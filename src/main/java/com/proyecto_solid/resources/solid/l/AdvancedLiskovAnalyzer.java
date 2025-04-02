/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.l;

/**
 *
 * @author PAOLA
 */

public class AdvancedLiskovAnalyzer implements SentimentAnalyzerLSP {
    @Override
    public String analyze(String text) {
        return text.length() > 15 ? "POSITIVO" : "NEUTRO";
    }
}