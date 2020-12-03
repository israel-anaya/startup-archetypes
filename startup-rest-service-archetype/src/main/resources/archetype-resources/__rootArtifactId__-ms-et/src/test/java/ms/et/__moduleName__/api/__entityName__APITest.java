#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
#set( $dtoClass = "${entityName}DTO" )
#set( $itemId = "${entityName.toLowerCase()}Id" )
#set( $servicePath = "${entityName}Def.PATH" )
package ${package}.ms.et.${moduleName}.api;

import static io.restassured.RestAssured.given;

import java.io.IOException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import ${package}.dm.${moduleName}.dto.${entityName}DTO;
import ${package}.dm.${moduleName}.def.${entityName}Def;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class ${entityName}APITest extends APITest {

	static String ${itemId};
	static ${dtoClass} newItem;
	static ${dtoClass} updateItem;
	
	void assertObject(${dtoClass} expected, ${dtoClass} actual) {
		assertProperty(expected::getNumberField, actual::getNumberField);
		assertProperty(expected::getStringField, actual::getStringField);
		assertProperty(expected::getDateField, actual::getDateField);
	}

	@BeforeAll
	static void initData() throws IOException {
		newItem = readValue("${entityName}-create.json", ${dtoClass}.class);
		updateItem = readValue("${entityName}-update.json", ${dtoClass}.class);
	}
	
	@Test
	@Order(1)
	void createItem() {

		RequestSpecification requestSpecification = createSpec();
		requestSpecification.body(newItem);

		Response response;
		response = given().spec(requestSpecification).when().post(${servicePath});
		response.then().statusCode(HttpStatus.CREATED.value());

		${itemId} = response.path("id");
		${dtoClass} actualItem = response.as(${dtoClass}.class);
		assertObject(newItem, actualItem);

	}

	@Test
	@Order(2)
	void updateItem() {

		updateItem.setId(${itemId});
		RequestSpecification requestSpecification = createSpec();
		requestSpecification.body(updateItem);

		Response response;
		response = given().spec(requestSpecification).when().put(${servicePath});
		response.then().statusCode(HttpStatus.OK.value());
		
		${dtoClass} actualItem = response.as(${dtoClass}.class);
		assertObject(updateItem, actualItem);
	}

	@Test
	@Order(3)
	void getItem() {

		RequestSpecification requestSpecification = createSpec();
		requestSpecification.pathParam("id", ${itemId});

		Response response;
		response = given().spec(requestSpecification).when().get(${servicePath} + "/{id}");
		response.then().statusCode(HttpStatus.OK.value());

	}

	@Test
	@Order(4)
	void findAllItems() {

		RequestSpecification requestSpecification = createSpec();

		Response response;
		response = given().spec(requestSpecification).when().get(${servicePath});
		response.then().statusCode(HttpStatus.OK.value());
	}

	@Test
	@Order(5)
	void deleteItem() {

		RequestSpecification requestSpecification = createSpec();
		requestSpecification.pathParam("id", ${itemId});

		Response response;
		response = given().spec(requestSpecification).when().delete(${servicePath} + "/{id}");
		response.then().statusCode(HttpStatus.OK.value());
	}

}
