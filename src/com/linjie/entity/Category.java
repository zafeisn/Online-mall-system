package com.linjie.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * 商品分类，用于在页面新增商品或编辑商品时获取
 * @author LinJie
 *
 */
@Setter@Getter
public class Category {

	public Integer cid;
	public String cname;
	
	@Override
	public String toString() {
		return "Category [cid=" + cid + ", cname=" + cname + "]";
	}

}
