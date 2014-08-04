/**
 *
 * FileName: ${bean_type}.java
 *
 * Description: ${bean_sql}
 *
 * Created: ${bean_author} ${bean_created}
 * 
 * |--------------------------------------------------History---------------------------------------------------|
 * |                                                                                                            |
 * |-----Author-----|-----Date-----|----Version----|----------------------------Desc----------------------------| 
 * || 
 * |------------------------------------------------------------------------------------------------------------|
 */
package ${mapper_pkg};

import com.remind.bpf.common.mapper.CommonMapper;
import ${bean};

/**
 * ${bean_type}
 * 
 * Create From SQL: ${bean_sql}
 * 
 * @author ${bean_author} ${bean_created}
 * @version 0.0.1
 */
public interface ${bean_type}Mapper <#if mapper_parent??>extends ${mapper_parent}<${bean_type}></#if>
{
	
	
}
