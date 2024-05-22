package cn.sine2cr.chainErp.service.iot;


import cn.sine2cr.chainErp.datasource.entities.IotDeviceData;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author sin
* @description 针对表【iot_device_data(iot设备数据)】的数据库操作Service
* @createDate 2023-08-06 11:49:34
*/
public interface IotDeviceDataService extends IService<IotDeviceData> {

    Boolean uploadData( IotDeviceData iotDeviceData);

}
