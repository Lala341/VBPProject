package com.inHealth.server.repository;

import com.inHealth.server.model.DistanceKPI;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceKPIRepository extends MongoRepository<DistanceKPI, String> {
}
