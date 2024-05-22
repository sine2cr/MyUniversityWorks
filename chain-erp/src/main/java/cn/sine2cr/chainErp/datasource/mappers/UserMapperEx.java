package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.User;
import cn.sine2cr.chainErp.datasource.entities.UserEx;
import cn.sine2cr.chainErp.datasource.vo.TreeNodeEx;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapperEx {

    List<UserEx> selectByConditionUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByUser(
            @Param("userName") String userName,
            @Param("loginName") String loginName);

    List<User> getUserListByUserNameOrLoginName(@Param("userName") String userName,
                                                @Param("loginName") String loginName);

    int batDeleteOrUpdateUser(@Param("ids") String ids[], @Param("status") byte status);

    List<TreeNodeEx> getNodeTree();
    List<TreeNodeEx> getNextNodeTree(Map<String, Object> parameterMap);

    void disableUserByLimit(@Param("tenantId") Long tenantId);

    List<User> getListByOrgaId(
            @Param("id") Long id,
            @Param("orgaId") Long orgaId);

    User getUserByWeixinOpenId(
            @Param("weixinOpenId") String weixinOpenId);

    int updateUserWithWeixinOpenId(
            @Param("loginName") String loginName,
            @Param("password") String password,
            @Param("weixinOpenId") String weixinOpenId);
}
