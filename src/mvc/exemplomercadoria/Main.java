package mvc.exemplomercadoria;

import bd.Mercadoria;

import mvc.exemplomercadoria.FormularioMercadoriaView;
import mvc.exemplomercadoria.MercadoriaController;
import mvc.exemplomercadoria.MercadoriaModel;
import mvc.exemplomercadoria.MercadoriaModelReadOnly;


public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando mvc.ExemploMercadoria");
        Mercadoria nova_mercadoria = new Mercadoria();
        MercadoriaController controller = new MercadoriaController(new MercadoriaModel(nova_mercadoria));
        // BUG ! FIXME !
        // controller.salvarAlterações(new MercadoriaModelReadOnly(new MercadoriaModel(new Mercadoria())));
        controller.view.mostrarJanela();
    }
}
