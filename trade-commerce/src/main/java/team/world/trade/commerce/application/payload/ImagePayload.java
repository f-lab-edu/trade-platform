package team.world.trade.commerce.application.payload;

import java.time.LocalDate;
import lombok.Getter;

@Getter
public class ImagePayload {

    private Long id;
    private String path;
    private LocalDate uploadTime;

    private ImagePayload(Long id, String path, LocalDate uploadTime) {
        this.id = id;
        this.path = path;
        this.uploadTime = uploadTime;
    }

    public static ImagePayload of(Long id, String path, LocalDate uploadTime) {
        return new ImagePayload(id, path, uploadTime);
    }
}
