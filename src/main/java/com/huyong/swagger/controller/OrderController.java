package com.huyong.swagger.controller;

import com.huyong.swagger.entity.CommonResult;
import com.huyong.swagger.entity.Goods;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Map;

/**
 * @author markhuyong
 * @version 1.0
 * @date 2021/5/7
 **/
@Api(tags = "订单管理接口")
@RestController
@RequestMapping("/order")
public class OrderController {

	@Operation(summary = "提交订单 -- 参数为 `Map`")
	@PostMapping("/map/order")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "userId", value = "用户id", dataTypeClass = Long.class, paramType = "query",
					example = "123"),
			@ApiImplicitParam(name = "goodsId", value = "商品id", dataTypeClass = Integer.class, paramType = "query",
					example = "1") })
	public CommonResult<String> toBuyMap(@ApiIgnore @RequestParam Map<String, String> params) {
		System.out.println(params);
		return CommonResult.success("success");
	}

	@Operation(summary = "提交订单 -- 参数为 Object")
	@PostMapping("/object/order")
	public CommonResult<String> toBuyObject(@RequestBody Goods goods) {
		System.out.println(goods);
		return CommonResult.success("success");
	}

}
