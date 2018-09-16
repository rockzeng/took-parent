package com.tooklili.service.biz.intf.tooklili;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.List;

import com.taobao.api.ApiException;
import com.taobao.api.response.TbkDgItemCouponGetResponse.TbkCoupon;
import com.tooklili.model.taobao.AlimamaItem;
import com.tooklili.model.tooklili.Item;
import com.tooklili.util.result.BaseResult;
import com.tooklili.util.result.PlainResult;

/**
 * 操作商品(主要做CUD)
 * @author shuai.ding
 * @date 2017年10月25日上午11:30:17
 */
public interface ItemOperService {
	
	/**
	 * 插入或更新商品
	 * @author shuai.ding
	 * @param alimamaItem   超级搜索接口对应的实体
	 * @param itemCateId    商品插入数据库的分类id
	 * @return
	 * @throws UnsupportedEncodingException 
	 * @throws ParseException 
	 */
	 BaseResult insertOrUpdate(AlimamaItem alimamaItem,Integer itemCateId) throws UnsupportedEncodingException, ParseException;
	
	
	/**
	 * 插入或更新商品
	 * @param alimamaItems  超级搜索接口对应的实体集合
	 * @param itemCateId    商品插入数据库的分类id
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ParseException
	 */
	 PlainResult<String> insertOrUpdate(List<AlimamaItem> alimamaItems,Integer itemCateId) throws UnsupportedEncodingException, ParseException;
	
	
	 /**
	  * 插入或更新商品
	  * @param item        商品信息
	  * @param itemCateId  商品插入数据库的分类id
	  * @return
	  */
	 BaseResult insertOrUpdate(Item item,Integer itemCateId);
	
	
	/**
	 * 插入或更新商品
	 * @author shuai.ding
	 * @param tbkCoupon   淘宝客接口对应的实体
	 * @param itemCateId    商品插入数据库的分类id
	 * @return
	 * @throws ApiException 
	 * @throws ParseException 
	 */
	 BaseResult insertOrUpdate(TbkCoupon tbkCoupon,Integer itemCateId) throws ApiException, ParseException;
	
	/**
	 * 清除过期商品
	 * @author shuai.ding
	 * @return
	 */
	 BaseResult clearExpiredItems();

}
