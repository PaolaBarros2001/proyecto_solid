/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.i;

import com.proyecto_solid.resources.solid.s.BasicAnalyzer;

/**
 *
 * @author PAOLA
 */

public class BasicSeparatedAnalyzer implements SentimentAnalyzer, SentimentScorer {
    private final BasicAnalyzer analyzer = new BasicAnalyzer();
    
    @Override
    public String analyze(String text) {
        return analyzer.analyze(text);
    }

    @Override
    public double getScore(String text) {
        return analyzer.getSentimentScore(text);
    }
}