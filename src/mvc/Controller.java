package br.com.ies.MVC;

import br.com.ies.MVC.Model;
import br.com.ies.MVC.View;

interface Controller {

    // Essa é uma chave que permite somente Controllers serem capazes de
    // usar métodos Set() (i.e. métodos write, que modificam dados) dos
    // com.br.ies.MVC.Model.
    // veja: https://stackoverflow.com/questions/182278/is-there-a-way-to-simulate-the-c-friend-concept-in-java
    public static final class Chave { private Chave() {} }
    private static final Chave chave;


}