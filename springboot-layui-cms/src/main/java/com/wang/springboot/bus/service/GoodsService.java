package com.wang.springboot.bus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wang.springboot.bus.domain.Goods;

/**
 * <p>
 * InnoDB free: 9216 kB; (`providerid`) REFER `warehouse/bus_provider`(`id`) 服务类
 * </p>
 *
 * @author luoyi-
 * @since 2019-12-06
 */
public interface GoodsService extends IService<Goods> {

    /**
     * 根据商品id删除商品
     * @param id
     */
    void deleteGoodsById(Integer id);
}
