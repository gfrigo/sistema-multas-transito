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

  public int getCodigo() {
      return codigo;
  }

  public String getDescricao() {
      return descricao;
  }

  // metodo para obter o NivelMulta a partir do código
  public static NivelMulta codigo(int codigo) {
    for (NivelMulta nivel : values()) {
        if (nivel.getCodigo() == codigo) {
            return nivel;
        }
    }
    throw new IllegalArgumentException("Código de nível de multa inválido: " + codigo);
  }

}
