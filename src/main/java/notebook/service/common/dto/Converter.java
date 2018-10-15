package notebook.service.common.dto;

import org.modelmapper.ModelMapper;

public interface Converter {
  static <T, C> C convert(T initialObject, Class<C> beanName) {
    ModelMapper modelMapper = new ModelMapper();
    return modelMapper.map(initialObject, beanName);
  }
}
