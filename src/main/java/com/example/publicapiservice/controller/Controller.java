package com.example.publicapiservice.controller;

import com.example.publicapiservice.client.BoredClient;
import com.example.publicapiservice.client.CatClient;
import com.example.publicapiservice.client.GifClient;
import com.example.publicapiservice.dto.BoredDto;
import com.example.publicapiservice.dto.CatFactDto;
import com.example.publicapiservice.dto.gif.GetGifResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping
public class Controller {

    @Autowired
    private CatClient catClient;

    @Autowired
    private BoredClient boredClient;

    @Autowired
    private GifClient gifClient;

    @Value("${service.gifs.apikey}")
    private String apiKey;


    @GetMapping(value = "/")
    public ResponseEntity<String> getHello() {

        return new ResponseEntity<>("HELLO!!! This is Public API Service!!!" , HttpStatus.OK);
    }


    @GetMapping(value = "/catfact")
    public ResponseEntity<CatFactDto> getCatFact() {

        return catClient.getCatFact();
    }


    @GetMapping(value = {"/bored", "/bored/{type}"})
    public ResponseEntity<BoredDto> getBored(@PathVariable(required = false) String type) {

        return boredClient.getBored(type);
    }


    @GetMapping(value = {"/gif", "/gif/{qWord}"})
    public ResponseEntity<GetGifResponseDto> getGif(@PathVariable(required = false) String qWord) {

        Random random = new Random();
        Integer num = random.nextInt(99) + 1;

        if (qWord == null) qWord = "anything";

        String limit = "1";
        String offset = num.toString();
        String bundle = "messaging_non_clips";

        ResponseEntity<GetGifResponseDto> response = gifClient.getGif(apiKey, qWord, limit, offset, bundle);

        return ResponseEntity.ok(response.getBody());
    }
}
