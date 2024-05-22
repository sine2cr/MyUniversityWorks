package cn.sine2cr.chainErp.service.iot.impl;

import cn.sine2cr.chainErp.datasource.entities.IotDeviceConfig;
import cn.sine2cr.chainErp.service.iot.IotDeviceConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.sine2cr.chainErp.datasource.mappers.IotDeviceConfigMapper;
import org.springframework.stereotype.Service;

/**
* @author sin
* @description 针对表【iot_device_config】的数据库操作Service实现
* @createDate 2023-08-06 11:49:34
*/
@Service
public class IotDeviceConfigServiceImpl extends ServiceImpl<IotDeviceConfigMapper, IotDeviceConfig>
    implements IotDeviceConfigService {


    @Override
    public boolean removeDevice(String iotDeviceId) {
        return false;
    }

    @Override
    public boolean updateDeviceAccessKey(String iotDeviceId) {
        return false;
    }

    @Override
    public boolean updateDeviceSecretKey(String iotDeviceId) {
        return false;
    }


}




