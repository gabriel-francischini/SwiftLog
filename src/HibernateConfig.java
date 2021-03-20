import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
// import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateConfig {

  private static SessionFactory sessionFactory;

  private static ServiceRegistry serviceRegistry;

  // static { }

  private static void ConstrutorManual(){
    if ( sessionFactory == null ) {
      try {
        serviceRegistry =
                new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        // Metadata metaData = new MetadataSources(standardRegistry).getMetadataBuilder().build();
        // sessionFactory = metaData.getSessionFactoryBuilder().build();

      /*sessionFactory = new MetadataSources( serviceRegistry )
              .buildMetadata()
              .buildSessionFactory();*/

        sessionFactory = new Configuration().buildSessionFactory(serviceRegistry);


      } catch (Exception e) {
        e.printStackTrace();
        throw new ExceptionInInitializerError(e);
      }
    }
  }

  public static SessionFactory getSessionFactory() {
    ConstrutorManual();
    return sessionFactory;
  }
  public static Session getSessão() {
    ConstrutorManual();
    return sessionFactory.getCurrentSession();
  }
  public static int salvar(Object obj) {
    ConstrutorManual();
    Transaction transaction = getSessão().beginTransaction();
    int id = (Integer) getSessão().save(obj);
    transaction.commit();
    return id;
  }
}
