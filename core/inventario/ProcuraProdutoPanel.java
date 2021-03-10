package com.br.ies.core.inventario;

import javax.swing.*;
import java.awt.*;

public class ProcuraProdutoPanel extends JPanel {

    private JLabel codigoLabel;
    private JLabel descricaoLabel;

    private JTextField codigoInput;
    private JTextField descricaoInput;

    private JButton procuraButton;

    public ProcuraProdutoPanel() {
        initializePanelConfigs();
        initializeObjects();
        setObjectsConfigs();
        setObjectsPositions();
    }

    public void initializePanelConfigs() {
        this.setLayout(new GridBagLayout());
    }

    public void initializeObjects() {
        this.codigoLabel = new JLabel("Códigio");
        this.descricaoLabel = new JLabel("Descrição");

        this.codigoInput = new JTextField();
        this.descricaoInput = new JTextField();

        this.procuraButton = new JButton("Procurar");
    }

    public void setObjectsConfigs() {
        this.codigoInput.setPreferredSize(new Dimension(70 ,20));
        this.descricaoInput.setPreferredSize(new Dimension(300, 20));

    }

    public void setObjectsPositions() {
        GridBagConstraints c = new GridBagConstraints();


        c.gridx = 0;
        c.gridy = 0;
        this.add(this.codigoLabel, c);
        c.gridy = 1;
        this.add(this.codigoInput, c);


        c.gridx = 1;
        c.gridy = 0;
        this.add(this.descricaoLabel, c);
        c.gridy = 1;
        this.add(this.descricaoInput, c);


        c.gridx = 2;
        c.gridy = 1;
        this.add(this.procuraButton, c);
    }

}
