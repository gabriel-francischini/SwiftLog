package mvc.exemplomercadoria;

import mvc.Controller;

class MercadoriaModelReadOnly {
    private MercadoriaModel mercadoria;

    /** "Converte" de MercadoriaModel para MercadoriaModelReadOnly */
    MercadoriaModelReadOnly(MercadoriaModel mercadoria){
        System.out.println("Criando MercadoriaModelReadOnly(MercadoriaModel)");
        this.mercadoria = mercadoria;
    }
    public void quandoMudarValores(padrõesdeprojeto.observador.Listener0Args callback){
        mercadoria.quandoMudarValores(callback);
    }

    /** Método importante para facilitar a vida de outros objetos/classes.
     * Converte de MercadoriaModelReadOnly para MercadoriaModel */
    public MercadoriaModel getModel(Controller.Chave _chave){ return mercadoria; }

    /* Getters */
    public int getId() { return this.mercadoria.getId(); }
    public String getNome() { return this.mercadoria.getNome(); }
    public String getTamanho() { return this.mercadoria.getTamanho(); }
    public String getMarca() { return this.mercadoria.getMarca(); }
    public String getDescrição() { return this.mercadoria.getDescrição(); }
}