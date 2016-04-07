/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.men;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

/**
 * Sistema:           Belcorp
 * Modulo:            MEN 
 * Submódulo:         Menú
 * Componente:        DTO's
 * Fecha:             28/03/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-MEN-001-200
 *                    (Subido al portal el 06/03/2003)
 * @version           1.0
 * @autor             Verónica Iturrioz
 */

public class DTOEntradaModificarPerfiles extends DTOBelcorp  {

  private String nombreDePerfil;
  private Vector listaDeFuncionesAcciones;
  private String pantallaInicioDeAplicacionAsociada;
  private String nombreDePerfilViejo;
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

  public DTOEntradaModificarPerfiles() {
    super();
  }

  public DTOEntradaModificarPerfiles(String nombreDePerfil,
                                     Vector listaDeFuncionesAcciones,
                                     String pantallaInicioDeAplicacionAsociada) {
    super();
    this.nombreDePerfil = nombreDePerfil;
    this.listaDeFuncionesAcciones = listaDeFuncionesAcciones;
    this.pantallaInicioDeAplicacionAsociada = pantallaInicioDeAplicacionAsociada;
  }

  public String getNombreDePerfil(){
    return this.nombreDePerfil;
  }

  public void setNombreDePerfil(String nombreDePerfil){
    this.nombreDePerfil = nombreDePerfil;
  }

  public Vector getListaDeFuncionesAcciones(){
		return listaDeFuncionesAcciones;
  }

  public void setListaDeFuncionesAcciones(Vector newListaDeFuncionesAcciones){
		listaDeFuncionesAcciones = newListaDeFuncionesAcciones;
  }

  public String getPantallaInicioDeAplicacionAsociada(){
    return this.pantallaInicioDeAplicacionAsociada;
  }

  public void setPantallaInicioDeAplicacionAsociada(String pantallaInicioDeAplicacionAsociada){
    this.pantallaInicioDeAplicacionAsociada = pantallaInicioDeAplicacionAsociada;
  }

  public String getNombreDePerfilViejo() {
	return nombreDePerfilViejo;
  }

  public void setNombreDePerfilViejo(String newNombreDePerfilViejo)	{
	nombreDePerfilViejo = newNombreDePerfilViejo;
  }
}