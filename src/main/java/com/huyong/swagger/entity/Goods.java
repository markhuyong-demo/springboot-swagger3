package com.huyong.swagger.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @author markhuyong
 * @version 1.0
 * @date 2021/5/7
 **/
@ApiModel("商品模型")
public class Goods {

	/**
	 * 商品id
	 */
	@ApiModelProperty(value = "商品ID", required = true)
	Long goodsId;

	/**
	 * 商品名称
	 */
	@ApiModelProperty("商品名称")
	private String goodsName;

	/**
	 * 商品价格
	 */
	@ApiModelProperty(value = "商品价格", hidden = true)
	private BigDecimal price;

	public Long getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

}
