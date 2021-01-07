#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.ts.${moduleName}.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.startupframework.controller.StartupController;
import org.startupframework.controller.feign.CRUDControllerBase;

import ${package}.dm.${moduleName}.def.${entityName}Def;
import ${package}.ms.ts.${moduleName}.dto.${entityName}APIModel;
import ${package}.ms.ts.${moduleName}.service.${entityName}Service;


/**
*
* @author startupframework
*/
@StartupController
@RestController
@RequestMapping(${entityName}Def.PATH)
class ${entityName}Controller extends CRUDControllerBase<${entityName}APIModel, ${entityName}Service> {

	@Autowired
	protected ${entityName}Controller(${entityName}Service service) {
		super(service);
	}

	@Override
	protected void updateProperties(${entityName}APIModel source, ${entityName}APIModel target) {

		updateProperty(source::getNumberField, target::setNumberField);
		updateProperty(source::getStringField, target::setStringField);
		updateProperty(source::getDateField, target::setDateField);

	}
}
