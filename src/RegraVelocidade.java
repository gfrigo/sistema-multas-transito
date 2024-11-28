public class RegraVelocidade extends RegraMulta {
  private int velocidadeMaxima;
  private String nomeLogradouro;
  private static double porcentagemMultaMedia = 0.1;
  private static double porcentagemMultaGrave = 0.4;

  public RegraVelocidade(int velMax, String logra){
    this.velocidadeMaxima = velMax;
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
