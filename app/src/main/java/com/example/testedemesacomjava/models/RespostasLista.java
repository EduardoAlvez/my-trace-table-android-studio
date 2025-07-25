package com.example.testedemesacomjava.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasLista {

    private List<String> exercicio1 = new ArrayList();
    private List<String> exercicio2 = new ArrayList();

    private List<String> exercicio3 = new ArrayList();
    public RespostasLista() {
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas() {
        exercicio1.addAll(Arrays.asList(
                "0", "*", "*",
                "0", "0", "*",
                "2", "0", "*",
                "2", "1", "*",
                "7", "1", "*",
                "7", "1", "8",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));
        exercicio2.addAll(Arrays.asList(
                "*", "*", "*",
                "18", "*", "*",
                "18", "6", "*",
                "18", "6", "2",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"
        ));
        exercicio3.addAll(Arrays.asList(
                "*", "*", "*",
                "4", "*", "*",
                "4", "6", "*",
                "4", "6", "12",
                "4", "6", "12",
                "18", "6", "12",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"
        ));
    }

    public List<String> getExercicio1() {
        return exercicio1;
    }

    public List<String> getExercicio2() {
        return exercicio2;
    }

    public List<String> getExercicio3() {
        return exercicio3;
    }
}


