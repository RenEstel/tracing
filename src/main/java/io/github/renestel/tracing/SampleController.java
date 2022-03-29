package io.github.renestel.tracing;

import io.github.renestel.tracing.request.RequestDto;
import io.github.renestel.tracing.request.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

//@Slf4j
@RestController
@RequiredArgsConstructor
public class SampleController {
    private final SampleService sampleService;

    Logger logger = Logger.getLogger("TestController");


    @PostMapping("/hello")
    public ResponseEntity<ResponseDto> hello(@RequestBody RequestDto request) {
//        logger.info("this is hello method");
        return ResponseEntity.ok(ResponseDto.builder().answer(sampleService.hello()).build());
    }
}
