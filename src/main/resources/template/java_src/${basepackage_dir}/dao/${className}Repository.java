<#include "/macro.include"/>
<#assign className = table.className>
package ${basepackage}.dao;

import com.pay.mybatis.data.CrudRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface ${className}Repository extends CrudRepository<${className}, ${className}Query, ${table.idColumn.simpleJavaType}>{

}