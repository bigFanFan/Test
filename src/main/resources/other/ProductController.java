package com.lxs.code.controller.product;

import com.sgsl.app.config.ApplicationConfiguration;
import com.sgsl.app.domain.PagerResultObject;
import com.sgsl.app.util.RestTemplateHelper;
import com.sgsl.foodsee.common.wrapper.ArrayObject;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import org.springframework.web.client.Exception;

@Slf4j
@Controller
@RequestMapping("/app/product")
@ApiModel("商品信息")
public class ProductController implements BaseObject {

    private String requestUrl = "%s/product";

    @Value("${sgsl.version.number.productcenter}")
    private String version;

    private ApplicationConfiguration config;

    @Autowired
    public ProductController(ApplicationConfiguration config) {
        requestUrl = String.format(requestUrl, config.getApiGatewayServerBasecenterUrl());
        this.config = config;
    }

    @ApiOperation(value = "商品信息列表显示")
    @GetMapping("/page")
    public String page(Map<String, Object> model) {

        return "/productManage/productList";
    }

    @ApiOperation(value = "后台管理--商品信息分页列表", notes = "后台管理--商品信息分页列表")
    @PostMapping("/grid")
    @ResponseBody
    public PagerResultObject<Product> grid(Product product) {

        return  RestTemplateHelper.builder().url(requestUrl.concat("/page/query")).version(version).build()
                        .exchange(HttpMethod.GET, new ParameterizedTypeReference<PagerResultObject<Product>>() {
                        }, product);

    }

    @ApiOperation(value = "后台管理--商品信息详情", notes = "后台管理--商品信息详情")
    @GetMapping("/detail")
    @ResponseBody
    public Product detail(@RequestParam String id) {

        return RestTemplateHelper.builder().url(requestUrl.concat("/{id}")).version(version).build()
                .exchange(HttpMethod.GET, Product.class, id);
    }

    @ApiOperation(value = "后台管理--新增或者修改商品信息", notes = "后台管理--新增或者修改商品信息")
    @PostMapping("/modify")
    @ResponseBody
    public Map<String, Object> modify(@RequestBody Product product) {
        Map<String, Object> result = new HashMap<>();

        Long id = product.getId();
        try {
            if (null != id) {
                RestTemplateHelper.builder().url(requestUrl.concat("/update/").concat(id.toString())).version(version).build().exchangeBody(HttpMethod.PUT,
                        Object.class, product);
            } else {
                RestTemplateHelper.builder().url(requestUrl.concat("/create")).version(version).build().exchangeBody(HttpMethod.POST,
                        Object.class, product);

            }
            result.put(SUCCESS, true);
            result.put(MESSAGE, "操作成功");
        } catch (Exception e) {
            result.put(SUCCESS, false);
            result.put(MESSAGE, "操作失败");
            log.error(e.getMessage());
        }
        return result;
    }

    @ApiOperation(value = "后台管理--批量删除商品信息", notes = "后台管理--批量删除商品信息")
    @GetMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(value = "ids") String ids) {
        Map<String, Object> result = new HashMap<>();
        try {
            RestTemplateHelper.builder().url(requestUrl.concat("/{ids}")).version(version).build()
                    .exchange(HttpMethod.DELETE, Integer.class, ids);

            result.put(SUCCESS, true);
            result.put(MESSAGE, "操作成功");
        } catch (Exception e) {
            result.put(SUCCESS, false);
            result.put(MESSAGE, "操作失败");
            log.error(e.getMessage());
        }
        return result;
    }

}
