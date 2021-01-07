#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.ts.${moduleName}.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.startupframework.service.feign.CRUDFeign;

import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.dm.${moduleName}.service.feign.ET${entityName}Service;

/**
*
* @author startupframework
*/
@Service
class ${entityName}FeignAdapter implements CRUDFeign<${entityName}DTO> {

	final ET${entityName}Service feign;

	@Autowired
	protected ${entityName}FeignAdapter(final ET${entityName}Service feign) {
		this.feign = feign;
	}

	@Override
	public List<${entityName}DTO> getAllItems() {
		return feign.getAllItems();
	}

	@Override
	public ${entityName}DTO getItem(String id) {
		return feign.getItem(id);
	}

	@Override
	public ${entityName}DTO createItem(${entityName}DTO item) {
		return feign.createItem(item);
	}

	@Override
	public ${entityName}DTO updateItem(${entityName}DTO item) {
		return feign.updateItem(item);
	}

	@Override
	public ${entityName}DTO deleteItem(String id) {
		return feign.deleteItem(id);
	}
}
