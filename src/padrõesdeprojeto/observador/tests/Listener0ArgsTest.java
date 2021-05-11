package padrõesdeprojeto.observador.tests;


import org.junit.Test;
import padrõesdeprojeto.observador.Evento0Args;
import padrõesdeprojeto.observador.Listener0Args;

import static org.junit.Assert.assertTrue;

public class Listener0ArgsTest
{
    public Integer variávelAfetada;
    Evento0Args meuEvento;

    public Listener0ArgsTest() {
        variávelAfetada = null;
        meuEvento = null;
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        variávelAfetada = 0;
        meuEvento = new Evento0Args();

        Listener0Args minha_função = () -> {
            this.variávelAfetada = 10;
        };

        meuEvento.addListener(minha_função);
        meuEvento.broadcast();

        assertTrue(variávelAfetada == 10);

        assertTrue( true );
    }
}

