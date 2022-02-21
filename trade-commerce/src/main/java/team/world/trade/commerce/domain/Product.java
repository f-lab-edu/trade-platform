package team.world.trade.commerce.domain;

import java.util.Set;

public class Product {

    private Long id;
    private Set<Category> categories;
    private String name;
    private Integer price;
    private String detail;

    public Product() {
    }

    public Product(String name, Integer price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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
