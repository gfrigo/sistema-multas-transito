import java.util.Date;

public class Multa {
  private double valor;
  private String motivo;
  private Date data;
  private String placa;

  public Multa(double valor, String motivo, Date data, String placa){
    this.valor = valor;
    this.motivo = motivo;
    this.data = data;
    this.placa = placa;
  }

  // metodos de Get e Set
  public double getValor() {
    return valor;
  }

  public void setValor(double valor){
    this.valor = valor;
  }

  public String getMotivo() {
    return motivo;
  }

  public void setMotivo(String motivo) {
    this.motivo = motivo;
  }

  public Date getData() {
    return data;
  }

  public void setData(Date data) {
    this.data = data;
  }

  public String getPlaca() {
    return placa;
  }

  public void setPlaca(String placa) {
    this.placa = placa;
  }

  //serve para exibir melhor os dados
  @Override
  public String toString() {
    return "Multa Aplicada{ " +
    "valor = " + valor +
    ", motivo = '" + motivo + '\'' +
    ", data = " + data +
    ", placa = '" + placa + '\'' +
    '}';
  }

}


