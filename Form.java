package interfaces.label;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Form{


    private JButton Calculate;
    private JPanel VentanaPrincipal;
    private JTextField IngresoMonto;
    private JComboBox Divisa1;
    private JComboBox Divisa2;
    private JButton convertirButton;
    private JTextArea Monedaconvertida;

    //Double valor;




    public Form() {
        convertirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double valor = Double.parseDouble(IngresoMonto.getText());
                int Divisa = Divisa1.getSelectedIndex();
                int DividaFinal = Divisa2.getSelectedIndex();

                Operaciones puente = new Operaciones();
                puente.setValor(valor);
                puente.setDivisa(Divisa);
                puente.setDivisafinal(DividaFinal);
                Monedaconvertida.setText("");

                double resultado=0;

                switch (Divisa){
                    case 0:
                        resultado = puente.convertir(0, puente.Euro);
                        break;
                    case 1:
                        resultado = puente.convertir(1, puente.dolar);
                        break;
                    case 2:
                        resultado = puente.convertir(2, puente.Soles);
                        break;
                    case 3:
                        resultado = puente.convertir(3, puente.PesoMex);
                        break;
                    case 4:
                        resultado = puente.convertir(4, puente.PesoCol);
                        break;
                    }
                Monedaconvertida.append("El cambio a la fecha es "+ resultado );

            }
        });
    }

    public JPanel getVentanaPrincipal() {
        return VentanaPrincipal;
    }


        public static void main(String[] args) {

            JFrame frame = new JFrame();
            frame.setSize(450, 300);
            frame.setTitle("Conversor de Monedas");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            Form monedas = new Form();
            frame.setContentPane(monedas.getVentanaPrincipal());
            frame.setVisible(true);
        }


}