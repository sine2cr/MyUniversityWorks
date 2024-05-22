package cn.sine2cr.chainErp.service.organization;

import cn.sine2cr.chainErp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * Description
 *  机构
 * @Author: cjl
 * @Date: 2019/3/6 15:10
 */
@ResourceInfo(value = "organization")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrganizationResource {
}
