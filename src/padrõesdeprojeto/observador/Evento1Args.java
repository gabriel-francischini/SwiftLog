package padrõesdeprojeto.observador;
import java.util.*;

import padrõesdeprojeto.observador.Observador1;

public class Evento1Args<ArgType> {
    private final ArrayList<Observador1<ArgType>> callbacks;

    public void registrar(Observador1<ArgType> código){
        callbacks.add(código);
    }

    public void broadcast(ArgType argumento){
        for (Observador1<ArgType> função : callbacks) {
            função.notificar(argumento);
        }
    }

    public Evento1Args() {
        this.callbacks = new ArrayList<Observador1<ArgType>>();

    }
}