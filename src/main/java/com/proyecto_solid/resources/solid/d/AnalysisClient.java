/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid.resources.solid.d;

/**
 *
 * @author PAOLA
 */

public class AnalysisClient {
    private final AnalysisService service;
    
    public AnalysisClient(AnalysisService service) {
        this.service = service;
    }
    
    public String analyze(String text) {
        return service.performAnalysis(text);
    }
}