package moduleB;

import moduleA.ModuleAConfigLoader;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.apache.camel.BeanInject;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.test.spring.CamelSpringJUnit4ClassRunner;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;

@RunWith(CamelSpringJUnit4ClassRunner.class)
//@BootstrapWith(CamelTestContextBootstrapper.class) // Not sure why bootstrap doesn't work here
@ContextConfiguration(classes = {ModuleBConfigLoader.class, ModuleAConfigLoader.class})
public class IntegrationTest {
	
	@Autowired
	@Qualifier("moduleBCamelContext")
	private CamelContext context;
	
	@Test
	public void test(){
		System.out.println("test");	
		context.createProducerTemplate().sendBody("seda:somewhere","hello");
	}
	/* receive incoming message in module B
	 * 
	 * send to seda route in module A
	 * 
	 * resolve endpoint in module A using recipientList with options
	 * 
	 * endpoint is in module A but Exchange still has context from B
	 * 
	 * so it cannot find the endpoint in module A
	 */

}
