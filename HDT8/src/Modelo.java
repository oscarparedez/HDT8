import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

public class Modelo implements Comparator<Paciente>
{
	
	
	private String path = System.getProperty("user.dir");
	private File file = new File(path+"/src/pacientes.txt");
	

    public Vector<Paciente> estructurarArchivoVector(){
    	
        Vector<Paciente> pacientes = new Vector<>();
       
        try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				
				String linea = scan.nextLine();
	            String[] datosPaciente = linea.split("\\,");
	        	
	            Paciente paciente = new Paciente();

	            paciente.setNombrePaciente(datosPaciente[0]);
	            paciente.setEnfermedadPaciente(datosPaciente[1]);
	            paciente.setPrioridadPaciente(datosPaciente[2]);
	            pacientes.add(paciente);
	            
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
        return pacientes;
    }

    public ArrayList<Paciente> estructurarArchivoArrayList(){
    	
        ArrayList<Paciente> pacientes = new ArrayList<>();
        try {
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				
				String linea = scan.nextLine();
	            String[] datosPaciente = linea.split("\\,");
	            
	        	Paciente paciente = new Paciente();

	            paciente.setNombrePaciente(datosPaciente[0]);
	            paciente.setEnfermedadPaciente(datosPaciente[1]);
	            paciente.setPrioridadPaciente(datosPaciente[2]);

	            pacientes.add(paciente);
			}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
        return pacientes;
    }
	
    Map<String,Integer> map = ordenarAlfabeticamente();
    
    public int posicionPaciente(String caracter){
        Set<String> keys = map.keySet();
        Object[] caracteres = keys.toArray();
        int pos = 0;

        for(int i=0;i<caracteres.length;i++) {
            if(String.valueOf(caracteres[i]).equals(caracter)) {
            	pos=i;
                break;
            }
        }
        return pos;
    }
	
    public Map<String,Integer> ordenarAlfabeticamente() {
    	
        ArrayList<String> letrasValidas = new ArrayList<>();
        String abecedario="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for(int i = 0; i < abecedario.length(); i++)
        {
            String caracter = String.valueOf(abecedario.charAt(i));
            letrasValidas.add(caracter);
        }
        Map<String, Integer> indicesOrdenados = new LinkedHashMap<>();


        for(int i=0;i<letrasValidas.size();i++)
        {
        	indicesOrdenados.put(letrasValidas.get(i),i);
        }
        return indicesOrdenados;
    }

    @Override
    public int compare(Paciente no1, Paciente no2) {
        return posicionPaciente(no1.getPrioridadPaciente())-posicionPaciente(no2.getPrioridadPaciente());
    }
}