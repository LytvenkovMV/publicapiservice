package com.example.publicapiservice.client;

import com.example.publicapiservice.dto.BoredDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "boredclient", url = "${service.bored.url}")
public interface BoredClient {

    @GetMapping
    ResponseEntity<BoredDto> getBored(@RequestParam(required = false) String type);
}
