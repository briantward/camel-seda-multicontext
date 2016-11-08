package moduleB;

import org.apache.camel.CamelContext;
import org.apache.camel.test.spring.CamelSpringDelegatingTestContextLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource({ "classpath:moduleBContext.xml" })
public class ModuleBConfigLoader {
	
	@Autowired
	@Qualifier("moduleBCamelContext")
	private CamelContext context;
	
	/* This was causing problems loading the routes -- got 0 routes when this was on
	@Bean(name = "camelContext")
	public CamelContext getCamelContext(){
		return context;
	}*/
	

}
