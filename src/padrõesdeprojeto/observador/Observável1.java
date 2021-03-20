package br.com.ies.padrõesdeprojeto;
import java.util.*;

import br.com.ies.padrõesdeprojeto.Observador1;

public class Observável1<ArgType> {
    private ArrayList<Observador1<ArgType>> callbacks;

    public void registrar(Observador1<ArgType> código){
        callbacks.add(código);
    }

    public void notificar(ArgType argumento){
        for (Observador1<ArgType> função : callbacks) {
            função.notificar(argumento);
        }
    }

    public Observável1() {
        this.callbacks = new ArrayList<Observador1<ArgType>>();

    }
}