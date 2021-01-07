#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.startupframework.data.service.EntityServiceBase

import ${package}.ms.et.${moduleName}.entity.${entityName}Entity
import ${package}.ms.et.${moduleName}.service.${entityName}Service


/**
*
* @author startupframework
*/
@Service
internal class ${entityName}ServiceImpl @Autowired protected constructor(repository: ${entityName}Repository?) :
	EntityServiceBase<${entityName}Repository?, ${entityName}Entity?>(repository), ${entityName}Service {

	override fun onValidateObject(entity: ${entityName}Entity?) {

	}

}
