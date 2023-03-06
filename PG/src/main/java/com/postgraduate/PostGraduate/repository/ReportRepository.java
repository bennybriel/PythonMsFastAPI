package com.postgraduate.PostGraduate.repository;

import com.postgraduate.PostGraduate.model.Report;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String>
{

}
