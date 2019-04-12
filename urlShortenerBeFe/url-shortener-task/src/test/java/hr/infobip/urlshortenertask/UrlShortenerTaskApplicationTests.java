package hr.infobip.urlshortenertask;

import hr.infobip.urlshortenertask.controller.RegisterUrlController;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebMvcTest(RegisterUrlController.class)
public class UrlShortenerTaskApplicationTests {

	@Test
	public void contextLoads() {
	}

}
