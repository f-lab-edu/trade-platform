package team.world.trade.commerce.domain;

import java.util.List;

public interface ImageRepository {

    void save(Image image);

    List<Image> findByProductId(Long id);
}
