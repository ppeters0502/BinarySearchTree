/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author ppete_000
 */
public class BinarySearchTreeMain {
       /*Main Method*/
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinarySearchTree T = new BinarySearchTree();
		boolean isComplete = false;
		while (isComplete==false) {
                    System.out.println("Enter choice [1-8] from menu below:");
                    System.out.println("1) Construct a tree");
                    System.out.println("2) Print tree in a descending order");
                    System.out.println("3) Print number of leaves in tree");
                    System.out.println("4) Print the number of nodes in T that contain only one child");
                    System.out.println("5) Print the number of nodes in T that contain only two children ");
                    System.out.println("6) Print the level order traversal of the tree");
                    System.out.println("7) Print all elements in the tree between k1 and k2");
                    System.out.println("8) Exit program");
                    int nextChoice = sc.nextInt();

                    switch(nextChoice) {
                            case 1: T.makeEmpty();
                                    System.out.println("How many values would you like to have in your tree?");
                                    //I'm generating random numbers in between 0 and 1000 to insert into the tree.
                                    int size = sc.nextInt();
                                    Random random = new Random();
                                    for (int i = 0; i < size; i++)
                                    {
                                        int randomNumber = randomNumberGenerator( 0, 1000, random);
                                        T.insert(randomNumber);
                                        System.out.println("Number: "+randomNumber+" inserted!");
                                    }

                                break;
                            case 2: System.out.println("___________________________________________________");
                                    System.out.println("Printing Tree...");
                                    T.printTree();
                                break;
                            case 3: System.out.println("___________________________________________________");
                                    System.out.println("Finding number of leaves...");
                                    System.out.println("Number of Leaves: "+T.findLeaves());
                                break;
                            case 4: System.out.println("___________________________________________________");
                                    System.out.println("Finding number of nodes with 1 child...");
                                    System.out.println("Number of nodes with 1 child: "+T.findOneChild());
                                break;
                            case 5: System.out.println("___________________________________________________");
                                    System.out.println("Finding number of nodes with 2 children...");
                                    System.out.println("Number of nodes with 2 children: "+T.findTwoChildren());
                                break;
                            case 6: System.out.println("___________________________________________________");
                                    System.out.println("Finding level order of the Binary Search Tree...");
                                    System.out.println("Level Order: \n"+T.levelOrder());
                                break;
                            case 7: System.out.println("ok");
                                break;
                            case 8: 
                                System.out.println("Thank you for using my system!");
                                isComplete=true;
                                break;  
                        }
                }
               
                
                
    }
       /***************************************************
    * FUNCTION Random Number Generator : (randomNumberGenerator) *
    * This method generates the random numbers for inserting into
    * the BinarySearchTree.
    * based on the input from the user in the Main method
    * INPUT PARAMETERS : 
    * int aStart: lowest value allowed in our random number sequence.
    * int aEnd: highest value allowed in our random number sequence.
    * long numberRange: result of aEnd minus aStart. This determines 
    * the range of the random number sequence.
    * Random aRandom: Our object Random for the random number sequence
    * OUTPUT : 
    * int randomNumber: random integer for the random number sequence
    * that fits within the number range. Is assigned into the sequence[]
    * array in main method.
    ****************************************************/ 
     private static int randomNumberGenerator(int aStart, int aEnd, Random aRandom)
    {
        long numberRange = (long)aEnd - (long)aStart + 1;
        long fraction = (long)(numberRange * aRandom.nextDouble());
        int randomNumber = (int)(fraction + aStart);
        return randomNumber;
        
    }
    
}
