package util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Tạo Configuration và đọc file hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Lỗi khi khởi tạo SessionFactory");
           return null;
        }
    }

    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }

    public static void shutdown() {
        if (SESSION_FACTORY != null) {
            SESSION_FACTORY.close();
        }
    }
}
