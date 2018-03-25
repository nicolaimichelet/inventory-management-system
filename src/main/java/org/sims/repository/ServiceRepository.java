package org.sims.repository;

import org.sims.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>, ServiceRepositoryCustom {

  public Service getByUuid(String uuid);

}
