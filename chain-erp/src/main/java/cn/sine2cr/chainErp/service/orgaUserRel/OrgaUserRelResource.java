package cn.sine2cr.chainErp.service.orgaUserRel;

import cn.sine2cr.chainErp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * Description
 *  机构用户关系
 * @Author: cjl
 * @Date: 2019/3/11 18:11
 */
@ResourceInfo(value = "orgaUserRel")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrgaUserRelResource {

}
