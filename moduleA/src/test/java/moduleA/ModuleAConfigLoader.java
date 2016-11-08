package moduleA;

import org.apache.camel.CamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource( { "classpath:moduleAContext.xml" })
public class ModuleAConfigLoader {
	
	@Autowired
	@Qualifier("moduleACamelContext")
	private CamelContext context;

}
