/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg;

/**
 *
 * @author laboratorio
 */
public class Retangulo extends FormaGeometrica {
    public float lado1;
    public float lado2;
    
    @Override
    float calcularArea() {
        float area;
        area = lado1*lado2;
        return area;
    }
}
