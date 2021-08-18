package repository;

import moduls.Blog;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

public class BlogRepo implements IBlogRepo {
    @Autowired
    EntityManager entityManager;


    @Override
    public Blog save(Blog blog) {
        EntityTransaction txn = entityManager.getTransaction();
        txn.begin();
        entityManager.persist(blog);
        txn.commit();
        return blog;
    }

    @Override
    public ArrayList<Blog> findAll() {
        String hql = "Select b from Blog as b";
        TypedQuery<Blog> query = entityManager.createQuery(hql, Blog.class);
        return (ArrayList<Blog>) query.getResultList();
    }

    @Override
    public Blog findByName(String name) {
        TypedQuery<Blog> query = entityManager.createQuery("select c from Blog as c where  c.name=:name", Blog.class);
        query.setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public void Delete(Blog blog) {
        entityManager.getTransaction().begin();
        entityManager.remove(blog);
        entityManager.getTransaction().commit();
    }

    @Override
    public void edit(Blog blog) {
        entityManager.getTransaction().begin();
        entityManager.merge(blog);
        entityManager.getTransaction().commit();
    }
}
