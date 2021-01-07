#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $dtoClass = "${entityName}DTO" )
#set( $itemId = "${entityName.toLowerCase()}Id" )
#set( $servicePath = "${entityName}Def.PATH" )
package ${package}.ms.et.${moduleName}.api;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.restassured.RestAssured
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import ${package}.dm.${moduleName}.dto.${entityName}DTO
import ${package}.dm.${moduleName}.def.${entityName}Def

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation::class)
internal class ${entityName}APITest : APITest() {

	companion object {
		var ${itemId}: String? = null
		var newItem: ${dtoClass}? = null
		var updateItem: ${dtoClass}? = null

		@JvmStatic
		@BeforeAll
		@Throws(IOException::class)
		fun initData() {
			newItem = readValue("${entityName}-create.json", ${dtoClass}::class.java)
			updateItem = readValue("${entityName}-update.json", ${dtoClass}::class.java)
		}
	}

	fun assertObject(expected: ${dtoClass}?, actual: ${dtoClass}?) {
		assertProperty({ -> expected?.numberField }, { -> actual?.numberField })
		assertProperty({ -> expected?.stringField }, { -> actual?.stringField })
		assertProperty({ -> expected?.dateField }, { -> actual?.dateField })

	}
	
	@Test
	@Order(1)
	fun createItem() {
		val requestSpecification: RequestSpecification = createSpec()
		requestSpecification.body(newItem)

		val response: Response = RestAssured.given().spec(requestSpecification).`when`().post(${servicePath})
		response.then().statusCode(HttpStatus.CREATED.value())

		${itemId} = response.path("id")
		val actualItem: ${dtoClass} = response.`as`(${dtoClass}::class.java)
		assertObject(newItem, actualItem)
	}

	@Test
	@Order(2)
	fun updateItem() {
		updateItem?.id = ${itemId}
		val requestSpecification: RequestSpecification = createSpec()
		requestSpecification.body(updateItem)

		val response: Response = RestAssured.given().spec(requestSpecification).`when`().put(${servicePath})
		response.then().statusCode(HttpStatus.OK.value())

		val actualItem: ${dtoClass} = response.`as`(${dtoClass}::class.java)
		assertObject(updateItem, actualItem)
	}

	@Test
	@Order(3)
	fun getItem() {

		val requestSpecification: RequestSpecification = createSpec()
		requestSpecification.pathParam("id", ${itemId})

		val response: Response = RestAssured.given().spec(requestSpecification).`when`().get(${servicePath} + "/{id}")
		response.then().statusCode(HttpStatus.OK.value())

	}

	@Test
	@Order(4)
	fun findAllItems() {

		val requestSpecification: RequestSpecification = createSpec()
		val response: Response = RestAssured.given().spec(requestSpecification).`when`().get(${servicePath})
		response.then().statusCode(HttpStatus.OK.value())

	}

	@Test
	@Order(5)
	fun deleteItem() {

		val requestSpecification: RequestSpecification = createSpec()
		requestSpecification.pathParam("id", ${itemId})

		val response: Response = RestAssured.given().spec(requestSpecification).`when`().delete(${servicePath} + "/{id}")
		response.then().statusCode(HttpStatus.OK.value())
	}

}
