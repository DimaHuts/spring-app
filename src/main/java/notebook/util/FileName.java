package notebook.util;

import org.springframework.util.StringUtils;

public interface FileName {
  static String normalizeFileName(String originalFileName) {
    return StringUtils.cleanPath(originalFileName);
  }
}
