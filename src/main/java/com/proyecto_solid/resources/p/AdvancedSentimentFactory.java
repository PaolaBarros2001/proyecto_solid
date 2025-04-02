/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.p;

import com.proyecto_solid.resources.solid.s.BasicFormatter;
import com.proyecto_solid.resources.solid.i.SentimentAnalyzer;
import com.proyecto_solid.resources.solid.i.SentimentScorer;

/**
 *
 * @author PAOLA
 */

public class AdvancedSentimentFactory implements SentimentFactory {
    @Override
    public SentimentAnalyzer createAnalyzer() {
        return new AdvancedAnalyzer();
    }

    @Override
    public SentimentScorer createScorer() {
        return new AdvancedAnalyzer();
    }

    @Override
    public BasicFormatter createFormatter() {
        return new AdvancedFormatter();
    }
}

class AdvancedAnalyzer implements SentimentAnalyzer, SentimentScorer {
    @Override
    public String analyze(String text) {
        double score = getScore(text);
        if (score > 0.5) return "MUY POSITIVO";
        if (score > 0.1) return "POSITIVO";
        if (score < -0.5) return "MUY NEGATIVO";
        if (score < -0.1) return "NEGATIVO";
        return "NEUTRAL";
    }

    @Override
    public double getScore(String text) {
        return Math.sin(text.length()) * 0.8;
    }
}

class AdvancedFormatter extends BasicFormatter {
    @Override
    public String format(String analysis) {
        return "🔍 Análisis avanzado:\n" + analysis + "\n📊 Detalles completos disponibles";
    }
}