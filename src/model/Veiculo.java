package model;

public class Veiculo {

    private String modelo;
    private String marca;
    private String cor;
    private String placa;
    private Condutor condutor;

    public Veiculo(){

    }

    public Veiculo(String modelo, String marca, String cor, String placa, Condutor condutor) {
        this.modelo = modelo;
        this.marca = marca;
        this.cor = cor;
        this.placa = placa;
        this.condutor = condutor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    @Override
    public String toString() {
        return  "Modelo:' " + modelo + '\'' +
                ", Marca: '" + marca + '\'' +
                ", Cor: '" + cor + '\'' +
                ", Placa: '" + placa + '\'' +
                ", Condutor: " + condutor + "\n";
    }
}
