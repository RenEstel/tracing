package io.github.renestel.tracing.zalando;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.zalando.logbook.Correlation;
import org.zalando.logbook.HttpLogWriter;
import org.zalando.logbook.Precorrelation;

@Slf4j(topic = "HTTP-REQUEST-LOG-WRITER")
public class CustomHttpLogWriter implements HttpLogWriter {
    @Value("${logbook.logger.active}")
    private boolean isActive;

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void write(Precorrelation precorrelation, String request) {
        log.info(request);
    }

    @Override
    public void write(Correlation correlation, String response) {
        log.info(response);
    }
}
