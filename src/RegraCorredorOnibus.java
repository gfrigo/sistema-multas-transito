public class RegraCorredorOnibus extends RegraMulta{
  private int horaInicial;
  private int horaFinal;
  private String nomeLogradouro;

  public RegraCorredorOnibus(String nomeLogradouro, int horaInicial, int horaFinal) {
    super(nomeLogradouro); // Define o logradouro no construtor da superclasse
    this.horaInicial = horaInicial;
    this.horaFinal = horaFinal;
    this.nomeLogradouro = nomeLogradouro;
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
  public String obterDescricaoMulta(Ocorrencia ocorrencia) {
    return "Trânsito irregular no corredor de ônibus em " + nomeLogradouro +
           " no horário entre " + horaInicial + "h e " + horaFinal + "h.";
}

}
