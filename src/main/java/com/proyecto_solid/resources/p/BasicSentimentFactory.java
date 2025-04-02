/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.p;

import com.proyecto_solid.resources.solid.s.BasicFormatter;
import com.proyecto_solid.resources.solid.i.BasicSeparatedAnalyzer;
import com.proyecto_solid.resources.solid.i.SentimentAnalyzer;
import com.proyecto_solid.resources.solid.i.SentimentScorer;

/**
 *
 * @author PAOLA
 */


public class BasicSentimentFactory implements SentimentFactory {
    @Override
    public SentimentAnalyzer createAnalyzer() {
        return new BasicSeparatedAnalyzer();
    }

    @Override
    public SentimentScorer createScorer() {
        return new BasicSeparatedAnalyzer();
    }

    @Override
    public BasicFormatter createFormatter() {
        return new BasicFormatter();
    }
}