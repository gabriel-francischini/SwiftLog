package br.com.ies.core.inventario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroProdutoFrame extends JFrame implements ActionListener {

    private JPanel painel;

    private JLabel nomeProdutoLabel;
    private JLabel codigoProdutoLabel;
    private JLabel quantidadeTotalProdutoLabel;
    private JLabel quantidadeMinimaProdutoLabel;
    private JLabel precoCompraProdutoLabel;
    private JLabel precoVendaProdutoLabel;

    private JTextField nomeProdutoInput;
    private JTextField codigoProdutoInput;
    private JTextField quantidadeTotalProdutoInput;
    private JTextField quantidadeMinimaProdutoInput;
    private JTextField precoCompraProdutoInput;
    private JTextField precoVendaProdutoInput;

    private JButton cadastroButton;


    public CadastroProdutoFrame() {
        super("Cadastro de Produtos");
        initializeFrameConfigs();
        initializePanelConfigs();
        initializeObjects();
        setObjectsConfigs();
        setObjectsPositions();

        this.pack();
        this.setVisible(true);

    }
    public void initializeFrameConfigs() {
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void initializePanelConfigs() {
        this.painel = new JPanel();
        this.painel.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(500, 300));
        this.painel.setBackground(new Color(255, 255, 255));
        this.painel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(100, 100, 100), 1, true));

    }

    public void initializeObjects() {
        // Labels
        this.nomeProdutoLabel = new JLabel("Nome");
        this.codigoProdutoLabel = new JLabel("Código");
        this.quantidadeTotalProdutoLabel = new JLabel("Quantidade Total");
        this.quantidadeMinimaProdutoLabel = new JLabel("Qauntidade Minima");
        this.precoCompraProdutoLabel = new JLabel("Preco de Compra");
        this.precoVendaProdutoLabel = new JLabel("Preco de Venda");

        // Inputs
        this.nomeProdutoInput = new JTextField();
        this.codigoProdutoInput = new JTextField();
        this.quantidadeTotalProdutoInput = new JTextField();
        this.quantidadeMinimaProdutoInput = new JTextField();
        this.precoCompraProdutoInput = new JTextField();
        this.precoVendaProdutoInput = new JTextField();

        // Buttons
        this.cadastroButton = new JButton("Cadastrar");
        this.cadastroButton.addActionListener(this);
        this.cadastroButton.setActionCommand("CADASTRO");

    }

    public void setObjectsConfigs() {
        // Inputs
        final int height = 20;
        this.nomeProdutoInput.setPreferredSize(new Dimension(100, height));
        this.codigoProdutoInput.setPreferredSize(new Dimension(50, height));
        this.quantidadeTotalProdutoInput.setPreferredSize(new Dimension(30, height));
        this.quantidadeMinimaProdutoInput.setPreferredSize(new Dimension(30, height));
        this.precoCompraProdutoInput.setPreferredSize(new Dimension(50, height));
        this.precoVendaProdutoInput.setPreferredSize(new Dimension(50, height));

        // Buttons
        this.cadastroButton.setPreferredSize(new Dimension(100, 50));


    }

    public void setObjectsPositions() {
        GridBagConstraints c = new GridBagConstraints();


        // Nome do produto
        c.gridx = 0;
        c.gridy = 0;
        this.painel.add(this.nomeProdutoLabel, c);
        c.gridx = 1;
        this.painel.add(this.nomeProdutoInput, c);


        // Codigo do produto
        c.gridx = 0;
        c.gridy = 1;
        this.painel.add(this.codigoProdutoLabel, c);
        c.gridx = 1;
        this.painel.add(this.codigoProdutoInput, c);


        // Quantidade total de produtos
        c.gridx = 0;
        c.gridy = 2;
        this.painel.add(this.quantidadeTotalProdutoLabel, c);
        c.gridx = 1;
        this.painel.add(this.quantidadeTotalProdutoInput, c);


        // Quantidade minima de produtos
        c.gridx = 0;
        c.gridy = 3;
        this.painel.add(this.quantidadeMinimaProdutoLabel, c);
        c.gridx = 1;
        this.painel.add(this.quantidadeMinimaProdutoInput, c);


        // Preco compra produto
        c.gridx = 0;
        c.gridy = 4;
        this.painel.add(this.precoCompraProdutoLabel, c);
        c.gridx = 1;
        this.painel.add(this.precoCompraProdutoInput, c);


        // Preco Venda produto
        c.gridx = 0;
        c.gridy = 5;
        this.painel.add(this.precoVendaProdutoLabel, c);
        c.gridx = 1;
        this.painel.add(this.precoVendaProdutoInput, c);



        // -----------------------------------
        // Buttons
        c.gridx = 0;
        c.gridy = 6;
        c.gridwidth = 2;
        this.painel.add(this.cadastroButton, c);

        this.add(this.painel);
    }


    public void getInputValues() {
        System.out.println(
        "Nome: " + this.nomeProdutoInput.getText() + '\n' +
        "Codigo: "+ this.codigoProdutoInput.getText() + '\n' +
        "Quantidade Total: " + this.quantidadeTotalProdutoInput.getText() + '\n' +
        "Quantidade Minima: " + this.quantidadeMinimaProdutoInput.getText() + '\n' +
        "Preço Compra: " + this.precoCompraProdutoInput.getText() + '\n' +
        "Preço Venda: " + this.precoVendaProdutoInput.getText() + '\n'
        );
    }







    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action == "CADASTRO") {
            getInputValues();
        }

    }
}
