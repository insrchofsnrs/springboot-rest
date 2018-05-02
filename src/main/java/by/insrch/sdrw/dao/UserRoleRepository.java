package by.insrch.sdrw.dao;

import by.insrch.sdrw.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<Role, Long> {

    Role findUserRoleByRoleEquals(String string);
    Role findRoleById(Long id);
}
