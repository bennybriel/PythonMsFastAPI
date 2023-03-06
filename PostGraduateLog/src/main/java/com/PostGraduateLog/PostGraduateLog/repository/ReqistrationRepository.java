package com.PostGraduateLog.PostGraduateLog.repository;

import com.PostGraduateLog.PostGraduateLog.model.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

public interface ReqistrationRepository extends JpaRepository<Registrations, String> {

}
