package br.com.ies.MVC.ExemploMercadoria;

import br.com.ies.MVC.Controller;
import br.com.ies.padrõesdeprojeto.Observador0;
import br.com.ies.padrõesdeprojeto.Observável0;

import br.com.ies.MVC.ExemploMercadoria.MercadoriaModel;

class MercadoriaModelReadOnly {
    private MercadoriaModel mercadoria;

    MercadoriaModelReadOnly(MercadoriaModel mercadoria){
        System.out.println("Criando MercadoriaModelReadOnly(MercadoriaModel)");
        this.mercadoria = mercadoria;
    }
    public void quandoMudarValores(Observador0 callback){
        mercadoria.quandoMudarValores(callback);
    }

    public MercadoriaModel getModel(Controller.Chave _chave){ return mercadoria; }

    /* Getters */
    public int getId() { return this.mercadoria.getId(); }
    public String getNome() { return this.mercadoria.getNome(); }
    public String getTamanho() { return this.mercadoria.getTamanho(); }
    public String getMarca() { return this.mercadoria.getMarca(); }
    public String getDescrição() { return this.mercadoria.getDescrição(); }
}