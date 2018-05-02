package by.insrch.sdrw.service.impl;

import by.insrch.sdrw.dao.UserRepository;
import by.insrch.sdrw.dao.UserRoleRepository;
import by.insrch.sdrw.exception.EmailExistsException;
import by.insrch.sdrw.pojo.User;
import by.insrch.sdrw.pojo.Role;
import by.insrch.sdrw.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserRoleRepository userRoleRepository;


    @Override
    public void registerNewUserAccount(User user) throws EmailExistsException {

        if (emailExist(user.getEmail())){
            throw new EmailExistsException("There is an account with that email: "+ user.getEmail());
        }

      //  User newUser = new User();
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncoder().encode(user.getPassword()));
        user.setRoles(getRoles("ROLE_USER"));
        userRepository.save(user);

    }

    private PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }

    private Set<Role> getRoles(String role){
        Set<Role> roles = new HashSet<>();
        roles.add(userRoleRepository.findUserRoleByRoleEquals(role));
        return roles;
    }

    private boolean emailExist(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
