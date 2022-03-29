package io.github.renestel.tracing;

import io.github.renestel.tracing.zalando.ZalandoConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(ZalandoConfig.class)
@SpringBootApplication
public class TracingApplication {

    public static void main(String[] args) {
        SpringApplication.run(TracingApplication.class, args);
    }

}
