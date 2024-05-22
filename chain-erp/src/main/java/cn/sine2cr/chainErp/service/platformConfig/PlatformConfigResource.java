package cn.sine2cr.chainErp.service.platformConfig;

import cn.sine2cr.chainErp.service.ResourceInfo;

import java.lang.annotation.*;

/**
 * @author jishenghua qq752718920  2020-10-16 22:26:27
 */
@ResourceInfo(value = "platformConfig")
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PlatformConfigResource {
}
