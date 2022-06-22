/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain;

import domain.list.ListException;
import domain.queue.LinkedQueue;
import domain.queue.QueueException;
import domain.stack.LinkedStack;
import domain.stack.StackException;

/**
 *
 * @author Profesor Gilberth Chaves A <gchavesav@ucr.ac.cr>
 */
public class AdjacencyListGraph implements Graph {
    private int n;
    private Vertex vertexList[];
    private int count; //contador de vertices
    
    //para los recorridos dfs, bfs
    private LinkedStack stack;
    private LinkedQueue queue;
    
    //Constructor
    public AdjacencyListGraph(int n){
        if(n<=0) System.exit(1);
        this.n = n;
        this.count = 0;
        this.vertexList = new Vertex[n];
        this.stack = new LinkedStack();
        this.queue = new LinkedQueue();
    }
    
    @Override
    public int size() throws ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsVertex(Object element) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean containsEdge(Object a, Object b) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addVertex(Object element) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addEdge(Object a, Object b) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addWeight(Object a, Object b, Object weight) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeVertex(Object element) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void removeEdge(Object a, Object b) throws GraphException, ListException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Vertex getVertexByIndex(int index) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    /**
    *____________RECORRIDOS POR GRAFOS
    */
    
    /***
     * RECORRIDO EN PROFUNDIDAD
     * @return 
     * @throws domain.GraphException
     * @throws domain.stack.StackException
     * @throws domain.list.ListException
     */
    @Override
    public String dfs() throws GraphException, StackException, ListException {
        setVisited(false);//marca todos los vertices como no vistados
        String info =vertexList[0].data+", ";
         vertexList[0].setVisited(true); // lo marca
         stack.clear();
         stack.push(0); //lo apila
         while( !stack.isEmpty() ){
             // obtiene un vertice adyacente no visitado, 
             //el que esta en el tope de la pila
             int index = adjacentVertexNotVisited((int) stack.top());
             if(index==-1) // no lo encontro
                 stack.pop();
             else{
                 vertexList[index].setVisited(true); // lo marca
                 info+=vertexList[index].data+", ";
                 stack.push(index); //inserta la posicion
             }
         }
         return info;
	}//dfs

    /***
     * RECORRIDO POR AMPLITUD
     * @return 
     * @throws domain.GraphException
     * @throws domain.queue.QueueException
     * @throws domain.list.ListException
     */
    @Override
    public String bfs() throws GraphException, QueueException, ListException {
        setVisited(false);//marca todos los vertices como no visitados
         // inicia en el vertice 0
         String info =vertexList[0].data+", ";
         vertexList[0].setVisited(true); // lo marca
         queue.clear();
         queue.enQueue(0); // encola el elemento
         int index2;
         while(!queue.isEmpty()){
             int index1 = (int) queue.deQueue(); // remueve el vertice de la cola
             // hasta que no tenga vecinos sin visitar
             while((index2=adjacentVertexNotVisited(index1)) != -1 ){
                 // obtiene uno
                 vertexList[index2].setVisited(true); // lo marca
                 info+=vertexList[index2].data+", ";
                 queue.enQueue(index2); // lo encola
             } 
         }
    return info;
    }
    
    //setteamos el atributo visitado del vertice respectivo
    private void setVisited(boolean value) {
        for (int i = 0; i < count; i++) {
            vertexList[i].setVisited(value); //value==true o false
        }//for
    }
    
    private int adjacentVertexNotVisited(int index) throws ListException {
        Object vertexData = vertexList[index].data;
        //for(int i=0; i<count; i++)
//	    if(!vertexList[i].edgesList.isEmpty()
//              &&vertexList[i].edgesList
//                .contains(new EdgeWeight(vertexData, null)) 
//                && !vertexList[i].isVisited())
//	             return i;
	return -1;
    }
    
}
