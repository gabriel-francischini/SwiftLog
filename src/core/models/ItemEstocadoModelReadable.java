package core.models;

import padrõesdeprojeto.observador.Listener0Args;

public interface ItemEstocadoModelReadable {
    public int getId();
    public int getQuantidade();
    public MercadoriaModelReadable getMercadoriaReadable();
    public LoteModelReadable getLoteReadable();
    public void quandoMudarValores(Listener0Args callback);
    public void notificarMudouValores();
}
