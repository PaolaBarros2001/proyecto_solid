/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.o;

/**
 *
 * @author PAOLA
 */
public class AdvancedSentimentAnalysis implements SentimentAnalysis {
    @Override
    public String analyze(String text) {
        return text.contains("excelente") ? "MUY POSITIVO" : 
               text.contains("malo") ? "NEGATIVO" : "NEUTRO";
    }
}