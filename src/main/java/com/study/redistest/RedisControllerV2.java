package com.study.redistest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class RedisControllerV2 {
    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/room")
    public String room(){
        return "room/room";
    }
}
