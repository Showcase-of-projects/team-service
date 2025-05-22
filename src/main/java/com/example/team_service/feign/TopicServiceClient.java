package com.example.team_service.feign;

import com.example.team_service.dtos.ExistenceResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "topic-service")
public interface TopicServiceClient {
    @GetMapping("/topics/check-existence/{id}")
    ResponseEntity<ExistenceResponse> checkExistence(@PathVariable("id") Long id);
}
