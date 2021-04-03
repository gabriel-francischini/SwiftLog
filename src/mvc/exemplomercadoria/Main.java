package br.com.ies.MVC.ExemploMercadoria;

import br.com.ies.bd.Mercadoria;

import br.com.ies.MVC.ExemploMercadoria.FormularioMercadoriaView;
import br.com.ies.MVC.ExemploMercadoria.MercadoriaController;
import br.com.ies.MVC.ExemploMercadoria.MercadoriaModel;
import br.com.ies.MVC.ExemploMercadoria.MercadoriaModelReadOnly;


public class Main {
    public static void main(String[] args) {
        System.out.println("Iniciando br.com.ies.MVC.ExemploMercadoria");
        Mercadoria nova_mercadoria = new Mercadoria();
        MercadoriaController controller = new MercadoriaController(new MercadoriaModel(nova_mercadoria));
        // BUG ! FIXME !
        // controller.salvarAlterações(new MercadoriaModelReadOnly(new MercadoriaModel(new Mercadoria())));
        controller.view.mostrarJanela();
    }
}
