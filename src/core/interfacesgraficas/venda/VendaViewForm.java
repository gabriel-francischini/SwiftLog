package core.interfacesgraficas.venda;

import core.models.ItemEstocadoModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendaViewForm extends JFrame {

    public JPanel contentPanel;
    public JTextField tfQuantidade;
    public JTextField tfIDInput;
    public JComboBox cbMercadoriaSearchResult;
    public JLabel lblIdentifier;
    public JLabel lblMercadoria;
    public JLabel lblQuantidade;
    public JTextField tfMercadoriaSearch;
    public JButton btnRegistrarVenda;


    public VendaViewForm(){
        super("Registrar Venda");
        super.add(contentPanel);
        tfMercadoriaSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) { }
            @Override
            public void removeUpdate(DocumentEvent e) { }
            @Override
            public void changedUpdate(DocumentEvent e) {
//              Nessa parte nós pegamos o texto do componente e fazemos a query
//                depois passamos para o combobox
//                e.getDocument().getText();
//                cbMercadoriaSearchResult.set

            }

            // Quando apertarmos "Enter" no tfMercadoriaSearch ou "Incluir" em um botão paralelo, devemos
            // adicionar a mercadoria no ComboBox.


        });


        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
        setSize(800,600);
        pack();
        btnRegistrarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public static void main(String[] args) {

    }
}
