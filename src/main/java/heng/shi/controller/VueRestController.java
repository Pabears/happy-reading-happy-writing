package heng.shi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class VueRestController {
    @Autowired
    private SimpMessagingTemplate template;

    public void sendToAll(String message) {
        template.convertAndSend("/topic/greetings", message); //广播
    }

    public void sendToOne(String userId, String message) {
        template.convertAndSendToUser(userId, "/message", message); //一对一发送，发送特定的客户端
    }

    @RequestMapping(value = "/hello/")
    public String index(String title) {
        return title + new Date();
    }

    @MessageMapping("/hello")
    public void greeting(String name) throws Exception {
        sendToAll(name);
    }

    @MessageMapping("/message")
    public void userMessage(String userID, String userMessage) throws Exception {
        sendToOne(userID, userMessage);
    }

}
