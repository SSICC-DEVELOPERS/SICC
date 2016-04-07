//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.dto.IMareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.msg.DTOMensaje;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import es.indra.sicc.util.UtilidadesError;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.NumberFormatException;
import java.lang.reflect.Array;

import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.dtos.msg.*;
import es.indra.sicc.util.*;
import es.indra.mare.common.dto.*;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.cmn.ListaEditableDinamica;

import org.w3c.dom.Element;

import java.util.Iterator;

import com.evermind.server.rmi.OrionRemoteException;
import java.sql.SQLException;
import java.lang.reflect.InvocationTargetException;
import javax.ejb.EJBException;
import es.indra.mare.common.exception.MareSystemLevelException;

public class LPDatosSeccion extends LPSICCBase {
    private String accion;
    private String numeroSeccion;
    private Integer numeroSecciones;   
    private Long oidSeccion;   
    private Long oidPatron;
    private Long oidPeriodo;
    private Long oidPatronOrigen;
    private String codigoPatron;   
    private String descripcionPatron;   
	private Integer ordenSecuencia;
    private Long oidMedioEnvio;
    private Long oidFormulario;
    private Boolean activo;   
    private Boolean patronPeriodo;   
    private Long oidPatronPeriodo;
    private Long pais;
    private Long idioma;
	private String casoUsoPatron;

    public LPDatosSeccion() {
        super();
    }
    
    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_patron_crear_seccion");
    }

    public void ejecucion() throws Exception {
         setTrazaFichero();
         
         try {
			rastreo();
            traza("Recibe los parametros:");
            String paramObt = null;
            accion = conectorParametroLimpia( "accion", "", true );
            oidSeccion = conectorParametroLimpiaLong( "oidSeccion");             
            oidPatron = conectorParametroLimpiaLong( "oidPatron"); 
            oidPeriodo = conectorParametroLimpiaLong( "oidPeriodo");
            oidPatronOrigen = conectorParametroLimpiaLong( "oidPatronOrigen");
            oidPatronPeriodo =conectorParametroLimpiaLong( "oidPatronPeriodo"); 
            numeroSeccion = conectorParametroLimpia( "numeroSeccion", "", true );
            numeroSecciones = conectorParametroLimpiaInteger( "numeroSecciones");
            codigoPatron = conectorParametroLimpia( "codigoPatron", "", true );
            descripcionPatron = conectorParametroLimpia( "descripcionPatron", "", true );
            oidMedioEnvio = conectorParametroLimpiaLong( "oidMedioEnvio");
            oidFormulario = conectorParametroLimpiaLong( "oidFormulario");
            activo = conectorParametroLimpiaBoolean( "activo");
            patronPeriodo = conectorParametroLimpiaBoolean( "patronPeriodo");
            casoUsoPatron = conectorParametroLimpia("casoDeUso", "", true);
						
				traza("*** Caso de Uso Patron: " + casoUsoPatron);
            if ( casoUsoPatron.equalsIgnoreCase("Modificar Seccion") )  // Se setea el titulo             
                asignarAtributoPagina("cod","0275");
					 traza("Este es el pais: ");
					traza(UtilidadesSession.getPais(this));

					traza("Este es el idioma:");
					traza(UtilidadesSession.getIdioma(this));

					pais = UtilidadesSession.getPais(this);	
	            idioma = UtilidadesSession.getIdioma(this);

		         traza("Recibio los parametros");
			   
				traza("*** Accion: " + accion);
				if ( accion.equals("") ) {
                //Llamar al método mostrarPaginaSeccion()
				       mostrarPaginaSeccion();
            }

            if ( accion.equalsIgnoreCase("Guardar seccion") ) {
                traza("---> Guardar Seccion <---");
        		pagina("salidaGenerica"); 
        		asignarAtributo("VAR", "ejecutar", "valor", "guardarOK()"); 
        		asignarAtributo("VAR", "ejecutarError", "valor", "guardarKO()"); 
                definirAccion();                 
            }

            getConfiguracionMenu();
         }  catch(Exception e){
            traza("TIRO EXCEPCION " + e.getMessage() + " \n " +  e.toString());
            lanzarPaginaError(e);  
         }
    }

	private void logStackTrace(Throwable e) throws Exception {
        traza("Se produjo la excepcion: " + e.getMessage());

        ByteArrayOutputStream pila = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(pila);

        if (e instanceof MareException) {
            MareException e2 = (MareException) e;
            traza("Es una mare Exception con codigo de error: " + e2.getCode());
        }

        e.printStackTrace(out);
        traza("stack Trace : " + pila.toString());
   }


    private void mostrarPaginaSeccion () throws Exception {
        traza(" === > entro a mostrarPaginaSeccion < === "); 
        DTOSeccion dtoSeccion = null;
        // Si estamos modificando la sección, mostramos los mensajes definidos en la misma        
        if ( oidSeccion != null && !oidSeccion.equals("") )
        {
            traza("Tiene definida una sección");
            // Recuperamos los datos de la sección para mostrarlos en pantalla
            MareBusinessID idBusiness = new MareBusinessID("MSGObtenerSeccion");

            //Crear DTOOID con:
            //  - oid = oidSeccion
            //  - idioma = idioma de la sesión
            //  - pais = pais de la sesión
            traza("dtoOid.oid = " + oidSeccion ); 
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(oidSeccion);
            dtoOid.setOidIdioma(idioma);
            dtoOid.setOidPais(pais);

            // Invocar a ConectorObtenerSeccion
            Vector paramConector = new Vector();
            paramConector.add(dtoOid);
            paramConector.add(idBusiness);
            dtoSeccion  = (DTOSeccion)conectar("ConectorObtenerSeccion", paramConector).objeto("DTOSeccion");
			ordenSecuencia = dtoSeccion.getOrdenSecuencia();
            asignarAtributo("CTEXTO", "txtCodigoSeccion", "valor", dtoSeccion.getCodigo());

            RecordSet recordSet = new RecordSet();
            recordSet.addColumn("oidMensaje");
            recordSet.addColumn("ordenImpresion");
            recordSet.addColumn("CodigoMensaje");
            recordSet.addColumn("texto");
            for ( Iterator it = dtoSeccion.getMensajes().iterator(); it.hasNext();) {
                DTOMensajeSeccion mensaje = (DTOMensajeSeccion) it.next();
                // Por cada DTOMensajeSeccion encontrado dentro de DTOSeccion, 
                // añade una fila a la lista listaMensajesSeccion con la información: 
                //  - oidMensaje (oculto) 
                //  - ordenImpresion 
                //  - texto
                Vector row = new Vector(); 
                row.add(mensaje.getOidMensaje());
                row.add(mensaje.getOrdenImpresion());
					 row.add(mensaje.getCodigoMensaje());
                row.add(mensaje.getTexto() );
                traza(" row : " + row );
                recordSet.addRow( row );
           }
            asignar("LISTADOA","listaMensajesSeccion",UtilidadesBelcorp.generarConector("dtoSalida", recordSet, recordSet.getColumnIdentifiers()),"dtoSalida");
        }

        traza("Asignando atributos");
        asignarAtributo("LABELC", "Seccion", "valor", numeroSeccion + " de " + numeroSecciones);
        // Carga el combo con el orden de las secciones
        cargarComboOrdenSecuencia();
    
        //Carga el combo con los metacaracteres de estructura
        cargarComboMetaEstructura(dtoSeccion);

        traza("asigno valores");
        traza("accion "+ accion);
        traza("numeroSeccion "+ numeroSeccion);
        traza("numeroSecciones "+ numeroSecciones);
        traza("oidSeccion "+ oidSeccion);
        traza("oidPatron "+oidPatron);
        traza("oidPeriodo "+oidPeriodo);
        traza("oidPatronOrigen "+oidPatronOrigen);
        traza("oidPatronPeriodo "+oidPatronPeriodo);
        traza("descripcionPais "+UtilidadesSession.getDescripcionPais(this));
        traza("codigoPatron "+codigoPatron);
        traza("descripcionPatron "+descripcionPatron);
        traza("oidMedioEnvio "+oidMedioEnvio);
		traza("oidFormulario "+oidFormulario);
        traza("activo "+activo);
        traza("patronPeriodo "+patronPeriodo);
        traza("pais_activo "+pais);
        traza("idioma_activo "+idioma);

        
        asignarAtributo("VAR", "accion", "valor", accion);
        asignarAtributo("VAR", "numeroSeccion", "valor", numeroSeccion);
        asignarAtributo("VAR", "numeroSecciones", "valor", numeroSecciones.toString());        
        if ( oidSeccion != null ) asignarAtributo("VAR", "oidSeccion", "valor", oidSeccion.toString());
        if ( oidPatron != null )  asignarAtributo("VAR", "oidPatron", "valor", oidPatron.toString());
        if ( oidPeriodo != null ) asignarAtributo("VAR", "oidPeriodo", "valor", oidPeriodo.toString());
        if ( oidPatronOrigen != null ) asignarAtributo("VAR", "oidPatronOrigen", "valor", oidPatronOrigen.toString());
        if ( oidPatronPeriodo != null ) asignarAtributo("VAR", "oidPatronPeriodo", "valor", oidPatronPeriodo.toString());
        asignarAtributo("VAR", "descripcionPais", "valor", UtilidadesSession.getDescripcionPais(this));
        asignarAtributo("VAR", "codigoPatron", "valor", codigoPatron);
        asignarAtributo("VAR", "descripcionPatron", "valor", descripcionPatron);
        if ( oidMedioEnvio != null ) asignarAtributo("VAR", "oidMedioEnvio", "valor", oidMedioEnvio.toString());
		if ( oidFormulario != null ) asignarAtributo("VAR", "oidFormulario", "valor", oidFormulario.toString());
        asignarAtributo("VAR", "activo", "valor", activo.booleanValue()? "S": "N");
        asignarAtributo("VAR", "patronPeriodo", "valor", patronPeriodo.booleanValue()? "S": "N");
        asignarAtributo("VAR", "pais_activo", "valor", pais.toString());
        asignarAtributo("VAR", "idioma_activo", "valor", idioma.toString());
        
        traza(" === > sale de mostrarPaginaSeccion < === "); 
    }

    /**
     * Carga el combo cbOrdenSecuencia con tantos valores como número de secciones 
     * tenga el patrón. (Parámetro numeroSecciones recibido en la LP).
     */
    private void cargarComboOrdenSecuencia () throws Exception {
        traza(" === cargarComboOrdenSecuencia () === ");
    	RecordSet rs = new RecordSet();
    	prepararRecordSet(rs);


    	DruidaConector druidaConector = UtilidadesBelcorp.generarConector("ROWSET",rs,rs.getColumnIdentifiers());
    	asignar("COMBO","cbOrdenSecuencia",druidaConector,"ROWSET");
		traza("ordenSecuencia: " + ordenSecuencia);

        if ( oidSeccion != null )
            asignarAtributo("VAR", "hddnOrdenInicial", "valor",  String.valueOf(ordenSecuencia.intValue()+1));
        else {
            asignarAtributo("VAR", "hddnOrdenInicial", "valor", ConstantesMSG.AL_FINAL);
				//asignarAtributo("VAR", "hOrdenInicialHabilitado", "valor", "N");
				asignarAtributo("VAR", "hOrdenInicialHabilitado", "valor", "S"); //BELC300013514 01/06/2006
		}
    }
    
	private void prepararRecordSet(RecordSet record){
		record.addColumn("OID");
		record.addColumn("DESC");

        Vector vectorFila = null;

        for(int i=0; numeroSecciones != null && i < numeroSecciones.intValue(); i++) {
    		vectorFila = new Vector(); 
            vectorFila.add(String.valueOf(i+1));
            vectorFila.add(String.valueOf(i+1));
            record.addRow(vectorFila);
        }
		vectorFila = new Vector(); 
		vectorFila.add(ConstantesMSG.AL_FINAL);
		vectorFila.add(ConstantesMSG.AL_FINAL);
		record.addRow(vectorFila);	
	}

    private  void cargarComboMetaEstructura(DTOSeccion dtoSeccion) throws Exception {
        //Documentation
        //Crear un DTOBelcorp dtoe con: 
        //- pais = Pais activo 
        //- idioma = Idioma del usuario 
        traza( " === entro a cargarComboMetaEstructura() === ");
        DTOBelcorp dtoe = new DTOBelcorp();
        dtoe.setOidPais(UtilidadesSession.getPais(this));
        dtoe.setOidIdioma(UtilidadesSession.getIdioma(this));

        traza("Crear una lista ComposerViewElementList");
        ComposerViewElementList cvList = new ComposerViewElementList();

        traza("Crear un elemento de tipo ComposerViewElement() para cargar los metacaracteres de estructura"); 
        ComposerViewElement elem = new ComposerViewElement();
        elem.setIDBusiness("MSGObtenerMetacaracterEstructura");//elem.IDBusiness="MSGObtenerMetacaracterEstructura"; 
        elem.setDTOE(dtoe); //elem.DTOE=dtoe;
        traza("Añadir el elemento a la lista");
        cvList.addViewElement(elem);

        traza("Invocar al subsistema GestorCargaPantalla"); 
        ConectorComposerView conector = new ConectorComposerView(cvList, this.getRequest());
        conector.ejecucion();

        DruidaConector resultados = conector.getConector();
        
        traza("Asigna la combo: hay resultado -> " + resultados.hayMas()); 
        //- cbMetacaracteresEstructura 
        asignar("COMBO", "cbMetacaracteresEstructura", resultados, "MSGObtenerMetacaracterEstructura");
        traza ("Cargo cbMetacaracteresEstructura");
        if ( dtoSeccion != null && oidSeccion != null  && dtoSeccion.getOidMetacaracter() != null) {
            //  Selecciona en el combo cbMetacaracteresEstructura la descripción 
            //  asociada el valor DTOSeccion.oidMetacaracter
            traza("Asigno el valor inicial a cbMetacaracteresEstructura ");            
            asignarAtributo("VAR", "hddnMetacaracter", "valor", dtoSeccion.getOidMetacaracter().toString() );
        }
        
        traza( " === salio de cargarComboMetaEstructura() === ");
        
    }

    /*
     * Este método define que acción realizar (guardarSeccion, actualizarSeccion y guardarPatron) 
     * en función de los parámetros oidPatron y oidSeccion
     */
    private void definirAccion() throws Exception {
        Boolean correcto = comprobarOrdenImpresion();
        
        if ( correcto.equals(Boolean.TRUE) )
        {
            // Comprobamos si estamos creando o actualizando la sección
            if ( oidSeccion == null ) { // La estamos creando
                // Comprobamos si vamos a guardar la primera sección del patrón
                if (  oidPatron == null ) { // Primera sección del patrón
                    // Primero guardamos el patron
                    oidPatron = guardarPatron();
                }
                // Creamos la sección
                oidSeccion = guardarSeccion(oidPatron); 
					 traza("despues de guardarSeccion");
            }
            else {   // Actualizamos la sección 
                modificarSeccion(oidSeccion, oidPatron);
            }
            traza("--> se actualizo la seccion <--");    
        
            //Si no se produce ningún error al guardar
            regresar(oidPatron);   
        }
        else {
            traza("--> orden incorrecto <---"); 
            //Muestra un mensaje de error: MSG-0003
			asignarAtributo("VAR", "cerrarVentana", "valor", "false");
        	asignarAtributo("VAR", "ejecutar", "valor", "guardarOK(-1,-1,'1426')"); 
        }
    }

    private Boolean comprobarOrdenImpresion () throws Exception  {
        String strOrdenImpresion = conectorParametro("hddnOrdenesImpresion");
        traza("strOrdenes : "+ strOrdenImpresion    );
        int ordenes[] = null;
        if ( strOrdenImpresion != null ) {
            StringTokenizer st = new StringTokenizer(strOrdenImpresion, "\r\n");
            ordenes = new int[st.countTokens()];
            for ( int i = 0; i < ordenes.length; i ++ )
                ordenes[i] = Integer.parseInt(st.nextToken());
                
            boolean contieneOrden[] = new  boolean[ordenes.length];            
            for ( int i=0; i < ordenes.length; i++ )
                contieneOrden[i] = false;
                
            for ( int i=0; i < ordenes.length; i++) {
                if ( ordenes[i] < 1 || ordenes[i] > ordenes.length ) 
                    return Boolean.FALSE; // No cumple con los valores min o max.
                
                if ( contieneOrden[ordenes[i]-1] )
                    return Boolean.FALSE; //Orden Repetido

                contieneOrden[ordenes[i]-1] = true;
            }

            for ( int i=0; i < ordenes.length; i++ )
                if ( !contieneOrden[i] )
                    return Boolean.FALSE;

            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    private Long guardarPatron () throws Exception {
        traza("guardarPatron()");
    	DTOPatron dtoPatron = crearDTOPatron();

		traza("Este es el DTO que se manda a guardar: " + dtoPatron);

        //Crea idBusiness = "MSGGuardarPatron"
        MareBusinessID idBusiness = new MareBusinessID("MSGGuardarPatron");
    
        //Invoca a ConectorGuardarPatron y recibe un DTOPatron
        Vector paramConector = new Vector();
        paramConector.add(dtoPatron);
        paramConector.add(idBusiness);
		  DruidaConector con = conectar("ConectorGuardarPatron", paramConector);
        //dtoPatron  = (DTOPatron)conectar("ConectorGuardarPatron", paramConector).objeto("DTOPatron");
		  traza("guardooooo");
		  dtoPatron  = (DTOPatron)con.objeto("DTOPatron");
        oidPatron = dtoPatron.getOidPatron();
		  traza("oid de retorno: "+dtoPatron.getOidPatron());
        oidPatronPeriodo = dtoPatron.getOidPatronPeriodo();

		traza("Este es el oidPatronPeriodo que retorno: " + oidPatronPeriodo);
        
        return oidPatron;        
    }

    /**
      * Crea un DTOPatron con los atributos:
      *   - DTOPatron.pais = oidPais activo
      *   - DTOPatron.codigo = codigoPatron (Recibido en la LP como parámetro)
      *   - DTOPatron.descripcion = descripcionPatron (Recibido en la LP como parámetro)
      *   - DTOPatron.oidFormulario = oidFormulario (Recibido en la LP como parámetro)
      *   - DTOPatron.oidMedioEnvio = oidMedioEnvio (Recibido en la LP como parámetro)
      *   - DTOPatron.activo = activo (Recibido en la LP como parámetro)
      *   - DTOPatron.patronPeriodo = patronPeriodo (Recibido en la LP como parámetro)
      *   - DTOPatron.oidPeriodo = oidPeriodo (Recibido en la LP como parámetro)
      *   - DTOPatron.oidPatronOrigen = oidPatronOrigen (Recibido en la LP como parámetro)
      *   - DTOPatron.oidPatron = Null
      *   - DTOPatron.oidPatronPeriodo = Null
     */
    private DTOPatron crearDTOPatron() throws Exception {
        DTOPatron dtoPatron = new DTOPatron();
        dtoPatron.setOidPais(pais);
        dtoPatron.setCodigo(codigoPatron);
        dtoPatron.setDescripcion(descripcionPatron);
        dtoPatron.setOidFormulario(oidFormulario);
        dtoPatron.setOidMedioEnvio(oidMedioEnvio);
        dtoPatron.setActivo(activo);
        dtoPatron.setPatronPeriodo(patronPeriodo);
        dtoPatron.setOidPeriodo(oidPeriodo);
        dtoPatron.setOidPatronOrigen(oidPatronOrigen);
        dtoPatron.setOidPatron(null);
        dtoPatron.setOidPatronPeriodo(null);

        return dtoPatron;
    }

    private Long guardarSeccion (Long oidPatron) throws Exception {
        traza("guardarSeccion()");
        DTOSeccion dtoSeccion = crearDTOSeccion(null, oidPatron); 
    
        //Crear idBusiness = "MSGGuardarSeccion"
        MareBusinessID idBusiness= new MareBusinessID("MSGGuardarSeccion");

        //Invocar a ConectorGuardarSeccion 
        //Recibe un DTOOID y devuelve DTOOID.oid
        Vector paramConector = new Vector();
        paramConector.add(dtoSeccion);
        paramConector.add(idBusiness);
		  traza("antes de guardar");
		  //DruidaConector con = conectar("ConectorGuardarSeccion", paramConector);
		  DruidaConector con = conectar("ConectorObjetoGenerico", paramConector);
		  traza("guardo");
		  DTOOID dtoOID  = (DTOOID) con.objeto("DTOSalida");
		  //String dtoOID  = (String) con.objeto("DTOOID");
        traza("dto: "+dtoOID);
		  //DTOOID dtoOID  = (DTOOID)conectar("ConectorGuardarSeccion", paramConector).objeto("DTOOID");

			//return null;
        return dtoOID.getOid();
    }

    private  DTOSeccion crearDTOSeccion (Long oidSeccion, Long oidPatron) throws Exception {
/*  Crea un DTOSeccion con los atributos:
      - DTOSeccion.oidSeccion = oidSeccion (Parametro entrada)
      - DTOSeccion.oidPatron = oidPatron (Parametro entrada)
      - DTOSeccion.codigo = Introducido en pantalla
      - DTOSeccion.ordenSecuencia = Posición (comenzando por 1) del valor seleccionado en el combo cbOrdenSecuencia. 
      - DTOSeccion.oidMetacaracter = oid del valor introducido en pantalla a través de la cbMetacaracteresEstructura
*/    
        DTOSeccion dtoSeccion = new DTOSeccion();
        dtoSeccion.setOidSeccion(oidSeccion);
        dtoSeccion.setOidPatron(oidPatron);
        dtoSeccion.setCodigo(conectorParametro("txtCodigoSeccion"));
		if (oidSeccion == null) {
			dtoSeccion.setOrdenSecuencia(new Integer(obtenerParametroOrdenSecuencia().intValue()) );
		} else {
			dtoSeccion.setOrdenSecuencia(new Integer(obtenerParametroOrdenSecuencia().intValue() -1) );
		}
        dtoSeccion.setOidMetacaracter(conectorParametroLong("cbMetacaracteresEstructura"));          
    
        String strOidMensajes = conectorParametro("hddnOidMensajes");
        traza("strOidMensajes : "+ strOidMensajes);
        String strOrdenesImpresion = conectorParametro("hddnOrdenesImpresion");
        traza("strOrdenesImpresion : "+ strOrdenesImpresion);
        String strCodMensajes = conectorParametro("hddnCodMensajes");
        traza("strCodMensajes : "+ strCodMensajes);
        String strTextoMensajes = conectorParametro("hddnTextoMensajes");
        traza("strTextoMensajes : "+ strTextoMensajes);
        if ( strOrdenesImpresion != null ) { // Hay Filas
				traza("hay filas");
            StringTokenizer stOidMensajes = new StringTokenizer(strOidMensajes, "\r\n");
            StringTokenizer stOrdenesImpresion = new StringTokenizer(strOrdenesImpresion, "\r\n");
            StringTokenizer stCodMensajes = new StringTokenizer(strCodMensajes, "\r\n");
				StringTokenizer stTextoMensajes = new StringTokenizer(strTextoMensajes, "\r\n");
            ArrayList mensajes = new  ArrayList();
            while ( stOidMensajes.hasMoreTokens() ) {
                Long oidMensaje = new Long(stOidMensajes.nextToken());
					 traza("oidMensaje: "+oidMensaje);
                Integer ordenImpresion = new Integer(stOrdenesImpresion.nextToken());
					 traza("ordenImpresion: "+ordenImpresion.toString());
 					 String codMsg = stCodMensajes.nextToken();
					 traza("codMsg: "+codMsg);
                String texto = stTextoMensajes.nextToken();
					 traza("texto: "+texto);
                // Por cada mensaje añadido a la lista listaMensajesSeccion creamos un DTOMensajeSeccion con los atributos:
                // - DTOMensajeSeccion.oidMensaje = oid del mensaje (columna oculta)
                // - DTOMensajeSeccion.ordenImpresion = orden de impresión del mensaje (primera columna)
                // - DTOMensajeSeccion.texto = texto fijo y datos variables del mensaje (segunda columna)
                DTOMensajeSeccion dtoMensajeSeccion = new DTOMensajeSeccion();
                dtoMensajeSeccion.setOidMensaje( oidMensaje );
                dtoMensajeSeccion.setOrdenImpresion(ordenImpresion);
                dtoMensajeSeccion.setCodigoMensaje(codMsg);
					 dtoMensajeSeccion.setTexto(texto);

                // Añadimos todos los DTOMensajeSeccion creados al DTOSeccion.
                mensajes.add(dtoMensajeSeccion);
            }
            dtoSeccion.setMensajes(mensajes);
        }
        //Devuelve el DTOSeccion
        return dtoSeccion;
    }

    private void regresar (Long oidPatron) throws Exception {
        traza("guardarRegresar()");
        // Asigna la pagina PGVentanaOcultaPatron y pasa el parámetro: 
        // - oidPatron 
        // - oidPatronPeriodo 
        asignarAtributo("VAR", "ejecutar", "valor", "guardarOK("+oidPatron.toString()+","+oidPatronPeriodo+" )"); 
        
    }

    private void modificarSeccion (Long oidSeccion, Long oidPatron) throws Exception {
        traza("---> modificarSeccion <---"); 
        DTOSeccion dtoSeccion = crearDTOSeccion(oidSeccion, oidPatron);

        // Crear idBusiness = "MSGModificarSeccion"
        MareBusinessID idBusiness = new MareBusinessID("MSGModificarSeccion");
        
        // Invocar a ConectorModificarSeccion 
        Vector paramConector = new Vector();
        paramConector.add(dtoSeccion);
        paramConector.add(idBusiness);        
        conectar("ConectorModificarSeccion", paramConector);
    }

    private Long conectorParametroLimpiaLong(String parametro) throws Exception {
        String paramObt = conectorParametroLimpia( parametro, "", true );
        traza("conectorParametroLimpiaLong --> " + parametro + " : " + paramObt );
        return paramObt != null && !paramObt.equals("")? new Long(paramObt): null;
    }

    private Integer conectorParametroLimpiaInteger(String parametro) throws Exception {
        String paramObt = conectorParametroLimpia( parametro, "", true );
        traza("conectorParametroLimpiaLong --> " + parametro + " : " + paramObt );
        return paramObt != null && !paramObt.equals("")? new Integer(paramObt): null;
    }

    private Boolean conectorParametroLimpiaBoolean(String parametro) throws Exception {
        String paramObt = conectorParametroLimpia( parametro, "", true );
        traza("conectorParametroLimpiaBoolean --> " + parametro + " : " + paramObt );
        return paramObt != null && paramObt.equalsIgnoreCase("S")? Boolean.TRUE: Boolean.FALSE;
    }
    
	private Integer obtenerParametroOrdenSecuencia() throws Exception {
        String paramObt = conectorParametro( "cbOrdenSecuencia");
		traza("casoUsoPatron: " + casoUsoPatron);
        traza("cbOrdenSecuencia : " + paramObt );
        if ( paramObt != null && paramObt.equalsIgnoreCase(ConstantesMSG.AL_FINAL) )
				return new Integer(numeroSecciones.intValue());
            //return new Integer(numeroSecciones.intValue()+1);
        return paramObt != null && !paramObt.equals("")? new Integer(paramObt): null;
    }

    private Long conectorParametroLong(String parametro) throws Exception {
        String paramObt = conectorParametro( parametro);
        traza("conectorParametroLong --> " + parametro + " : " + paramObt );
        return paramObt != null && !paramObt.equals("")? new Long(paramObt): null;
    }

    private Integer conectorParametroInteger(String parametro) throws Exception {
        String paramObt = conectorParametro( parametro);
        traza("conectorParametroInteger --> " + parametro + " : " + paramObt );
        return paramObt != null && !paramObt.equals("")? new Integer(paramObt): null;
    }

}

