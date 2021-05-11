package core.models;

import bd.Lote;
import mvc.Controller;
import java.time.LocalDate;

public interface LoteModelWritable {
    public abstract void setID(Controller.Chave _chave, int id);
    public abstract void setDataFabricacao(Controller.Chave _chave, LocalDate dataFabricao);
    public abstract void setDataVencimento(Controller.Chave _chave, LocalDate dataVencimento);

    public abstract LoteModel getModel(Controller.Chave _chave);
}
