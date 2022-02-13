package org.itstep.query;

import entity.CommentEntity;
import entity.PassportEntity;
import entity.ProductEntity;
import entity.UserEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import javax.imageio.spi.ServiceRegistry;
import java.util.List;

public class HibernateRunner {
    private static Session session = null;
    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new
                StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        StandardServiceRegistry registry = builder.build();
        SessionFactory sessionFactory = conf.buildSessionFactory(registry);

        //SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        session = sessionFactory.openSession();

        //addProduct();
        //getUserById(2);

        session.close();
        sessionFactory.close();
        builder.destroy(registry);
    }

    private static void addProduct() {
        session.beginTransaction();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("product3");
        productEntity.setPrice(3);
        session.save(productEntity);
        session.getTransaction().commit();
    }

    private static void getUserById(int id) {
        session.beginTransaction();
        Query query = session.createQuery("from UserEntity where id = :paramId");
        query.setParameter("paramId", id);
        List list = query.list();
        list.stream().forEach(o -> System.out.println(((UserEntity) o).getSurname()));
        session.getTransaction().commit();
    }

    private static void getPassportById(int id) {
        session.beginTransaction();
        Query query = session.createQuery("from PassportEntity where id = :paramId");
        query.setParameter("paramId", id);
        List list = query.list();
        list.stream().forEach(o -> System.out.println(((PassportEntity) o).getNumber()));
        session.getTransaction().commit();
    }
}
