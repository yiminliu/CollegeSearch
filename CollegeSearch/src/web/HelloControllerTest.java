package web;

import static org.junit.Assert.assertEquals;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerTest {

	protected final Log logger = LogFactory.getLog(getClass());

	HelloController controller = null;

	@Before
	public void setUp() throws Exception {
		controller = new HelloController();

	}

	@Test
	public void testGetView() {
		ModelAndView mav = controller.sayHello();
		assertEquals("hello", mav.getViewName());
	}

	@Test
	public void testGetModel() {
		ModelAndView mav = controller.sayHello();
		assertEquals("Hello World", mav.getModel().get("message"));
	}

}
