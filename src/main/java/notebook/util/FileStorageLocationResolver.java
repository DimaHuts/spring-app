package notebook.util;

import notebook.property.FileStorageProperties;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface FileStorageLocationResolver {
  static Path resolveFileStorageLocation() {
    FileStorageProperties fileStorageProperties = new FileStorageProperties();

    return Paths.get(fileStorageProperties.getUploadDir())
      .toAbsolutePath().normalize();
  }
}
