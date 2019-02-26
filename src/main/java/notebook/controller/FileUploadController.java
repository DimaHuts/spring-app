package notebook.controller;

import notebook.service.common.BeanProvider;
import notebook.service.filestorage.StorageService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class FileUploadController {

  @PostMapping("/upload")
  public String handleFileUpload(@RequestParam("file") MultipartFile file) {
    StorageService storageService = BeanProvider.getBean(StorageService.class);

    return storageService.storeFile(file);
  }
}
