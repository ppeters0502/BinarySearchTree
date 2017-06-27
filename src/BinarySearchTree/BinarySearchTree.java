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
    
    public int findOneChild()
    {
        return findOneChild(root);
    }
    
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
