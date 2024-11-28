public class RegraCorredorOnibus extends RegraMulta{
  private int horaInicial;
  private int horaFinal;
  private String nomeLogradouro;

  public RegraCorredorOnibus(int inicio, int fim, String logra){
    this.horaInicial = inicio;
    this.horaFinal = fim;
    this.nomeLogradouro = logra;
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
