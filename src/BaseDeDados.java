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
    regras.add(new RegraVelocidade(70, "Avenida Santo Amaro"));
    regras.add(new RegraVelocidade(50, "Rua Consolação"));
    regras.add(new RegraVelocidade(90, "Marginal Tietê"));
    regras.add(new RegraVelocidade(30, "Rua Clélia"));
    regras.add(new RegraVelocidade(50, "Avenida Ayrton Senna"));

    //adicionando algumas regras de rodízio, dias de 1 a 7, sendo 1 = domingo e 7 = sábado
    regras.add(new RegraRodizio(1, new String[]{"Avenida Ayrton Senna"}, 2, 0)); // Final de placa 1, veículos leves, segunda
    regras.add(new RegraRodizio(7, new String[]{"Marginal Tietê"}, 3, 1)); // Final de placa 7, caminhões, domingo
    regras.add(new RegraRodizio(5, new String[]{"Marginal Pinheiros"}, 4, 0)); // Final de placa 5, caminhões, quarta-feira
    regras.add(new RegraRodizio(3, new String[]{"Avenida Rebouças"}, 5, 1)); // Final de placa 3, veículo leve, quinta-feira
    regras.add(new RegraRodizio(2, new String[]{"Rua Clélia"}, 6, 0));
    regras.add(new RegraRodizio(4, new String[]{"Avenida das Nações Unidas"}, 2, 1));
    regras.add(new RegraRodizio(8, new String[]{"Avenida Eng. Eusébio Stevaux"}, 4, 0));


    //adicionando algumas regras de corredor de ônibus
    regras.add(new RegraCorredorOnibus(6, 22, "Rua Consolação")); // Corredor de ônibus das 6h às 10h
    regras.add(new RegraCorredorOnibus(6, 22, "Avenida Santo Amaro")); // Corredor de ônibus das 16h às 20h
    regras.add(new RegraCorredorOnibus(6, 22, "Marginal Pinheiros")); // Corredor de ônibus das 6h às 10h
    regras.add(new RegraCorredorOnibus(6, 22, "Avenida das Nações Unidas")); // Corredor de ônibus das 8h às 14h
    regras.add(new RegraCorredorOnibus(6, 22, "Avenida Rebouças")); // Corredor de ônibus das 6h ao 12h
    regras.add(new RegraCorredorOnibus(6, 22, "Avenida Ayrton Senna")); // Corredor de ônibus das 16h às 20h
    regras.add(new RegraCorredorOnibus(6, 22, "Avenida Eng. Eusébio Stevaux"));
    regras.add(new RegraCorredorOnibus(6, 22, "Avenida Paulista"));
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
          System.out.println("Ocorrência processada: " + ocorrencia);
      }
    }

  //por fim, limpa a lista de ocorrencias não processadas
    ocorrenciasSemProcessar.clear();
  }

  // gera o relatorio de multas
  public void exibirRelatorioMultas() {
    System.out.println(this.multas);
    for (Multa multa : multas) {
      System.out.println(multa + "\n");
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

