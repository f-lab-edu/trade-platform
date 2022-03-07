package team.world.trade.commerce.application.payload;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import team.world.trade.commerce.domain.Product;

@Getter
public class ProductCategoryResponse {

    private String productName;
    private Integer price;
    private String detail;

    private ProductCategoryResponse(String productName, Integer price, String detail) {
        this.productName = productName;
        this.price = price;
        this.detail = detail;
    }

    public static ProductCategoryResponse of(String productName,
                                             Integer price,
                                             String detail) {
        return new ProductCategoryResponse(productName, price, detail);
    }

    public static List<ProductCategoryResponse> convert(List<Product> p) {
        List<ProductCategoryResponse> response = new ArrayList<>();
        for (Product product : p) {
            response.add(ProductCategoryResponse.of(product.getName(),
                    product.getPrice(),
                    product.getDetail()));
        }
        return response;
    }
}
