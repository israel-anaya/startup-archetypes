#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dm.${moduleName}.service.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.startupframework.feign.StartupClientConfig;

import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.dm.${moduleName}.def.${entityName}Def;

@FeignClient(name = ${entityName}Def.NAME, path = ${entityName}Def.PATH, configuration = StartupClientConfig.class, primary = false)
public interface ET${entityName}Service {

	@GetMapping()
	List<${entityName}DTO> getAllItems();
	
	@GetMapping("/{id}")
	${entityName}DTO getItem(@PathVariable("id") String id);

	@PostMapping()
	${entityName}DTO createItem(${entityName}DTO item);

	@PutMapping()
	${entityName}DTO updateItem(${entityName}DTO item);
	
	@DeleteMapping("/{id}")
	${entityName}DTO deleteItem(@PathVariable("id") String id);
}
