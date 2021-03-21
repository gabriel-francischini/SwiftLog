package br.com.ies.bd.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.com.ies.bd.tests.HibernateTestUnit;
import br.com.ies.bd.HibernateConfig;

import java.math.BigDecimal;

public class ExemploTabelaTest extends HibernateTestUnit {

    @Test
    public void testInsertUser() {
        br.com.ies.bd.ExemploTabela user =
                new br.com.ies.bd.ExemploTabela("1°", "não-nulo",
                        300,10, new BigDecimal("59.60"), null);

        HibernateConfig.salvar(user);

        assertTrue(true);
    }
}
