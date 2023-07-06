package main.services.processoseletivo.repositorios.interfaces;

import main.services.processoseletivo.dtos.CandidatoDto;
import java.util.List;

public interface CandidatoRepositorio {
    List<CandidatoDto> consultarCandidatos();
}
