/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author laboratorio
 */
public class Triangulo extends FormaGeometrica {
    public float lado;
    
    @Override
    float calcularArea() {
        float area;
        area = (lado*lado)/2;
        return area;
    }
    
}
