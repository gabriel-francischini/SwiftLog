package br.com.ies.bd.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.ies.bd.tests.HibernateTestUnit;
import br.com.ies.bd.HibernateConfig;

public class HibernateTest extends HibernateTestUnit {

    @Test
    public void testInsertUser() {
        br.com.ies.bd.ExemploTabela user = new br.com.ies.bd.ExemploTabela("Robb", "Stark", 17);

        HibernateConfig.salvar(user);

        assertTrue(true);
    }
}
