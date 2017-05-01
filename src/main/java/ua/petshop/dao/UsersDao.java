package ua.petshop.dao;

import org.springframework.data.repository.CrudRepository;
import ua.petshop.model.User;

public interface UsersDao extends CrudRepository<User, Long> {
    User findByUserName(String UserName);
}
