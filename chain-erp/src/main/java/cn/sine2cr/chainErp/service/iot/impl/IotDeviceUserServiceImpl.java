package cn.sine2cr.chainErp.service.iot.impl;

import cn.sine2cr.chainErp.datasource.entities.IotDeviceConfig;
import cn.sine2cr.chainErp.datasource.entities.IotDeviceUser;
import cn.sine2cr.chainErp.datasource.entities.User;
import cn.sine2cr.chainErp.datasource.mappers.UserMapper;
import cn.sine2cr.chainErp.exception.JshException;
import cn.sine2cr.chainErp.service.iot.IotDeviceUserService;
import cn.sine2cr.chainErp.service.user.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.sine2cr.chainErp.datasource.mappers.IotDeviceUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author sin
 * @description 针对表【iot_device_user(用户与物联网设备信息表)】的数据库操作Service实现
 * @createDate 2023-08-06 11:49:34
 */
@Service
public class IotDeviceUserServiceImpl extends ServiceImpl<IotDeviceUserMapper, IotDeviceUser>
        implements IotDeviceUserService {
    @Resource
    private UserService userService;
    @Resource
    private IotDeviceUserMapper iotDeviceUserMapper;
    private Logger logger = LoggerFactory.getLogger(IotDeviceUserService.class);

    @Override
    public boolean addDevice(long id, String iotDeviceId) throws Exception {
        String loginName = userService.getUser(id).getLoginName();
        IotDeviceUser iotDeviceUser = new IotDeviceUser();
        iotDeviceUser.setDeviceId(iotDeviceId);
        iotDeviceUser.setLoginName(loginName);
        int res = 0;
        try {
            res = iotDeviceUserMapper.insert(iotDeviceUser);
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }

        return res > 0;
    }

    @Override
    public boolean removeDevice(String iotDeviceId) {
        return false;
    }

    @Override
    public boolean updateDeviceId(String iotDeviceId) {
        return false;
    }

    @Override
    public boolean updateOwner(String iotDeviceId) {
        return false;
    }

    @Override
    public List<IotDeviceUser> listDevices(String loginName) {
        List<IotDeviceUser> devices = null;
        try {
            devices = iotDeviceUserMapper.selectList(
                    new QueryWrapper<IotDeviceUser>().eq("login_name", loginName));
        } catch (Exception e) {
            JshException.readFail(logger, e);
        }
        return devices;
    }

    @Override
    public IotDeviceConfig findDeviceById(String iotDeviceId) {
        return null;
    }
}




