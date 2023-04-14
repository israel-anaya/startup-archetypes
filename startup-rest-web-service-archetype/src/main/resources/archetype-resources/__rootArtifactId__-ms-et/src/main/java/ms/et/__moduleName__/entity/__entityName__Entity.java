#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.startupframework.data.entity.EntityBase;
import org.startupframework.entity.id.EntityId;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
*
* @author startupframework
*/
@Entity
@EntityId("${entityName.substring(0,2)}") // TODO Select prefix for id, max 4 letters
@Data()
@EqualsAndHashCode(callSuper = true)
public class ${entityName}Entity extends EntityBase {

	public ${entityName}Entity() {
	}

	@Column(length = 30, unique = true, nullable = false)
	@NotNull
	private Integer numberField;
	
	@Column(length = 30, unique = true, nullable = false)
	@NotEmpty
	@Size(max = 30)
	private String stringField;
	
	@Column(nullable = false)
	@NotNull
	private Date dateField;
	

}