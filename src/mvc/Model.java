package br.com.ies.MVC;
import br.com.ies.MVC.ModelReadOnly;
import br.com.ies.MVC.Controller;

class Model extends ModelReadOnly {
    void registrarObservador(int evento, void código);
    void notificarObservadores(int evento);

    // Métodos set...
    // void set(Controller.Chave chave);
}