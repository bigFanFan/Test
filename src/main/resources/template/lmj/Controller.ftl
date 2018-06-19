package ${package_name}.controller.${table_name_first_low};

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
@RequestMapping("/app/${table_name_first_low}")
@ApiModel("${table_annotation}")
public class ${table_name}Controller implements BaseObject {

    private static String REQUEST_URL = "%s/${table_name_small?replace("_","/")}";

    @Value("${r'${'}sgsl.version.number.${table_name_first_low}center${r'}'}")
    private String version;

    @Autowired
    public ${table_name}Controller(ApplicationConfiguration config) {
        REQUEST_URL = String.format(REQUEST_URL, config.getApiGatewayServerBasecenterUrl());
    }

    @ApiOperation(value = "${table_annotation}列表显示")
    @GetMapping("/page")
    public String page(Map<String, Object> model) {

        return "/${table_name_first_low}Manage/${table_name_first_low}List";
    }

    @ApiOperation(value = "后台管理--${table_annotation}分页列表", notes = "后台管理--${table_annotation}分页列表")
    @PostMapping("/grid")
    @ResponseBody
    public PagerResultObject<${table_name}> grid(${table_name} ${table_name_first_low}) {

        return  RestTemplateHelper.builder().url(REQUEST_URL.concat("/page/query")).version(version).build()
                        .exchange(HttpMethod.POST, new ParameterizedTypeReference<PagerResultObject<${table_name}>>() {
                        }, ${table_name_first_low});

    }

    @ApiOperation(value = "后台管理--${table_annotation}详情", notes = "后台管理--${table_annotation}详情")
    @GetMapping("/detail")
    @ResponseBody
    public ${table_name} detail(@RequestParam String id) {

        return RestTemplateHelper.builder().url(REQUEST_URL.concat("/{id}")).version(version).build()
                .exchange(HttpMethod.GET, ${table_name}.class, id);
    }

    @ApiOperation(value = "后台管理--新增或者修改${table_annotation}", notes = "后台管理--新增或者修改${table_annotation}")
    @PostMapping("/modify")
    @ResponseBody
    public Map<String, Object> modify(@RequestBody ${table_name} ${table_name_first_low}) {
        Map<String, Object> result = new HashMap<>();

        Long id = ${table_name_first_low}.getId();
        try {
            if (null != id) {
                RestTemplateHelper.builder().url(REQUEST_URL).version(version).build().exchange(HttpMethod.PUT,
                        Object.class, ${table_name_first_low});
            } else {
                RestTemplateHelper.builder().url(REQUEST_URL).version(version).build().exchange(HttpMethod.POST,
                        Object.class, ${table_name_first_low});

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

    @ApiOperation(value = "后台管理--批量删除${table_annotation}", notes = "后台管理--批量删除${table_annotation}")
    @GetMapping("/delete")
    @ResponseBody
    public Map<String, Object> delete(@RequestParam(value = "ids") String ids) {
        Map<String, Object> result = new HashMap<>();
        try {
            RestTemplateHelper.builder().url(REQUEST_URL.concat("/{ids}")).version(version).build()
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
