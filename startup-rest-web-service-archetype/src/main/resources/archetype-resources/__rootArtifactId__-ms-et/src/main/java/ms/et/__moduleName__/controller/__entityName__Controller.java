#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.startupframework.controller.StartupController;
import org.startupframework.controller.service.CRUDControllerBase;

import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.dm.${moduleName}.def.${entityName}Def;
import ${package}.ms.et.${moduleName}.adapter.${entityName}Adapter;

/**
*
* @author startupframework
*/
@StartupController
@RestController
@RequestMapping(${entityName}Def.PATH)
class ${entityName}Controller extends CRUDControllerBase<${entityName}DTO, ${entityName}Adapter> {

	@Autowired
	protected ${entityName}Controller(${entityName}Adapter adapter) {
		super(adapter);
	}

	@Override
	protected void updateProperties(${entityName}DTO source, ${entityName}DTO target) {

		updateProperty(source::getNumberField, target::setNumberField);
		updateProperty(source::getStringField, target::setStringField);
		updateProperty(source::getDateField, target::setDateField);
		
	}
}
