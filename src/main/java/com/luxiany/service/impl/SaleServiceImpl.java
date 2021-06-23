package com.luxiany.service.impl;

import com.luxiany.Expection.NotEnoughException;
import com.luxiany.dao.GoodsDao;
import com.luxiany.dao.SaleDao;
import com.luxiany.domain.Goods;
import com.luxiany.domain.Sale;
import com.luxiany.service.SaleService;
import org.springframework.stereotype.Service;


public class SaleServiceImpl implements SaleService {
    private SaleDao saleDao;
    private GoodsDao goodsDao;

    public void setGoodsDao(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao) {
        this.saleDao = saleDao;
    }

    @Override
    public void buy(Integer goodsId, Integer nums) {
        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(nums);
        saleDao.insertSale(sale);

        Goods goods = goodsDao.selectGood(goodsId);
        if (goods==null){
            throw new NullPointerException("编号为："+goodsId+"商品不存在");
        }else if(goods.getAmount()<nums){
          throw new NotEnoughException("编号为："+goodsId+"商品不足");
        }
        Goods buyGoos = new Goods();
        buyGoos.setId(goodsId);
        buyGoos.setAmount(nums);
        goodsDao.updateGoods(buyGoos);

    }
}
