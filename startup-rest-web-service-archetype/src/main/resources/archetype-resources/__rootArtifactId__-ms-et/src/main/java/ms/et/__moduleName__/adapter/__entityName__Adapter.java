#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.adapter;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.startupframework.data.adapter.CRUDAdapter;
import org.startupframework.entity.DataConverter;

import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.ms.et.${moduleName}.entity.${entityName}Entity;
import ${package}.ms.et.${moduleName}.service.${entityName}Service;

/**
*
* @author startupframework
*/
@Service
public class ${entityName}Adapter extends CRUDAdapter<${entityName}DTO, ${entityName}Entity, ${entityName}Service> {

	@Mapper
	public interface Converter extends DataConverter<${entityName}DTO, ${entityName}Entity> {
		static final Converter INSTANCE = Mappers.getMapper(Converter.class);

	}

	@Autowired
	protected ${entityName}Adapter(${entityName}Service service) {
		super(service, Converter.INSTANCE);
	}
}
