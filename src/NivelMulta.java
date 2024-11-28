public enum NivelMulta {
  SEM_MULTA(0, "Sem multa"),
  MULTA_LEVE(1, "Multa leve"),
  MULTA_MEDIA(2, "Multa média"),
  MULTA_GRAVE(3, "Multa grave");

  private final int codigo;
  private final String descricao;

  NivelMulta(int codigo, String descricao){
    this.codigo = codigo;
    this.descricao = descricao;
  }
}
