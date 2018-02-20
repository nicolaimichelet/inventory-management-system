package org.sims.repository;

import org.sims.model.RelatedPartyRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RelatedPartyRefRepository extends JpaRepository<RelatedPartyRef, Long>{
}
