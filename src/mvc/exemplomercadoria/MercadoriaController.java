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

    public void salvarAlterações(MercadoriaModelReadOnly mercadoriaReadOnly){
        System.out.println("Salvando MercadoriaModelReadOnly no banco de dados via MercadoriaController");

        /* Toma cuidado pois assim que setarmos um atributo do Model, o FormularioMercadoriaView
        * vai apagar os dados que ele está mostrado para colocar os dados novos que estão no MercadoriaModel.
        * Isso quer dizer que se o usuário digitou vários campos, ao setarmos o primeiro campo a gente perde
        * os dados que o usuário digitou pois o FormularioMercadoriaView apagou eles para
        * colocar os dados do MercadoriaModel. A solução é salvar esses dados numa variável temporária primeiro, ou
        * ter um método que altera mais de um campo ao mesmo tempo. */
        var novoNome = view.getNomeInput();
        var novaMarca = view.getMarcaInput();
        var novaDescrição = view.getDescriçãoInput();
        var novoTamanho = view.getTamanhoInput();

        MercadoriaModel mercadoria = mercadoriaReadOnly.getModel(Controller.chave);
        mercadoria.setNome(Controller.chave, novoNome);
        mercadoria.setMarca(Controller.chave, novaMarca);
        mercadoria.setDescrição(Controller.chave, novaDescrição);
        mercadoria.setTamanho(Controller.chave, novoTamanho);

        br.com.ies.bd.HibernateConfig.salvar(mercadoriaReadOnly.getModel(Controller.chave).getMercadoria(Controller.chave));
        // Ao salvar, pode ser que uma ID seja adicionada a um item que não fosse pré-existente,
        // logo, devemos avisar os componentes interessados que os valores dessa mercadoria podem ter mudado.
        mercadoriaReadOnly.getModel(Controller.chave).notificarMudouValores();
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