package notebook.service.common.dto;

import org.modelmapper.ModelMapper;

public interface Converter {
  static <T, C> Object convert(T initialObject, C objectDto) {
    return (new ModelMapper()).map(initialObject, objectDto.getClass());
  }
}
