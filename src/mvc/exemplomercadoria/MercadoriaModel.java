package br.com.ies.MVC.ExemploMercadoria;
import br.com.ies.MVC.ModelReadOnly;
import br.com.ies.MVC.Controller;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.com.ies.padrõesdeprojeto.Observador0;
import br.com.ies.padrõesdeprojeto.Observável0;

import br.com.ies.bd.Mercadoria;

class MercadoriaModel {
    private Mercadoria mercadoria;
    private Observável0 eventoValoresMudaram;

    void quandoMudarValores(Observador0 callback){
        eventoValoresMudaram.registrar(callback);
    }
    void notificarMudouValores(){ eventoValoresMudaram.notificar(); }

    MercadoriaModel() {
        // chama MercadoriaModel(Mercadoria mercadoria)
        this(new Mercadoria());
    }
    MercadoriaModel(Mercadoria mercadoria) {
        System.out.println("Criando MercadoriaModel(Mercadoria)");
        this.mercadoria = mercadoria;
        this.eventoValoresMudaram = new Observável0();
    }

    public Mercadoria getMercadoria(Controller.Chave _chave){
        return mercadoria;
    }

    /* Daqui para baixo são os getters e setters */
    public int getId() { return this.mercadoria.id; }
    public String getNome() { return this.mercadoria.nome; }
    public String getTamanho() { return this.mercadoria.tamanho; }
    public String getMarca() { return this.mercadoria.marca; }
    public String getDescrição() { return this.mercadoria.descrição; }

    public void setId(Controller.Chave _chave, int id) {
        this.mercadoria.id = id;
        eventoValoresMudaram.notificar();
    }

    public void setNome(Controller.Chave _chave, String nome) {
        this.mercadoria.nome = nome;
        eventoValoresMudaram.notificar();
    }

    public void setTamanho(Controller.Chave _chave, String tamanho) {
        this.mercadoria.tamanho = tamanho;
        eventoValoresMudaram.notificar();
    }

    public void setMarca(Controller.Chave _chave, String marca) {
        this.mercadoria.marca = marca;
        eventoValoresMudaram.notificar();
    }

    public void setDescrição(Controller.Chave _chave, String descrição) {
        this.mercadoria.descrição = descrição;
        eventoValoresMudaram.notificar();
    }
}