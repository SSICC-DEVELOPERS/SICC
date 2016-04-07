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
import es.indra.sicc.dtos.msg.DTOMensajeTipoCliente;
import es.indra.sicc.dtos.seg.DTOFiltroPMC;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.msg.DTOMensajeUnidadAdministrativa;
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

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import es.indra.sicc.dtos.msg.*;
import es.indra.sicc.util.*;
import es.indra.mare.common.dto.*;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import org.w3c.dom.Element;

import java.util.Iterator;


public class LPDestinatarios extends LPSICCBase {

    private String accion;
    private String opcionMenu;
    private String oidMensaje;
    private String unidadAdministrativa;
    private String tipoCliente;
    private String marca;
    private String codigoVenta;
    private String programa;
    private String consultoras;

    private Vector listaZonas = new Vector();
    private Vector listaSecciones = new Vector();
    private Vector listaTerritorios = new Vector();
    private Vector listaSubtipos = new Vector();
    private Vector listaTiposClasificacion = new Vector();
    private Vector listaClasificaciones = new Vector();
    private Vector seleccionRegion = new Vector();
    private Vector seleccionZona = new Vector();
    private Vector seleccionSeccion = new Vector();
    private Vector seleccionTerritorio = new Vector();
    private Vector seleccionTipoCliente = new Vector();
    private Vector seleccionSubtipoCliente = new Vector();
    private Vector seleccionTipoClasificacion = new Vector();
    private Vector seleccionClasificacion = new Vector();

        
    private String oidTipoMensaje;
    private String valoresLista;
    private String pedido;
    private DTODestinatario dtoDestinatario=null;

    
    public LPDestinatarios() {
        super();
    }

    // Definicion del metodo abstracto inicio
    public void inicio() throws Exception {
        // Defino el nombre de la vista
        pagina("contenido_insertar_destinatario");
    }

    public void ejecucion() throws Exception {
        setTrazaFichero();
        
        try{
            rastreo();
            accion = conectorParametroLimpia( "accion", "", true );
            asignarAtributo("VAR", "oidPais", "valor", UtilidadesSession.getPais(this).toString());

			
            opcionMenu = conectorParametroLimpia( "opcionMenu", "", true );
			
				
            traza( "VALOR DE OPCIONMENU EN LPDestinatario: " + (opcionMenu==null ? "null" : opcionMenu) );
            
			
            oidMensaje=(conectorParametro("oidMensaje")==null?"":conectorParametro("oidMensaje"));
            oidTipoMensaje=(conectorParametro("oidTipoMensaje")==null?"":conectorParametro("oidTipoMensaje"));
            unidadAdministrativa=(conectorParametro("unidadAdministrativa")==null?"":conectorParametro("unidadAdministrativa"));
	          tipoCliente=(conectorParametro("tipoCliente")==null?"":conectorParametro("tipoCliente"));
	          marca=(conectorParametro("marca")==null?"":conectorParametro("marca"));
	          codigoVenta=(conectorParametro("codigoVenta")==null?"":conectorParametro("codigoVenta"));
            pedido=(conectorParametro("pedido")==null?"":conectorParametro("pedido"));
            consultoras=(conectorParametro("consultoras")==null?"":conectorParametro("consultoras"));

            traza( "VALORES RECUPERADOS EN LPDestinatarios, met. ejecucion" );
            traza( "------------------------------------------------------" );
            traza( "oidMensaje: " + ( oidMensaje==null ? "null" : oidMensaje ) );
            traza( "oidTipoMensaje: " + (oidTipoMensaje==null ? "null" : oidTipoMensaje) );
            traza( "unidadAdministrativa: " + (unidadAdministrativa==null ? "null" : unidadAdministrativa) );
            traza( "tipoCliente: " + (tipoCliente==null ? "null" : tipoCliente) );
            traza( "marca: " + (marca==null ? "null" : marca) );
            traza( "codigoVenta: " + (codigoVenta==null ? "null" : codigoVenta) );
            traza( "pedido: " + (pedido==null ? "null" : pedido) );
            traza( "consultoras: " + (consultoras==null ? "null" : consultoras) );
            traza( "------------------------------------------------------" );

            //pagina("contenido_insertar_destinatario");

            if (accion.equals("")){
                traza( "ENTRO A ACCION VACIA EN LPDESTINATARIO" );
                inicializar();
              //  getConfiguracionMenu( "LPDestinatarios", "" );
            }else if (accion.equalsIgnoreCase("Guardar")){
                guardar();
               // getConfiguracionMenu( "LPDestinatarios", "" );
            }else{
                traza("NO EXISTE ACCION");
            }


        }catch(Exception e){
          traza("TIRO EXCEPCION");
          traza( e.toString() );
          logStackTrace( e );
          lanzarPaginaError(e);
          
/*
          this.pagina( "contenido_insertar_destinatario" );

          this.asignarAtributo( "VAR", "hUnidadesAdministrativas", "valor", unidadAdministrativa );
          this.asignarAtributo( "VAR", "hTipoCliente", "valor", tipoCliente );
          this.asignarAtributo( "VAR", "hMarca", "valor", marca );
          this.asignarAtributo( "VAR", "hCodigoVenta", "valor", codigoVenta );
          this.asignarAtributo( "VAR", "hGeneracionPedido", "valor", pedido );
          this.asignarAtributo( "VAR", "hProgramas", "valor", programa );
          this.asignarAtributo( "VAR", "hListaConsultoras", "valor", consultoras );
*/
          //inicializar();
          //logStackTrace(e);
        }
    }

    private void inicializar() throws Exception{
        traza("ENTRO A INICIALIZAR");

        traza( "--VALOR DE opcionMenu en inicializar: " + opcionMenu );
        
        cargarPGDatosDestinatario();
        traza("TERMINO cargarPGDatosDestinatario");
        
        if(opcionMenu.equalsIgnoreCase("Modificar Mensaje")){
            dtoDestinatario = obtenerDatosDestinatario();
            mostrarDatosDestinatario(dtoDestinatario);
            //this.getConfiguracionMenu( "LPDestinatarios", "" );
            asignarAtributoPagina( "cod", "0374" );
            getConfiguracionMenu( "LPDestinatarios", "ModificarDetalle" );
            
        } else if( opcionMenu.equalsIgnoreCase("Consultar Mensaje") || 
                   opcionMenu.equalsIgnoreCase("Eliminar Mensaje") ){
            
                  if( opcionMenu.equalsIgnoreCase("Consultar Mensaje") ){
                       asignarAtributoPagina( "cod", "0376" );
                  } else if( opcionMenu.equalsIgnoreCase("Eliminar Mensaje") ){
                            asignarAtributoPagina( "cod", "0375" );
                         }
            dtoDestinatario = obtenerDatosDestinatario();
            mostrarDatosDestinatario(dtoDestinatario);
            //deshabilitarCamposPagina();
            getConfiguracionMenu( "LPDestinatarios", "consultarDetalle" );
        } else if( opcionMenu.equals( "Insertar mensaje" ) ){
            traza( "LPDestinatarios: entro por insertar" );
            asignarAtributoPagina( "cod", "0361" );
            getConfiguracionMenu( "LPDestinatarios", "" );
            
          //this.getConfiguracionMenu( "LPDestinatarios", "insertar" );
        }

        Long marcaPorDefecto   = UtilidadesSession.getMarcaPorDefecto(this);
        Long canalPorDefecto   = UtilidadesSession.getCanalPorDefecto(this);
        Integer regionPorDefecto  = UtilidadesSession.getRegion(this);
        Long zonaPorDefecto    = UtilidadesSession.getZonaPorDefecto(this);
        Integer seccionPorDefecto = UtilidadesSession.getSeccion(this);
        Integer terriPorDefecto   = UtilidadesSession.getTerritorio(this);
        

        if(marcaPorDefecto != null){
           asignarAtributo("VAR", "marcaPorDefecto", "valor", marcaPorDefecto.toString());
        }

        if(canalPorDefecto != null){
           asignarAtributo("VAR", "canalPorDefecto", "valor", canalPorDefecto.toString());
        }

        if(regionPorDefecto != null){
           asignarAtributo("VAR", "regionPorDefecto", "valor", regionPorDefecto.toString());
        }
        
        if(zonaPorDefecto != null){
           asignarAtributo("VAR", "zonaPorDefecto", "valor", zonaPorDefecto.toString());
        }

        if(seccionPorDefecto != null){
           asignarAtributo("VAR", "seccionPorDefecto", "valor", seccionPorDefecto.toString());
        }

        if(terriPorDefecto != null){
           asignarAtributo("VAR", "terriPorDefecto", "valor", terriPorDefecto.toString());
        }
        
    }

    private void guardar() throws Exception{

        pagina( "salidaGenerica" );
    
      //  boolean correcto = comprobarCodigoVenta();

        //traza("VALOR DE CORRECTO: " + correcto);
        traza( "opcionMenu: " + opcionMenu );
        
       // if (correcto){
            MareBusinessID id=null;
            
            if (opcionMenu.equalsIgnoreCase("Insertar mensaje")){
                traza( "Creo el bid MSGGuardarDestinatarioMensaje" );
                id = new MareBusinessID("MSGGuardarDestinatarioMensaje");
            }else if (opcionMenu.equalsIgnoreCase("Modificar mensaje")){
                traza( "Creo el bid MSGModificarDestinatarioMensaje" );
                id = new MareBusinessID("MSGModificarDestinatarioMensaje");
            }
            dtoDestinatario = crearDTODestinatario();

            traza( "-------------------------------------------" );
            traza( "Business ID generado: " + id.getBusinessID() );
            traza( "-------------------------------------------" );

            traza( "dtoDestinatario: " + dtoDestinatario );
            
            Vector vec = new Vector();
            vec.add(dtoDestinatario);
            vec.add(id);

            //probar envia oculto

            traza( "VA A CONECTAR ConectorGuardarDestinatarioMensaje..." );
            conectar("ConectorGuardarDestinatarioMensaje",vec);
            traza( "CONECTO!!!!" );
      

            if (opcionMenu.equalsIgnoreCase("Insertar mensaje")){
               conectorAction( "LPMantenimientoMensajes" );
               conectorActionParametro( "accion", "" );
               conectorActionParametro( "opcionMenu", "Insertar mensaje" ); 
            }else if (opcionMenu.equalsIgnoreCase("Modificar mensaje")){
                     asignarAtributo("VAR","ejecutar","valor","retorna();");
                  }
                 
            traza( "TERMINO comprobarTipoMensaje!!" );
        //}
    }

    private boolean comprobarCodigoVenta() throws Exception{
        DTODestinatario dto = generarMensajeCodigoVenta(new DTODestinatario());
        //dto.setIpCliente( UtilidadesBelcorp.getIPCliente( this ) );
        //dto.setPrograma( UtilidadesSession.getFuncion( this ) );
        //dto.setOidIdioma( UtilidadesSession.getIdioma( this ) );
        //dto.setOidPais( UtilidadesSession.getPais( this ) );

        traza( "ENTRO A comprobarCodigoVenta" );

        traza( "DTODestinatario: " + (dto==null ? "null" : dto.toString()) );

        Vector vec = new Vector();
        MareBusinessID id = new MareBusinessID("MSGComprobarMensajeCodigoVenta");
        vec.add(dto);
        vec.add(id);

        traza( "VA A CONECTAR ....." );
        IMareDTO dtoS =(IMareDTO)conectar("ConectorComprobarMensajeCodigoVenta",vec).objeto("dtoSalida");
        traza( "CONECTO!!!!!" );
        
        DTOBoolean dtoB = (DTOBoolean)dtoS.getProperty("resultado");

        traza( "OBTUVO RESULTADO!!!" );

        traza( "dtoB.getValor(): " + dtoB.getValor() );

        if (!dtoB.getValor()){

            traza( "ENTRO PARA LANZAR LA EXCEPCION" );

            throw new MareException( new Exception(), UtilidadesError.armarCodigoError( "290009" ) );
            
        }

        traza( "TERMINO comprobarCodigoVenta" );
        
        return dtoB.getValor();
    }

    private void generarCapaUnidadAdministrativa() throws Exception{
        //VER ESTE METODO

        traza( "-->  ENTRO A generarCapaUnidadAdministrativa" );

        //Para habilitar el boton de la capa
        asignarAtributo( "VAR", "hUnidadesAdministrativas", "valor", "S" );
        DTOBelcorp dto = new DTOBelcorp();

        dto.setOidPais( UtilidadesSession.getPais( this ) );
        dto.setOidIdioma( UtilidadesSession.getIdioma( this ) );

        ComposerViewElementList lista = new ComposerViewElementList();

        ComposerViewElement elem = null;

        String[] bids = { "SEGConsultaCanales",
                          "SEGConsultaMarcas"};
    
        for( int i = 0; i < bids.length; i++ ){
           elem = new ComposerViewElement();
           elem.setIDBusiness( bids[i] );
           elem.setDTOE( dto );
           lista.addViewElement( elem );
        }

        ConectorComposerView conector = null;
        DruidaConector resultados = null;

        conector = new ConectorComposerView(lista, this.getRequest());
        conector.ejecucion();
        resultados = null;
        resultados = conector.getConector();

        asignar("COMBO", "cbMarca2", resultados, "SEGConsultaMarcas");
        asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");       
        traza( "-->  SALIO DE generarCapaUnidadAdministrativa" );      
    }

    /*
     * Arma un conector en base a un record set y los nombres de los campos
     * pasados como parámetro. En esta caso solo se aplica la petición de
     * 2 campos.
     */
    private DruidaConector generaConector(RecordSet rs, String ID_Rows, String campoCod,
        String campoNom, String campoF) throws Exception {
        XMLDocument xmlDoc = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");

        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID", ID_Rows);
        docDestino.getDocumentElement().appendChild(e_rows);

        for (int i = 0; i < rs.getRowCount(); i++) {
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            Element e_campo1 = docDestino.createElement("CAMPO");
            e_campo1.setAttribute("NOMBRE", campoCod);
            e_campo1.setAttribute("TIPO", "OBJECTO");
            e_campo1.setAttribute("LONGITUD", "50");

            Text txtCod = docDestino.createTextNode(((rs.getValueAt(i, campoCod) == null) ? ""
                                                                                          : rs.getValueAt(
                        i, campoCod).toString()));
            e_campo1.appendChild(txtCod);
            e_row.appendChild(e_campo1);

            Element e_campo2 = docDestino.createElement("CAMPO");
            e_campo2.setAttribute("NOMBRE", campoNom);
            e_campo2.setAttribute("TIPO", "OBJECTO");
            e_campo2.setAttribute("LONGITUD", "50");

            Text txtDesc = docDestino.createTextNode(((rs.getValueAt(i, campoNom) == null) ? ""
                                                                                           : rs.getValueAt(
                        i, campoNom).toString()));
            e_campo2.appendChild(txtDesc);
            e_row.appendChild(e_campo2);

            if (campoF != null) {
                Element e_campo3 = docDestino.createElement("CAMPO");
                e_campo3.setAttribute("NOMBRE", campoF);
                e_campo3.setAttribute("TIPO", "OBJECTO");
                e_campo3.setAttribute("LONGITUD", "50");

                Text txtF = docDestino.createTextNode(((rs.getValueAt(i, campoF) == null) ? ""
                                                                                          : rs.getValueAt(
                            i, campoF).toString()));
                e_campo3.appendChild(txtF);
                e_row.appendChild(e_campo3);
            }
        }

        DruidaConector conect = new DruidaConector();
        conect.setXML(docDestino.getDocumentElement());

        return conect;
    }



    private DTODestinatario obtenerDatosDestinatario() throws Exception{


        traza( "entro a obtenerDatosDestinatario()" );
        traza( "oidMensaje: " + (oidMensaje==null ? "null" : oidMensaje) );

    
        DTOOID dto = new DTOOID();
        dto.setOid(Long.valueOf(oidMensaje));
        Vector vec = new Vector();
        vec.add(dto);
        MareBusinessID id = new MareBusinessID("MSGObtenerDatosDestinatario");
        vec.add(id);

        traza( "VA A CONECTAR EN obtenerDatosDestinatario" );
        DruidaConector dc = this.conectar("ConectorObtenerDatosDestinatario",vec);
        traza( "CONECTO CON EXITO" );

        DTODestinatario dtoDestinatario = null;

        if( dc != null ){
          dtoDestinatario = (DTODestinatario)dc.objeto( "dtoSalida" );
        }
        
        //IMareDTO dtoS = (IMareDTO)conectar("ConectorObtenerDatosDestinatario",vec).objeto("dtoSalida");
        
        return dtoDestinatario;
    }

    private void generarCapaTipoCliente() throws Exception{

      //flag para habilitar el boton de la capa camposBusqueda3
	    traza( "-->  ENTRO A generarCapaTipoCliente" );
      asignarAtributo( "VAR", "hTipoCliente", "valor", "S" );

       /******* yyy CODIGO DE DISENO COMENTADO POR PROBLEMA CON B ID  ****/

      DTOBelcorp dtoe = new DTOBelcorp();
      dtoe.setOidPais( UtilidadesSession.getPais( this ) );
      dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );

//      ComposerViewElementList lista = new ComposerViewElementList();
//
//      // TIPO / SUBTIPO CLIENTE 
//      ComposerViewElement ci1 = new ComposerViewElement();
//      ci1.setIDBusiness( "MAEObtenerTipoSubtipo" );
//      ci1.setDTOE( dtoe );
//    
//      ComposerViewElement ci2 = new ComposerViewElement();
//      ci2.setIDBusiness( "MAEObtenerClasificaciones" );
//      ci2.setDTOE( dtoe );
//
//      lista.addViewElement( ci1 );
//      lista.addViewElement( ci2 );
//
//      //Utilizamos el subsistema
//      ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
//      conector.ejecucion();
//      DruidaConector resultados = null;
//      resultados = conector.getConector();
//	    traza(resultados);
//        asignar("COMBO", "cbTipoCliente", resultados, "MAEObtenerTipoSubtipo");

	  /**
	   * TODO: revisar que las claves ( listaTiposClasificacion, ... ) sean 
	   * correctas.
	   */
//      asignar("COMBO", "cbTipoCliente", resultados, "listaTiposClasificacion");
//      asignar("COMBO", "cbTipoClasificacion", resultados, "listaClasificaciones");


      cargarTipoSubtipo();
      cargarClasificaciones();
		  traza( "-->  SALIO DE generarCapaTipoCliente" );
      
    }

    /******************************/
    /******************************/
    private void cargarTipoSubtipo() throws Exception {
    
        DTOTipoSubtipo dto = (DTOTipoSubtipo) conectorParametroSesion("TIPOSUBTIPO");
        DruidaConector conTipoSubtipo = null;
        Long idioma = UtilidadesSession.getIdioma( this );

        if (dto == null) {
        
            DTOBelcorp dtoE = new DTOBelcorp();
            dtoE.setOidIdioma(idioma);

            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoE);
            paramEntrada.add(new MareBusinessID("MAEObtenerTipoSubtipo"));

            conTipoSubtipo = conectar("ConectorTipoSubtipo", paramEntrada);

            dto = (DTOTipoSubtipo) conTipoSubtipo.objeto("DTOSalida");


//            MareDTO dtoSalida = (DTOTipoSubtipo) conTipoSubtipo.objeto("DTOSalida");
//            dto = (DTOTipoSubtipo) dtoSalida.getProperty("resultado");
            conectorParametroSesion("TIPOSUBTIPO", dto);
        }

        //Tipo
        conTipoSubtipo = generaConector(dto.getTipos(), "dtoSalida.tipos_ROWSET","OID_TIPO_CLIE", "VAL_I18N", null); //DES_MAE_TIPO_CLIEN
        asignar("COMBO", "cbTipoCliente", conTipoSubtipo, "dtoSalida.tipos_ROWSET");
		//asignarAtributo("VAR", "hTipo", "valor", this.tipoCliente);

        //Subtipo
        conTipoSubtipo = generaConector(dto.getSubtipos(), "dtoSalida.subtipos_ROWSET",
                "OID_SUBT_CLIE", "TICL_OID_TIPO_CLIE", "VAL_I18N"); //"DES_MAE_TIPO_CLIEN", "DES_MAE_SUBTI_CLIEN"
        asignar("COMBO", "lstSubtipo", conTipoSubtipo, "dtoSalida.subtipos_ROWSET");
        //asignarAtributo("VAR", "hSubtipo", "valor", this.subTipoCliente);
    }

    private void cargarClasificaciones() throws Exception {
		traza("ENTRO A CARGAR CLASIFICACIONES......");
        DTOClasificaciones dto = (DTOClasificaciones) conectorParametroSesion("CLASIFICACION");
        DruidaConector conClasificacion = null;

        Long idioma = UtilidadesSession.getIdioma( this );

        if (dto == null) {
            DTOBelcorp dtoE = new DTOBelcorp();
            dtoE.setOidIdioma(idioma);

            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoE);
            paramEntrada.add(new MareBusinessID("MSGObtenerClasificacion"));
            conClasificacion = conectar("ConectorObtenerModulos", paramEntrada);

            //this.ratrearFuncion();

				 /* Modificado por eyache*/
            //MareDTO dtoSalida = (MareDTO) conClasificacion.objeto("dtoSalidaObjeto");
		      //dto = (DTOClasificaciones) dtoSalida.getProperty("resultado");
            dto = (DTOClasificaciones) conClasificacion.objeto("dtoSalidaObjeto");
				 /* fin modificacion*/
            conectorParametroSesion("CLASIFICACION", dto);
        }
        traza("//Tipo Clasificacion");
        //Tipo Clasificacion
        conClasificacion = generaConector(dto.getTipoClasificacion(),"dtoSalida.tipoclasificacion_ROWSET", "OID_TIPO_CLAS","SBTI_OID_SUBT_CLIE", "VAL_I18N"); //DES_MAE_TIPO_CLASI_CLIEN
        asignar("COMBO", "lstTipoClasificacion", conClasificacion,"dtoSalida.tipoclasificacion_ROWSET");
        //asignarAtributo("VAR", "hTipoClasificacion", "valor", this.tipoClasificacion);

        traza("//Clasificacion");
        conClasificacion = generaConector(dto.getClasificacion(),"dtoSalida.clasificacion_ROWSET", "OID_CLAS", "TCCL_OID_TIPO_CLAS", "VAL_I18N"); //"TCCL_OID_TIPO_CLAS", "DES_MAE_CLASI"
        asignar("COMBO", "lstClasificacion", conClasificacion, "dtoSalida.clasificacion_ROWSET");
        //asignarAtributo("VAR", "hClasificacion", "valor", this.clasificacion);
    }

    private void generarCapaMarcas() throws Exception{

      /**
       * TODO: flag para que el javascript haga visible la capa camposBusqueda3
       * 
       */
	  traza( "-->  ENTRO A generarCapaMarcas" );
      asignarAtributo( "VAR", "hMarca", "valor", "S" );

      DTOBelcorp dtoe = new DTOBelcorp();
      dtoe.setOidPais( UtilidadesSession.getPais( this ) );
      dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );

      ComposerViewElementList lista = new ComposerViewElementList();

      ComposerViewElement elem = new ComposerViewElement();
      elem.setIDBusiness( "SEGConsultaMarcas" );
      elem.setDTOE( dtoe );
      elem.setPosOID( (byte)0 );
      elem.setPosDesc( (byte)1 );
      
      lista.addViewElement( elem );
      
      //Utilizamos el subsistema
      ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());

      if( conector != null ){
      
        conector.ejecucion();
        DruidaConector resultados = null;
        resultados = conector.getConector();
        
        if( resultados != null ){
          asignar("COMBO", "cbMarca4", resultados, "SEGConsultaMarcas");
        }
      }
	  traza( "-->  SALIO DE generarCapaMarcas" );
    }

    private void generarCapaCodigoVenta() throws Exception{

      /**
       * TODO: flag para que el javascript haga visible la capa camposBusqueda5
       * 
       */
	  traza( "-->  ENTRO A generarCapaCodigoVenta" );
      asignarAtributo( "VAR", "hCodigoVenta", "valor", "S" );
	  traza( "-->  SALIO DE generarCapaCodigoVenta" );

    }
  
    private void generarCapaConsultoras() throws Exception{

      /**
       * TODO: flag para que el javascript haga visible la capa camposBusqueda8
       * 
       */

      asignarAtributo( "VAR", "hListaConsultoras", "valor", "S" );

    }

    private void cargarPGDatosDestinatario() throws Exception{

        traza("ENTRO A cargarPGDatosDestinatario");

        traza( "------------------------------------------" );
        traza( "opcionMenu: " + (opcionMenu==null ? "null":opcionMenu) );
        traza( "unidadAdministrativa: "  + (unidadAdministrativa==null?"null":unidadAdministrativa));
        traza( "tipoCliente: " + (tipoCliente==null?"null":tipoCliente));
        traza( "marca: " + (marca==null?"null":marca));
        traza( "codigoVenta: " + (codigoVenta==null?"null":codigoVenta));
        traza( "consultoras: " + (consultoras==null?"null":consultoras));
        traza( "------------------------------------------" );

        if (unidadAdministrativa.equalsIgnoreCase("S")){
            traza("entro en el if de unidades administrtativas");
            generarCapaUnidadAdministrativa();
        } 
        /*else{
          asignarAtributo( "COMBO", "cbMarca2", "req", "N" );
          asignarAtributo( "COMBO", "cbCanal", "req", "N" );
          asignarAtributo( "COMBO", "cbRegion", "req", "N" );
          asignarAtributo( "COMBO", "cbZona", "req", "N" );
          asignarAtributo( "COMBO", "cbSeccion", "req", "N" );
          asignarAtributo( "COMBO", "cbTerritorio", "req", "N" );
        }*/

        if (tipoCliente.equalsIgnoreCase("S")){
            traza("entro en el if de tipo cliente");
            generarCapaTipoCliente();
        } else{
          asignarAtributo( "COMBO", "cbTipoCliente", "req", "N" );
          asignarAtributoElementoValidacion("cbTipoCliente", "required", "false");
          //asignarAtributo( "COMBO", "cbSubtipoCliente", "req", "N" );
          //asignarAtributo( "COMBO", "cbTipoClasificacion", "req", "N" );
          //asignarAtributo( "COMBO", "cbClasificacion", "req", "N" );
        }

        if (marca.equalsIgnoreCase("S")){
            traza("entro en el if de marcas");
            generarCapaMarcas();
        } else{
          asignarAtributo( "COMBO", "cbMarca4", "req", "N" );
          asignarAtributoElementoValidacion("cbMarca4", "required", "false");
                      
        }

        if (codigoVenta.equalsIgnoreCase("S")){
            traza("entro en el if de codigo venta");
            generarCapaCodigoVenta();
        } else{
          asignarAtributo( "CTEXTO", "txtCodigoVenta", "req", "N" );
          asignarAtributoElementoValidacion("txtCodigoVenta", "required", "false");
        }

        if (consultoras.equalsIgnoreCase("S") && oidTipoMensaje.equalsIgnoreCase(ConstantesMSG.OID_TIPO_G2.toString())){
            traza("entro en el if de consultoras");
            generarCapaConsultoras();
        }

        traza("LLEGO A LA MITAD");

        asignarAtributo( "VAR", "oidMensajeSeleccionado", "valor", oidMensaje );
        asignarAtributo( "VAR","accion","valor",accion );
        asignarAtributo( "VAR","opcionMenu","valor",opcionMenu );
        asignarAtributo( "VAR","oidMensaje","valor",oidMensaje );
        asignarAtributo( "VAR","oidTipoMensaje","valor",oidTipoMensaje );
        asignarAtributo( "VAR","unidadAdministrativa","valor",unidadAdministrativa );
        asignarAtributo( "VAR","tipoCliente","valor",tipoCliente );
        asignarAtributo( "VAR","marca","valor",marca );
        asignarAtributo( "VAR","codigoVenta","valor",codigoVenta );
        asignarAtributo( "VAR","consultoras","valor",consultoras );

        traza("TERMINO cargarPGDatosDestinatario");
    }

    private DTODestinatario crearDTODestinatario() throws Exception{
        dtoDestinatario = new DTODestinatario();
        if (!oidMensaje.equals(""))
            dtoDestinatario.setOidMensaje(Long.valueOf(oidMensaje));
        else
            traza("SE ME COMPLICA SI ES VACIO");

        if (unidadAdministrativa.equalsIgnoreCase("S")){
            dtoDestinatario = generarMensajeUnidadAdministrativa(dtoDestinatario);
            if (dtoDestinatario==null)
                throw new MareException("Ver Codigo Error");
        }

        if (tipoCliente.equalsIgnoreCase("S")){
            dtoDestinatario = generarMensajeTipoCliente(dtoDestinatario);
            if (dtoDestinatario==null)
                throw new MareException("Ver Codigo Error");
        }

        if (marca.equalsIgnoreCase("S")){
            dtoDestinatario = generarMensajeMarca(dtoDestinatario);
            if (dtoDestinatario==null)
                throw new MareException("Ver Codigo Error");
        } 

        if (codigoVenta.equalsIgnoreCase("S")){
            dtoDestinatario = generarMensajeCodigoVenta(dtoDestinatario);
            if (dtoDestinatario==null)
                throw new MareException("Ver Codigo Error");
        } 

        if (pedido.equals("S")){
            dtoDestinatario.setPedido(Boolean.TRUE);
        } 


        if (consultoras.equalsIgnoreCase("S")&& oidTipoMensaje.equalsIgnoreCase(ConstantesMSG.OID_TIPO_G2.toString())){
            dtoDestinatario = generarMensajeCliente(dtoDestinatario);
            if (dtoDestinatario==null)
                throw new MareException("Ver Codigo Error");
        }
        
        return dtoDestinatario;
    }    

    private DTODestinatario generarMensajeUnidadAdministrativa(DTODestinatario dtoe) throws Exception{
       traza("ENTRO A generarMensajeUnidadAdministrativa...");

       DTODestinatario dto = new DTODestinatario();
        
       String elem = conectorParametroLimpia("hidListaUnidades", "", true);
       traza("ELEM " + elem);
       StringTokenizer tok = new StringTokenizer(elem,"#");
       traza("tokenizo " + tok);
       
       Long[] registro = new Long[4];
       traza("array de longs");
       Vector v = new Vector();
       traza("vector");

       while(tok.hasMoreTokens()){
                    
          StringTokenizer tok2 = new StringTokenizer(tok.nextToken(), ",");
          int indice = 0;
         
          for( int i = 0; i < registro.length; i++){
            registro[i] = null;
          }

          while(tok2.hasMoreTokens()){ 
            registro[indice] = new Long(tok2.nextToken());
            indice ++;
          } 
          traza("se fue a crear dtos");  
          traza("el primero " + registro[0]);
          traza("el segindo " + registro[1]);
          traza("el tercero " + registro[2]);
          traza("el cuarto " + registro[3]);
          
          v.add(crearDTOMensajeUnidadAdministrativa (registro[0], registro[1], registro[2], registro[3]));
       
       }

       dtoe.setUnidadAdministrativa(v);
       return dtoe;
    }

    private DTODestinatario generarMensajeCliente(DTODestinatario dtoe) throws Exception{
        /*String listaDestinatarios = conectorParametro("cbMarca");
        StringTokenizer tok = new StringTokenizer(listaDestinatarios,"|");
        if (tok.countTokens()==0)
            return null;
        DTOMensajeCliente[] dtoC = new DTOMensajeCliente[tok.countTokens()];
        dtoe.setCliente(dtoC);
        int i=0;
        while(tok.hasMoreElements()){
           dtoe.getCliente()[i]=crearDTOMensajeCliente(Long.valueOf(tok.nextToken()));
        }*///REVISAR
        return dtoe;
    }

    private DTODestinatario generarMensajeMarca(DTODestinatario dtoe) throws Exception{
		traza("ENTRO A generarMensajeMarca...");
        String marcaPantalla = conectorParametro("cbMarca4");
        StringTokenizer tok = new StringTokenizer(marcaPantalla,"|");
        if (tok.countTokens()==0)
            return null;
            
        //DTOMensajeMarca[] dtoC = new DTOMensajeMarca[tok.countTokens()];
        //dtoe.setMarca(dtoC);

        dtoe.setMarca( new Vector() );
        
        int i=0;
        while(tok.hasMoreElements()){
           dtoe.getMarca().addElement( crearDTOMensajeMarca(Long.valueOf(tok.nextToken())) );
        }
		traza("SALIO DE generarMensajeMarca...");
        return dtoe;
    }

    private DTODestinatario generarMensajeCodigoVenta(DTODestinatario dtoe) throws Exception{
	  traza("ENTRO A generarMensajeCodigoVenta...");
      String codigoVentaPantalla = conectorParametroLimpia("txtCodigoVenta", "", true);
      StringTokenizer tok = null;

      //se agrega el pais
      dtoe.setOidPais( UtilidadesSession.getPais( this ) );
      
      if( codigoVentaPantalla.equals( "" ) ){
        dtoe = null;
      } else{
        tok = new StringTokenizer(codigoVentaPantalla,";");

        if (tok.countTokens() > 0){
          dtoe.setCodigoVenta( new Vector() );

          int i=0;
          while(tok.hasMoreElements()){
            dtoe.getCodigoVenta().addElement( crearDTOMensajeCodigoVenta(tok.nextToken()) );
          }
        }
      }
	  traza("SALIO DE generarMensajeCodigoVenta...");          
      return dtoe;
    }

    private DTODestinatario generarMensajePrograma(DTODestinatario dto) throws Exception{

        traza( "ENTRO A generarMensajePrograma" );
    
        String proceso = conectorParametroLimpia("txtProgramaLlamado", "", true);
        String programa = conectorParametroLimpia("txtProgramaAsociado", "", true);

        traza( "trajo datos" );
        
        if ( proceso.equals( "" ) && programa.equals( "" ) ){
          return null;
        }

        traza( "PASO LA VALIDACION" );

        traza( "Programa: " + programa );
        traza( "Proceso: " + proceso );
        
//        dto.setProgramaAsociado(crearDTOMensajePrograma(proceso, programa));

        traza( "AGREGO DATO AL DTO" );
        
        return dto;
    }

    private DTODestinatario generarMensajeTipoCliente(DTODestinatario dtoe) throws Exception{
		   traza("ENTRO A generarMensajeTipoCliente...");

       DTODestinatario dto = new DTODestinatario();
        
       String elem = conectorParametroLimpia("elementosSeleccionados", "", true);
       traza("ELEM " + elem);
       StringTokenizer tok = new StringTokenizer(elem,"#");
       traza("tokenizo " + tok);
       
       Long[] registro = new Long[4];
       traza("array de longs");
       Vector v = new Vector();
       traza("vector");

       while(tok.hasMoreTokens()){
                    
          StringTokenizer tok2 = new StringTokenizer(tok.nextToken(), ",");
          int indice = 0;
         
          for( int i = 0; i < registro.length; i++){
            registro[i] = null;
          }

          while(tok2.hasMoreTokens()){ 
            registro[indice] = new Long(tok2.nextToken());
            indice ++;
          } 
          traza("se fue a crear dtos");  
          traza("el primero " + registro[0]);
          traza("el segindo " + registro[1]);
          traza("el tercero " + registro[2]);
          traza("el cuarto " + registro[3]);

          if(registro[0] != null){
             v.add(crearDTOMensajeTipoCliente(registro[0], registro[1], registro[2], registro[3]));
          }
       
       }

       dtoe.setTipoCliente(v);
       return dtoe;
       
     
    }

    private void mostrarDatosDestinatario(DTODestinatario dto) throws Exception{

      asignarAtributo( "VAR", "opcionMenu", "valor", opcionMenu );

      if( unidadAdministrativa.equals( "S" ) ){
        mostrarDatosUnidadAdministrativa( dto );

        if((valoresLista != null) && !valoresLista.equals("")){
           asignarAtributo("VAR", "hValoresLista", "valor", valoresLista );
        }
           
      } 

      if( tipoCliente.equals( "S" ) ){
        mostrarDatosTipoCliente( dto );
        traza( "-----------------------------------------" );
        traza( "seleccionTipoCliente: " + seleccionTipoCliente.toString() );
        traza( "seleccionSubtipoCliente: " + seleccionSubtipoCliente.toString() );
        traza( "seleccionTipoClasificacion: " + seleccionTipoClasificacion.toString() );
        traza( "seleccionClasificacion: " + seleccionClasificacion.toString() );
        traza( "-----------------------------------------" );

        //Se pasa a la pagina el nivel del elemento seleccionado
        if(seleccionTipoCliente.size() > 0 ){
          asignarAtributo( "VAR", "hNivelTipificacion", "valor", "tipocliente" );
        }

        if( seleccionSubtipoCliente.size() > 0 ){
          asignarAtributo( "VAR", "hNivelTipificacion", "valor", "subtipocliente" );
        }

        if( seleccionTipoClasificacion.size() > 0 ){
          asignarAtributo( "VAR", "hNivelTipificacion", "valor", "tipoclasificacion" );
        }

        if( seleccionClasificacion.size() > 0 ){
          asignarAtributo( "VAR", "hNivelTipificacion", "valor", "clasificacion" );
        }

        //se envian a PGDatosDestinatarios
        asignarAtributo( "VAR", "hSeleccionTipoCliente", "valor", vectorToString( seleccionTipoCliente ) );
        asignarAtributo( "VAR", "hSeleccionSubtipoCliente", "valor", vectorToString( seleccionSubtipoCliente ) );
        asignarAtributo( "VAR", "hSeleccionTipoClasificacion", "valor", vectorToString( seleccionTipoClasificacion ) );
        asignarAtributo( "VAR", "hSeleccionClasificacion", "valor", vectorToString( seleccionClasificacion ) );
      }

      if( marca.equals( "S" ) ){
        mostrarDatosMarca( dto );
      }

      if( codigoVenta.equals( "S" ) ){
        mostrarDatosCodigoVenta( dto );
      }
     
      /*if( consultoras.equals( "S" ) && oidTipoMensaje.equals( ConstantesMSG.OID_TIPO_G2 ) ){
        mostrarDatosCliente( dto );
      }*/
    }

    private String vectorToString( Vector v ){
      StringBuffer sb = new StringBuffer();

      if( v != null && v.size() >= 1 ){
        Enumeration e = v.elements();
        boolean first = true;

        while( e.hasMoreElements() ){
          if( first ){
            sb.append( e.nextElement().toString() );
            first = false;
          } else{
            sb.append( "," ).append( e.nextElement().toString() );
          }
        }
      }

      return sb.toString();
    }


    private void mostrarDatosCliente(DTODestinatario dto) throws Exception{

      DTOMensajeCliente dtoMC = null;
      Vector dtoMCs = dto.getCliente();
      Enumeration e = null;
      StringBuffer sb = new StringBuffer();

      if( dtoMCs != null ){
        e = dtoMCs.elements();

        while( e.hasMoreElements() ){
          dtoMC = (DTOMensajeCliente)e.nextElement();

          if( dtoMC.getOidCliente() != null ){
            if( sb.toString().length() > 0 ){
              sb.append( "," );
            }
            sb.append( dtoMC.getOidCliente().toString() );
          }
        } //while

        // Asignacion a VAR
        if( sb.toString().length() > 0 ){
          asignarAtributo( "VAR", "hListaClientesSeleccionados", "valor", sb.toString() );
        }

      }
        
    }

    private DTOMensajeCliente crearDTOMensajeCliente(Long cliente) throws Exception{
        DTOMensajeCliente dto = new DTOMensajeCliente();
        dto.setOidCliente(cliente);
        return dto;
    }

    private DTOMensajePrograma crearDTOMensajePrograma(String proceso, String programa) throws Exception{
      DTOMensajePrograma dto = new DTOMensajePrograma();
      dto.setProceso(proceso);
      dto.setProgramaAsociado(programa);
      return dto;
    }

    private void mostrarDatosUnidadAdministrativa( DTODestinatario dtoe ) throws Exception{

      DTOMensajeUnidadAdministrativa dtoMUA = null;
      Vector dtoMUAs = dtoe.getUnidadAdministrativa();
      Enumeration e = null;
      

      if( dtoMUAs != null ){
        e = dtoMUAs.elements();

        while( e.hasMoreElements() ){
          dtoMUA = (DTOMensajeUnidadAdministrativa)e.nextElement();

          Long oid             = dtoMUA.getOid();
          String desRegion     = (dtoMUA.getDesRegion()==null?"":dtoMUA.getDesRegion());
          String desZona       = (dtoMUA.getDesZona()==null?"":dtoMUA.getDesZona());
          String desSeccion    = (dtoMUA.getDesSeccion()==null?"":dtoMUA.getDesSeccion());
          String desTerritorio = (dtoMUA.getDesTerritorio()==null?"":dtoMUA.getDesTerritorio());
          Long oidRegion       = dtoMUA.getOidRegion();
          Long oidZona         = dtoMUA.getOidZona();
          Long oidSeccion      = dtoMUA.getOidSeccion();
          Long oidTerritorio   = dtoMUA.getOidTerritorio();
          
          valoresLista = (valoresLista==null?"":valoresLista) + oid + "|" + desRegion + "|" + desZona + "|" + desSeccion + "|" + desTerritorio + "|" + oidRegion + "|" +
                         oidZona + "|" + oidSeccion + "|" + oidTerritorio + "#"; 
        }
      }
       traza("los valores de la lista son " + valoresLista);
    }

    private void mostrarDatosTipoCliente( DTODestinatario dtoe ){

      DTOMensajeTipoCliente dtoMTC = null;
      Vector dtoMTCs = dtoe.getTipoCliente();
      Enumeration e = null;

      if( dtoMTCs != null ){
        e = dtoMTCs.elements();

        while( e.hasMoreElements() ){
          dtoMTC = (DTOMensajeTipoCliente)e.nextElement();
          
          if(dtoMTC.getOidTipoCliente() != null){
             seleccionTipoCliente.add(dtoMTC.getOidTipoCliente());
          }

          if(dtoMTC.getOidSubtipoCliente() != null){
             seleccionSubtipoCliente.add(dtoMTC.getOidSubtipoCliente());
          }

          if(dtoMTC.getOidTipoClasificacion() != null){
             seleccionTipoClasificacion.add(dtoMTC.getOidTipoClasificacion());
          }

          if(dtoMTC.getOidClasificacion() != null){
             seleccionClasificacion.add(dtoMTC.getOidClasificacion());
          }

       
        }
      }
    }
   
    private void mostrarDatosMarca( DTODestinatario dtoe ) throws Exception {

      DTOMensajeMarca dtoMM = null;
      Vector dtoMMs = dtoe.getMarca();
      Enumeration e = null;

      StringBuffer sb = new StringBuffer();

      if( dtoMMs != null ){
        e = dtoMMs.elements();

        while( e.hasMoreElements() ){
          dtoMM = (DTOMensajeMarca)e.nextElement();

          if( dtoMM != null ){
            if( sb.toString().length() > 0 ){
              sb.append( "," );
            }
            sb.append( dtoMM.getOidMarca().toString() );
          }
        }

        traza("las marcas seleccionadas " + sb.toString());
        if( sb.toString().length() > 0 ){
          asignarAtributo( "VAR", "hMarcasSeleccionadas", "valor", sb.toString() );
        }
      }
    }


    private void mostrarDatosCodigoVenta( DTODestinatario dtoe ) throws Exception {

      DTOMensajeCodigoVenta dtoMCV = null;
      Vector DTOMCVs = dtoe.getCodigoVenta();
      Enumeration e = null;
      StringBuffer sb = new StringBuffer();

      if( DTOMCVs != null ){
        e = DTOMCVs.elements();

        while( e.hasMoreElements() ){
          dtoMCV = (DTOMensajeCodigoVenta)e.nextElement();

          if( dtoMCV.getCodigoVenta() != null && dtoMCV.getCodigoVenta().length() > 0 ){
            if( sb.toString().length() > 0 ){
              sb.append( ";" );
            }
            sb.append( dtoMCV.getCodigoVenta() );
          }
        }

        if( sb.toString().length() > 0 ){
          asignarAtributo( "CTEXTO", "txtCodigoVenta", "valor", sb.toString() );
        }
      }
    }


    private DTOMensajeCodigoVenta crearDTOMensajeCodigoVenta(String codigoVenta) throws Exception{
        DTOMensajeCodigoVenta dto = new DTOMensajeCodigoVenta();
        dto.setCodigoVenta(codigoVenta);
        return dto;
    }

    private DTOMensajeMarca crearDTOMensajeMarca(Long marca) throws Exception{
        DTOMensajeMarca dto = new DTOMensajeMarca();
        dto.setOidMarca(marca);
        return dto;
    }

    private DTOMensajeTipoCliente crearDTOMensajeTipoCliente(Long tipoClien, Long subtipoClien, Long tipoClasi, Long clasi) throws Exception{
        DTOMensajeTipoCliente dtoTC = new DTOMensajeTipoCliente();
        traza("tipo clientes " + tipoClien);  

        dtoTC.setOidTipoCliente(tipoClien); 
        dtoTC.setOidSubtipoCliente(subtipoClien);
        dtoTC.setOidTipoClasificacion(tipoClasi);
        dtoTC.setOidClasificacion(clasi);
          
        return dtoTC;
        
    }

    private DTOMensajeUnidadAdministrativa crearDTOMensajeUnidadAdministrativa(Long region, Long zona, Long seccion, Long territorio) throws Exception{
        DTOMensajeUnidadAdministrativa dto = new DTOMensajeUnidadAdministrativa();

        dto.setOidRegion(region);
        dto.setOidZona(zona);
        dto.setOidSeccion(seccion);
        dto.setOidTerritorio(territorio);

        return dto;
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

    
}
