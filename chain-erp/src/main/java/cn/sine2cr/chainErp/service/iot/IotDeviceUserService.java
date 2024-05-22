package cn.sine2cr.chainErp.service.iot;

import cn.sine2cr.chainErp.datasource.entities.IotDeviceConfig;
import cn.sine2cr.chainErp.datasource.entities.IotDeviceUser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author sin
* @description 针对表【iot_device_user(用户与物联网设备信息表)】的数据库操作Service
* @createDate 2023-08-06 11:49:34
*/
public interface IotDeviceUserService extends IService<IotDeviceUser> {

    boolean addDevice(long id,String iotDeviceId) throws Exception;
    boolean removeDevice(String iotDeviceId);
    boolean updateDeviceId(String iotDeviceId);
    boolean updateOwner(String iotDeviceId);
    List<IotDeviceUser> listDevices(String loginName);
    IotDeviceConfig findDeviceById(String iotDeviceId);

}
