package notebook.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public abstract class FileTransfer {
  static void transferIntoTargetLocation(MultipartFile file) throws IOException {
    Path targetLocation = FileStorageLocationResolver.resolveFileStorageLocation();
    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
  }
}
