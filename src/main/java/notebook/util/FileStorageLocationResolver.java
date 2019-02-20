package notebook.util;

import notebook.property.FileStorageProperties;
import notebook.service.common.BeanProvider;

import java.nio.file.Path;
import java.nio.file.Paths;

abstract class FileStorageLocationResolver {
  static Path resolveFileStorageLocation() {
    FileStorageProperties fileStorageProperties = BeanProvider.getBean(FileStorageProperties.class);

    return Paths.get(fileStorageProperties.getUploadDir())
      .toAbsolutePath().normalize();
  }
}
