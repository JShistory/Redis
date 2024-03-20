//package com.study.redistest;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import java.util.List;
//
//@RequiredArgsConstructor
//@Controller
//public class RedisControllerV2 {
//    private final RedisTemplate<String, String> redisTemplate;
//    private final ChatService chatService;
//
//    @GetMapping("/room")
//    public String room(){
//        return "room/room";
//    }
//
//
//    @PostMapping("/send")
//    public void sendMessage(@RequestBody ChatMessage message) {
//        chatService.sendMessage(message);
//    }
//
//    @GetMapping("/messages")
//    public List<Object> getAllMessages() {
//        return chatService.getAllMessages();
//    }
//}
