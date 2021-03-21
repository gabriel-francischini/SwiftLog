package br.com.ies.bd;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import org.reflections.Reflections;
import javax.persistence.Table;
import java.util.Set;


public class HibernateConfig {
  private static Configuration configuration;
  private static SessionFactory sessionFactory;
  private static ServiceRegistry serviceRegistry;

  static {
    try {
      serviceRegistry = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
      configuration = new Configuration();
      sessionFactory = configuration.buildSessionFactory(serviceRegistry);
    } catch (Exception e) {
      e.printStackTrace();
      throw new ExceptionInInitializerError(e);
    }
  }

  public static SessionFactory getSessionFactory() {
    return sessionFactory;
  }
  public static Session getSessão() {
    return sessionFactory.getCurrentSession();
  }
  public static int salvar(Object obj) {
    Transaction transaction = getSessão().beginTransaction();
    int id = (Integer) getSessão().save(obj);
    transaction.commit();
    return id;
  }

  // veja: https://stackoverflow.com/questions/1262723/using-hibernate-hql-to-truncate-a-table
  public static void limparTabela(String nomeTabela){
    // Toda tabela tem um nome, se a tabela não tem nome então não podemos deletá-la
    if (nomeTabela.isBlank()) return;

    // Não podemos usar TRUNCATE aqui pois o SQLite3 não suporta truncate, mas o delete faz o mesmo serviço.
    String comandoSQL = String.format("delete from %s", nomeTabela);
    Transaction transaction = getSessão().beginTransaction();
    getSessão().createSQLQuery(comandoSQL).executeUpdate();
    transaction.commit();
  }

  public static void limparBD() {
    // Busca todas as classes anotadas com javax.persistence.Table
    // veja: https://stackoverflow.com/questions/13128552/how-to-scan-classes-for-annotations/56339680
    Reflections reflections = new Reflections("br.com.ies");
    Set<Class<?>> classesAnotadasComTable = reflections.getTypesAnnotatedWith(Table.class);

    for (Class<?> classe : classesAnotadasComTable) {
      Table entityDoHibernate = classe.getAnnotation(Table.class);
      String nomeDaTabela = entityDoHibernate.name();
      limparTabela(nomeDaTabela);
    }
  }
}
