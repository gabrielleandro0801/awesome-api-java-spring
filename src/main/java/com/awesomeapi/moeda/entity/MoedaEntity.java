package com.awesomeapi.moeda.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MoedaEntity {
    private String code;
    private String name;
    private Double bid;
}
