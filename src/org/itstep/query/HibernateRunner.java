package org.itstep.query;

import entity.CommentEntity;
import entity.PassportEntity;
import entity.ProductEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateRunner {

    public static void main(String[] args) {
        Configuration conf = new Configuration().configure("hibernate.cfg.xml");
        StandardServiceRegistryBuilder builder = new
                StandardServiceRegistryBuilder().applySettings(conf.getProperties());
        SessionFactory sessionFactory = conf.buildSessionFactory(builder.build());

        //SessionFactory sessionFactory=new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();


        session.beginTransaction();
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName("product");
        productEntity.setPrice(1);
        session.save(productEntity);
        session.getTransaction().commit();

/*
        session.beginTransaction();
        Query query = session.createQuery("from entity.PassportEntity where id = :paramId");
        query.setParameter("paramId", 2);
        List list = query.list();
        list.stream().forEach(o -> System.out.println(((PassportEntity) o).getNumber()));
        session.getTransaction().commit();
*/


        session.close();

    }
}
