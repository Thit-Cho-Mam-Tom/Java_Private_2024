package org.example;

import model.Cat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import util.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            if (sessionFactory != null) {
                Session session = sessionFactory.openSession();
                try {
                    Transaction transaction = session.beginTransaction();
                    Cat cat1 = new Cat();
                    cat1.setName("tom");
                    cat1.setSex(true);
                    session.save(cat1);
                    transaction.commit();
                } catch (Exception e) {
                    e.printStackTrace(); // In chi tiết lỗi
                } finally {
                    session.close();
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // In chi tiết lỗi
            System.out.println("Lỗi khi khởi chạy Hibernate");
        }
    }
}
