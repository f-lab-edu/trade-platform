package team.world.trade.user.response;

import lombok.Getter;

@Getter
public class ResponseApi<T> {

    private StatusCode statusCode;
    private T data;
    private String message;

    public ResponseApi(StatusCode statusCode, T data, String message) {
        this.statusCode = statusCode;
        this.data = data;
        this.message = message;
    }

    public static <T> ResponseApi<T> success(T data) {
        return new ResponseApi<>(StatusCode.OK, data, null);
    }

    public static <T> ResponseApi<T> error(String message) {
        return new ResponseApi<>(StatusCode.BAD, null, message);
    }
}
