package mvc;

import mvc.Model;
import mvc.View;

public class Controller {
    // Campo static (de classe) que constrói um objeto vazio "chave", para uso
    // por objetos Controller (Escrito por Eduardo Augusto)
    public static final Chave chave = new Chave();

    // Essa é uma chave que permite somente Controllers serem capazes de
    // usar métodos Set() (i.e. métodos write, que modificam dados) dos
    // com.br.ies.MVC.Model.
    // veja: https://stackoverflow.com/questions/182278/is-there-a-way-to-simulate-the-c-friend-concept-in-java
    
    // Classe interna Chave para criação da chave usada na classe (Escrito por Eduardo Augusto)
    public static final class Chave { 
        private Chave() {} 
    }
}