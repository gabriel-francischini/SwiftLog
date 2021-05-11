package padrõesdeprojeto.observador.tests;

import org.junit.Test;
import static org.junit.Assert.assertTrue;
import padrõesdeprojeto.observador.Evento1Args;
import padrõesdeprojeto.observador.Observador1;

public class Observador1IntegerTest
{
    public Integer variávelAfetada;
    Evento1Args<Integer> meuEvento;


    public Observador1IntegerTest() {
        variávelAfetada = null;
        meuEvento = null;
    }


    @Test
    public void shouldAnswerWithTrue()
    {
        variávelAfetada = 0;
        meuEvento = new Evento1Args<Integer>();

        Observador1<Integer> minha_função = (Integer x) -> {
            this.variávelAfetada = x * 2;
        };

        meuEvento.registrar(minha_função);
        meuEvento.broadcast(10);

        assertTrue(variávelAfetada == 20);

        assertTrue( true );
    }
}

