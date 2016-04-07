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

import es.indra.druida.DruidaBase;
import es.indra.druida.DruidaConector;
import es.indra.druida.dom.DruidaDOMObjeto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.IBelcorpError;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTODate;

import es.indra.sicc.dtos.cra.ConstantesCRA;
import es.indra.sicc.dtos.cra.DTOActividadGrupo;
import es.indra.sicc.dtos.cra.DTOBuscarActividadOrigen;
import es.indra.sicc.dtos.cra.DTOCalcularFechaPrevista;
import es.indra.sicc.dtos.cra.DTOCronograma;
import es.indra.sicc.dtos.cra.DTOGrupoCronograma;
import es.indra.sicc.dtos.cra.DTODiasFacturacion;
import es.indra.sicc.dtos.cra.DTOGrupoZonas;
import es.indra.sicc.dtos.cra.DTONuevasActividadesCronograma;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.cra.util.TADCronograma;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.sql.Date;

import java.text.SimpleDateFormat;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import es.indra.sicc.util.xml.XMLDocument;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


/**
 * Sistema:           Belcorp
 * Modulo:            CRA
 * Submódulo:      Cronograma
 * Componente:    LPMantieneCronograma 
 * Fecha:             02/06/2004
 * Observaciones:     
 * @version        1.0
 * @autor           Luis Ramos
 */

public class LPMantieneCronograma extends LPUtilidadesCronograma {
  private static String sesionCrono = "craCronograma";
  private static String sesionActivs = "craCronoActivs";
  String accion = "";
  String marca = null;
  String canal = null;
  String codPeriodo = null;

	public LPMantieneCronograma() {
		super();
	}

	public void inicio() throws Exception {
		pagina("contenido_cronograma1_generar");
	}

	public void ejecucion() throws Exception {

    setTrazaFichero();
	  rastreo();

	  try{

        accion = conectorParametroLimpia( "accion", "", true );
        marca = conectorParametroLimpia( "hMarca", "", true );
        canal = conectorParametroLimpia( "hCanal", "", true );
        codPeriodo = conectorParametroLimpia( "hCodPeriodo", "", true );

        traza("ACCION: "+accion);
        //1.- Capta el cronograma de sesión:  
        traza("conectorParametroSesion(sesionCrono): " + conectorParametroSesion(sesionCrono));
        if (conectorParametroSesion(sesionCrono) == null) {
            tadCronograma = null;
        } else {
            //VER: QUIZAS HAYA QUE GUARDAR TODO EL TADCRONOGRAMA ENTONCES,
            //(TADCronograma)conectorParametroSesion(sesionCrono);
            //tadCronograma = new TADCronograma((DTOCronograma) conectorParametroSesion(sesionCrono));  
            tadCronograma = (TADCronograma)conectorParametroSesion(sesionCrono);
            traza("TAD session: "+tadCronograma.getCronograma());
            traza("con ipCliente: "+tadCronograma.getCronograma().getIpCliente());
            traza("con programa: "+tadCronograma.getCronograma().getPrograma());
        }

        /** 2.- Establece los componentes gráficos sobre los que se representa el cronograma: **/
        componenteGrafico = "rejCronograma";
        listaFueraPeriodo = "lstFueraPeriodo";
        i18NtituloGrupoZona = "hLblGrupoZona";
        i18NtituloZona = "hLblZona";
        ocultoDiasSemana = "hVecDiasSemana";
        ocultoMeses = "hVecMeses";

  			lblFija = conectorParametroLimpia( "hlblActiFija", "", true );
    		lblReferencia = conectorParametroLimpia( "hlblActiRefe", "", true );
        traza("lblFija: "+lblFija+"          lblRefe: "+lblReferencia);

  		  getConfiguracionMenu();

        if (accion.equals("muestraCronogramaFase1")) {
            muestra(false, "contenido_cronograma1_generar"); 
        } else if (accion.equals("muestraCronogramaFase2"))  {
            muestra(true, "contenido_cronograma1_generar"); 
        } else if (accion.equals("muestraModificaCronograma"))  {
            esManteCrono = true;
            muestra(true, "contenido_cronograma_modificar"); 
        } else if (accion.equals("muestraConsultaCronograma"))  {
            esManteCrono = true;
            esConsCrono = true;
            muestra(true, "contenido_cronograma_modificar"); 
        } else if (accion.equals("existeFase")) {
            existe(); 
        } else if (accion.equals("generaFase1")) {
            genera(); 
        } else if (accion.equals("obtieneTiposFacturacion")) {
            if (tadCronograma.esZonas()) 
                genera();
            else
                obtieneTiposFacturacion();
        } else if (accion.equals("guardaCronograma")) {
            guarda();
        } else if (accion.equals("guardarFechaActividad")) {
            guardaFecha();
        } else if (accion.equals("modificaFechaActividad")) {
            //modificaFecha(id vista actividad seleccionada); 
            modificaFecha(conectorParametroLimpia( "hIdVista", "", true ));
        } else if (accion.equals("aceptaModificarFija")) {
            aceptaModificarFecha(); 
        } else if (accion.equals("obtieneCronograma")) {
            esManteCrono = true;
            obtieneCronograma(); 
        } else if (accion.equals("insertaActividad")) {
            insertaActividad(); 
        } else if (accion.equals("guardarActividad")) {
            esManteCrono = true;
            guardaActividad(); 
        } else if (accion.equals("confirmaCronograma")) {
            //confirmaCronograma(); 
        } else if (accion.equals("eliminarCronograma")) {
            eliminaCronograma();
        } else if (accion.equals("confirmaActividadCronograma")) {
            confirmaActividad(); 
        } else if (accion.equals("eliminarActividad")) {
            eliminaActividad(); 
        } else if (accion.equals("eliminaTareas")) {
            esManteCrono = true;
            eliminaTareas();
        } else if (accion.equals("obtenerInfoActividad")) {
			obtenerInfoActividad();
        }
        

	  }catch (Exception ex){
			   
		  logStackTrace(ex); 

      traza("################# SE PRODUJO UNA EXCEPTION #################");
      ByteArrayOutputStream pila = new ByteArrayOutputStream();
      PrintStream out = new PrintStream(pila);
      ex.printStackTrace(out);
      traza("EL STACK ES COMO SIGUE : " + pila.toString());

		  this.lanzarPaginaError(ex);
			
	  }


	}

  /** Muestra la pantalla pasada por parámetro rellenando los combos de marcas y canales, 
   * y poniendo la etiqueta del país de sesión. **/
  private void muestra (boolean esFase2, String pantalla) throws Exception {
  		pagina(pantalla);

      getConfiguracionMenu("LPMantieneCronograma","muestraCronogramaFase1");                    
      cargaInicialCombos();
      asignarAtributo( "LABELC", "lblCodPais", "valor", UtilidadesSession.getDescripcionPais(this));
      asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
      asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());

      DTOCronograma dtoE = new DTOCronograma();
      dtoE.setOidPais(UtilidadesSession.getPais(this));
      dtoE.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoE.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoE.setPrograma("LPMantieneCronograma");

      tadCronograma = new TADCronograma(dtoE, esFase2); 
      conectorParametroSesion(sesionCrono, tadCronograma);

      traza("Caso de Uso: "+conectorParametroLimpia( "casoDeUso", "", true ));
      if (esFase2)
         asignarAtributo( "VAR", "casoDeUso", "valor", "Fase 2");    
      if (esManteCrono)
          asignarAtributo("CAPA", "capaTablas", "visibilidad", "hidden");		
      if (esConsCrono) {
         getConfiguracionMenu("LPMantieneCronograma","consultaCronograma");                    
         asignarAtributo( "VAR", "casoDeUso", "valor", "consulta");    
         if (conectorParametroLimpia( "casoDeUso", "", true ).equals("eliminaCronograma")) {
            getConfiguracionMenu("LPMantieneCronograma","eliminaCronograma");                    
            asignarAtributo( "VAR", "casoDeUso", "valor", "eliminaCronograma");    
         }
      }
    

  }

  /** Verifica si existe ya un canal para la marca, canal el codigo de periodo y el pais, 
   * en ese caso habrá que mostrar un mensaje de confirmación. Si el usuario pulsa "Sí", 
   * o si no existía ningún cronograma se pasa a obtener los tipos de facturación de los 
   * grupos implicados del pais, marca y canal.  **/
  private void existe() throws Exception {
      traza("grabando Datos nuevo1");
      pagina("salidaGenerica");
  		//pagina("contenido_cronograma1_generar");

      /** Agregado porque si se presiona nuevamente el boton generar no limpia el cronograma **/
      DTOCronograma dtoC = new DTOCronograma();
      dtoC.setOidPais(UtilidadesSession.getPais(this));
      dtoC.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoC.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoC.setPrograma("LPMantieneCronograma");

      tadCronograma = new TADCronograma(dtoC, tadCronograma.esZonas()); 
      conectorParametroSesion(sesionCrono, tadCronograma);
      /** Fin Agregado **/
      
      DTOCronograma dtoE = tadCronograma.getCronograma(); 
      dtoE.setMarca(new Long(marca));
      dtoE.setCanal(new Long(canal));
      dtoE.setCodigoPeriodo(codPeriodo);

      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAExisteCronograma");
      
      paramEntrada.add(dtoE);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorExisteCronograma: "+dtoE);
      traza("Pais del dto: "+dtoE.getOidPais());
      DruidaConector conectorExiste;
      try {
          conectorExiste = this.conectar( "ConectorExisteCronograma", paramEntrada );
      } catch (Exception ex) {
          traza("SE PRODUJO EXCEPTION AL usar CRAExisteCronograma");
          asignarAtributo( "VAR", "ejecutarError", "valor", "errorExiste()");
          throw ex;
      }
      traza("CONECTO ConectorExisteCronograma: ");

      traza("Se obtuvo dto"+conectorExiste.objeto("dtoSalida"));
      DTOBoolean dtoB = (DTOBoolean) conectorExiste.objeto("dtoSalida");

       if (dtoB.getValor())
           asignarAtributo( "VAR", "ejecutar", "valor", "vueltaGenerica('1')");
       else
           asignarAtributo( "VAR", "ejecutar", "valor", "vueltaGenerica('0')");
       asignarAtributo( "VAR", "cerrar", "valor", "false");

  }

  /** Genera el cronograma y lo muestra en la pantalla PantallaGenerarCronogramaFase1. **/
  private void genera() throws Exception {
      traza("ENTRO A GENERA");
      cargaInicialCombos();
      asignarAtributo( "LABELC", "lblCodPais", "valor", UtilidadesSession.getDescripcionPais(this));
      asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
      asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
      asignarAtributo( "VAR", "hMarca", "valor", marca);
      asignarAtributo( "VAR", "hCanal", "valor", canal);
      asignarAtributo( "VAR", "hCodPeriodo", "valor", codPeriodo);
      asignarAtributo( "VAR", ocultoDiasSemana, "valor", conectorParametroLimpia( ocultoDiasSemana, "", true ));
      asignarAtributo( "VAR", ocultoMeses, "valor", conectorParametroLimpia( ocultoMeses, "", true ));

    // -1-
      DTOCronograma dtoEntrada = tadCronograma.getCronograma(); 
      
      
      
      //se comenta por inc 17371
      //String varGrupos = conectorParametroLimpia("hVarGrupos", "", true );
      //traza("varGrupos: "+varGrupos);
      
      //INCIDENCIA 5872
      Vector vDiasF = new Vector();
      
      //Lo siguiente se comenta por inc. 17371----------------------------------
      /*
      if (!varGrupos.equals("")) {
          //StringTokenizer stkGrupos = new StringTokenizer(varGrupos,"|#|");
          do {
              int pos = varGrupos.indexOf("|#|");
              String sElem = varGrupos.substring(0,pos);

              StringTokenizer stkElem = new StringTokenizer(sElem,"|");
              traza("sElem: "+sElem+"      cant: "+stkElem.countTokens());
              //Armo el DTODiasFacturacion
              DTODiasFacturacion dtoDia = new DTODiasFacturacion();
              //oidGrupo
              String sOidGrupo = (String) stkElem.nextToken();
              dtoDia.setOid(new Long(sOidGrupo.trim()));
              //txtGrupo
              String sDato = (String) stkElem.nextToken();
              //tipoFacturacion
              sDato = (String) stkElem.nextToken();
              //Nota: se elimina el $ utilizado para que el Tokenizer devuelve siempre 5 elementos
              //ndff
              String ndff = ((String) stkElem.nextToken()).substring(1).trim();
              if (!ndff.equals(""))
                  dtoDia.setNdff(new Integer(ndff)); 
              //ndm
              String ndm = (String) stkElem.nextToken().substring(1).trim();
              if (!ndm.equals(""))
                  dtoDia.setNdm(new Integer(ndm));

              vDiasF.add(dtoDia);

              varGrupos = varGrupos.substring(pos+3);
          } while (!varGrupos.equals(""));
      }
      */
      //Fin comentado por inc. 17371--------------------------------------------
      
      traza("VDiasF: "+vDiasF);
      dtoEntrada.setDiasFacturacion(vDiasF);



      getConfiguracionMenu("LPMantieneCronograma","generaFase1");                    
      
      // -2-
      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAGeneraCronograma");
      
      paramEntrada.add(dtoEntrada);
      paramEntrada.add(id);

    // -3-
      traza("ANTES DE CONECTAR ConectorGeneraCronograma: "+dtoEntrada);
      DruidaConector conectorFact = this.conectar( "ConectorGeneraCronograma", paramEntrada );
      traza("CONECTO ConectorGeneraCronograma: ");

    // -4-
      DTOCronograma dtoS = (DTOCronograma) conectorFact.objeto("dtoSalida");
      traza("CRONOGRAMA GENERADO: "+dtoS);
      
    // -5-
      tadCronograma = new TADCronograma(dtoS);
      
    // -6-
      conectorParametroSesion(sesionCrono, tadCronograma);

    // -7-
      vistaCronograma();

      //getFormatosValidaciones();
      
  }

  /** Obtiene todos los tipos de facturaciones de cada grupo del cronograma para ir mostrando 
   * pantallas para rellenar los datos de cada tipo de facturación. **/
  private void obtieneTiposFacturacion() throws Exception {
      //Están los ocultos aca por si da error la comprobación de la facturación
      cargaInicialCombos();
      asignarAtributo( "VAR", "hIndGrupo", "valor", "0");
      asignarAtributo( "VAR", "hMarca", "valor", marca);
      asignarAtributo( "VAR", "hCanal", "valor", canal);
      asignarAtributo( "VAR", "hCodPeriodo", "valor", codPeriodo);
      asignarAtributo( "VAR", ocultoDiasSemana, "valor", conectorParametroLimpia( ocultoDiasSemana, "", true ));
      asignarAtributo( "VAR", ocultoMeses, "valor", conectorParametroLimpia( ocultoMeses, "", true ));

      DTOCronograma dtoEntrada = tadCronograma.getCronograma(); 

      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRACompruebaFacturacion");
      
      paramEntrada.add(dtoEntrada);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorCompruebaFacturacion: "+dtoEntrada);
      traza("Pais del dto: "+dtoEntrada.getOidPais());
      DruidaConector conectorFact = this.conectar( "ConectorCompruebaFacturacion", paramEntrada );
      traza("CONECTO ConectorCompruebaFacturacion: ");

      //Si da error se debería quedar en la pantalla de Generar
      //sino llega acá, cambia de pagina y vuelve a cargar los ocultos
  		pagina("contenido_cronograma_facturacion");
      asignarAtributo( "VAR", "hIndGrupo", "valor", "0");
      asignarAtributo( "VAR", "hMarca", "valor", marca);
      asignarAtributo( "VAR", "hCanal", "valor", canal);
      asignarAtributo( "VAR", "hCodPeriodo", "valor", codPeriodo);
      asignarAtributo( "VAR", ocultoDiasSemana, "valor", conectorParametroLimpia( ocultoDiasSemana, "", true ));
      asignarAtributo( "VAR", ocultoMeses, "valor", conectorParametroLimpia( ocultoMeses, "", true ));

      traza("Se obtuvo dto"+conectorFact.objeto("dtoSalida"));
      DTOCronograma dtoS = (DTOCronograma) conectorFact.objeto("dtoSalida");
      tadCronograma = new TADCronograma(dtoS);
      conectorParametroSesion(sesionCrono, tadCronograma);
      crearArrayTipos(dtoS);

      getConfiguracionMenu("LPMantieneCronograma","obtieneTiposFacturacion");                    
      
  }

  /** Muestra la pantalla de modificación de la fecha de una actividad cuyo identificador de vista es el indicado 
   * por el parámetro idVista del cronograma, mostrando previamente un mensaje de confirmación por si la actividad fuera fija. **/
  private void modificaFecha(String idVista) throws Exception {
      traza("Inicio modificaFecha");
      pagina("salidaGenerica");
      traza("IdVista: "+idVista);
      DTOActividadGrupo actividad = tadCronograma.obtieneActividadGrupo(new Integer(idVista)); 
      traza("Actividad: "+actividad);
      if (actividad.getIndFija() != null && actividad.getIndFija().booleanValue()) {
          asignarAtributo( "VAR", "ejecutar", "valor", "aceptaModificaFecha('1',"+idVista+")");
      } else {
          asignarAtributo( "VAR", "ejecutar", "valor", "aceptaModificaFecha('0',"+idVista+")");
      }

  }

  /** Muestra la pantalla de modificación de la fecha de una actividad cuyo identificador de vista es 
   * el indicado por el parámetro idVista del cronograma.  **/
  private void aceptaModificarFecha() throws Exception {
      traza("Inicio aceptaModificaFecha");
      pagina("contenido_cronograma_fecha_modificar_1");
      Integer idVista = new Integer(conectorParametroLimpia( "hIdVista", "", true ));
      DTOActividadGrupo actividad = tadCronograma.obtieneActividadGrupo(idVista); 
      traza("Actividad: "+actividad);
      actividad.setIndFija(new Boolean(false));
      //DTOGrupoCronograma dtoG = tadCronograma.obtieneGrupo(actividad.getGrupo());
      String formato = UtilidadesSession.getFormatoFecha(this);
      int pos = formato.indexOf("mm");
      if ( pos > 0) 
          formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);
      SimpleDateFormat sdf = new SimpleDateFormat(formato);
      String fecha = sdf.format(actividad.getFechaPrevista());
      traza("FEcha: "+fecha);

      asignarAtributo( "VAR", "hActividad", "valor", actividad.getIdVista().toString());
      asignarAtributo( "VAR", "hGrupo", "valor", actividad.getGrupo().toString());
      asignarAtributo( "VAR", "hTextoActividad", "valor", actividad.getTextoActividad());
      traza("Formato fecha: "+UtilidadesSession.getFormatoFecha(this));
      if (tadCronograma.esZonas()) {
          SimpleDateFormat sdfHora = new SimpleDateFormat("HH:mm:ss");
          asignarAtributo( "CTEXTO", "txtFecha3", "valor", fecha);
          traza("Hora: "+sdfHora.format(actividad.getFechaPrevista()));
          asignarAtributo( "CTEXTO", "txtHora", "valor", sdfHora.format(actividad.getFechaPrevista()));
          asignarAtributo("CAPA", "capaBusqueda2", "visibilidad", "");			
          asignarAtributo("CAPA", "capaBusqueda", "visibilidad", "hidden");			
      } else {
          asignarAtributo( "LABELC", "lblFechaxx", "valor", fecha);
          asignarAtributo( "CTEXTO", "txtDiasDeDesplazamiento", "valor", actividad.getFecha0().toString());
          asignarAtributo("CAPA", "capaBusqueda2", "visibilidad", "hidden");			
          asignarAtributo("CAPA", "capaBusqueda", "visibilidad", "");			
      }      
      asignarAtributo( "VAR", "hMarca", "valor", marca);
      asignarAtributo( "VAR", "hCanal", "valor", canal);
      asignarAtributo( "VAR", "hCodPeriodo", "valor", codPeriodo);
      asignarAtributo( "VAR", ocultoDiasSemana, "valor", conectorParametroLimpia( ocultoDiasSemana, "", true ));
      asignarAtributo( "VAR", ocultoMeses, "valor", conectorParametroLimpia( ocultoMeses, "", true ));
      asignarAtributo( "VAR", "hFormatoFechaPais", "valor", UtilidadesSession.getFormatoFecha(this));
      //Variables de Modifica Cronograma
      asignarAtributo( "VAR", "hCbPais", "valor", conectorParametroLimpia("hCbPais", "", true ));
      asignarAtributo( "VAR", "hGrupoZona", "valor", conectorParametroLimpia("hGrupoZona", "", true ));
      asignarAtributo( "VAR", "hSubgerencia", "valor", conectorParametroLimpia("hSubgerencia", "", true ));
      asignarAtributo( "VAR", "hRegion", "valor", conectorParametroLimpia("hRegion", "", true ));
      asignarAtributo( "VAR", "hZona", "valor", conectorParametroLimpia("hZona", "", true ));
      asignarAtributo( "VAR", "casoDeUso", "valor", conectorParametroLimpia("casoDeUso", "", true ));    
      asignarAtributo( "VAR", "hChangePaisMC", "valor", conectorParametroLimpia("hChangePaisMC", "", true ));
      asignarAtributo( "VAR", "hChangeMarcaMC", "valor", conectorParametroLimpia("hChangeMarcaMC", "", true ));
      asignarAtributo( "VAR", "hChangeCanalMC", "valor", conectorParametroLimpia("hChangeCanalMC", "", true ));
      asignarAtributo( "VAR", "hChangeGrupo", "valor", conectorParametroLimpia("hChangeGrupo", "", true ));
      asignarAtributo( "VAR", "hChangeSub", "valor", conectorParametroLimpia("hChangeSub", "", true ));
      asignarAtributo( "VAR", "hChangeRegion", "valor", conectorParametroLimpia("hChangeRegion", "", true ));

      //getFormatosValidaciones();
      
      getConfiguracionMenu("LPMantieneCronograma","aceptaModificarFija");                    
      traza("Fin aceptaModificaFecha");
      
  }

  /** Guarda el nuevo desplazamiento de una actividad en el cronograma. **/
  private void guardaFecha() throws Exception {
      traza("Inicio guardaFecha()");
      if (conectorParametroLimpia("casoDeUso", "", true ).equals("ModificaCronograma")) {
          esManteCrono = true;
          pagina("contenido_cronograma_modificar");
      }
      cargaInicialCombos();
      Long grupo = new Long(conectorParametroLimpia( "hGrupo", "", true ));
      traza("grupo: "+grupo);
      Integer actividad = new Integer(conectorParametroLimpia( "hActividad", "", true ));
      traza("actividad: "+actividad);
      if (tadCronograma.esZonas()) {
          String formato = UtilidadesSession.getFormatoFecha(this) + " hh:mm:ss";
          int pos = formato.indexOf("mm");
          if ( pos > 0) 
              formato = formato.substring(0, pos) + "MM" + formato.substring(pos+2);

          String fecha = conectorParametroLimpia( "hFecha", "", true );
          String hora = conectorParametroLimpia( "hHora", "", true );
          traza("MAD El formato de la fecha es " + formato);
         

          /*StringTokenizer stkOculto = new StringTokenizer(hora,":");
          String sHora = (String) stkOculto.nextToken();
          String sMin = (String) stkOculto.nextToken();
          String sSeg = (String) stkOculto.nextToken();

          Calendar c = new GregorianCalendar();
          c.setTime(dia);
          c.set(Calendar.HOUR_OF_DAY, new Integer(sHora).intValue());
          c.set(Calendar.MINUTE, new Integer(sMin).intValue());
          c.set(Calendar.SECOND, new Integer(sSeg).intValue());*/

		  SimpleDateFormat sdf = new SimpleDateFormat(formato);
          Timestamp dia = new Timestamp( sdf.parse(fecha + " " + hora).getTime());
          
          


 
         //Calendar cRes = new GregorianCalendar();
         //cRes.set(c.get(Calendar.YEAR),c.get(Calendar.MONTH), c.get(Calendar.DATE),
         //    new Integer(sHora).intValue(),new Integer(sMin).intValue(),new Integer(sSeg).intValue());  

          tadCronograma.modificaFechaActividad(grupo, actividad, dia);
      } else {
          Integer diasDesp = new Integer(conectorParametroLimpia( "hDiasDeDesp", "", true ));
          traza("DiasDesp: "+diasDesp);
          tadCronograma.modificaFechaActividad(grupo, actividad, diasDesp);
      }
      conectorParametroSesion(sesionCrono, tadCronograma);
      
      asignarAtributo( "LABELC", "lblCodPais", "valor", UtilidadesSession.getDescripcionPais(this));
      asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
      asignarAtributo( "VAR", "hPais", "valor", UtilidadesSession.getPais(this).toString());
      asignarAtributo( "VAR", "hMarca", "valor", marca);
      asignarAtributo( "VAR", "hCanal", "valor", canal);
      asignarAtributo( "VAR", "hCodPeriodo", "valor", codPeriodo);
      asignarAtributo( "VAR", ocultoDiasSemana, "valor", conectorParametroLimpia( ocultoDiasSemana, "", true ));
      asignarAtributo( "VAR", ocultoMeses, "valor", conectorParametroLimpia( ocultoMeses, "", true ));
      //Variables de Modifica Cronograma
      asignarAtributo( "VAR", "hCbPais", "valor", conectorParametroLimpia("hCbPais", "", true ));
      asignarAtributo( "VAR", "hGrupoZona", "valor", conectorParametroLimpia("hGrupoZona", "", true ));
      asignarAtributo( "VAR", "hSubgerencia", "valor", conectorParametroLimpia("hSubgerencia", "", true ));
      asignarAtributo( "VAR", "hRegion", "valor", conectorParametroLimpia("hRegion", "", true ));
      asignarAtributo( "VAR", "hZona", "valor", conectorParametroLimpia("hZona", "", true ));
      asignarAtributo( "VAR", "hMostrarCrono", "valor", "1");
      asignarAtributo( "VAR", "casoDeUso", "valor", conectorParametroLimpia("casoDeUso", "", true ));    
      asignarAtributo( "VAR", "hChangePaisMC", "valor", conectorParametroLimpia("hChangePaisMC", "", true ));
      asignarAtributo( "VAR", "hChangeMarcaMC", "valor", conectorParametroLimpia("hChangeMarcaMC", "", true ));
      asignarAtributo( "VAR", "hChangeCanalMC", "valor", conectorParametroLimpia("hChangeCanalMC", "", true ));
      asignarAtributo( "VAR", "hChangeGrupo", "valor", conectorParametroLimpia("hChangeGrupo", "", true ));
      asignarAtributo( "VAR", "hChangeSub", "valor", conectorParametroLimpia("hChangeSub", "", true ));
      asignarAtributo( "VAR", "hChangeRegion", "valor", conectorParametroLimpia("hChangeRegion", "", true ));
      asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
      
      vistaCronograma();

      getConfiguracionMenu("LPMantieneCronograma","generaFase1");                    
  }

  /** Guarda el cronograma y lo muestra en la pantalla PantallaGenerarCronogramaFase1. **/
  private void guarda() throws Exception {
      traza("Inicio guarda");
      //No se puede usar oculto porque no se actualizan los oid en el cronograma y no se refresca la pantalla
      //pagina("salidaGenerica");
	  String casoDeUso = conectorParametroLimpia("casoDeUso", "", true );
	  traza("Caso de uso: " + casoDeUso);
	  if (casoDeUso.equals("ModificaCronograma")) {
          traza("es Modifica Cronograma");
          esManteCrono = true;
          pagina("contenido_cronograma_modificar");
      } else {
          traza("es Genera Cronograma");
          pagina("contenido_cronograma1_generar");
          asignarAtributo( "LABELC", "lblCodPais", "valor", UtilidadesSession.getDescripcionPais(this));
      }      
          getConfiguracionMenu("LPMantieneCronograma","generaFase1");                    
          cargaInicialCombos();
          generaOcultosVueltaCrono();
      //} else {  //Es generacion
          //pagina("salidaGenerica");
      //}
      
      DTOCronograma dtoEntrada = tadCronograma.getCronograma(); 
      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAActualizaCronograma");
      
      paramEntrada.add(dtoEntrada);
      paramEntrada.add(id);

      try {
          traza("ANTES DE CONECTAR ConectorActualizaCronograma: "+dtoEntrada);
          DruidaConector conectorCrono = this.conectar( "ConectorActualizaCronograma", paramEntrada );
          traza("CONECTO ConectorActualizaCronograma: ");
      } catch (Exception ex) {  //Para dejar en el mantenimiento el cronograma que dio error
          traza("SE PRODUJO EXCEPTION AL GUARDAR EL CRONO");
          //if (esManteCrono) {
              asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
              vistaCronograma();
          //}
          throw ex;
      }

	  traza("esManteCrono: " + esManteCrono);
	  traza("tadCronograma.esZonas(): " + tadCronograma.esZonas());
	  
	  if (esManteCrono || tadCronograma.esZonas())
          obtieneCronograma();
      else {
          //asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
          asignarAtributo( "VAR", "hMostrarCrono", "valor", "1");
          vistaCronograma();
      }

  }

  /** Obtiene el cronograma para los criterios dados por pantalla. **/
  private void obtieneCronograma() throws Exception {
      if (conectorParametroLimpia("casoDeUso", "", true ).equals("GenerarCronograma")) {
          traza("es Genera Cronograma de obtieneCrono");
          pagina("contenido_cronograma1_generar");
      } else {
          traza("es Modifica Cronograma de obtieneCrono");
          pagina("contenido_cronograma_modificar");
      }      
      cargaInicialCombos();

      if (conectorParametroLimpia("casoDeUso", "", true ).equals("consulta") ||
          conectorParametroLimpia("casoDeUso", "", true ).equals("eliminaCronograma"))
              esConsCrono = true;


      if (esConsCrono) {
         getConfiguracionMenu("LPMantieneCronograma","consultaCronograma");                    
         if (conectorParametroLimpia( "casoDeUso", "", true ).equals("eliminaCronograma")) {
            getConfiguracionMenu("LPMantieneCronograma","eliminaCronograma");                    
         }
      } else
          getConfiguracionMenu("LPMantieneCronograma","generaFase1");                    


      /** Agregado porque si se presiona nuevamente el boton generar no limpia el cronograma **/
      DTOCronograma dtoC = new DTOCronograma();
      dtoC.setOidPais(UtilidadesSession.getPais(this));
      dtoC.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoC.setIpCliente(UtilidadesBelcorp.getIPCliente(this));
      dtoC.setPrograma("LPMantieneCronograma");

      tadCronograma = new TADCronograma(dtoC, tadCronograma.esZonas()); 
      conectorParametroSesion(sesionCrono, tadCronograma);
      /** Fin Agregado **/
      
      DTOCronograma dtoE = tadCronograma.getCronograma(); 
      if (!marca.equals(""))
          dtoE.setMarca(new Long(marca));
      if (!canal.equals(""))
          dtoE.setCanal(new Long(canal));
      if (!codPeriodo.equals(""))
          dtoE.setCodigoPeriodo(codPeriodo);
      String grupo = conectorParametroLimpia( "hGrupoZona", "", true );
      String subgerencia = conectorParametroLimpia( "hSubgerencia", "", true );
      String region = conectorParametroLimpia( "hRegion", "", true );
      String zona = conectorParametroLimpia( "hZona", "", true );
      if (!grupo.equals(""))
          dtoE.setGrupo(new Long(grupo));
      if (!subgerencia.equals(""))
          dtoE.setSubgerencia(new Long(subgerencia));
      if (!region.equals(""))
          dtoE.setRegion(new Long(region));
      if (!zona.equals(""))
          dtoE.setZona(new Long(zona));

      generaOcultosVueltaCrono();
      asignarAtributo( "VAR", "hMostrarCrono", "valor", "");
      asignarAtributo("CAPA", "capaTablas", "visibilidad", "hidden");		

      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAConsultaCronograma");
      
      paramEntrada.add(dtoE);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorConsultaCronograma: "+dtoE);
      DruidaConector conectorCrono = this.conectar( "ConectorConsultaCronograma", paramEntrada );
      traza("CONECTO ConectorConsultaCronograma: ");

      //traza("Se obtuvo dto"+conectorFact.objeto("dtoSalida"));
      DTOCronograma dtoS = (DTOCronograma) conectorCrono.objeto("dtoSalida");
      tadCronograma = new TADCronograma(dtoS);
      conectorParametroSesion(sesionCrono, tadCronograma);

      asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
      asignarAtributo( "VAR", "hMostrarCrono", "valor", "1");
      vistaCronograma();
 
      //getFormatosValidaciones();

      //if (esConsCrono)
      //    getConfiguracionMenu("LPMantieneCronograma","consultaCronograma ");                    
      //else
      //    getConfiguracionMenu("LPMantieneCronograma","generaFase1 ");                    
      
  }

  /** Muestra el mensaje de confirmación del borrado de la actividad **/
  private void confirmaActividad() throws Exception {
      traza("Entro a confirma actividad");
      //Se hace en javascript    
      pagina("salidaGenerica");
      Integer idVista = new Integer(conectorParametroLimpia( "hIdVista", "", true ));
      traza("IdVista: "+idVista);
      DTOActividadGrupo actividad = tadCronograma.obtieneActividadGrupo(idVista);
      if (actividad.getIndFija() != null && actividad.getIndFija().booleanValue()) {
          //throw new MareException(new MareException(), 180110005);            
          asignarAtributo( "VAR", "ejecutar", "valor", "vueltaEliminaActividad('1',"+idVista+")");
      } else {
          asignarAtributo( "VAR", "ejecutar", "valor", "vueltaEliminaActividad('0',"+idVista+")");
      }
      traza("FIN - confirma actividad");
  }

  /** Muestra la pantalla PantallaEliminarActividadCronograma. **/
  private void eliminaActividad() throws Exception {
      traza("Inicio eliminaActividad");
      pagina("contenido_mdg_actividad_eliminar");
      Integer idVista = new Integer(conectorParametroLimpia( "hIdVista", "", true ));
      DTOActividadGrupo actividad = tadCronograma.obtieneActividadGrupo(idVista); 
      Long oid = tadCronograma.eliminaActividad(idVista);
      conectorParametroSesion(sesionCrono, tadCronograma);
      traza("Actividad a eliminar: "+actividad.getTextoActividad());
      asignarAtributo( "VAR", "hVarActividad", "valor", oid.toString());
      //asignarAtributo( "LABELC", "lblActividad1", "valor", actividad.getTextoActividad());
      asignarAtributo( "VAR", "hTextoActividad", "valor", actividad.getTextoActividad());

      //Para volver al cronograma
      asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
      generaOcultosVueltaCrono();
      
      getConfiguracionMenu("LPMantieneCronograma","aceptaModificarFija");                    
  }

  /** Elimina las tareas de una actividad. **/
  private void eliminaTareas() throws Exception {
      String radio = conectorParametroLimpia("hRadio", "", true);
      traza("Inicio eliminarTareas: "+radio);
      pagina("contenido_cronograma_modificar");
      cargaInicialCombos();
      if (radio.equalsIgnoreCase("si")) {
          DTOOID dto = new DTOOID(); 
          Long oid = new Long(conectorParametroLimpia("hVarActividad", "", true));
          dto.setOid(oid);

          Vector paramEntrada = new Vector();
          MareBusinessID id = new MareBusinessID("CRAEliminaTareas");
      
          paramEntrada.add(dto);
          paramEntrada.add(id);

          traza("ANTES DE CONECTAR ConectorEliminaTransacciones: "+dto);
          DruidaConector conectorCrono = this.conectar( "ConectorEliminaTransacciones", paramEntrada );
          traza("CONECTO ConectorEliminaTransacciones: ");

      }

      //Para volver al cronograma
      asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
      generaOcultosVueltaCrono();

      vistaCronograma();
 
      //getFormatosValidaciones();
      
      getConfiguracionMenu("LPMantieneCronograma","generaFase1");                    
      
  }

  /** Muestra el mensaje de confirmación del borrado de la actividad **/
  private void insertaActividad() throws Exception {
      traza("Inicio insertaActividad");
      pagina("contenido_cronograma_actividad_anadir");

      RecordSet rs = tadCronograma.obtieneGruposRecordSet();
      DruidaConector dc = generarConectorZonas(rs);
      asignar("COMBO", "cbZona", dc, "resultado");
      
      //Incidencia 10038
      DTONuevasActividadesCronograma dtoNA = new DTONuevasActividadesCronograma();
      dtoNA.setOidPais(UtilidadesSession.getPais(this));
      dtoNA.setOidMarca(new Long(marca));
      dtoNA.setOidCanal(new Long(canal));
      dtoNA.setOidIdioma(UtilidadesSession.getIdioma(this));
      dtoNA.setActividadesCronograma(tadCronograma.obtieneActividadesVista());

      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAObtieneNuevasActividadesCronograma");
      
      paramEntrada.add(dtoNA);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorObtieneNuevasActividadesCronograma: "+dtoNA);
      DruidaConector conectorNuevas = this.conectar( "ConectorObtieneNuevasActividadesCronograma", paramEntrada );
      traza("CONECTO ConectorObtieneNuevasActividadesCronograma: ");

      DTOSalida dtoS = (DTOSalida) conectorNuevas.objeto("dtoSalida");

	  // CRA-01
	  Long oidPeriodo = tadCronograma.getCronograma().getPeriodo();
	  Integer anio = this.obtenerAnioPeriodo(oidPeriodo);
	  asignar("VAR", "hOidPeriodo", oidPeriodo.toString());
	  asignar("VAR", "hConstanteActividadConRefeOtroPeriodo", ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.toString());

	  // CRA-01 - Cargo el combo cbPeriodoReferencia
	  DTOPeriodo dtoPeri = new DTOPeriodo();
	  dtoPeri.setPais(UtilidadesSession.getPais(this));
	  dtoPeri.setMarca(new Long(marca));
	  dtoPeri.setCanal(new Long(canal));
	  dtoPeri.setAnio(anio);

	  ComposerViewElementList list = new ComposerViewElementList();
	  ComposerViewElement element = new ComposerViewElement();
	  element.setDTOE(dtoPeri);
	  element.setIDBusiness("REPObtenerPeriodosAnioAcceso");
	  list.addViewElement(element);

	  ConectorComposerView conector = new ConectorComposerView(list, this.getRequest());
	  conector.ejecucion();

	  traza("*** antes de conectar para obtener periodos");
	  DruidaConector drdConector = conector.getConector();
	  traza("*** despues de conectar para obtener periodos");

	  asignar("COMBO", "cbPeriodoReferencia", drdConector, "REPObtenerPeriodosAnioAcceso");
	  // Fin carga combo cbPeriodoReferencia

      //rs = tadCronograma.obtieneActividadesVista();
      dc = generarConectorActividades(dtoS.getResultado());
      asignar("COMBO", "cbActividad", dc, "resultado");
      conectorParametroSesion(sesionActivs, dtoS);

      //Para volver al cronograma
      generaOcultosVueltaCrono();

      //getConfiguracionMenu("LPMantieneCronograma","modificaCrono");                    
      getConfiguracionMenu("LPMantieneCronograma","aceptaModificarFija");                    

  }

  /**
   * Cambio CRA-01
   * Recupera información de la actividad seleccionada en la página de Añadir actividad
   * y la asigna a las variables hidden de la página.
   * @author dmorello
   */
  private void obtenerInfoActividad() throws Exception {
      traza("*** Entrada - LPMantieneCronograma - obtenerInfoActividad ***");

      Long oidActividad = new Long(conectorParametroLimpia("hOidActividad", "", false));

      pagina("salidaGenerica");

	  DTOOID dtoOid = new DTOOID();
	  dtoOid.setOid(oidActividad);

      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAObtenerInfoActividad");
      paramEntrada.add(dtoOid);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorObtenerInfoActividad: " + dtoOid);
      DruidaConector conectorInfo = this.conectar( "ConectorObtenerInfoActividad", paramEntrada );
      traza("CONECTO ConectorObtenerInfoActividad: ");

	  DTOSalida dtoSalidaInfo = (DTOSalida)conectorInfo.objeto("dtoSalida");
	  RecordSet rsInfo = dtoSalidaInfo.getResultado();
	  traza("rsInfo: " + rsInfo);

	  Integer tipoActividad = null;
	  Long oidActivOrigen = null;
	  String codActivOrigen = null;
	  String nombreActivOrigen = null;
	  Integer diasDesplazamiento = null;

	  Object aux;

	  tipoActividad = new Integer(((BigDecimal)rsInfo.getValueAt(0, "COD_TIPO_ACTI")).intValue());

	  if ((aux = rsInfo.getValueAt(0, "OID_ACTI_ORIG")) != null) {
	      oidActivOrigen = new Long(((BigDecimal)aux).longValue());
	  }
	  if ((aux = rsInfo.getValueAt(0, "COD_ACTI_ORIG")) != null) {
	      codActivOrigen = aux.toString();
	  }
	  if ((aux = rsInfo.getValueAt(0, "VAL_NOMB_ACTI_ORIG")) != null) {
	      nombreActivOrigen = aux.toString();
	  }
	  if ((aux = rsInfo.getValueAt(0, "NUM_DIAS_DESP")) != null) {
		  diasDesplazamiento = new Integer(((BigDecimal)aux).intValue());
	  }

	  traza("tipoActividad: " + tipoActividad);
	  traza("oidActivOrigen: " + oidActivOrigen);
	  traza("codActivOrigen: " + codActivOrigen);
	  traza("nombreActivOrigen: " + nombreActivOrigen);
	  traza("diasDesplazamiento: " + diasDesplazamiento);

      // Seteo a la pagina la info obtenida de la actividad
	  StringBuffer js = new StringBuffer();
      js.append("setInfoActividadOrigen('").append(tipoActividad).append("',");
	  if (oidActivOrigen != null) {
		  js.append("'").append(oidActivOrigen).append("',");
		  js.append("'").append(codActivOrigen).append("',");
		  js.append("'").append(nombreActivOrigen).append("',");
	  } else {
		  js.append("null,null,null,");
	  }
	  js.append("'").append(diasDesplazamiento).append("')");
	  traza("js: " + js);
	  asignar("VAR", "ejecutar", js.toString());


      traza("*** Salida - LPMantieneCronograma - obtenerInfoActividad ***");
  }

  /** Añade una nueva actividad al cronograma. **/
  private void guardaActividad() throws Exception {
      traza("Inicio guardaActividad");
      pagina("contenido_cronograma_modificar");
      cargaInicialCombos();
      Long oidActCmb = new Long(conectorParametroLimpia( "hIdVista", "", true ));
      Long oidZona = new Long(conectorParametroLimpia( "hZonaNue", "", true ));
      String textoActividad = conectorParametroLimpia( "hTextoAct", "", true );
      String textoZona = conectorParametroLimpia( "hTextoZona", "", true );
      String radioFija = conectorParametroLimpia("hRadioFija", "", true);
      String radioAsoc = conectorParametroLimpia("hRadioAsoc", "", true);

      //Incidencia 10038
      //DTOActividadGrupo actividad = tadCronograma.obtieneActividadGrupo(idVistaAct);

      DTOActividadGrupo dto = new DTOActividadGrupo();

      //VER Incidencia 6036 
      String diasEjec = conectorParametroLimpia( "hDiasEjec", "", true );
      String horaEjec = conectorParametroLimpia( "hHoraEjec", "", true );
      if (horaEjec.equals(""))
          horaEjec = "12:00:00";
      String fechaFin = conectorParametroLimpia( "hFechaFin", "", true );
      String cadaDias = conectorParametroLimpia( "hCadaDias", "", true );

	  traza("diasEjec: " + diasEjec);
	  traza("horaEjec: " + horaEjec);
	  traza("fechaFin: " + fechaFin);
	  traza("cadaDias: " + cadaDias);

      dto.setFecha0(new Long(diasEjec));
      if (!cadaDias.equals(""))
          dto.setFechaMedia(new Integer(cadaDias));

      //Armo fechaPrevista
      Calendar c = new GregorianCalendar();
      c.setTime(tadCronograma.getCronograma().getFechaIniPeriodo());
      c.add(Calendar.DATE, new Integer(diasEjec).intValue());
      
      StringTokenizer stkOculto = new StringTokenizer(horaEjec,":");
      String sHora = (String) stkOculto.nextToken();
      String sMin = (String) stkOculto.nextToken();
      String sSeg = (String) stkOculto.nextToken();

      c.set(Calendar.HOUR_OF_DAY, new Integer(sHora).intValue());
      c.set(Calendar.MINUTE, new Integer(sMin).intValue());
      c.set(Calendar.SECOND, new Integer(sSeg).intValue());

      Timestamp fechaPrev = new Timestamp(c.getTime().getTime());

      dto.setFechaPrevista(fechaPrev);
      //Fin armo fechaPrevista

      String repetitiva = conectorParametroLimpia("hRepetitiva", "", true);
      traza("Check de Repetitiva: "+repetitiva);
      if (repetitiva.equalsIgnoreCase("s") && !fechaFin.equals("")) {
          Calendar cFin = new GregorianCalendar();
          cFin.setTime(dto.getFechaPrevista());
          cFin.add(Calendar.DATE, new Integer(fechaFin).intValue());
          dto.setFechaFinal(new Date(cFin.getTime().getTime()));
      }

      //Incidencia 10038
      DTOSalida dtoS = (DTOSalida) conectorParametroSesion(sesionActivs);
      RecordSet rs = dtoS.getResultado();
      Boolean tipoDias = new Boolean(false);
      String codActi = "";
      for (int i = 0; i < rs.getRowCount(); i ++) {
          Long oidA = new Long(((BigDecimal) rs.getValueAt(i, "OID_ACTI")).toString());
          if (oidA.equals(oidActCmb)) {
              if (rs.getValueAt(i, "IND_LABO") != null) {
                  if (((BigDecimal) rs.getValueAt(i, "IND_LABO")).intValue() == 1)
                      tipoDias = new Boolean(true);
              }
              codActi = (String) rs.getValueAt(i, "COD_ACTI");
              break;
          }
      }

	  // Cambio CRA-01 - dmorello
	  // Verifico si la activ es de tipo Referencia otro periodo
	  // Si es de ese tipo, seteo al dto info extra del periodo
	  Integer tipoActividad = new Integer(conectorParametroLimpia("hTipoActividad", "", false));
	  dto.setTipoActividad(tipoActividad);
	  if (dto.getTipoActividad().intValue() == ConstantesCRA.ACTIVIDAD_CON_REFE_OTRO_PERIODO.intValue()) {
		  dto = this.agregarInfoActividadRefOtroPeriodo(dto);
	  }

      dto.setTipoDias(tipoDias);
      dto.setActividad(oidActCmb);
      dto.setGrupo(oidZona);
      dto.setPeriodo(tadCronograma.getCronograma().getPeriodo());

      // Obtengo el tipo de facturación de la zona a la que añado la actividad 
      DTOGrupoCronograma dtoGC = tadCronograma.obtieneGrupo((oidZona));
      //DTOActividadGrupo = DTOGrupoCronograma.actividades(0) // Todas tienen el mismo tipo de facturación 
      dto.setTipoFacturacion(dtoGC.getTipoFacturacion());

      dto.setFechaIniPeriodo(tadCronograma.getCronograma().getFechaIniPeriodo());
      dto.setFechaFinPeriodo(tadCronograma.getCronograma().getFechaFinPeriodo());
      dto.setTextoGrupo(textoZona);
      dto.setTextoActividad(textoActividad);
      dto.setCodigo(codActi);
      dto.setIndFija(new Boolean(radioFija.equalsIgnoreCase("si")));

      traza("Nueva actividad: "+dto);

      traza("IdVista ultimo: "+tadCronograma.getIdVistaUltimo());
      Integer idVistaNue = tadCronograma.insertaActividadGrupo(dto.getGrupo(), dto);
      dto.setIdVista(idVistaNue);
      traza("IdVista nuevo: "+idVistaNue);

      if (radioAsoc.equalsIgnoreCase("si"))
          guardaAsociadas(dto);

      conectorParametroSesion(sesionCrono, tadCronograma);

      asignarAtributo("CAPA", "capaTablas", "visibilidad", "visible");		
      generaOcultosVueltaCrono();

      vistaCronograma();

      getConfiguracionMenu("LPMantieneCronograma","generaFase1");                    
      
  }

  /** 
   * Cambio CRA-01
   * Se procesan actividades de tipo Referencia otra campaña
   * Si la actividad guardada es de este tipo:
   * - Se obtiene su actividad origen
   * - Se busca la actividad origen en el período de referencia seleccionado
   * - Si existe, se calcula la fecha prevista de la nueva actividad a partir
   *   de la fecha de inicio de la actividad origen hallada
   * - Si no existe origen, a la actividad nueva se le asigna temporalmente
   *   fecha prevista igual a la fecha de inicio de su período.
   * @author dmorello
   */
  private DTOActividadGrupo agregarInfoActividadRefOtroPeriodo(DTOActividadGrupo dto) throws Exception {

	  // Tomo de la pagina info de la actividad ingresada
	  Long oidActCmb = new Long(conectorParametroLimpia( "hIdVista", "", true ));
      Long oidZona = new Long(conectorParametroLimpia( "hZonaNue", "", true ));
	  Long oidPeriodoRef = null;
	  String nombrePeriodoRef = "";
	  String strOidPeriodoRef = conectorParametroLimpia("hOidPeriodoReferencia", "", false);
	  if (strOidPeriodoRef.length() > 0) {
		  oidPeriodoRef = new Long(strOidPeriodoRef);
		  nombrePeriodoRef = conectorParametroLimpia("hNombrePeriodoReferencia", "", false);
	  }

	  // Tomo info de la actividad origen
	  Long oidActivOrigen = new Long(conectorParametroLimpia("hOidActividadOrigen", "", false));
	  String codActivOrigen = conectorParametroLimpia("hCodActividadOrigen", "", false);
	  String nombreActivOrigen = conectorParametroLimpia("hNombreActividadOrigen", "", false);
	  Integer diasDesplazamiento = new Integer(conectorParametroLimpia("hDiasDesplazamiento", "", false));

	  traza("oidActivOrigen: " + oidActivOrigen);
	  traza("codActivOrigen: " + codActivOrigen);
	  traza("nombreActivOrigen: " + nombreActivOrigen);
	  traza("diasDesplazamiento: " + diasDesplazamiento);
	  
	  // Busco el id vista y la fecha de inicio de la actividad origen en el periodo de referencia
	  DTOBuscarActividadOrigen dtoBuscar = new DTOBuscarActividadOrigen();
	  dtoBuscar.setOidPeriodo(oidPeriodoRef);
	  dtoBuscar.setOidZona(oidZona);
	  dtoBuscar.setOidActividad(oidActivOrigen); // Se que es != null por el tipo de actividad

	  MareBusinessID id = new MareBusinessID("CRAObtenerActividadOrigenDeOtroPeriodo");
	  Vector paramEntrada = new Vector();
	  paramEntrada.add(dtoBuscar);
	  paramEntrada.add(id);

	  traza("ANTES DE CONECTAR ConectorObtenerActividadOrigenDeOtroPeriodo: " + dtoBuscar);
	  DruidaConector conectorOrigen = this.conectar( "ConectorObtenerActividadOrigenDeOtroPeriodo", paramEntrada );
	  traza("CONECTO ConectorObtenerActividadOrigenDeOtroPeriodo");

	  DTOSalida dtoSalida = (DTOSalida)conectorOrigen.objeto("dtoSalida");
	  RecordSet rsOrigen = dtoSalida.getResultado();
	  traza("rsOrigen: " + rsOrigen);

	  // Verifico si existe el cronograma del periodo de referencia
	  // y contiene la actividad origen
	  if (rsOrigen != null && ! rsOrigen.esVacio()) {

		  // Existe actividad origen
		  dto.setIdVistaOrigenOtroPeriodo(new Integer(((BigDecimal)rsOrigen.getValueAt(0, "COD_VIST")).intValue()));
		  dto.setIndPendienteOrigen(Boolean.FALSE);

		  // Calculo la fecha prevista a partir de la actividad origen
		  DTOCalcularFechaPrevista dtoCalc = new DTOCalcularFechaPrevista();
		  dtoCalc.setDiasDesplazamiento(diasDesplazamiento);
		  dtoCalc.setOidActividad(oidActCmb);
		  dtoCalc.setOidPais(UtilidadesSession.getPais(this));
		  dtoCalc.setOidMarca(new Long(this.marca));
		  dtoCalc.setOidCanal(new Long(this.canal));
		  dtoCalc.setOidZona(oidZona);
		  dtoCalc.setFechaActividadOrigen(new Timestamp(((Date)rsOrigen.getValueAt(0, "FEC_INIC")).getTime()));

		  id = new MareBusinessID("CRACalcularFechaPrevista");
		  paramEntrada.clear();
		  paramEntrada.add(dtoCalc);
		  paramEntrada.add(id);

		  traza("ANTES DE CONECTAR ConectorCalcularFechaPrevista: " + dtoCalc);
		  DruidaConector conectorFecha = this.conectar( "ConectorCalcularFechaPrevista", paramEntrada );
		  traza("CONECTO ConectorCalcularFechaPrevista");

		  // Asigno al dto la fecha obtenida
		  DTODate dtoDate = (DTODate)conectorFecha.objeto("dtoSalida");
		  traza("dtoDate: " + dtoDate);
		  dto.setFechaPrevista(new Timestamp(dtoDate.getFecha().getTime()));

	  } else {
		  // No existe actividad origen
		  // Se coloca temporalmente la fecha de inicio del periodo al que pertenece la actividad
		  dto.setFechaPrevista(new Timestamp(tadCronograma.getCronograma().getFechaIniPeriodo().getTime()));
		  dto.setIndPendienteOrigen(Boolean.TRUE);
	  }

	  // Fecha0 coincide con diasDesplazamiento para las actividades de este tipo
	  dto.setFecha0(new Long(diasDesplazamiento.longValue()));

	  dto.setOidActividadOrigen(oidActivOrigen);
	  dto.setNombrePeriodoReferencia(nombrePeriodoRef);
	  dto.setCodigoActividadOrigen(codActivOrigen);
	  dto.setNombreActividadOrigen(nombreActivOrigen);
	  dto.setPeriodoReferencia(oidPeriodoRef);
	  dto.setDiasDesplazamiento(diasDesplazamiento);

	  return dto;
  }

  /** Guarda las actividades asociadas a la dada. **/
  private void guardaAsociadas(DTOActividadGrupo dto) throws Exception {
      dto.setOidIdioma(UtilidadesSession.getIdioma(this));
  
      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAObtieneReferenciasCronograma");
      
      paramEntrada.add(dto);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorObtieneReferenciasCronograma: "+dto);
      DruidaConector conectorCrono = this.conectar( "ConectorObtieneReferenciasCronograma", paramEntrada );
      traza("CONECTO ConectorObtieneReferenciasCronograma: ");
      
      DTOGrupoCronograma dtoS = (DTOGrupoCronograma) conectorCrono.objeto("dtoSalida");
      traza("DTO para insertar asociadas: "+dtoS);
      tadCronograma.insertaAsociadas(dtoS);
  }

  /** Elimina el cronograma. **/
  private void eliminaCronograma() throws Exception {
      traza("Inicio eliminaCronograma");
      pagina("salidaGenerica");
      DTOCronograma dtoEntrada = tadCronograma.getCronograma();
  
      Vector paramEntrada = new Vector();
      MareBusinessID id = new MareBusinessID("CRAEliminaCronograma");
      
      paramEntrada.add(dtoEntrada);
      paramEntrada.add(id);

      traza("ANTES DE CONECTAR ConectorActualizaCronograma: ");
      DruidaConector conectorCrono = this.conectar( "ConectorActualizaCronograma", paramEntrada );
      traza("CONECTO ConectorActualizaCronograma: ");

      asignarAtributo( "VAR", "ejecutar", "valor", "vueltaEliminaCrono()");

  }

  private void generaOcultosVueltaCrono() throws Exception {
      asignarAtributo( "VAR", ocultoDiasSemana, "valor", conectorParametroLimpia( ocultoDiasSemana, "", true ));
      asignarAtributo( "VAR", ocultoMeses, "valor", conectorParametroLimpia( ocultoMeses, "", true ));
      asignarAtributo( "VAR", "hPaisDesc", "valor", UtilidadesSession.getDescripcionPais(this));
      asignarAtributo( "VAR", "hIdioma", "valor", UtilidadesSession.getIdioma(this).toString());
      asignarAtributo( "VAR", "hCbPais", "valor", conectorParametroLimpia("hCbPais", "", true ));
      asignarAtributo( "VAR", "hMarca", "valor", marca);
      asignarAtributo( "VAR", "hCanal", "valor", canal);
      asignarAtributo( "VAR", "hCodPeriodo", "valor", codPeriodo);
      asignarAtributo( "VAR", "hGrupoZona", "valor", conectorParametroLimpia("hGrupoZona", "", true ));
      asignarAtributo( "VAR", "hSubgerencia", "valor", conectorParametroLimpia("hSubgerencia", "", true ));
      asignarAtributo( "VAR", "hRegion", "valor", conectorParametroLimpia("hRegion", "", true ));
      asignarAtributo( "VAR", "hZona", "valor", conectorParametroLimpia("hZona", "", true ));
      asignarAtributo( "VAR", "hMostrarCrono", "valor", "1");
      asignarAtributo( "VAR", "casoDeUso", "valor", conectorParametroLimpia("casoDeUso", "", true ));    
      asignarAtributo( "VAR", "hChangePaisMC", "valor", conectorParametroLimpia("hChangePaisMC", "", true ));
      asignarAtributo( "VAR", "hChangeMarcaMC", "valor", conectorParametroLimpia("hChangeMarcaMC", "", true ));
      asignarAtributo( "VAR", "hChangeCanalMC", "valor", conectorParametroLimpia("hChangeCanalMC", "", true ));
      asignarAtributo( "VAR", "hChangeGrupo", "valor", conectorParametroLimpia("hChangeGrupo", "", true ));
      asignarAtributo( "VAR", "hChangeSub", "valor", conectorParametroLimpia("hChangeSub", "", true ));
      asignarAtributo( "VAR", "hChangeRegion", "valor", conectorParametroLimpia("hChangeRegion", "", true ));
      asignarAtributo( "VAR", "hFormatoFechaPais", "valor", UtilidadesSession.getFormatoFecha(this));
  }


  private DruidaConector generarConectorZonas(RecordSet rs) throws Exception {
        traza("Inicio generarConectorZona");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "resultado");
        rowset2.appendChild(rowset);

        quickSort(rs, 0, rs.getRowCount()-1);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "oid");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(((Long) rs.getValueAt(i,"oid")).toString());
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "zona");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            txt = docDestino.createTextNode((String) rs.getValueAt(i,"descripcion"));
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

        }

        DruidaConector conectorCrono = new DruidaConector();
        conectorCrono.setXML(rowset2);
        traza("XML: "+conectorCrono.getXML());

        return conectorCrono;
  }

  private DruidaConector generarConectorActividades(RecordSet rs) throws Exception {
        traza("Inicio generarConectorActividades");
        DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document docDestino = docBuilder.newDocument();
        Element rowset2 = docDestino.createElement("ROWSET2");
        
        Element rowset = docDestino.createElement("ROWSET");
        rowset.setAttribute("ID", "resultado");
        rowset2.appendChild(rowset);

        //Por incidencia 10038 ya debería venir ordenado
        //quickSort(rs, 0, rs.getRowCount()-1);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element elemRow = docDestino.createElement("ROW");
            rowset.appendChild(elemRow);

            Element elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "oid"); //En realidad viene el idVista
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            Text txt = docDestino.createTextNode(((BigDecimal) rs.getValueAt(i,"OID_ACTI")).toString());
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

            elemDato = docDestino.createElement("CAMPO");
            elemDato.setAttribute("NOMBRE", "zona");
            elemDato.setAttribute("TIPO", "STRING");
            elemDato.setAttribute("LONGITUD", "50");
            txt = docDestino.createTextNode((String) rs.getValueAt(i,"NOMBRE"));
            elemDato.appendChild(txt);
            elemRow.appendChild(elemDato);

        }

        DruidaConector conectorCrono = new DruidaConector();
        conectorCrono.setXML(rowset2);
        traza("XML: "+conectorCrono.getXML());

        return conectorCrono;
  }

  /** Ordena los recordSet usando quickSort **/
  private void quickSort(RecordSet rs, int izqT, int derT) throws Exception {
      if (izqT < derT) {
          int izq = izqT;
          int der = derT;
          int medio = ((der + izq) / 2);
          String elemM = (String) rs.getValueAt(medio, "descripcion");
          do {
                String elemI = (String) rs.getValueAt(izq, "descripcion");
                while (elemI.compareTo(elemM) < 0) {  //ElemI es menor que elemM?
                    izq++;
                    elemI = (String) rs.getValueAt(izq, "descripcion");
                }
                String elemD = (String) rs.getValueAt(der, "descripcion");
                while (elemD.compareTo(elemM) > 0) {  //ElemD es mayor que elemM?
                    der--;
                    elemD = (String) rs.getValueAt(der, "descripcion");
                }

                if (izq <= der) {
                  swap(rs, izq, der);

                  izq++;
                  der--;
                }

            } while (izq <= der);

            quickSort(rs, izqT, der);
            quickSort(rs, izq, derT);
      }

  }

  private static void swap (RecordSet rs, int izq, int der) throws Exception {
      Vector vIzq = (Vector) rs.getRow(izq).clone();
      Vector vDer = (Vector) rs.getRow(der).clone();
      rs.setValueAt(vDer.get(0), izq, 0);
      rs.setValueAt(vDer.get(1), izq, 1);
      rs.setValueAt(vIzq.get(0), der, 0);
      rs.setValueAt(vIzq.get(1), der, 1);
  }
  
  private void crearArrayTipos(DTOCronograma dto) throws Exception {
      Vector grupos = dto.getGrupos();
      if (grupos == null) 
          grupos = new Vector();
          
      //String strArray = "[";
      String strArray = "";

      for(int i = 0; i < grupos.size(); i++) {
        DTOGrupoCronograma dtoG = (DTOGrupoCronograma) grupos.get(i);
        strArray = strArray + "" + dtoG.getOid() + "| ";
        strArray = strArray + "" + dtoG.getTextoGrupo() + "| ";
        strArray = strArray + "" + dtoG.getTipoFacturacion() + "| ";
        strArray = strArray + "| ";
        if( i < (grupos.size() - 1) ){
          strArray = strArray + "|| ";
        }
      }
      //strArray = strArray + ']';
      traza("El array resultante es: "+strArray);

      asignarAtributo( "VAR", "hTipos", "valor", strArray);
      asignarAtributo( "VAR", "hLongTipos", "valor", grupos.size()+"");
      //return strArray;
  }
  
  private void cargaInicialCombos() throws Exception{
    traza("Inicio cargaInicialCombos");
		//Preparamos los parametros del subsistema
		ComposerViewElementList cv = crearParametrosEntrada();
		
		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();

		//traza("resultados: "+resultados.getXML());
		//Cargamos los combos con los resultados
		asignar("COMBO", "cbMarcas", resultados, "SEGConsultaMarcas");
		asignar("COMBO", "cbCanales", resultados, "SEGConsultaCanales");
    if (esManteCrono) {
        cargaComboPais();
        if (!accion.equals("muestraConsultaCronograma") && !accion.equals("muestraModificaCronograma")) {
            traza("Antes asignar combo de Zonas");
            asignar("COMBO", "cbGrupoZonas", resultados, "CRAObtieneGruposZonas");
            asignar("COMBO", "cbSubgerenciaVentas", resultados, "ZONRecargaSubgerenciaVentas");
            if (!conectorParametroLimpia("hChangeSub", "", true ).equals("")) {
                asignar("COMBO", "cbRegion", resultados, "ZONRecargaRegiones");
            }
            if (!conectorParametroLimpia("hChangeGrupo", "", true ).equals(""))
                    asignar("COMBO", "cbZona", resultados, "CRAObtieneZonasGrupo");
            if (!conectorParametroLimpia("hChangeRegion", "", true ).equals(""))
                    asignar("COMBO", "cbZona", resultados, "ZONRecargaZonas");
        }
    }
        
    traza("Fin cargaInicialCombos");

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception {
		ComposerViewElementList lista = new ComposerViewElementList(); 

    DTOBelcorp dtoBel = new DTOBelcorp();
    dtoBel.setOidPais(UtilidadesSession.getPais(this));
    dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
    
		//Primer combo
		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("SEGConsultaMarcas");
		ci1.setDTOE(dtoBel);
		ci1.setPosOID((byte)0);
		ci1.setPosDesc((byte)1);

		//Segundo combo
		ComposerViewElement ci2 = new ComposerViewElement();
		ci2.setIDBusiness("SEGConsultaCanales");
		ci2.setDTOE(dtoBel);
		ci2.setPosOID((byte)0);
		ci2.setPosDesc((byte)1);

		lista.addViewElement(ci1);
		lista.addViewElement(ci2);

    if (esManteCrono &&
        !accion.equals("muestraConsultaCronograma") && !accion.equals("muestraModificaCronograma")) {

        String cbPais = conectorParametroLimpia("hChangePaisMC", "", true );
        String cbMarca = conectorParametroLimpia("hChangeMarcaMC", "", true );
        String cbCanal = conectorParametroLimpia("hChangeCanalMC", "", true );
        String cbGrupo = conectorParametroLimpia("hChangeGrupo", "", true );
        String cbSubgerencia = conectorParametroLimpia("hChangeSub", "", true );
        String cbRegion = conectorParametroLimpia("hChangeRegion", "", true );
        traza("cbPais: "+cbPais);
        traza("cbMarca: "+cbMarca);
        traza("cbCanal: "+cbCanal);
        traza("cbGrupo: "+cbGrupo);
        traza("cbSubgerencia: "+cbSubgerencia);
        traza("cbRegion: "+cbRegion);

        //Combo Grupos
        DTOGrupoZonas dtoG = new DTOGrupoZonas();
        //if (!cbPais.equals(""))  //Es obligatorio en pantalla
            dtoG.setOidPais(new Long(cbPais));
        //if (!cbMarca.equals(""))   //Es obligatorio en pantalla
            dtoG.setOidMarca(new Long(cbMarca));
        //if (!cbCanal.equals(""))   //Es obligatorio en pantalla
            dtoG.setOidCanal(new Long(cbCanal));
        dtoG.setOidIdioma(UtilidadesSession.getIdioma(this));
        ComposerViewElement ci3 = new ComposerViewElement();
        ci3.setIDBusiness("CRAObtieneGruposZonas");
        ci3.setDTOE(dtoG);
        ci3.setPosOID((byte)0);
        ci3.setPosDesc((byte)1);

    		lista.addViewElement(ci3);

        //Combo Subgerencia
        DTOUnidadAdministrativa dtoU = new DTOUnidadAdministrativa();
        //if (!cbPais.equals("")) 
            dtoU.setOidPais(new Long(cbPais));
        //if (!cbMarca.equals("")) 
            dtoU.setOidMarca(new Long(cbMarca));
        //if (!cbCanal.equals("")) 
            dtoU.setOidCanal(new Long(cbCanal));
        dtoU.setOidIdioma(UtilidadesSession.getIdioma(this));
        ComposerViewElement ci4 = new ComposerViewElement();
        ci4.setIDBusiness("ZONRecargaSubgerenciaVentas");
        ci4.setDTOE(dtoU);
        ci4.setPosOID((byte)0);
        ci4.setPosDesc((byte)1);

    		lista.addViewElement(ci4);

        //Combo Region
        if (!cbSubgerencia.equals("")) {
            DTOUnidadAdministrativa dtoUS = new DTOUnidadAdministrativa();
            dtoUS.setOidPais(new Long(cbPais));
            dtoUS.setOidMarca(new Long(cbMarca));
            dtoUS.setOidCanal(new Long(cbCanal));
            dtoUS.setOidIdioma(UtilidadesSession.getIdioma(this));
            dtoUS.setOidSGV(new Long(cbSubgerencia));
            ComposerViewElement ci6 = new ComposerViewElement();
            ci6.setIDBusiness("ZONRecargaRegiones");
            ci6.setDTOE(dtoUS);
            ci6.setPosOID((byte)0);
            ci6.setPosDesc((byte)1);

            lista.addViewElement(ci6);
            
        }
        //Combo Zona
        if (!cbGrupo.equals("") || !cbRegion.equals("")) {
            ComposerViewElement ci5 = new ComposerViewElement();

            if (!cbGrupo.equals("")) {
                DTOOID dtoO = new DTOOID();
                dtoO.setOid(new Long(cbGrupo));
                dtoO.setOidIdioma(UtilidadesSession.getIdioma(this));
                ci5.setDTOE(dtoO);
                ci5.setIDBusiness("CRAObtieneZonasGrupo");
            }
            if (!cbRegion.equals("")) {
                DTOUnidadAdministrativa dtoUR = new DTOUnidadAdministrativa();
                dtoUR.setOidPais(new Long(cbPais));
                dtoUR.setOidMarca(new Long(cbMarca));
                dtoUR.setOidCanal(new Long(cbCanal));
                dtoUR.setOidSGV(new Long(cbSubgerencia));
                dtoUR.setOidRegion(new Long(cbRegion));
                dtoUR.setOidIdioma(UtilidadesSession.getIdioma(this));
                ci5.setDTOE(dtoUR);
                ci5.setIDBusiness("ZONRecargaZonas");
            }

            ci5.setPosOID((byte)0);
            ci5.setPosDesc((byte)1);

            lista.addViewElement(ci5);
            
        }

    }

		return lista;
	}

  private void cargaComboPais() throws Exception {
        DTOFiltroPMC dtoFPMC = new DTOFiltroPMC();

        dtoFPMC.setIpCliente( UtilidadesBelcorp.getIPCliente( this) );
        dtoFPMC.setPrograma( UtilidadesSession.getFuncion( this ) );
        dtoFPMC.setOidIdioma( UtilidadesSession.getIdioma( this) );

        dtoFPMC.setCanales( new Boolean(true) );
        dtoFPMC.setMarcas( new Boolean(true) );
        dtoFPMC.setPaises( new Boolean(true) );

        MareBusinessID bizId = new MareBusinessID("SEGcargaPMC");

        Vector params = new Vector();
        params.addElement( dtoFPMC );
        params.addElement( bizId );

        traza( "Antes conector: " + dtoFPMC);
        DruidaConector dc  =	conectar( "ConectorCargaPMC" , params );
        traza( "dc "); // + dc.getXML());

        asignar("COMBO", "cbPaises", dc , "dtoSalida.paises_ROWSET");
    

  }

	public Integer obtenerAnioPeriodo(Long oidPeriodo) throws Exception {
		traza("*** Entrada - LPMantieneCronograma - obtenerAnioPeriodo");
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOid(oidPeriodo);

		MareBusinessID id = new MareBusinessID("CRAObtenerAnioPeriodo");
		Vector paramEntrada = new Vector();
		paramEntrada.add(dtoOid);
		paramEntrada.add(id);

		traza("ANTES DE CONECTAR ConectorObtenerAnioPeriodo");
		DruidaConector conector = this.conectar("ConectorObtenerAnioPeriodo", paramEntrada );
		traza("CONECTO ConectorObtenerAnioPeriodo");

		DTOSalida dtoSalida = (DTOSalida)conector.objeto("dtoSalida");

		RecordSet rsAnio = dtoSalida.getResultado();
		Integer anio = null;
		if (!rsAnio.esVacio()) {
			anio = new Integer(((BigDecimal)rsAnio.getValueAt(0,0)).intValue());
		}

		traza("*** Salida  - LPMantieneCronograma - obtenerAnioPeriodo");
		return anio;
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


	/*
	private void traza(String s) throws Exception {
		super.traza(s);
		System.out.println(s);
	}
	*/

}
