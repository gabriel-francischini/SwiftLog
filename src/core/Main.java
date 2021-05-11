package core;
import core.interfacesgraficas.listagemmercadorias.*;
import core.models.ItemEstocadoModel;


public class Main {

    public static void main(String[] args) {
        var controller = new ListagemItemEstocadoController(ItemEstocadoModel.findAll());
        controller.view.mostrarJanela();
    }
}
