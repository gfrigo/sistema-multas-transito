public abstract class RegraMulta {
  private static double valorMultaLeve;
  private static double valorMultaMedia;
  private static double valorMultaGrave;

  public Multa calcularMulta(Ocorrencia o){}

  public abstract int verificaNivelMulta(Ocorrencia o);

  public abstract String obterDescricaoMulta();
}
