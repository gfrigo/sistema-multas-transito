public enum TipoVeiculo {
  VEICULO_LEVE(1, "Veículo leve"),
  CAMINHAO(2, "Caminhão");

  private final int codigo;
  private final String descricao;

  TipoVeiculo(int codigo, String descricao){
      this.codigo = codigo;
      this.descricao = descricao;
  }

  public int getCodigo() {
      return codigo;
  }

  public String getDescricao() {
      return descricao;
  }

  // função para obter o TipoVeiculo a partir do código
  public static TipoVeiculo codigo(int codigo) {
    for (TipoVeiculo tipo : values()) {
        if (tipo.getCodigo() == codigo) {
            return tipo;
        }
    }
    throw new IllegalArgumentException("Código de veículo inválido: " + codigo);
  }

}
