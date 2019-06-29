package learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class Application {
  public static void main(String... args) {
    SpringApplication.run(Application.class,args);
  }
}

@RestController
class GreetingsController {
  @GetMapping("/greetings")
  public String getGreetings() {
    return "Hello, World!";
  }
}
