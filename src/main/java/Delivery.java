
import javax.swing.SwingUtilities;
import view.TelaCadastro;

public class Delivery {
    public static void main(String[] args) {
        // Executa a interface grafica na thread correta do Swing
        SwingUtilities.invokeLater(() -> {
            TelaCadastro tela = new TelaCadastro();
            tela.setVisible(true);
        });
    }
}
