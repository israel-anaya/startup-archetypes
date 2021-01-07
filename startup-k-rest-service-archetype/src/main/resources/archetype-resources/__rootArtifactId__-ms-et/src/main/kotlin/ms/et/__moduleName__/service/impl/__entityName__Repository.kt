#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.service.impl

import org.startupframework.data.repository.EntityRepository
import ${package}.ms.et.${moduleName}.entity.${entityName}Entity


/**
*
* @author startupframework
*/
internal interface ${entityName}Repository : EntityRepository<${entityName}Entity?> {

	
}
