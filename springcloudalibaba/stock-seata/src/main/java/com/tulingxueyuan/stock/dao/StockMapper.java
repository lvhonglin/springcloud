package com.tulingxueyuan.stock.dao;

import org.apache.ibatis.annotations.Param;

public interface StockMapper {
    public void reduct(@Param("productId") int productId);

}
