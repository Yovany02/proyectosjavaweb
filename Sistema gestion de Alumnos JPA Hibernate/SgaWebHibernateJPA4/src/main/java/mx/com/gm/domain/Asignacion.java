
package mx.com.gm.domain;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;

@Entity
public class Asignacion implements Serializable{
    
    public static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asignacion")
    private Integer idAsignacion;
    
    private String turno;
    
    @JoinColumn(name="id_alumno", referencedColumnName ="id_alumno")
    @ManyToOne
    private Alumno alumno;
    
    @JoinColumn(name="id_curso", referencedColumnName ="id_curso")
    @ManyToOne
    private Curso curso;

    public Asignacion() {
    }

    public Asignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public Integer getIdAsignacion() {
        return idAsignacion;
    }

    public void setIdAsignacion(Integer idAsignacion) {
        this.idAsignacion = idAsignacion;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Asignacion{" + "idAsignacion=" + idAsignacion + ", turno=" + turno + ", alumno=" + alumno + ", curso=" + curso + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.idAsignacion);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asignacion other = (Asignacion) obj;
        return Objects.equals(this.idAsignacion, other.idAsignacion);
    }

}
