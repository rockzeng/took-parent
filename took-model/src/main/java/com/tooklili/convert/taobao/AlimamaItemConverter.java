package com.tooklili.convert.taobao;

import com.tooklili.model.taobao.AlimamaItem;
import com.tooklili.model.tooklili.Item;
import com.tooklili.util.Arith;

/**
 * 
 * @author ding.shuai
 * @date 2018年3月26日下午5:17:59
 */
public class AlimamaItemConverter {
	
	public static Item alimamaItemConverItem(AlimamaItem alimamaItem) {
		if(alimamaItem == null) {
			return null;
		}
		Item item = new Item();
		item.setNumIid(alimamaItem.getAuctionId());
		item.setTitle(alimamaItem.getTitle());
		item.setPicUrl(alimamaItem.getPictUrl());
		//现价
		item.setPrice(alimamaItem.getZkPrice());
		//折扣价
		double couponPrice = Arith.sub(Double.valueOf(alimamaItem.getZkPrice()),Double.valueOf(alimamaItem.getCouponAmount()));
		item.setCouponPrice(String.valueOf(couponPrice));
		
		item.setQuan(String.valueOf(alimamaItem.getCouponAmount()));
		item.setQuanSurplus(alimamaItem.getCouponTotalCount());
		item.setQuanReceive(alimamaItem.getCouponLeftCount());
		item.setVolume(String.valueOf(alimamaItem.getBiz30day()));
		item.setCouponStartTime(alimamaItem.getCouponEffectiveStartTime());
		item.setCouponEndTime(alimamaItem.getCouponEffectiveEndTime());
		if(alimamaItem.getUserType() == 0) {
			item.setShopType("C");
		}else if(alimamaItem.getUserType() == 1) {
			item.setShopType("B");
		}
				
		return item;
	}

}
