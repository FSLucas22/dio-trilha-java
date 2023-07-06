package main.services.processoseletivo.repositorios;

import main.services.processoseletivo.dtos.CandidatoDto;
import main.services.processoseletivo.repositorios.interfaces.CandidatoRepositorio;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class MockCandidatoRepositorio implements CandidatoRepositorio {
    @Override
    public List<CandidatoDto> consultarCandidatos() {
        String[] nomes = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO",
                "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE"};

        return Arrays.stream(nomes)
                .map(this::criarCandidato)
                .collect(Collectors.toList());
    }

    private CandidatoDto criarCandidato(String nome) {
        double salarioPretendido = ThreadLocalRandom.current().nextDouble(1800.0, 2200.0);

        return new CandidatoDto(nome, salarioPretendido);
    }
}
