package cn.sine2cr.chainErp.service.serialNumber;

import cn.sine2cr.chainErp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * Description
 *
 * @Author: jishenghua
 * @Date: 2019/1/21 16:33
 */
@ResourceInfo(value = "serialNumber")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialNumberResource {
}
