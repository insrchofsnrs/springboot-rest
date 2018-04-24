package by.insrch.sdrw.dao;

import by.insrch.sdrw.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail (String email);
}
