/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author ppete_000
 */
public class ListQueue<AnyType> implements Queue<AnyType> {
     /**
     * Construct the queue.
     */
    public ListQueue( )
    {
        front = back = null;
    }

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty( )
    {
        return front == null;
    }

    /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    @Override
    public void enqueue( AnyType x )
    {
        if( isEmpty( ) )    // Make queue of one element
            back = front = new ListNode<AnyType>( x );
        else                // Regular case
            back = back.next = new ListNode<AnyType>( x );
    }

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public AnyType dequeue( )
    {
        if( isEmpty( ) )
            throw new UnderflowException( "ListQueue dequeue" );

        AnyType returnValue = front.element;
        front = front.next;
        return returnValue;
    }

    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @throws UnderflowException if the queue is empty.
     */
    public AnyType getFront( ) 
    {
        if( isEmpty( ) )
            throw new UnderflowException( "ListQueue getFront" );
        return front.element;
    }

    /**
     * Make the queue logically empty.
     */
    public void makeEmpty( )
    {
        front = null;
        back = null;
    }

    private ListNode<AnyType> front;
    private ListNode<AnyType> back;
}

class ListNode<AnyType>
{
      // Constructors
    public ListNode( AnyType theElement )
    {
        this( theElement, null );
    }

    public ListNode( AnyType theElement, ListNode<AnyType> n )
    {
        element = theElement;
        next    = n;
    }

    public AnyType   element;
    public ListNode<AnyType> next;
}