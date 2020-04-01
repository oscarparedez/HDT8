import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Vector;

class addRemoveTest {

    public void add(){
        Modelo modelo = new Modelo();
        Vector<Paciente> pacientes = modelo.estructurarArchivoVector();
        VectorHeap<Paciente> vectorHeap= new VectorHeap<>();
        for(int i=0;i<pacientes.size();i++)
        {
            vectorHeap.add(pacientes.get(i));
        }
        assertEquals(vectorHeap.getFirst().getNombrePaciente(), "Maria Ramirez");
    }

    public void remove() {
    	Modelo modelo = new Modelo();
    	Vector<Paciente> pacientes = modelo.estructurarArchivoVector();
        VectorHeap<Paciente> vectorHeap= new VectorHeap<>();
        for(int i=0;i<pacientes.size();i++) {
        	vectorHeap.add(pacientes.get(i));
        }
        assertEquals(vectorHeap.remove().getNombrePaciente(), "Maria Ramirez");
    }
}