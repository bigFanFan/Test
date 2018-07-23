<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.mapper.${table_name}Mapper">

    <!-- 数据库字段对象关系映射 -->
    <resultMap id="BaseResultMap"
        type="${package_name}.domain.${table_name}" >
     <#list model_column as model>
     <#if model.columnName='id'>
        <id column="id" property="id"/>
     <#else>
        <result column="${model.columnName}" property="${model.changeColumnName}" />
     </#if>
     </#list>
    </resultMap>

    <!-- base查询字段  -->
    <sql id="Base_Column_List" >
        <trim suffixOverrides="," >
            <#if model_column?exists>
                <#list model_column as model>
            ${model.columnName},
                </#list>
            </#if>
        </trim>
    </sql>

    <!--新增${table_annotation}-->
    <insert id="create" parameterType="${package_name}.domain.${table_name}" useGeneratedKeys="true" keyProperty="id">
        insert into ${table_name_small}
        <trim prefix="(" suffix=")" suffixOverrides="," >
            <#if model_column?exists>
                <#list model_column as model>
            <if test="${model.changeColumnName} != null ">
                ${model.columnName},
            </if>
                </#list>
            </#if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides="," >
            <#if model_column?exists>
                <#list model_column as model>
            <if test="${model.changeColumnName} != null ">
                #${r'{'}${model.changeColumnName}${r'}'},
            </if>
                </#list>
            </#if>
        </trim>
    </insert>

    <!--根据id修改${table_annotation}-->
    <update id="updateById" parameterType="${package_name}.domain.${table_name}">
        update ${table_name_small}
        <set>
            <#if model_column?exists>
                <#list model_column as model>
            <if test="${model.changeColumnName} != null ">
                ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'},
            </if>
                </#list>
            </#if>
        </set>
        where id=#${r'{'}id${r'}'}
    </update>

    <!--根据ids删除${table_annotation}-->
    <delete id="deleteByIds" parameterType="java.util.List">
        delete from ${table_name_small} where id in
        <foreach collection="list" item="item" open="("
            separator="," close=")">
            #${r'{'}item${r'}'}
        </foreach>
    </delete>


    <!-- 根据id查找${table_annotation} -->
	<select id="selectById" resultMap="BaseResultMap"
		parameterType="${primary_key_modtype?lower_case}"> select <include refid="Base_Column_List" />
		from ${table_name_small} where ${primary_key} = #${r'{'}id${r'}'}
	</select>


    <!-- base where条件  -->
    <sql id="Base_Where_Condition" >
        <#if model_column?exists>
        <where>
            <#list model_column as model>
            <if test="${model.changeColumnName} != null <#--<#if  model.modelAttrType='String' > and ${model.changeColumnName} != '' </#if> -->">
                and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
            </if>
            </#list>
        </where>
        </#if>
    </sql>


    <!--查询${table_annotation}列表-->
     <#if pageFlag>
     <select id="page${table_name}s" resultMap="BaseResultMap"
     <#else>
     <select id="list" resultMap="BaseResultMap"
     </#if>
        parameterType="${package_name}.domain.${table_name}">
	        select <include refid="Base_Column_List" />
	        from ${table_name_small}
	        <include refid="Base_Where_Condition" />
	        <#if pageFlag>
	        <include refid="common.pager" />
	        </#if>
    </select>

    <!--查询${table_annotation}总记录-->
    <select id="page${table_name}Counts" resultType="long"
        parameterType="${package_name}.domain.${table_name}">
            select count(1)
            from ${table_name_small}
            <include refid="Base_Where_Condition" />
    </select>

</mapper>