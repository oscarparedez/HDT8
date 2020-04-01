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
        
        if(opcion == 1){
        	
        	VectorHeap<Paciente> vectorHeap = new VectorHeap<>();
            Vector<Paciente> pacientes = modelo.estructurarArchivoVector();
            
            for(int i=0;i<pacientes.size();i++) {
            	vectorHeap.add(pacientes.get(i));
            }
            
            for(int i=pacientes.size()-1;i>=0;i--) {
            	System.out.println("PACIENTE "+vectorHeap.getFirst().getNombrePaciente()+" | ENFERMEDAD"+vectorHeap.getFirst().getEnfermedadPaciente()+ " | PRIORIDAD "+vectorHeap.getFirst().getPrioridadPaciente()+"\n");
            	vectorHeap.remove();
            }
            System.out.println("SE HAN ATENDIDO A TODOS LOS PACIENTES!");

        } else if(opcion == 2){
        	
            ArrayList<Paciente> pacientes = modelo.estructurarArchivoArrayList();
            PriorityQueue<Paciente> priorityQueue = new PriorityQueue<>(pacientes.size(), new Modelo());
            
            for(int i=0;i<pacientes.size();i++)
            {
            	priorityQueue.add(pacientes.get(i));
            }
            
            PriorityQueue<Paciente> lista = priorityQueue;
            
            int listSize = lista.size();
            for(int i=0; i<listSize; i++) {
                System.out.println("PACIENTE "+lista.peek().getNombrePaciente()+" | ENFERMEDAD:"+lista.peek().getEnfermedadPaciente()+ " | PRIORIDAD "+lista.peek().getPrioridadPaciente()+"\n");
                lista.poll();
            }
            System.out.println("SE HAN ATENDIDO A TODOS LOS PACIENTES!");
            
        }
        

    }
}