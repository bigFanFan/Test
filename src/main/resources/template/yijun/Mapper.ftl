<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${package_name}.mapper.${table_name}Mapper">
    <!--新增${table_annotation}-->
    <insert id="create" parameterType="${package_name}.domain.${table_name}" useGeneratedKeys="true" keyProperty="id">
        insert into ${table_name_small}(
            <#if model_column?exists>
                <trim suffixOverrides=",">
                    <#list model_column as model>
                        ${model.columnName},
                    </#list>
                </trim>
            </#if>
        )VALUES (
            <#if model_column?exists>
                    <trim suffixOverrides=",">
                        <#list model_column as model>
                            #${r'{'}${model.changeColumnName}${r'}'},
                        </#list>
                    </trim>
            </#if>
        )
    </insert>
    <!--修改${table_annotation}-->
    <update id="updateById" parameterType="${package_name}.domain.${table_name}">
        update ${table_name_small}
        <set>
            <#if model_column?exists>
                <#list model_column as model>
                    <if test="${model.changeColumnName}!=null">
                        ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'},
                    </if>
                </#list>
            </#if>
        </set>
        where id=#${r'{'}id${r'}'}
    </update>
    <!--依据编号删除${table_annotation}-->
    <delete id="deleteByIds" parameterType="java.util.List">
        delete from ${table_name_small} where id
        in
        <foreach collection="list" item="id" open="(" separator="," close=")">
            #${r'{'}id${r'}'}
        </foreach>
    </delete>

    <!--查询${table_annotation}-->
    <select id="list" parameterType="${package_name}.domain.${table_name}"
            resultType="${package_name}.domain.${table_name}">
        select * from ${table_name_small}
        <#if model_column?exists>
            <where>
                <#list model_column as model>
                    <#if model.modelAttrType =="Integer" || model.modelAttrType=="Long" >
                    <if test="${model.changeColumnName}!=0 ">
                        and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
                    </if>
                    <#else>
                    <if test="${model.changeColumnName}!=null and ${model.changeColumnName}!='null' and ${model.changeColumnName}!=''">
                        and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
                    </if>
                    </#if>
                </#list>
            </where>
        </#if>
    </select>

    <!--分页查询${table_annotation}-->
    <select id="page" parameterType="map"
            resultType="${package_name}.domain.${table_name}">
        select * from ${table_name_small}
        <where>
            <#list model_column as model>
                <#if model.modelAttrType =="Integer" || model.modelAttrType=="Long" >
                    <if test="${model.changeColumnName}!=0 ">
                        and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
                    </if>
                <#else>
                    <if test="${model.changeColumnName}!=null and ${model.changeColumnName}!='null' and ${model.changeColumnName}!=''">
                        and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
                    </if>
                </#if>
            </#list>
        </where>
        <include refid="common.pager"></include>
    </select>

    <!--查询${table_annotation}总记录数-->
    <select id="pageQueryCount" parameterType="map"
            resultType="Integer">
        select count(id) from ${table_name_small}
        <where>
            <#list model_column as model>
                <#if model.modelAttrType =="Integer" || model.modelAttrType=="Long" >
                    <if test="${model.changeColumnName}!=0 ">
                        and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
                    </if>
                <#else>
                    <if test="${model.changeColumnName}!=null and ${model.changeColumnName}!='null' and ${model.changeColumnName}!=''">
                        and ${model.columnName} = #${r'{'}${model.changeColumnName}${r'}'}
                    </if>
                </#if>
            </#list>
        </where>
    </select>


    <select id="findById" parameterType="Long" resultType="${package_name}.domain.${table_name}">
        select * from ${table_name_small} where id=#${r'{'}0${r'}'}
    </select>

</mapper>