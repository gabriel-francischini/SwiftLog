package com.br.ies.core;

import com.br.ies.core.inventario.InventarioPanel;
import com.br.ies.core.janela.Janela;

import javax.swing.*;

    public class Main {


        private Janela janela;
        private JTabbedPane jTabbedPane;

        private InventarioPanel inventarioPanel;

    public Main() {
        this.janela = new Janela(600, 500);
        this.jTabbedPane = new JTabbedPane();
        this.inventarioPanel = new InventarioPanel();


        this.jTabbedPane.add(this.inventarioPanel, "Inventario");
        this.jTabbedPane.add(new JPanel(), "Relatorios");
        this.jTabbedPane.add(new JPanel(), "Opção 3");
        this.jTabbedPane.add(new JPanel(), "Opção 4");


        this.janela.add(this.jTabbedPane);
        this.janela.pack();
        this.janela.setVisible(true);
    }



    public static void main(String[] args) {
        new Main();
    }
}
