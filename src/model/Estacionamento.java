package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class Estacionamento {

    private LocalDateTime hora;
    private double valorFinal;
    private final double valorHora = 2.0;
    public ArrayList<Vaga> vaga = new ArrayList<>();

    List<String> vagasDisponiveis = new ArrayList<>(Arrays.asList
            ("A1", "A2", "A3", "A4", "A5", "A6", "A7", "A8", "A9", "A10",
                    "B11", "B12", "B13", "B14", "B15", "B16", "B17", "B18", "B19", "B20",
                    "C21", "C22", "C23", "C24", "C25", "C26", "C27", "C28", "C29", "C30",
                    "D31", "D32", "D33", "D34", "D35", "D36", "D37", "D38", "D39", "D40",
                    "E41", "E42", "E43", "E44", "E45", "E46", "E47", "E48", "E49", "E50"));

    List<String> vagasOcupadas = new ArrayList<>();
    List<Vaga> historicoEstacionamento = new ArrayList<>();


    public Estacionamento() {

    }

    public Estacionamento(LocalDateTime hora) {
        this.hora = hora;
    }

    public LocalDateTime getHora() {
        return hora;
    }

    public void setHora(LocalDateTime hora) {
        this.hora = hora;
    }

    public double getValorHora() {
        return valorHora;
    }


    public void ocuparVaga(Vaga v) {
        String vagaOcupada = "";
        vaga.add(v);
        historicoEstacionamento.add(v);
        vagasOcupadas.add(v.getIdVaga());
        vagaOcupada = v.getIdVaga();
        removerVagaEscolhida(vagaOcupada);
    }


    public void desocuparVaga(String idVaga, String horaSaida) throws ParseException {
        Vaga vagaRemover = null;
        String adicionarVaga = "";
        boolean encontrada = false;
        String entrada = "";
        String saida = "";

        for (Vaga v : vaga) {
            if (idVaga.equalsIgnoreCase(v.getIdVaga())) {
                adicionarVaga = idVaga;
                v.setHoraSaida(horaSaida);
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
                Date horaDeEntrada = sdf.parse(v.getHoraEntrada());
                Date horadeSaida = sdf.parse(v.getHoraSaida());
                long millisEntrada = horaDeEntrada.getTime();
                long millisSaida = horadeSaida.getTime();
                long diferencaHora = TimeUnit.MILLISECONDS.toHours(millisSaida) - TimeUnit.MILLISECONDS.toHours(millisEntrada);
                this.valorFinal = diferencaHora * valorHora;
                encontrada = true;
                vagaRemover = v;
                System.out.println("Vaga liberada!");
                System.out.println("Total a pagar: R$" + valorFinal);
            }
        }
        if (!encontrada) {
            System.out.println("Essa vaga não está ocupada");
        }

        vaga.remove(vagaRemover);
        vagasDisponiveis.add(adicionarVaga);
        Collections.sort(vagasDisponiveis);
    }

    public void removerVagaEscolhida(String v) {
        String remover = "";
        for (String vagaProcurada : vagasDisponiveis) {
            if (v.equalsIgnoreCase(vagaProcurada)) {
                remover = vagaProcurada;
            }
        }
        vagasDisponiveis.remove(remover);
    }

    public void buscarHoraDeEntrada(String placa) {
        String horaEntrada = "";
        for (Vaga carroProcurado : vaga) {
            if (placa.equalsIgnoreCase(carroProcurado.getVeiculo().getPlaca())) {
                horaEntrada = carroProcurado.getHoraEntrada();
            }
        }
        System.out.println(horaEntrada);
    }

    public void buscarHoraDeSaida(String placa) {
        String horaSaida = "";
        for (Vaga carroProcurado : vaga) {
            if (placa.equalsIgnoreCase(carroProcurado.getVeiculo().getPlaca())) {
                horaSaida = carroProcurado.getHoraSaida();
                System.out.println(horaSaida);
            }
            if(placa.equalsIgnoreCase(carroProcurado.getVeiculo().getPlaca())){
                if(carroProcurado.getHoraSaida() == null){
                    System.out.println("Sem horário de saída, carro se localiza no estacionamento.");
                }
            }
        }
    }

    public void buscaCarro(String v) {
        boolean encontrado = false;
        for (Vaga vagaProcurada : vaga) {
            if (v.equalsIgnoreCase(vagaProcurada.getIdVaga())) {
                System.out.println("O seguinte carro se encontra na vaga " + vagaProcurada.getIdVaga() + ": \n" +
                        "Marca: " + vagaProcurada.getVeiculo().getMarca() + "\n" +
                        "Modelo: " + vagaProcurada.getVeiculo().getModelo() + "\n" +
                        "Cor: " + vagaProcurada.getVeiculo().getCor() + "\n" +
                        "Placa: " + vagaProcurada.getVeiculo().getPlaca() + "\n");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("ID de vaga inexistente");
        }
    }

    public void buscaVaga(String placa) {
        boolean encontrado = false;
        for (Vaga placaProcurada : vaga) {
            if (placa.equalsIgnoreCase(placaProcurada.getVeiculo().getPlaca())) {
                encontrado = true;
                System.out.println("O carro com a placa " + placa + " se encontra na vaga " + placaProcurada.getIdVaga());
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Não existe nenhum veículo com essa placa");
        }
    }

    public void buscarCondutor(int documento) {
        boolean encontrado = false;
        for (Vaga condutorProcurado : vaga) {
            if (documento == condutorProcurado.getVeiculo().getCondutor().getDocumento()) {
                encontrado = true;
                System.out.println("Documento: " + condutorProcurado.getVeiculo().getCondutor().getDocumento());
                System.out.println("Nome: " + condutorProcurado.getVeiculo().getCondutor().getNome());
                System.out.println("Telefone: " + condutorProcurado.getVeiculo().getCondutor().getTelefone());
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Condutor não encontrado, confira o documento");
        }
    }

    public void valorCaixa() {
        double valorDoCaixa = 0.0;
        valorDoCaixa += this.valorFinal;
        System.out.println("Valor do caixa: RS" + valorDoCaixa);

    }

    public void mostrarVagasDisponiveis() {
        System.out.println("Vagas disponiveis: ");
        int count = 1;
        for (String v : vagasDisponiveis) {
            System.out.print(v + " ");
            if (count % 10 == 0) {
                System.out.print("\n");
            }
            count++;
        }
        System.out.println();
    }

    public void mostrarVagasOcupadas() {
        System.out.println("Vagas ocupadas");
        int count = 1;
        for (Vaga v : vaga) {
            System.out.print("Vaga: " + v.getIdVaga() + ", Veículo: " + v.getVeiculo() + " ");
            if (count % 10 == 0) {
                System.out.print("\n");
            }
            count++;
        }
        System.out.println();
    }

    public void mostrarHistorico() {
        for (Vaga v : historicoEstacionamento) {
            if (v.getHoraSaida() != null) {
                System.out.println("Vaga " + v.getIdVaga() + " desocupada. Placa do veícuulo: " + v.getVeiculo().getPlaca() + ". Horário de saída: " + v.getHoraSaida());
            }
            if (v.getHoraSaida() == null) {
                System.out.println("Vaga " + v.getIdVaga() + " ocupada. Placa do veículo: " + v.getVeiculo().getPlaca());
            }
        }
        if (historicoEstacionamento.isEmpty()) {
            System.out.println("Ainda não existem dados no histórico");
        }

    }
}
