import java.util.ArrayList;

public class Pessoa {
    
    private String nome;
    private String cpf;
    private int idade;
    private double salario;


    public Pessoa(String nome, String cpf, int idade, double salario){
        this.nome = nome;
        this.cpf = cpf;
        this.idade = idade;
        this.salario = salario;
    }

    public void setNome(String nome){
        this.nome = nome;
    }   
    
    public String getNome(){
        return nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    } 

    public String getCpf(){
        return cpf;
    }
    
    public void setIdade(int nome){
        this.idade = idade;
    }   
    
    public int getIdade(){
        return idade;
    }

    public void setSalario(double setSalario){
        this.salario = salario;
    }

    String relatorioPessoa(){
        String texto = "";

        texto = "Nome: " + nome +
                " Cpf: " + cpf;

        return texto;
    }
    
}