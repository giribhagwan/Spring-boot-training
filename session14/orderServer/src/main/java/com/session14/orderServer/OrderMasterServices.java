package com.session14.orderServer;

import com.session14.orderServer.dto.ApiResponseDto;
import com.session14.orderServer.dto.ProductStockUpdateDto;
import com.session14.orderServer.exception.ProductUnAvailableException;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class OrderMasterServices {
    private OrderMasterRepo repo;
    private RestTemplate restTemplate;

    OrderMaster save(OrderMaster orderMaster){
        int availableQut=getProductAvl(orderMaster.getProductId());
        if (availableQut>0) {
            updateStock(orderMaster.getProductId(),orderMaster.getQuantity());
            return repo.save(orderMaster);
        }
        else throw new ProductUnAvailableException("Out of stock");
    }
     Integer getProductAvl(Long id){
         ResponseEntity<ApiResponseDto> response
                 = restTemplate.getForEntity( "http://PRODCUT-CATALOG-SERVICE/api/v1/product/stock/"+id, ApiResponseDto.class);
         if (response.getStatusCode().value()==200){
             try {
                 ApiResponseDto apiResponseDto =  response.getBody();
                 assert apiResponseDto != null;
                 return (Integer) apiResponseDto.getData();
             }catch (Exception e){
                 e.printStackTrace();
                 throw new ProductUnAvailableException(e.getMessage());
             }
         }
         return -1;
     }

     boolean updateStock(Long productId,Integer qty){
         HttpEntity<ProductStockUpdateDto> entity=new HttpEntity<>(ProductStockUpdateDto.builder()
                 .productId(productId)
                 .qty(qty).build());
         ResponseEntity<ApiResponseDto> response
                 = restTemplate.exchange( "http://PRODCUT-CATALOG-SERVICE/api/v1/product/stock", HttpMethod.POST,entity,ApiResponseDto.class);
         return response.getStatusCode().value() == 200;
     }

}
