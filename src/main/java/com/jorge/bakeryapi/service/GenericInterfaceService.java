package com.jorge.bakeryapi.service;

import java.util.List;
import java.util.Optional;

public interface GenericInterfaceService<T, D>{
    List<T> findAll();
    Optional<T> findById(Long id);
    T save(D dto);
    T updateInfo(D dto, Long id);
    void delete(Long id);
}
