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
    $Id: LPEstructuraVial.java,v 1.1 2009/12/03 18:41:15 pecbazalar Exp $
    DESC
*/

import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.*;
import es.indra.sicc.dtos.zon.DTOConsultaEstructuraVialPantalla;
import es.indra.sicc.dtos.zon.DTOELocalizacionDirecciones;
import es.indra.sicc.dtos.zon.DTOUBIGEO;
import es.indra.sicc.dtos.zon.DTOUBIGEOS;
import es.indra.sicc.dtos.zon.DTOUG;
import es.indra.sicc.util.DTOPais;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.sql.Date;

import java.util.Enumeration;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

// Definicion de la clase
public class LPEstructuraVial extends LPSICCBase {

  private String accion;
  private DTOPais dtoPais;
  private IRastreador rastreador;
  private DTOConsultaEstructuraVialPantalla dtoCEVP;
  private Vector paramEntrada;
  private DocumentBuilder docBuild;

  //campos
  private String tipoVia;
  private String nombreVia;
  private String numero;
  private String descTipoVia;
  
  private String UG1;
  private String UG2;
  private String UG3;
  private String UG4;
  private String UG5;
  private String UG6;
  private String UG7;
  private String UG8;
  private String UG9;

  //contenido de los combos
  private String contUG1;
  private String contUG2;
  private String contUG3;
  private String contUG4;
  private String contUG5;
  private String contUG6;
  private String contUG7;
  private String contUG8;
  private String contUG9;

  private DTOUG dtoUG;
  private MareBusinessID id;
  private DruidaConector conectorConsultaUnidadesGeograficas;
  private DruidaConector conectorLocalizacionDirecciones;
  private DTOELocalizacionDirecciones dtoELocalizacionDirecciones;
  private DTOUBIGEOS dtoUBIGEOS;
  private String pais;
  private String oidUG;
  private String ugBuscar;

  // Definicion del constructor
  public LPEstructuraVial() {super();}

  // Definicion del metodo abstracto inicio
  public void inicio() throws Exception {
    // Defino el nombre de la vista
    pagina("contenido_vial_pais_buscar");	
  }

  // Definicion del metodo abstracto ejecucion
  public void ejecucion() throws Exception {
  
    try{
      this.setTrazaFichero();

      // Valores de validación
	  this.getFormatosValidaciones();         

      accion    = this.conectorParametroLimpia("accion", "", true);

	  // Rastreo
	  if(accion.equals("")){
		  this.rastreo();
	  }


      tipoVia   = this.conectorParametroLimpia("hComboTipoVia", "", true);
      descTipoVia = this.conectorParametroLimpia("hDescComboTipoVia", "", true);
      nombreVia = this.conectorParametroLimpia("hTxtNombreVia", "", true);
      numero    = this.conectorParametroLimpia("hTxtNumero", "", true);
      UG1       = this.conectorParametroLimpia("hComboUnidad1", "", true);
      UG2       = this.conectorParametroLimpia("hComboUnidad2", "", true);
      UG3       = this.conectorParametroLimpia("hComboUnidad3", "", true);
      UG4       = this.conectorParametroLimpia("hComboUnidad4", "", true);
      UG5       = this.conectorParametroLimpia("hComboUnidad5", "", true);
      UG6       = this.conectorParametroLimpia("hComboUnidad6", "", true);
      UG7       = this.conectorParametroLimpia("hComboUnidad7", "", true);
      UG8       = this.conectorParametroLimpia("hComboUnidad8", "", true);
      UG9       = this.conectorParametroLimpia("hComboUnidad9", "", true);

      //contenido de los combos
      contUG1   = this.conectorParametroLimpia( "hContComboUnidad1", "", true );
      contUG2   = this.conectorParametroLimpia( "hContComboUnidad2", "", true );
      contUG3   = this.conectorParametroLimpia( "hContComboUnidad3", "", true );
      contUG4   = this.conectorParametroLimpia( "hContComboUnidad4", "", true );
      contUG5   = this.conectorParametroLimpia( "hContComboUnidad5", "", true );
      contUG6   = this.conectorParametroLimpia( "hContComboUnidad6", "", true );
      contUG7   = this.conectorParametroLimpia( "hContComboUnidad7", "", true );
      contUG8   = this.conectorParametroLimpia( "hContComboUnidad8", "", true );
      contUG9   = this.conectorParametroLimpia( "hContComboUnidad9", "", true );

      /*
      traza("----------------------------------");
      traza( "accion: " + accion );
      traza( "tipoVia: " + tipoVia );
      traza( "nombreVia: " + nombreVia );
      traza( "numero: " + numero );
      traza( "UG1: " + UG1 );
      traza( "UG2: " + UG2 );
      traza( "UG3: " + UG3 );
      traza( "UG4: " + UG4 );
      traza( "UG5: " + UG5 );
      traza( "UG6: " + UG6 );
      traza( "UG7: " + UG7 );
      traza( "UG8: " + UG8 );
      traza( "UG9: " + UG9 );
      traza("----------------------------------");
      */

      dtoPais = new DTOPais();
      dtoPais.setOidPais( UtilidadesSession.getPais( this ) );
      dtoPais.setPais( UtilidadesSession.getPais( this ) );
      dtoPais.setOidIdioma( UtilidadesSession.getIdioma( this ) );
      dtoPais.setIpCliente( UtilidadesBelcorp.getIPCliente( this ) );
      dtoPais.setPrograma( UtilidadesSession.getFuncion( this ) );

      pais = dtoPais.getOidPais().toString();

      
      traza("******************************");
      traza("PAIS: " + dtoPais.getOidPais().longValue() );
      traza("******************************");

      traza("******************************");
      traza( "PAIS: " + dtoPais.getOidPais() );
      traza( "IDIOMA: " + dtoPais.getOidIdioma() );
      traza( "IPCLIENTE: " + dtoPais.getIpCliente() );
      traza( "PROGRAMA: " + dtoPais.getPrograma() );
      traza("******************************");
      

      MareBusinessID id = new MareBusinessID("ZONPantallaEstructuraVial");

      paramEntrada = new Vector();
      paramEntrada.add( dtoPais );
      paramEntrada.add( id );

      traza("-- VA A CONECTAR 1 --");
      DruidaConector conectorConsultaPantallaEstructuraVial = conectar("ConectorConsultaPantallaEstructuraVial", paramEntrada);
      traza("-- CONECTO 1 --");
      
      dtoCEVP = (DTOConsultaEstructuraVialPantalla)conectorConsultaPantallaEstructuraVial.objeto( "ESTRUCTURA_VIAL" );
      RecordSet rsTiposVia = (dtoCEVP == null) ? null : dtoCEVP.getTiposVia();
      RecordSet rsUnidadesGP = (dtoCEVP == null) ? null : dtoCEVP.getUnidadesGeo();

      DruidaConector conTiposVia = new DruidaConector();
      conTiposVia.setXML(getElementFromRecordSet( rsTiposVia, "dtoSalida.resultado_ROWSET") );

      //traza("########################################################");
      //traza("DATOS EN conTiposVia");
      //traza(conTiposVia.getXML());
      //traza("########################################################");
      
      // --------------
      this.asignar("COMBO", "comboTipoVia", conTiposVia, "dtoSalida.resultado_ROWSET");
      // --------------
     
      if( accion.equals( "" ) ){
        /*
        traza("----------------------------------------------------------------");
        traza("ENTRO A LA ACCION VACIA");
        traza("----------------------------------------------------------------");
        */

		this.rastreo();
    
        // Asignar campos
        traza("PAIS ANTES DE ASIGNAR: " + pais);
        this.asignarAtributo( "VAR", "accion", "valor", accion );
        this.asignarAtributo( "VAR", "hPais", "valor", pais );

		asignarAtributo("VAR", "hFormatoDef", "valor", (new Integer(this.FORMATO_DEFAULT)).toString());
		
        traza("TERMINO LA ACCION VACIA");
        
      }
    }
    catch( Exception e ){
		traza ("Error en logStackTrace: " + e.getMessage ());
		this.lanzarPaginaError(e);      
    }

	this.getConfiguracionMenu("LPEstructuraVial");
  }


private void logStackTrace(Throwable e) {
     ByteArrayOutputStream os = new ByteArrayOutputStream();
	 PrintStream ps = new PrintStream(os);

	 e.printStackTrace(ps);
     try {
		traza("Se produjo la excepcion: " 
			+ e.getMessage() 
			+ "\n" 
			+ "stackTrace = " 
		    + os.toString());
     }
     catch (Exception ex) {
        //traza ("Error en logStackTrace: " + ex.getMessage ());
		e.printStackTrace ();
     }
	}


  private Element getElementFromRecordSet(RecordSet rsEntrada, String id) throws Exception{
    if(docBuild == null){
       docBuild = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    }

    Document doc = docBuild.newDocument();
    Element raiz = doc.createElement("ROWSET2");
    doc.appendChild(raiz);

    int filas = rsEntrada.getRowCount();
    int columnas = rsEntrada.getColumnCount();

    Vector nombresColumnas = rsEntrada.getColumnIdentifiers();
    Vector vFila = null;
    Element rowset = doc.createElement("ROWSET");
    rowset.setAttribute("ID", id);
    rowset = (Element)doc.getDocumentElement().appendChild(rowset);
    Element campo = null;
    Element row = null;

    for(int i = 0; i < filas; i++){
       vFila = rsEntrada.getRow(i);
       row = doc.createElement("ROW");
       row = (Element)rowset.appendChild(row);
       row.setAttribute("ID", (vFila.get(0) == null)?"":vFila.get(0).toString());
       for(int j = 0; j < columnas; j++){
          campo = doc.createElement("CAMPO");
          campo.setAttribute("TIPO", "STRING");
          campo.setAttribute("LONGITUD", "100");
          campo.setAttribute("NOMBRE", (String)nombresColumnas.get(j));
          campo.appendChild(doc.createTextNode((vFila.get(j) == null)?"":vFila.get(j).toString()));
          row.appendChild(campo);
       }
    }
    return doc.getDocumentElement();
  }

}












