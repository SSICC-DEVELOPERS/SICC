package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOEntradaEliminarPerfil extends DTOAuditableSICC 
{

  private String nombrePerfil;
  private Vector listaFuncionesYacciones;
  private String pantallaInicioAplicacionAsociada;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

  public DTOEntradaEliminarPerfil() {
    super();
  }
  
  public DTOEntradaEliminarPerfil(String nombrePerfil,
                                  Vector listaFuncionesYacciones,
                                  String pantallaInicioAplicacionAsociada) {
    super();
    this.nombrePerfil = nombrePerfil;
    this.listaFuncionesYacciones = listaFuncionesYacciones;
    this.pantallaInicioAplicacionAsociada = pantallaInicioAplicacionAsociada;
  }

  public String getNombrePerfil(){
    return this.nombrePerfil;
  }

  public void setNombrePerfil(String nombrePerfil){
    this.nombrePerfil = nombrePerfil;
  }
  
  public Vector getListaFuncionesYacciones(){
		return listaFuncionesYacciones;
  }

  public void setListaFuncionesYacciones(Vector newListaFuncionesYacciones){
		listaFuncionesYacciones = newListaFuncionesYacciones;
  }

  public String getPantallaInicioAplicacionAsociada(){
    return this.pantallaInicioAplicacionAsociada;
  }

  public void setPantallaInicioAplicacionAsociada(String pantallaInicioAplicacionAsociada){
    this.pantallaInicioAplicacionAsociada = pantallaInicioAplicacionAsociada;
  }
} 
