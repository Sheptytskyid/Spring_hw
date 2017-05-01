package ua.petshop.dao;

import org.springframework.data.repository.CrudRepository;
import ua.petshop.model.Role;

public interface RolesDao extends CrudRepository<Role, Long> {

}
