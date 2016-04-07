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

import com.evermind.server.rmi.OrionRemoteException;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.cmn.presentacion.cache.Cache;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.ped.DTOLoteSolicitudes;
import es.indra.sicc.dtos.ped.DTORegistrarSolicitud;
import es.indra.sicc.dtos.ped.DTOTipoSolicitudRegistro;
import es.indra.sicc.dtos.ped.DTOValoresDefecto;
import es.indra.sicc.logicanegocio.ped.ConstantesValoresDefecto;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.reflect.InvocationTargetException;

import java.sql.Timestamp;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;



/**
 * Sistema:           Belcorp
 * Modulo:            PED
 * Submódulo:         
 * Componente:        Logica de Presentacion
 * Fecha:             
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes SICC-DMCO-PED-201-354-N030
 * @version           1.0
 * @autor             Alem luz de Luna pone tu nombre
 */

public class LPRegistrarSolicitud extends LPSICCBase {
    private Long aPais;
    private Long aIdioma;
    private String accion;
    private Long tipoSolicitud;
    private Long oidPeriodo;
    
    private long numeroSolicitudesRegistradasTotal;
    private Long oidLote;

	private Long numeroOC;
    private Long errorOC;
    private Long numeroCV;
    private Long errorCV;
    private Timestamp inicioSesion;
    private Timestamp finSesion;
    private Long aMarca;
    private Long aCanal;
    private Long aAcceso;
    private Long aSubacceso;
    private Long indMasSolicitud;
    private String strDatosDetalleKO;
    private Cache sesion;


    public LPRegistrarSolicitud() {
    }

    
    public void inicio() throws Exception {
        pagina("contenido_solicitudes_registrar");
    }
    
    
	public void ejecucion() throws Exception {
        try {
			setTrazaFichero();
            rastreo();
			accion = conectorParametroLimpia("accion", "", true);
            traza("accion:" + accion);
			aPais = UtilidadesSession.getPais(this);
            traza("pais: "  + aPais);
			aIdioma = UtilidadesSession.getIdioma(this);
            traza("idioma: "  + aIdioma);
			tipoSolicitud = (conectorParametro("hOidTipoSolicitud") == null) ? null : new Long(conectorParametro("hOidTipoSolicitud"));
            traza("tipoSolicitud: "  + tipoSolicitud);
				  traza("tipoSolicitud: "  + conectorParametro("hPeriodo") );
			oidPeriodo = (conectorParametro("hPeriodo") == null || conectorParametro("hPeriodo").equals("") ) ? null : new Long(conectorParametro("hPeriodo"));
            traza("oidPeriodo: " );
			asignarAtributo("VAR", "hPais", "valor", aPais.toString());
			
			asignarAtributo("VAR", "hIdioma", "valor", aIdioma.toString());
			asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
			asignarAtributo("VAR", "hOidTipoSolicitud", "valor", (this.tipoSolicitud == null) ? "" : this.tipoSolicitud.toString());
			asignarAtributo("VAR", "hPeriodo", "valor", (this.oidPeriodo == null) ? "" : this.oidPeriodo.toString());


            if (accion.equals("")) {
                traza("Antes de llamar al metodo inicializar.. ");
                //limpiarAtributosSesion();
                inicializar();
				traza("Despues de llamar al metodo inicializar.. ");
				//asignarAtributo("VAR", "hOidTipoSolicitud", "valor",tipoSolicitud.toString());
				//asignarAtributo("VAR", "hPeriodo", "valor",oidPeriodo.toString());
				getConfiguracionMenu();
								
            } else if (accion.equals("Cambiar_tipo_solicitud")) {
				traza("Antes de llamar al metodo cambiarTipoSolicitud ....Por Ejecuccion");
				sesion = getSessionCache();
				sesion.put("TIPO_SOLICITUD", tipoSolicitud);
				cambiarTipoSolicitud();
				traza("Despues de llamar al metodo cambiarTipoSolicitud ..");
                //pagina("salidaGenerica");
                    
            } else if (accion.equals("Cambiar_periodo")) {

				traza("Este es el periodo: #"  + conectorParametro("hPeriodo") + "#");
				oidPeriodo = conectorParametro("hPeriodo").equals("") ? null : new Long(conectorParametro("hPeriodo"));
				traza("Despues de asignar el periodo..!!");
				pagina("salidaGenerica");
				iniciarLote2();
						
            } else if (accion.equals("Comprobar_secuencia_procesos")) {
                //asignarAtributo("VAR", "ejecutarError", "valor", "validacionKO");
                //ComprobarSecuenciaProcesos();
                //pagina("salidaGenerica");

			} else if (accion.equals("Grabar_lote")) {
                grabarLote();
				getConfiguracionMenu();
            } 

		} catch (Exception ex) {
			logStackTrace(ex);
      lanzarPaginaError(ex);
			asignarAtributo("VAR", "hOidTipoSolicitud", "valor",tipoSolicitud.toString());
			asignarAtributo("VAR", "hPeriodo", "valor",oidPeriodo.toString());
			this.recargaPostError(ex);
		}
    }
    
    
    /*
     * Llamar al método cargarCabecera() 
     */
     public void inicializar() throws Exception {
		traza("Antes de llamar al metodo cargarCabecera ");
		cargarCabecera();
		traza("Despues de llamar al metodo cargarCabecera ");
     }
    
    
    public void cargarCabecera() throws Exception {
		  traza (" *************** INICIO CABECERA  ******************************************");

		  traza("Antes de llamar al metodo obtenerDatosIniciales() - cargarCabecera()");
		  obtenerDatosIniciales();
		  
		  traza("Antes de llamar al metodo seleccionarTipoSolicitud() - cargarCabecera() ");
		  seleccionarTipoSolicitudInicial();
		  
		  traza("Antes de llamar al metodo obtenerValoresAsociadosTipoSolicitud() - cargarCabecera()");
		  //obtenerValoresAsociadosTipoSolicitud(); 
  
		  
		  traza("Antes de llamar al metodo obtenerPeriodos() - cargarCabecera() ");
		  //obtenerPeriodos();
		  
		  traza("Antes de  llamar al metodo seleccionarPeriodo() - cargarCabecera() ");
		 // seleccionarPeriodo();
		  
		  traza("Antes de  llamar al metodo comprobarSecuenciaProcesos() - cargarCabecera()");
		 // comprobarSecuenciaProcesos();
		  traza("Despues de  llamar al metodo comprobarSecuenciaProcesos() - cargarCabecera()");
		  
		  traza("Antes de  llamar al metodo iniciarLote() - cargarCabecera()");
		//  iniciarLote();
		  traza("Despues de  llamar al metodo iniciarLote() - cargarCabecera()");
		  
		  traza (" *************** FIN CABECERA  ******************************************");
    }

	
      public void obtenerDatosIniciales() throws Exception {
      
		  traza ("***********************  INICIO - OBTENER DATOS INICIALES -  **********************************");
		  traza ("METODO OBTENER DATOS INICIALES");
		  DTOBelcorp dtobelcorp = new DTOBelcorp();
		  dtobelcorp.setOidIdioma(aIdioma);
		  dtobelcorp.setOidPais(aPais);
		  
		  traza ("METODO OBTENER DATOS INICIALES pais" + dtobelcorp.getOidPais());
  
		  ComposerViewElementList composerviewelementlist = crearParametrosEntradaDatosINI(dtobelcorp);
		  ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist, getRequest());
		  conectorcomposerview.ejecucion();
  
		  DruidaConector druidaconector = conectorcomposerview.getConector();
		  
		  traza("ESTE ES EL CONECTOR: " + druidaconector.getXML());
		  asignar("COMBO", "cbTipoSolicitud", druidaconector, "PEDObtenerTiposSolicitudDigitacionVD");
		  traza ("*****************************  FIN - OBTENER DATOS INICIALES  ****************************");
    }
    
    
      private ComposerViewElementList crearParametrosEntradaDatosINI(DTOBelcorp dtobelcorp) throws Exception {
            ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
            ComposerViewElement composerviewelement = new ComposerViewElement();
            composerviewelement.setIDBusiness("PEDObtenerTiposSolicitudDigitacionVD");
            composerviewelement.setDTOE(dtobelcorp);
            composerviewelementlist.addViewElement(composerviewelement);
            return composerviewelementlist;
    }
    
    
    /*
     * Selecciona en cbTipoSolicitud el primer valor 
     */ 
       public void seleccionarTipoSolicitud() throws Exception {
       
            traza ("METODO SELECCIONAR TIPO  SOLICITUD");
            traza("El TIPO_SOLICITUD es : " + tipoSolicitud);
            tipoSolicitud = obtenerPrimerElementoCombo("cbTipoSolicitud");
            traza("El TIPO_SOLICITUD es : " + tipoSolicitud);
            asignarAtributo("VAR", "hOidTipoSolicitud", "valor",tipoSolicitud.toString());
      }
    
    	 public void seleccionarTipoSolicitudInicial() throws Exception {

            asignarAtributo("VAR", "hOidTipoSolicitud", "valor","");
      }

    public void obtenerPeriodos() throws Exception {
            traza("obtenerPeriodos() ");
            DTOPeriodo dtoperiodo = new DTOPeriodo();
            dtoperiodo.setOidIdioma(aIdioma);
            dtoperiodo.setOidPais(aPais);
            dtoperiodo.setPais(aPais);
            
            traza("MARCA: " + sesion.get("MARCA"));
            traza("CANAL: " + sesion.get("CANAL"));
            
            dtoperiodo.setMarca((Long) sesion.get("MARCA"));
            dtoperiodo.setCanal((Long) sesion.get("CANAL"));
            
            ComposerViewElementList composerviewelementlist = crearParametrosEntradaPeriodos(dtoperiodo);
            ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist,getRequest());
            conectorcomposerview.ejecucion();
            DruidaConector druidaconector = conectorcomposerview.getConector();
            
            traza("obtenerPeriodos asignar CRAObtienePeriodos");
            asignar("COMBO", "cbPeriodo", druidaconector, "CRAObtienePeriodos");
            
            traza("Salio al metodo obtenerPeriodos()");
    }


	public void seleccionarPeriodo() throws Exception {
		  traza ("seleccionarPeriodo() ");
		  sesion = getSessionCache();

		  Long long1 = (Long) sesion.get("PERIODO");

		  if (long1 == null) {
			  traza("El periodo es igual a null.... selecciona el primero del combo.");
			  oidPeriodo = obtenerPrimerElementoCombo("cbPeriodo");
			  asignarAtributo("VAR", "hPeriodo", "valor", oidPeriodo.toString());
			  sesion.put("PERIODO", oidPeriodo);
		  } else {
			  traza("El periodo de sesion es diferente de null, lo toma.");
			  asignarAtributo("VAR", "hPeriodo", "valor", long1.toString());
			  oidPeriodo = long1;
		  }
    }
    
    
    public DTOValoresDefecto obtenerValoresDefecto() throws Exception {
        traza ("obtenerValoresDefecto()");
    
        Long long1 = tipoSolicitud;
        String[] as = {new String(ConstantesValoresDefecto.CB_ACCESO_FISICO), new String(ConstantesValoresDefecto.CB_DESTINO),
            new String(ConstantesValoresDefecto.CB_TIPO_DESPACHO) };

        traza("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
        traza("Estas son las constantes:   ");
        traza("ConstantesValoresDefecto.CB_TIPO_DESPACHO: "  + ConstantesValoresDefecto.CB_TIPO_DESPACHO);
        traza("ConstantesValoresDefecto.CB_ACCESO_FISICO: " + ConstantesValoresDefecto.CB_ACCESO_FISICO);
        traza("ConstantesValoresDefecto.CB_DESTINO: " + ConstantesValoresDefecto.CB_DESTINO);
        traza("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");

        MareBusinessID marebusinessid = new MareBusinessID("PEDObtenerValoresDefecto");
        DTOValoresDefecto dtovaloresdefecto = new DTOValoresDefecto();
        dtovaloresdefecto.setModulo(new Long(ConstantesValoresDefecto.MODULO_PED.longValue()));
        dtovaloresdefecto.setFormulario(ConstantesValoresDefecto.PG_DATOS_SOLICITUD);
        dtovaloresdefecto.setTipoSolicitud(long1);
        dtovaloresdefecto.setCampo(as);

        Vector vector = new Vector();
        vector.addElement(dtovaloresdefecto);
        vector.addElement(marebusinessid);
        traza(" ANTES DE CONECTAR");

        DruidaConector druidaconector = conectar("ConectorObtenerValorDefecto",vector);
        traza(" DESPUES DE CONECTAR");

        DTOValoresDefecto dtovaloresdefecto1 = (DTOValoresDefecto) druidaconector.objeto("DTOSalida");

        traza("Este es el DTO que recibo: " + dtovaloresdefecto1);

        traza("Esta es la longitud de Valor: " + dtovaloresdefecto1.getValor().length);

        traza("Esta es la longitud de Obligatorio: " + dtovaloresdefecto1.getObligatorio().length);

        traza("Esta es la longitud de Editable: " + dtovaloresdefecto1.getEditable().length);

        for (int i=0;i<dtovaloresdefecto1.getValor().length ;i++)  {
              traza("Valor " + i + ": " + dtovaloresdefecto1.getValor()[i]);			
        }
      
      for (int i=0;i<dtovaloresdefecto1.getObligatorio().length ;i++)  {
          traza("Obligatorio " + i + ": " + dtovaloresdefecto1.getObligatorio()[i]);			
      }
		
      for (int i=0;i<dtovaloresdefecto1.getEditable().length ;i++)  {
        traza("Editable " + i + ": " + dtovaloresdefecto1.getEditable()[i]);			
      }

      if (dtovaloresdefecto1.getValor() != null) {
            if (dtovaloresdefecto1.getValor()[0] != null) {
                asignarAtributo("VAR", "accesoFisicoVD", "valor",dtovaloresdefecto1.getValor()[0]);

                if (!dtovaloresdefecto1.getEditable()[0].booleanValue()) {
                    asignarAtributo("VAR", "accesoFisicoHabilitado", "valor","N");
                }
            }

      if (dtovaloresdefecto1.getValor()[1] != null) {

                if (!dtovaloresdefecto1.getEditable()[1].booleanValue()) {
                    asignarAtributo("VAR", "destinoHabilitado", "valor", "N");
                }
            }

      if (dtovaloresdefecto1.getValor()[2] != null) {
                asignarAtributo("VAR", "tipoDespachoVD", "valor",
                    dtovaloresdefecto1.getValor()[2]);

                if (!dtovaloresdefecto1.getEditable()[2].booleanValue()) {
                    asignarAtributo("VAR", "tipoDespachoHabilitado", "valor","N");
                }
				if (dtovaloresdefecto1.getObligatorio()[2].booleanValue())  {
					asignarAtributo("COMBO","cbTipoDespacho","req","S");
					asignarAtributoElementoValidacion("cbTipoDespacho","required","true");						
				}
            } else {
				Long tDespacho = obtenerPrimerElementoCombo("cbTipoDespacho");
				asignarAtributo("VAR", "tipoDespachoVD", "valor",tDespacho.toString());				
			}
        }
		return dtovaloresdefecto1;
    
  }


private Long obtenerPrimerElementoCombo(String s) throws Exception {

        traza ("METODO OBTENER PRIMER ELEMENTO COMBO");

        Document document = getXML();
        Object obj = null;
        Object obj1 = null;
        NodeList nodelist = null;
        Object obj2 = null;
        Object obj3 = null;
        String s1 = null;
        nodelist = document.getDocumentElement().getElementsByTagName("COMBO");

        int i = nodelist.getLength();

        for (int j = 0; j < i; j++) {
            if (((Element) nodelist.item(j)).getAttribute("nombre").equals(s)) {
                NodeList nodelist1 = ((Element) nodelist.item(j)).getElementsByTagName(
                        "ROW");
                NodeList nodelist2 = ((Element) nodelist1.item(0)).getElementsByTagName(
                        "CAMPO");
                s1 = ((Text) nodelist2.item(0).getFirstChild()).getData();
            }
        }

        return new Long(s1);
	}


	public void obtenerValoresAsociadosTipoSolicitud() throws Exception {
       
              traza ("****************** inicio - obtenerValoresAsociadosTipoSolicitud ********************************");
            
              traza("EL OIDTIPOSOLICUTUD ES: " + tipoSolicitud);
              traza ("METODO OBTENER VALORES ASOCIADOS TIPO SOLICITUD");
      
              MareBusinessID marebusinessid = new MareBusinessID( "PEDObtenerValoresTSRegistro");
              DTOOID dtooid = new DTOOID();
              DTOTipoSolicitudRegistro  dtoTipoSolicitudRegistro = new DTOTipoSolicitudRegistro();
              
              dtoTipoSolicitudRegistro.setOidTipoSolicitudPais(tipoSolicitud);
              dtoTipoSolicitudRegistro.setOidIdioma(aIdioma);
              dtoTipoSolicitudRegistro.setOidPais(aPais);
              
              traza ("OBTENER VALORES ASOCIADOS getOidTipoSolicitudPais  " + dtoTipoSolicitudRegistro.getOidTipoSolicitudPais() ); 
              traza ("OBTENER VALORES ASOCIADOS getOidPais  " + dtoTipoSolicitudRegistro.getOidPais() ); 
      
              Vector vector = new Vector();
              vector.addElement(dtoTipoSolicitudRegistro);
              vector.addElement(marebusinessid);
              traza(" ANTES DE CONECTAR");
      
              DruidaConector druidaconector = conectar("ConectorObtenerValoresTSRegistro", vector);
              traza(" DESPUES DE CONECTAR");
      
              DTOTipoSolicitudRegistro dtotiposolicitudRegistro = (DTOTipoSolicitudRegistro) druidaconector.objeto(       "DTOSalida");
              traza("Este es el DTO....: " + dtotiposolicitudRegistro);
              
      
              sesion = getSessionCache();
              sesion.put("MARCA", dtotiposolicitudRegistro.getOidMarca());
              sesion.put("CANAL", dtotiposolicitudRegistro.getOidCanal());
              
              traza ("MARCA DE OBTENER VALORES ASOCIADOS TIPO SOLICITUD" + sesion.get("MARCA"));
              traza ("CANAL DE OBTENER VALORES ASOCIADOS TIPO SOLICITUD" + sesion.get("CANAL"));
              
              if (dtotiposolicitudRegistro.getNumeroLote() != null){
                    traza("dtotiposolicitudRegistro.getNumeroLote()" + dtotiposolicitudRegistro.getNumeroLote());
                    asignarAtributo("VAR", "lote", "valor", dtotiposolicitudRegistro.getNumeroLote().toString());
                    asignarAtributo("LABELC", "lblLoteXX", "valor", dtotiposolicitudRegistro.getNumeroLote().toString());
              }
              if (dtotiposolicitudRegistro.getNumeroSolicitudesLote() != null){  
                    traza("dtotiposolicitudRegistro.getNumeroSolicitudesLote()" + dtotiposolicitudRegistro.getNumeroSolicitudesLote());
                    asignarAtributo("VAR", "numeroSolicitudes", "valor", dtotiposolicitudRegistro.getNumeroSolicitudesLote().toString());
                    asignarAtributo("LABELC", "lblNumeroSolicitudesLoteXX", "valor", dtotiposolicitudRegistro.getNumeroSolicitudesLote().toString());
              }
              traza("Termino de subir los datos a sesion...!!!!!");
              
              traza ("****************** fin - obtenerValoresAsociadosTipoSolicitud ********************************");
    }


    private ComposerViewElementList crearParametrosEntradaPeriodos(DTOPeriodo dtoperiodo) throws Exception {
              traza ("--------------- inicio crearParametrosEntradaPeriodos----------------------");
              ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
              ComposerViewElement composerviewelement = new ComposerViewElement();
              composerviewelement.setIDBusiness("CRAObtienePeriodos");
              composerviewelement.setDTOE(dtoperiodo);
              composerviewelementlist.addViewElement(composerviewelement);
              traza ("--------------- fin crearParametrosEntradaPeriodos----------------------");
              return composerviewelementlist;
    }
 

	/**
	*
	*/
 	public void cambiarTipoSolicitud() throws Exception {
		
   
    // Recuperamos los valores de digitación en función del tipo de solicitud 
        obtenerDatosIniciales();
		traza("Antes de llamar al metodo obtenerValoresAsociadosTipoSolicitud() ");
		obtenerValoresAsociadosTipoSolicitud();

		// Cargamos los periodos asociados al tipo de solicitud seleccionado 
		traza("Antes de llamar al metodo obtenerPeriodos()  ");
		obtenerPeriodos();

		traza("Antes de llamar al metodo seleccionarPeriodo()  ");
		seleccionarPeriodo();

		// Comprueba si el proceso de registro está definido para el tipo de solicitud 
		traza("Antes de llamar al metodo comprobarSecuenciaProcesos()  ");
		comprobarSecuenciaProcesos();

		traza("Antes de llamar al metodo iniciarLote()  ");
		iniciarLote();
   
	
	}


	/**
	*
	*/
    public void comprobarSecuenciaProcesos() throws Exception {
		// Comprueba si el proceso Registro solicitudes está configurado en la secuencia
		//de procesos para el tipo de solicitud 
		traza("EL OIDTIPOSOLICUTUD ES: " + tipoSolicitud);
		MareBusinessID marebusinessid = new MareBusinessID( "PEDValidarProcesoRegistro");
		DTOOID dtooid = new DTOOID();
		DTOTipoSolicitudRegistro  DTOTipoSolicitudRegistro = new DTOTipoSolicitudRegistro();
		dtooid.setOid(tipoSolicitud);
		Vector vector = new Vector();
		vector.addElement(dtooid);
		vector.addElement(marebusinessid);
        
    traza(" ANTES DE CONECTAR");
    DruidaConector druidaconector = conectar("ConectorValidarProcesoRegistro", vector);
    traza(" DESPUES DE CONECTAR");            

    traza("Si no capturo ninguna excepcion habilitarLecturaClientes() ");
		// Si no capturo ninguna excepcion habilitarLecturaClientes() 
        
		habilitarLecturaClientes();
    }


	/**
	* La lista de clientes solo tendrá una fila. Al insertar un cliente, se añade una nueva y se coloca el foco en la misma. 
	*/
    public void habilitarLecturaClientes() throws Exception {
		// Habilita la lista lstClientes y coloca el foco en la celda de la primera fila. 
		// Habilita el botón Guardar del menú secundario
		/** Se hace en la pagina para esto se pone un flag pues puede que no se habilite la lectura de clientes*/
		asignarAtributo("VAR", "hLecturaClientes", "valor", "S");
	}
    
    
    private String[] construirLineas(String s, String s1)
        throws Exception {
        StringTokenizer stringtokenizer = new StringTokenizer(s, s1);
        String[] as = new String[stringtokenizer.countTokens()];

        for (int i = 0; stringtokenizer.hasMoreTokens(); i++) {
            as[i] = stringtokenizer.nextToken();
        }

        return as;
    }
    

	/**
	*
	*/
	public void iniciarLote() throws Exception {
		traza("iniciarLote()");
		//Muestra en pantalla el número de solicitudes para el lote 
		asignarAtributo("LABELC", "lblNumeroSolicitudesRegistradasXX", "valor", "0");
		traza("IL1");
		asignarAtributo("VAR", "numeroSolicitudesRegistradas", "valor", "0");
		traza("IL2");
		//Envia a la página el valor: - oidLote = null 
        numeroSolicitudesRegistradasTotal = 0;
        oidLote = null;

		asignarAtributo("VAR", "oidLote", "valor", "");
		traza("IL3");
		// Muestra la lista de solicitudes vacia, se hace con en JS

	}

	public void iniciarLote2() throws Exception {
		traza("iniciarLote2()");

        numeroSolicitudesRegistradasTotal = 0;
        oidLote = null;
		  asignarAtributo("VAR", "ejecutar", "valor", "iniciarLote2()");

	}


	/**
	*
	*/
    public void grabarLote() throws Exception {
		traza (" ***grabarLote()");
		DTOLoteSolicitudes dto = new DTOLoteSolicitudes();
		traza("periodo: " + this.oidPeriodo);
		traza("tipoSolicitud: " + this.tipoSolicitud);
		dto.setOidPais(aPais);
		dto.setPeriodo(oidPeriodo);
		dto.setTipoSolicitud(tipoSolicitud);
              
		dto.setNumeroLote(conectorParametro("lote").equals("")? null : new Long(conectorParametro("lote")));
		dto.setNumeroSolicitudesLote(conectorParametro("numeroSolicitudes").equals("") ? null : new Long(conectorParametro("numeroSolicitudes")));
              
		// Previamente en JS se seteo la hidden hNumeroClientes = numeroSolicitudesRegistradas + cantidad de filas de la lista
		dto.setNumeroSolicitudes(conectorParametro("numeroSolicitudesRegistradas").equals("") ? null : new Long(conectorParametro("numeroSolicitudesRegistradas")));
		dto.setOidLote(conectorParametro("oidLote").equals("")? null : new Long(conectorParametro("oidLote")));
		dto.setOk(new Boolean(true));
              
		traza("DTOLoteSolicitudes: " + dto);

		String sDatosDetalle = conectorParametro("strDatosDetalle");
		traza("Clientes desde pagina: " + sDatosDetalle);
		String[] as = construirLineas(sDatosDetalle, "|");
		ArrayList clientes = new ArrayList();

		for (int i = 0; i < as.length; i++) {
			String codigoCliente = new String(as[i]);
			DTORegistrarSolicitud dtoRegistrarSolicitud = new DTORegistrarSolicitud();
			dtoRegistrarSolicitud.setOidPais(aPais);
			dtoRegistrarSolicitud.setCliente(codigoCliente);
			dtoRegistrarSolicitud.setOk(new Boolean(true));
			clientes.add(dtoRegistrarSolicitud);
		}
		dto.setClientes(clientes);
		traza("DTOLoteSolicitudes con clientes: " + dto);

		MareBusinessID marebusinessid = new MareBusinessID("PEDGrabarLote");
              
		Vector vector = new Vector();
		vector.addElement(dto);
		vector.addElement(marebusinessid);
		traza(" ANTES DE CONECTAR");
		DruidaConector druidaconector = conectar("ConectorGrabarLote",vector);
		traza(" DESPUES DE CONECTAR");

		DTOLoteSolicitudes  dtoLoteSolicitudes = (DTOLoteSolicitudes) druidaconector.objeto("DTOSalida");
		traza("DTOLoteSolicitudes luego de grabarLote: " + dtoLoteSolicitudes);

		if ( ! dtoLoteSolicitudes.getOk().booleanValue() ) {
			//Llamar al método reportarErrores(DTOLoteSolicitudes) 
			this.reportarErrores(dtoLoteSolicitudes);

		} else {
			if (dtoLoteSolicitudes.getOidLote() != null){
				// Incrementa en pantalla el número de solicitudes registradas (Campo txtNumeroSolicitudesRegistradas) para este lote 
				// txtNumeroSolicitudesRegistradas = txtNumeroSolicitudesRegistradas + DTOLoteSolicitudes.numeroSolicitudes 
				traza ("dtoLoteSolicitudes.getOidLote() es distinto de null");
				Long numeroSolicitudesRegistradas = conectorParametro("numeroSolicitudesRegistradas").equals("") ? new Long(0) : new Long(conectorParametro("numeroSolicitudesRegistradas"));
				
				if ( dtoLoteSolicitudes.getNumeroSolicitudes() != null)
				{
					numeroSolicitudesRegistradasTotal = dtoLoteSolicitudes.getNumeroSolicitudes().longValue();
				} 


				asignarAtributo("LABELC", "lblNumeroSolicitudesRegistradasXX", "valor", (new Long(numeroSolicitudesRegistradasTotal)).toString());
				asignarAtributo("VAR", "oidLote", "valor",  dtoLoteSolicitudes.getOidLote().toString());
                oidLote = dtoLoteSolicitudes.getOidLote();
			}else {
				traza ("dtoLoteSolicitudes.getOidLote() es null");
				iniciarLote();
			}
			// Limpiar la lista lstClientes, se jecuta en java script en guardarOK()
			pagina("salidaGenerica");
			asignarAtributo("VAR", "ejecutar", "valor", "guardarOK(" + numeroSolicitudesRegistradasTotal + 
                                                                    "," + oidLote + ")");
		}
		traza (" *** Finalizo grabarLote()");
	}



     /**
      * 
      */
     public void reportarErrores(DTOLoteSolicitudes  dtoLoteSolicitudes ) throws Exception {
        traza("reportarErrores()"); 
        String PED_035 = "10035";
        StringBuffer mensagesValidaciones = new StringBuffer();
        //Recorremos el ArrayList DTOE.clientes y comprobamos el estado de cada posición 
        for (int i = 0; i < dtoLoteSolicitudes.getClientes().size(); i++) {
            //Si la posición es erronea (DTORegistrarSolicitud.OK == False) 
            DTORegistrarSolicitud dtoRegistrarSolicitud = (DTORegistrarSolicitud) dtoLoteSolicitudes.getClientes().get(i);
            if ( ! dtoRegistrarSolicitud.getOk().booleanValue() ) {
                //Mostramos el mensaje PED-035 en la segunda columna de la lista ("Validación") para la linea indicada 
                String descripcionError = obtenerDescripcionError(PED_035);
                mensagesValidaciones.append(descripcionError);             
            } else {
                mensagesValidaciones.append(" ");
            }
            mensagesValidaciones.append("|");
        }
        mensagesValidaciones.deleteCharAt(mensagesValidaciones.length()-1);
        traza("mensagesValidaciones" + mensagesValidaciones.toString());
		pagina("salidaGenerica");
        asignarAtributo("VAR", "ejecutar", "valor", "guardarKO('" + mensagesValidaciones.toString() + "')");
    }



    /**
     * Recarga la pagina luego de un error.
     * Si es un error de negocio, recarga la pagina segun el error particular.
     * El estado deseado es el mismo que produce ejecucion.
     */
    private void recargaPostError(Exception ex) throws Exception {
		traza("metodo recargaPostError");
		traza("Clase de la excepcion: " + ex.getClass().getName());

		if (ex instanceof InvocationTargetException) { 
			traza("target exception es de clase: " + ((InvocationTargetException)ex).getTargetException().getClass().getName());
			if (((InvocationTargetException)ex).getTargetException() instanceof MareException) {
				MareException mex = (MareException)((InvocationTargetException)ex).getTargetException();
				traza("mex.getCode() " + mex.getCode());

				if (mex.getCode() == 10034) {
					//Recarga post error: El proceso registrar solicitudes no existe en secuencia de procesos
					traza("Recarga post error: El proceso registrar solicitudes no existe en secuencia de procesos.");
					//pagina("salidaGenerica");
					asignarAtributo("VAR", "hLecturaClientes", "valor", "N");
				}
			} else if (((InvocationTargetException)ex).getTargetException() instanceof OrionRemoteException) {
				OrionRemoteException ore = (OrionRemoteException)((InvocationTargetException)ex).getTargetException();
				traza("Es OrionRemoteException");
			}
		}        
		getConfiguracionMenu();
	}


    /**
     * Imprime el stack trace en caso de errores.
     */
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


	/**
	*
	*/
	private String obtenerDescripcionError(String codigoError) throws Exception {

		MareException me = new MareException(null,null,UtilidadesError.armarCodigoError(codigoError));
		DTOError dtoError = (new BelcorpError()).obtenerError( me, UtilidadesSession.getIdioma_ISO(this), 
																UtilidadesSession._ISO(this));
		return dtoError.getDescripcionError();
	}


}
