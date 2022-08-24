package com.packtpub.micronaut.service;

import com.packtpub.micronaut.domain.Visit;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;

import java.util.Optional;

public interface VisitService {
    Visit save(Visit visit);
    Page<Visit> findAll(Pageable pageable);
    Optional<Visit> findOne(Long id);
    void delete(long id);
}
