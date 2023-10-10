package com.session14.productCatalog;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductStockUpdateDto {
    private Long productId;
    private int qty;
}
