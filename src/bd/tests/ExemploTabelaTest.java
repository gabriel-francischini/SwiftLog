package bd.tests;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import bd.tests.HibernateTestUnit;
import bd.HibernateConfig;

import java.math.BigDecimal;

public class ExemploTabelaTest extends HibernateTestUnit {

    @Test
    public void testInsertUser() {
        bd.ExemploTabela user =
                new bd.ExemploTabela("1°", "não-nulo",
                        300,10, new BigDecimal("59.60"), null);

        HibernateConfig.salvar(user);

        assertTrue(true);
    }
}
