package team.world.trade.commerce.infrastructure.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import team.world.trade.commerce.domain.Image;

@Mapper
public interface ImageMapper {

    void insert(Image image);

    List<Image> findByProductId(Long id);
}
