package team.world.trade.commerce.application.payload;

import java.util.List;
import lombok.Getter;

@Getter
public class ResponseItems<T> {
    private List<T> items;

    public ResponseItems(
            List<T> items) {
        this.items = items;
    }

}
