#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dm.${moduleName}.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.startupframework.feign.StartupClientConfig;
import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.dm.${moduleName}.def.${entityName}Def;

@FeignClient(name = ${entityName}Def.NAME, path = ${entityName}Def.PATH, configuration = [StartupClientConfig::class], primary = false)
interface ET${entityName}Service {

	@get:GetMapping
	val allItems: List<${entityName}DTO?>?

	@GetMapping("/{id}")
	fun getItem(@PathVariable("id") id: String?): ${entityName}DTO?

	@PostMapping
	fun createItem(item: ${entityName}DTO?): ${entityName}DTO?

	@PutMapping
	fun updateItem(item: ${entityName}DTO?): ${entityName}DTO?

	@DeleteMapping("/{id}")
	fun deleteItem(@PathVariable("id") id: String?): ${entityName}DTO?
}
