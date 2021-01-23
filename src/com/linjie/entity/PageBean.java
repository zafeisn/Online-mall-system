package com.linjie.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * 当前页 currentPage
 * 总记录数 totalCount
 * 总页数 totalPage
 * 当前页的商品 listGoods
 * 
 * @author LinJie
 */

@Setter@Getter
public class PageBean {

	private Integer currentPage;
	private Integer totalPage;
	private Integer totalCount;
	private List<Goods> listGoods = new ArrayList<>();
}
