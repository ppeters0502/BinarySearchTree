/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarysearchtree;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author ppete
 */
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{

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
                            case 2: System.out.println("Printing Tree...");
                                    T.printTree();
                                break;
                            case 3: System.out.println("Finding number of leaves...");
                                    System.out.println("Number of Leaves: "+T.findLeaves());
                                break;
                            case 4: System.out.println("ok");
                                break;
                            case 5: System.out.println("ok");
                                break;
                            case 6: System.out.println("ok");
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
    
    
    
    /*Constructor*/
    public BinarySearchTree() {
        root = null;
    }
        /**
     * Insert into the tree; duplicates are ignored.
     * @param x the item to insert.
     */
    public void insert( AnyType x )
    {
        root = insert( x, root );
    }

    /**
     * Remove from the tree. Nothing is done if x is not found.
     * @param x the item to remove.
     */
    public void remove( AnyType x )
    {
        root = remove( x, root );
    }

    /**
     * Find the smallest item in the tree.
     * @return smallest item or null if empty.
     */
    public AnyType findMin( )
    {
        if( isEmpty( ) )
            throw new UnderflowException();
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( );
        return findMax( root ).element;
    }

    /**
     * Find an item in the tree.
     * @param x the item to search for.
     * @return true if not found.
     */
    public boolean contains( AnyType x )
    {
        return contains( x, root );
    }

    /**
     * Make the tree logically empty.
     */
    public void makeEmpty( )
    {
        root = null;
    }

    /**
     * Test if the tree is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return root == null;
    }

    /**
     * Print the tree contents in sorted order.
     */
    public void printTree( )
    {
        if( isEmpty( ) )
            System.out.println( "Empty tree" );
        else
            printTree( root );
    }

    /**
     * Internal method to insert into a subtree.
     * @param x the item to insert.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> insert( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return new BinaryNode<AnyType>( x, null, null );
        
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
            ;  // Duplicate; do nothing
        return t;
    }

    /**
     * Internal method to remove from a subtree.
     * @param x the item to remove.
     * @param t the node that roots the subtree.
     * @return the new root of the subtree.
     */
    private BinaryNode<AnyType> remove( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return t;   // Item not found; do nothing
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            t.left = remove( x, t.left );
        else if( compareResult > 0 )
            t.right = remove( x, t.right );
        else if( t.left != null && t.right != null ) // Two children
        {
            t.element = findMin( t.right ).element;
            t.right = remove( t.element, t.right );
        }
        else
            t = ( t.left != null ) ? t.left : t.right;
        return t;
    }

    /**
     * Internal method to find the smallest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the smallest item.
     */
    private BinaryNode<AnyType> findMin( BinaryNode<AnyType> t )
    {
        if( t == null )
            return null;
        else if( t.left == null )
            return t;
        return findMin( t.left );
    }

    /**
     * Internal method to find the largest item in a subtree.
     * @param t the node that roots the subtree.
     * @return node containing the largest item.
     */
    private BinaryNode<AnyType> findMax( BinaryNode<AnyType> t )
    {
        if( t != null )
            while( t.right != null )
                t = t.right;

        return t;
    }

    /**
     * Internal method to find an item in a subtree.
     * @param x is item to search for.
     * @param t the node that roots the subtree.
     * @return node containing the matched item.
     */
    private boolean contains( AnyType x, BinaryNode<AnyType> t )
    {
        if( t == null )
            return false;
            
        int compareResult = x.compareTo( t.element );
            
        if( compareResult < 0 )
            return contains( x, t.left );
        else if( compareResult > 0 )
            return contains( x, t.right );
        else
            return true;    // Match
    }

    /**
     * Internal method to print a subtree in sorted order.
     * @param t the node that roots the subtree.
     */
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.right );
            System.out.println( t.element );
            printTree( t.left );
        }
    }

    /**
     * Internal method to compute height of a subtree.
     * @param t the node that roots the subtree.
     */
    private int height( BinaryNode<AnyType> t )
    {
        if( t == null )
            return -1;
        else
            return 1 + Math.max( height( t.left ), height( t.right ) );    
    }
    
    // Basic node stored in unbalanced binary search trees
    private static class BinaryNode<AnyType>
    {
            // Constructors
        BinaryNode( AnyType theElement )
        {
            this( theElement, null, null );
        }

        BinaryNode( AnyType theElement, BinaryNode<AnyType> lt, BinaryNode<AnyType> rt )
        {
            element  = theElement;
            left     = lt;
            right    = rt;
        }

        AnyType element;            // The data in the node
        BinaryNode<AnyType> left;   // Left child
        BinaryNode<AnyType> right;  // Right child
    }


      /** The tree root. */
    private BinaryNode<AnyType> root;
    
  
    /** Finding Number of Leaves in Tree */
    public int findLeaves()
    {
        return findLeaves(root);
    }
    
    public int findLeaves(BinaryNode<AnyType> n)
    {
      if (n.left==null & n.right==null)
          return 1;
      else if (n.left==null)
          return findLeaves(n.right);
      
      else if (n.right==null)
          return findLeaves(n.left);
      
      else
          return (findLeaves(n.left) + findLeaves(n.right)) ;
        
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
