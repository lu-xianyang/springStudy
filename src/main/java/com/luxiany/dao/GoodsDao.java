package com.luxiany.dao;

import com.luxiany.domain.Goods;

public interface GoodsDao {
   int updateGoods(Goods goods);
   Goods selectGood(Integer id);

}
