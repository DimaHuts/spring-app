package notebook.util;

import notebook.exception.FileStorageException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public abstract class FileTransfer {
  public static void transferIntoTargetLocation(MultipartFile file, Path targetLocation) {
    try {
      tryToTransferIntoTargetLocation(file, targetLocation);
    } catch (IOException ex) {
      throw new FileStorageException("Could not store file " + file.getOriginalFilename() + ". Please try again!", ex);
    }
  }

  private static void tryToTransferIntoTargetLocation(MultipartFile file, Path targetLocation) throws IOException {
    Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
  }
}
