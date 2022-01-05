package ua.lviv.shved.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.shved.domain.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public User findByUserName(String userName);
}
