import es.indra.druida.DruidaConector;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.presentacion.rastreador.IRastreador;
import es.indra.sicc.cmn.presentacion.rastreador.Rastreador;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;
import es.indra.sicc.dtos.msg.DTOMensaje;
import es.indra.sicc.dtos.msg.DTODestinatario;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.BelcorpError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.NumberFormatException;
import java.lang.reflect.Array;

import java.sql.Date;


import java.util.Enumeration;
import java.util.StringTokenizer;
import java.util.Vector;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.dtos.msg.ConstantesMSG;
import es.indra.sicc.util.DTOBoolean;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import es.indra.sicc.util.UtilidadesError;
import java.text.*;


public class LPMantenimientoMensajes extends LPSICCBase {

    static final String INSERTAR_MENSAJE = "Insertar mensaje";
    static final String MODIFICAR_MENSAJE = "Modificar mensaje";
    static final String ELIMINAR_MENSAJE = "Eliminar mensaje";
    static final String CONSULTAR_MENSAJE = "Consultar mensaje";
    static final String ACEPTAR_MENSAJE = "Aceptar mensaje";
    static final String DETALLE_MENSAJE = "Detalle mensaje";

    private Long pais;
    private String accion;
    private String opcionMenu;
    private String oidMensaje;
    private String oidModulo;
    private String codigoMensaje;
    private String oidTipoMensaje;
    private String descripcionMensaje;
    private String oidGeneracionDatos;
    private String bloque;
    private String oidPermanenciaMensaje;
    private String permanenciaDesde;
    private String permanenciaHasta;
    private String oidPeriodoDesde;
    private String oidPeriodoHasta;
    private String textoMensaje;
    private String numeroVariables;
    private String unidadAdministrativa;
    private String tipoCliente;
    private String marca;
    private String codigoVenta;
    private String pedido;
    private String programa;
    private String consultoras = null;
    private String casoDeUso = null;
    private String descTipoMensaje;
    //Los oids seleccionados en el combo Tipos Destinatarios
    private String oidsTiposDestinatarios;
    private String asignacionDestinatario;
	private String exclusionTipologia;



    public LPMantenimientoMensajes() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        //PGDatosMensaje
        pagina("contenido_mensajes_insertar");
    }

    public void ejecucion() throws Exception {
    
      setTrazaFichero();

      try{
        
        accion = conectorParametroLimpia( "accion", "", true );
        opcionMenu = conectorParametroLimpia( "opcionMenu", "", true );
        casoDeUso  = conectorParametroLimpia( "casoDeUso", "", true );

        traza( "LPMANTENIMIENTOMENSAJES -- METODO EJECUCION" );

        traza( "--> accion: " + accion );
        traza( "--> opcionMenu: " + opcionMenu );
        traza( "--> casoDeUso: " + casoDeUso );

        generarHiddenFormatoFecha();

        if( accion.equals("") ){
          inicializar();
        } else if( accion.equals( LPMantenimientoMensajes.ACEPTAR_MENSAJE ) ){
          comprobarMensaje();
        } else if( accion.equals( LPMantenimientoMensajes.MODIFICAR_MENSAJE ) ){
          modificarMensaje();
        } else if( accion.equals( LPMantenimientoMensajes.DETALLE_MENSAJE ) ){
          consultarMensaje();
        }

        traza( "--> SE VA A ASIGNAR A PAGINA OPCION MENU: " + opcionMenu );
		
		/* 13-11-2004*/
          asignarAtributo( "VAR", "opcionMenu", "valor", opcionMenu );
		      asignarAtributo( "VAR", "hCasoDeUso", "valor", casoDeUso );

      } catch( Exception e ){
        
        traza( e.toString() );
        logStackTrace( e );
      
      
        lanzarPaginaError( e );
        //this.inicializar();
        
      }
    }

    //**************************************************************************


  private void inicializar() throws Exception {

    traza( "opcionMenu: " + opcionMenu );

    //guarda el formato de fecha para el pais con el que se esta logueado.
    //generarHiddenFormatoFecha();

    if( opcionMenu.equals( LPMantenimientoMensajes.INSERTAR_MENSAJE ) ){

      traza( "ENTRO POR INSERTAR MENSAJE" );
      
      cargarPGDatosMensaje();
      asignarAtributoPagina("cod", "0361");
      getConfiguracionMenu( "LPMantenimientoMensajes", "insertar" );
      
    } else if( opcionMenu.equals( LPMantenimientoMensajes.MODIFICAR_MENSAJE ) ){

      traza( "ENTRO POR MODIFICAR MENSAJE" );
    
      cargarPGBuscarMensajes();

      traza( "paso cargarPGBuscarMensajes()" );

      asignarAtributoPagina( "cod", "0374" );

      asignarAtributo( "VAR", "hCasoDeUso", "valor", LPMantenimientoMensajes.MODIFICAR_MENSAJE );

      //flag para habilitar boton en javascript
      //asignarAtributo( "VAR", "hHabilitarBtBuscar", "valor", "S" ); 

      //flag para ocultar lista de resultados en javascript
      //asignarAtributo( "VAR", "hOcultarListaResultados", "valor", "s" );

      //flag para ocultar boton en javascript
      //asignarAtributo( "VAR", "hOcultarBtDetalle", "valor", "S" );

      getConfiguracionMenu( "LPMantenimientoMensajes", "modificar" );

    } else if( opcionMenu.equals( LPMantenimientoMensajes.ELIMINAR_MENSAJE ) ){

      traza( "ENTRO POR ELIMINAR MENSAJE" );

      cargarPGBuscarMensajes();

      asignarAtributoPagina( "cod", "0375" );

      asignarAtributo( "VAR", "hCasoDeUso", "valor", LPMantenimientoMensajes.ELIMINAR_MENSAJE );
      asignarAtributo( "VAR", "opcionMenu", "valor", LPMantenimientoMensajes.ELIMINAR_MENSAJE );

      //flag para habilitar boton en javascript
      asignarAtributo( "VAR", "hHabilitarBtBuscar", "valor", "S" ); 

      //flag para ocultar lista de resultados en javascript
      asignarAtributo( "VAR", "hOcultarListaResultados", "valor", "s" );

      //flag para ocultar boton en javascript
      asignarAtributo( "VAR", "hOcultarBtDetalle", "valor", "S" );

      getConfiguracionMenu( "LPMantenimientoMensajes", "eliminar" );
      
    } else if( opcionMenu.equals( LPMantenimientoMensajes.CONSULTAR_MENSAJE ) ){

      traza( "====> entro a CONSULTAR_MENSAJE" );

      // yyy - la llamada a este metodo figura en diseno, pero no su implementacion
      //cargarPaginaBuscarPatrones();
      cargarPGBuscarMensajes();

      asignarAtributoPagina( "cod", "0376" );

      asignarAtributo( "VAR", "hCasoDeUso", "valor", LPMantenimientoMensajes.CONSULTAR_MENSAJE );

      //flag para habilitar boton en javascript
      asignarAtributo( "VAR", "hHabilitarBtBuscar", "valor", "S" ); 

      //flag para ocultar lista de resultados en javascript
      asignarAtributo( "VAR", "hOcultarListaResultados", "valor", "s" );

      //flag para ocultar boton en javascript
      asignarAtributo( "VAR", "hOcultarBtModificar", "valor", "S" );

      getConfiguracionMenu( "LPMantenimientoMensajes", "consultar" );
    }
  }

  private void cargarPGDatosMensaje() throws Exception {
  
     
    traza( "ENTRO A cargarPGDatosMensaje" );
    DTOBelcorp dtoe = new DTOBelcorp();
    traza("paso 1");
    dtoe.setOidPais( UtilidadesSession.getPais( this ) );
    traza("paso 2");
    dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );
    traza("paso 3");

    ComposerViewElementList lista = new ComposerViewElementList();
    traza("paso 4");
    ComposerViewElement elem = null;
    traza("paso 5");

    String[] bids = { "MSGObtenerMetacaracteres",
                      "SEGObtenerModulos",
                      "MSGObtenerTiposMensaje",
                      "MSGObtenerTiposPermanencia",
                      "SEGObtenerTiposPeriodo",
                      "MSGObtenerTiposDestinatario"
                   
                    };
    traza("paso 6");
    for( int i = 0; i < bids.length; i++ ){
      elem = new ComposerViewElement();
      elem.setIDBusiness( bids[i] );
      elem.setDTOE( dtoe );
      traza("el dto es " + elem.getDTOE());
      traza("el id negocio " + elem.getIDBusiness());
      lista.addViewElement( elem );
    }
   
		//Utilizamos el subsistema
    ConectorComposerView conector = null;
    DruidaConector resultados = null;
       
    conector = new ConectorComposerView(lista, this.getRequest());
    traza("paso 10");
    conector.ejecucion();
    traza("paso 11");
    resultados = null;
    traza("paso 12");
    resultados = conector.getConector();
    traza("paso 13");

    //this.asignarAtributo( "LABELC", "lblvalorPais", "valor", UtilidadesSession.getDescripcionPais( this ) );
    
    asignar("COMBO", "cbMetacaracteresControlFormato", resultados, "MSGObtenerMetacaracteres");
    asignar("COMBO", "cbModulo", resultados, "SEGObtenerModulos");
    asignar("COMBO", "cbTipoMensaje", resultados, "MSGObtenerTiposMensaje");
    asignar("COMBO", "cbPermanenciaMensaje", resultados, "MSGObtenerTiposPermanencia");
    asignar("COMBO", "cbTipoPeriodo", resultados, "SEGObtenerTiposPeriodo");
    asignar("COMBO", "cbAsignacionDestinatarios", resultados, "MSGObtenerTiposDestinatario");

    //Enviar a pagina
    
    asignarAtributo( "VAR", "opcionMenu", "valor", (opcionMenu==null ? "" : opcionMenu) );
    asignarAtributo( "VAR", "accion", "valor", (accion==null ? "" : accion) );
    asignarAtributo( "VAR", "hOidMensaje", "valor", (oidMensaje==null ? "" : oidMensaje) );
    asignarAtributo( "VAR", "hOidPermanenciaH", "valor", (ConstantesMSG.OID_PERMANENCIA_H==null ? "" : ConstantesMSG.OID_PERMANENCIA_H.toString()) );
    asignarAtributo( "VAR", "hOidPermanenciaR", "valor", (ConstantesMSG.OID_PERMANENCIA_R==null ? "" : ConstantesMSG.OID_PERMANENCIA_R.toString()) );
    asignarAtributo("VAR", "cteOidPedido", "valor", ConstantesMSG.OID_PEDIDO.toString());
	asignarAtributo("VAR", "cteOidConsultora", "valor", ConstantesMSG.OID_CONSULTORAS.toString());
	asignarAtributo("VAR", "cteOidTipoG1", "valor", ConstantesMSG.OID_TIPO_G1.toString());
    asignarAtributo("VAR", "cteOidTipoG2", "valor", ConstantesMSG.OID_TIPO_G2.toString());
    
	/*  inicio CAMBIO MSG 002 - pperez  */
    asignarAtributo("VAR", "cteOidUA", "valor", ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA.toString());
    asignarAtributo("VAR", "cteOidClasiClien", "valor", ConstantesMSG.OID_CLASIFICACION_CLIENTE.toString());
	/*  fin CAMBIO MSG 002 - pperez  */
	

	asignarAtributo( "VAR", "lblvalorPais", "valor", UtilidadesSession.getDescripcionPais( this ) );
  }

  private void comprobarMensaje() throws Exception {

    traza( "ENTRO A comprobarMensaje " + opcionMenu );

    obtenerDatosPrincipales();

    if( opcionMenu.equals( LPMantenimientoMensajes.INSERTAR_MENSAJE ) || 
        opcionMenu.equals( LPMantenimientoMensajes.MODIFICAR_MENSAJE ) ){ // agregado
          
        guardarMensaje();

    } else{

      oidMensaje = conectorParametroLimpia( "oidMensaje", "", true );
        
    }

    traza("el oid tipo mensaje es " + oidTipoMensaje);
    if(consultoras != null && consultoras.equals("S") ){         
       if((oidTipoMensaje != null) && (oidTipoMensaje.equals(ConstantesMSG.OID_TIPO_G1.toString()))){
          traza("**************************entro en COnsultora");
         
          asignarAtributo("VAR", "ejecutar", "valor", "enviarConsultoras("+ oidMensaje +")");

         /* conectorAction( "LPMantenimientoConsultoras");
          conectorActionParametro("accion", "" );
          conectorActionParametro("oidMensaje", oidMensaje);
          conectorActionParametro("opcionMenu", "Insertar mensaje");*/
       }

    }else{
       traza("pedido " + pedido);
       if(     (pedido == null || !pedido.equals("S"))      ||
               (unidadAdministrativa != null   && unidadAdministrativa.equals("S"))  ||
		       (tipoCliente != null   && tipoCliente.equals("S")))     {    /* CAMBIO MSG 002 - pperez  */

          if(opcionMenu.equals("Consultar mensaje") || (opcionMenu.equals("Eliminar mensaje"))){
             conectorAction( "LPDestinatarios" );
             traza( "VALOR DE OPCIONMENU AL LLAMAR A LPDestinatarios: " + (opcionMenu==null ? "" : opcionMenu) );
             traza( "----------------------------------" );
             traza( "oidMensaje a enviar: " + oidMensaje );
             traza( "----------------------------------" );


             conectorActionParametro( "opcionMenu", (opcionMenu==null ? "" : opcionMenu) );
             conectorActionParametro( "accion", "" );
             conectorActionParametro( "oidMensaje", (oidMensaje==null ? "" : oidMensaje) );
             conectorActionParametro( "oidTipoMensaje", (oidTipoMensaje==null ? "" : oidTipoMensaje) );
             conectorActionParametro( "unidadAdministrativa", (unidadAdministrativa==null ? "" : unidadAdministrativa) );
             conectorActionParametro( "tipoCliente", (tipoCliente==null ? "" : tipoCliente) );
             conectorActionParametro( "marca", (marca==null ? "" : marca) );
             conectorActionParametro( "codigoVenta", (codigoVenta==null ? "" : codigoVenta) );
             conectorActionParametro( "pedido", (pedido==null ? "" : pedido) );
             conectorActionParametro( "consultoras", (consultoras==null ? "" : consultoras) );
 
          }else{
        
             String param1 = opcionMenu==null ? "" : opcionMenu;
             String param2 = oidMensaje==null ? "" : oidMensaje;
             String param3 = oidTipoMensaje==null ? "" : oidTipoMensaje;
             String param4 = unidadAdministrativa==null ? "" : unidadAdministrativa;
             String param5 = tipoCliente==null ? "" : tipoCliente;
             String param6 = marca==null ? "" : marca;
             String param7 = codigoVenta==null ? "" : codigoVenta;
             String param8 = pedido==null ? "" : pedido;
             String param9 = consultoras==null ? "" : consultoras;
             String param = new String();

             param =  "'" + param1 + "'," + 
                      "'" + param2 + "'," +
                      "'" + param3 + "'," +
                      "'" + param4 + "'," +
                      "'" + param5 + "'," +
                      "'" + param6 + "'," +
                      "'" + param7 + "'," +
                      "'" + param8 + "'," +
                      "'" + param9 + "'"; 
                  
             traza("los parametros son " + param);
        
             asignarAtributo( "VAR", "ejecutar", "valor", "enviar(" + param + ")" );
          }
       }else{
          if(opcionMenu.equals( LPMantenimientoMensajes.INSERTAR_MENSAJE )){
             asignarAtributo( "VAR", "ejecutar", "valor", "insertoPedidoOk()" );
          }else if(opcionMenu.equals( LPMantenimientoMensajes.MODIFICAR_MENSAJE ) ){
             asignarAtributo( "VAR", "ejecutar", "valor", "modificoPedidoOk()" );

          }
          
       }
    
    }
  }

  private boolean comprobarDatosPrincipales() throws Exception { 

    //Comprueba que los siguientes datos introducidos tienen algún valor: 
    if( !(
      textoMensaje           != null && textoMensaje.length() > 0 &&      
      oidModulo              != null && oidModulo.length() > 0 &&
      codigoMensaje          != null && codigoMensaje.length() > 0 &&
      oidTipoMensaje         != null && oidTipoMensaje.length() > 0 &&
      descripcionMensaje     != null && descripcionMensaje.length() > 0 &&
      oidPermanenciaMensaje  != null && oidPermanenciaMensaje.length() > 0 &&
      asignacionDestinatario != null && asignacionDestinatario.length() > 0 )){
           
      traza("oid modulo " + oidModulo);
      traza("oid tipo mensaje " + oidTipoMensaje);
      traza("codigo mensaje " + codigoMensaje);
      traza("descripcion mensaje " + descripcionMensaje);
      traza("texto mensaje " + textoMensaje);
      traza(" oid permanencia " + oidPermanenciaMensaje);
      traza("asignacion destinatario " + asignacionDestinatario);
      

      //mostrar mensaje error
      //lanzarPaginaError(  );
      throw new MareException( new Exception(), UtilidadesError.armarCodigoError( "290007" ) );
      //Esta validacion no es necesaria ya que se valida en la pagina.
      
    } else{
       traza(" devolvio true");
       return true;
    }

    
  }
  
  // Método que comprueba si el número de destinatarios excluyentes seleccionados es correcto 
  private boolean comprobarTiposDestinatario() throws Exception {

    DTOBoolean dtob = null;
    StringTokenizer st = null;
    Long[] oids = null;
    MareBusinessID id = null;
    DTOOIDs dtoOIDs = null;
    Vector param = null;
    DruidaConector con = null;
    
    //La variable 'oidsTiposDestinatarios' contiene los valores seleccionados del 
    //combo cbAsignaciónDestinatarios. se parsea y convierta a un array de Long.
    oidsTiposDestinatarios = conectorParametroLimpia( "hAsignacionDestinatarios", "", true );

    traza( "oidsTiposDestinatarios: " + (oidsTiposDestinatarios==null ? "null" : oidsTiposDestinatarios) );

    //Se crea el array de Long para asignar al DTOOIDs

    if( oidsTiposDestinatarios != null ){
    
      st = new StringTokenizer( oidsTiposDestinatarios, "," ); //yyy ver como es el separador

      if( st != null && st.countTokens() >=0 ){
        oids = new Long[st.countTokens()];
        int ind = 0;
    
        while( st.hasMoreTokens() ){
          oids[ind++] = new Long(st.nextToken());
        }
        //------- fin armar array.

        id = new MareBusinessID( "MSGComprobarDestinatariosExcluyentes" );
    
        dtoOIDs = new DTOOIDs();
        dtoOIDs.setOids( oids );

        param = new Vector();
        param.addElement( dtoOIDs );
        param.addElement( id );

        pagina( "salidaGenerica" );
        asignarAtributo("VAR", "cerrarVentana", "valor", "false");
         

        //this.asignarAtributo( "VAR", "ejecutar", "valor", "errorDestinatario()" );
        asignarAtributo( "VAR", "ejecutarError", "valor", "errorDestinatario()" );

        traza( "VA A COMPROBAR TIPOS DE DESTINATARIOS EXCLUYENTES" );
        con = conectar( "ConectorComprobarDestinatariosExcluyentes", param );
        traza("EXITO AL COMPROBAR TIPOS DE DESTINATARIOS EXCLUYENTES");

        if( con != null ){
           traza("entro");
          dtob = (DTOBoolean)con.objeto( "dtoSalida" );


          if( !dtob.getValor() ){
          }
          
          return dtob.getValor();
        }
      }
    }

    //si no se obtuvo el dto
    return false;
  }

  // Obtiene los datos generales del mensaje 
  private void obtenerDatosPrincipales() throws Exception {

    traza( "ENTRO A obtenerDatosPrincipales" );

    oidMensaje = conectorParametroLimpia( "oidMensaje", "", true );

    traza( "oidMensaje: " + oidMensaje );

    oidModulo          = conectorParametroLimpia("hModulo", "", true);
    traza("codigo mensaje es " + conectorParametroLimpia("hCodigoMensaje", "", true));
    codigoMensaje      = conectorParametroLimpia("hCodigoMensaje", "", true);
    oidTipoMensaje     = conectorParametroLimpia("hTipoMensaje", "", true);
    descTipoMensaje    = conectorParametroLimpia("hDescTipoMensaje", "", true);
    descripcionMensaje = conectorParametroLimpia("hDescMensaje", "", true);
    bloque             = conectorParametroLimpia("hBloqueGrupo", "", true);
        
    
    
    oidPermanenciaMensaje = conectorParametro( "hPermanenciaMensaje" );

    traza( "oidPermanenciaMensaje: " + (oidPermanenciaMensaje==null ? "null" : oidPermanenciaMensaje.toString() ) );
    traza( "ConstantesMSG.OID_PERMANENCIA_H: " + (ConstantesMSG.OID_PERMANENCIA_H==null ? "null" : ConstantesMSG.OID_PERMANENCIA_H.toString()) );

    if( oidPermanenciaMensaje.equals( ConstantesMSG.OID_PERMANENCIA_H.toString() ) ){

      traza( "ENTRO A RECUPERAR LOS PERIODOS" );
    
      oidPeriodoDesde = conectorParametroLimpia("hPeriodoDesde", "", true);
      oidPeriodoHasta = conectorParametroLimpia("hPeriodoHasta", "", true );
      permanenciaDesde = null;
      permanenciaHasta = null;
    }

    traza( "PASO RECUPERAR PERIODOS" );

    if( oidPermanenciaMensaje.equals( ConstantesMSG.OID_PERMANENCIA_R.toString() ) ){

      traza( "ENTRO A RECUPERAR LA PERMANENCIA" );
    
      permanenciaDesde = conectorParametroLimpia("txtPermanenciaDesde", "", true);
      permanenciaHasta = conectorParametroLimpia("txtPermanenciaHasta", "", true);
      oidPeriodoDesde = null;
      oidPeriodoHasta = null;
    }

    traza( "PASO RECUPERAR PERMANENCIA" );

    textoMensaje = conectorParametroLimpia("hTextoFijo", "", true);
    

    // Comprueba los elementos seleccionados en el combo cbAsignacionDestinatarios 
	traza("Esta es la asigancion que viene de la pagina: " + conectorParametro("hAsignacionDestinatarios"));
    asignacionDestinatario = conectorParametroLimpia("hAsignacionDestinatarios", "", true);

    traza( "asignacionDestinatario: " + (asignacionDestinatario==null ? "" : asignacionDestinatario) );

    if( asignacionDestinatario != null ){
    
      // Armar array con oids
      StringTokenizer st = new StringTokenizer( asignacionDestinatario, "," );
      String[] oids = new String[st.countTokens()];
      int ind = 0;
    
      while( st.hasMoreTokens() ){
        oids[ind++] = st.nextToken();
      }
      //-------------- fin armar array

      for( int i = 0; i < oids.length; i++ ){
        if( oids[i].equals( ConstantesMSG.OID_UNIDAD_ADMINISTRATIVA.toString() ) ){
          unidadAdministrativa = "S";
        }
        if( oids[i].equals( ConstantesMSG.OID_CLASIFICACION_CLIENTE.toString() ) ){
          tipoCliente = "S";
        }
        if( oids[i].equals( ConstantesMSG.OID_MARCA.toString() ) ){
          marca = "S";
        }
        if( oids[i].equals( ConstantesMSG.OID_CODIGO_VENTA.toString() ) ){
          codigoVenta = "S";
        }
        if( oids[i].equals( ConstantesMSG.OID_PEDIDO.toString() ) ){
          pedido = "S";
        }
     
        if( oids[i].equals( ConstantesMSG.OID_CONSULTORAS.toString() ) ){
          consultoras = "S";
        }
      }
    }

    exclusionTipologia = conectorParametro("hExclusionTipologia")==null?"":conectorParametro("hExclusionTipologia");
	traza( "exclusionTipologia: " + exclusionTipologia );

  }


  private DTOMensaje crearMensaje() throws Exception {

    DTOMensaje dto = new DTOMensaje();
    dto.setOidPais( UtilidadesSession.getPais( this ) );

    //--------------------------------------------------------------------------
    // PREPARAR FECHAS
    java.util.Date fDesde = null;
    java.util.Date fHasta = null;
    Date sqlFDesde = null;
    Date sqlFHasta = null;
    
    String formatoFecha = null;

    if( permanenciaDesde != null && permanenciaDesde.length() > 0 &&
    permanenciaHasta != null && permanenciaHasta.length() > 0  ){
    
      formatoFecha = conectorParametroLimpia( "hFormatoFechaPais", "", true );
      formatoFecha = formatoFecha.replace('m', 'M'); //minute por MONTH, viene solo fecha.

      fDesde = UtilidadesBelcorp.getDatefromSICCStringFormat( permanenciaDesde, formatoFecha );
      fHasta = UtilidadesBelcorp.getDatefromSICCStringFormat( permanenciaHasta, formatoFecha );
    }

    //--------------------------------------------------------------------------

    //auditoria
    dto.setIpCliente( UtilidadesBelcorp.getIPCliente( this ) );
    dto.setPrograma( UtilidadesSession.getFuncion( this ) );

    if( oidMensaje != null && oidMensaje.length() > 0 ){
      dto.setOidMensaje( new Long( oidMensaje ) );
    }

    if( oidModulo != null && oidModulo.length() > 0 )
      dto.setOidModulo( new Long( oidModulo ) );

    if( codigoMensaje != null && codigoMensaje.length() > 0 )
      dto.setCodigo( codigoMensaje.toUpperCase() );

    if( oidTipoMensaje != null && oidTipoMensaje.length() > 0 )
      dto.setOidTipoMensaje( new Long( oidTipoMensaje ) );

    if( descripcionMensaje != null && descripcionMensaje.length() > 0 )
      dto.setDescripcion( descripcionMensaje );
    
    if( bloque != null && bloque.length() > 0 )
      dto.setBloque( bloque );

    if( oidPermanenciaMensaje != null && oidPermanenciaMensaje.length() > 0 )
      dto.setOidPermanencia( new Long( oidPermanenciaMensaje ) );


    if( permanenciaDesde != null && permanenciaDesde.length() > 0 ){
      //dto.setPermanenciaDesde( Date.valueOf( permanenciaDesde ) );
      dto.setPermanenciaDesde( fDesde );
    }

    if( permanenciaHasta != null && permanenciaHasta.length() > 0 ){
      //dto.setPermanenciaHasta( Date.valueOf( permanenciaHasta ) );
      dto.setPermanenciaHasta( fHasta );
    }


    if( textoMensaje != null && textoMensaje.length() > 0 )
      dto.setTexto( textoMensaje );

    if( oidPeriodoDesde != null && oidPeriodoDesde.length() > 0 )
      dto.setOidPeriodoDesde( new Long( oidPeriodoDesde ) );

    if( oidPeriodoHasta != null && oidPeriodoHasta.length() > 0 )
      dto.setOidPeriodoHasta( new Long( oidPeriodoHasta ) );
   
	if (exclusionTipologia.equals("") || exclusionTipologia.equals("N")) {
		dto.setExclusionTipologia(new Boolean(false));
	} else {
		dto.setExclusionTipologia(new Boolean(true));
	}

    return dto;
  }

  // Guarda o Modifica un mensaje 
  private void guardarMensaje() throws Exception {

    MareBusinessID id   = null;
    MareBusinessID idEx   = null;
    DTOOID dtoOID       = null;
    DruidaConector con  = null;
    DruidaConector conEx  = null;
    Vector param        = null;
    Vector paramEx        = null;

    if( oidMensaje == null || oidMensaje.equals( "" ) ){
      id = new MareBusinessID( "MSGGuardarMensaje" );
    } else{
      id = new MareBusinessID( "MSGModificarMensaje" );
    }


    traza( "-------------------------------------------" );
    traza( "Business id generado: " + id.getBusinessID() );
    traza( "-------------------------------------------" );

    
    DTOMensaje dto = crearMensaje();

    traza( "------------------------------" );
    traza( "DTO con el mensaje a insertar:" );
    traza( dto );
    traza( "------------------------------" );

    param = new Vector();
    param.addElement( dto );
    param.addElement( id );

    pagina( "salidaGenerica" );
    asignarAtributo("VAR", "cerrarVentana", "valor", "false");
    asignarAtributo("VAR", "ejecutarError", "valor", "errorPeriodos()");

    traza( "VA A CONECTAR PARA GUARDAR MENSAJE:" );
    con = conectar( "ConectorGuardarMensaje", param );
    traza( "EXITO AL CONECTAR" );


    if( con != null ){
      traza("conector no es null");
      dtoOID = (DTOOID)con.objeto( "dtoSalida" );
      if( dtoOID != null ){
        traza("dto no es null");
        oidMensaje = dtoOID.getOid().toString();
      }
    }
    traza("antes del if " + pedido);
    traza("antes del if " + consultoras);

    if( ((pedido != null) && (pedido.equals("S")) ) ||( (consultoras != null)&&(consultoras.equals("S")) ) ){
       traza("+++++PEDIDO O CONSULTORA S++++++");
       traza("el id es " + id.getBusinessID());
       
       if(id.getBusinessID().equals("MSGGuardarMensaje")){
         traza("toma el id para guardar");
         idEx = new MareBusinessID("MSGGuardarDestinatarioExcluyente");
       }else{
          if(id.getBusinessID().equals("MSGModificarMensaje")){
              traza("se fue a modificar");
              idEx = new MareBusinessID("MSGModificarDestinatarioExcluyente");
          }
       }
       traza("c paso 1");
       DTODestinatario dtoD = new DTODestinatario();
traza("c paso 2");
       dtoD.setOidMensaje(dtoOID.getOid());
       traza("c paso 3");
        
       if( (pedido != null) && (pedido.equals("S")) ){
          traza("c paso 4");
          dtoD.setPedido(new Boolean(true));
       }else{
       traza("c paso 5");
          dtoD.setPedido(new Boolean(false));
       }

       if( (consultoras != null) && (consultoras.equals("S")) ){
       traza("c paso 6");
          dtoD.setConsultoras(new Boolean(true));
       }else{
          dtoD.setConsultoras(new Boolean(false));
       }
       traza("c paso 7");
       paramEx = new Vector();
       traza("c paso 8");
       paramEx.addElement(dtoD);
       traza("c paso 9");
       paramEx.addElement(idEx);

       traza("antes de conectar");
       conEx = conectar( "ConectorGuardarDestinatarioMensaje", paramEx );
       traza("conecto con exito");
     }

     
  }

  private void cargarPGBuscarMensajes() throws Exception {

    //Carga de la pagina
    pagina( "contenido_msg_modificar" );

    DTOBelcorp dtoe = new DTOBelcorp();
    dtoe.setOidPais( UtilidadesSession.getPais( this ) );
    dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );

      asignarAtributo("VAR", "oidIdioma", "valor", UtilidadesSession.getIdioma( this ).toString() );
      asignarAtributo("VAR", "oidPais", "valor", UtilidadesSession.getPais(this).toString());

    ComposerViewElementList lista = new ComposerViewElementList();
    ComposerViewElement elem = null;

    String[] bids = { "MSGObtenerTiposMensaje", 
                      "MSGObtenerTiposPermanencia"
                    };

    for( int i = 0; i < bids.length; i++ ){
      elem = new ComposerViewElement();
      elem.setIDBusiness( bids[i] );
      elem.setDTOE( dtoe );
      lista.addViewElement( elem );
    }

		//Utilizamos el subsistema
		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
    DruidaConector resultados = null;
    resultados = conector.getConector();
    
    //asignarAtributo( "LABELC", "lblvalorPais", "valor", UtilidadesSession.getDescripcionPais( this ) );
    asignar( "COMBO", "cbTipoMensaje", resultados, "MSGObtenerTiposMensaje" );
    //asignar( "COMBO", "cbGeneracionDatos", resultados, "MSGObtenerTiposGeneracionDatos" );
    asignar( "COMBO", "cbPermanenciaMensaje", resultados, "MSGObtenerTiposPermanencia" );
  }

  private void modificarMensaje() throws Exception {

    /*
     * Hiddens utilizados: en PGBuscarMensajes
     * - hOidMensaje (oid del elemento seleccionado en la lista resultado de la pagina PGBuscarMensajes)
     * - hDeshabilitarTxtCodigoMensaje
     * */

    //oid del elemento seleccionado en la lista resultado de la pagina PGBuscarMensajes (VER)
    //oidMensaje = this.conectorParametro( "hOidMensaje" );

    traza( "ENTRO A MODIFICAR MENSAJE" );

    oidMensaje = conectorParametroLimpia("oidMensajeSeleccionado", "", true);

    traza( "oidMensajeSeleccionado: " + oidMensaje );

    DTOMensaje dto = obtenerMensaje();
    
    cargarPGDatosMensaje();
    
    mostrarDatosMensaje( dto );

    asignarAtributo( "VAR", "oidMensaje", "valor", oidMensaje );

    //Codigo para setear flag que se usa para deshabilitar txtCodigoMensaje
    //en javascript.
    asignarAtributo( "VAR", "hDeshabilitarTxtCodigoMensaje", "valor", "S" );
  }

  private DTOMensaje obtenerMensaje() throws Exception {

    traza( "ENTRO A obtenerMensaje" );

    DTOOID dto = new DTOOID();
    dto.setOid( new Long( oidMensaje ) );
    MareBusinessID id = new MareBusinessID( "MSGObtenerMensaje" );
    DTOMensaje dtom = null;

    Vector param = new Vector();
    param.addElement( dto );
    param.addElement( id );

    traza( "DTO CON EL QUE SE VA A BUSCAR: " );
    traza( dto.toString() );

    traza( "VA A CONECTAR" );
    DruidaConector con = conectar( "ConectorObtenerMensaje", param );
    traza( "CONECTO CON EXITO" );

    if( con != null ){
      dtom = (DTOMensaje)con.objeto( "dtoSalida" );
    }
    
    return dtom;
  }

  // Muestra en la página PGDatosMensaje la información del mensaje contenido en DTOMensaje
  private void mostrarDatosMensaje( DTOMensaje dtoe ) throws Exception {

    //this.pagina( "contenido_mensajes_insertar" );

    traza( "------------------------------------" );
    traza( "dto que se va a asignar: " );
    traza( dtoe );
    traza( "------------------------------------" );

    String casoDeUso = conectorParametroLimpia( "casoDeUso", "", true );

    //casoDeUso = opcionMenu;

    traza( "-->> caso de uso obtenido: " + casoDeUso );


    asignarAtributo( "VAR", "hCasoDeUso", "valor", casoDeUso );


    asignarAtributo("AREATEXTO", "TextoFijo", "valor", (dtoe.getTexto() == null ? "" : dtoe.getTexto().toString() ));
    asignarAtributo("VAR", "hTextoFijo", "valor", (dtoe.getTexto() == null ? "" : dtoe.getTexto().toString() ));
    asignarAtributo("VAR", "hModuloSeleccionado", "valor", ( dtoe.getOidModulo()==null ? "" : dtoe.getOidModulo().toString() ) );
    asignarAtributo("CTEXTO", "txtCodigoMensaje", "valor", ( dtoe.getCodigo()==null ? "" : dtoe.getCodigo() ) );
    asignarAtributo("VAR", "hTipoMensajeSeleccionado", "valor", ( dtoe.getOidTipoMensaje()==null ? "" : dtoe.getOidTipoMensaje().toString() ) );
    asignarAtributo("AREATEXTO", "atDescripcion", "valor", ( dtoe.getDescripcion()==null ? "" : dtoe.getDescripcion() ) ); //VER
	asignarAtributo("VAR", "hDescripcion", "valor", ( dtoe.getDescripcion()==null ? "" : dtoe.getDescripcion() ) ); //VER
    //asignarAtributo( "VAR", "hGeneracionDatosSeleccionado", "valor", ( dtoe.getOidGeneracionDatos()==null ? "" : dtoe.getOidGeneracionDatos().toString() ) );
    asignarAtributo( "CTEXTO", "txtBloqueGrupo", "valor", ( dtoe.getBloque()==null ? "" : dtoe.getBloque() ) );
    asignarAtributo( "VAR", "hPermanenciaMensajeSeleccionado", "valor", ( dtoe.getOidPermanencia()==null ? "" : dtoe.getOidPermanencia().toString() ) );

    String formato = UtilidadesSession.getFormatoFecha( this );
    
    String fechaDesde = "";
    String fechaHasta = "";

    if( dtoe.getPermanenciaDesde() != null ){
      fechaDesde = UtilidadesBelcorp.fechaFormateada( dtoe.getPermanenciaDesde(), formato );
    }
    
    if( dtoe.getPermanenciaHasta() != null ){
      fechaHasta = UtilidadesBelcorp.fechaFormateada( dtoe.getPermanenciaHasta(), formato );
    }
    
    asignarAtributo( "CTEXTO", "txtPermanenciaDesde", "valor", fechaDesde );
    asignarAtributo( "CTEXTO", "txtPermanenciaHasta", "valor", fechaHasta );
    asignarAtributo( "VAR", "hTipoPeriodoDesdeSeleccionado", "valor", ( dtoe.getOidPeriodoDesde()==null ? "" : dtoe.getOidPeriodoDesde().toString() ) );
    asignarAtributo( "VAR", "hTipoPeriodoHastaSeleccionado", "valor", ( dtoe.getOidPeriodoHasta()==null ? "" : dtoe.getOidPeriodoHasta().toString() ) );
    asignarAtributo( "VAR", "hTipoPeriodoSeleccionado", "valor",  ( dtoe.getOidTipoPeriodo()==null ? "" : dtoe.getOidTipoPeriodo().toString() ) );

    Vector td = dtoe.getTiposDestinatario();
    Enumeration e = null;
    StringBuffer sbtd = new StringBuffer();
    boolean first = true;
    if( td != null ){
      e = td.elements();
      while( e.hasMoreElements() ){
        if( first ){
          sbtd.append( e.nextElement().toString() );
          first = false;
        } else{
          sbtd.append( "," ).append( e.nextElement().toString() );
        }
      }
    }
    
    this.asignarAtributo( "VAR", "hAsignacionDestinatarios", "valor", sbtd.toString() );

	if (dtoe.getExclusionTipologia().booleanValue()) {
		asignarAtributo("VAR", "hExclusionTipologia", "valor", "S");
	    asignarAtributo("CHECKBOX", "chkExclusionTipologia", "check", "S");
	} else {
		asignarAtributo("VAR", "hExclusionTipologia", "valor", "N");
	    asignarAtributo("CHECKBOX", "chkExclusionTipologia", "check", "N");
	}
	

    if( casoDeUso.equals( LPMantenimientoMensajes.CONSULTAR_MENSAJE ) ){
      asignarAtributoPagina( "cod", "0376" );
      getConfiguracionMenu( "LPMantenimientoMensajes", "consultarDetalle" );
    } else if( casoDeUso.equals( LPMantenimientoMensajes.MODIFICAR_MENSAJE ) ){
              traza("entro en el menu de modificar detalle");
              asignarAtributoPagina( "cod", "0374" );
              getConfiguracionMenu( "LPMantenimientoMensajes", "ModificarDetalle" );
           } else if( casoDeUso.equals( LPMantenimientoMensajes.ELIMINAR_MENSAJE ) ){
                     asignarAtributoPagina( "cod", "0375" );
                     getConfiguracionMenu( "LPMantenimientoMensajes", "consultarDetalle" );
                  }
  }

  private void consultarMensaje() throws Exception {

    /*
     * HIDDENS:
     * hOidMensajeSeleccionado: oid del mensaje seleccionado de la lista editable.
     * hDeshabilitarTodosLosCampos: flag para deshabilitar todos los campos desde el javascript
     * */

    oidMensaje = this.conectorParametro( "oidMensajeSeleccionado" );

    traza( "--> oidMensaje: " + (oidMensaje==null ? "null" : oidMensaje.toString() ) );

    DTOMensaje dto = this.obtenerMensaje();

    cargarPGDatosMensaje();

    mostrarDatosMensaje( dto );

    asignarAtributo( "VAR", "oidMensaje", "valor", oidMensaje );

    asignarAtributo( "VAR", "hDeshabilitarTodosLosCampos", "valor", "S" );
    
  }


    /*
    * Imprime el stack trace en caso de errores.
    */
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



}