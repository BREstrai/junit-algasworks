package com.algaworks.junit.utilidade;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

class SimuladorEsperaTest {

    // Só executa se a variável de ambiente ENV for DEV
    //@EnabledIfEnvironmentVariable(named = "ENV", matches = "DEV")
    @Test
    @Disabled("Desabilitado pois não é mais necessário")
    void deveEsperarNaoDarTimeOut() {

        // Só executa se a variável de ambiente ENV for DEV
        //Assumption.assumeTrue("DEV".equals(System.getenv("ENV")));

        // Se passar to tempo esperado ele nem espera concluir o restante do teste
        assertTimeoutPreemptively(
                java.time.Duration.ofMillis(1000),
                () -> SimuladorEspera.esperar(java.time.Duration.ofMillis(500))
        );
    }

}