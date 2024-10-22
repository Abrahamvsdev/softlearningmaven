// Version: 1.0
package com.core.entities.shared.dimensions; 
import com.core.checks.Check;


public class Dimensions {
    protected double weight;
    protected double height;
    protected double width;
    protected double length;
    protected double volume;
    
    protected Dimensions(){

    };
    public static Dimensions getInstanceDimensions(double weight, double height, double width, double length) throws Exception { //CONTRUIRbUILDeXCEPTIONS
        StringBuilder errors = new StringBuilder();

        
        Dimensions d = new Dimensions();
        int errorCode;


        if ((errorCode = d.setWeight(weight)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = d.setHeight(height)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = d.setWidth(width)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if ((errorCode = d.setLength(length)) != 0) {
            errors.append(Check.getErrorMessage(errorCode)).append("\n");
        }

        if (errors.length() > 0) {
            
            throw new Exception("Not possible to create the dimensions: \n" + errors.toString());
        }
        return d;
    }

    public double  getWeight() {
        return this.weight;
    }

    public double getHeight() {
        return this.height;
    }

    public double getWidth() {
        return this.width;
    }

    public double getLength() {
        return this.length;
    }

    public int setWeight(double weight) {
        int errorWeight = Check.range(weight);
        if (errorWeight == 0) {
            this.weight = weight;
        }
        return errorWeight;
    }

    public int setHeight(double height) {
        int errorHeight = Check.range(height);
        if (errorHeight == 0) {
            this.height = height;
        }
        return errorHeight;
    }

    public int setWidth(double width) {
        int errorWidth = Check.range(width);
        if (errorWidth == 0) {
            this.width = width;
        }
        return errorWidth;
    }

    public int setLength(double length) {
        int errorLength = Check.range(length);
        if (errorLength == 0) {
            this.length = length;
        }
        return errorLength;
    }

    public double getVolume() {
        return this.width * this.height * this.length;
    }

    public String getDetails() {
        return "Height: " + this.getHeight() + " cm\n" +
                "Weight: " + this.getWeight() + " kg\n" +
                "Width: " + this.getWidth() + " cm\n" +
                "Length: " + this.getLength() + " cm\n" +
                "Volume: " + this.getVolume() + " cubic cm";
    }
}