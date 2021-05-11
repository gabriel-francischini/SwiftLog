package core.models;
import bd.Lote;
import mvc.Controller;
import padrõesdeprojeto.observador.Evento0Args;
import padrõesdeprojeto.observador.Listener0Args;

import java.time.LocalDate;

public class LoteModel implements LoteModelWritable, LoteModelReadable {
    
    private Lote lote;
    private Evento0Args eventoValoresMudaram;

    //Getters
    @Override public int getID() {return lote.id;}
    @Override public LocalDate getDataFabricacao() {return lote.dataFabricacao;}
    @Override public LocalDate getDataVencimento() {return lote.dataVencimento;}

    @Override public LoteModel getLote() { return null; }

    @Override
    public void quandoMudarValores() {

    }

    // Setters
    private void setId(int id) {}
    private void setDataFabricacao(LocalDate dataFabricacao) {}
    private void setDataVencimento(LocalDate dataVencimento) {}

    public void quandoMudarValores(Listener0Args callback){eventoValoresMudaram.addListener(callback);}
    public void notificarMudouValores(){eventoValoresMudaram.broadcast();}

    public LoteModel(Lote lote) {
        System.out.println("Criando Lote Model");
        this.lote = lote;
        this.eventoValoresMudaram = new Evento0Args();
    }
    public LoteModel() {
        this(new Lote());
    }

    @Override
    public void setID(Controller.Chave _chave, int id) {

    }

    @Override
    public void setDataFabricacao(Controller.Chave _chave, LocalDate dataFabricao) {

    }

    @Override
    public void setDataVencimento(Controller.Chave _chave, LocalDate dataVencimento) {

    }

    @Override
    public LoteModel getModel(Controller.Chave _chave) {
        return this;
    }

//    @Override
//    public LoteModel getModel() {
//        return null;
//    }

    public Lote getDBEntity() {return this.lote;}
}