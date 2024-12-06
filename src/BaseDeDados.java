import java.util.ArrayList;
import java.util.List;

public class BaseDeDados {
  private List<Ocorrencia> ocorrenciasSemProcessar; 
  private List<Ocorrencia> ocorrenciasProcessadas;  
  private List<Multa> multas;                      
  private List<RegraMulta> regras;

  public BaseDeDados() {
    this.ocorrenciasSemProcessar = new ArrayList<>();
    this.ocorrenciasProcessadas = new ArrayList<>();
    this.multas = new ArrayList<>();
    this.regras = new ArrayList<>();
  }

  public void inicializarRegras() {
    // Adiciona algumas regras de velocidade
    regras.add(new RegraVelocidade(60, "Avenida Paulista"));
    regras.add(new RegraVelocidade(50, "Avenida Rebouças"));
    regras.add(new RegraVelocidade(90, "Marginal Pinheiros"));
    regras.add(new RegraVelocidade(50, "Avenida Eng. Eusébio Stevaux"));
    regras.add(new RegraVelocidade(50, "Avenida das Nações Unidas"));
    regras.add(new RegraVelocidade(70, "Avenida Rebouças"));
    regras.add(new RegraVelocidade(50, "Rua Mourato Coelho"));
    regras.add(new RegraVelocidade(30, "Rua Fiorelli Peccicacco"));
    regras.add(new RegraVelocidade(30, "Rua Clélia"));

    //adicionando algumas regras de rodízio, dias de 1 a 7, sendo 1 = domingo e 7 = sábado
    regras.add(new RegraRodizio(1, new String[]{"Avenida Ayrton Senna"}, 2, 0)); // Final de placa 1, veículos leves, segunda
    regras.add(new RegraRodizio(7, new String[]{"Marginal Tietê"}, 1, 1)); // Final de placa 7, caminhões, domingo
    regras.add(new RegraRodizio(5, new String[]{"Marginal Pinheiros"}, 4, 1)); // Final de placa 5, caminhões, quarta-feira
    regras.add(new RegraRodizio(3, new String[]{"Avenida dos Bandeirantes"}, 5, 0)); // Final de placa 3, veículo leve, quinta-feira

    //adicionando algumas regras de corredor de ônibus
    regras.add(new RegraCorredorOnibus(6, 10, "Rua Consolação")); // Corredor de ônibus das 6h às 10h
    regras.add(new RegraCorredorOnibus(16, 20, "Avenida Santo Amaro")); // Corredor de ônibus das 16h às 20h
    regras.add(new RegraCorredorOnibus(6, 10, "Vila Hamburguesa")); // Corredor de ônibus das 6h às 10h
    regras.add(new RegraCorredorOnibus(8, 14, "Avenida Doutora Ruth Cardoso")); // Corredor de ônibus das 8h às 14h
    regras.add(new RegraCorredorOnibus(6, 12, "Avenida Giovanni Gronchi")); // Corredor de ônibus das 6h ao 12h
    regras.add(new RegraCorredorOnibus(16, 20, "Avenida Guido Caloi")); // Corredor de ônibus das 16h às 20h
}


  public void adicionarOcorrencia(Ocorrencia ocorrencia) { //adiciona uma ocorrencia não processada
    ocorrenciasSemProcessar.add(ocorrencia);
  }

  public void processar(){ //processa as ocorrencias adicionadas
    for (Ocorrencia ocorrencia : ocorrenciasSemProcessar) { // o operador : adiciona todos os valores disponiveis
      boolean foiProcessada = false;

      for (RegraMulta regra : regras) { //adiciona todas as regras na ocorrencia
          int nivelMulta = regra.verificaNivelMulta(ocorrencia);
          if (nivelMulta > 0) { //se na regra mostrar que tomou multa
              Multa multa = regra.calcularMulta(ocorrencia, nivelMulta);
              multas.add(multa);
              foiProcessada = true;
          }
      }

      // após finalizar, move a ocorrencia para a lista de ja processadas
      if (foiProcessada) {
          ocorrenciasProcessadas.add(ocorrencia);
      }
    }

  //por fim, limpa a lista de ocorrencias não processadas
    ocorrenciasSemProcessar.clear();
  }

  // gera o relatorio de multas
  public void exibirRelatorioMultas() {
      for (Multa multa : multas) {
        System.out.println(multa);
      }
  }

  public List<Ocorrencia> getOcorrenciasSemProcessar() {
      return ocorrenciasSemProcessar;
  }

  public List<Ocorrencia> getOcorrenciasProcessadas() {
      return ocorrenciasProcessadas;
  }

  public List<Multa> getMultas() {
      return multas;
  }

  public List<RegraMulta> getRegras() {
    return regras;
}
  
}

