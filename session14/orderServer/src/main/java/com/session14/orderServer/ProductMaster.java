package com.session14.orderServer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductMaster {
    private Long id;
    private String name;
    private int quantity;
    private Double amount;
}
