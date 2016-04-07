import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cob.DTOGestionDeCobranza;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesSession;
import java.util.Vector;

public class LPConsultarConsultorasPorTipoAccion extends LPSICCBase {

    private String accion;
    private String aUsuario;
    private Long aPais;
    private Long aIdioma;

    public LPConsultarConsultorasPorTipoAccion() {
    }

    public void inicio() throws Exception {
        
        pagina("contenido_consultoras_tipoAccion_consultar");
    }

    public void ejecucion() throws Exception {
        //rastreo();
        try  {            
            setTrazaFichero();
            
            accion = conectorParametroLimpia("accion","",true);
            aPais = UtilidadesSession.getPais(this);
            aIdioma = UtilidadesSession.getIdioma(this);
            aUsuario = UtilidadesSession.getIdUsuario(this);
            if(accion.equals(""))  {
                traza("La accion es igual a vacio..");
                cargarPagina();
            } else if(accion.equals("clienteSeleccionado")) {
                traza("La accion es igual a clienteSeleccionado..");
                clienteSeleccionado();
            } else if(accion.equals("compromisoPago")) {
                traza("La accion es igual a compromisoPago...");
                compromisoPago();
            } else if(accion.equals("detalle")) {
                traza("La accion es igual a detalle..");
                detalle();
            }
            getConfiguracionMenu();
        } catch(Exception e) {
            lanzarPaginaError(e);
            System.out.println("Entro al catch por...");
            e.printStackTrace();
        }
    }

    public void cargarPagina() throws Exception {
        traza("Ento a cargar Pagina....");
        DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(aIdioma);
        dtoBelcorp.setOidPais(aPais);
        traza("Seteo el DTO...");
        ComposerViewElementList composerviewelementlist = crearParametros(dtoBelcorp);
        ConectorComposerView conectorcomposerview = new ConectorComposerView(composerviewelementlist, getRequest());
        traza("Antes de ejecucion...");
        conectorcomposerview.ejecucion();
        traza("Antes de getConector");
        DruidaConector druidaconector = conectorcomposerview.getConector();
        traza("ESTE ES EL CONECTOR: " + druidaconector.getXML());
        asignar("COMBO", "cbAccion", druidaconector, "COBObtenerAccionesCobranza");
        asignarAtributo("VAR","hPais","valor",aPais.toString());
        asignarAtributo("VAR","hIdioma","valor",aIdioma.toString());
        asignarAtributo("VAR","hUsuario","valor",aUsuario);
        asignarAtributo("VAR","hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString());
        traza("termino se setear la pagina");
    }

    public void clienteSeleccionado() throws Exception {
        /*
        -> Llamar al subsistema "GestorCargaPantalla" con la siguiente información 
        -> idBusiness = "COBObtenerAccionesCobranza" y un DTOBelcorp => llena el combo "accionCobranza" 
        -> Tomar de sesión el parámetro "codigoCliente" y mapearlo en el campo "codigoCliente" de la pantalla 
        -> Deshabilitar el campo "codigoCliente" y el botón de búsqueda de clientes para que el usuario no pueda cambiarlo 
        -> Mostrar página
        */
        cargarPagina();
        String codigoCliente = (String) conectorParametro("codigoCliente");
        asignarAtributo("VAR","hCodigoCliente","valor",codigoCliente);
        asignarAtributo("VAR","hCodigoClienteHabilitado","valor","S");
    }

    public void compromisoPago() throws Exception {
        Long oidGestionCob = new Long(conectorParametro("hOidGestionCobranza"));
        pagina("contenido_seguimiento_telecobranza_realizar_compromiso_pago");
        asignarAtributo("VAR","oidGestionCobranza","valor",oidGestionCob.toString());
        asignarAtributo("VAR","oidPais","valor",aPais.toString());
        asignarAtributo("VAR","oidIdioma","valor",aIdioma.toString());
        /*
        -> Asignar página "contenido_seguimiento_telecobranza_realizar_compromiso_pago" 
        -> Tomar el oid de gestión de cobranza del registro seleccionado en la ventana llamante 
        y asignarlo al atributo "oidGestionCobranza" 
        */
    }

    public void detalle() throws Exception {
        /*
        -> Asignar página <<maquete de la página de detalle>> 
        -> Crear DTOOID con oid de gestión de cobranza del registro seleccionado en pantalla 
        -> Crear idBusiness = "COBObtenerDetalleGestionCobranza" 
        -> Asignar conector "ConectorObtenerDetalleGestionCobranza" con idBusiness y dto creados 
        -> Obtener DTODetalleGestionCobranza de respuesta 
        -> Mapear los datos de la pantalla de detalle con los valores del dto obtenido
        */
        
        Long oidGestionCob = new Long(conectorParametro("hOidGestionCobranza"));
        pagina("contenido_seguimiento_telecobranza_realizar_detalle");        
        DTOOID dto = new DTOOID();
        dto.setOidIdioma(aIdioma);
        dto.setOidPais(aPais);
        
        dto.setOid(oidGestionCob);
        
        MareBusinessID id = new MareBusinessID("COBDetalleGestion");
        Vector paramEntrada = new Vector();
        paramEntrada.add(dto);
        paramEntrada.add(id);
        traza("antes de ConectorDetalleGestion");
        DruidaConector conector = conectar("ConectorDetalleGestion", paramEntrada);
        traza("despues de ConectorDetalleGestion");
        DTOGestionDeCobranza dtoGC = (DTOGestionDeCobranza) conector.objeto("dtoSalida");
		traza(" dtoGC:    " + dtoGC);
        if (dtoGC != null)
        {            
            asignarAtributoPagina("cod","0281");
            vAsignaValoresPantalla(dtoGC);
            asignarAtributo("VAR","oidGestionCobranza","valor",oidGestionCob.toString());
        }
        
    }

    private ComposerViewElementList crearParametros(DTOBelcorp dto) throws Exception  {
        traza("Entro a crearParametros");
        ComposerViewElementList composerviewelementlist = new ComposerViewElementList();
        ComposerViewElement composerviewelement = new ComposerViewElement();
        composerviewelement.setIDBusiness("COBObtenerAccionesCobranza");
        composerviewelement.setDTOE(dto);
        composerviewelementlist.addViewElement(composerviewelement);
        traza("salio de crearParametros");
        return composerviewelementlist;
    }

        private void vAsignaValoresPantalla(DTOGestionDeCobranza dtoGC) throws Exception{
traza("Entrando a vAsignaValoresPantalla" );
        if (dtoGC != null )
        {
            if (dtoGC.getUsuarioCobranza() != null)
              vAsignaValor("lbldtUsuarioCobranza", dtoGC.getUsuarioCobranza());
            
			if (dtoGC.getEtapaDeuda() != null)
			  vAsignaValor("lbldtEtapaDeuda", dtoGC.getEtapaDeuda());
            
			if (dtoGC.getMarca() != null)
			  vAsignaValor("lbldtMarca", dtoGC.getMarca());
            
			if (dtoGC.getCanal() != null)
			  vAsignaValor("lbldtCanal", dtoGC.getCanal());
            
			if (dtoGC.getPeriodo() != null)
			  vAsignaValor("lbldtCodigoPeriodo", dtoGC.getPeriodo());
            
			if (dtoGC.getTipoCargo() != null)
			  vAsignaValor("lbldtTipoCargo", dtoGC.getTipoCargo());
            
			if (dtoGC.getSubgerenciaVentas() != null)
			  vAsignaValor("lbldtSubgerenciaVenta", dtoGC.getSubgerenciaVentas());
            
			if (dtoGC.getRegion() != null)
			  vAsignaValor("lbldtRegion", dtoGC.getRegion());
            
			if (dtoGC.getZona() != null)
			  vAsignaValor("lbldtZona", dtoGC.getZona());
            
			if (dtoGC.getSeccion() != null)
			  vAsignaValor("lbldtSeccion", dtoGC.getSeccion());
            
			if (dtoGC.getTerritorio() != null)
			  vAsignaValor("lbldtTerritorio", dtoGC.getTerritorio());
            
			if (dtoGC.getCodigoCliente() != null)
			  vAsignaValor("lbldtCodigoCliente", dtoGC.getCodigoCliente());
            
			if (dtoGC.getNombre() != null)
			  vAsignaValor("lbldtNombre", dtoGC.getNombre());
            
			if (dtoGC.getApellidos() != null)
			  vAsignaValor("lbldtApellidos", dtoGC.getApellidos());
            
			if (dtoGC.getAccion() != null)
			  vAsignaValor("lbldtAccion", dtoGC.getAccion());
            
			if (dtoGC.getFechaSeguimiento()!= null)
              vAsignaValor("lbldtFechaSeguimiento", dtoGC.getFechaSeguimiento().toString());
            
			if (dtoGC.getHoraSeguimiento()!= null)
			  vAsignaValor("lbldtHoraSeguimiento", dtoGC.getHoraSeguimiento());
            
			if (dtoGC.getCodCompromisoPago() != null)
                vAsignaValor("lbldtCodigoCompromisoPago", dtoGC.getCodCompromisoPago().toString());
            
			if (dtoGC.getFechaReprogramacion() != null)
                vAsignaValor("lbldtFechaReprogramacion", dtoGC.getFechaReprogramacion().toString());
            
			if (dtoGC.getHoraReprogramacion() != null)
			  vAsignaValor("lbldtHoraReprogramacion", dtoGC.getHoraReprogramacion());
            
			if (dtoGC.getAportaPrueba() != null)
			  vAsignaValorHidden("hDtAportaPrueba", obtenerValor(dtoGC.getAportaPrueba()));
            
			if (dtoGC.getDescripcionPrueba() != null)
			  vAsignaValor("lbldtDescripcionPrueba", dtoGC.getDescripcionPrueba());
            
			if (dtoGC.getNumeroDocSoporte() != null)
			  vAsignaValor("lbldtNumeroDocumentoSoporte", dtoGC.getNumeroDocSoporte());
            
			if (dtoGC.getTipoDocPago() != null)
			  vAsignaValor("lbldtTipoDocumentoPago", dtoGC.getTipoDocPago());
            
			if (dtoGC.getCodigoBanco() != null)
   			  vAsignaValor("lbldtBanco", dtoGC.getCodigoBanco());
            
			if (dtoGC.getCodigoSucursal() != null)
			  vAsignaValor("lbldtSucursal", dtoGC.getCodigoSucursal());
            
			if (dtoGC.getNuevaDireccion() != null)
			  vAsignaValor("lbldtNuevaDirreccion", dtoGC.getNuevaDireccion());
            
			if (dtoGC.getNuevoTelefono() != null)
			  vAsignaValor("lbldtNuevoTelefono", dtoGC.getNuevoTelefono());
            
			if (dtoGC.getPasaAdministrador() != null)
			  vAsignaValorHidden("hDtPasaAdministrador", obtenerValor(dtoGC.getPasaAdministrador()));
            
			if (dtoGC.getPeticionBloqueoAdmin() != null)
			  vAsignaValorHidden("hDtPeticionBloqueoAdministrativo", obtenerValor(dtoGC.getPeticionBloqueoAdmin()));
            
			if (dtoGC.getPeticionDesbloqueoAdmin() != null)
		 	  vAsignaValorHidden("hDdtPeticionDesBloqueoAdministrativo", obtenerValor(dtoGC.getPeticionDesbloqueoAdmin()));
            
			if (dtoGC.getVisadoAdministrador() != null)
			  vAsignaValorHidden("hDdtVisadoAdministrativo", obtenerValor(dtoGC.getVisadoAdministrador()));
            
			if (dtoGC.getMarcaComisionCalculada() != null)
			  vAsignaValorHidden("hDtMarcaComisionCalculada", obtenerValor(dtoGC.getMarcaComisionCalculada()));
            
			if (dtoGC.getMotivoNoCobro() != null)
			  vAsignaValor("lbldtMotivoNoCobro", dtoGC.getMotivoNoCobro());
            
			if (dtoGC.getObservaciones() != null)
			  vAsignaValor("lbldtObservaciones", dtoGC.getObservaciones());
        }
traza("Saliendo de vAsignaValoresPantalla" );
    }
    
    private void vAsignaValor(String sLabel, String sValor) throws Exception{
        asignarAtributo("LABELC", sLabel, "valor", (sValor==null? "": sValor));    
    }
    
    private void vAsignaValor(String sLabel, Long lValor) throws Exception{
        if (lValor != null)
            asignarAtributo("LABELC", sLabel, "valor", (lValor.toString()==null? "": lValor.toString()));    
    }

	private void vAsignaValorHidden(String nombre, String lValor) throws Exception{
        if (lValor != null)
            asignarAtributo("VAR", nombre, "valor", lValor);    
    }

    private String obtenerValor(Boolean bool) throws Exception{
        if (bool != null) {
            if(bool.booleanValue()) {
                return "S";
			} else if(!bool.booleanValue()) {
                return "N";
			}
        } if (bool == null) {
			traza("retorna nulo");
			return "";
		}

		return "";
	}
}
