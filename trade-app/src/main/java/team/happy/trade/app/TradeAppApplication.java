package team.happy.trade.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "team.happy")
public class TradeAppApplication {
    public static void main(String[] args) {
        SpringApplication.run(TradeAppApplication.class, args);
    }
}
