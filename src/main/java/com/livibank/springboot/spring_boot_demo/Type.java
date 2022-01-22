package com.livibank.springboot.spring_boot_demo;

/**
 * @author chenzhaoyu
 * @date 2022/1/22  -  0:41
 **/
public enum Type {
    custNo("custNo"),
    ipone("ipone"),
    addre("addre");

   private String name;

    Type(String name) {
        this.name = name;
    }
}
