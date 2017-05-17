/*
 * Copyright 2014-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package heng.shi.websocket;

import heng.shi.repository.ActiveWebSocketUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

public class MyWebSocketHandler implements WebSocketHandler {
    private RedisTemplate<String,String> redisTemplate;

    public MyWebSocketHandler(RedisTemplate<String,String> redisTemplate){
        this.redisTemplate = redisTemplate;
    }
    @Override
    public void afterConnectionEstablished(WebSocketSession webSocketSession) throws Exception {
        this.redisTemplate.opsForValue().set(webSocketSession.getId(),webSocketSession.getAttributes().toString());
    }

    @Override
    public void handleMessage(WebSocketSession webSocketSession, WebSocketMessage<?> webSocketMessage) throws Exception {
        System.out.println("message "+webSocketSession.getId()+" "+webSocketMessage.getPayloadLength());
    }

    @Override
    public void handleTransportError(WebSocketSession webSocketSession, Throwable throwable) throws Exception {
        System.out.println("error "+webSocketSession.getId()+" "+throwable.getMessage());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession webSocketSession, CloseStatus closeStatus) throws Exception {
        System.out.println("closed "+webSocketSession.getId()+" "+closeStatus.getCode());
        this.redisTemplate.delete(webSocketSession.getId());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
