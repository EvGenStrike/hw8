package ru.petryakov.NauJava.dao;

import jakarta.persistence.criteria.Join;
import ru.petryakov.NauJava.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findByName(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        query.select(user).where(cb.equal(user.get("name"), name));
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<User> findByRole(String roleTitle) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> user = query.from(User.class);
        Join<Object, Object> role = user.join("role");
        query.select(user).where(cb.equal(role.get("title"), roleTitle));
        return entityManager.createQuery(query).getResultList();
    }
}
