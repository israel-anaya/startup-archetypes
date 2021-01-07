#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.ts.${moduleName}.service;

import org.startupframework.service.feign.CRUDFeign;
import ${package}.ms.ts.${moduleName}.dto.${entityName}APIModel;

/**
*
* @author startupframework
*/
public interface ${entityName}Service extends CRUDFeign<${entityName}APIModel> {

}
