package com.huyong.swagger.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.schema.ScalarType;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;
import java.util.List;

/**
 * @author markhuyong
 * @version 1.0
 * @date 2021/5/7
 **/
@EnableKnife4j
@Configuration
@EnableOpenApi
public class Swagger3Config {

	@Bean
	public Docket createRestApi() {
		// 返回文档摘要信息
		return new Docket(DocumentationType.OAS_30).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(Operation.class)).paths(PathSelectors.any()).build()
				.globalRequestParameters(getGlobalRequestParameters())
				.globalResponses(HttpMethod.GET, getGlobalResponseMessage())
				.globalResponses(HttpMethod.POST, getGlobalResponseMessage());
	}

	/**
	 * 生成接口信息，包括标题、联系人等
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Swagger3接口文档").description("如有疑问, 联系作者")
				.contact(new Contact("二师兄", "markhuyong.github.io", "markhuyong@gmail.com")).version("1.0").build();
	}

	/**
	 * 封装全局通用参数
	 */
	private List<RequestParameter> getGlobalRequestParameters() {
		List<RequestParameter> parameters = new ArrayList<>();
		parameters.add(
				new RequestParameterBuilder().name("uuid").description("设备uuid").required(true).in(ParameterType.QUERY)
						.query(q -> q.model(m -> m.scalarModel(ScalarType.STRING))).required(false).build());
		return parameters;
	}

	/**
	 * 封装通用响应信息
	 */
	private List<Response> getGlobalResponseMessage() {
		List<Response> responseList = new ArrayList<>();
		responseList.add(new ResponseBuilder().code("404").description("未找到资源").build());
		return responseList;
	}

}
