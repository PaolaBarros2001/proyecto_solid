/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.o;

import com.proyecto_solid.resources.solid.s.BasicAnalyzer;

/**
 *
 * @author PAOLA
 */


public class BasicSentimentAnalysis implements SentimentAnalysis {
    @Override
    public String analyze(String text) {
        // Implementación básica abierta para extensión
        return new BasicAnalyzer().analyze(text);  // Más legible
    }
}