package es.indra.sicc.dtos.inc;
import es.indra.sicc.logicanegocio.inc.Concurso;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOCalculoMeta  extends DTOBelcorp
{
    private DTOConcurso DTOConcurso;
    private ArrayList cliente;
    private Concurso concurso;
    private int cantPeriodo;

    public DTOCalculoMeta()
    {
    }

    public DTOConcurso getDTOConcurso()
    {
        return DTOConcurso;
    }

    public void setDTOConcurso(DTOConcurso DTOConcurso)
    {
        this.DTOConcurso = DTOConcurso;
    }

    public ArrayList getCliente()
    {
        return cliente;
    }

    public void setCliente(ArrayList cliente)
    {
        this.cliente = cliente;
    }

    public Concurso getConcurso()
    {
        return concurso;
    }

    public void setConcurso(Concurso concurso)
    {
        this.concurso = concurso;
    }

    public int getCantPeriodo()
    {
        return cantPeriodo;
    }

    public void setCantPeriodo(int cantPeriodo)
    {
        this.cantPeriodo = cantPeriodo;
    }
}