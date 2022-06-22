/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package domain.queue;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public interface Queue {
    public int size(); // devuelve el número de elementos en la cola
    public void clear(); //elimina / inicializa la Cola
    public boolean isEmpty(); // true si la Cola está vacía
    public int indexOf(Object element) throws QueueException; //devuelve la posicion de un elemento en la Cola
    public void enQueue(Object element) throws QueueException; // encola un elemento por el extremo posterior(final) de la cola
    public Object deQueue() throws QueueException; //suprime y retorna el elemento que está en la parte anterior(frente/inicio) de la cola
    public boolean contains(Object element) throws QueueException; //true si el elemento fue encolado
    public Object peek() throws QueueException; //devuelve el elemento que está en el frente/inicio de la Cola
    public Object front() throws QueueException; //devuelve el elemento que está en el frente/inicio de la Cola
}
