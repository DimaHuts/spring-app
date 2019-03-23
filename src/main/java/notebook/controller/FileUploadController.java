package notebook.controller;

import notebook.service.common.BeanProvider;
import notebook.service.filestorage.StorageService;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    StorageService storageService = BeanProvider.getBean(StorageService.class);

    return storageService.storeFile(file);
  }

  @GetMapping("/get/{fileName:.+}")
  public ResponseEntity<Resource> getFile(@PathVariable String fileName, HttpServletRequest request) {
    StorageService storageService = BeanProvider.getBean(StorageService.class);

    Resource resource = storageService.tryToGetFile(fileName);

    String contentType = null;
    try {
      contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
    } catch (IOException e) {
      e.printStackTrace();
    }

    if(contentType == null) {
      contentType = "application/octet-stream";
    }

    return ResponseEntity.ok()
      .contentType(MediaType.parseMediaType(contentType))
      .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
      .body(resource);
  }
}
