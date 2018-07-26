package ${package_name}.controller.${table_name_first_low};

import com.sgsl.app.config.ApplicationConfiguration;
import com.sgsl.app.domain.PagerResultObject;
import com.sgsl.app.util.BaseResult;
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

@Slf4j
@Controller
@RequestMapping("/app/${table_name_first_low}")
@ApiModel("${table_annotation}")
public class ${table_name}Controller {

    private String requestUrl = "%s/${table_name_small?replace("_","/")}";

    @Value("${r'${'}sgsl.version.number.${table_name_first_low}center${r'}'}")
    private String version;

    private ApplicationConfiguration config;

    @Autowired
    public ${table_name}Controller(ApplicationConfiguration config) {
        requestUrl = String.format(requestUrl, config.getApiGatewayServerBasecenterUrl());
        this.config = config;
    }

    @ApiOperation(value = "${table_annotation}列表显示")
    @GetMapping("/page")
    public String page(Map<String, Object> model) {

        return "/${table_name_first_low}Manage/${table_name_first_low}List";
    }

    @ApiOperation(value = "后台管理--${table_annotation}分页列表", notes = "后台管理--${table_annotation}分页列表")
    @PostMapping("/grid")
    @ResponseBody
    public PagerResultObject grid(${table_name} ${table_name_first_low}) {
        PagerResultObject pagerResult = null;
         try {
                pagerResult =  RestTemplateHelper.builder().url(requestUrl.concat("/page/query")).version(version).build()
                        .exchangeUrl(HttpMethod.GET, new ParameterizedTypeReference<PagerResultObject<${table_name}>>() {
                        }, ${table_name_first_low});

        } catch (RestClientException e) {
            log.error(e.getMessage());
        }
        return pagerResult;
    }

    @ApiOperation(value = "后台管理--${table_annotation}详情", notes = "后台管理--${table_annotation}详情")
    @GetMapping("/detail")
    @ResponseBody
    public BaseResult<${table_name}> detail(@RequestParam String id) {
        ${table_name}  ${table_name_first_low} = null;
        try {
                ${table_name_first_low} = RestTemplateHelper.builder().url(requestUrl.concat("/{id}")).version(version).build()
                    .exchangePath(HttpMethod.GET, ${table_name}.class, id);

        } catch (RestClientException e) {
            log.error(e.getMessage());
            return BaseResult.badRequest().msg("查询失败");
        }

        return BaseResult.ok(${table_name_first_low});
    }

    @ApiOperation(value = "后台管理--新增或者修改${table_annotation}", notes = "后台管理--新增或者修改${table_annotation}")
    @PostMapping("/modify")
    @ResponseBody
    public BaseResult modify(@RequestBody ${table_name} ${table_name_first_low}) {

        Long id = ${table_name_first_low}.getId();
        try {
            if (null != id) {
                RestTemplateHelper.builder().url(requestUrl.concat("/update/").concat(id.toString())).version(version).build().exchangeBody(HttpMethod.PUT,
                        Object.class, ${table_name_first_low});
            } else {
                RestTemplateHelper.builder().url(requestUrl.concat("/create")).version(version).build().exchangeBody(HttpMethod.POST,
                        Object.class, ${table_name_first_low});

            }

        } catch (Exception e) {
            log.error(e.getMessage());
            return BaseResult.badRequest();
        }
        return BaseResult.ok();
    }

    @ApiOperation(value = "后台管理--批量删除${table_annotation}", notes = "后台管理--批量删除${table_annotation}")
    @GetMapping("/delete")
    @ResponseBody
    public BaseResult delete(@RequestParam(value = "ids") String ids) {
        try {
            RestTemplateHelper.builder().url(requestUrl.concat("/{ids}")).version(version).build()
                    .exchangePath(HttpMethod.DELETE, Integer.class, ids);

        } catch (Exception e) {
            log.error(e.getMessage());
            return BaseResult.badRequest();
        }
         return BaseResult.ok();
    }

}
