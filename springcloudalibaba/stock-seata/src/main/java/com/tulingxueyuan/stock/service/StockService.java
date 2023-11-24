package com.tulingxueyuan.stock.service;

import com.tulingxueyuan.stock.dao.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockService {
    @Autowired
    StockMapper stockMapper;
    public void reduct(Integer productId){
        System.out.println("更新商品:"+productId);
        stockMapper.reduct(productId);
    }
}
