package com.study.redistest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.geo.Point;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/redis")
@RestController
public class RedisController {
    private final RedisService redisService;
    @GetMapping("/{key}")
    public ResponseEntity<Object> getRedisKey(@PathVariable String key) {
        String value = redisService.findById(key);
        log.info(key);
        log.info(value);
        return ResponseEntity.status(HttpStatus.OK).body(value);
    }

    @GetMapping("/redisTest/{key}")
    public ResponseEntity<?> getRedisKey2(@PathVariable String key) {
        String value = redisService.findById(key);
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

    @PostMapping("/redisTest")
    public ResponseEntity<?> addRedisKey(@RequestBody RedisSaveDTO dto) {
        redisService.save(dto.getKey(), dto.getValue());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/redisGeoTest")
    public ResponseEntity<?> addGeoKey(@RequestBody GeoDTO geoDTO) {
        Point point1 = new Point(geoDTO.getM1_x(),geoDTO.getM1_y());
        Point point2 = new Point(geoDTO.getM2_x(),geoDTO.getM2_y());
        redisService.saveGEO(geoDTO.getKey(), point1, geoDTO.getMember1());
        redisService.saveGEO(geoDTO.getKey(), point2, geoDTO.getMember2());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }




}