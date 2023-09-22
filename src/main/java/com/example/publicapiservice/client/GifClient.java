package com.example.publicapiservice.client;

import com.example.publicapiservice.dto.gif.GetGifResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "gifclient", url = "${service.gifs.url}")
public interface GifClient {

    @GetMapping
    ResponseEntity<GetGifResponseDto> getGif(@RequestParam String api_key
            , @RequestParam String q
            , @RequestParam String limit
            , @RequestParam String offset
            , @RequestParam String bundle);
}
