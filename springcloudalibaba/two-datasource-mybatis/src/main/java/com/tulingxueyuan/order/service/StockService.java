package com.tulingxueyuan.order.service;

import com.tulingxueyuan.order.dao2.StockMapper;
import com.tulingxueyuan.order.model.Stock;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional("transactionManeger2")
public class StockService {
    @Autowired
    @Qualifier("sqlSessionFactory2")
    private SqlSessionFactory sqlSessionFactory;

    public List<Stock> getStocks(){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            StockMapper stockMapper = sqlSession.getMapper(StockMapper.class);
            List<Stock> stocks = stockMapper.getStocks();
            return stocks;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return null;
    }
}
