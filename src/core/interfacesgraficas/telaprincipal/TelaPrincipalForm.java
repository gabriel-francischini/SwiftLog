package core.interfacesgraficas.telaprincipal;

import core.interfacesgraficas.listagemmercadorias.ListagemItemEstocadoForm;
import core.interfacesgraficas.venda.VendaViewForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipalForm extends JFrame{
    private JPanel panel1;
    private JButton incluirMercadoriaFornecedorButton;
    private JButton alterarDadosDaMercadoriaButton;
    private JButton listarMercadoriasButton;
    private JButton listarFornecedoresButton;
    private JButton listarSolicitaçõesDeMercadoriasButton;
    private JButton registrarVendaButton;
    private JButton consultarVendasButton;
    private JPanel panel2;

    public TelaPrincipalForm(){
        super.setTitle("Swiftlog");
        listarMercadoriasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListagemItemEstocadoForm();
            }
        });
        registrarVendaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new VendaViewForm();
            }
        });
    }
}
