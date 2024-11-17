package com.upc.backapphelp.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DonacionEcoRecaudacionDTO {
    private Long cant;
    private BigDecimal suma;
    //private BigDecimal prom;
}
