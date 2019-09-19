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
		///////////////////////
		System.out.println(444);
		System.out.println(555);

		System.out.println(666);
		System.out.println(777);

		SpringApplication.run(DemoApplication.class, args);

		System.out.println(888);
	}
}
