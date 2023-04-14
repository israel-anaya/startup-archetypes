#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.ts.${moduleName}.dto;

import java.util.Date;
import org.startupframework.dto.EntityDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ${entityName}APIModel extends EntityDTO {

	public ${entityName}APIModel() {
	}

	private Integer numberField;
	private String stringField;
	
	@JsonFormat(pattern = DATE_PATTERN)
	private Date dateField;
}
