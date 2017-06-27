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
                                    int size = sc.nextInt();
                                    System.out.println("Please enter "+size+" values one at a time below.");
                                    for(int i=0; i<size; i++)
                                    {
                                        System.out.println("Please enter value number "+(i+1));
                                        int value = sc.nextInt();
                                        T.insert(value);
                                        
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
                                    T.levelOrder();
                                break;
                            case 7: System.out.println("___________________________________________________");
                                    System.out.println("What value would you like for k1?");
                                    int k1 = sc.nextInt();
                                    System.out.println("What value would you like for k2?");
                                    int k2 = sc.nextInt();
                                    System.out.println("Finding node values inbetween "+k1+" and "+k2);
                                    T.printBetween(k1, k2);
                                    
                                break;
                            case 8: 
                                System.out.println("Thank you for using my system!");
                                isComplete=true;
                                break;  
                        }
                }
               
                
                
    }
    
}
