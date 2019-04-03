package notebook.util;

import java.nio.file.Path;

public final class FileResolver {
  public static Path resolveFileForLocation(Path targetLocation, String fileName) {
    String normalizedFileName = FileName.normalizeFileName(fileName);
    return targetLocation.resolve(normalizedFileName);
  }
}
