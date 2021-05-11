package core.models;

import mvc.Controller;
import padrõesdeprojeto.observador.Listener0Args;

public interface ItemEstocadoModelWritable extends ItemEstocadoModelReadable{
    public void setId(Controller.Chave _chave, int id);
    public void setQuantidade(Controller.Chave _chave, int quantidade);
    public void setMercadoria(Controller.Chave _chave, MercadoriaModelWritable mercadoria);
    public void setLote(Controller.Chave _chave, LoteModelWritable lote);
}
