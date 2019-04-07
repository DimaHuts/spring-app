package notebook.exception;

public class UndefinedResourceContentType extends RuntimeException {
  public UndefinedResourceContentType(Throwable cause) {
    super("Undefined resource type", cause);
  }
}
