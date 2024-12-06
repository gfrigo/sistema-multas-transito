public abstract class RegraMulta {
  //private String nomeLogradouro;
  private static double valorMultaLeve = 100.0;
  private static double valorMultaMedia = 250.0;
  private static double valorMultaGrave = 500.0;

    /* 
  public RegraMulta(String nomeLogradouro) {
    this.nomeLogradouro = nomeLogradouro;
  }

    
  public String getNomeLogradouro() {
    return nomeLogradouro;
  }
*/
  public abstract int verificaNivelMulta(Ocorrencia ocorrencia);

  public abstract String obterDescricaoMulta(Ocorrencia ocorrencia);

  public Multa calcularMulta(Ocorrencia ocorrencia, int nivel){ //calcula multa pelo nivel dela
    String motivo = obterDescricaoMulta(ocorrencia);
    double valorMulta;
    switch (nivel) {
      case 1:
        valorMulta = valorMultaLeve;
        break;

      case 2:
        valorMulta = valorMultaMedia;
        break;

      case 3:
        valorMulta = valorMultaGrave;
        break;

      default:
        valorMulta = 0.0;
        break;
    }
    return new Multa(valorMulta, motivo, ocorrencia.getData(), ocorrencia.getPlaca());
  }


}
