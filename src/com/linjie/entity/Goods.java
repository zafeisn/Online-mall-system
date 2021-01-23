package com.linjie.entity;

import lombok.Getter;
import lombok.Setter;

/*
 * 商品实体类
 */
@Setter@Getter
public class Goods {

	private Integer gid;
	private String gname;
	private Double gprice;
	private String gimage;
	private String gdesc;
	private Integer gis_hot;
	private Integer cid;
	
	@Override
	public String toString() {
		return "Goods [gid=" + gid + ", gname=" + gname + ", gprice=" + gprice + ", gimage=" + gimage + ", gdesc="
				+ gdesc + ", gis_hot=" + gis_hot + ", cid=" + cid + "]";
	}
	
}
