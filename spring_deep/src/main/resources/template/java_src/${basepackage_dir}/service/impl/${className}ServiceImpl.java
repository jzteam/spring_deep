<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.service.impl;

import com.pay.mybatis.service.AbstractCrudServiceImpl;
import org.apache.ibatis.annotations.Param;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.apache.ibatis.annotations.Param;

@Service
public class ${className}ServiceImpl extends AbstractCrudServiceImpl<${className}Repository, ${className}, ${className}BO, ${className}Query, ${table.idColumn.simpleJavaType}>
	implements ${className}Service{

	@Override
	protected Class<${className}> getBeanClass(){
		return ${className}.class;
	}

	@Override
	protected Class<${className}BO> getBOClass(){
		return ${className}BO.class;
	}

}
