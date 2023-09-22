package com.example.publicapiservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoredDto {

    private String activity;
    private String type;
    private Integer participants;
    private Double price;
    private String link;
    private String key;
    private Double accessibility;
}
