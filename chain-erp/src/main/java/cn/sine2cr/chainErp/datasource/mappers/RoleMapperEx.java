package cn.sine2cr.chainErp.datasource.mappers;

import cn.sine2cr.chainErp.datasource.entities.Role;
import cn.sine2cr.chainErp.datasource.entities.RoleEx;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface RoleMapperEx {

    List<RoleEx> selectByConditionRole(
            @Param("name") String name,
            @Param("description") String description,
            @Param("offset") Integer offset,
            @Param("rows") Integer rows);

    Long countsByRole(
            @Param("name") String name,
            @Param("description") String description);

    int batchDeleteRoleByIds(@Param("updateTime") Date updateTime, @Param("updater") Long updater, @Param("ids") String ids[]);

    Role getRoleWithoutTenant(
            @Param("roleId") Long roleId);
}
