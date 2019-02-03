package notebook.util;

import org.springframework.util.StringUtils;

public abstract class FileName {
  public static String normalizeFileName(String originalFileName) {
    return StringUtils.cleanPath(originalFileName);
  }
}
