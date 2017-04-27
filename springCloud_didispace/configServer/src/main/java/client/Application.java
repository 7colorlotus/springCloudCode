package client;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * Created by Administrator on 2017/4/26 0026.
 */
@EnableConfigServer
@SpringBootApplication
public class Application {
    public static void main(String[] args){
        new SpringApplicationBuilder(Application.class).web(true).run(args);


    }
}
