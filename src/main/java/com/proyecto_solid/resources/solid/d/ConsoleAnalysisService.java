/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.d;

import com.proyecto_solid.resources.solid.s.BasicAnalyzer;

/**
 *
 * @author PAOLA
 */
public abstract class ConsoleAnalysisService implements AnalysisService {
    public String performAnalysis(String text) {
        return "Análisis: " + new BasicAnalyzer().analyze(text);
    }

    
}