package main.services.processoseletivo.estrategiasselecao;

import main.services.processoseletivo.dtos.CandidatoDto;
import main.services.processoseletivo.estrategiasselecao.interfaces.EstrategiaSelecao;

public class EstrategiaSemVaga implements EstrategiaSelecao {
    @Override
    public Resultado analisar(CandidatoDto candidato) {
        return Resultado.EM_ESPERA;
    }
}
