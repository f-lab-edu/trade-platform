package team.world.trade.common.response;

public enum StatusCode {
    OK(0), BAD(1);

    private int code;

    StatusCode(int code) {
        this.code = code;
    }
}
