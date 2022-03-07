package team.world.trade.commerce.application.payload;


public class CommerceResponse {

    private final String name;
    private final Integer price;
    private final String detail;

    private CommerceResponse(String name, Integer price, String detail) {
        this.name = name;
        this.price = price;
        this.detail = detail;
    }

    public static CommerceResponse of(String name, Integer price, String detail) {
        return new CommerceResponse(name, price, detail);
    }
}