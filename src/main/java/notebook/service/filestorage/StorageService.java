package notebook.service.filestorage;

import org.springframework.web.multipart.MultipartFile;

public interface StorageService {
  void store(MultipartFile file);
}
