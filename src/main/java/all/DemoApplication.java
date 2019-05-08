package all;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableScheduling
public class DemoApplication {

	public static void main(String[] args) {
		System.out.println(111);
		System.out.println(222);
		System.out.println(333);
		SpringApplication.run(DemoApplication.class, args);
	}
}
