package io.github.renestel.tracing;

import brave.Span;
import brave.Tracer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class SampleService {

    Logger logger = Logger.getLogger("TestService");

    @Autowired
    private Tracer tracer;

    public String hello() {
//        logger.info("Starting");

        Span newSpan = tracer.nextSpan().name("new sleuth span").start();

        try {
            Tracer.SpanInScope span = tracer.withSpanInScope(newSpan.start());
//            logger.info("Check (new span)");
        } finally {
            newSpan.finish();
        }

//        logger.info("Finish");
        return "hello";
    }
}
