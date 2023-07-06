package main.services.processoseletivo;

import main.services.processoseletivo.estrategiasselecao.Resultado;
import main.services.processoseletivo.dtos.CandidatoDto;
import main.services.processoseletivo.repositorios.interfaces.CandidatoRepositorio;
import main.services.processoseletivo.estrategiasselecao.interfaces.EstrategiaSelecao;
import main.services.processoseletivo.estrategiasselecao.EstrategiaSemVaga;

import java.util.List;
import java.util.function.Consumer;

public class ProcessoSeletivoService {
    private EstrategiaSelecao selecao = new EstrategiaSemVaga();
    private final CandidatoRepositorio repository;

    public ProcessoSeletivoService(CandidatoRepositorio repository) {
        this.repository = repository;
    }

    public void selecionarCandidatos(Consumer<CandidatoDto> pegaSelecionados) {
        consultarCandidatos().forEach(candidato -> {
            Resultado resultado = selecao.analisar(candidato);
            if (resultado.equals(Resultado.SELECIONADO))
                pegaSelecionados.accept(candidato);
        });
    }

    public void setaSelecao(EstrategiaSelecao selecao) {
        this.selecao = selecao;
    }

    public List<CandidatoDto> consultarCandidatos() {
        return repository.consultarCandidatos();
    }
}
