package core.interfacesgraficas.listagemmercadorias;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

// Sugestão para construção de interfaces: construir primeiro a janela (JFrame) e depois ir adicionando os painéis?
// Diversos exemplos de código utilizam essa metodologia: realizar a construção de toda a interface em um objeto  de
// uma classe que extende JFrame, construindo a interface diretamente no construtor.
// (Escrito por Eduardo Augusto)
public class ListagemItemEstocadoForm extends JPanel {
    public JTable tabela;
    private JPanel painelBotoes;
    private JScrollPane barraRolagem;
    private JButton btInserir;
    private JButton btExcluir;
    private JButton btEditar;
    public DefaultTableModel modelo;

    public ListagemItemEstocadoForm() {
        modelo = new DefaultTableModel();
        criarJTable();

        btInserir = new JButton("Inserir");
        btExcluir = new JButton("Excluir");
        btEditar = new JButton("Editar");
        painelBotoes = new JPanel();

        barraRolagem = new JScrollPane(tabela);

        painelBotoes.add(btInserir);
        painelBotoes.add(btEditar);
        painelBotoes.add(btExcluir);

        this.setLayout(new BorderLayout());
        this.add(BorderLayout.CENTER, barraRolagem);
        this.add(BorderLayout.SOUTH, painelBotoes);
    }

    public void criarJTable() {
        tabela = new JTable(modelo);
        modelo.addColumn("Id");
        modelo.addColumn("Nome");
        modelo.addColumn("Tamanho");
        modelo.addColumn("Marca");
        modelo.addColumn("Descrição");

        // Setar a largura
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(8);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(10);
        modelo.setNumRows(0);
    }

    public static void main(String[] args) {
        JFrame janela = new JFrame("Mercadoria");
        ListagemItemEstocadoForm m = new ListagemItemEstocadoForm();
        janela.add(m);
        janela.pack();
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setSize(500, 320);
        janela.setVisible(true);
    }
}