package com.tulingxueyuan.order.dao2;

import com.tulingxueyuan.order.model.Order;
import com.tulingxueyuan.order.model.Stock;

import java.util.List;

public interface StockMapper {
    public List<Stock> getStocks();
}
