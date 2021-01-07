#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.et.${moduleName}.api;

import io.restassured.builder.RequestSpecBuilder
import org.junit.jupiter.api.BeforeAll
import org.springframework.beans.factory.annotation.Autowired
import org.startupframework.config.StartupProperties
import io.restassured.specification.RequestSpecification
import io.restassured.RestAssured
import kotlin.Throws
import java.io.IOException
import org.springframework.core.io.ClassPathResource
import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.http.ContentType
import org.junit.jupiter.api.Assertions
import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.http.HttpHeaders
import java.util.HashMap
import java.util.function.Consumer
import java.util.function.Supplier

internal abstract class APITest {
	companion object {
		private val objectMapper = ObjectMapper()
		private val builder = RequestSpecBuilder()

		@JvmStatic
		@BeforeAll
		fun init(@Autowired startupProperties: StartupProperties, @Value("\${local.server.port}") port: Int) {
			val headers: MutableMap<String, String> = HashMap()
			startupProperties.headers.required.forEach(Consumer { header: String -> headers[header] = header })
			builder.setPort(port)
			builder.setContentType(ContentType.JSON)
			builder.addHeaders(headers)
			builder.addHeader(HttpHeaders.AUTHORIZATION, "DUMMY")
		}

		@JvmStatic
		protected fun createSpec(): RequestSpecification {
			return RestAssured.given().spec(builder.build())
		}


		@JvmStatic
		@Throws(IOException::class)
		protected fun <T> readValue(path: String?, valueType: Class<T>?): T {
			val resource: Resource = ClassPathResource(path!!)
			val inputstream = resource.inputStream
			return objectMapper.readValue(inputstream, valueType)
		}
	}

	protected fun <P> assertProperty(expected: Supplier<P>, actual: Supplier<P>) {
		val expectedValue: P? = expected.get()
		if (expectedValue != null) {
			val actualValue = actual.get()
			Assertions.assertEquals(expectedValue, actualValue)
		}
	}
}