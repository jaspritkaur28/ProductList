package com.ProductList.Product.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponseDTO {

    private String apiPath;
    private HttpStatus HttpsStatus;
    private String errorMessage;
    private LocalDateTime timestamp;

}
