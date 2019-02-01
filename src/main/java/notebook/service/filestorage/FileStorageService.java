package notebook.service.filestorage;

import notebook.util.FileName;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService implements StorageService {
  @Override
  public void store(MultipartFile file) {
    String normalizedFileName = FileName.normalizeFileName(file.getOriginalFilename());
  }
}
