/*
 * Copyright 2012 dxp.alibaba-inc.com All right reserved. This software is the
 * confidential and proprietary information of dxp.alibaba-inc.com ("Confidential
 * Information"). You shall not disclose such Confidential Information and shall
 * use it only in accordance with the terms of the license agreement you entered
 * into with dxp.alibaba-inc.com.
 */
package com.taobao.hessian.domain;

import java.math.BigDecimal;

/**
 * 类Pojo.java的实现描述：TODO 类实现描述 
 * @author ethon.chenf 2012-12-24 下午5:02:55
 */
public class Pojo {

    private int age;
    
    private String name;
    
    private BigDecimal salar;

    
    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    
    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    
    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    
    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * @return the salar
     */
    public BigDecimal getSalar() {
        return salar;
    }

    
    /**
     * @param salar the salar to set
     */
    public void setSalar(BigDecimal salar) {
        this.salar = salar;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Pojo [age=" + age + ", name=" + name + ", salar=" + salar + "]";
    }

}
