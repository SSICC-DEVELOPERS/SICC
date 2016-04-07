import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOProductoSustitutivo;
import es.indra.sicc.dtos.mae.DTOBusquedaMateriales;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.dtos.inc.DTOPremioSustitutivo;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.inc.ConstantesINC;

public class LPMantenerBolsaDeFaltantes extends LPSICCBase  {   
   private String accion = null;
   private String sPais = null;
   private String sIdioma = null;
   private String constSitRegHist = null;  

   public LPMantenerBolsaDeFaltantes() { super(); }

   public void inicio() throws Exception {
      traza("LPMantenerBolsaDeFaltantes.inicio() - Entrada");      
      pagina("contenido_bolsa_faltantes_mantener"); 
	  getFormatosValidaciones();
      traza("LPMantenerBolsaDeFaltantes.inicio() - Salida");            
   }
 
   public void ejecucion() throws Exception {
      traza("LPMantenerBolsaDeFaltantes.ejecucion() - Entrada");      
      setTrazaFichero();      
      try {
          
		sIdioma = UtilidadesSession.getIdioma(this).toString();      
        traza(" idioma en ejecucion: " + sIdioma);
        asignarAtributo("VAR","hIdioma", "valor", sIdioma); 
          
        sPais = UtilidadesSession.getPais(this).toString();
        traza(" pais en ejecucion: " + sPais);
        asignarAtributo("VAR","hPais", "valor", sPais);
          
        accion = this.conectorParametro("accion");
        traza(" accion en ejecucion: " + accion);
          
        if(this.accion==null){this.accion = "";
			asignarAtributo("VAR","accion","valor",accion);
			traza("accion: " + this.accion);
        }
		
		constSitRegHist = ConstantesINC.SITUACION_REGISTRO_HISTORICA.toString();
        asignarAtributo("VAR","hConstSitRegHist", "valor", constSitRegHist);
                  
        if(accion.equals("")){
			this.inicializar();
			getConfiguracionMenu("LPMantenerBolsaDeFaltantes", accion);
           
        }
		else if( accion.equals("inicioDetalle") ){
			this.inicializarDetalle();
			getConfiguracionMenu("LPMantenerBolsaDeFaltantes", accion);           
        }
		else if( accion.equals("guardarProductosSustitutivos") ){
			this.guardarProductosSustitutivos();
        }

	    getFormatosValidaciones();
		getConfiguracionMenu();
	    traza("LPMantenerBolsaDeFaltantes.ejecucion() - Salida");        
      }
      catch (Exception e) {
         traza("-------- EXCEPTION en LPMantenerBolsaDeFaltantes");
         e.printStackTrace();
         lanzarPaginaError(e);         
      }   
   }

   public void inicializar() throws Exception {     
	  traza("LPMantenerBolsaDeFaltantes.inicializar() - Entrada");         

      ComposerViewElementList compViewList = new ComposerViewElementList();
      
      DTOBelcorp dtoe = new DTOBelcorp();
      dtoe.setOidPais(new Long(sPais));
      dtoe.setOidIdioma(new Long(sIdioma));
      
      ComposerViewElement compElem = new ComposerViewElement();
      compElem.setIDBusiness("INCConsultaCodConcurso");
      compElem.setDTOE(dtoe);
      
      compViewList.addViewElement(compElem);
            
      DTOBusquedaMateriales dtoCritMat = new DTOBusquedaMateriales();
      dtoCritMat.setOidPais(new Long(sPais));
	  dtoCritMat.setOidIdioma(new Long(sIdioma));
      
      ComposerViewElement compElem1 = new ComposerViewElement();
      compElem1.setIDBusiness("MAEBuscarMateriales");
      compElem1.setDTOE(dtoCritMat);   
      
      compViewList.addViewElement(compElem1);
       
      DTOUnidadAdministrativa dtoUnidadAdmin = new DTOUnidadAdministrativa();
      dtoUnidadAdmin.setOidPais(new Long(sPais));
      
	  MareBusinessID id = new MareBusinessID("MLNFObtenerZonasNoBorradas");
      Vector paramEntrada = new Vector();

	  paramEntrada.add(dtoUnidadAdmin);
	  paramEntrada.add(id);

	  DruidaConector conectorObjeto = conectar("ConectorObtenerZonasNoBorradas", paramEntrada);

	  DTOSalida dtoSalida = (DTOSalida)conectorObjeto.objeto("dtoSalida");
	  
	  this.asignar("COMBO", "cbZona", generarConectorComboZona(dtoSalida.getResultado()));

	  MareBusinessID idR = new MareBusinessID("MLNFObtenerRegionesNoBorradas");
      Vector paramEntradaR = new Vector();

	  paramEntradaR.add(dtoUnidadAdmin);
	  paramEntradaR.add(idR);

	  DruidaConector conectorObjetoR = conectar("ConectorObtenerRegionesNoBorradas", paramEntradaR);

	  DTOSalida dtoSalidaR = (DTOSalida)conectorObjetoR.objeto("dtoSalida");
	  
	  this.asignar("COMBO", "cbRegion", generarConectorComboRegion(dtoSalidaR.getResultado()));

      DTOBelcorp dtoe1 = new DTOBelcorp();
      dtoe1.setOidPais(new Long(sPais));
      dtoe1.setOidIdioma(new Long(sIdioma));
      
      ComposerViewElement compElem4 = new ComposerViewElement();
      compElem4.setIDBusiness( "INCCargarSituacionRegistro" );
      compElem4.setDTOE( dtoe1 );
      
      compViewList.addViewElement(compElem4);
      
      ConectorComposerView conector = new ConectorComposerView(compViewList, this.getRequest());
      conector.ejecucion();
      DruidaConector con = conector.getConector();

	  asignar("COMBO", "cbSituacionRegistro", con, "INCCargarSituacionRegistro");
      asignar("COMBO", "cbCodConcurso", con, "INCConsultaCodConcurso");
      asignar("COMBO", "cbCodProducto", con, "MAEBuscarMateriales");

  	  traza("LPMantenerBolsaDeFaltantes.inicializar() - Salida");        
   }

	 private DruidaConector generarConectorComboZona(RecordSet rs) throws Exception {
		RecordSet raux = new RecordSet();
		traza("rs: "+rs);
		
		raux.addColumn("OID");
        raux.addColumn("DESC");

		for (int fila = 0; rs.existeFila(fila); fila++) {
			Vector v = new Vector();	
			BigDecimal oidZona = (BigDecimal) rs.getValueAt(fila, "OID_ZONA");
			String descZona = (String) rs.getValueAt(fila, 5);

			v.add(new Long(oidZona.longValue()));
			v.add(descZona);
			raux.addRow(v);
		}

		return UtilidadesBelcorp.generarConector("dtoSalida", raux, raux.getColumnIdentifiers());

	 
	 }

	 private DruidaConector generarConectorComboRegion(RecordSet rs) throws Exception {
		RecordSet raux = new RecordSet();
		traza("rs: "+rs);
		
		raux.addColumn("OID");
        raux.addColumn("DESC");

		for (int fila = 0; rs.existeFila(fila); fila++) {
			Vector v = new Vector();	
			BigDecimal oidZona = (BigDecimal) rs.getValueAt(fila, "OID_REGI");
			String descZona = (String) rs.getValueAt(fila, 5);

			v.add(new Long(oidZona.longValue()));
			v.add(descZona);
			raux.addRow(v);
		}

		return UtilidadesBelcorp.generarConector("dtoSalida", raux, raux.getColumnIdentifiers());

	 
	 }




   public void inicializarDetalle() throws Exception {
      traza("-------- INICIA 'inicializarDetalle()'");
   
      pagina("contenido_bolsa_faltantes_detalle");
      getFormatosValidaciones();
      traza("-------- Se asignó 'página= contenido_bolsa_faltantes_detalle'");
   
      String auxConcurso= conectorParametroLimpia("oidConcurso", "", true);
      String auxCliente= conectorParametroLimpia("oidCliente", "", true);
      String auxSolicitud= conectorParametroLimpia("oidSolicitud", "", true);
      String auxNumPremio= conectorParametroLimpia("numero_premio", "", true);
      String auxRegion= conectorParametroLimpia("oidRegion", "", true);
      String auxZona = conectorParametroLimpia("oidZona", "", true);
      
      asignarAtributo( "VAR", "hOidConcurso", "valor", auxConcurso );
      asignarAtributo( "VAR", "hOidSolicitud", "valor", auxSolicitud );
      asignarAtributo( "VAR", "hOidCliente", "valor", auxCliente );
      asignarAtributo( "VAR", "hNumeroPremioFaltante", "valor", auxNumPremio );
      asignarAtributo( "VAR", "hOidRegion", "valor", auxRegion );
      asignarAtributo( "VAR", "hOidZona", "valor", auxZona );
	  //Inc 20647
	  asignarAtributo( "VAR", "constSinPremio", "valor", ConstantesINC.TIPO_CAMBIO_SIN_PREMIO.toString());
      traza("-------- Se asignó 'hOidConcurso', 'hOidSolicitud', 'hOidCliente', " +
            "'hNumeroPremioFaltante', 'hOidRegion' y 'hOidZona'");
      
      ComposerViewElementList compViewList = new ComposerViewElementList();
      traza("-------- Se creó 'ComposerViewElementList= compViewList'");
      
      DTOBelcorp dtoe= new DTOBelcorp();
      dtoe.setOidPais( new Long(sPais));
      dtoe.setOidIdioma(new Long(sIdioma));
      traza("-------- Se creó 'DTOBelcorp= dtoe'");
      traza("-------- Se asignó 'Pais' e 'Idioma'");      
      
      ComposerViewElement compElem = new ComposerViewElement();
      compElem.setIDBusiness( "MSGObtenerCodigosMensajesPorPais" );
      compElem.setDTOE( dtoe );
      traza("-------- Se creó 'ComposerViewElement= compElem'");
      traza("-------- Se asignó 'setIDBusiness' y 'setDTOE'");
      
      compViewList.addViewElement( compElem );
      traza("-------- Se agregó 'addViewElement( compElem )'");
      
      ComposerViewElement compElem1 = new ComposerViewElement();
      compElem1.setIDBusiness("MAEObtenerProductosPais");
      compElem1.setDTOE( dtoe );
      traza("-------- Se creó 'ComposerViewElement= compElem1'");
      traza("-------- Se asignó 'setIDBusiness' y 'setDTOE'");
      
      compViewList.addViewElement( compElem1 );
      traza("-------- Se agregó 'addViewElement( compElem1 )'");
      
      DTOBelcorp dtoe1= new DTOBelcorp();
      dtoe1.setOidPais(new Long(sPais));
      dtoe1.setOidIdioma(new Long(sIdioma));
      traza("-------- Se creó 'DTOBelcorp= dtoe1'");
      traza("-------- Se asignó 'Pais' e 'Idioma'");
      
      ComposerViewElement compElem2 = new ComposerViewElement();
      compElem2.setIDBusiness( "INCCargarTipoCambio" );
      compElem2.setDTOE( dtoe1 );
      traza("-------- Se creó 'ComposerViewElement= compElem2'");
      traza("-------- Se asignó 'setIDBusiness' y 'setDTOE'");
      
      compViewList.addViewElement( compElem2 );
      traza("-------- Se agregó 'addViewElement( compElem2 )'");
      
      ConectorComposerView conector = 
                  new ConectorComposerView(compViewList, this.getRequest());
      traza("-------- Antes de conector.ejecucion();");
      conector.ejecucion();
      traza("-------- Despues de conector.ejecucion();");
      DruidaConector con = conector.getConector();
      traza("-------- Se invocó al subsistema GestorCargaPantalla");
      
       asignar("COMBO", "cbCodMensaje", con, "MSGObtenerCodigosMensajesPorPais");
       asignar("COMBO", "cbProducto", con, "MAEObtenerProductosPais");
       asignar("COMBO", "cbTipoCambio", con, "INCCargarTipoCambio");
       traza("-------- Se asignó 'cbComboMensaje', 'cbProducto' y 'cbTipoCambio'");
       
        
       traza("-------- FINALIZA 'inicializarDetalle()'");
   }
   
   public void guardarProductosSustitutivos() throws Exception {      
      traza("LPMantenerBolsaDeFaltantes.guardarProductosSustitutivos() - Entrada");
      pagina("salidaGenerica");

	  try  {
        DTOPremioSustitutivo dtoPremioSus= new DTOPremioSustitutivo();
        dtoPremioSus.setOidPais(new Long(sPais));

		traza("***cbTipoCambio: "+ conectorParametroLimpia("cbTipoCambio", "", true ));
        dtoPremioSus.setTipoCambio(new Long(conectorParametroLimpia("cbTipoCambio", "", true )));
        
        traza("***atxtObservaciones: "+conectorParametroLimpia("atxtObservaciones", "", true));
        dtoPremioSus.setObservacionesCambio(conectorParametroLimpia("atxtObservaciones", "", true));
        
        traza("***hOidConcurso"+conectorParametroLimpia("hOidConcurso", "", true));
        dtoPremioSus.setOidConcurso(new Long(conectorParametroLimpia("hOidConcurso", "", true)));
        
        traza("***hOidSolicitud: "+conectorParametroLimpia("hOidSolicitud", "", true));
        dtoPremioSus.setOidSolicitud(new Long(conectorParametroLimpia("hOidSolicitud", "", true)));
        
        traza("***hOidCliente: "+conectorParametroLimpia("hOidCliente", "", true));
        dtoPremioSus.setOidCliente(new Long(conectorParametroLimpia("hOidCliente", "", true)));
        
        ArrayList lista= new ArrayList();
        DTOProductoSustitutivo dtoProd;
        String valoresListaEditable = this.conectorParametro("valoresListaEditable");
        StringTokenizer st1 = new StringTokenizer(valoresListaEditable,"|");
        int cantLineas = st1.countTokens();        
                
        for( int i = 0; i < cantLineas; i++ ){
           traza(" Linea nro: " + i);
           
           String linea = st1.nextToken();
           traza(" Linea: " + linea);
  
           StringTokenizer st2 = new StringTokenizer(linea,",");
           int cantColumnas = st2.countTokens();
           traza("************ cantidad de Columnas: " + cantColumnas);
           
           dtoProd = new DTOProductoSustitutivo();
           String oidProducto = st2.nextToken();
           traza("***oidProducto "+ oidProducto);
           dtoProd.setOidProducto(new Long(oidProducto));
           
           String codSap = st2.nextToken();
           traza("***codSap "+codSap);
           dtoProd.setCodSap(codSap);
           
           String cantidad = st2.nextToken();
           traza("***Cantidad "+ cantidad);
           dtoProd.setCantidad(new Long(cantidad)); 
           
           traza("***dtoProd.getCantidad() "+dtoProd.getCantidad());           
           lista.add(dtoProd);
        }
        
        String numeroPremioFaltante = conectorParametroLimpia("hNumeroPremioFaltante", "", true);
        traza("******* numeroPremioFaltante: "+numeroPremioFaltante);
        dtoPremioSus.setNumeroPremioFaltante((numeroPremioFaltante.equals(""))?null:new Long(numeroPremioFaltante));
        
        String oidRegion = conectorParametroLimpia("hOidRegion", "", true);
        traza("******* oidRegion: "+oidRegion);           
        dtoPremioSus.setOidRegion((oidRegion.equals(""))?null:new Long(oidRegion));
        
        String oidZona = conectorParametroLimpia("hOidZona", "", true);
        traza("******* oidZona: "+oidZona);
        dtoPremioSus.setOidZona((oidZona.equals(""))?null:new Long(oidZona));
        
        dtoPremioSus.setCodigoMensaje(conectorParametroLimpia("hDescCodMensaje", "", true));
        traza("******* DesCodMensaje: "+dtoPremioSus.getCodigoMensaje());
        
        dtoPremioSus.setProductosSustitutivos(lista);
        
        MareBusinessID idBusiness = new MareBusinessID("INCGuardarAsignacionFaltantes");
        
        Vector params = new Vector();
        params.add(dtoPremioSus);
        params.add(idBusiness);
        traza("*** ANTES DE CONECTAR");
        DruidaConector ConectorGrabarMensajesLote = conectar("ConectorGuardasAsignacionFaltantes", params); 
        traza("*** DESPUES DE CONECTAR");

		traza("LPMantenerBolsaDeFaltantes.guardarProductosSustitutivos() - Salida");
        asignarAtributo("VAR","ejecutar","valor","reInicio()"); 
      }
      catch (Exception e) {
        traza("******** Entro al catch debido a...");        
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardarI()"); 
        e.printStackTrace(); 
        lanzarPaginaError(e);
      }
   }  
}