package notebook.controller;

import notebook.service.common.BeanProvider;
import notebook.service.filestorage.StorageService;
import notebook.util.resource.ResourceContentType;
import notebook.util.resource.ResourceContentTypeImpl;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    StorageService storageService = BeanProvider.getBean(StorageService.class);

    return storageService.storeFile(file);
  }

  @PostMapping("/uploadMultipleFiles")
  public List<String> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
    return Arrays.stream(files)
      .map(this::handleFileUpload)
      .collect(Collectors.toList());
  }

  @GetMapping("/get/{fileName:.+}")
  public ResponseEntity<Resource> getFile(@PathVariable String fileName) {
    StorageService storageService = BeanProvider.getBean(StorageService.class);

    Resource resource = storageService.tryToGetFile(fileName);
    ResourceContentType resourceContentType = new ResourceContentTypeImpl(resource);

    String contentType = resourceContentType.getContentType();

    return ResponseEntity.ok()
      .contentType(MediaType.parseMediaType(contentType))
      .body(resource);
  }
}
