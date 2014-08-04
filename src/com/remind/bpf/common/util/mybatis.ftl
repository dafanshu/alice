<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${mapper_pkg}.${bean_type}Mapper">
	
	<resultMap type="${bean_type}" id="${bean_type}ResultMap">
		<#list bean_property as p> <#if p.fields?lower_case="id"><id property="id" column="ID"/>
		<#else>
		 <result property="${p.fields?lower_case}" column="${p.fields?upper_case}"/>
		</#if>
		</#list>
	</resultMap>
	
	<insert id="insert" parameterType="${bean_type}">
	 	<selectKey  keyProperty="id" resultType="long" order="BEFORE">
			<![CDATA[select func_bpf_getseq('${table_name}') as id from dual]]>
	   </selectKey>
		<![CDATA[
			INSERT INTO ${table_name}(<#assign i = 0><#list bean_property as p>${p.fields?upper_case}<#if i != (bean_property?size - 1)>, </#if><#assign i = i + 1></#list>) 
			VALUES( <#assign i = 0><#list bean_property as p><#if p.fields?lower_case != "created">#${'{'}${p.fields?lower_case},jdbcType=${p.jdbcType}}<#if i != (bean_property?size - 1)>, </#if><#else>current_date, </#if><#assign i = i + 1></#list> )
		]]>
	</insert>
	
	<delete id="delete" parameterType="${bean_type}">
		 delete from ${table_name}
		 <trim prefix="where" prefixOverrides="AND |OR">  
			<#list bean_property as p> 
			<if test="${p.fields?lower_case} != null">
				AND ${p.fields?upper_case} = #${'{'}${p.fields?lower_case}}
			</if>
			</#list>
		 </trim> 
	</delete>
	
	<delete id="deleteById" parameterType="Long">
		 delete from ${table_name} where id=${r"#{id}"}  
	</delete>
		
	<update id="updateAll" parameterType="${bean_type}">
		<![CDATA[ 
			UPDATE ${table_name} SET LAST_UPD = current_date,
			<#assign i = 0><#list bean_property as p><#if p.fields?lower_case != "last_upd" && p.fields?lower_case != "created" && p.fields?lower_case != "created_by">${p.fields?upper_case} = #${'{'}${p.fields?lower_case}}<#if i != (bean_property?size - 1)>, </#if></#if><#assign i = i + 1></#list> 
			WHERE 1 = 1<#list bean_pk as p> AND ${p?upper_case} = #${'{'}${p?lower_case}}</#list>
		]]>
	</update>
	
	<update id="updateNotNull" parameterType="${bean_type}">
		<![CDATA[ UPDATE ${table_name} ]]>
		<trim prefix="SET" suffixOverrides=",">
			<#assign i = 0><#list bean_property as p>
			<#if p.fields?lower_case != "last_upd">
				<if test="${p.fields?lower_case} != null">
					${p.fields?upper_case} = #${'{'}${p.fields?lower_case}}
				</if>
			</#if>
			<#assign i = i + 1></#list>
		</trim>
		<![CDATA[ WHERE 1 = 1<#list bean_pk as p> AND ${p?upper_case} = #${'{'}${p?lower_case}}</#list> ]]>
	</update>
	
	
	<select id="query" resultMap="${bean_type}ResultMap" parameterType="${bean_type}">
		<![CDATA[ SELECT <#assign i = 0><#list bean_property as p>${p.fields?upper_case}<#if i != (bean_property?size - 1)>, </#if><#assign i = i + 1></#list> FROM ${table_name}]]>
		 <trim prefix="where" prefixOverrides="AND |OR">  
			<#list bean_property as p> 
			<if test="${p.fields?lower_case} != null">
				<![CDATA[AND ${p.fields?upper_case} like CONCAT(CONCAT('%', #${'{'}${p.fields?lower_case}}),'%')]]>
			</if>
			</#list>
		 </trim> 
	</select>
    
    <select id="queryListPage" resultMap="${bean_type}ResultMap" parameterType="Page">
		<![CDATA[ SELECT <#assign i = 0><#list bean_property as p>${p.fields?upper_case}<#if i != (bean_property?size - 1)>, </#if><#assign i = i + 1></#list> FROM ${table_name}]]>
		 <trim prefix="where" prefixOverrides="AND |OR">  
			<#list bean_property as p> 
			<if test="${p.fields?lower_case} != null">
				<![CDATA[AND ${p.fields?upper_case} like CONCAT(CONCAT('%', #${'{'}${p.fields?lower_case}}),'%')]]>
			</if>
			</#list>
		 </trim> 
	</select>
    
</mapper>