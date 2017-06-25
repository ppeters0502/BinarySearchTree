/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
            throw new UnderflowException("Tree is Empty.");
        return findMin( root ).element;
    }

    /**
     * Find the largest item in the tree.
     * @return the largest item of null if empty.
     */
    public AnyType findMax( )
    {
        if( isEmpty( ) )
            throw new UnderflowException("Tree is Empty.");
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
        if(L.isEmpty())
        {}
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
            BinaryNode N = (BinaryNode)L.peek();
            levelOrder(N, L);
        }
    }
    
    
    
 
        
    
}
