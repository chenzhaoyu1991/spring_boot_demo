package com.livibank.springboot.spring_boot_demo.controller;

import com.livibank.springboot.spring_boot_demo.InjectValue;
import com.livibank.springboot.spring_boot_demo.Permission;
import com.livibank.springboot.spring_boot_demo.Type;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenzhaoyu
 * @date 2022/1/21  -  23:08
 **/
@RestController
@RequestMapping(value = "/index")
public class IndexController {
    @RequestMapping(value = "/test")
    @Permission(value = "root")
    public String index(@InjectValue(propert = Type.custNo) String custNo, String account, String ipone) {
        System.out.println("accountNo:" + custNo);
        return custNo;
    }

    @RequestMapping(value = "/{custNo}")
    public String testPath(@PathVariable("custNo") String custNo) {
        System.out.println("custNo: " + custNo);
        return custNo;
    }
}
