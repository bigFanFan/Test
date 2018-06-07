package ${package_name}.controller.${table_name_first_low};

import com.sgsl.app.config.ApplicationConfiguration;
import com.sgsl.app.domain.${table_name}PageResult;
import com.sgsl.app.domain.${table_name}Result;
import com.sgsl.app.util.DomainUtil;
import com.sgsl.app.util.StringUtil;
import com.sgsl.app.util.interceptor.HeaderHelper;
import com.sgsl.app.util.PageQueryObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.*;
import java.sql.Timestamp;
import java.math.BigDecimal;

    @Slf4j
    @Controller
    @RequestMapping("/app/${table_name_first_low}")
    public class ${table_name}Controller {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ApplicationConfiguration config;

    @Value("${r'${'}sgsl.version.number.${table_name_first_low}center${r'}'}")
    private String version;

    private HeaderHelper header = new HeaderHelper();

    /**
    * ${table_annotation}列表显示
    * @param model
    * @return
    */
    @GetMapping("/page")
    public String ${table_name_first_low}List(Map<String,Object> model,HttpSession session) {

        return "/${table_name_first_low}Manage/${table_name_first_low}List";
    }

    /**
    * Grid显示数据--${table_annotation}
    * @param
    * @return
    * @throws Exception
    */
    @PostMapping("/grid")
    @ResponseBody
    public PageQueryObject ${table_name_first_low}Datagrid(
    <#if model_column?exists>
            <#list model_column as model>
    @RequestParam(value="${model.changeColumnName?uncap_first}", required = false<#if model.modelAttrType =="Integer" || model.modelAttrType=="Long" >,defaultValue="0"</#if>)${model.modelAttrType!} ${model.changeColumnName?uncap_first},
            </#list>
    </#if>
    @RequestParam(value="rows", required = false, defaultValue="10") String rows,
    @RequestParam(value="page", required = false, defaultValue="1") String page,
    @RequestParam(value="sidx", required = false, defaultValue="") String sidx,
    @RequestParam(value="sord", required = false, defaultValue="") String sord, HttpSession session){
    String requestUrl="%s/${table_name_first_low}/page?<#if model_column?exists><#list model_column as model>${model.changeColumnName?uncap_first}=%s&</#list></#if>rows=%s&page=%s&sidx=%s&sord=%s";

    requestUrl=String.format(requestUrl,config.getApiGatewayServer${table_name}centerUrl(),<#if model_column?exists><#list model_column as model>${model.changeColumnName?uncap_first},</#list></#if>rows,page,sidx,sord);

    ResponseEntity<PageQueryObject> entity = restTemplate.exchange(requestUrl,
        HttpMethod.GET,header.findRequestEntity(null,version),new ParameterizedTypeReference<PageQueryObject>(){});

    PageQueryObject pageQueryResult = null;
    if (null != entity && entity.getStatusCodeValue()<400) {
        pageQueryResult = entity.getBody();
    }
    return pageQueryResult;
    }

    /**
    * ajax添加或者修改--${table_annotation}
    * @param model
    * @return
    * @throws Exception
    */
    @PostMapping("/addOrEdit")
    @ResponseBody
    public Map<String, Object> addOrEdit(@RequestBody Map<String,String> model, HttpSession session) {
        Map<String, Object> result=new HashMap<>();
        String id = model.get("id");
        try{
        StringBuilder requestUrl=new StringBuilder(config.getApiGatewayServer${table_name}centerUrl());
        if(StringUtil.isNotNull(id)){
            //修改
            requestUrl.append("/${table_name_first_low}/update/"+id);
            restTemplate.exchange(requestUrl.toString(), HttpMethod.PUT, header.findRequestEntity(model,version), Object.class);
        }else{
            //添加
            requestUrl.append("/${table_name_first_low}/create");
            restTemplate.exchange(requestUrl.toString(), HttpMethod.POST, header.findRequestEntity(model,version), Object.class);
        }
        result.put("success", true);
        result.put("msg", "操作成功");
        }catch(Exception e){
        result.put("success", false);
        result.put("msg", "操作失败");
        log.error(e.getMessage());
        }
        return result;
    }

    /**
    * ajax查询单条数据--${table_annotation}
    * @param id
    * @return
    * @throws Exception
    */
    @GetMapping("/detail")
    @ResponseBody
    public ${table_name}Result detialAjax(@RequestParam(value="id") String id, HttpSession session) {
        ResponseEntity<${table_name}Result> entity = restTemplate.exchange(config.getApiGatewayServer${table_name}centerUrl()+"/${table_name_first_low}/find/{id}",
                HttpMethod.GET, header.findRequestEntity(null,version) , new ParameterizedTypeReference<${table_name}Result>(){},id);
        ${table_name}Result ${table_name_first_low}Result = null;
        if(null != entity){
              ${table_name_first_low}Result = entity.getBody();
        }
        return ${table_name_first_low}Result;
    }

    /**
    * ajax删除--${table_annotation}
    * @param ids
    * @return
    * @throws Exception
    */
    @GetMapping("/delete")
    @ResponseBody
    public Map<String, Object> deleteAjax(@RequestParam(value="ids") String ids, HttpSession session){
        Map<String, Object> result=new HashMap<>();

        try{
        String requestUrl="%s/${table_name_first_low}/remove/%s";
        requestUrl=String.format(requestUrl,config.getApiGatewayServer${table_name}centerUrl(),ids);
        restTemplate.exchange(requestUrl, HttpMethod.DELETE, header.findRequestEntity(null,version), Object.class);

        result.put("success", true);
        result.put("msg", "删除成功");
        }catch(Exception e){
        result.put("success", false);
        result.put("msg", "删除失败");
        log.error(e.getMessage());
        }
        return result;
    }


    /**
    *导出-${table_annotation}
    **/
    @PostMapping("/download")
    @ResponseBody
    public Map<String,Object> downloadUrl(@RequestBody Map<String,Object> model){

        Map<String,Object> result = new HashMap<>();
        String requestUrl="%s/${table_name_first_low}/export?<#if model_column?exists><#list model_column as model>${model.changeColumnName?uncap_first}=%s&</#list></#if>";
        requestUrl=String.format(requestUrl,config.getApiGatewayServer${table_name}centerUrl()<#if model_column?exists><#list model_column as model>,(String) model.get("${model.changeColumnName?uncap_first}")</#list></#if>);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
        String title = sdf.format(new Date());

        result.put("success", true);
        result.put("downloadUrl", requestUrl);
        result.put("title", title+"导出${table_annotation}");
        return result;
    }
}
