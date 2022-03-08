package team.world.trade.commerce.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import team.world.trade.commerce.application.exception.FileNotStoreException;
import team.world.trade.commerce.application.payload.CommerceIdResponse;
import team.world.trade.commerce.domain.ExternalImage;
import team.world.trade.commerce.domain.ImageRepository;
import team.world.trade.common.service.FileUploader;
import team.world.trade.common.service.payload.UploadFile;

@Service
public class CommerceImageService {
    private static final Logger logger = LoggerFactory.getLogger(CommerceImageService.class);

    private final ImageRepository imageRepository;
    private final FileUploader fileUploader;

    public CommerceImageService(ImageRepository imageRepository,
                                FileUploader fileUploader) {
        this.imageRepository = imageRepository;
        this.fileUploader = fileUploader;
    }

    public CommerceIdResponse store(final Long productId, MultipartFile multipartFile) {
        try {
            UploadFile storeFile = fileUploader.save(multipartFile);
            ExternalImage image = new ExternalImage(productId, storeFile.getStoreFileName());
            imageRepository.save(image);
            return CommerceIdResponse.of(productId);
        } catch (Exception e) {
            logger.error("fail to store the file : name={}, exception={}",
                    multipartFile.getOriginalFilename(), e.getMessage());
            throw new FileNotStoreException("Could not store the file.");
        }
    }

}
