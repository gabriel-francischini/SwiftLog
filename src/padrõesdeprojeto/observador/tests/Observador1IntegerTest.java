package br.com.ies.padrõesdeprojeto;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.com.ies.padrõesdeprojeto.Observável1;
import br.com.ies.padrõesdeprojeto.Observador1;

public class Observador1IntegerTest
{
    public Integer variávelAfetada;
    Observável1<Integer> meuEvento;


    public Observador1IntegerTest() {
        variávelAfetada = null;
        meuEvento = null;
    }


    @Test
    public void shouldAnswerWithTrue()
    {
        variávelAfetada = 0;
        meuEvento = new Observável1<Integer>();

        Observador1<Integer> minha_função = (Integer x) -> {
            this.variávelAfetada = x * 2;
        };

        meuEvento.registrar(minha_função);
        meuEvento.notificar(10);

        assertTrue(variávelAfetada == 20);

        assertTrue( true );
    }
}

