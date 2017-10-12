<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.bean.query;

import com.pay.mybatis.query.PageQuery;

<#include "/java_imports.include">


public class ${className}Query extends PageQuery implements Serializable{

	private static final long serialVersionUID=-1L;

	<@generateFields/>

	<@generateProperties/>

	@Override
	public String toString(){
		try{
			return JSONObject.toJSONString(this);
		}catch(Exception e){
			Logs.geterrorLogger().error("${className}Query toString exception occur.",e);
		}
		return null;
	}

}

<#macro generateFields>
<#list table.columns as column>
	/** ${column.columnAlias} */
	<#if column.isDateTimeColumn && !column.contains("begin,start,end")>
	private ${column.simpleJavaType} ${column.columnNameLower}Begin;
	private ${column.simpleJavaType} ${column.columnNameLower}End;
	<#else>
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#if>
</#list>
</#macro>

<#macro generateProperties>
<#list table.columns as column>
<#if column.isDateTimeColumn && !column.contains("begin,start,end")>
	public ${column.simpleJavaType} get${column.columnName}Begin() {
		return this.${column.columnNameLower}Begin;
	}

	public void set${column.columnName}Begin(${column.simpleJavaType} value) {
		this.${column.columnNameLower}Begin = value;
	}

	public ${column.simpleJavaType} get${column.columnName}End() {
		return this.${column.columnNameLower}End;
	}

	public void set${column.columnName}End(${column.simpleJavaType} value) {
		this.${column.columnNameLower}End = value;
	}

<#else>
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}

	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}

</#if>
</#list>
</#macro>

