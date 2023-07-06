package main.services.processoseletivo.dtos;

import java.util.concurrent.ThreadLocalRandom;

public record CandidatoDto(String nome, double salarioPretendido) {
    public boolean atenderLigacao() {
        return ThreadLocalRandom.current().nextBoolean();
    }
}
