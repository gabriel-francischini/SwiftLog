package br.com.ies.core.inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventarioPanel extends JPanel implements ActionListener {

    private ProcuraProdutoPanel procuraProdutoPanel;

    private JButton cadastraButton;
    private CadastroProdutoFrame cadastroProdutoFrame;

    private JButton alteraButton;

    private JButton excluiButton;

    private ResultadoProdutoPanel resultadoProdutoPanel;
    private JScrollPane resultadoProdutoPanelScroll;


    public InventarioPanel() {
        this.setLayout(new GridBagLayout());
        initializeObjects();
        setObjectsConfigs();
        setObjectsPositions();

    }

    public void initializeObjects() {
        this.cadastraButton = new JButton("Cadastrar");
        this.alteraButton = new JButton("Alterar");
        this.excluiButton = new JButton("Excluir");

        this.procuraProdutoPanel = new ProcuraProdutoPanel();

        this.resultadoProdutoPanel = new ResultadoProdutoPanel();
        this.resultadoProdutoPanelScroll = new JScrollPane(this.resultadoProdutoPanel);


    }

    public void setObjectsConfigs() {

        this.cadastraButton.addActionListener(this);
        this.cadastraButton.setActionCommand("CADASTRAR");


        this.alteraButton.addActionListener(this);
        this.alteraButton.setActionCommand("ALTERAR");

        this.excluiButton.addActionListener(this);
        this.excluiButton.setActionCommand("EXCLUIR");

//        this.resultadoProdutoPanel.
    }


    public void setObjectsPositions() {
        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.PAGE_START;

        c.weighty = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.add(this.cadastraButton, c);

        c.gridx = 1;
        this.add(this.alteraButton, c);

        c.gridx = 2;
        this.add(this.excluiButton, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        c.weighty = 1;
        this.add(this.procuraProdutoPanel, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 4;
        c.weighty = 6;
        this.add(this.resultadoProdutoPanel, c);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action == "CADASTRAR") {
            new CadastroProdutoFrame();
        }
        else if(action == "EXCLUIR") {

        } else if(action == "ALTERAR") {

        }
    }
}
