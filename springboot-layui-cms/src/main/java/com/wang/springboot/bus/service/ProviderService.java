package com.wang.springboot.bus.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.springboot.bus.domain.Provider;

/**
 * <p>
 * InnoDB free: 9216 kB 服务类
 * </p>
 *
 * @author luoyi-
 * @since 2019-12-05
 */
public interface ProviderService extends IService<Provider> {

    /**
     * 根据供应商ID删除供应商
     * @param id
     */
    void deleteProviderById(Integer id);
}
