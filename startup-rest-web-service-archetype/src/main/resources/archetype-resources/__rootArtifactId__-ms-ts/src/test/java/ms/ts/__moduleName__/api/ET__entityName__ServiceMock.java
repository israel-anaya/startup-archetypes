#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( ${dtoClass} = "${entityName}DTO" )

package ${package}.ms.ts.${moduleName}.api;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.startupframework.exception.DataNotFoundException;
import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.dm.${moduleName}.service.feign.ET${entityName}Service;


public class ET${entityName}ServiceMock implements ET${entityName}Service {

	List<${dtoClass}> buffer = new ArrayList<>();

	${dtoClass}  findItem(String id) {
		Optional<${dtoClass}> found = buffer.stream().filter(item -> item.getId().equals(id)).findFirst();
		return found.orElseThrow(() -> DataNotFoundException.fromId(id));
	}

	@Override
	public List<${dtoClass}> getAllItems() {
		return buffer;
	}

	@Override
	public ${dtoClass} getItem(String id) {
		return findItem(id);
	}

	@Override
	public ${dtoClass} createItem(${dtoClass} item) {
		Date currentDate = new Date(Instant.now().toEpochMilli());
		item.setId("CUST-7e6648f3-1fde-4239-bcb7-b6b39ec323b2");
		item.setCreatedDate(currentDate);
		item.setModifiedDate(currentDate);
		buffer.add(item);
		return item;
	}

	@Override
	public ${dtoClass} updateItem(${dtoClass} item) {
		Date currentDate = new Date(Instant.now().toEpochMilli());
		item.setCreatedDate(currentDate);
		item.setModifiedDate(currentDate);
		return item;
	}

	@Override
	public ${dtoClass} deleteItem(String id) {
		${dtoClass} item = findItem(id);
		buffer.remove(item);
		return item;
	}

}
