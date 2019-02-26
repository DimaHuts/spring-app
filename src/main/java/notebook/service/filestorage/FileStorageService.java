package notebook.service.filestorage;

import notebook.property.FileStorageProperties;
import notebook.service.common.BeanProvider;
import notebook.util.DirCreator;
import notebook.util.FileName;
import notebook.util.FileTransfer;
import notebook.util.LocationConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@Service
public class FileStorageService implements StorageService {
  private final Path targetPath;

  @Override
  public String storeFile(MultipartFile file) {
    DirCreator.create(this.targetPath);

    String normalizedFileName = FileName.normalizeFileName(file.getOriginalFilename());
    Path targetLocation = this.targetPath.resolve(normalizedFileName);

    FileTransfer.transferIntoTargetLocation(file, targetLocation);

    return normalizedFileName;
  }

  public FileStorageService() {
    FileStorageProperties fileStorageProperties = BeanProvider.getBean(FileStorageProperties.class);

    this.targetPath = LocationConverter.resolveFileStorageLocation(fileStorageProperties.getUploadDir());
  }
}
