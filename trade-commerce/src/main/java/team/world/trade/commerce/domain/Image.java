package team.world.trade.commerce.domain;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public abstract class Image {

    private Long id;
    private String path;
    private LocalDate uploadTime;

    public Image(String path) {
        this.path = path;
        this.uploadTime = LocalDate.now();
    }

    abstract String getUrl();

    abstract Boolean hasThumbnail();

    abstract String getThumbnailUrl();
}
