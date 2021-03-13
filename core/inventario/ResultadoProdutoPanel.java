package br.com.ies.core.inventario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ResultadoProdutoPanel extends JTable {

    public final String[] colunas = new String[]{"Código", "Nome", "Qtd To", "Qtd Min", "Preco Comp", "Preco Vend"};
    public final String[][] produto = new String[][] {
            {"001", "Sabão", "10 Un", "2un", "10,00", "20,00"},
            {"002", "Pipipi-pópópó", "20 Un", "10un", "60,00", "6,00"},
            {"999", "No duvidas", "100 Un", "10un", "100,00", "666,00"}
    };



    private DefaultTableModel defaultTableModel;

    public ResultadoProdutoPanel() {
        this.defaultTableModel = new DefaultTableModel(produto, colunas);
        this.setModel(this.defaultTableModel);


        addRow(new String[]{"100", "FILLER", "9090"});
    }

    public void addRow(String[] linha) {
        this.defaultTableModel = (DefaultTableModel) this.getModel();
        this.defaultTableModel.addRow(linha);
    }


}
