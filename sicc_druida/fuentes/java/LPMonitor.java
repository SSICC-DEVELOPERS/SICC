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

/*import LPSICCBase;*/
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.ped.DTOBuscarDatosMonitor;
import es.indra.sicc.dtos.ped.DTOCargaInicialMonitor;
import es.indra.sicc.dtos.ped.DTODatosMonitor;
import es.indra.sicc.dtos.ped.DTOEGrupoReversion;
import es.indra.sicc.dtos.ped.DTOElementoPlantilla;
import es.indra.sicc.dtos.ped.DTOInfoMonitor;
import es.indra.sicc.dtos.ped.DTOListaSolicitudes;
import es.indra.sicc.dtos.ped.DTOPlantilla;
import es.indra.sicc.dtos.ped.DTOSecuenciaSolicitudes;
import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;
import es.indra.sicc.logicanegocio.ped.ConstantesPED;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

/**
 * Sistema:       Belcorp
 * Modulo:        PED
 * Submódulo:     Monitor
 * Componente:    LPMonitor
 * Fecha:         30/07/2004
 * Observaciones:     
 * @version        1.0
 * @autor         
 */
public class LPMonitor extends LPSICCBase {

	public LPMonitor() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_estados_consolidados_buscar");
	}

	/**
	 * CHANGELOG
	 * ---------
	 * dmorello, 15/01/2009 - Cambio RI 20090825
	 *  - Al mostrar la lista, el valor que toma el campo txtFechaFact
	 *    depende de que este relleno o no el campo Fecha final.
	 */
	public void ejecucion() throws Exception {

	  setTrazaFichero();
	  rastreo();
	  String mAccion = conectorParametroLimpia( "accion", "", true );
	  
	  try{
      traza("Accion: "+ mAccion);
      asignarAtributo( "VAR", "hFormatoFechaPais", "valor", UtilidadesSession.getFormatoFecha(this));    
      asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());    
      //LPMonitor/buscar = 0691,0,0,1,0,1,1,1,1,1,1
      //LPMonitor/datosPlantilla = 0691,0,1,0,0,0,1,0,0,0,1

      getConfiguracionMenu("LPMonitor","buscar");                    

			if (mAccion.equals("")) {
          asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString()); //incidencia SiCC-20070172    
          cargaInicialMonitor();
      
          //asignarAtributo( "VAR", "hFechaIni", "valor", hoyAString());    
          asignarAtributo( "VAR", "hMostrarLista", "valor", "N");    
          //asignarAtributo("CAPA", "capa2", "visibilidad", "hidden");		
          //asignarAtributo("CAPA", "capaCombo", "visibilidad", "hidden");		


			} else if (mAccion.equals("datosPlantilla")) {
      		pagina("contenido_estados_consolidados_buscar_detalle_2");
          getConfiguracionMenu("LPMonitor","datosPlantilla");                    
          
    			String paramModif = conectorParametroLimpia( "hModificar", "", true );
          asignarAtributo( "VAR", "hModificar", "valor", paramModif);    
          traza("Modificar: "+paramModif);
          if (paramModif.equals("true")) {
              //asignarAtributo("CTEXTO", "txtCodigoCliente", "visibilidad", "hidden");    
              //asignarAtributo("LABELC", "lblCodigoPlantilla", "visibilidad", "hidden");		
              asignarAtributo("CAPA", "capa2", "visibilidad", "hidden");		
              asignarAtributo("CAPA", "capaSinCod", "visibilidad", "");		
          } else {
              asignarAtributo("CAPA", "capa2", "visibilidad", "");		
              asignarAtributo("CAPA", "capaSinCod", "visibilidad", "hidden");		
          }
          
        
      } else if (mAccion.equals("buscar")) {
          pagina("salidaGenerica");
              try{
                  //cargaInicialMonitor();
        
                  String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );
                  String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );
                  String codPlantilla = conectorParametroLimpia( "hCbCodPlantilla", "", true );
                  String tipoSol = conectorParametroLimpia( "hTipoSol", "", true );
                  String acceso = conectorParametroLimpia( "hAcceso", "", true );
                  //<inicio>Obtiene las regiones y zonas seleccionadas, incidencia SiCC-20070172
                  String region = conectorParametroLimpia( "hRegion", "", true );
                  String zona = conectorParametroLimpia( "hZona", "", true );
                  traza("Region: "+ region);                  
                  traza("Zona: "+ zona);                  
                  //<fin>incidencia SiCC-20070172
                  
                  // sapaza -- PER-SiCC-2011-0079 -- 15/02/2011
                  String periodo = conectorParametroLimpia( "hOidPeriodo", "", true );
                  String periodoSiguiente = conectorParametroLimpia( "hOidPeriodoSiguiente", "", true );
                  String indPeriodoSiguiente = conectorParametroLimpia( "hIndPeriodoSiguiente", "N", true );                  
				  
                  // sapaza -- PER-SiCC-2011-1002 -- 16/12/2011
                  String fechaProceso = conectorParametroLimpia( "hFechaProceso", "", true );

                  DTOBuscarDatosMonitor dtoBDM = new DTOBuscarDatosMonitor();
                  dtoBDM.setOidIdioma(UtilidadesSession.getIdioma(this));
                  dtoBDM.setOidPais(UtilidadesSession.getPais(this));
                  dtoBDM.setFechaInicio(stringAFecha(fechaIni));
                  if (fechaFin.equals(""))
                      dtoBDM.setFechaFin(dtoBDM.getFechaInicio());
                  else
                      dtoBDM.setFechaFin(stringAFecha(fechaFin));
                  dtoBDM.setPlantilla(codPlantilla.trim().equals("") ? null : new Long(codPlantilla));
                  dtoBDM.setOidAcceso(acceso.trim().equals("") ? null : new Long(acceso));
                  dtoBDM.setOidTipoSolicitudPais(tipoSol.trim().equals("") ? null : this.obtenerTiposSolicitud(tipoSol));
                  //<inicio>Obtiene las regiones y zonas seleccionadas, incidencia SiCC-20070172
                  dtoBDM.setOidRegiones(region.trim().equals("") ? null : this.obtenerRegiones(region));
                  dtoBDM.setOidZonas(zona.trim().equals("") ? null : this.obtenerZonas(zona));
                  //<fin>incidencia SiCC-20070172
                  
                  // sapaza -- PER-SiCC-2011-0079 -- 25/02/2011
                  dtoBDM.setOidPeriodo(periodo.equals("") ? null : new Long(periodo));
                  if(indPeriodoSiguiente.equals("S"))
                	  dtoBDM.setOidPeriodoSiguiente(periodoSiguiente.equals("") ? null : new Long(periodoSiguiente));
                			  
                  MareBusinessID bizId = new MareBusinessID("PEDBuscarDatosMonitorMejorado");
        
                  Vector params = new Vector();
                  params.addElement( dtoBDM );
                  params.addElement( bizId );
        
                  DruidaConector dc  =	conectar( "ConectorDatosMonitor" , params );
        
                  DTODatosMonitor dtoS = (DTODatosMonitor) dc.objeto("dtoSalida"); 
                  String asignacion = convertirRecordSetAString(dtoS.getProcesos());   
                  
                  String totalGP1 = dtoS.getTotalGP1() == null ? "" : dtoS.getTotalGP1().toString();    
                  String totalGP2 = dtoS.getTotalGP2() == null ? "" : dtoS.getTotalGP2().toString();    
                  String totalGP3 = dtoS.getTotalGP3() == null ? "" : dtoS.getTotalGP3().toString();    
                  String totalGP4 = dtoS.getTotalGP4() == null ? "" : dtoS.getTotalGP4().toString();    
                  String totalGP5 = dtoS.getTotalGP5() == null ? "" : dtoS.getTotalGP5().toString();   

                  // sapaza -- PER-SiCC-2011-0644 -- 22/11/2011
				  String fechaFact = fechaProceso;
				  /*if (fechaFin.length() == 0) {
					  fechaFact = fechaIni;
				  } else {
					  fechaFact = hoyAString(null);
				  }*/
                  asignarAtributo("VAR","ejecutar","valor","initLista('"+asignacion+"','"+totalGP1+"','"+totalGP2+"','"+totalGP3+"','"+totalGP4+"','"+totalGP5+"','"+fechaFact+"')");
              }catch(Exception e){
                  asignarAtributo("VAR","ejecutarError","valor","borrarLista()");
                  throw e;
              }

      } else if (mAccion.equals("guardar")) {
          pagina("salidaGenerica");
          DTOPlantilla dtoP = new DTOPlantilla();
          dtoP.setOidPais(UtilidadesSession.getPais(this));
		  String usaPlant = conectorParametroLimpia( "hUsaPlantillas", "", true );
		  traza( "ejecucion,guardar, usaPlant: " + usaPlant);
          if (usaPlant.equals("true")) {
              String codPlant = conectorParametroLimpia( "hCbCodPlantilla", "", true );
              dtoP.setOid(codPlant.equals("") ? null : new Long(codPlant));
              dtoP.setCodigo(conectorParametroLimpia( "hCodigoPlantilla", "", true ));
              dtoP.setDescripcion(conectorParametroLimpia( "hDescripcion", "", true ));
          }
          //Supongo que viene para cada GP de la pantalla:
          //Tipo1 | Region1 | Zona1 | Secuencia1 |#| Tipo1 | Region1 | Zona1 | Secuencia2 ...
    			String treeGP1 = conectorParametroLimpia( "hTreeGP1", "", true );
    			String treeGP2 = conectorParametroLimpia( "hTreeGP2", "", true );
    			String treeGP3 = conectorParametroLimpia( "hTreeGP3", "", true );
    			String treeGP4 = conectorParametroLimpia( "hTreeGP4", "", true );
    			String treeGP5 = conectorParametroLimpia( "hTreeGP5", "", true );

          TreeSet tsGP1 = generarTreeSet(treeGP1);
          TreeSet tsGP2 = generarTreeSet(treeGP2);
          TreeSet tsGP3 = generarTreeSet(treeGP3);
          TreeSet tsGP4 = generarTreeSet(treeGP4);
          TreeSet tsGP5 = generarTreeSet(treeGP5);

          dtoP.setGp1(tsGP1);
          dtoP.setGp2(tsGP2);
          dtoP.setGp3(tsGP3);
          dtoP.setGp4(tsGP4);
          dtoP.setGp5(tsGP5);

		  dtoP.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
		  dtoP.setPrograma("LPMonitor");


          MareBusinessID bizId = new MareBusinessID("PEDGuardarPlantilla");

          Vector params = new Vector();
          params.addElement( dtoP );
          params.addElement( bizId );

          traza("Antes conector guardar plantilla, dtoP: "+dtoP);

          DruidaConector dc  =	conectar( "ConectorGuardarPlantilla" , params );
          
      } else if (mAccion.equals("CrearGrupoRevesion")) {
		  
    	  String lista = conectorParametroLimpia( "hListaOidsCrear", "", true );
    	  String grupoRever = conectorParametroLimpia( "hGrupoReversion", "", true );
    	  String GPRever = conectorParametroLimpia( "hGPRever", "", true );
    	  String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );
    	  String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );

          DTOInfoMonitor dtoIM = armarDTOInfo(fechaIni, fechaFin, lista, new Long(GPRever));

          //MareBusinessID bizId = new MareBusinessID("PEDObtenerSolicitud");
		  MareBusinessID bizId = new MareBusinessID("PEDObtenerSolicitudRever");

          Vector params = new Vector();
          params.addElement(dtoIM);
          params.addElement(bizId);

          traza( "Antes conector: " + dtoIM);
		  DruidaConector dc = null;

		  pagina("contenido_grupos_reversion_crear");
	  	  dc = conectar( "ConectorObtenerSolicitudes" , params );

          traza( "dc "); 

          DTOListaSolicitudes dtoS = (DTOListaSolicitudes) dc.objeto("dtoSalida"); 

          traza("DTOListaSol: "+dtoS);
          //DTOListaSolicitudes dtoS = new DTOListaSolicitudes();  /*** SACAR POR COMENTARIO ANTERIOR ***/
          //dtoS.setLista(new Vector());  /*** SACAR POR COMENTARIO ANTERIOR ***/
          //dtoS.getLista().add("1");  /*** SACAR POR COMENTARIO ANTERIOR ***/
          //dtoS.getLista().add("2");  /*** SACAR POR COMENTARIO ANTERIOR ***/


          Vector arOid = dtoS.getLista();
          String listaSol = "";
          for (int i = 0; i < arOid.size(); i++) {
              DTOSolicitudValidacion dtoSV = (DTOSolicitudValidacion) arOid.get(i);
              listaSol = listaSol + dtoSV.getOidSolicitud().toString();
              listaSol = listaSol + ",";
          }

          asignarAtributo( "VAR", "listaSolicitudes", "valor", listaSol);    
          asignarAtributo( "VAR", "grupoReversion", "valor", grupoRever);    

          traza("Lista Sol antes Crear: "+listaSol);
          
          conectorAction("LPCrearGrupoReversion"); //en diseño es LPCrearGruposReversion
          conectorActionParametro("accion","");
          conectorActionParametro("listaSolicitudes", listaSol);
          conectorActionParametro("grupoReversion", grupoRever);


      } else if (mAccion.equals("revertirProcesos")) {
          pagina("salidaGenerica");
    			String grupoRever = conectorParametroLimpia( "hGrupoReversion", "", true );
    			String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );
    			String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );

          DTOEGrupoReversion dtoE = new DTOEGrupoReversion();
          dtoE.setGrupoReversion(grupoRever);
          dtoE.setOidIdioma(UtilidadesSession.getIdioma(this));

          
          MareBusinessID bizId = new MareBusinessID("PEDRevertirProcesos");

          Vector params = new Vector();
          params.addElement(dtoE);
          //params.addElement(new DTOAuditableSICC()); 
          params.addElement(bizId);
   

          traza( "Antes conector, reversion: " + dtoE);
          DruidaConector dc  =	conectar( "ConectorRevertirProcesos" , params );

          
          //traza("el conector, retorno: " + dc.getXML());
		  traza("el conector, retorno: " + dc);
          traza( "dc "); 


      } else if (mAccion.equals("validaciones")) {
          pagina("salidaGenerica");
    			String lista = conectorParametroLimpia( "hCrearGP1", "", true );
    			String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );
    			String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );

          DTOInfoMonitor dtoIM = armarDTOInfo(fechaIni, fechaFin, lista, ConstantesPED.GP1);

          // sapaza -- PER-SiCC-2011-0079 -- 15/02/2011
          String codigoPais = conectorParametroLimpia( "hCodigoPais", "", true );
		  String codigoPeriodo = conectorParametroLimpia( "hCodigoPeriodo", "", true );
		  String oidPeriodo = conectorParametroLimpia( "hOidPeriodo", "", true );
		  String fechaProceso = conectorParametroLimpia( "hFechaProceso", "", true );
          String periodoSiguiente = conectorParametroLimpia( "hOidPeriodoSiguiente", "", true );
          String indPeriodoSiguiente = conectorParametroLimpia( "hIndPeriodoSiguiente", "N", true );                  
		  
          if(!codigoPais.equals("") )
        	  dtoIM.setCodigoPais(codigoPais);
          if(!codigoPeriodo.equals("") )
        	  dtoIM.setCodigoPeriodo(codigoPeriodo);
          if(!oidPeriodo.equals("") )
        	  dtoIM.setOidPeriodo(new Long(oidPeriodo));
          if(!fechaProceso.equals("") )
        	  dtoIM.setFechaProceso(new java.sql.Date(stringAFecha(fechaProceso).getTime()));
          if(indPeriodoSiguiente.equals("S"))
        	  dtoIM.setOidPeriodoSiguiente(periodoSiguiente.equals("") ? null : new Long(periodoSiguiente));

          conectarProcesarSolicitudes(dtoIM);

      } else if (mAccion.equals("facturar") || mAccion.equals("preFacturar")) {
          pagina("salidaGenerica");
    			String lista = conectorParametroLimpia( "hCrearGP4", "", true );
    			String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );
    			String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );
    			String fechaFact = conectorParametroLimpia( "hFechaFact", "", true );

          DTOInfoMonitor dtoIM = armarDTOInfo(fechaIni, fechaFin, lista, ConstantesPED.GP4);
          dtoIM.setFechaFacturacion(new java.sql.Date(stringAFecha(fechaFact).getTime()));
          if (mAccion.equals("preFacturar"))
              dtoIM.setIndPreFacturacion(new Boolean(true));
          else    
              dtoIM.setIndPreFacturacion(new Boolean(false));
          
          // sapaza -- PER-SiCC-2011-0079 -- 15/02/2011
          String codigoPais = conectorParametroLimpia( "hCodigoPais", "", true );
		  String codigoPeriodo = conectorParametroLimpia( "hCodigoPeriodo", "", true );
		  String oidPeriodo = conectorParametroLimpia( "hOidPeriodo", "", true );
		  String fechaProceso = conectorParametroLimpia( "hFechaProceso", "", true );
          String periodoSiguiente = conectorParametroLimpia( "hOidPeriodoSiguiente", "", true );
          String indPeriodoSiguiente = conectorParametroLimpia( "hIndPeriodoSiguiente", "N", true );                  
		  
          if(!codigoPais.equals("") )
        	  dtoIM.setCodigoPais(codigoPais);
          if(!codigoPeriodo.equals("") )
        	  dtoIM.setCodigoPeriodo(codigoPeriodo);
          if(!oidPeriodo.equals("") )
        	  dtoIM.setOidPeriodo(new Long(oidPeriodo));
          if(!fechaProceso.equals("") )
        	  dtoIM.setFechaProceso(new java.sql.Date(stringAFecha(fechaProceso).getTime()));
          if(indPeriodoSiguiente.equals("S"))
        	  dtoIM.setOidPeriodoSiguiente(periodoSiguiente.equals("") ? null : new Long(periodoSiguiente));
          
          conectarProcesarSolicitudes(dtoIM);

      } else if (mAccion.equals("gestionStock")) {
          pagina("salidaGenerica");
    			String lista = conectorParametroLimpia( "hCrearGP3", "", true );
    			String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );
    			String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );
          String indTipif = conectorParametroLimpia("hIndTipif", "", true);

          
          DTOInfoMonitor dtoIM = armarDTOInfo(fechaIni, fechaFin, lista, ConstantesPED.GP3);
          dtoIM.setIndTipificacion(indTipif.equalsIgnoreCase("s") ? new Boolean(true) : new Boolean(false));

          // sapaza -- PER-SiCC-2011-0079 -- 15/02/2011
          String codigoPais = conectorParametroLimpia( "hCodigoPais", "", true );
		  String codigoPeriodo = conectorParametroLimpia( "hCodigoPeriodo", "", true );
		  String oidPeriodo = conectorParametroLimpia( "hOidPeriodo", "", true );
		  String fechaProceso = conectorParametroLimpia( "hFechaProceso", "", true );
          String periodoSiguiente = conectorParametroLimpia( "hOidPeriodoSiguiente", "", true );
          String indPeriodoSiguiente = conectorParametroLimpia( "hIndPeriodoSiguiente", "N", true );                  
		  
          if(!codigoPais.equals("") )
        	  dtoIM.setCodigoPais(codigoPais);
          if(!codigoPeriodo.equals("") )
        	  dtoIM.setCodigoPeriodo(codigoPeriodo);
          if(!oidPeriodo.equals("") )
        	  dtoIM.setOidPeriodo(new Long(oidPeriodo));
          if(!fechaProceso.equals("") )
        	  dtoIM.setFechaProceso(new java.sql.Date(stringAFecha(fechaProceso).getTime()));
          if(indPeriodoSiguiente.equals("S"))
        	  dtoIM.setOidPeriodoSiguiente(periodoSiguiente.equals("") ? null : new Long(periodoSiguiente));
          
          conectarProcesarSolicitudes(dtoIM);

      } 
	  //	Agregado por HRCS - Fecha 24/07/2007 - Cambio Sicc20070303
	  else if (mAccion.equals("revertirSolicitudesServicio")) {
          
			pagina("salidaGenerica");
    		String fechaIni = conectorParametroLimpia( "hFechaIni", "", true );

			DTOInfoMonitor dtoIM = new DTOInfoMonitor();
			dtoIM.setFechaInicio(new java.sql.Date(stringAFecha(fechaIni).getTime()));
			dtoIM.setOidIdioma( UtilidadesSession.getIdioma(this) );
			dtoIM.setOidPais( UtilidadesSession.getPais(this) );
          
			MareBusinessID bizId = new MareBusinessID("PEDReversarSolicitudesServicioMonitor");
	        Vector params = new Vector();
	        params.addElement(dtoIM);
			params.addElement(bizId);
	        traza( "Antes conector, reversion: " + dtoIM);
			DruidaConector dc = conectar( "ConectorRevertirProcesos", params );
			traza("el conector, retorno: " + dc);
      }

	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

		  this.lanzarPaginaError(ex);
		  
		  if (mAccion.equals("facturar") || mAccion.equals("preFacturar"))
			  asignarAtributo("VAR", "ejecutarError", "valor", "habilitarBotonFacturar();");
		  if (mAccion.equals("gestionStock"))
			  asignarAtributo("VAR", "ejecutarError", "valor", "habilitarBotonGestionStocks();");
			
	  }

		  //getConfiguracionMenu();

	}
  

  private String convertirRecordSetAString(RecordSet r){
      try{
          StringBuffer s = new StringBuffer();
          for (int i = 0; i<r.getRowCount();i++){
              for (int j = 0 ; j < r.getColumnCount(); j++){
                  if (r.getValueAt(i,j)!=null){
                      traza(r.getValueAt(i,j));
                      s.append(r.getValueAt(i,j));
                  }else{
                      s.append("");
                  }
                  if (j !=  (r.getColumnCount()-1)){
                      s.append("####");
                  }
              }
              if (i !=  (r.getRowCount()-1)){
                  s.append("%%%%");
              }
          }
          return s.toString();
      }catch (Exception e){
          e.printStackTrace();
      }
      return "";
  }


  private void conectarProcesarSolicitudes(DTOInfoMonitor dtoIM) throws Exception {
      //Llamamos al ConectorProcesarSolicitudes con el idBusiness "PEDProcesarSolicitudes" 
      //con el dto DTOParametrosMonitor 
      MareBusinessID bizId = new MareBusinessID("PEDProcesarSolicitudes");

	  //jrivas 9/12/2005 Faltaba pasarle el Pais
	  dtoIM.setOidPais(UtilidadesSession.getPais(this));

	  //vbongiov 2/03/2006 inc 22675
	  dtoIM.setOidIdioma(UtilidadesSession.getIdioma(this));

      Vector params = new Vector();
      params.addElement( dtoIM );     
      params.addElement( bizId );

      traza( "Antes conector: " + dtoIM);
      DruidaConector dc  =	conectar( "ConectorProcesarSolicitudes" , params );
      traza( "dc "); 
  }

  private DTOInfoMonitor armarDTOInfo(String fechaIni, String fechaFin, String lista, Long gp) throws Exception {

        DTOInfoMonitor dtoIM = new DTOInfoMonitor();
        dtoIM.setFechaInicio(new java.sql.Date(stringAFecha(fechaIni).getTime()));
        if (fechaFin.equals("")) {
            dtoIM.setFechaFin(dtoIM.getFechaInicio());
        } else {
            dtoIM.setFechaFin(new java.sql.Date(stringAFecha(fechaFin).getTime()));
        }
        dtoIM.setGP(gp);

        ArrayList vSol = new ArrayList();
        traza("Lista: "+lista);
        if (!lista.equals("")) {
            do {
                int pos = lista.indexOf("|#|");
                String sElem = lista.substring(0,pos);

                StringTokenizer stkElem = new StringTokenizer(sElem,"|");
                DTOSecuenciaSolicitudes dtoSS = new DTOSecuenciaSolicitudes();
                String sOidTipoSol = (String) stkElem.nextToken();
                dtoSS.setOidTipoSolicitud(new Long(sOidTipoSol));
                String sZona = (String) stkElem.nextToken();
                dtoSS.setOidZona(new Long(sZona));
                String sSecuen = (String) stkElem.nextToken();
                dtoSS.setSecuencia(new Long(sSecuen));

                lista = lista.substring(pos+3);
                vSol.add(dtoSS);
            } while (!lista.equals(""));
        }          

        dtoIM.setSecuencia(vSol);

        return dtoIM;
    
  }

  private void cargaInicialMonitor() throws Exception {
      traza("Inicio cargaInicialMonitor");
      DTOBelcorp dtoBel = new DTOBelcorp();
      dtoBel.setOidPais(UtilidadesSession.getPais(this));
      dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));

      MareBusinessID bizId = new MareBusinessID("PEDCargaInicialMonitor");

      Vector params = new Vector();
      params.addElement( dtoBel );
      params.addElement( bizId );

      traza( "Antes conector: " + dtoBel);
      DruidaConector dc  =	conectar( "ConectorCargaInicialMonitor" , params );
      traza( "dc ");

      DTOCargaInicialMonitor dtoS = (DTOCargaInicialMonitor) dc.objeto("dtoSalida");
          
      boolean usaPlant = false;
      if (dtoS.getUsaPlantillas() != null && dtoS.getUsaPlantillas().booleanValue()) {
          cargaComboPlantilla(dtoS.getPlantillas());
          usaPlant = true;
		  traza("utilizo plantillas!!");
      } else {
          //ocultamos el combo "plantilla" de la pantalla 
          //Deshabilitamos el botón guardar 
          //asignarAtributo("COMBO", "cbCodigoPlantilla", "visibilidad", "hidden");		
		  traza("NO utilizo plantillas!!");                
      }
	  traza( "dtoS.getUsaPlantillas(): " + dtoS.getUsaPlantillas());
	  traza( "Antes conector: " + dtoBel);
      cargaInicialCombos();

	  traza( "usaPlant(): " + usaPlant);
      asignarAtributo( "VAR", "hUsaPlantillas", "valor", usaPlant + "");    
    
      // sapaza -- PER-SiCC-2011-0079 -- 15/02/2011
      if(dtoS.getCodigoPais()!=null)
    	  asignarAtributo( "VAR", "hCodigoPais", "valor", dtoS.getCodigoPais());
      if(dtoS.getCodigoPeriodo()!=null)
    	  asignarAtributo( "VAR", "hCodigoPeriodo", "valor", dtoS.getCodigoPeriodo());
      if(dtoS.getOidPeriodo()!=null)
    	  asignarAtributo( "VAR", "hOidPeriodo", "valor", dtoS.getOidPeriodo().toString());
      if(dtoS.getFechaProceso()!=null) {      
    	  asignarAtributo( "VAR", "hFechaIni", "valor", hoyAString(dtoS.getFechaProceso()));
    	  asignarAtributo( "VAR", "hFechaProceso", "valor", hoyAString(dtoS.getFechaProceso()));
      }
      if(dtoS.getOidPeriodoSiguiente()!=null)
    	  asignarAtributo( "VAR", "hOidPeriodoSiguiente", "valor", dtoS.getOidPeriodoSiguiente().toString());
      if(dtoS.getFechaFinPeriodoSiguiente()!=null) {      
    	  asignarAtributo( "VAR", "hFechaFinPeriodoSiguiente", "valor", hoyAString(dtoS.getFechaFinPeriodoSiguiente()));
      }
      
  }

  private TreeSet generarTreeSet(String sTree) throws Exception {
      traza("Inicio generarTreeSet");
      //Supongo que viene para cada GP de la pantalla:
      //Tipo1 | Region1 | Zona1 | Secuencia1 |#| Tipo1 | Region1 | Zona1 | Secuencia2 ...
      TreeSet ts = new TreeSet();
      if (!sTree.equals("")) {
          do {
              traza("sTree: "+ sTree);
              int pos = sTree.indexOf("|#|");
              String sElem = sTree.substring(0,pos);
              sTree = sTree.substring(pos+3);

              StringTokenizer stkElem = new StringTokenizer(sElem,"|");
              traza("sElem: "+sElem);
              //Armo el DTOElementoPlantilla
              DTOElementoPlantilla dtoEP = new DTOElementoPlantilla();
              dtoEP.setTipoSolicitud(new Long((String) stkElem.nextToken()));
              dtoEP.setRegion(new Long((String) stkElem.nextToken()));
              dtoEP.setZona(new Long((String) stkElem.nextToken()));
              dtoEP.setSecuencia(new Integer((String) stkElem.nextToken()));

              traza("DTOEP: "+ dtoEP);
              ts.add(dtoEP);
              traza("DTOEP despues");

          } while (!sTree.equals(""));

      }

      traza("Fin generarTreeSet");
      return ts;
      
    
  }

  private java.util.Date stringAFecha(String fecha) throws Exception {
      if (fecha.trim().equals(""))
          return null;
      String formato = UtilidadesSession.getFormatoFecha(this);
      int pos = formato.indexOf("mm");
      if ( pos > -1) 
          formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
      SimpleDateFormat sdf = new SimpleDateFormat(formato);

      return sdf.parse(fecha);
      
  }

  private String hoyAString(java.sql.Date fechaProceso) throws Exception {
      String formato = UtilidadesSession.getFormatoFecha(this);
      traza("Formato fecha: "+formato);
      int pos = formato.indexOf("mm");
      if ( pos > -1) 
          formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
      SimpleDateFormat sdf = new SimpleDateFormat(formato);
      String fecha = "";
      
      if(fechaProceso != null)
    	  fecha = sdf.format(fechaProceso);
      else
    	  fecha = sdf.format(new java.util.Date());
      
      traza("Fecha: "+fecha);

      return fecha;
  }

  private void cargaComboPlantilla(RecordSet rs) throws Exception {
        traza("Inicio cargaComboPlantilla");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "resultado");
        rowset2.appendChild(rowset);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "oid"); //En realidad viene el idVista
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(((BigDecimal) rs.getValueAt(i,"OID")).toString());
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "descripcion");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            txt = docDestino.createTextNode((String) rs.getValueAt(i,"DESCRIPCION"));
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

        }

        DruidaConector conectorCb = new DruidaConector();
        conectorCb.setXML(rowset2);
        traza("XML: "+conectorCb.getXML());

        asignar("COMBO", "cbCodigoPlantilla", conectorCb , "resultado");

   
  }


  private DruidaConector generarConector(RecordSet rs) throws Exception {
        traza("Inicio generarConector");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "resultado");
        rowset2.appendChild(rowset);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "Ident");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(i+"");
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            for (int k = 0; k < rs.getColumnCount(); k++) {
                elemDato = docDestino.createElement("CAMPO");
                elemDato.setAttribute("NOMBRE", rs.getColumnName(k));
                elemDato.setAttribute("TIPO", "STRING");
                elemDato.setAttribute("LONGITUD", "50");
                String dato = rs.getValueAt(i, k) == null ? "" : rs.getValueAt(i, k).toString();
                txt = docDestino.createTextNode(dato);
                elemDato.appendChild(txt);
                elemRow.appendChild(elemDato);
                
            }

        }

        DruidaConector conectorLista = new DruidaConector();
        conectorLista.setXML(rowset2);

        return conectorLista;
  }
  

  	private void cargaInicialCombos() throws Exception{

        ComposerViewElementList cvList = crearParametrosEntrada();

        ConectorComposerView conector = new ConectorComposerView(cvList,
                this.getRequest());
        conector.ejecucion();

        DruidaConector resultados = conector.getConector();

        //cargamos los combos con los resultados 
        //asignar("COMBO", "cbCodigoPlantilla", resultados, "PEDCargaInicialMonitor");
        asignar("COMBO", "cbTipoSolicitud", resultados, "PEDobtieneTiposSolicitudPorPais");
        asignar("COMBO", "cbAcceso", resultados, "SEGRecuperaAccesos");
        asignar("COMBO", "cbRegion", resultados, "ZONObtenerRegionesPorPais"); //incidencia SiCC-20070172

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception {
      	DTOBelcorp dtoBel = new DTOBelcorp();
      	dtoBel.setOidPais(UtilidadesSession.getPais(this));
      	dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
    
      
      	ComposerViewElementList lista = new ComposerViewElementList();
	  	//Primer combo
        /*ComposerViewElement ci1 = new ComposerViewElement();
      	ci1.setIDBusiness("PEDCargaInicialMonitor");
      	ci1.setDTOE(dtoBel);
      	ci1.setPosOID((byte)0);
      	ci1.setPosDesc((byte)1);

      	lista.addViewElement(ci1);*/
      	
        //combo tipo sol pais
        ComposerViewElement cmb1 = new ComposerViewElement();
        cmb1.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
        cmb1.setDTOE(dtoBel);

        //combo acceso
        ComposerViewElement cmb2 = new ComposerViewElement();
        cmb2.setIDBusiness("SEGRecuperaAccesos");
        cmb2.setDTOE(dtoBel);

		//<inicio>Obtiene las regiones del pais al cual pertenece el usuario logueado, incidencia SiCC-20070172
        //combo regiones
        DTOOID dto = new DTOOID();
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
        dto.setOidPais(UtilidadesSession.getPais(this));
        dto.setOid(null);
        
        ComposerViewElement cmb3 = new ComposerViewElement();
        cmb3.setIDBusiness("ZONObtenerRegionesPorPais");
        cmb3.setDTOE(dto);
        //<fin>incidencia SiCC-20070172

        lista.addViewElement(cmb1);
        lista.addViewElement(cmb2);
        lista.addViewElement(cmb3); //incidencia SiCC-20070172

        return lista;
	}


	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException)
		{
			
			MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
	}


	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}


	private ArrayList obtenerTiposSolicitud(String oidsTiposSolicitud) throws Exception {
		StringTokenizer oidsTiposSolicitudTk = new StringTokenizer(oidsTiposSolicitud,",");
		ArrayList tiposSolicitud = new ArrayList();
		while (oidsTiposSolicitudTk.hasMoreTokens()) {
			Long oidTipoSolicitud = new Long(oidsTiposSolicitudTk.nextToken());
			tiposSolicitud.add(oidTipoSolicitud);
		}
		return tiposSolicitud;
	}

	//<inicio>Recupera las regiones y zonas, incidencia SiCC-20070172
	private ArrayList obtenerRegiones(String oidsRegiones) throws Exception {
		StringTokenizer oidsRegionesTk = new StringTokenizer(oidsRegiones,",");
		ArrayList regiones = new ArrayList();
    
		while (oidsRegionesTk.hasMoreTokens()) {
			Long oidRegion = new Long(oidsRegionesTk.nextToken());
			regiones.add(oidRegion);
		}
		return regiones;
	}

	private ArrayList obtenerZonas(String oidsZonas) throws Exception {
		StringTokenizer oidsZonasTk = new StringTokenizer(oidsZonas,",");
		ArrayList zonas = new ArrayList();

		while (oidsZonasTk.hasMoreTokens()) {
			Long oidZona = new Long(oidsZonasTk.nextToken());
			zonas.add(oidZona);
		}
		return zonas;
	}
	//<fin>incidencia SiCC-20070172

}
