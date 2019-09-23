package co.simplon.airbus_shop.dao;

import co.simplon.airbus_shop.entities.Products;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")
@RepositoryRestResource

public interface ProductRepository extends JpaRepository<Products,Long> {
   /* @RestResource(path="/byDesignation")
    List<Products> findByDesignationContains(@Param("mc") String mc);
    @RestResource(path="/byDesignationPage")
    Page<Products> findByDesignationContains(@Param("mc") String mc, Pageable pageable);
*/
}
