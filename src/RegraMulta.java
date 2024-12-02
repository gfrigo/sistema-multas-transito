public abstract class RegraMulta {
  private static double valorMultaLeve;
  private static double valorMultaMedia;
  private static double valorMultaGrave;

  public Multa calcularMulta(Ocorrencia ocorrencia, int nivel){ //calcula multa pelo nivel dela
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
    return new Multa(valorMulta, obterDescricaoMulta(), ocorrencia.getData(), ocorrencia.getPlaca());
  }

  public abstract int verificaNivelMulta(Ocorrencia ocorrencia);

  public abstract String obterDescricaoMulta();
}
