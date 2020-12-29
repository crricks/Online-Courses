/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clairericks
 */
public class TestRegularPolygon {
    
    public static void main(String[] args) {
        RegularPolygon[] polygons = new RegularPolygon[3];
        
        polygons[0] = new RegularPolygon();
        polygons[1] = new RegularPolygon(6, 4);
        polygons[2] = new RegularPolygon(10, 4, 5.6, 7.8);
        
        for (int i = 0; i < 3; i++) {
            System.out.printf("Polygon %d Area: %f\n", i, polygons[i].getArea());
            System.out.printf("Polygon %d Perimeter: %f\n",
                                                i, polygons[i].getPerimeter());
        }
    }
}
