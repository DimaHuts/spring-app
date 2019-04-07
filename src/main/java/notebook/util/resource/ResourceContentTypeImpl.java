package notebook.util.resource;

import notebook.exception.UndefinedResourceContentType;
import org.springframework.core.io.Resource;

import java.nio.file.Files;

public class ResourceContentTypeImpl implements ResourceContentType {
  private Resource resource;

  public ResourceContentTypeImpl(Resource resource) {
    this.resource = resource;
  }

  @Override
  public String getContentType() {
    try {
      return this.tryToGetContentType();
    }
    catch (Exception e) {
      throw new UndefinedResourceContentType(e);
    }
  }

  private String tryToGetContentType() throws Exception {
    String contentType;
    try {
      contentType = Files.probeContentType(resource.getFile().toPath());
    } catch (RuntimeException e) {
      throw new UndefinedResourceContentType(e);
    }

    return contentType;
  }
}
