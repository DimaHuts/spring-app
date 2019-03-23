package notebook.service.filestorage;

import notebook.exception.FileNotFoundException;
import notebook.property.FileStorageProperties;
import notebook.service.common.BeanProvider;
import notebook.util.DirCreator;
import notebook.util.FileName;
import notebook.util.FileTransfer;
import notebook.util.LocationConverter;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.net.MalformedURLException;
import java.nio.file.Path;

@Service
public class FileStorageService implements StorageService {
  private final Path targetPath;

  public FileStorageService() {
    FileStorageProperties fileStorageProperties = BeanProvider.getBean(FileStorageProperties.class);

    this.targetPath = LocationConverter.resolveFileStorageLocation(fileStorageProperties.getUploadDir());
  }

  @Override
  public String storeFile(MultipartFile file) {
    DirCreator.create(this.targetPath);

    String normalizedFileName = FileName.normalizeFileName(file.getOriginalFilename());
    Path targetLocation = this.targetPath.resolve(normalizedFileName);

    FileTransfer.transferIntoTargetLocation(file, targetLocation);

    return normalizedFileName;
  }

  private Resource getFile(String fileName) throws MalformedURLException {
    String normalizedFileName = FileName.normalizeFileName(fileName);
    Path filePath  = this.targetPath.resolve(normalizedFileName);

    return new UrlResource(filePath.toUri());
  }

  @Override
  public Resource tryToGetFile(String fileName) {
    try {
      return this.getFile(fileName);
    } catch (MalformedURLException ex) {
      throw new FileNotFoundException("File not found" + fileName, ex);
    }
  }
}
