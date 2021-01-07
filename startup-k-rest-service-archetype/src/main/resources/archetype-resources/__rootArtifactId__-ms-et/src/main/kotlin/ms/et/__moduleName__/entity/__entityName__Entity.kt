#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.entity

import java.util.Date

import javax.persistence.Column
import javax.persistence.Convert
import javax.persistence.Entity
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

import org.startupframework.data.entity.EntityBase
import org.startupframework.data.entity.id.EntityId


/**
*
* @author startupframework
*/
@Entity
@EntityId("${entityName.substring(0,2)}") // TODO Select prefix for id, max 4 letters
class ${entityName}Entity : EntityBase() {

	@Column(length = 30, unique = true, nullable = false)
	var numberField: @NotNull Int? = null

	@Column(length = 30, unique = true, nullable = false)
	var stringField: @NotEmpty @Size(max = 30) String? = null

	@Column(nullable = false)
	var dateField: @NotNull Date? = null

}