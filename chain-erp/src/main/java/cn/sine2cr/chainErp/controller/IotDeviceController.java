package cn.sine2cr.chainErp.controller;

import cn.hutool.core.bean.BeanUtil;

import cn.sine2cr.chainErp.datasource.entities.IotDeviceConfig;
import cn.sine2cr.chainErp.datasource.entities.IotDeviceData;
import cn.sine2cr.chainErp.datasource.entities.IotDeviceUser;
import cn.sine2cr.chainErp.datasource.vo.InsertDeviceVO;
import cn.sine2cr.chainErp.datasource.vo.UploadDeviceDataVo;
import cn.sine2cr.chainErp.service.iot.IotDeviceConfigService;
import cn.sine2cr.chainErp.service.iot.IotDeviceDataService;
import cn.sine2cr.chainErp.service.iot.IotDeviceUserService;
import cn.sine2cr.chainErp.service.redis.RedisService;
import cn.sine2cr.chainErp.service.user.UserService;
import cn.sine2cr.chainErp.utils.BaseResponseInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import static cn.sine2cr.chainErp.constants.ExceptionConstants.*;

/**
 * @author Sine2cr
 * @Date 2023/8/6
 * @Mail sine2cr@163.com
 **/
@RestController
@RequestMapping("/iot")
@Api(tags = {"物联网设备接口"})
public class IotDeviceController {
    @Resource
    private IotDeviceDataService iotDeviceDataService;
    @Resource
    private IotDeviceUserService iotDeviceUserService;
    @Resource
    private IotDeviceConfigService iotDeviceConfigService;

    @Resource
    private UserService userService;

    @Resource
    private RedisService redisService;

    /**
     * 上传物联网设备监控数据
     *
     * @param uploadDeviceDataVo
     * @param request
     * @return
     */
    @PostMapping("/up")
    @ApiOperation(value = "上传数据")
    public BaseResponseInfo upLoadData(UploadDeviceDataVo uploadDeviceDataVo, HttpServletRequest request) {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            IotDeviceData iotDeviceData = new IotDeviceData();
            BeanUtil.copyProperties(uploadDeviceDataVo, iotDeviceData);
            iotDeviceData.setDeviceId(request.getHeader("deviceId"));
            Boolean data = iotDeviceDataService.uploadData(iotDeviceData);
            res.code=SERVICE_SUCCESS_CODE;
            res.data=data;
        }catch (Exception e){
            res.code=DATA_READ_FAIL_CODE;
        }
        return res;
    }
    @PostMapping("/insert/{deviceId}")
    @ApiOperation(value = "添加IOT设备")
    public BaseResponseInfo insertDevice(@PathVariable String deviceId, InsertDeviceVO insertDeviceVO, HttpServletRequest request){
        BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
        Long userId = Long.parseLong(redisService.getObjectFromSessionByKey(request,"userId").toString());
        try {
            boolean res1 = iotDeviceUserService.addDevice(userId, deviceId);
            IotDeviceConfig iotDeviceConfig = new IotDeviceConfig();
            BeanUtil.copyProperties(insertDeviceVO,iotDeviceConfig);
            boolean res2 = iotDeviceConfigService.save(iotDeviceConfig);
            baseResponseInfo.code=SERVICE_SUCCESS_CODE;
            baseResponseInfo.data=(res1&&res2);
        } catch (Exception e) {
            e.printStackTrace();
            baseResponseInfo.code=DATA_READ_FAIL_CODE;
            baseResponseInfo.data=DATA_READ_FAIL_MSG;
        }
        return baseResponseInfo;
    }
    @PostMapping("/update/{deviceId}")
    @ApiOperation(value = "修改IOT设备信息")
    public BaseResponseInfo updateDeviceConfig(@PathVariable String deviceId, InsertDeviceVO insertDeviceVO, HttpServletRequest request){
        BaseResponseInfo baseResponseInfo = new BaseResponseInfo();
        try {
            IotDeviceConfig iotDeviceConfig = new IotDeviceConfig();
            BeanUtil.copyProperties(insertDeviceVO,iotDeviceConfig);
            boolean res = iotDeviceConfigService.update(iotDeviceConfig, new UpdateWrapper<IotDeviceConfig>().eq("device_id", deviceId));
            baseResponseInfo.code=SERVICE_SUCCESS_CODE;
            baseResponseInfo.data=res;
        } catch (Exception e) {
            e.printStackTrace();
            baseResponseInfo.code=DATA_READ_FAIL_CODE;
            baseResponseInfo.data=DATA_READ_FAIL_MSG;
        }
        return baseResponseInfo;
    }
}
