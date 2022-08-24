package com.packtpub.micronaut.service.impl;

import com.packtpub.micronaut.domain.Visit;
import com.packtpub.micronaut.repository.VisitRepository;
import com.packtpub.micronaut.service.VisitService;
import io.micronaut.data.model.Page;
import io.micronaut.data.model.Pageable;
import io.micronaut.transaction.annotation.ReadOnly;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.transaction.Transactional;
import java.util.Optional;

@Singleton
@Transactional
public class VisitServiceImpl implements VisitService {
    private final Logger log = LoggerFactory.getLogger(VisitServiceImpl.class);
    private final VisitRepository visitRepository;

    public VisitServiceImpl(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    @Override
    public Visit save(Visit visit) {
        log.debug("Request to Save Visit: {}", visit);
        return visitRepository.margeAndSave(visit);
    }

    @Override
    @ReadOnly
    @Transactional
    public Page<Visit> findAll(Pageable pageable) {
        log.debug("Request to get all visits");
        return visitRepository.findAll(pageable);
    }

    @Override
    public Optional<Visit> findOne(Long id) {
        log.debug("Request to get Visit : {}",id);
        return visitRepository.findById(id);
    }

    @Override
    public void delete(long id) {
        log.debug("Request to delete Visit: {}", id);
        visitRepository.deleteById(id);
    }
}
