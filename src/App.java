import java.util.Scanner;

public class App {

    static Scanner teclado = new Scanner(System.in);
    static ContaBancaria conta;
    static Pessoa cliente;

    static Banco banco = new Banco("TADSBank");

    static String imprimirMenu(){
        String str="";
        str += "###-TADSBank-###\n";
        str += "1 - Cadastrar pessoa\n";
        str += "2 - Buscar pessoa\n";
        str += "3 - Listar pessoas\n";
        str += "4 - Cadastrar conta\n";
        str += "5 - Sacar\n";
        str += "6 - Depositar\n";
        str += "7 - Ver dados\n";
        str += "0 - Sair\n";
        str += "Digite uma opção:";

        return str;
    }

    static void cadastrarPessoa(){
        String nomeCliente;
        String cpf;
        int idade;
        double salario;

        System.out.println("Digite o nome do cliente:");
        nomeCliente = teclado.nextLine();
        System.out.println("Digite os 11 digitos do seu cpf:");
        cpf = teclado.nextLine();
        System.out.println("Digite a sua idade");
        idade = teclado.nextInt();
        System.out.println("Digite o seu salario:");
        salario = teclado.nextDouble();

        cliente = new Pessoa(nomeCliente, cpf, idade, salario);

        banco.cadastrarPessoa(cliente);
    }

    static void buscarPessoa(){
        String cpf;

        System.out.println("Digite o cpf que deseja buscar:");
        cpf = teclado.nextLine();

        System.out.println(banco.buscarPessoa(cpf));
    }

    static void listarPessoas(){
       System.out.println(banco.listarPessoas());
    }

    static void criarConta(){
        
        String cpf;
        String numero;
        String agencia;

        System.out.println("Digite o cpf cadastrado:");
        cpf = teclado.nextLine();

        if(banco.verificaCpf(cpf) == true){
        System.out.println("Digite o número da conta:");
        numero = teclado.nextLine();
        System.out.println("Digite a agência da conta:");
        agencia = teclado.nextLine();

        conta = new ContaBancaria(agencia,numero, banco.buscarPessoa(cpf));

        System.out.println("************");
        
        //adicionando um conta na coleção de contas
        banco.criarConta(conta);

        } else{
            System.out.println("CPF não enncontrado.");
        }
    }

    static void sacar(){
        double valor;
        String numero;
        String agencia;
        

        System.out.println("Digite o numero da conta:");
        numero = teclado.nextLine();
        
        System.out.println("Digite o numero da agencia:");
        agencia = teclado.nextLine();
        

        System.out.println("Digite um valor:");
        valor = teclado.nextDouble();


        System.out.println(banco.sacar(numero, agencia, valor));

        System.out.println("************");
    }

    static void depositar(){
        double valor;
        String numero;
        String agencia;
        

        System.out.println("Digite o numero da conta:");
        numero = teclado.nextLine();
        
        System.out.println("Digite o numero da agencia:");
        agencia = teclado.nextLine();
        

        System.out.println("Digite um valor:");
        valor = teclado.nextDouble();

        String retorno = banco.depositar(numero,agencia,valor);
        System.out.println(retorno);
        System.out.println("************");
    }

    static void mostrarDados(){
        System.out.println(banco.mostrarSaldo());
    }


    public static void main(String[] args) {

        int opcao=0;

        do{
            System.out.println(imprimirMenu());
            opcao = teclado.nextInt();
            teclado.nextLine();

            switch(opcao){
                case 1:
                    cadastrarPessoa();
                break;
                case 2:
                    buscarPessoa();;
                break;
                case 3:
                    listarPessoas();
                break;
                case 4:
                    criarConta();
                break;
                case 5:
                    sacar();
                break;
                case 6:
                    depositar();
                break;
                case 7:
                    mostrarDados();
                break;
                default:
                    if(opcao != 0){
                        System.out.println("Opção inválida!!");
                    }
            }
        }while(opcao != 0);
    }
    
}