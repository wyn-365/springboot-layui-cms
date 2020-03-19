package com.wang.springboot.bus.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.springboot.bus.domain.Customer;

/**
 * <p>
 * InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author luoyi-
 * @since 2019-12-05
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 根据客户id删除客户
     * @param id    客户id
     */
    void deleteCustomerById(Integer id);
}
