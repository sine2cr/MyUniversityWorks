package cn.sine2cr.chainErp.filter;

import cn.sine2cr.chainErp.service.auth.IotDeviceAuthService;
import cn.sine2cr.chainErp.service.redis.RedisService;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LogCostFilter", urlPatterns = {"/*"},
        initParams = {@WebInitParam(name = "filterPath",
                value = "/chainErp/user/login#/chainErp/user/weixinLogin#/chainErp/user/weixinBind#" +
                        "/chainErp/user/registerUser#/chainErp/user/randomImage#" +
                        "/chainErp/platformConfig/getPlatform#/chainErp/v2/api-docs#/chainErp/webjars#" +
                        "/chainErp/systemConfig/static#/chainErp/api/plugin/wechat/weChat/share#/chainErp/swagger-resources#")})
public class LogCostFilter implements Filter {

    private static final String FILTER_PATH = "filterPath";

    private String[] allowUrls;
    @Resource
    private RedisService redisService;

    @Resource
    private IotDeviceAuthService iotDeviceAuthService;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String filterPath = filterConfig.getInitParameter(FILTER_PATH);
        if (!StringUtils.isEmpty(filterPath)) {
            allowUrls = filterPath.contains("#") ? filterPath.split("#") : new String[]{filterPath};
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        String requestUrl = servletRequest.getRequestURI();
        //具体，比如：处理若用户未登录，则跳转到登录页
        Object userId = redisService.getObjectFromSessionByKey(servletRequest, "userId");
        String deviceId = servletRequest.getHeader("deviceId");
        if (deviceId != null) {
            String serverSign = iotDeviceAuthService.sign(servletRequest);
            String sign = servletRequest.getHeader("sign");
            if (serverSign.equals(sign)){
                chain.doFilter(request,response);
                return;
            }
            servletResponse.setStatus(300);
            servletResponse.getWriter().write("fail");
            return;
        }

        if (userId != null) { //如果已登录，不阻止
            chain.doFilter(request, response);
            return;
        }
        if (requestUrl != null && (requestUrl.contains("/doc.html") ||
                requestUrl.contains("/user/login") || requestUrl.contains("/user/register"))) {
            chain.doFilter(request, response);
            return;
        }
        if (null != allowUrls && allowUrls.length > 0) {
            for (String url : allowUrls) {
                if (requestUrl.startsWith(url)) {
                    chain.doFilter(request, response);
                    return;
                }
            }
        }
        servletResponse.setStatus(500);
        if (requestUrl != null && !requestUrl.contains("/user/logout") && !requestUrl.contains("/function/findMenuByPNumber")) {
            servletResponse.getWriter().write("loginOut");
        }
    }

    @Override
    public void destroy() {

    }
}
