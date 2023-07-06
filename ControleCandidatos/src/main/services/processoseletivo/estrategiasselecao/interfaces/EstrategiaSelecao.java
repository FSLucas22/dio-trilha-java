package main.services.processoseletivo.estrategiasselecao.interfaces;

import main.services.processoseletivo.dtos.CandidatoDto;
import main.services.processoseletivo.estrategiasselecao.Resultado;

@FunctionalInterface
public interface EstrategiaSelecao {
    Resultado analisar(CandidatoDto candidato);
}
