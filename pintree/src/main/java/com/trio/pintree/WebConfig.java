package com.trio.pintree;

import io.netty.channel.ChannelOption;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HttpClient httpClient() {
        return HttpClient.create()
                         .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                         .responseTimeout(Duration.ofMillis(5000))
                         .doOnConnected(
                                 conn -> conn.addHandlerLast(new ReadTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                                             .addHandlerLast(new WriteTimeoutHandler(5000, TimeUnit.MILLISECONDS))
                         );
    }

    @Bean
    public WebClient webClient() {
        return WebClient.builder()
                        .clientConnector(new ReactorClientHttpConnector(httpClient()))
                        .build();
    }
}
