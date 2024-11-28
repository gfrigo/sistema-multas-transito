public class RegraRodizio extends RegraMulta {
  private int finalPlaca;
  private String[] logradourosAfetados;
  private int diaDaSemana;
  private int tipoVeiculo;

  public RegraRodizio(int placa, String[] logra, int dia, int tipoVeic){
    this.finalPlaca = placa;
    this.logradourosAfetados = logra;
    this.diaDaSemana = dia;
    this.tipoVeiculo = tipoVeic;
  }

    /* Implementar métodos abstratos: 
  ->verificaNivelMulta()
  -> obterDescricaoMulta()
  (provenientes da classe RegraMulta)*/

  @Override
  public int verificaNivelMulta(Ocorrencia o){};

  @Override
  public String obterDescricaoMulta(){};
}
