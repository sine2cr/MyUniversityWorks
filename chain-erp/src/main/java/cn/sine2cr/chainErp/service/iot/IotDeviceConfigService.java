package cn.sine2cr.chainErp.service.iot;

import cn.sine2cr.chainErp.datasource.entities.IotDeviceConfig;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author sin
* @description 针对表【iot_device_config】的数据库操作Service
* @createDate 2023-08-06 11:49:34
*/
public interface IotDeviceConfigService extends IService<IotDeviceConfig> {


    boolean removeDevice(String iotDeviceId);
    boolean updateDeviceAccessKey(String iotDeviceId);
    boolean updateDeviceSecretKey(String iotDeviceId);



}
