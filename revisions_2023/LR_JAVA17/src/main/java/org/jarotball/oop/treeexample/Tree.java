package org.jarotball.oop.treeexample;

import java.awt.*;

public class Tree {

    // Class Attributes - static attributes
    public static Color TRUNK_COLOR = new Color(0, 102, 10, 144);      // trunk_color :: red,green,blue


    // Instance Attributes - non-static attributes
    double heightFt;
    double trunkDiameterInches;
    TreeType treeType; // Enum type

    // Constructor
    public Tree(double heightFt, double trunkDiameterInches, TreeType treeType) {
        this.heightFt = heightFt;
        this.trunkDiameterInches = trunkDiameterInches;
        this.treeType = treeType;
    }

    // For Class - static methods
    // Custom Methods/Behaviors
    public static void announceTree(){
        System.out.println("Look out for that tree");
    }

    // For Instance - non-static methods
    // Custom Methods/Behaviors
    // All tree will grow 10Ft in Height and 1 inch in diameter when this grow() behavior is used
    public void grow(){
        this.heightFt+=10;
        this.trunkDiameterInches+=1;
    }

    // Check if its a tall tree or not
    // TreeHeight>100 is a tall tree
    public void announceTallTree(){
        if (this.heightFt>100){
            System.out.format("This is a tall %s tree%n",this.treeType);
        }else{
            System.out.format("%s Tree is not tall%n", this.treeType);
        }
    }


    // getter and setter
    public double getHeightFt() {
        return heightFt;
    }

    public void setHeightFt(double heightFt) {
        this.heightFt = heightFt;
    }

    public double getTrunkDiameterInches() {
        return trunkDiameterInches;
    }

    public void setTrunkDiameterInches(double trunkDiameterInches) {
        this.trunkDiameterInches = trunkDiameterInches;
    }

    public TreeType getTreeType() {
        return treeType;
    }

    public void setTreeType(TreeType treeType) {
        this.treeType = treeType;
    }

    // print the object


    @Override
    public String toString() {
        return "Tree{" +
                "heightFt=" + heightFt +
                ", trunkDiameterInches=" + trunkDiameterInches +
                ", treeType=" + treeType +
                '}';
    }
}
