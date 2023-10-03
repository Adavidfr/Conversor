import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class ConversorUtilidadesGUI {
    private JFrame frame;
    private JPanel opcionesPanel;
    private JTextField entradaTexto;
    private JTextArea resultadoTextArea;

    public ConversorUtilidadesGUI() {
        frame = new JFrame("Conversor y Utilidades");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        opcionesPanel = new JPanel();
        opcionesPanel.setLayout(new GridLayout(10, 1));

        JButton monedaButton = new JButton("Conversor de Moneda");
        JButton longitudButton = new JButton("Conversor de Longitud");
        JButton temperaturaButton = new JButton("Conversor de Temperatura");
        JButton salarioButton = new JButton("Calculadora de Salario");
        JButton limpiarButton = new JButton("Limpiar");

        monedaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConversorMoneda();
            }
        });

        longitudButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConversorLongitud();
            }
        });

        temperaturaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarConversorTemperatura();
            }
        });

        salarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarCalculadoraSalario();
            }
        });

        limpiarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiarResultado();
            }
        });

        opcionesPanel.add(monedaButton);
        opcionesPanel.add(longitudButton);
        opcionesPanel.add(temperaturaButton);
        opcionesPanel.add(salarioButton);
        opcionesPanel.add(limpiarButton);

        frame.add(opcionesPanel, BorderLayout.WEST);

        entradaTexto = new JTextField();
        resultadoTextArea = new JTextArea();
        resultadoTextArea.setEditable(false);

        JPanel contenidoPanel = new JPanel(new BorderLayout());
        contenidoPanel.add(entradaTexto, BorderLayout.NORTH);
        contenidoPanel.add(resultadoTextArea, BorderLayout.CENTER);

        frame.add(contenidoPanel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void mostrarConversorMoneda() {
        String cantidadTexto = entradaTexto.getText();
        if (!cantidadTexto.isEmpty()) {
            double cantidadDolar = Double.parseDouble(cantidadTexto);
            DecimalFormat df = new DecimalFormat("#.##");

            StringBuilder resultado = new StringBuilder("Resultado:\n");
            resultado.append("Dólar a Euro: ").append(df.format(cantidadDolar * 0.85)).append("\n");
            resultado.append("Dólar a Libra Esterlina: ").append(df.format(cantidadDolar * 0.73)).append("\n");
            resultado.append("Dólar a Yen Japonés: ").append(df.format(cantidadDolar * 111.15)).append("\n");
            resultado.append("Dólar a Won Sul-Coreano: ").append(df.format(cantidadDolar * 1194.50)).append("\n");

            resultado.append("\nConvertir desde otras monedas a Dólar:\n");
            resultado.append("Euro a Dólar: ").append(df.format(cantidadDolar / 0.85)).append("\n");
            resultado.append("Libra Esterlina a Dólar: ").append(df.format(cantidadDolar / 0.73)).append("\n");
            resultado.append("Yen Japonés a Dólar: ").append(df.format(cantidadDolar / 111.15)).append("\n");
            resultado.append("Won Sul-Coreano a Dólar: ").append(df.format(cantidadDolar / 1194.50));

            resultadoTextArea.setText(resultado.toString());
        } else {
            resultadoTextArea.setText("Ingresa una cantidad en Dólares para convertir.");
        }
    }

    private void mostrarConversorLongitud() {
        String cantidadTexto = entradaTexto.getText();
        if (!cantidadTexto.isEmpty()) {
            double cantidadMetros = Double.parseDouble(cantidadTexto);
            DecimalFormat df = new DecimalFormat("#.##");

            StringBuilder resultado = new StringBuilder("Conversor de Longitud:\n");
            resultado.append("Metros a Pies: ").append(df.format(cantidadMetros * 3.28084)).append("\n");
            resultado.append("Pies a Metros: ").append(df.format(cantidadMetros / 3.28084));

            resultadoTextArea.setText(resultado.toString());
        } else {
            resultadoTextArea.setText("Ingresa una cantidad en Metros para convertir.");
        }
    }

    private void mostrarConversorTemperatura() {
        String cantidadTexto = entradaTexto.getText();
        if (!cantidadTexto.isEmpty()) {
            double temperaturaCelsius = Double.parseDouble(cantidadTexto);
            double temperaturaFahrenheit = (temperaturaCelsius * 9/5) + 32;
            DecimalFormat df = new DecimalFormat("#.##");

            StringBuilder resultado = new StringBuilder("Conversor de Temperatura:\n");
            resultado.append("Celsius a Fahrenheit: ").append(df.format(temperaturaFahrenheit)).append("\n");
            resultado.append("Fahrenheit a Celsius: ").append(df.format((temperaturaFahrenheit - 32) * 5/9));

            resultadoTextArea.setText(resultado.toString());
        } else {
            resultadoTextArea.setText("Ingresa una temperatura en grados Celsius para convertir.");
        }
    }

    private void mostrarCalculadoraSalario() {
        String cantidadTexto = entradaTexto.getText();
        if (!cantidadTexto.isEmpty()) {
            double salarioHora = Double.parseDouble(cantidadTexto);
            DecimalFormat df = new DecimalFormat("#.##");

            double salarioDia = salarioHora * 8;
            double salarioSemana = salarioDia * 5;
            double salarioMes = salarioSemana * 4;
            double salarioAnual = salarioMes * 12;

            StringBuilder resultado = new StringBuilder("Calculadora de Salario:\n");
            resultado.append("Salario por Hora: $").append(df.format(salarioHora)).append("\n");
            resultado.append("Salario por Día: $").append(df.format(salarioDia)).append("\n");
            resultado.append("Salario por Semana: $").append(df.format(salarioSemana)).append("\n");
            resultado.append("Salario por Mes: $").append(df.format(salarioMes)).append("\n");
            resultado.append("Salario Anual: $").append(df.format(salarioAnual));

            resultadoTextArea.setText(resultado.toString());
        } else {
            resultadoTextArea.setText("Ingresa el salario por hora para calcular.");
        }
    }

    private void limpiarResultado() {
        entradaTexto.setText("");
        resultadoTextArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ConversorUtilidadesGUI();
            }
        });
    }
}
