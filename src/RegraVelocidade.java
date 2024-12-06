public class RegraVelocidade extends RegraMulta {
  private int velocidadeMaxima; //podemos alterar o valor, coloquei para teste
  private String nomeLogradouro; //tem que colocar alguma coisa pra puxar isso aqui
  private static double porcentagemMultaMedia = 0.1; //10%
  private static double porcentagemMultaGrave = 0.4; //40%

  public RegraVelocidade(int velocidadeMaxima, String nomeLogradouro) {
    super(nomeLogradouro);
    this.velocidadeMaxima = velocidadeMaxima;
  }

  /* Implementar métodos abstratos: 
  ->verificaNivelMulta()
  -> obterDescricaoMulta()
  (provenientes da classe RegraMulta)*/

  @Override
  public int verificaNivelMulta(Ocorrencia ocorrencia){
    int velocidadeRegistrada = ocorrencia.getVelocidade();
        int velocidadePermitida = velocidadeMaxima; //aqui é onde definimos a velocidade que é permitida na via

        // Define o limite de velocidade com base no tipo do veículo
        if (ocorrencia.getTipoVeiculo() == TipoVeiculo.CAMINHAO.getCodigo()) {
            velocidadePermitida -= 10; // caminhão tem limite de -10
        }

        int excessoVelocidade = velocidadeRegistrada - velocidadePermitida; // calculo do excesso de velocidade

        if (excessoVelocidade <= 0) {
            return NivelMulta.SEM_MULTA.getCodigo(); // sem multa
        } else if (excessoVelocidade <= velocidadePermitida * porcentagemMultaMedia) {
            return NivelMulta.MULTA_LEVE.getCodigo(); // multa leve
        } else if (excessoVelocidade <= velocidadePermitida * porcentagemMultaGrave) {
            return NivelMulta.MULTA_MEDIA.getCodigo(); // multa media
        } else {
            return NivelMulta.MULTA_GRAVE.getCodigo(); // multa grave, fez merda
        }
  };

  @Override
  public String obterDescricaoMulta(Ocorrencia ocorrencia){
    return "Excesso de velocidade registrado em " + ocorrencia.getNomeLogradouro() +
                ". Velocidade máxima permitida: " + velocidadeMaxima + " km/h " +
                "(caminhões têm limite reduzido em 10 km/h).";
  };

}
