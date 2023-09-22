package com.example.publicapiservice.client;

import com.example.publicapiservice.dto.CatFactDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "catclient", url = "${service.cats.url}")
public interface CatClient {

    @GetMapping
    ResponseEntity<CatFactDto> getCatFact();
}