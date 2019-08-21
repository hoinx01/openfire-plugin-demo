package vn.dvg.openfire.plugins.autoportal.infrastructure;

import lombok.val;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.jivesoftware.database.DbConnectionManager;

import javax.security.auth.login.Configuration;
import java.util.HashMap;
import java.util.Map;

public class HibernateUtils {
    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static StandardServiceRegistry registry;

    // Hibernate 5:
    private static SessionFactory buildSessionFactory() {
        try {
//            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()//
//                    .configure().build();
//
//            // Tạo nguồn siêu dữ liệu (metadata) từ ServiceRegistry
//            Metadata metadata = new MetadataSources(serviceRegistry).getMetadataBuilder().build();
//
//            val sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//
//            return sessionFactory;

            // Create registry builder
            StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();

            // Hibernate settings equivalent to hibernate.cfg.xml's properties
            Map<String, String> settings = new HashMap<>();
            settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
            settings.put(Environment.URL, "jdbc:mysql://127.0.0.1:3306/openfire-test01?serverTimezone=Europe/Brussels");
            settings.put(Environment.USER, "root");
            settings.put(Environment.PASS, "tulanh92");
            settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");

            // Apply settings
            registryBuilder.applySettings(settings);

            // Create registry
            registry = registryBuilder.build();

            // Create MetadataSources
            MetadataSources sources = new MetadataSources(registry);

            // Create Metadata
            Metadata metadata = sources.getMetadataBuilder().build();

            // Create SessionFactory
            return metadata.getSessionFactoryBuilder().build();
        } catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
//        return sessionFactory;
        return buildSessionFactory();
    }

    public static void shutdown() {
        // Giải phóng cache và Connection Pools.
        getSessionFactory().close();
    }
}
