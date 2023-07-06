package main;

import main.services.processoseletivo.dtos.CandidatoDto;
import main.services.processoseletivo.repositorios.MockCandidatoRepositorio;
import main.services.processoseletivo.estrategiasselecao.interfaces.EstrategiaSelecao;
import main.services.processoseletivo.estrategiasselecao.EstrategiaBaixoSalario;
import main.services.processoseletivo.ProcessoSeletivoService;
import main.services.rh.Rh;

import java.util.ArrayList;
import java.util.List;

public class AppCandidatura {
    public static void main(String[] args) {
        int limiteSelecoes = 5;
        double salarioBase = 2000.0;
        EstrategiaSelecao selecao = new EstrategiaBaixoSalario(salarioBase, limiteSelecoes);
        var processo = new ProcessoSeletivoService(new MockCandidatoRepositorio());
        var rh = new Rh();

        processo.setaSelecao(selecao);

        List<CandidatoDto> selecionados = new ArrayList<>();
        processo.selecionarCandidatos(selecionados::add);

        imprimirCandidatos(selecionados);

        int limiteTentativas = 3;
        selecionados.forEach(selecionado -> rh.contatar(selecionado, limiteTentativas));
    }

    static void imprimirCandidatos(List<CandidatoDto> candidatos) {
        for(CandidatoDto candidato : candidatos)
            System.out.println("Candidato(a) selecionado(a): " + candidato.nome());
    }
}
