package org.itstep.query;

import entity.CommentEntity;
import entity.PassportEntity;
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

        /*
        PassportEntity passportEntity = new PassportEntity();
        passportEntity.setNumber("2333");
        session.save(passportEntity);

         */


        session.beginTransaction();
        Query query = session.createQuery("from entity.PassportEntity where id = :paramId");
        query.setParameter("paramId", 1);
        List list = query.list();

        list.stream().forEach(o -> System.out.println(((PassportEntity) o).getNumber()));

        session.getTransaction().commit();

        session.close();

    }
}
