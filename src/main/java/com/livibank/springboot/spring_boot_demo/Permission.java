package com.livibank.springboot.spring_boot_demo;

import java.lang.annotation.*;

/**
 * @author chenzhaoyu
 * @date 2022/1/21  -  23:16
 **/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Permission {
    String value();
}
