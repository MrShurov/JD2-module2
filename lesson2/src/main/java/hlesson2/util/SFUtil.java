package hlesson2.util;

import hlesson2.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yslabko on 09/24/2017.
 */
public class SFUtil {
    private static final SessionFactory sessionFactory;
    /*
        SessionFactory initialization
     */
    static {
        StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
        // Hibernate settings equivalent to hibernate.cfg.xml's properties
        Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/lesson2");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "2372002Java");
        settings.put(Environment.HBM2DDL_AUTO, "none");
        settings.put(Environment.SHOW_SQL, "true");
        settings.put(Environment.STORAGE_ENGINE, "innodb");
        // Apply settings
        serviceRegistryBuilder.applySettings(settings);
        // Create registry
        ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
        // Create MetadataSources
        MetadataSources sources = new MetadataSources(serviceRegistry);
        sources.addAnnotatedClass(User.class);
        // Create Metadata
        Metadata metadata = sources.getMetadataBuilder().build();
        // Create SessionFactory
        sessionFactory = metadata.getSessionFactoryBuilder().build();
    }

    public static Session getSession() {
        return sessionFactory.openSession();
    }

    public static void closeSessionFactory() {
        sessionFactory.close();
    }
}
