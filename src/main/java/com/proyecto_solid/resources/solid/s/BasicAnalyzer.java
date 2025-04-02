/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.s;

/**
 *
 * @author PAOLA
 */


public class BasicAnalyzer {
    public String analyze(String text) {
        double score = getSentimentScore(text);
        return score > 0 ? "POSITIVE" : score < 0 ? "NEGATIVE" : "NEUTRAL";
    }

    public double getSentimentScore(String text) {
        String[] positiveWords = {"bueno", "excelente", "feliz", "genial"};
        String[] negativeWords = {"malo", "terrible", "triste", "horrible"};
        
        int positiveCount = 0;
        int negativeCount = 0;
        String lowerText = text.toLowerCase();
        
        for (String word : positiveWords) {
            if (lowerText.contains(word)) positiveCount++;
        }
        
        for (String word : negativeWords) {
            if (lowerText.contains(word)) negativeCount++;
        }
        
        return positiveCount - negativeCount;
    }
}