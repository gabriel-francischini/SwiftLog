package core.models;

import java.math.BigDecimal;

import padrõesdeprojeto.observador.Listener0Args;

public interface MercadoriaModelReadable {
    public abstract int getId();
    public abstract String getNome();
    public abstract String getTamanho();
    public abstract String getMarca();
    public abstract String getDescrição();
    public abstract BigDecimal getPreçoBase();
    public void quandoMudarValores(Listener0Args callback);
    public void notificarMudouValores();
}
