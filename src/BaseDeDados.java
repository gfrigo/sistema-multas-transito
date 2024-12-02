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

  public void inicializarRegras(){ //inicia as regras de validação do sistema
    regras.add(new RegraVelocidade());
    regras.add(new RegraRodizio());
    regras.add(new RegraCorredorOnibus());
    //a principio são so essas 3 regras... eu pensei em colocar uma de placa tampada e etc, mas vamos terminar essas primeiro
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
  
}
