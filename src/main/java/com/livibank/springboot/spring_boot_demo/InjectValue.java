package com.livibank.springboot.spring_boot_demo;

import java.lang.annotation.*;

/**
 * @author chenzhaoyu
 * @date 2022/1/21  -  23:48
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface InjectValue {
    Type  propert();
}
