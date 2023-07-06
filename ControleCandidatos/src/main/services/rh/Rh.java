package main.services.rh;

import main.services.processoseletivo.dtos.CandidatoDto;

public class Rh {
    public void contatar(CandidatoDto candidato, int limiteTentativas) {
        int i = 0;
        boolean atendeu = false;

        while (i < limiteTentativas && !atendeu) {
            i++;
            System.out.println("TENTANDO CONTATAR " + candidato.nome());
            atendeu = candidato.atenderLigacao();
        }

        if (atendeu)
            System.out.println(
                    "CONSEGUIMOS CONTATO COM " + candidato.nome() + " APÓS " + i + " TENTATIVAS");
        else
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato.nome());
    }
}
