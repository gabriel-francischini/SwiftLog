package br.com.ies.padrõesdeprojeto;
import java.util.*;

import br.com.ies.padrõesdeprojeto.Observador0;

public class Observável0 {
    private ArrayList<Observador0> callbacks;

    public void registrar(Observador0 código){
        callbacks.add(código);
    }

    public void notificar(){
        for (Observador0 função : callbacks) {
            função.notificar();
        }
    }

    public Observável0() {
        this.callbacks = new ArrayList<Observador0>();

    }
}