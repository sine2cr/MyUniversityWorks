package cn.sine2cr.chainErp.service.auth;

import cn.hutool.crypto.SecureUtil;
import cn.sine2cr.chainErp.datasource.entities.IotDeviceConfig;
import cn.sine2cr.chainErp.datasource.mappers.IotDeviceConfigMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author Sine2cr
 * @Date 2023/8/6
 * @Mail sine2cr@163.com
 **/
@Service
public class IotDeviceAuthService {


    @Resource
    private IotDeviceConfigMapper iotDriveConfigMapper;

    /**
     * 生成签名
     *
     * @param servletRequest
     * @return
     */
    public String sign(HttpServletRequest servletRequest) {
        String deviceId = servletRequest.getHeader("deviceId");
        String accessKey = servletRequest.getHeader("accessKey");
        IotDeviceConfig iotDeviceConfig = iotDriveConfigMapper.selectOne(new QueryWrapper<IotDeviceConfig>().eq("device_id", deviceId));
        System.out.println(iotDeviceConfig);
//        防重放攻击
//        String nonce = servletRequest.getHeader("nonce");
//        long timeStamp = Long.parseLong(servletRequest.getHeader("timeStamp"));
//        String data = getPostData(servletRequest);

        return  SecureUtil.md5(deviceId + accessKey + iotDeviceConfig.getSecretKey());

    }

    /**
     * 获取请求体
     * @param request
     * @return
     */
    private String getPostData(HttpServletRequest request) throws IOException {
        StringBuffer data = new StringBuffer();
        String line = null;
        BufferedReader reader = null;
        try {
            reader = request.getReader();
            while (null != (line = reader.readLine()))
                data.append(line);
        } catch (IOException e) {
            throw new IOException("获取请求体异常");
        }
        return data.toString();
    }

}
