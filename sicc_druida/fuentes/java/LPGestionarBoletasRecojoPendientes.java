/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.math.BigDecimal;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;                
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;           
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.druida.DruidaConector;
import es.indra.sicc.cmn.negocio.comun.DTOComunes.DTOOIDPaginado;
import es.indra.sicc.util.UtilidadesSession; 
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.dtos.rec.DTOGestBoletasRecPend;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;

import java.util.Vector;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.mare.common.dto.*;
import java.text.SimpleDateFormat;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.util.Enumeration;
import es.indra.sicc.util.*;

public class LPGestionarBoletasRecojoPendientes extends LPSICCBase {

	private String accion = null;
	private Long idioma;
	private Long pais;    
    private String opcionMenu = "";

    private Long oidIdioma = null;
    private Long oidPais = null;
	private String ipCliente = "";

	private String elementosSeleccionadosBoletasRecojoPendientes = null;

    public LPGestionarBoletasRecojoPendientes() {
		super();
	}

	public void inicio() throws Exception {
        setTrazaFichero();
        pagina("contenido_boleta_recojo_pendiente_gestionar");
		getFormatosValidaciones();
        this.getConfiguracionMenu("LPGestionarBoletasRecojoPendientes","");		
	} 

	public void ejecucion() throws Exception {
		rastreo();
		setTrazaFichero();
		traza("*** Entrada - LPGestionarBoletasRecojoPendientes - ejecucion ***");
		
		this.accion = conectorParametroLimpia("accion", "", true);
		this.idioma = UtilidadesSession.getIdioma(this);
		this.pais = UtilidadesSession.getPais(this);      	
		this.opcionMenu = conectorParametroLimpia("opcionMenu","",true);

        oidPais = UtilidadesSession.getPais(this);
        oidIdioma = UtilidadesSession.getIdioma(this);
        ipCliente = UtilidadesBelcorp.getIPCliente(this);                        

        try{
			if(accion.equals("")){	      
				this.cargarPagina();	      		
			}else if(accion.equals("no exitoso")){
				this.noExitoso();
			} else if(accion.equals("anular")){
				this.anular();
			}
		}catch(Exception  e){
			logStackTrace(e);
			lanzarPaginaError(e);
		}
		
		traza("*** Salida - LPGestionarBoletasRecojoPendientes - ejecucion ***");	

	}

	private void cargarPagina () throws Exception {
	
		traza("*** Entrada - LPGestionarBoletasRecojoPendientes - cargarPagina ***");
		asignarAtributo( "VAR", "hFechaRecojo", "valor", hoyAString());
		traza("hFechaRecojo: " + conectorParametroLimpia("hFechaRecojo","",true));
		cargarMarcaCanal();
        traza("*** Salida  - LPGestionarBoletasRecojoPendientes - cargarPagina ***");


		Long oidMarcaDefecto = UtilidadesSession.getMarcaPorDefecto(this);
		Long oidCanalDefecto = UtilidadesSession.getCanalPorDefecto(this);

		cargarPeriodoDesde(oidPais, oidMarcaDefecto, oidCanalDefecto);
 
		asignarAtributo("VAR","accion","valor",accion);
        asignarAtributo("VAR","hidMarca","valor",oidMarcaDefecto.toString());
        asignarAtributo("VAR","hidCanal","valor",oidCanalDefecto.toString());
        asignarAtributo("VAR","hidPais","valor",oidPais.toString());

		asignarAtributo("VAR","oidPais","valor",oidPais.toString());

		traza("hidPais: " + conectorParametroLimpia("hidPais","",true));
		traza("oidPais: " + conectorParametroLimpia("oidPais","",true));
	}

	private void logStackTrace(Throwable e) throws Exception {
	
		traza("Se produjo la excepcion: " + e.getMessage());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);
		
		traza("Stack Trace: " + baos.toString());
	
	}

	private void cargarMarcaCanal() throws Exception{
		traza("Entró de cargarMarcaCanal()");

		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		traza("antes del conector.ejecucion");
		conector.ejecucion();
		traza("despues del conector");
		DruidaConector resultados = conector.getConector();
			 
		asignar("COMBO", "cbMarca", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanal", resultados, "SEGRecuperaCanales");

		traza("Salio de cargarMarcaCanal()");
	}

	 private ComposerViewElementList crearParametrosEntrada() throws Exception{
      traza("metodo ComposerViewElementList");
      ComposerViewElementList lista = new ComposerViewElementList();
  
      DTOBelcorp dtoBel = new DTOBelcorp();
      traza("antes de asignar al dtobelcorp");
      dtoBel.setOidPais(oidPais);
      dtoBel.setOidIdioma(oidIdioma);
           
      ComposerViewElement marcas = new ComposerViewElement();
      marcas.setIDBusiness("SEGConsultaMarcas");
      marcas.setDTOE(dtoBel);
           
      lista.addViewElement(marcas);

	  ComposerViewElement canales = new ComposerViewElement();
      canales.setIDBusiness("SEGRecuperaCanales");
      canales.setDTOE(dtoBel);
           
      lista.addViewElement(canales);
      
      return lista;
    }

	private void cargarPeriodoDesde(Long oidPais, Long oidMarca, Long oidCanal) throws Exception{
		traza("Entró de cargarPeriodoDesde(Long oidPais, Long oidMarca, Long oidCanal)");
		DTOPeriodo paisMarcaCanal = new DTOPeriodo();
		paisMarcaCanal.setOidIdioma(oidIdioma);
		paisMarcaCanal.setPais(oidPais);
		paisMarcaCanal.setMarca(oidMarca);
		paisMarcaCanal.setCanal(oidCanal);

		Vector paramEntrada = new Vector();
		paramEntrada.add(paisMarcaCanal);

		paramEntrada.add(new MareBusinessID("CRAObtienePeriodoActual"));
		DruidaConector conectorCargarPeriodo = conectar("ConectorObjeto", paramEntrada);

		IMareDTO dtoSalida = (IMareDTO)conectorCargarPeriodo.objeto("DTOSalida");
		DTOPeriodo dtoPeriodo = (DTOPeriodo)(dtoSalida.getProperty("periodoActual"));

		String periodoActual = dtoPeriodo.getOid().toString();
		asignarAtributo("VAR","hOidPeriodoDde","valor",periodoActual);
		traza("asigno periodo actual:"+periodoActual);

		traza("Salió de cargarPeriodoDesde(Long oidPais, Long oidMarca, Long oidCanal)");
	}

    private String hoyAString() throws Exception {
       String formato = UtilidadesSession.getFormatoFecha(this);
       traza("Formato fecha: "+formato);
       int pos = formato.indexOf("mm");
       if ( pos > -1) 
           formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
       SimpleDateFormat sdf = new SimpleDateFormat(formato);
       String fecha = sdf.format(new java.util.Date());
       traza("Fecha: "+fecha);
	 
       return fecha;
   }

   private DTOOIDs obtOidsAnular() throws Exception {
		String nrsAtencion   = conectorParametro("numsAten");
		traza("nrsAtencion: " + nrsAtencion);
		StringTokenizer filas = new StringTokenizer(nrsAtencion, "&");

		DTOOIDs nrosAten = null;

	    String idAten = null;
		if (!nrsAtencion.equals("")){
			nrosAten = new DTOOIDs();
		    Long[] oids = new Long[filas.countTokens()]; 
			int k = 0;
		    while(filas.hasMoreTokens()) {
				  StringTokenizer oid = new StringTokenizer(filas.nextToken(), "|");
				  while(oid.hasMoreTokens()) {
					  idAten = oid.nextToken();
					  traza("oid leido: " + idAten);
					  oids[k] = Long.valueOf(idAten);
					  k++;
				  }
			}
			nrosAten.setOids(oids);          
 		}
		traza("nrosAten mide: " + nrosAten.getOids().length);
		return nrosAten;
   }

   private DTOOIDs obtOidsNoExitosos() throws Exception {
		String oidsRegistros = conectorParametro("elemSelecc");
		traza("bolRecojoPend: " + oidsRegistros);
		StringTokenizer filas = new StringTokenizer(oidsRegistros, "&");

		DTOOIDs oidsNoExitosos = null;

	    String idNoEx = null;
		if (!oidsRegistros.equals("")){
			oidsNoExitosos = new DTOOIDs();
		    Long[] oids = new Long[filas.countTokens()]; 
			int k = 0;
		    while(filas.hasMoreTokens()) {
				  StringTokenizer oid = new StringTokenizer(filas.nextToken(), "|");
				  while(oid.hasMoreTokens()) {
					  idNoEx = oid.nextToken();
					  traza("oid leido: " + idNoEx);
					  oids[k] = Long.valueOf(idNoEx);
					  k++;
				  }
			}
			oidsNoExitosos.setOids(oids);          
 		}
		traza("oidsNoExitosos mide: " + oidsNoExitosos.getOids().length);
		return oidsNoExitosos;
   }

   private void anular() throws Exception {
        traza("anular inicio");
		pagina("salidaGenerica");
		//utilizo mismo conector y BId, para ambos casos (no ex. y anular!)
		MareBusinessID id = new MareBusinessID("RECGuardarNoExitososAnular");
		Vector parameters = new Vector();

		DTOGestBoletasRecPend dtoGBRP = new DTOGestBoletasRecPend();
		dtoGBRP.setOids(obtOidsNoExitosos());
		dtoGBRP.setNumsAten(obtOidsAnular());
		dtoGBRP.setAnularNoExitoso(new String("AN"));   //parametro, anular

        dtoGBRP.setOidPais(UtilidadesSession.getPais(this));
        dtoGBRP.setOidIdioma(UtilidadesSession.getIdioma(this));

		parameters.add(dtoGBRP);
		parameters.add(id);
		DruidaConector conector = conectar("ConectorGuardarNoExitosos", parameters);                          
        traza("anular fin");

		asignarAtributo("VAR","ejecutar","valor","guardoAnularOk();");

    }

    private void noExitoso() throws Exception {
        traza("noExitoso inicio");
		pagina("salidaGenerica");
		//utilizo mismo conector y BId, para ambos casos (no ex. y anular!)
		MareBusinessID id = new MareBusinessID("RECGuardarNoExitososAnular");
		Vector parameters = new Vector();

		DTOGestBoletasRecPend dtoGBRP = new DTOGestBoletasRecPend();
		dtoGBRP.setOids(obtOidsNoExitosos());
		dtoGBRP.setNumsAten(obtOidsAnular());
		dtoGBRP.setAnularNoExitoso(new String("NE"));   //parametro, no exitoso
		//Agregado por cambio 20080765
		dtoGBRP.setOidNumRecoj(obtenerOidNumRecojo());
		dtoGBRP.setNumBoletaRecojo(obtenerNumeroBoletaRecojo());
        dtoGBRP.setOidPais(UtilidadesSession.getPais(this));
        dtoGBRP.setOidIdioma(UtilidadesSession.getIdioma(this));

		parameters.add(dtoGBRP);
		parameters.add(id);
		DruidaConector conector = conectar("ConectorGuardarNoExitosos", parameters);                          
        traza("noExitoso fin");

		asignarAtributo("VAR","ejecutar","valor","guardoNoExitososOk();");

    }
	//Agregado por cambio 20080765
	private DTOOIDs obtenerOidNumRecojo() throws Exception{
		String oidsNumRecoj = conectorParametro("numsRecoj");
		traza("oidsNumRecoj: " + oidsNumRecoj);
		StringTokenizer filas = new StringTokenizer(oidsNumRecoj, "&");

		DTOOIDs oidsNumeroRecojo = null;

	    String idNuRe = null;
		if (!oidsNumRecoj.equals("")){
			oidsNumeroRecojo = new DTOOIDs();
		    Long[] oids = new Long[filas.countTokens()]; 
			int k = 0;
		    while(filas.hasMoreTokens()) {
				  StringTokenizer oid = new StringTokenizer(filas.nextToken(), "|");
				  while(oid.hasMoreTokens()) {
					  idNuRe = oid.nextToken();
					  traza("oid leido: " + idNuRe);
					  oids[k] = Long.valueOf(idNuRe);
					  k++;
				  }
			}
			oidsNumeroRecojo.setOids(oids);          
 		}
		traza("oidsNumeroRecojo mide: " + oidsNumeroRecojo.getOids().length);
		return oidsNumeroRecojo;
	}
 // Agregado por cambio 20080765
	private DTOOIDs obtenerNumeroBoletaRecojo() throws Exception{
		traza("LPGestionarBoletasRecojoPendientes.obtenerNumeroBoletaRecojo(): Entrada ");
		String numBoletaRecojo = conectorParametro("numBoletaRecojo");
		traza("numBoletaRecojo: " + numBoletaRecojo);
		StringTokenizer filas = new StringTokenizer(numBoletaRecojo, "&");

		DTOOIDs NumeroBoletaRecojo = null;

	    String idNuBoRe = null;
		if (!numBoletaRecojo.equals("")){
			NumeroBoletaRecojo = new DTOOIDs();
		    Long[] oids = new Long[filas.countTokens()]; 
			int k = 0;
		    while(filas.hasMoreTokens()) {
				  StringTokenizer oid = new StringTokenizer(filas.nextToken(), "|");
				  while(oid.hasMoreTokens()) {
					  idNuBoRe = oid.nextToken();
					  traza("oid leido: " + idNuBoRe);
					  oids[k] = Long.valueOf(idNuBoRe);
					  k++;
				  }
			}
			NumeroBoletaRecojo.setOids(oids);          
 		}
		traza("NumeroBoletaRecojo mide: " + NumeroBoletaRecojo.getOids().length);
		traza("NumeroBoletaRecojo: " + NumeroBoletaRecojo);
		traza("LPGestionarBoletasRecojoPendientes.obtenerNumeroBoletaRecojo(): Salida ");
		return NumeroBoletaRecojo;
		
		
	}

}