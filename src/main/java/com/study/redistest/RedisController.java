package com.study.redistest;

import io.lettuce.core.metrics.MetricCollector;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/redis")
@RestController
public class RedisController {
    private final RedisTemplate<String, String> redisTemplate;

    @GetMapping("/{key}")
    public ResponseEntity<Object> getRedisKey(@PathVariable String key) {
        ValueOperations<String, String> valueOperations = redisTemplate.opsForValue();
        String value = valueOperations.get(key);
        log.info(key);
        log.info(value);
        return ResponseEntity.status(HttpStatus.OK).body(value);
    }

    @GetMapping("/redisTest/{key}")
    public ResponseEntity<?> getRedisKey2(@PathVariable String key) {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        String value = vop.get(key);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @PostMapping("/redisTest")
    public ResponseEntity<?> addRedisKey() {
        ValueOperations<String, String> vop = redisTemplate.opsForValue();
        vop.set("yellow", "banana");
        vop.set("red", "apple");
        vop.set("green", "watermelon");
        vop.set("test1123", "aa",10L, TimeUnit.SECONDS );
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/redisGeoTest")
    public ResponseEntity<?> addGeoKey() {
        GeoOperations<String, String> geo = redisTemplate.opsForGeo();
        Point hongdaePoint = new Point(126.923917,37.556944);
        Point gangnamPoint = new Point(127.027583,37.497928);

        geo.add("seoul:station",hongdaePoint,"hong-dae");
        geo.add("seoul:station",gangnamPoint,"gang-nam");

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/redisGeoTest/{key}")
    public ResponseEntity<?> getGeoRedisKey(@PathVariable String key) {
        GeoOperations<String, String> geo = redisTemplate.opsForGeo();
        Distance distance = geo.distance(key, "hong-dae", "gang-nam");
        return new ResponseEntity<>(distance.getNormalizedValue(), HttpStatus.OK);
    }


}