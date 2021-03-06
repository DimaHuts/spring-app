package notebook.service.filestorage;

import notebook.exception.FileNotFoundException;
import notebook.property.FileStorageProperties;
import notebook.service.common.BeanProvider;
import notebook.util.*;
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

    String originalFileName = file.getOriginalFilename();
    Path targetLocation = FileResolver.resolveFileForLocation(this.targetPath, originalFileName);

    FileTransfer.transferIntoTargetLocation(file, targetLocation);

    return originalFileName;
  }

  private Resource getFile(String fileName) throws MalformedURLException {
    Path filePath = FileResolver.resolveFileForLocation(this.targetPath, fileName);

    Resource resource = new UrlResource(filePath.toUri());
    if(resource.exists()) {
      return resource;
    } else {
      throw new MalformedURLException ();
    }
  }

  @Override
  public Resource tryToGetFile(String fileName) {
    try {
      return this.getFile(fileName);
    } catch (MalformedURLException ex) {
      throw new FileNotFoundException("File not found " + fileName, ex);
    }
  }
}
