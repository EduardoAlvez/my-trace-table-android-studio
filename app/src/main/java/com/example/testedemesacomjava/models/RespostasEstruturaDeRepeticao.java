package com.example.testedemesacomjava.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasEstruturaDeRepeticao {

    private final List<String> exercicio1 = new ArrayList<>();
    private final List<String> exercicio2 = new ArrayList<>();
    private final List<String> exercicio3 = new ArrayList<>();

    public RespostasEstruturaDeRepeticao() {
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas() {
        exercicio1.addAll(Arrays.asList(
                "4", "*", "*",
                "4", "12", "*",
                "4", "12", "2",
                "4", "12", "2",
                "4", "4", "2",
                "4", "4", "2",
                "4", "4", "10",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));

        exercicio2.addAll(Arrays.asList(
                "3", "1", "0",
                "3", "1", "0",
                "3", "2", "0",
                "2", "2", "0",
                "2", "2", "1",
                "2", "3", "1",
                "1", "3", "1",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));

        exercicio3.addAll(Arrays.asList(
                "0", "10", "0",
                "1", "10", "0",
                "1", "9", "0",
                "1", "9", "2",
                "3", "9", "2",
                "3", "7", "2",
                "3", "7", "6",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));
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
