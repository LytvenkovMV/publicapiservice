package com.example.publicapiservice.dto.gif;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AnalyticsDto {

    private AnalyticsOnloadDto onload;
    private AnalyticsOnclickDto onclick;
    private AnalyticsOnsentDto onsent;
}
