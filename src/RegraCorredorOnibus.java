public class RegraCorredorOnibus extends RegraMulta{
  private int horaInicial;
  private int horaFinal;
  private String nomeLogradouro;

  public RegraCorredorOnibus(/*int inicio, int fim, String logra*/){
    /*this.horaInicial = inicio;
    this.horaFinal = fim;
    this.nomeLogradouro = logra;*/
  }

    /* Implementar métodos abstratos: 
  ->verificaNivelMulta()
  -> obterDescricaoMulta()
  (provenientes da classe RegraMulta)*/

  @Override
  public int verificaNivelMulta(Ocorrencia ocorrencia){
    if (ocorrencia.getNomeLogradouro().toLowerCase().contains("corredor ônibus")) { // verifica se é corredor de onibus
      return NivelMulta.MULTA_GRAVE.getCodigo(); // é grave
  }
  return NivelMulta.SEM_MULTA.getCodigo(); // Sem multa
  };

  @Override
  public String obterDescricaoMulta(Ocorrencia ocorrencia){
    return "Veículo trafegando em corredor exclusivo de ônibus em " +
                ocorrencia.getNomeLogradouro() + ".";
  };

}
