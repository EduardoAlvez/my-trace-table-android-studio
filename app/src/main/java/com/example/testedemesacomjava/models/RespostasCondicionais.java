package com.example.testedemesacomjava.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RespostasCondicionais {

    private List<String> exercicio1 = new ArrayList<>();
    private List<String> exercicio2 = new ArrayList<>();
    private List<String> exercicio3 = new ArrayList<>();


    public RespostasCondicionais(){
        populaRespostas();
    }

    //POPULA AS RESPOSTAS. QUANDO TIVER UM "*" SIGNIFICA QUE A VARIÁVEL NÃO EXISTE NAQUELA POSIÇÃO
    private void populaRespostas(){
        exercicio1.addAll(Arrays.asList(
                "5", "*", "*",
                "5", "*", "*",
                "*", "*", "*",
                "5", "*", "*",
                "5", "15", "*",
                "5", "15", "20",
                "14", "15", "20",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));

        exercicio2.addAll(Arrays.asList(
                "1", "550", "0",
                "1", "550", "0",
                "1", "550", "50",
                "1", "550", "50",
                "1", "275", "50",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*"));

        exercicio3.addAll(Arrays.asList(
                "7", "*", "*",
                "7", "12", "*",
                "7", "12", "*",
                "7", "12", "19",
                "*", "*", "*",
                "*", "*", "*",
                "*", "*", "*",
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
