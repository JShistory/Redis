package com.study.redistest;

import lombok.RequiredArgsConstructor;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class RedisRepository {
    private final RedisTemplate<String, String> redisTemplate;

    public void save(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String findByKey(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void saveGEO(String key, Point point, String member) {
        redisTemplate.opsForGeo().add(key, point, member);
    }
}
