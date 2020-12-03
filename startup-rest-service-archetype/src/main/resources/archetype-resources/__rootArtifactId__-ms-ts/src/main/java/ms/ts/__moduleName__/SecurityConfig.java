#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.ms.ts.${moduleName};

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.startupframework.security.CustomizerAntMatchers;
import org.startupframework.security.StartupSecurityConfig;
import ${package}.dm.${moduleName}.def.${entityName}Def;

/**
*
* @author startupframework
*/
@Configuration
@EnableWebSecurity
@Profile(value = { "local", "dev", "qa", "uat", "prod" })
public class SecurityConfig extends StartupSecurityConfig {

	@Override
	protected void customAntMatchers(CustomizerAntMatchers customizer) {
		customizer.antMatchers(HttpMethod.GET, ${entityName}Def.PATH + "/**").hasAuthority("SCOPE_read");
		customizer.antMatchers(HttpMethod.POST, ${entityName}Def.PATH + "/**").hasAuthority("SCOPE_write");
		customizer.antMatchers(HttpMethod.PUT, ${entityName}Def.PATH + "/**").hasAuthority("SCOPE_write");
		customizer.antMatchers(HttpMethod.DELETE, ${entityName}Def.PATH + "/**").hasAuthority("SCOPE_write");
	}

}
