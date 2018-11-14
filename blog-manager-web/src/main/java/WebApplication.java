import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author LuoJu_123855
 * @since 2018.10.10
 */

@SpringBootApplication
@EnableCaching
@ComponentScan(value = "com.hanslaser.blog")
public class WebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }
}



