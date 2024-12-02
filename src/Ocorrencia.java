import java.util.Date;

public class Ocorrencia {
  private String placa;
  private Date data;
  private String nomeLogradouro;
  private int velocidade;
  private int tipoVeiculo;

  public Ocorrencia(String placa, Date data, String nomeLogradouro, int velocidade, int tipoVeiculo) {
    this.placa = placa;
    this.data = data;
    this.nomeLogradouro = nomeLogradouro;
    this.velocidade = velocidade;
    this.tipoVeiculo = tipoVeiculo;
}

// metodos get e set

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getNomeLogradouro() {
    return nomeLogradouro;
  }

  public void setNomeLogradouro(String nomeLogradouro) {
    this.nomeLogradouro = nomeLogradouro;
  }

  public int getVelocidade() {
    return velocidade;
  }

  public void setVelocidade(int velocidade) {
    this.velocidade = velocidade;
  }

  public int getTipoVeiculo() {
    return tipoVeiculo;
  }

  public void setTipoVeiculo(int tipoVeiculo) {
    this.tipoVeiculo = tipoVeiculo;
  }

  //serve para exibir melhor os dados
  @Override
  public String toString() {
    return "Nova Ocorrencia { " +
            "placa = '" + placa + '\'' +
            ", data = " + data +
            ", nomeLogradouro = '" + nomeLogradouro + '\'' +
            ", velocidade = " + velocidade +
            ", tipoVeiculo = " + (tipoVeiculo == 0 ? "Veículo leve" : "Caminhão") +
            '}';
  }


}
