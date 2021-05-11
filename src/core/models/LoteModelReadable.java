package core.models;

import bd.Lote;
import mvc.Controller;
import padrõesdeprojeto.observador.Listener0Args;

import java.time.LocalDate;

public interface LoteModelReadable {
    public abstract int getID();
    public abstract LocalDate getDataFabricacao();
    public abstract LocalDate getDataVencimento();
    public abstract LoteModel getLote();
    public void quandoMudarValores();
    public void notificarMudouValores();

    public String toString();
}
