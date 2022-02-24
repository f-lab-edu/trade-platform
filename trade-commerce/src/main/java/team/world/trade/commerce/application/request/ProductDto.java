package team.world.trade.commerce.application.request;

public class ProductDto {

    private String name;
    private Integer price;
    private String detail;
    
    public ProductDto() {
    }

    public ProductDto(String name, Integer price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
