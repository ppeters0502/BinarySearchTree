/***********************************************************************
 * Program Title: Binary Search Tree
 * File Name: BinarySearchTree.java*
 * Author: Patrick Peters *
 * Class: CSCI3320, Summer 2017 *
 * Assignment #2 *
 * **********************Internal Methods*******************************
 * void insert(AnyType x, BinaryNode t) -> inserts new node into BinarySearchTree
 * void makeEmpty() -> removes all items from BinarySearchTree
 * boolean isEmpty() -> tests if tree is logically empty. returns true/false
 * void printTree(BinaryNode t) -> prints tree in descending order.
 * int findLeaves(BinaryNode n) -> returns number of leaves in BinarySearchTree 
 * int findOneChild(BinaryNode n) -> returns number of nodes in BinarySearchTree
 *  with one child.
 * int findTwoChildren(BinaryNode n) -> returns number of nodes in BinarySearchTree
 *  with two children.
 * void levelOrder(BinaryNode n, Queue L) -> prints level order of BinarySearchTree
 * void printBetween(BinaryNode n, AnyType k1, AnyType k2) -> takes inputs k1
 *  and k2 and finds all BinaryNodes that have values in between k1 and k2.
 ***********************************************************************/
package BinarySearchTree;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 *
 * @author ppete
 */
public class BinarySearchTree <AnyType extends Comparable<? super AnyType>>{

    
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

    /***************************************************
    * FUNCTION insert : (Insert BinaryNode) *
    * Inserts new BinaryNode into BinarySearchTree *
    * INPUT PARAMETERS : *
    * AnyType x: Value to be added as Node's element 
    * BinaryNode t: checks if t is null to determine recursively
    * if t is leaf node or parent.
    * OUTPUT : *
    * BinaryNode: newly inserted BinaryNode that is in the
    * BinarySearchTree.
     ****************************************************/
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
    /***************************************************
    * FUNCTION printTree : (Print Binary Search Tree) *
    * Prints BinarySearchTree in descending order *
    * INPUT PARAMETERS : *
    * BinaryNode t: node to be printed, along with it's
    * left and right child.
    * OUTPUT : *
    * void. Prints out BinaryNode with it's children
    * internally.
     ****************************************************/
    private void printTree( BinaryNode<AnyType> t )
    {
        if( t != null )
        {
            printTree( t.right );
            System.out.println( t.element );
            printTree( t.left );
        }
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
    /***************************************************
    * FUNCTION findLeaves : (Find all leaves in BinarySearchTree) *
    * Finds all leaves in BinarySearchTree *
    * INPUT PARAMETERS : *
    * BinaryNode n: node to check for children. If no children
    * returns 1.
    * OUTPUT : *
    * int: returns 1 if BinaryNode input has no children
    * and is a leaf.
     ****************************************************/
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
    
    public int findOneChild()
    {
        return findOneChild(root);
    }
    /***************************************************
    * FUNCTION findOneChild : (Find One Child) *
    * Finds all BinaryNodes with one child *
    * INPUT PARAMETERS : *
    * BinaryNode n: node to check for children. If one child,
    * returns 1.
    * OUTPUT : *
    * int: returns 1 if BinaryNode input has one child.
     ****************************************************/
    public int findOneChild(BinaryNode<AnyType> n)
    {
        if (n.left==null & n.right==null)
        {
            return 0;
        }
        else if (n.left==null)
        {
            return 1 + findOneChild(n.right);
        }
        else if (n.right==null)
        {
            return 1 + findOneChild(n.left);
        }
        else
            return findOneChild(n.left)+findOneChild(n.right);
    }
    
    public int findTwoChildren()
    {
        return findTwoChildren(root);
    }
    
    /***************************************************
    * FUNCTION findTwoChildren : (Find Two Children) *
    * Finds all BinaryNodes with two children *
    * INPUT PARAMETERS : *
    * BinaryNode n: node to check for children. If full node,
    * returns 1.
    * OUTPUT : *
    * int: returns 1 if BinaryNode input has two children.
     ****************************************************/
    public int findTwoChildren(BinaryNode<AnyType> n)
    {
        if (n.left==null & n.right==null)
        {
            return 0;
        }
        else if (n.left==null)
        {
            return findTwoChildren(n.right);
        }
        else if (n.right==null)
        {
            return findTwoChildren(n.left);
        }
        else
            return 1 + (findTwoChildren(n.left) + findTwoChildren(n.right));
    }
    
    public void levelOrder()
    {
        Queue levelOrderQueue = new LinkedList();
        levelOrderQueue.add(root);
        levelOrder(root, levelOrderQueue);
    }
    /***************************************************
    * FUNCTION levelOrder : (Find Level Order) *
    * Prints level order of the BinarySearchTree *
    * INPUT PARAMETERS : *
    * BinaryNode n: node to check for children and if so
    * adds itself and children to Queue L.
    * Queue L: LinkedList Queue to put node and it's
    * children into. on remove method, returns the head
    * of the Queue which is node from the previous iteration
    * or the root if it's the first time running.
    * OUTPUT : *
    * void. Prints n.element internally.
     ****************************************************/
    public void levelOrder(BinaryNode<AnyType> n, Queue L)
    {
        if(L.isEmpty()){}
        else
        {
            BinaryNode head = (BinaryNode)L.poll();
            System.out.println(head.element);
            if(n.left!=null)
            {
                try {
                    L.add(n.left);
                } catch (NoSuchElementException e)
                { e.printStackTrace(); }
            }
            if(n.right!=null)
            {
                try {
                    L.add(n.right);
                } catch (NoSuchElementException e)
                { e.printStackTrace(); }
            }
            BinaryNode next = (BinaryNode)L.peek();
            levelOrder(next, L);
        }
    }
    public void printBetween(AnyType k1, AnyType k2)
    {
       printBetween(root, k1, k2);
    }
    
    /***************************************************
    * FUNCTION printBetween : (Print nodes in between k1 and k2) *
    * Finds and prints all BinaryNodes that have values
    * in between AnyType k1 and AnyType k2
    * INPUT PARAMETERS : *
    * BinaryNode n: Compares n to k1 and k2, if BinaryNode
    * is in between k1 and k2, it prints the node's element,
    * and recursively runs with it's left and right children.
    * If n is outside of the k1 to k2 range, program
    * recursively runs with either n.left or n.right, reducing
    * the time complexity from O(N) to O(log N).
    * OUTPUT : *
    * void. Prints node elements internally.
     ****************************************************/
    public void printBetween(BinaryNode<AnyType> n, AnyType k1, AnyType k2)
    {
        int compareResultK1 = n.element.compareTo(k1);
        int compareResultK2 = n.element.compareTo(k2);
        if (compareResultK1<0)
        {
            if(n.right!=null)
            { printBetween(n.right, k1, k2); }
        }
        else if (compareResultK1>=0)
        {
            if (compareResultK2<=0)
            {
               System.out.println(n.element);
               if(n.left!=null)
               {printBetween(n.left,k1,k2);}
               if(n.right!=null)
               {printBetween(n.right,k1,k2);}
            }
            else
            {
                if(n.left!=null)
                { printBetween(n.left, k1, k2); }
            }
        }
    }

    
        
    
}
