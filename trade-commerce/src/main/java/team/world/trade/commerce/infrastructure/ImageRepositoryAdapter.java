package team.world.trade.commerce.infrastructure;

import java.util.List;

import org.springframework.stereotype.Component;

import team.world.trade.commerce.domain.Image;
import team.world.trade.commerce.domain.ImageRepository;
import team.world.trade.commerce.infrastructure.mybatis.ImageMapper;

@Component
public class ImageRepositoryAdapter implements ImageRepository {

    private final ImageMapper imageMapper;

    public ImageRepositoryAdapter(ImageMapper imageMapper) {
        this.imageMapper = imageMapper;
    }

    @Override
    public void save(Image image) {
        imageMapper.insert(image);
    }

    @Override
    public List<Image> findByProductId(Long id) {
        return imageMapper.findByProductId(id);
    }
}
