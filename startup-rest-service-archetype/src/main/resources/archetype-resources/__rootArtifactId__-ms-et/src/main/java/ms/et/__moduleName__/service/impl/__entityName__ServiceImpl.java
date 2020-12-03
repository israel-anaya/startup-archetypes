#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.startupframework.data.service.EntityServiceBase;

import ${package}.ms.et.${moduleName}.entity.${entityName}Entity;
import ${package}.ms.et.${moduleName}.service.${entityName}Service;


/**
*
* @author startupframework
*/
@Service
class ${entityName}ServiceImpl extends EntityServiceBase<${entityName}Repository, ${entityName}Entity> implements ${entityName}Service {


	@Autowired
	protected ${entityName}ServiceImpl(${entityName}Repository repository) {
		super(repository);
	}

	@Override
	protected void onValidateObject(${entityName}Entity entity) {

	}

}
