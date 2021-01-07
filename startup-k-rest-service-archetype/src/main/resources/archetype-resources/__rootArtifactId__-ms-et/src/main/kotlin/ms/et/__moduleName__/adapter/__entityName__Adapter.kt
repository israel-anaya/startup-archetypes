#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.adapter

import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.startupframework.data.adapter.CRUDAdapter
import org.startupframework.data.entity.DataConverter

import ${package}.dm.${moduleName}.dto.${entityName}DTO
import ${package}.ms.et.${moduleName}.entity.${entityName}Entity
import ${package}.ms.et.${moduleName}.service.${entityName}Service

/**
*
* @author startupframework
*/
@Service
class ${entityName}Adapter @Autowired protected constructor(service: ${entityName}Service?) :
	CRUDAdapter<${entityName}DTO?, ${entityName}Entity?, ${entityName}Service?>(service, Converter.INSTANCE) {

	@Mapper
	interface Converter : DataConverter<${entityName}DTO?, ${entityName}Entity?> {
		companion object {
			val INSTANCE: Converter = Mappers.getMapper<Converter>(Converter::class.java)
		}
	}
}
