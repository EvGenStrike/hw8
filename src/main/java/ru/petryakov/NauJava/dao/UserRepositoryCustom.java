package ru.petryakov.NauJava.dao;

import ru.petryakov.NauJava.entity.User;
import java.util.List;

public interface UserRepositoryCustom {
    List<User> findByName(String name);
    List<User> findByRole(String roleTitle);
}
