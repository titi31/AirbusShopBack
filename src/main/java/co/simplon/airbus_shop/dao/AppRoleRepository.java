package co.simplon.airbus_shop.dao;


import co.simplon.airbus_shop.entities.AppRole;
import co.simplon.airbus_shop.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AppRoleRepository extends JpaRepository<AppRole,Long> {

        public AppRole findByRoleName(String roleName);
}
