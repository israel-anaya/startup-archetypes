#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.dm.${moduleName}.dto

import java.util.Date
import org.startupframework.dto.EntityDTO
import com.fasterxml.jackson.annotation.JsonFormat

class ${entityName}DTO : EntityDTO() {

	var numberField: Int? = null
	var stringField: String? = null

	@JsonFormat(pattern = DATE_PATTERN)
	var dateField: Date? = null

}
