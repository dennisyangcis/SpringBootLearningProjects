package org.yangcis.webfluxlearning.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author: yangyinqi1991@gmail.com
 * @date: 2021/7/28
 * @description: hello world
 */
@RestController
public class HelloWorldController {
    @GetMapping("/helloworld")
    public Mono<String> helloworld() {
        return Mono.just("This is WebFlux demo");
    }
}
