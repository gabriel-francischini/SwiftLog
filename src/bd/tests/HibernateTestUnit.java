package bd.tests;

import org.junit.Before;
import bd.HibernateConfig;

// Essa classe aqui só avisa o JUnit para limpar o banco antes de rodar qualquer teste que interaja com o banco.
public class HibernateTestUnit {
    @Before
    public void limpar(){
        HibernateConfig.limparBD();
    }
}
