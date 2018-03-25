package org.sims.demo.repository;

import java.util.List;
import org.sims.demo.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    List<Service> findByCategory(String var1);

    List<Service> findByNameAndHrefAndCategory(String var1, String var2, String var3);
}
