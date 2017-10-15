package com.tooklili.app.web.controller.tooklili;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tooklili.model.tooklili.Item;
import com.tooklili.service.biz.intf.tooklili.ItemService;
import com.tooklili.util.result.PageResult;
import com.tooklili.util.result.PlainResult;

/**
 * tooklili控制器
 * @author ding.shuai
 * @date 2017年9月16日上午11:36:21
 */
@Controller
public class ItemController {	
	
	@Resource
	private ItemService itemService;
	
	@RequestMapping("/couponItems")
	@ResponseBody
	public PageResult<Item> queryCouponItemsByCateId(Integer cateId,Long currentPage,Long pageSize){
		return itemService.queryCouponItemsByCateId(cateId, currentPage, pageSize);
	}
	
	@RequestMapping("/getitem/{id}")
	@ResponseBody
	public PlainResult<Item> queryItemById(@PathVariable Long id){
		return itemService.queryItemById(id);
	}

}