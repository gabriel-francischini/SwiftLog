package mvc.exemplomercadoria;

import javax.swing.*;
import java.awt.*;

public class MercadoriaForm {
    public JTextField nomeInput;
    public JTextField tamanhoInput;
    public JTextField marcaInput;
    public JTextArea descriçãoInput;
    public JButton confirmarButton;
    public JLabel identificaçãoLabel;
    public JLabel nomeLabel;
    public JLabel tamanhoLabel;
    public JLabel identificaçãoInput;
    public JLabel marcaLabel;
    public JLabel descriçãoLabel;
    public JPanel raiz;

    /**
     * Esse método de classe cria a view inteira sozinha e stand-alone, caso você precise.
     * Nesse exemplos não precisamos disso pois o FormularioMercadoriaView já tem uma função que faz isso,
     * mas esse aqui é um bom template para copiar e colar caso você precise escrever o código de criar janelas
     * em algum outro lugar.
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame("MercadoriaForm");
        frame.setContentPane(new MercadoriaForm().raiz);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //! Esse método é criado se ouver pelo menos um componente swing com o checkbox "Custom Create" marcado.
    //! Se esse checkbox estiver marcado, $$$setupUI$$$() chama esse método ANTES de criar os componentes.
    //! O $$$setupUI$$$$() sempre é chamado pelo construtor da classe, independente de checkboxes.
    //! O botão incluir está marcado com o "Custom Create" para que possamos adicionar um Listener nele, caso o contrário
    //! esse código nunca seria executado.
    public void createUIComponents() {
        // TODO: place custom component creation code here
        confirmarButton = new JButton();
        confirmarButton.addActionListener(e -> {
            System.out.println("Botão clicado");
        });
    }

    //* Esse abaixo é o construtor da classe.

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        createUIComponents();
        raiz = new JPanel();
        raiz.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(6, 2, new Insets(0, 0, 0, 0), -1, -1));
        identificaçãoLabel = new JLabel();
        identificaçãoLabel.setText("Identificação:");
        raiz.add(identificaçãoLabel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nomeLabel = new JLabel();
        nomeLabel.setText("Nome:");
        raiz.add(nomeLabel, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        tamanhoLabel = new JLabel();
        tamanhoLabel.setText("Tamanho:");
        raiz.add(tamanhoLabel, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        identificaçãoInput = new JLabel();
        identificaçãoInput.setText("Marca");
        raiz.add(identificaçãoInput, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        nomeInput = new JTextField();
        raiz.add(nomeInput, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        tamanhoInput = new JTextField();
        raiz.add(tamanhoInput, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        marcaLabel = new JLabel();
        marcaLabel.setText("Marca:");
        raiz.add(marcaLabel, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        marcaInput = new JTextField();
        raiz.add(marcaInput, new com.intellij.uiDesigner.core.GridConstraints(3, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        descriçãoLabel = new JLabel();
        descriçãoLabel.setText("Descrição:");
        raiz.add(descriçãoLabel, new com.intellij.uiDesigner.core.GridConstraints(4, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        descriçãoInput = new JTextArea();
        descriçãoInput.setText("");
        raiz.add(descriçãoInput, new com.intellij.uiDesigner.core.GridConstraints(4, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, new Dimension(150, 50), null, 0, false));
        confirmarButton.setText("Incluir");
        raiz.add(confirmarButton, new com.intellij.uiDesigner.core.GridConstraints(5, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return raiz;
    }

}
