package es.indra.sicc.dtos.edu;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOValidarParticipantes extends DTOBelcorp  {
    private Long curso;
    private Long tipoCurso;
    private ArrayList validar;

    public DTOValidarParticipantes() {
    }

    public Long getCurso() {
        return curso;
    }

    public void setCurso(Long curso) {
        this.curso = curso;
    }

    public Long getTipoCurso() {
        return tipoCurso;
    }

    public void setTipoCurso(Long tipoCurso) {
        this.tipoCurso = tipoCurso;
    }

    public ArrayList getValidar() {
        return validar;
    }

    public void setValidar(ArrayList validar) {
        this.validar = validar;
    }
}