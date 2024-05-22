package cn.sine2cr.chainErp.service.iot.impl;


import cn.sine2cr.chainErp.datasource.entities.IotDeviceData;
import cn.sine2cr.chainErp.service.iot.IotDeviceDataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.sine2cr.chainErp.datasource.mappers.IotDeviceDataMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sin
 * @description 针对表【iot_device_data(iot设备数据)】的数据库操作Service实现
 * @createDate 2023-08-06 11:49:34
 */
@Service
public class IotDeviceDataServiceImpl extends ServiceImpl<IotDeviceDataMapper, IotDeviceData>
        implements IotDeviceDataService {


    @Resource
    private IotDeviceDataMapper iotDeviceDataMapper;

    @Override
    public Boolean uploadData(IotDeviceData iotDeviceData) {

        return iotDeviceDataMapper.insert(iotDeviceData) > 0;
    }
}




