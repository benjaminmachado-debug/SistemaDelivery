import view.TelaPrincipal;

import javax.swing.*;


public class Delivery {
    public static void main(String[] args) {
        // Executa a interface grafica na thread correta do Swing
        SwingUtilities.invokeLater(() -> {
            TelaPrincipal tela = new TelaPrincipal();
            tela.setVisible(true);
        });
    }
}
