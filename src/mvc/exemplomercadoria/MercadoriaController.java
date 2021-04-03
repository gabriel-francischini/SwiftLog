package br.com.ies.MVC.ExemploMercadoria;

import br.com.ies.MVC.Model;
import br.com.ies.MVC.View;
import br.com.ies.MVC.Controller;

import br.com.ies.bd.Mercadoria;

import br.com.ies.MVC.ExemploMercadoria.MercadoriaModel;
import br.com.ies.MVC.ExemploMercadoria.MercadoriaModelReadOnly;
import br.com.ies.MVC.ExemploMercadoria.FormularioMercadoriaView;


class MercadoriaController extends Controller {
    MercadoriaModel mercadoria;
    public FormularioMercadoriaView view;

    MercadoriaController(FormularioMercadoriaView view, MercadoriaModel mercadoria){
        System.out.println("Criando MercadoriaController(view, MercadoriaModel)");
        this.view = view;
        this.mercadoria = mercadoria;
    }

    MercadoriaController(FormularioMercadoriaView view, MercadoriaModelReadOnly mercadoria){
        this(view, mercadoria.getModel(Controller.chave));
    }

    public void salvarAlterações(MercadoriaModelReadOnly mercadoria){
        System.out.println("Salvando MercadoriaModelReadOnly no banco de dados via MercadoriaController");
        br.com.ies.bd.HibernateConfig.salvar(mercadoria.getModel(Controller.chave).getMercadoria(Controller.chave));
        // Ao salvar, pode ser que uma ID seja adicionada a um item que não fosse pré-existente,
        // logo, devemos avisar os componentes interessados que os valores dessa mercadoria podem ter mudado.
        mercadoria.getModel(Controller.chave).notificarMudouValores();
    }

    MercadoriaController(MercadoriaModel mercadoria){
        System.out.println("Criando MercadoriaController(MercadoriaModel)");
        // Essa linha abaixo, que delegaria para o outro construtor, não pode ser escrita em java because of *reasons*.
        // Quase qualquer outra linguagem seria OK com isso, mas Java não. Por isso temos que repetir o mesmo código
        // duas vezes em dois lugares diferentes e torcer para que eles nunca fiquem out of sync.
        // veja: https://stackoverflow.com/questions/23754814/cannot-reference-this-before-supertype-constructor-has-been-called
        //    this(new FormularioMercadoriaView(this, new MercadoriaModelReadOnly(mercadoria)), mercadoria);
        this.mercadoria = mercadoria;
        this.view = new FormularioMercadoriaView(this, new MercadoriaModelReadOnly(mercadoria));
    }
}