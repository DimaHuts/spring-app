package notebook.service.filestorage;

import notebook.util.FileName;
import notebook.util.FileTransfer;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileStorageService implements StorageService {
  @Override
  public String tryToStore(MultipartFile file) {
    try {
      return this.store(file);
    } catch (IOException ex) {
      return "";
    }
  }

  private String store(MultipartFile file) throws IOException {
    String normalizedFileName = FileName.normalizeFileName(file.getOriginalFilename());

    FileTransfer.transferIntoTargetLocation(file);

    return normalizedFileName;
  }
}
