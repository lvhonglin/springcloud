package com.tulingxueyuan.order.service;

import com.tulingxueyuan.order.dao.OrderMapper;
import com.tulingxueyuan.order.dao2.StockMapper;
import com.tulingxueyuan.order.model.Order;
import com.tulingxueyuan.order.model.Stock;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    @Qualifier("sqlSessionFactory")
    private SqlSessionFactory sqlSessionFactory;
    public int create(Order order){
//        int id = orderMapper.insert(order);
        return 0;
    }
    public List<Order> getOrders(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
            List<Order> orders = orderMapper.getOrders();
            return orders;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }
}
