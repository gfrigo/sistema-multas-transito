import java.util.Calendar;

public class RegraRodizio extends RegraMulta {
  private int finalPlaca;
  private String[] logradourosAfetados;
  private int diaDaSemana;
  private int tipoVeiculo;

  public RegraRodizio(int finalPlaca, String[] logradourosAfetados, int diaDaSemana, int tipoVeiculo) {
    this.finalPlaca = finalPlaca;
    this.logradourosAfetados = logradourosAfetados;
    this.diaDaSemana = diaDaSemana;
    this.tipoVeiculo = tipoVeiculo;
  }

    /* Implementar métodos abstratos: 
  ->verificaNivelMulta()
  -> obterDescricaoMulta()
  (provenientes da classe RegraMulta)*/

  @Override
  public int verificaNivelMulta(Ocorrencia ocorrencia){String placa = ocorrencia.getPlaca();
    placa = ocorrencia.getPlaca();
    Calendar data = Calendar.getInstance();
    data.setTime(ocorrencia.getData());

    diaDaSemana = data.get(Calendar.DAY_OF_WEEK); // 1 a 7, sendo 1 = domingo e 7 = sábado
    finalPlaca = Integer.parseInt(placa.substring(placa.length() - 1)); // aqui pega o ultimo digito da placa

    if (diaDaSemana == Calendar.SATURDAY || diaDaSemana == Calendar.SUNDAY) { //aqui verifica se é final de semana, se for, ignora o rodizio
        return NivelMulta.SEM_MULTA.getCodigo();
    }

    boolean emRodizio = false;

    switch (diaDaSemana) { //
        case Calendar.MONDAY:
            emRodizio = (finalPlaca == 1 || finalPlaca == 2);
            break;

        case Calendar.TUESDAY:
            emRodizio = (finalPlaca == 3 || finalPlaca == 4);
            break;

        case Calendar.WEDNESDAY:
            emRodizio = (finalPlaca == 5 || finalPlaca == 6);
            break;

        case Calendar.THURSDAY:
            emRodizio = (finalPlaca == 7 || finalPlaca == 8);
            break;

        case Calendar.FRIDAY:
            emRodizio = (finalPlaca == 9 || finalPlaca == 0);
            break;

        default:
            break;
    }

    if (emRodizio) { // aplica multa se o cara for pego no rodizio
        return NivelMulta.MULTA_GRAVE.getCodigo(); // rodizio é grave
    }

    return NivelMulta.SEM_MULTA.getCodigo(); // Fora do rodízio
  }
  @Override
  public String obterDescricaoMulta(Ocorrencia ocorrencia) {
    return "Infração de rodízio em logradouros afetados (" + String.join(", ", logradourosAfetados) +
           ") para veículos do tipo " + TipoVeiculo.getDescricaoPorCodigo(tipoVeiculo) +
           " com placa terminada em " + finalPlaca +
           " no dia " + diaDaSemana + ".";
  }

}
