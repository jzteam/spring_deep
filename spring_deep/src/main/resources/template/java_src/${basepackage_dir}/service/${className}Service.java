<#include "/macro.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>

package ${basepackage}.service;

import com.pay.mybatis.service.CrudService;
import org.apache.ibatis.annotations.Param;

public interface ${className}Service extends CrudService<${className}BO, ${className}Query, ${table.idColumn.simpleJavaType}>{

}
