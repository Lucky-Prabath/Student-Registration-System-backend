package lk.ijse.dep.web.institute;

import lk.ijse.dep.web.institute.util.LogConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : Lucky Prabath <lucky.prabath94@gmail.com>
 * @since : 2021-03-19
 **/

@SpringBootApplication
public class AppInitializer {

    public static void main(String[] args) {
        LogConfig.initLogging();
        SpringApplication.run(AppInitializer.class, args);
    }
}
