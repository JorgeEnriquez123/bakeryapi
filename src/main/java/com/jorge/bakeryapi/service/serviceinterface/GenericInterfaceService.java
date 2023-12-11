package com.jorge.bakeryapi.service.serviceinterface;

import java.util.List;
import java.util.Optional;

public interface GenericInterfaceService<T, D>{
    List<T> findAll();
    T findById(Long id);
    T save(D dto);
    T updateInfo(D dto, Long id);
    void delete(Long id);
}
