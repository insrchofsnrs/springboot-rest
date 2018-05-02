package by.insrch.sdrw.service;

import by.insrch.sdrw.exception.EmailExistsException;
import by.insrch.sdrw.pojo.User;
import org.springframework.stereotype.Component;


public interface IUserService {
    void registerNewUserAccount(User user) throws EmailExistsException;
}
