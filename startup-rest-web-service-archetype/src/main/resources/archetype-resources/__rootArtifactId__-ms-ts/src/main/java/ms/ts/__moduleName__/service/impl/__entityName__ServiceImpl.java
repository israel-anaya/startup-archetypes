#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.ts.${moduleName}.service.impl;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.startupframework.dto.DTOConverter;
import org.startupframework.service.feign.CRUDFeignBase;
import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.ms.ts.${moduleName}.dto.${entityName}APIModel;
import ${package}.ms.ts.${moduleName}.service.${entityName}Service;

/**
*
* @author startupframework
*/
@Service
class ${entityName}ServiceImpl extends CRUDFeignBase<${entityName}DTO, ${entityName}APIModel> implements ${entityName}Service {

	@Mapper
	public interface Converter extends DTOConverter<${entityName}DTO, ${entityName}APIModel> {
		static final Converter INSTANCE = Mappers.getMapper(Converter.class);

	}

	@Autowired
	protected ${entityName}ServiceImpl(final ${entityName}FeignAdapter feign) {
		super(feign, Converter.INSTANCE);
	}

	@Override
	protected void onValidateObject(${entityName}APIModel item) {

	}

}
