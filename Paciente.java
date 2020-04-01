import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Paciente implements Comparable<Paciente>
{
//	ATRIBUTOS DE PACIENTE
    String nom;
    String enf;
    String pri;
// MAP DONDE SE ENCUENTRAN LOS PACIENTES ORDENADOS ALFABETICAMENTE POR SUS PRIORIDADES
    Map<String,Integer> map = ordenarAlfabeticamente();

//	GETTERS Y SETTERS
    public String getNombrePaciente(){
        return this.nom;
    }
    public String getEnfermedadPaciente(){
        return this.enf;
    }
    public String getPrioridadPaciente(){
        return this.pri;
    }
    public void setNombrePaciente(String n){
        this.nom=n;
    }
    public void setEnfermedadPaciente(String e){
        this.enf=e;
    }
    public void setPrioridadPaciente(String p){
        this.pri=p;
    }

//  OBTENER EL INDICE DE LA POSICION DEL PACIENTE EN EL OBJETO DONDE SE ENCUENTRAN
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
//  ORDENAR ALFABETICAMENTE A LAS PRIORIDADES DE LOS PACIENTES MEDIANTE UN MAP
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

//  COMPARACION ENTRE DOS PACIENTES Y SUS POSICIONES MEDIANTE LA CLASE COMPARABLE
    @Override
    public int compareTo(Paciente p) {
        if(posicionPaciente(getPrioridadPaciente())<posicionPaciente(p.getPrioridadPaciente())){
            return -1;
        } else if(posicionPaciente(getPrioridadPaciente())>posicionPaciente(p.getPrioridadPaciente())) {
            return 1;
        } else{
            return 0;
        }
    }

}