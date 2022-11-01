package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Vaga {

    private String idVaga;
    private String horaEntrada;
    private String horaSaida;
    private double valorFinal;
    private Veiculo veiculo;
    public Vaga() {

    }

    public Vaga(String idVaga, String horaEntrada, Veiculo veiculo) {
        this.idVaga = idVaga;
        this.horaEntrada = horaEntrada;
        this.veiculo = veiculo;
    }

    public String getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(String idVaga) {
        this.idVaga = idVaga;
    }

    public String getHoraEntrada() {

        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {

        this.horaEntrada = horaEntrada;
    }

    public String getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(String horaSaida) {
        this.horaSaida = horaSaida;

    }

    public double getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

}
