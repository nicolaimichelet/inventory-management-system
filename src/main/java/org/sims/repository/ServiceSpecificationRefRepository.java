package org.sims.repository;

import org.sims.model.ServiceSpecificationRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceSpecificationRefRepository extends JpaRepository<ServiceSpecificationRef, Long> {
}
