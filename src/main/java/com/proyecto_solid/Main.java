/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.proyecto_solid;

import com.proyecto_solid.resources.p.AdvancedSentimentFactory;
import com.proyecto_solid.resources.p.BasicSentimentFactory;
import com.proyecto_solid.resources.p.SentimentFactory;
import com.proyecto_solid.resources.solid.d.AnalysisClient;
import com.proyecto_solid.resources.solid.d.AnalysisService;
import com.proyecto_solid.resources.solid.d.ConsoleAnalysisService;
import com.proyecto_solid.resources.solid.i.BasicSeparatedAnalyzer;
import com.proyecto_solid.resources.solid.s.BasicFormatter;
import com.proyecto_solid.resources.solid.i.SentimentAnalyzer;
import com.proyecto_solid.resources.solid.i.SentimentScorer;
import com.proyecto_solid.resources.solid.l.AdvancedLiskovAnalyzer;
import com.proyecto_solid.resources.solid.l.BasicLiskovAnalyzer;
import com.proyecto_solid.resources.solid.l.SentimentAnalyzerLSP;
import com.proyecto_solid.resources.solid.o.AdvancedSentimentAnalysis;
import com.proyecto_solid.resources.solid.o.BasicSentimentAnalysis;
import com.proyecto_solid.resources.solid.o.SentimentAnalysis;
import com.proyecto_solid.resources.solid.s.BasicAnalyzer;

/**
 *
 * @author PAOLA
 */






public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMOSTRACIÓN DE TODOS LOS PRINCIPIOS SOLID ===");
        
        // 1. Single Responsibility Principle (SRP)
        demonstrateSRP();
        
        // 2. Open/Closed Principle (OCP)
        demonstrateOCP();
        
        // 3. Liskov Substitution Principle (LSP)
        demonstrateLSP();
        
        // 4. Interface Segregation Principle (ISP)
        demonstrateISP();
        
        // 5. Dependency Inversion Principle (DIP)
        demonstrateDIP();
        
        // 6. Abstract Factory integrando todos los principios
        demonstrateAbstractFactory();
    }
    
    private static void demonstrateSRP() {
        System.out.println("\n--- 1. SINGLE RESPONSIBILITY PRINCIPLE (SRP) ---");
        System.out.println("Cada clase tiene una sola razón para cambiar");
        
        // Analizador solo analiza
        BasicAnalyzer analyzer = new BasicAnalyzer();
        String analysis = analyzer.analyze("El producto funciona muy bien");
        
        // Formateador solo formatea
        BasicFormatter formatter = new BasicFormatter();
        String formattedResult = formatter.format(analysis);
        
        System.out.println("Resultado formateado: " + formattedResult);
    }
    
    private static void demonstrateOCP() {
        System.out.println("\n--- 2. OPEN/CLOSED PRINCIPLE (OCP) ---");
        System.out.println("Abierto a extensión, cerrado a modificación");
        
        // Implementación básica
        SentimentAnalysis basicAnalysis = new BasicSentimentAnalysis();
        System.out.println("Análisis básico: " + basicAnalysis.analyze("No está mal"));
        
        // Nueva implementación sin modificar el existente
        SentimentAnalysis advancedAnalysis = new AdvancedSentimentAnalysis();
        System.out.println("Análisis avanzado: " + advancedAnalysis.analyze("No está mal"));
    }
    
    private static void demonstrateLSP() {
        System.out.println("\n--- 3. LISKOV SUBSTITUTION PRINCIPLE (LSP) ---");
        System.out.println("Las subclases deben ser sustituibles por sus clases base");
        
        SentimentAnalyzerLSP analyzer;
        
        // Usando implementación básica
        analyzer = (SentimentAnalyzerLSP) new BasicLiskovAnalyzer();
        System.out.println("Análisis básico: " + analyzer.analyze("Es aceptable"));
        
        // Sustituyendo por implementación avanzada
        analyzer = new AdvancedLiskovAnalyzer();
        System.out.println("Análisis avanzado: " + analyzer.analyze("Es aceptable"));
    }
    
    private static void demonstrateISP() {
        System.out.println("\n--- 4. INTERFACE SEGREGATION PRINCIPLE (ISP) ---");
        System.out.println("Interfaces específicas en lugar de una general");
        
        BasicSeparatedAnalyzer analyzer = new BasicSeparatedAnalyzer();
        
        // Usando solo Analyzer
        System.out.println("Análisis: " + analyzer.analyze("Increíble servicio"));
        
        // Usando solo Scorer
        System.out.println("Puntaje: " + analyzer.getScore("Increíble servicio"));
    }
    
    private static void demonstrateDIP() {
        System.out.println("\n--- 5. DEPENDENCY INVERSION PRINCIPLE (DIP) ---");
        System.out.println("Depender de abstracciones, no de implementaciones");
        
        // Inyectamos la dependencia (abstracción)
        AnalysisService service = new ConsoleAnalysisService() {};
        AnalysisClient client = new AnalysisClient(service);
        
        System.out.println(client.analyze("El peor producto que he comprado"));
    }
    
    private static void demonstrateAbstractFactory() {
        System.out.println("\n--- 6. ABSTRACT FACTORY INTEGRANDO SOLID ---");
        
        String[] testPhrases = {
            "Este producto es excelente!",
            "No me gustó para nada",
            "Es más o menos, podría mejorar"
        };
        
        System.out.println("\nFábrica Básica:");
        testFactory(new BasicSentimentFactory(), testPhrases);
        
        System.out.println("\nFábrica Avanzada:");
        testFactory(new AdvancedSentimentFactory(), testPhrases);
    }
    
    private static void testFactory(SentimentFactory factory, String[] phrases) {
        for (String phrase : phrases) {
            System.out.println("\nFrase: " + phrase);
            
            // SRP: Cada componente con una sola responsabilidad
            String analysis = factory.createAnalyzer().analyze(phrase);
            double score = factory.createScorer().getScore(phrase);
            String formatted = factory.createFormatter().format(analysis);
            
            System.out.println("Análisis: " + formatted);
            System.out.println("Puntaje: " + score);
        }
    }
}