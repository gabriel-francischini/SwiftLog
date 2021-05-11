package padrõesdeprojeto.observador;

import java.util.*;

public class Evento0Args {
    private ArrayList<Listener0Args> callbacks;

    public void addListener(Listener0Args código){
        callbacks.add(código);
    }

    public void broadcast(){
        for (Listener0Args função : callbacks) {
            função.callback();
        }
    }

    public Evento0Args() {
        this.callbacks = new ArrayList<Listener0Args>();
    }
}