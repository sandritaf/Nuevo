package Modelo;

import java.sql.Date;
import java.sql.Time;

public class M_Defensa {

    private Date fecha;
    private Time hora;
    private int aula;
    private String periodo;
    private int id_tesis;
    private int id_jurado1;
    private int id_jurad2;

    public M_Defensa() {
    }

    public M_Defensa(Date fecha, Time hora, int aula, String periodo, int id_tesis, int id_jurado1, int id_jurad2) {
        this.fecha = fecha;
        this.hora = hora;
        this.aula = aula;
        this.periodo = periodo;
        this.id_tesis = id_tesis;
        this.id_jurado1 = id_jurado1;
        this.id_jurad2 = id_jurad2;
    }

    
    public void actualizar(Date fecha, Time hora, int aula, String periodo, int id_tesis, int id_jurado1, int id_jurado2) {
        this.fecha = fecha;
        this.hora = hora;
        this.aula = aula;
        this.periodo = periodo;
        this.id_tesis = id_tesis;
        this.id_jurado1 = id_jurado1;
        this.id_jurad2 = id_jurado2;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHora() {
        return hora;
    }

    public int getAula() {
        return aula;
    }

    public String getPeriodo() {
        return periodo;
    }

    public int getId_tesis() {
        return id_tesis;
    }

    public int getId_jurado1() {
        return id_jurado1;
    }

    public int getId_jurad2() {
        return id_jurad2;
    }
    
    
  
    
    
}
