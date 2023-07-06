package main.services.processoseletivo.estrategiasselecao;

import main.services.processoseletivo.dtos.CandidatoDto;
import main.services.processoseletivo.estrategiasselecao.interfaces.EstrategiaSelecao;

public class EstrategiaBaixoSalario implements EstrategiaSelecao {
    private final Double salarioBase;
    private final Integer limiteSelecoes;
    private Integer selecionados = 0;

    public EstrategiaBaixoSalario(Double salarioBase, Integer limiteSelecoes) {
        this.salarioBase = salarioBase;
        this.limiteSelecoes = limiteSelecoes;
    }

    @Override
    public Resultado analisar(CandidatoDto candidato) {
        if (salarioBase < candidato.salarioPretendido())
            return Resultado.REJEITADO;
        if (selecionados >= limiteSelecoes)
            return Resultado.EM_ESPERA;
        selecionados++;
        return Resultado.SELECIONADO;
    }
}