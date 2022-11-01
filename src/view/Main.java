package view;

import model.Condutor;
import model.Estacionamento;
import model.Vaga;
import model.Veiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {

    public static void main(String[] args) throws ParseException {

            Scanner sc = new Scanner(System.in);
            Estacionamento estacionamento = new Estacionamento();

            metodoPrincipal(estacionamento);

            System.out.println("Exibir menu de opções?");
            System.out.print("1 - Sim\n2 - Voltar para cadastro\n0 - Encerrar expediente\n");
            System.out.print("Digite a opção: ");
            int opcao = sc.nextInt();

            while(opcao != 0) {
                System.out.println("Escolha uma opção");
                System.out.print("1 - Ver informações de condutor\n" +
                        "2 - Ver informações de veículo\n" +
                        "3 - Ver data/hora de entrada\n" +
                        "4 - Ver data/hora de saída\n" +
                        "5 - Ver vaga onde estacionou\n" +
                        "6 - Ver vagas disponíveis\n" +
                        "7 - Vagas ocupadas com respectivo veículo\n" +
                        "8 - Liberar vaga\n" +
                        "9 - Exibir valor do caixa\n" +
                        "10 - Exibir histórico\n" +
                        "11 - Retornar para cadastro\n");
                System.out.print("Opção: ");
                int opcaoMenu = sc.nextInt();
                switch (opcaoMenu) {
                    case 1:
                        System.out.print("Digite o documento do condutor: ");
                        int documento = sc.nextInt();
                        estacionamento.buscarCondutor(documento);
                        break;
                    case 2:
                        System.out.print("Digite a vaga do veículo: ");
                        String idVaga = sc.next();
                        estacionamento.buscaCarro(idVaga);
                        break;
                    case 3:
                        System.out.print("Digite a placa do carro: ");
                        String placa = sc.next();
                        estacionamento.buscarHoraDeEntrada(placa);
                        break;
                    case 4:
                        System.out.print("Digite a placa do carro: ");
                        placa = sc.next();
                        estacionamento.buscarHoraDeSaida(placa);
                        break;
                    case 5:
                        System.out.print("Digite a placa do veículo: ");
                        placa = sc.next();
                        estacionamento.buscaVaga(placa);
                        break;
                    case 6:
                        estacionamento.mostrarVagasDisponiveis();
                        break;
                    case 7:
                        estacionamento.mostrarVagasOcupadas();
                        break;
                    case 8:
                        System.out.print("Digite o id da vaga: ");
                        idVaga = sc.next();
                        System.out.print("Digite a data e hora de saída no formato dd/MM/yyyy HH:mm: ");
                        sc.nextLine();
                        String horaSaida = sc.nextLine();
                        estacionamento.desocuparVaga(idVaga, horaSaida);
                        break;
                    case 9:
                        estacionamento.valorCaixa();
                        break;
                    case 10:
                        estacionamento.mostrarHistorico();
                        break;
                    case 11:
                        metodoPrincipal(estacionamento);
                        break;

                }
                System.out.println("Voltar para menu?");
                System.out.print("1 - Sim\n2 - Voltar para cadastro\n0 - Encerrar expediente\n");
                System.out.print("Digite a opção:");
                opcao = sc.nextInt();
                if(opcao == 2){
                    metodoPrincipal(estacionamento);
                }
                if(opcao == 0){
                    System.out.println("Expediente encerrado!");
                    opcao = 0;
                }
            }

        }

        public static void metodoPrincipal(Estacionamento estacionamento){
            Scanner sc = new Scanner(System.in);

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

            System.out.println("====ESTACIONAMENTO DO TIO====");
            System.out.println("Novo cadastro ou liberar vaga?");
            System.out.print("1 - Cadastro\n2 - Liberar Vaga\n");
            System.out.print("Digite a opção: ");
            int resposta = sc.nextInt();


            while (resposta == 1) {

                //Cadastro dos dados do condutor
                System.out.println("====DADOS DO CONDUTOR====");
                System.out.print("Digite o documento do condutor: ");
                int documento = sc.nextInt();
                System.out.print("Digite o telefone do condutor: ");
                int telefone = sc.nextInt();
                System.out.print("Digite o nome do condutor: ");
                String nome = sc.next();
                System.out.println();
                Condutor condutor = new Condutor(nome, documento, telefone);

                //Cadastro dos dados do carro
                System.out.println("====DADOS DO CARRO====");
                System.out.print("Digite a marca do carro: ");
                String marca = sc.next();
                System.out.print("Digite o modelo do carro: ");
                String modelo = sc.next();
                System.out.print("Digite a cor do carro: ");
                String cor = sc.next();
                System.out.print("Digite a placa do carro: ");
                String placa = sc.next();
                System.out.println();
                Veiculo veiculo = new Veiculo(modelo, marca, cor, placa, condutor);

                //Criação de vaga e ocupação de vaga
                System.out.println("====VAGAS DISPONÍVEIS====");
                estacionamento.mostrarVagasDisponiveis();
                System.out.print("Escolha uma vaga disponível: ");
                String idVaga = sc.next();
                System.out.print("Digite a data e hora no formato dd/MM/yyyy HH:mm: ");
                sc.nextLine();
                String hora = sc.nextLine();
                Vaga vaga = new Vaga(idVaga, hora, veiculo);
                estacionamento.ocuparVaga(vaga);
                System.out.println("Nova vaga ocupada");

                //Pergunta para ver se deseja ocupar mais vagas ou ir para outras opções
                System.out.println();
                System.out.println("1 - Cadastrar nova vaga\n2 - Sair do cadastro\n");
                System.out.print("Digite a opção: ");
                resposta = sc.nextInt();
                if (resposta == 2) {
                    resposta = 2;
                }
            }
        }
    }

