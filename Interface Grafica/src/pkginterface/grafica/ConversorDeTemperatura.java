
package pkginterface.grafica;

import javax.swing.*;
import java.awt.*;
        
public class ConversorDeTemperatura {
    
    public static void criarTela(){
        JFrame tela = new JFrame("Conversor");
        /*
        JButton - Botões
        JLabel - Componentes textuais não editáveis pelo usuário
        JTextField - Componenetes textuais editáveis pelo usuário
        */
        JTextField celsiusTextField = new JTextField(10);
        JLabel celsiusLabel = new JLabel("\u00B0C");
        JButton convertButton = new JButton("Converter");
        JLabel valorConvertidoLabel = new JLabel("");
        Container painelDeConteudo = tela.getContentPane();
        painelDeConteudo.setLayout(new GridLayout(2, 4, 2, 4));
        painelDeConteudo.add(celsiusTextField);
        painelDeConteudo.add(celsiusLabel);
        painelDeConteudo.add(convertButton);
        painelDeConteudo.add(valorConvertidoLabel);
        
        convertButton.addActionListener((e)->{
            double celsius = Double.parseDouble(
                celsiusTextField.getText()
            );
            double fahrenheit = celsius / 5*9 + 32;
            valorConvertidoLabel.setText(
                String.format("%.2f\u00B0F", fahrenheit)
            );
        });
        
        //ajustar largura e altura de acordo com o conteúdo
        tela.pack();
        //centraliza
        tela.setLocationRelativeTo(null);
        //altera comportamento padrão do botão fechar
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //torna a tela visível
        tela.setVisible(true);
    }
    
    //Para executar, criar método main e utilizar o método invokeLate de SwingUtilities para chamar o método criarTela apropriadamente
        public static void main(String[] args){
            SwingUtilities.invokeLater(()->{
                criarTela();
            });
        }
    
}
