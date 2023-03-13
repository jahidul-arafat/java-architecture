package org.jarotball.oop.treeexample;

public class simulator {
    public static void main(String[] args) {
        // Basic Simulation
        Tree.announceTree();
        System.out.format("Tree will be carried in Trunk with Color: %s%n%n",Tree.TRUNK_COLOR);

        Tree tree1 = new Tree(125,5,TreeType.MAPLE);
        Tree tree2 = new Tree(20, 10, TreeType.OAK);

        tree1.grow();
        tree2.grow();

        System.out.println();
        System.out.println(tree1);
        System.out.println(tree2);

        System.out.println();
        tree1.announceTallTree();
        tree2.announceTallTree();

        // Testing Encapsulation
        // Accessing the Tree attributes through getter and setter
        System.out.println(tree1.getTreeType());
        System.out.println(tree1.getHeightFt());
        System.out.println(tree1.getTrunkDiameterInches());
        tree1.setTreeType(TreeType.PECAN);
        System.out.println(tree1);


    }
}
