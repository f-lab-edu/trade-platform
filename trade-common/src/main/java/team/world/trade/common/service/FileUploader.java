package team.world.trade.common.service;

import java.io.IOException;
import org.springframework.web.multipart.MultipartFile;
import team.world.trade.common.service.payload.UploadFile;

public interface FileUploader {

    UploadFile save(MultipartFile multipartFile) throws IOException;

}
