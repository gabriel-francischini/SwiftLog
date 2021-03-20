package br.com.ies.padrõesdeprojeto;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

import br.com.ies.padrõesdeprojeto.Observável0;
import br.com.ies.padrõesdeprojeto.Observador0;

public class Observador0Test
{
    public Integer variávelAfetada;
    Observável0 meuEvento;

    public Observador0Test() {
        variávelAfetada = null;
        meuEvento = null;
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        variávelAfetada = 0;
        meuEvento = new Observável0();

        Observador0 minha_função = () -> {
            this.variávelAfetada = 10;
        };

        meuEvento.registrar(minha_função);
        meuEvento.notificar();

        assertTrue(variávelAfetada == 10);

        assertTrue( true );
    }
}

