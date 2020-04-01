import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Vector;

public class Main {
    public static void main(String[] args){
    	
    	Modelo modelo = new Modelo();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("INGRESE [1] PARA LA IMPLEMENTACION DEL LIBRO JAVA STRUCTURES O INGRESE [2] PARA LA IMPLEMENTACION DE JCF");
        int opcion = scan.nextInt();
        
//        IMPLEMENTACION DEL LIBRO JAVA STRUCTURES BASADO EN VECTORHEAP Y LA CLASE PRIORITY QUEUE
        if(opcion == 1){
        	
        	VectorHeap<Paciente> vectorHeap = new VectorHeap<>();
            Vector<Paciente> pacientes = modelo.estructurarArchivoVector();
            
//          RECORRER CADA PACIENTE DE UNA FUNCION QUE LOS MANDA ORDENADOS Y GUARDARLOS EN UN VECTORHEAP
            for(int i=0;i<pacientes.size();i++) {
            	vectorHeap.add(pacientes.get(i));
            }
//          IMPRIMIR Y REMOVER A CADA PACIENTE DEL VECTOR PREVIAMENTE MENCIONADO 
            for(int i=pacientes.size()-1;i>=0;i--) {
            	System.out.println("PACIENTE "+vectorHeap.getFirst().getNombrePaciente()+" | ENFERMEDAD"+vectorHeap.getFirst().getEnfermedadPaciente()+ " | PRIORIDAD "+vectorHeap.getFirst().getPrioridadPaciente()+"\n");
            	vectorHeap.remove();
            }
            System.out.println("SE HAN ATENDIDO A TODOS LOS PACIENTES!");
//		  IMPLEMENTACION DE JCF PRIOROTY QUEUE
        } else if(opcion == 2){
        	
            ArrayList<Paciente> pacientes = modelo.estructurarArchivoArrayList();
            PriorityQueue<Paciente> priorityQueue = new PriorityQueue<>(pacientes.size(), new Modelo());
            
//          RECORRER CADA PACIENTE DE UNA FUNCION QUE LOS MANDA ORDENADOS Y GUARDARLOS EN UN OBJETO TIPO PRIORITY QUEUE
            for(int i=0;i<pacientes.size();i++)
            {
            	priorityQueue.add(pacientes.get(i));
            }
            
            PriorityQueue<Paciente> lista = priorityQueue;
            
//          IMPRIMIR Y REMOVER A CADA PACIENTE DEL OBJETO PREVIAMENTE MENCIONADO           
            int listSize = lista.size();
            for(int i=0; i<listSize; i++) {
                System.out.println("PACIENTE "+lista.peek().getNombrePaciente()+" | ENFERMEDAD:"+lista.peek().getEnfermedadPaciente()+ " | PRIORIDAD "+lista.peek().getPrioridadPaciente()+"\n");
                lista.poll();
            }
            System.out.println("SE HAN ATENDIDO A TODOS LOS PACIENTES!");
            
        }
        

    }
}