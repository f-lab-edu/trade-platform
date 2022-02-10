package team.world.trade.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "team.world")
public class TradeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeAppApplication.class, args);
    }
}
