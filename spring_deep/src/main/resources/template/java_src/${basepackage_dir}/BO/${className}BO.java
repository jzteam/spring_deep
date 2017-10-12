<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.bo.bean;

<#include "/java_imports.include">

public class ${className}BO implements Serializable{

	<@generateFields />

	<@generateProperties />

	@Override
	public String toString(){
		try{
			return JSONObject.toJSONString(this);
		}catch(Exception e){
			Logs.geterrorLogger().error("${className}BO toString exception occur.",e);
		}
		return null;
	}
}

<#macro generateFields>
	<#list table.columns as column>
	/** ${column.columnAlias} */
	private ${column.simpleJavaType} ${column.columnNameLower};
	</#list>
</#macro>

<#macro generateProperties>
<#list table.columns as column>
	public ${column.simpleJavaType} get${column.columnName}() {
		return this.${column.columnNameLower};
	}

	public void set${column.columnName}(${column.simpleJavaType} value) {
		this.${column.columnNameLower} = value;
	}
</#list>
</#macro>