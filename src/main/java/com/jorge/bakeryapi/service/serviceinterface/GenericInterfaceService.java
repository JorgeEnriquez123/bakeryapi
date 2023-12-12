package com.jorge.bakeryapi.service.serviceinterface;

import java.util.List;

public interface GenericInterfaceService<T, D>{
    List<T> findAll();
    T findById(Long id);
    T save(D dto);
    T updateInfo(D dto, Long id);
    T enable(Long id);
    T disable(Long id);


}
