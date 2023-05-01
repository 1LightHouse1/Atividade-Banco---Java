
//importações

public class ContaBancaria{

    //atributos
    private String agencia;
    private String numero;
    private double saldo=0;
    private String cliente;



    public ContaBancaria(String agencia, String numero, String cliente){
        this.agencia = agencia;
        this.numero = numero;      
        this.cliente = cliente;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public String getNumero(){
        return numero;
    }

    public String getAgencia(){
        return agencia;
    }

    public String getCliente(){
        return cliente;
    }

    public double getSaldo(){
        return saldo;
    }

    //metodos
    String depositar(double valor){

        if(valor < 0){
            return "Valor inválido!";
        }
        saldo = saldo + valor;
        return "ok";
    }

    String sacar(double valor){
        if(valor < 0){
            return "Valor inválido!";
        }
        if(valor > saldo){
            return "Saldo insuficiente!";
        }

        saldo = saldo - valor;
        return "ok";

    }
}