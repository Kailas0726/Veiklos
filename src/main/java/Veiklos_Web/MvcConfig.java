package Veiklos_Web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

	public void addViewControllers(ViewControllerRegistry registry) {
		//registry.addViewController("/prisijungti").setViewName("prisijungti");
		registry.addViewController("/").setViewName("/prisijungti");
		registry.addViewController("/atsijungti").setViewName("atsijungti");
		registry.addViewController("/prisijungimas").setViewName("prisijungimas");
		registry.addViewController("/zmonesveiklos").setViewName("zmonesveiklos");
	}

}
