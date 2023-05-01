import java.util.ArrayList;

public class Banco {
    
    private ArrayList<ContaBancaria> contas;
    private ArrayList<Pessoa> pessoas;
    private String nome;


    public Banco(String nome){
        this.nome = nome;
        this.contas = new ArrayList<>();
        this.pessoas = new ArrayList<>();
    }


    public void criarConta(ContaBancaria conta){
        contas.add(conta);
    }

    public void cadastrarPessoa(Pessoa cliente){
        pessoas.add(cliente);
    }

    public String sacar(String numero, String agencia, double valor){

        
        for(ContaBancaria aux:contas){
            if(aux.getNumero().equals(numero) && 
               aux.getAgencia().equals(agencia)){
                return aux.sacar(valor);
            }
        }

        return "Conta não encontrada!!";

    }

    public String depositar(String numero, String agencia, double valor){

        
        for(ContaBancaria aux:contas){
            if(aux.getNumero().equals(numero) && 
               aux.getAgencia().equals(agencia)){
                return aux.depositar(valor);
            }
        }

        return "Conta não encontrada!!";

    }

    public boolean verificaCpf(String cpf){
        
        for(Pessoa aux:pessoas){
            if(aux.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public String buscarPessoa(String cpf){

        
        for(Pessoa aux:pessoas){
            if(aux.getCpf().equals(cpf)){
                return aux.relatorioPessoa()+"\n";
            }
        }

        return "Pessoa não encontrada!!";

    }

    public String listarPessoas(){
        String lista = "";

        for(Pessoa aux:pessoas){
            lista += aux.getNome() + "\n";
        
        }

        return lista + "\n";
    }

    public String mostrarSaldo(){
        String texto = "";

        for(ContaBancaria aux:contas){
            texto += "Agência: " + aux.getAgencia() +
                    " Número: " + aux.getNumero() +
                    " Saldo: " + aux.getSaldo() +
                    " Cliente: " + aux.getCliente() + "\n";
        
        }

        return texto;
    }
}