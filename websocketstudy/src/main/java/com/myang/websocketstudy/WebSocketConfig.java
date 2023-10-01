package com.myang.websocketstudy;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    public void configureMessageBroker(MessageBrokerRegistry registry){
        /*
        destination객체는 , @Controller 객체의 @MessageMapping 메서드로 라우팅된다.
         */
        registry.enableSimpleBroker("/sub");
        /*
         */
        registry.setApplicationDestinationPrefixes("/pub");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry){
        /*
        핸드쉐이크 커넥션을 생성할 경로
         */
        registry.addEndpoint("/expo")
                .setAllowedOrigins("*");
    }


}
