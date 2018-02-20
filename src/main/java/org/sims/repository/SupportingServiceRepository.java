package org.sims.repository;

import org.sims.model.SupportingResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportingServiceRepository extends JpaRepository<SupportingResource, Long> {
}
