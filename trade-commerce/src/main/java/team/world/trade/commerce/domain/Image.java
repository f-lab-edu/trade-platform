package team.world.trade.commerce.domain;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public abstract class Image {

    private Long id;
    private Long productId;
    private String path;
    private LocalDate uploadTime;

    public Image(Long productId, String path) {
        this.productId = productId;
        this.path = path;
        this.uploadTime = LocalDate.now();
    }

    abstract String getUrl();

    abstract Boolean hasThumbnail();

    abstract String getThumbnailUrl();
}
