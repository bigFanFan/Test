package com.lxs.codegenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.google.common.collect.Lists;

import freemarker.template.Template;

/**
 * 描述：代码生成器 Created by Ay on 2017/5/1.
 */
@Service
public class CodeGenerateService {
    private final String AUTHOR = "Limiaojun";
    private final String CURRENT_DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());
    private final String CURRENT_DATE_TIME = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    private final String packageName = "com.lxs.app";
    private final String URL = "jdbc:mysql://172.16.10.196:3306/sgsl_base?useSSL=false";
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String diskPath = "D:\\lmj\\git-project\\my\\basic-service\\code-generator\\";
//    private final String diskPath = "D:\\lmjCode\\0607\\";
    //生成文件是否放同一文件夹标识
//    private boolean oneFloadFlag = true;
    //生成分页标识
    private boolean pageFlag = true;
    private final String tableTirmPrefix = "";// 生成文件中去掉表前缀
    // 需要生成的table ,逗号分割
    private final List<String> tableList = Lists.newArrayList("product_group");

    public Connection getConnection() throws Exception {
        Class.forName(DRIVER);
        Properties props = new Properties();
        props.setProperty("user", USER);
        props.setProperty("password", PASSWORD);
        props.setProperty("remarks", "true"); // 设置可以获取remarks信息
        props.setProperty("useInformationSchema", "true");// 设置可以获取tables
                                                          // remarks信息
        Connection connection = DriverManager.getConnection(URL, props);
        return connection;
    }

    public static void main(String[] args) throws Exception {
        CodeGenerateService codeGenerateUtils = new CodeGenerateService();
        codeGenerateUtils.generate();
    }

    public void generate() throws Exception {
        try {
            File targetFoder = new File(diskPath);
            if (!targetFoder.exists()) {
                targetFoder.mkdirs();
            }
            Connection connection = getConnection();
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            // 查询表
            ResultSet tableRs = databaseMetaData.getTables(null, "%", null, new String[] { "TABLE" });
            while (tableRs.next()) {
                // 生成Mapper文件
                String tableName = tableRs.getString("TABLE_NAME");
                if (!CollectionUtils.isEmpty(tableList) && !tableList.contains(tableName)) {
                    continue;
                }

                String changeTableName = replaceUnderLineAndUpperCase(tableName.replaceFirst(tableTirmPrefix, ""));// 首字母大写用于定义类
                String changeTableNameFistLowCase =
                        replaceUnderLineAndUpperCaseFistLowCase(tableName.replaceFirst(tableTirmPrefix, ""));// 首字母小写用于申明变量
                
                // 生成Mapper文件
                generateFile("Mapper.xml", "Mapper.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
                // 生成Model文件
                generateFile(".java", "Model.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
                // 生成MapperAPI文件
                generateFile("Mapper.java", "MapperJava.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
                // 生成service文件
                generateFile("Service.java", "Service.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
                // 生成api文件
                generateFile("Api.java", "Api.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
                // 生成controller文件
                generateFile("Controller.java", "Controller.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
                // 生成ftl页面
                generateFile("List.ftl", "Page.ftl", tableName, changeTableName, changeTableNameFistLowCase,
                        tableRs.getString("REMARKS"),
                        databaseMetaData.getColumns(null, "%", tableRs.getString("TABLE_NAME"), "%"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {

        }
    }

    private void generateFile(String suffix, String templateName, String tableName, String changeTableName,
            String changeTableNameFistLowCase, String tableAnnotation, ResultSet resultSet) throws Exception {
        
        String tempDiskPath = diskPath;
//        if (!oneFloadFlag) {
        String javaPath = "src/main/java/";
        String resourcesPath = "src/main/resources/";
        String packagePath = packageName.replaceAll("\\.", "/").concat("/");
        switch (suffix) {
            case "Mapper.xml":
                tempDiskPath += resourcesPath.concat("mappers").concat("/");
                break;
            case "Mapper.java":
                tempDiskPath += javaPath.concat(packagePath).concat("mapper").concat("/");
                break;
            case ".java":
                tempDiskPath += javaPath.concat(packagePath).concat("domain").concat("/");
                break;
            case "Service.java":
                tempDiskPath += javaPath.concat(packagePath).concat("service").concat("/");
                break;
            case "Api.java":
                tempDiskPath += javaPath.concat(packagePath).concat("api").concat("/");
                break;
            case "Controller.java":
                tempDiskPath += javaPath.concat(packagePath).concat("controller").concat("/");
                break;
            case "List.ftl":
                tempDiskPath += resourcesPath.concat("template").concat("/");
//             break;
            default:
                break;
        }
//        }

        File targetFoder = new File(tempDiskPath);
        if (!targetFoder.exists()) {
            targetFoder.mkdirs();
        }
        
//        final String path =
//                oneFloadFlag ? diskPath + changeTableName + suffix : tempDiskPath + changeTableName + suffix;
        final String path = tempDiskPath + (suffix.equals("List.ftl")?changeTableNameFistLowCase: changeTableName) + suffix;
        File mapperFile = new File(path);
        List<ColumnClass> columnClassList = new ArrayList<>();
        ColumnClass columnClass = null;
        
        //主键和主键类型
        String key = null;
        String keyType = null;
        while (resultSet.next()) {
            // id字段略过
            // if(resultSet.getString("COLUMN_NAME").equals("id")) continue;
            if(null == key) {
                key = resultSet.getString("COLUMN_NAME");
                keyType = colTypeToModType(resultSet.getString("TYPE_NAME"));
            }
            columnClass = new ColumnClass();
            // 获取字段名称
            columnClass.setColumnName(resultSet.getString("COLUMN_NAME"));
            // 获取字段类型
            columnClass.setColumnType(resultSet.getString("TYPE_NAME"));
            // 转换数据库字段类型为model属性类型
            columnClass.setModelAttrType(colTypeToModType(resultSet.getString("TYPE_NAME")));
            // 转换字段名称，如 sys_name 变成 sysName
            columnClass
                    .setChangeColumnName(replaceUnderLineAndUpperCaseFistLowCase(resultSet.getString("COLUMN_NAME")));
            // 字段在数据库的注释
            columnClass.setColumnComment(resultSet.getString("REMARKS"));
            columnClassList.add(columnClass);
        }
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("model_column", columnClassList);
        dataMap.put("primary_key",key);
        dataMap.put("primary_key_modtype",keyType);
        generateFileByTemplate(tableName, changeTableName, changeTableNameFistLowCase, tableAnnotation, templateName,
                mapperFile, dataMap);

    }

    private void generateFileByTemplate(String tableName, String changeTableName, String changeTableNameFistLowCase,
            String tableAnnotation, final String templateName, File file, Map<String, Object> dataMap)
            throws Exception {
        Template template = FreeMarkerTemplateUtils.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        dataMap.put("table_name_small", tableName);
        dataMap.put("table_name", changeTableName);
        dataMap.put("table_name_first_low", changeTableNameFistLowCase);
        dataMap.put("author", AUTHOR);
        dataMap.put("date", CURRENT_DATE);
        dataMap.put("dateTime", CURRENT_DATE_TIME);
        dataMap.put("package_name", packageName);
        
        if (!StringUtils.isEmpty(tableAnnotation)) {
            // 判断最后字符串是否以表结尾 去掉
            String lastStr = tableAnnotation.substring(tableAnnotation.length() - 1, tableAnnotation.length());
            if ("表".equals(lastStr)) {
                tableAnnotation = tableAnnotation.substring(0, tableAnnotation.length() - 1);
            }
            if ("Model.ftl".equals(templateName)) {
                tableAnnotation += "实体类";
            }
        }
        
        dataMap.put("table_annotation", tableAnnotation);
        dataMap.put("pageFlag", pageFlag);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"), 10240);
        template.process(dataMap, out);
    }

    private String replaceUnderLineAndUpperCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.capitalize(result);
    }

    private String replaceUnderLineAndUpperCaseFistLowCase(String str) {
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        int count = sb.indexOf("_");
        while (count != 0) {
            int num = sb.indexOf("_", count);
            count = num + 1;
            if (num != -1) {
                char ss = sb.charAt(count);
                char ia = (char) (ss - 32);
                sb.replace(count, count + 1, ia + "");
            }
        }
        String result = sb.toString().replaceAll("_", "");
        return StringUtils.uncapitalize(result);
    }

    /**
     * 数据字段类型转model属性类型
     * 
     * @param colType
     * @return
     */
    private String colTypeToModType(String colType) {
        colType = colType.toUpperCase();
        String modelType;
        switch (colType) {
            case "INTEGER":
                modelType = "Integer";
                break;
            case "TINYINT":
                modelType = "Integer";
                break;
            case "INT":
                modelType = "Integer";
                break;
            case "BIGINT":
                modelType = "Long";
                break;
            case "VARCHAR":
                modelType = "String";
                break;
            case "CHAR":
                modelType = "String";
                break;
            case "TEXT":
                modelType = "String";
                break;
            case "DECIMAL":
                modelType = "BigDecimal";
                break;
            case "DATETIME":
                modelType = "Timestamp";
                break;
            case "TIMESTAMP":
                modelType = "Timestamp";
                break;
            case "DOUBLE":
                modelType = "Double";
                break;
            case "FLOAT":
                modelType = "Float";
                break;
            default:
                modelType = colType;
        }
        return modelType;
    }

}
