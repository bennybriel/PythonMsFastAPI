package com.PostGraduateLog.PostGraduateLog.service;

import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import com.PostGraduateLog.PostGraduateLog.repository.ReqistrationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService {
    private final ReqistrationRepository reqistrationRepository;
    public Page<Registrations> getRegistrationPagination(Integer pageNumber, Integer pageSize, String sortProperty) {
//      Sort sort = Sort.by(Sort.Direction.ASC,"name");
        Pageable pageable= null;
        if(null!=sortProperty)
        {
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC,sortProperty);
        }
        else
        {
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return reqistrationRepository.findAll(pageable);
    }
}
