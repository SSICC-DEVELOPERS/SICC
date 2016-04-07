package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import es.indra.sicc.util.DTOBelcorp;


public class DTODocLegal extends DTOBelcorp
{

private ArrayList listaPaginas;
private String usuario;
    private Boolean indOnline;


  public DTODocLegal()
  {
    listaPaginas=new ArrayList();
  }

  public ArrayList getlistaPaginas()
  {
    return listaPaginas;
  }

  public void setListaPaginas(ArrayList entrada)
  {
    listaPaginas=entrada;
  }

  public void añadirPagina(DTOFACDocumentoContable entrada)
  {
    listaPaginas.add(entrada);
  }

  public void limpiarLista()
  {
    listaPaginas.clear();
  }

  public void eliminarPagina(int index)
  {
    listaPaginas.remove(index);
  }


  public int getNumeroPaginas()
  {
    return listaPaginas.size();
  }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String usuario)
    {
        this.usuario = usuario;
    }

    public Boolean getIndOnline()
    {
        return indOnline;
    }

    public void setIndOnline(Boolean indOnline)
    {
        this.indOnline = indOnline;
    }

}