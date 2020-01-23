package BLL;

import BEU.Curso;
import BEU.Estado;
import BEU.Estudiante;
import BEU.Matricula;
import Illapa.BaseBLLCrud;
import Illapa.BasePersistencia;
import Illapa.Util;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GestionMatricula extends BasePersistencia<Matricula> implements BaseBLLCrud<Matricula> {

    private Matricula matricula;
    private final String directorio = "Matriculas";

    public GestionMatricula() {
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public String calificar(float valor) {
        String m = "";
        int num = this.matricula.addCalificacion(valor);
        switch (num) {
            case 0:
                m = "Todas las notas está registradas.\n";
                break;
            case 1:
                m = "Calificación de la Unidad I ingresada correctamente.\n";
                break;
            case 2:
                m = "Calificación de la Unidad II ingresada correctamente.\n";
                break;
            case 3:
                m = "Calificación de la Unidad III ingresada correctamente.\n";
                break;
        }
        return m;
    }

    public String anularEstudiante() {
        matricula.setEstado(Estado.Anulada);
        DecimalFormat df = new DecimalFormat("#,##");
        float s = (matricula.getCurso().getCosto() * 0.10f);
        String r = "El estudiante " + matricula.getEstudiante().getNombre() + " "
                + "" + matricula.getEstudiante().getApellido()
                + " Se ha dado de baja del curso correctamente \n"
                + "Se le va a debitar " + df.format(s) + "$ por el rubro a pagar\n";
        return r;
    }

    public String mostrarListaEstudiantes(Object[] arreglo) {
        byte i = 1;
        String r = "\nLista de Estudiantes Inscritos: \n";
        for (Object matri : arreglo) {
            r += i + ". " + matri.toString() + "\n";
            i++;
        }
        r += "\n";
        return r;
    }

    public String mostrarAprobados(Object[] arreglo) {
        byte i = 1;
        String r = "\nLista de Estudiantes Aprobados: \n";
        for (Object matri : arreglo) {
            r += i + ". " + matri.toString() + "\n";
            i++;
        }
        r += "\n";
        return r;
    }

    public void promediar() {
        this.matricula.calcularPromedio();
    }

    public String imprimir() {
        StringBuilder sb = new StringBuilder();
        sb.append("Estudiante: ").append(matricula.getEstudiante()).append("\n");
        sb.append("Curso:").append(matricula.getCurso().getTitulo()).append("\n");
        sb.append("Promedio: ").append(matricula.getPromedio()).append("\n");
        return sb.toString();
    }

    public void archivar() {
        this.escribir(directorio, this.matricula.getNmatricula(), matricula);
    }

    public void configurar(Curso cr, Estudiante est) {
        matricula.setEstudiante(est);
        matricula.setCurso(cr);
    }

    public List<Matricula> reportar(String titulo) throws IOException {
        List<Matricula> resultado = new ArrayList<>();
        List<String> contenidos = this.leerDirectorio(directorio, titulo);
        for (String texto : contenidos) {
            GsonBuilder gb = new GsonBuilder();
            gb.setPrettyPrinting();
            Gson gson = gb.create();
            try {
                Matricula m = gson.fromJson(texto, Matricula.class);
                resultado.add(m);
            } catch (JsonSyntaxException e) {
                Util.Print("No se pudo convertir en matrícula");
            }

        }
        return resultado;
    }

    @Override
    public void crear() {
        matricula = new Matricula();
    }

    @Override
    public void consultar(String id) throws IOException {
        String nombre = id + ".json";
        String contenido = leer(directorio, nombre);
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        matricula = gson.fromJson(contenido, Matricula.class);
    }

    @Override
    public void actualizar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar() throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
