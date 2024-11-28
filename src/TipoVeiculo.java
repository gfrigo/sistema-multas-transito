public enum TipoVeiculo {
  VEICULO_LEVE(1, "Veículo leve"),
  CAMINHAO(2, "Caminhão");

  private final int codigo;
  private final String descricao;

  TipoVeiculo(int codigo, String descricao){
    this.codigo = codigo;
    this.descricao = descricao;
  }
}
