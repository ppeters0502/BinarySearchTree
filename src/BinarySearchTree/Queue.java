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
public interface Queue<AnyType> {
        /**
     * Insert a new item into the queue.
     * @param x the item to insert.
     */
    void  enqueue( AnyType x );
    
    /**
     * Get the least recently inserted item in the queue.
     * Does not alter the queue.
     * @return the least recently inserted item in the queue.
     * @exception UnderflowException if the queue is empty.
     */
    Object getFront( );

    /**
     * Return and remove the least recently inserted item
     * from the queue.
     * @return the least recently inserted item in the queue.
     * @exception UnderflowException if the queue is empty.
     */
    AnyType dequeue( );

    /**
     * Test if the queue is logically empty.
     * @return true if empty, false otherwise.
     */
    boolean isEmpty( );

    /**
     * Make the queue logically empty.
     */
    void makeEmpty( );
}
