package interfaces.label;

import java.text.DecimalFormat;

public class Operaciones {

    private double valor, resultado;
    private int divisa, divisafinal;

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public double getResultado() {
        return resultado;
    }

    public void setResultado(double resultado) {
        this.resultado = resultado;
    }

    public int getDivisa() {
        return divisa;
    }

    public void setDivisa(int divisa) {
        this.divisa = divisa;
    }

    public int getDivisafinal() {
        return divisafinal;
    }

    public void setDivisafinal(int divisafinal) {
        this.divisafinal = divisafinal;
    }

    public Operaciones() {

    }
    double Euro = 1.08;
    double dolar = 1.0;
    double Soles = 0.27;
    double PesoMex = 0.053;
    double PesoCol = 0.00021;
    DecimalFormat df = new DecimalFormat("#.##");


    public double convertir(int index, double cantidad) {
        if (divisa == divisafinal) {
            resultado = valor;
        } else if (divisa == index && divisafinal==0){

            if (cantidad>1){
                resultado = valor * (dolar*cantidad);
            }else {
                resultado = valor * (cantidad/Euro);
            }

        } else if (divisa == index && divisafinal==1) {
            if(cantidad>1){
                resultado = valor * (dolar*cantidad);
            }else {
                resultado = valor * (cantidad/dolar);
            }
        } else if (divisa == index && divisafinal==2){
            resultado = valor * (dolar*(cantidad/Soles));
        } else if (divisa == index && divisafinal==3){
            resultado = valor * (dolar*(cantidad/PesoMex));
        } else {
            resultado = valor * (dolar*(cantidad/PesoCol));
        }
        return resultado = Double.parseDouble(df.format(resultado));
    }
}

