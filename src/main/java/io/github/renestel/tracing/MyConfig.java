package io.github.renestel.tracing;

import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.http.HttpServletResponse;

@Configuration(proxyBeanMethods = false)
public class MyConfig {

    @Bean
    Filter traceIdInResponseFilter(Tracer tracer) {
        return (request, response, chain) -> {
            Span currentSpan = tracer.currentSpan();
            if (currentSpan != null) {
                HttpServletResponse resp = (HttpServletResponse) response;
                // putting trace id value in [mytraceid] response header
                resp.addHeader("mytraceid", currentSpan.context().traceId());
            }
            chain.doFilter(request, response);
        };
    }

}
