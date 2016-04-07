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
 /*
    INDRA/CAR/PROY
    $Id: LPMantieneSecuenciaProcesos.java,v 1.1 2009/12/03 18:37:57 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            PED
 * Submódulo:         
 * Componente:        LPMantieneSecuenciaProcesos.java
 * Fecha:             13/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-PED-201-354-P0018
 * @version           1.0
 * @autor             Andrés Pollitzer
 */



import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.exception.MareException;

import es.indra.druida.DruidaConector;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Date;
import java.util.Vector;

import es.indra.sicc.dtos.ped.DTOSecuenciaProcesos;
import javax.servlet.http.*;
import java.util.*;


public class LPMantieneSecuenciaProcesos extends LPSICCBase {

  String casoDeUso;
  String accion;

  String secuencia;
  String indEjecucion;
  String oid;
  String oIDModificar;
  String oidTipoSolicitudPais;
  String oidProceso;
  String oidGrupoProcesos;


	public LPMantieneSecuenciaProcesos ()  {
      super();
  }

  public void inicio() throws Exception  {

  }

  public void ejecucion() throws Exception  {
    try{
        setTrazaFichero();
      
      casoDeUso = conectorParametroLimpia("hCasoDeUso","",true);
      accion = conectorParametroLimpia("accion","",true);

      secuencia = conectorParametroLimpia("txtSecuencia","",true);
      indEjecucion = conectorParametroLimpia("chkIdEjecucionLinea","",true);
      oid = conectorParametroLimpia("hOid","",true);
      oIDModificar = conectorParametroLimpia("hOIDModificar","",true);
      oidTipoSolicitudPais = conectorParametroLimpia("cbTipoSol","",true);
      oidProceso = conectorParametroLimpia("cbCodProceso","",true);
      oidGrupoProcesos = conectorParametroLimpia("cbGProcesos","",true);

        traza(" ");
        traza("********************************************************");
        traza("******* ejecucion() LPMantieneSecuenciaProcesos ********");
        traza("********************************************************");
        traza("casoDeUso : "            + casoDeUso);
        traza("accion : "               + accion);

        traza("secuencia : "            + secuencia);
        traza("indEjecucion : "         + indEjecucion);
        traza("oid : "                  + oid);
        traza("oIDModificar : "         + oIDModificar);
        traza("oidTipoSolicitudPais : " + oidTipoSolicitudPais);
        traza("oidProceso : "           + oidProceso);
        traza("oidGrupoProcesos : "     + oidGrupoProcesos);

//casoDeUso == "Insertar" ---------------------------------------------------------------------------
      if (casoDeUso.equals("Insertar"))  {
          traza("Entra en Insertar");
        pagina("contenido_secuencia_proceso_insertar");
        cargarCombos();
        getConfiguracionMenu("LPInsertaSecuenciaProcesos","Insertar");
        try  {
          getFormatosValidaciones();
        } catch (Exception e)  {
            this.logStackTrace(e);
          throw e;
         }
          traza("Sale de Insertar");
      }

//casoDeUso == "Modificar" ---------------------------------------------------------------------------
      if (casoDeUso.equals("Modificar"))  {
          traza("Entra en Modificar");
        pagina("contenido_secuencia_proceso_modificar");
        cargarCombos();
        getConfiguracionMenu("LPModificaSecuenciaProcesos","Modificar");
		try  {
          getFormatosValidaciones();
        } catch (Exception e)  {
            this.logStackTrace(e);
          throw e;
         }
          traza("Sale de Modificar");
      }

//casoDeUso == "Eliminar" ---------------------------------------------------------------------------
      if (casoDeUso.equals("Eliminar") && accion.equals(""))  {
          traza("Entra en Eliminar");
        pagina("contenido_secuencia_proceso_modificar");
        cargarCombos();
        getConfiguracionMenu("LPEliminaSecuenciaProcesos","Eliminar");
        asignarAtributoPagina("cod","0635");
		 try  {
          getFormatosValidaciones();
        } catch (Exception e)  {
            this.logStackTrace(e);
          throw e;
         }
          traza("Sale de Eliminar");
      }

//casoDeUso == "Consultar" ---------------------------------------------------------------------------
      if (casoDeUso.equals("Consultar") && accion.equals(""))  {
          traza("Entra en Consultar");
        pagina("contenido_secuencia_proceso_modificar");
        cargarCombos();
        getConfiguracionMenu("LPConsultaSecuenciaProcesos","Consultar");
        asignarAtributoPagina("cod","0636");
		try  {
          getFormatosValidaciones();
        } catch (Exception e)  {
            this.logStackTrace(e);
          throw e;
         }
          traza("Sale de Consultar");
      }


//accion == "modificar" ---------------------------------------------------------------------------
      if (accion.equals("modificar"))  {
          traza("Entra en modificar");
        pagina("contenido_secuencia_proceso_insertar");
        cargarCombos();
        mostrar();
        getConfiguracionMenu("LPMantieneSecuenciaProcesos","modificar");
        asignarAtributoPagina("cod","0634");
        try  {
          getFormatosValidaciones();
        } catch (Exception e)  {
            this.logStackTrace(e);
          throw e;
         }
          traza("Sale de modificar");
      }

//accion == "detallar" ---------------------------------------------------------------------------
      if (accion.equals("detallar"))  {
          traza("Entra en detallar");
        pagina("contenido_secuencia_proceso_insertar");
        cargarCombos();
        mostrar();
        getConfiguracionMenu("LPMantieneSecuenciaProcesos","detallar");
        asignarAtributoPagina("cod","0636");
        if ( casoDeUso.equals("Eliminar") ) asignarAtributoPagina("cod","0635");
          traza("Sale de detallar");
      }


//accion == "guardar" ----------------------------------------------------------------------
      if (accion.equals("guardar"))  {
          traza("Entra en guardar");
        pagina("salidaGenerica");
        guardar();
          traza("Sale de guardar");
      }
      asignarAtributo("VAR","hCasoDeUso","valor",casoDeUso);
      asignarAtributo("VAR","accion","valor",accion);

    } catch (Exception e) {
        lanzarPaginaError(e);
//        logStackTrace(e);
//        e.printStackTrace();
    }


  }


//este metodo se renombro "cargarCombos()" en lugar de mostarCarga() ya que representa mejor su funcionalidad.
  public void cargarCombos() throws Exception  {
      traza("Entra en cargarCombos");
    //Crear un DTOBelcorp dtoe con: - pais = Pais activo - idioma = Idioma del usuario
    DTOBelcorp dtoBelcorp = new DTOBelcorp();
    UtilidadesSession sesion = new UtilidadesSession();
    dtoBelcorp.setOidPais(sesion.getPais(this));
    dtoBelcorp.setOidIdioma(sesion.getIdioma(this));
    asignarAtributo("VAR","hOidIdioma","valor",sesion.getIdioma(this).toString());
    setCombos(dtoBelcorp);
      traza("Sale de cargarCombos");
  }


	private void setCombos(DTOBelcorp dtoB) throws Exception  {
      traza("Entra en setCombos");
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametros(dtoB);
    //Invocar al subsistema GestorCargaPantalla
    //Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
      traza("resultados: " + resultados.getXML() );
    //Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente
    //utilizando el String que representa el BusinessID en cada caso.
    asignar("COMBO", "cbGProcesos", resultados, "PEDconsultaGruposProceso");
    asignar("COMBO", "cbTipoSol", resultados, "PEDobtieneTiposSolicitudPorPais");
      traza("Sale de setCombos");
	}


  private ComposerViewElementList crearParametros(DTOBelcorp dto) throws Exception {
      traza("Entra en crearParametros");
    ComposerViewElementList lista = new ComposerViewElementList(); 
		//combo cbGProcesos
		ComposerViewElement cVE1 = new ComposerViewElement();
		cVE1.setIDBusiness("PEDconsultaGruposProceso");
		cVE1.setDTOE(dto);
		//combo cbTipoSol
		ComposerViewElement cVE2 = new ComposerViewElement();
		cVE2.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
		cVE2.setDTOE(dto);
		lista.addViewElement(cVE1);
		lista.addViewElement(cVE2);
      traza( "lista : " + lista.toString() );
      traza("Sale de crearParametros");
		return lista;
	}


  public void guardar() throws Exception  {
      traza("Entra en guardar()");
    try {
      //- Se crea DTOSecuenciaProcesos y se mapea con la PantallaGuardarSecuenciaProcesos así:
      DTOSecuenciaProcesos dtoSecProcGuardar = new DTOSecuenciaProcesos();

	  // Auditoria
	  dtoSecProcGuardar.setIpCliente(UtilidadesBelcorp.getIPCliente(this));				
      dtoSecProcGuardar.setPrograma(UtilidadesSession.getFuncion(this));

      if ( secuencia == null || secuencia.equals("") );
      else dtoSecProcGuardar.setSecuencia(new Integer(secuencia));
      if ( indEjecucion == null || indEjecucion.equals("") );
      else if ( indEjecucion.equals("S") ) dtoSecProcGuardar.setIndEjecucion( Boolean.TRUE );
           else dtoSecProcGuardar.setIndEjecucion( Boolean.FALSE);
      if ( oid == null || oid.equals("") );
      else dtoSecProcGuardar.setOid( Long.valueOf(oid) );
      if ( oidTipoSolicitudPais == null || oidTipoSolicitudPais.equals("") );
      else dtoSecProcGuardar.setOidTipoSolicitudPais( Long.valueOf(oidTipoSolicitudPais) );
      if ( oidProceso == null || oidProceso.equals("") );
      else dtoSecProcGuardar.setOidProceso( Long.valueOf(oidProceso) );
      if ( oidGrupoProcesos == null || oidGrupoProcesos.equals("") );
      else dtoSecProcGuardar.setOidGrupoProcesos( Long.valueOf(oidGrupoProcesos) );
        traza("dtoSecProcGuardar : " + dtoSecProcGuardar);
      Vector objBusiness = new Vector();
      objBusiness.add( dtoSecProcGuardar );
      //- Se crea idNegocio = "PEDguardaSecuenciaProcesos"
      objBusiness.add( new MareBusinessID("PEDguardaSecuenciaProcesos") );    
      //- Se invoca a ConectorGuardarSecuenciaProcesos
      conectar("ConectorGuardarSecuenciaProcesos",objBusiness);
      asignarAtributo("VAR", "ejecutar", "valor", "fPostGuardar()");
    } catch (Exception e)  { 
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");
        throw e;
      }
    traza("Sale de guardar()");
  }


//Nota del desarrollador: este metodo se renombro "mostrar()" en lugar de modificar() como sugeria el diseño,
//ya que representa mejor su funcionalidad.
  public void mostrar() throws Exception  {
      traza("Entra en mostrar()");
    //A partir del ítem seleccionado en la pantalla de búsqueda
    //se muestran los detalles en la pantalla de detalle.
    //Se crea un DTOOID y se rellena el atributo oid.
    DTOOID dtoOidModificar = new DTOOID();
    dtoOidModificar.setOidPais( new UtilidadesSession().getPais(this) );
    dtoOidModificar.setOid(Long.valueOf(oIDModificar));
    Vector objBusiness = new Vector();
    objBusiness.add(dtoOidModificar);
    //Se crea idNegocio = "PEDdetallesSecuenciaProcesos"
    objBusiness.add( new MareBusinessID("PEDdetallesSecuenciaProcesos") );
      traza("mostrar() objBusiness: " + objBusiness);
    //Se invoca a ConectorDetallesSecuenciaProcesos
    DruidaConector con = conectar("ConectorDetallesSecuenciaProcesos",objBusiness);
    //Se rellena la PantallaGuardarSecuenciaProcesos con el DTOSecuenciaProcesos devuelto:
    //dto.secuencia -> txtSecuencia
    //dto.indEjecucion -> indEjecucionLinea
    //dto.oid -> varOid
    //dto.oidTipoSolicitudPais -> cmbTipoSolicitud
    //dto.oidProceso -> cmbProceso
    //dto.oidGrupoProcesos -> cbGProcesos
    DTOSecuenciaProcesos dtoSecProcOut = (DTOSecuenciaProcesos) con.objeto("DTOSalida");
    asignarAtributo("CTEXTO","txtSecuencia","valor",dtoSecProcOut.getSecuencia().toString());

    if ( dtoSecProcOut.getIndEjecucion().booleanValue() )
      {  asignarAtributo("CHECKBOX", "chkIdEjecucionLinea", "check", "S"); }
    else { asignarAtributo("CHECKBOX", "chkIdEjecucionLinea", "check", "N"); }
    asignarAtributo("VAR","hOid","valor",dtoSecProcOut.getOid().toString());
    asignarAtributo("VAR","hCbTipoSol","valor",dtoSecProcOut.getOidTipoSolicitudPais().toString());
    asignarAtributo("VAR","hCbCodProceso","valor",dtoSecProcOut.getOidProceso().toString());
    asignarAtributo("VAR","hCbGProcesos","valor",dtoSecProcOut.getOidGrupoProcesos().toString());
      traza("Registro a mostrar: dtoSecProcOut " + dtoSecProcOut);
    //Pone no modificables: txtSecuencia, cmbTipoSolicitud, cmbProceso, cbGProcesos
      traza("Sale de mostrar()");
  }


  private void logStackTrace(Throwable e) throws Exception {
          traza("Se produjo la excepcion: " + e.getMessage());
 
          ByteArrayOutputStream pila = new ByteArrayOutputStream();
          PrintStream out = new PrintStream(pila);
          if (e instanceof MareException) {
              MareException e2=(MareException)e;
              traza("Es una mare Exception con codigo de error: "+e2.getCode());
          }
              e.printStackTrace(out);
              traza("stack Trace : " +  pila.toString());
      }


}//fin clase

/***************************************************************************************************
1.1 LPMantieneSecuenciaProcesos.java
************************************
1.1.1 Operation --Not Named-- ejecucion (), in Class LPMantieneSecuenciaProcesos
Si accion == "modificar"{
muestraCarga()
modifica()
}
Si accion == "muestraConsulta"{
muestraCarga()
}
Si accion =="muestraBorrado"{
muestraCarga()
}
Si accion =="muestraModificacion"{
muestraCarga()
}
Si accion =="muestraInsercion"{
muestraCarga()
}
Si accion == "guardar"{
guarda()
}
----------------------------------------------------------------------------------------------------
//Nota del desarrollador: este metodo se renombro "mostrar()" ya que representa mejor su funcionalidad.
1.1.2 Operation --Not Named-- modifica (), in Class LPMantieneSecuenciaProcesos
A partir del ítem seleccionado en la pantalla de búsqueda se muestran los detalles en la pantalla
de detalle. 

Proceso:
=======
1.- Se crea un DTOOID y se rellena el atributo oid.
2.- Se crea idNegocio = "PEDdetallesSecuenciaProcesos"
3.- Se invoca a ConectorDetallesSecuenciaProcesos
4.- Se rellena la PantallaGuardarSecuenciaProcesos con el DTOSecuenciaProcesos devuelto:
dto.secuencia -> txtSecuencia
dto.indEjecucion -> indEjecucionLinea
dto.oid -> varOid
dto.oidTipoSolicitudPais -> cmbTipoSolicitud
dto.oidProceso -> cmbProceso
dto.oidGrupoProcesos -> cmbGrupoProcesos

5.- Pone no modificables:
txtSecuencia
cmbTipoSolicitud
cmbProceso
cmbGrupoProcesos
----------------------------------------------------------------------------------------------------
//Nota del desarrollador: este metodo se renombro "cargarCombos()" ya que representa mejor su funcionalidad.
1.1.3 Operation --Not Named-- muestraCarga (), in Class LPMantieneSecuenciaProcesos
Crear un DTOBelcorp dtoe con:
- pais = Pais activo
- idioma = Idioma del usuario

Crear una lista ComposerViewElementList

Crear un elemento de tipo ComposerViewElement()
elem.IDBusiness="PEDconsultaGruposProceso";
elem.DTOE=null;
Añadir el elemento a la lista

Crear un elemento de tipo ComposerViewElement()
elem.IDBusiness="PEDobtieneTiposSolicitudPorPais";
elem.DTOE=dtoe;
Añadir el elemento a la lista

Invocar al subsistema GestorCargaPantalla

/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*
DruidaConector conConsultar = conectar("ConectorCargaPantalla", paramEntrada);

/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente
utilizando el String que representa el BusinessID en cada caso.
asignar("COMBO", "cmbGrupoProcesos", conConsultar, "PEDconsultaGruposProceso");
asignar("COMBO", "cmbTiposSolicitud", conConsultar, "PEDobtieneTiposSolicitudPorPais");
----------------------------------------------------------------------------------------------------

1.1.4 Operation --Not Named-- guarda (), in Class LPMantieneSecuenciaProcesos
Guarda los datos.

Proceso:
=======
- Se crea DTOSecuenciaProcesos y se mapea con la PantallaGuardarSecuenciaProcesos así:
dto.secuencia <- txtSecuencia
dto.indEjecucion <- indEjecucionLinea
dto.oid <- varOid
dto.oidTipoSolicitudPais <- cmbTipoSolicitud
dto.oidProceso <- cmbProceso
dto.oidGrupoProcesos <- cmbGrupoProcesos
- Se crea idNegocio = "PEDguardaSecuenciaProcesos"
- Se invoca a ConectorGuardarSecuenciaProcesos
***************************************************************************************************/
/*
java                    DTO                             xml                     Ocultas
secuencia               String secuencia                txtSecuencia            -
indEjecucion            Boolean indEjecucion            chkIdEjecucionLinea     hChkIdEjecucionLinea
oid                     Long oid                        -                       hOid
oidTipoSolicitudPais    Long oidTipoSolicitudPais       cbTipoSol               hCbTipoSol
oidProceso              Long oidProceso                 cbCodProceso            hCbCodProceso
oidGrupoProcesos        Long oidGrupoProcesos           cbGProcesos             hCbGProcesos
*/
