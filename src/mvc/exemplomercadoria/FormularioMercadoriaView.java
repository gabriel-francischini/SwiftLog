package mvc.exemplomercadoria;

import mvc.exemplomercadoria.MercadoriaForm;
import mvc.exemplomercadoria.MercadoriaModelReadOnly;
import mvc.exemplomercadoria.MercadoriaController;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class FormularioMercadoriaView {
    MercadoriaModelReadOnly mercadoria;
    MercadoriaController controller;
    MercadoriaForm mercadoriaForm;
    JFrame janela;

    /** Método importante pra facilitar a vida de outras classes */
    void mostrarJanela(){
        janela.setTitle("Mercadoria");
        janela.setContentPane(mercadoriaForm.raiz);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
    }

    /** Método importante pra facilitar a vida de outras classes */
    public void setarConformeModel(MercadoriaModelReadOnly mercadoria){
        this.mercadoria = mercadoria;
        mercadoriaForm.nomeInput.setText(mercadoria.getNome());
        mercadoriaForm.marcaInput.setText(mercadoria.getMarca());
        mercadoriaForm.identificaçãoInput.setText(String.valueOf(mercadoria.getId()));
        mercadoriaForm.tamanhoInput.setText(mercadoria.getTamanho());
        mercadoriaForm.descriçãoInput.setText(mercadoria.getDescrição());
    }

    /** Inicializa os campos da interface que não são pré-fixados e coloca as callbacks de quando usário interage
     * com a interface. */
    private void continuarConstrutor(){
        System.out.println("Continuando a contrução de uma FormularioMercadoriaView");
        janela = new JFrame();
        setarConformeModel(this.mercadoria);

        mercadoria.quandoMudarValores(() -> {
            System.out.println("FormularioMercadoriaView ouviu uma mudança de valores de uma mercadoria");
            setarConformeModel(this.mercadoria);
        });

        System.out.println("Adicionando listener da FormularioMercadoriaView a um botão Swing");

        mercadoriaForm.confirmarButton.addActionListener((ActionEvent e) -> {
            System.out.println("FormularioMercadoriaView ouviu o evento Swing de botão: " + e.getActionCommand());
            controller.salvarAlterações(mercadoria);
        });
    }

    FormularioMercadoriaView(MercadoriaController controller, MercadoriaModelReadOnly model){
        this.controller = controller;
        this.mercadoria = model;
        this.mercadoriaForm = new MercadoriaForm();
        this.continuarConstrutor();
    }

    FormularioMercadoriaView(MercadoriaModelReadOnly model){
        this.mercadoria = model;
        this.controller = new MercadoriaController(this, model);
        this.mercadoriaForm = new MercadoriaForm();
        this.continuarConstrutor();
    }

    public String getNomeInput() {
        return mercadoriaForm.nomeInput.getText();
    }

    public String getTamanhoInput() {
        return mercadoriaForm.tamanhoInput.getText();
    }

    public String getMarcaInput() {
        return mercadoriaForm.marcaInput.getText();
    }

    public String getDescriçãoInput() {
        return mercadoriaForm.descriçãoInput.getText();
    }

    public String getIdentificaçãoInput() {
        return mercadoriaForm.identificaçãoInput.getText();
    }

}