#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.controller

import java.util.Date

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.startupframework.controller.StartupController
import org.startupframework.controller.service.CRUDControllerBase

import ${package}.dm.${moduleName}.dto.${entityName}DTO
import ${package}.dm.${moduleName}.def.${entityName}Def
import ${package}.ms.et.${moduleName}.adapter.${entityName}Adapter

/**
*
* @author startupframework
*/
@StartupController
@RestController
@RequestMapping(${entityName}Def.PATH)
internal class ${entityName}Controller @Autowired protected constructor(adapter: ${entityName}Adapter?) :
	CRUDControllerBase<${entityName}DTO?, ${entityName}Adapter?>(adapter) {

	override fun updateProperties(source: ${entityName}DTO?, target: ${entityName}DTO?) {

		updateProperty({ -> source?.numberField }, { v: Int? -> target?.numberField = v })
		updateProperty({ -> source?.stringField }, { v: String? -> target?.stringField = v })
		updateProperty({ -> source?.dateField }, { v: Date? -> target?.dateField = v })
	}
}
