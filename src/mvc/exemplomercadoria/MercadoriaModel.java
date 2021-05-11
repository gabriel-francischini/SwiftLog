package mvc.exemplomercadoria;
import mvc.Controller;

import bd.Mercadoria;

class MercadoriaModel {
    private Mercadoria mercadoria;
    private padrõesdeprojeto.observador.Evento0Args eventoValoresMudaram;

    void quandoMudarValores(padrõesdeprojeto.observador.Listener0Args callback){
        eventoValoresMudaram.addListener(callback);
    }
    void notificarMudouValores(){ eventoValoresMudaram.broadcast(); }

    MercadoriaModel() {
        // chama MercadoriaModel(Mercadoria mercadoria)
        this(new Mercadoria());
    }
    MercadoriaModel(Mercadoria mercadoria) {
        System.out.println("Criando MercadoriaModel(Mercadoria)");
        this.mercadoria = mercadoria;
        this.eventoValoresMudaram = new padrõesdeprojeto.observador.Evento0Args();
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
        eventoValoresMudaram.broadcast();
    }

    public void setNome(Controller.Chave _chave, String nome) {
        this.mercadoria.nome = nome;
        eventoValoresMudaram.broadcast();
    }

    public void setTamanho(Controller.Chave _chave, String tamanho) {
        this.mercadoria.tamanho = tamanho;
        eventoValoresMudaram.broadcast();
    }

    public void setMarca(Controller.Chave _chave, String marca) {
        this.mercadoria.marca = marca;
        eventoValoresMudaram.broadcast();
    }

    public void setDescrição(Controller.Chave _chave, String descrição) {
        this.mercadoria.descrição = descrição;
        eventoValoresMudaram.broadcast();
    }
}