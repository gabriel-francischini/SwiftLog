package br.com.ies.MVC.ExemploMercadoria;

import mvc.exemplomercadoria.MercadoriaForm;
import br.com.ies.MVC.ExemploMercadoria.MercadoriaModelReadOnly;
import br.com.ies.MVC.ExemploMercadoria.MercadoriaController;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class FormularioMercadoriaView {
    MercadoriaModelReadOnly mercadoria;
    MercadoriaController controller;
    MercadoriaForm mercadoriaForm;
    JFrame janela;

    void mostrarJanela(){
        janela.setTitle("Mercadoria");
        janela.setContentPane(mercadoriaForm.raiz);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
    }

    public void setarConformeModel(MercadoriaModelReadOnly mercadoria){
        this.mercadoria = mercadoria;
        mercadoriaForm.nomeInput.setText(mercadoria.getNome());
        mercadoriaForm.marcaInput.setText(mercadoria.getMarca());
        mercadoriaForm.identificaçãoInput.setText(String.valueOf(mercadoria.getId()));
        mercadoriaForm.tamanhoInput.setText(mercadoria.getTamanho());
        mercadoriaForm.descriçãoInput.setText(mercadoria.getDescrição());
    }

    private void continuarConstrutor(){
        System.out.println("Continuando a contrução de uma FormularioMercadoriaView");
        janela = new JFrame();
        setarConformeModel(this.mercadoria);

        mercadoria.quandoMudarValores(() -> {
            System.out.println("FormularioMercadoriaView ouviu uma mudança de valores de uma mercadoria");
            setarConformeModel(this.mercadoria);
        });

        System.out.println("Adicionando listener da FormularioMercadoriaView a um botão Swing");
        System.out.println(mercadoriaForm.confirmarButton.getActionCommand() + " " + mercadoriaForm.confirmarButton.toString());

        var listener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("FormularioMercadoriaView ouviu o evento Swing de botão: " + e.getActionCommand());
                if(!e.getActionCommand().isEmpty()){
                    controller.salvarAlterações(mercadoria);
                }
            }};
        mercadoriaForm.confirmarButton.addActionListener((ActionEvent e) -> {
            System.out.println("FormularioMercadoriaView ouviu o evento Swing de botão: " + e.getActionCommand());
            if(!e.getActionCommand().isEmpty()){
                controller.salvarAlterações(mercadoria);
            }
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
}