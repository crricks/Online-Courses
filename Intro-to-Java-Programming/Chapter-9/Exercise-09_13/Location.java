/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author clairericks
 */
public class Location {
    int row;
    int column;
    double maxValue;
    
    public Location() {
        this(0, 0, 0);
    }
    
    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }
    
    public String toString() {
        return this.maxValue + " at (" + this.row + ", " + this.column + ")";
    }
}
