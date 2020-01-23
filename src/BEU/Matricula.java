package BEU;

import Illapa.Persona;
import Illapa.Unidad;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

public class Matricula {

    private Calendar fecha;
    private Estado estado;
    private Persona estudiante;
    private Curso curso;
    private float promedio;
    private final String Nmatricula;
    private final List<Calificacion> calificaciones = new ArrayList<>();

    public Matricula() {
        UUID numeroAleatorio = UUID.randomUUID();
        this.Nmatricula = numeroAleatorio.toString();
        fecha = Calendar.getInstance();
        estado = Estado.Registrada;

    }

    public Calendar getFecha() {
        return fecha;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Persona getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Persona estudiante) {
        this.estudiante = estudiante;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;

    }

    public float getPromedio() {
        return promedio;
    }

    public String getNmatricula() {
        return Nmatricula;
    }

    public void calcularPromedio() {
        if (calificaciones.isEmpty()) {
            return;
        }
        float suma = 0;
        for (Calificacion c : calificaciones) {
            suma += c.valor;
        }
        int divisor = this.calificaciones.size();
        promedio = (float) suma / divisor;

        if (divisor == 3) {
            if (promedio > 14) {
                this.estado = Estado.Aprobada;
            } else {
                this.estado = Estado.Reprobada;
            }
        }

    }

    // Este método registra calificacion y retorna un numero
    public int addCalificacion(float v) {
        Calificacion cal = new Calificacion();
        int nCali = 0;
        nCali = this.calificaciones.size();
        switch (nCali) {
            case 0:
                cal.setUnidad(Unidad.I);
                break;
            case 1:
                cal.setUnidad(Unidad.II);
                break;
            case 2:
                cal.setUnidad(Unidad.III);
                break;
            default:
                return 0;
        }

        cal.setValor(v);
        cal.setFecha(Calendar.getInstance());
        calificaciones.add(cal);
        this.calcularPromedio();
        return this.calificaciones.size();
    }

    @Override

    public String toString() {
        return estudiante.toString();
    }

    public String toSave() {
        GsonBuilder gb = new GsonBuilder();
        gb.setPrettyPrinting();
        Gson gson = gb.create();
        return gson.toJson(this);
    }

    public List<Calificacion> getCalificaciones() {
        return this.calificaciones;
    }

    public String imprimirDetalle() {
        String r = "\n" + estudiante.getNombre() + " " + estudiante.getApellido();
        for (Calificacion c : calificaciones) {
            r += "\t\t" + c.getValor();
        }
        r += "\t\t" + promedio + "\n";
        return r;
    }

    class Calificacion {

        private Calendar fecha;
        private float valor;
        private Unidad unidad;

        public Calificacion() {
        }

        public Calendar getFecha() {
            return fecha;
        }

        public void setFecha(Calendar fecha) {
            this.fecha = fecha;
        }

        public void setValor(float valor) {
            this.valor = valor;
        }

        public Unidad getUnidad() {
            return unidad;
        }

        public void setUnidad(Unidad unidad) {
            this.unidad = unidad;
        }

        public float getValor() {
            return valor;
        }

    }

}
