//import LPSICCBase;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.ListaEditableDinamica;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTODetalleOferta;
import es.indra.sicc.dtos.pre.DTOGrupo;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOModificarOferta;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOVentaExclusiva;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

public class LPConsultarOferta extends LPSICCBase{

    private Long pais = null;
    private Long idioma = null;
    private String soloImprimible = null;
    Document doc = null;
    XMLDocument xml = null;


    private String accion=null;
    private String casoDeUso=null;
    private Long oidCabeceraMF = null;
    private Long oidOferta = null;
    private String pais2 = null;
    private String marca = null;
    private String canal = null;
    private String periodo = null;
    private String nueva = null;
    private String nombreLista = "";
    private String deshabilitar = null; 
    DruidaConector ConectorCargarCriteriosBusquedaProductos = null;
    DruidaConector conObtenerOferta;

    private Element table = null;
    private Element fieldset1 = null;
    private Element tablaDentro = null;
    private Element tablaAfuera = null;
    private Element trTablaAfuera = null;
    private Element tr = null;
    private Element listaEditableObtenida = null;   
    DTOPromocion elemPromocion = null;
    long indice = 0;
    static int TAMANOPAGINASINDINAMICA = 757;
    Integer yLista;//913
    
    private Long oidTipoCliente = null;
    private Long oidSubtipoCliente = null;
    private Long oidTipoClasificacion = null;
    private Long oidClasificacion = null;
    private Long oidEstatus = null;
    private String desTipoCliente = null;
    private String desSubtipoCliente = null;
    private String desTipoClasificacion = null;
    private String desClasificacion = null;
    private String desEstatus = null;
    private Long oidVentaExclusiva = null;
    private String estatus2;
    private String elementosSeleccionadosVentaExclusiva = null;
    private String elementosSeleccionadosProductosAsociados = null;
    private Long oidEstrategia = null;
    private Long oidFormaPago = null;
    private Long oidArgumentoVenta = null;
    private String despachoCompleto = null;
    private String despachoAutomatico = null;
    private Long oidIndicadorCuadre = null;
    private Integer numeroGrupos = null;
    private Integer numeroPaquetes = null;
    private Integer numeroGruposCondicionantes = null;
    private Integer numeroGruposCondicionados = null;
    private String condicionCondicionantes = null;
    private String condicionCondicionados = null;
    private Integer numeroOrden = null;
    private String recupObligatoria = null;
    private Long oidAcceso = null;
    private Long oidSubacceso = null;
    private Long oidGrupo = null;
    private Long nroGrupo = null;
    private Long oidPromocion = null;
    Vector vectorDtoPromo = new Vector();
    Vector vectorPromocion = new Vector();
    Vector v;
    char p = 'P';
    char r = 'R';
    char s = 'S';

    private Element table1 = null;
    private Element table2 = null;
    private Element table3 = null;
    private Element table4 = null;
    private Element table5 = null;
    private Element table6 = null;
    private Element tablaAfueraG = null;
    //private Element tablaEnglobaG = null;
    private Element div = null;
    private Element tr1 = null;
    private Element tr2 = null;
    private Element tr3 = null;
    private Element tr4 = null;
    private Element tr5 = null;
    private Element tr6 = null;
    private Element tr7 = null;
    private Element tr8 = null;
    private int contador = 0;
    private Element fieldset2 = null;
    private Element fieldset3 = null;
    private Element fieldset4 = null;
    private Element trEngloba = null;
    private Element legend1 = null;

    public LPConsultarOferta()  {
        super();
    }  

    public void inicio() throws Exception {
    }

    public void ejecucion() throws Exception{

         
        setTrazaFichero();
        casoDeUso = "consultar";

				try{
            idioma = UtilidadesSession.getIdioma(this);
            pais = UtilidadesSession.getPais(this);

            accion = conectorParametro("accion")==null?"":conectorParametro("accion");
            //nueva  = conectorParametro("nueva","",true);
            traza("accion: "+ accion);
					
            if (accion.equals("")){
                rastreo();
                traza("==============>  ENTRA ACCION VACIA ");  
                conectorParametroSesion("UltimaLP","LPConsultarOferta");
                conectorAction("LPSeleccionarMF");
                //esto hay que preguntarlo
                conectorActionParametro("nueva","");
            }else if (accion.equals("Matriz seleccionada")){
                
                traza("==============>  ENTRA ACCION MATRIZ SELECCIONADA ");
                this.oidCabeceraMF = (conectorParametroSesion("oidCabeceraMF") == null || conectorParametroSesion("oidCabeceraMF").equals(""))?
                                      null: (Long)(conectorParametroSesion("oidCabeceraMF"));
                //traza("this.oidCabeceraMF: "+ this.oidCabeceraMF);
                this.cargarCriteriosBusqueda();
            }
            else if (accion.equals("obtenerOferta")){
                traza("==============>  ENTRA ACCION OBTENER OFERTA ");
                this.pagina("contenido_ofertas_modificar");
                this.getFormatosValidaciones();
                asignarAtributoPagina("cod","0182");
                getConfiguracionMenu();	
                asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
                this.obtenerOferta(); 
            }
            //getConfiguracionMenu();
            
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
            
        }catch (Exception ex){
            traza("==============>  ENTRO AL CATCH ");
			asignarAtributo("VAR","pais","valor",pais==null?"":pais.toString());
			asignarAtributo("VAR","hIdioma","valor",idioma==null?"":idioma.toString());
            asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
            logStackTrace(ex);
            this.lanzarPaginaError(ex);
        }

        asignarAtributo("VAR","pais","valor",pais==null?"":pais.toString());
        asignarAtributo("VAR","hIdioma","valor",idioma==null?"":idioma.toString());
        asignarAtributo("VAR", "varNombresListasDinamicas","valor", this.nombreLista);
	}

	public void cargarCriteriosBusqueda() throws Exception {
        traza("==============>  ENTRA CARGAR CRITERIOS BUSQUEDA ");
        this.pagina("contenido_oferta_seleccionar");
        this.getFormatosValidaciones();
        asignarAtributo("VAR", "casoDeUso", "valor", casoDeUso);
        getConfiguracionMenu("LPConsultarOferta","Matriz seleccionada");
        //traza(oidCabeceraMF==null?"":oidCabeceraMF.toString());
        asignarAtributo("VAR","hidOidCabeceraMF","valor",oidCabeceraMF==null?"":oidCabeceraMF.toString());
        asignarAtributo("VAR","pais","valor",pais==null?"":pais.toString());
        Vector paramEntrada = new Vector();
        DTOOID dto = new DTOOID();
        DruidaConector conModulos = null;
        dto.setOidPais(accion.equals("")?UtilidadesSession.getPais(this):pais);
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));
        dto.setOid(oidCabeceraMF);
        paramEntrada.add(dto);
        paramEntrada.add(new MareBusinessID("PRECargarCriteriosBusquedaProductos"));

        ConectorCargarCriteriosBusquedaProductos = conectar("ConectorCargarCriteriosBusquedaProductos",paramEntrada);

        DTOSCargarCriteriosBusquedaProductos  dtoCCBP     = (DTOSCargarCriteriosBusquedaProductos)
        ConectorCargarCriteriosBusquedaProductos.objeto("dtoSalida");
        //conectorParametroSesion("DTOSCargarCriteriosBusquedaProductos",dtoCCBP);
        //traza("dto: " + dtoCCBP);

        RecordSet rsCatalogos         = (RecordSet)dtoCCBP.getCatalogos();
        Vector colIDCatalogos         = rsCatalogos.getColumnIdentifiers();
        int numColCatalogos           = rsCatalogos.getColumnCount();
        DruidaConector catalogos       = this.generarConector("DTOSalida.resultado_ROWSET",rsCatalogos, colIDCatalogos );
        asignar("COMBO","cbCatalogo", catalogos, "DTOSalida.resultado_ROWSET");

        RecordSet rsEstrategias         = (RecordSet)dtoCCBP.getEstrategias();
        Vector colIDEstrategias         = rsEstrategias.getColumnIdentifiers();
        int numColEstrategias           = rsEstrategias.getColumnCount();
        DruidaConector estrategias      = this.generarConector("DTOSalida.resultado_ROWSET",rsEstrategias, colIDEstrategias );
        asignar("COMBO","cbEstrategia", estrategias, "DTOSalida.resultado_ROWSET");

        RecordSet rsMarca         = (RecordSet)dtoCCBP.getMarcas();
        Vector colIDMarca         = rsMarca.getColumnIdentifiers();
        int numColMarca           = rsMarca.getColumnCount();
        DruidaConector marca       = this.generarConector("DTOSalida.resultado_ROWSET",rsMarca, colIDMarca );
        asignar("COMBO","cbMarca",marca,"DTOSalida.resultado_ROWSET");	

        RecordSet rsLineaProducto         = (RecordSet)dtoCCBP.getLineasProducto();
        Vector colIDLineaProducto         = rsLineaProducto.getColumnIdentifiers();
        int numColLineaProducto           = rsLineaProducto.getColumnCount();
        DruidaConector LineaProducto       = this.generarConector("DTOSalida.resultado_ROWSET",rsLineaProducto, colIDLineaProducto );
        asignar("COMBO","cbLineaProducto",LineaProducto,"DTOSalida.resultado_ROWSET");
        
        RecordSet rsUnidadNegocio         = (RecordSet)dtoCCBP.getUnidadesNegocio();
        Vector colIDUnidadNegocio         = rsUnidadNegocio.getColumnIdentifiers();
        int numColUnidadNegocio           = rsUnidadNegocio.getColumnCount();
        DruidaConector UnidadNegocio       = this.generarConector("DTOSalida.resultado_ROWSET",rsUnidadNegocio, colIDUnidadNegocio);
        asignar("COMBO","cbUnidadNegocio",UnidadNegocio,"DTOSalida.resultado_ROWSET");			

        RecordSet rsNegocio         = (RecordSet)dtoCCBP.getNegocios();
        Vector colIDNegocio         = rsNegocio.getColumnIdentifiers();
        int numColNegocio           = rsNegocio.getColumnCount();
        DruidaConector Negocio       = this.generarConector("DTOSalida.resultado_ROWSET",rsNegocio, colIDNegocio);
        asignar("COMBO","cbNegocio",Negocio,"DTOSalida.resultado_ROWSET");			

        RecordSet rsGenerico         = (RecordSet)dtoCCBP.getGenericos();
        Vector colIDGenerico         = rsGenerico.getColumnIdentifiers();
        int numColGenerico           = rsGenerico.getColumnCount();
        DruidaConector Generico       = this.generarConector("DTOSalida.resultado_ROWSET",rsGenerico, colIDGenerico);
        asignar("COMBO","cbGenerico",Generico,"DTOSalida.resultado_ROWSET");			

        RecordSet rsSuperGenerico         = (RecordSet)dtoCCBP.getSupergenericos();
        Vector colIDSuperGenerico         = rsSuperGenerico.getColumnIdentifiers();
        int numColSuperGenerico           = rsSuperGenerico.getColumnCount();
        DruidaConector SuperGenerico       = this.generarConector("DTOSalida.resultado_ROWSET",rsSuperGenerico, colIDSuperGenerico);
        asignar("COMBO","cbSuperGenerico",SuperGenerico,"DTOSalida.resultado_ROWSET");		     
		}

    public void obtenerOferta() throws Exception {
        traza("obtenerOferta()");
		Vector paramEntrada = new Vector();
        DTOOID dto = new DTOOID();
        Long oidOferta = new Long(conectorParametroLimpia("hidOidOferta","",true));
        traza("oidOferta: " + oidOferta);
		dto.setOid(oidOferta);
        dto.setOidIdioma(idioma);
        dto.setOidPais(this.pais);
        paramEntrada.add(dto);
        paramEntrada.add(new MareBusinessID("PREObtenerOferta"));
		traza("ConectorObtenerOferta");
        conObtenerOferta = conectar("ConectorObtenerOferta",paramEntrada);
        DTOOferta  dtoOferta = (DTOOferta) conObtenerOferta.objeto("dtoSalida");
		traza("dto: " + dtoOferta);

        DTOOID dtoOID = new DTOOID();
        dtoOID.setOid(oidOferta);
        dtoOID.setOidIdioma(this.idioma);
        dtoOID.setOidPais(this.pais);
        paramEntrada = new Vector();
        paramEntrada.add(dtoOID);
        paramEntrada.add(new MareBusinessID("PREObtenerOfertaModificacion"));
        DruidaConector conObtenerOfertaModif = conectar("ConectorObtenerOfertaModificacion",paramEntrada);
        DTOModificarOferta dtoModifOferta = (DTOModificarOferta) conObtenerOfertaModif.objeto("dtoSalida");
        this.oidCabeceraMF = dtoModifOferta.getDtoOferta().getOidCabeceraMF();
        this.oidEstrategia = dtoModifOferta.getDtoOferta().getOidEstrategia();
        conectorParametroSesion("DTOSCargarCriteriosDefinirOferta",dtoModifOferta.getDtoCargarCriterios());
        asignarAtributo("VAR","hDeshabilitaTodo","valor", "S");
        
        // Agregado por SICC20070316 - Rafael Romero - 18/07/2007
        conectorParametroSesion("DTOOferta", dtoOferta);
        // fin agregado SICC20070316
        

        cargarPantalla(dtoOferta);
    }

		
    private void cargarPantalla(DTOOferta dtoOferta) throws Exception {
        traza("metodo cargarPantalla()");
        getConfiguracionMenu("LPConsultarOferta","obtenerOferta");

        // Agregado por SICC20070316 - Rafael Romero - 20/07/2007
        conectorParametroSesion("descripcionCatalogo",dtoOferta.getDescripcionCatalogo().toString());
        // Fin agregado SICC20070316

        DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta = (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        RecordSet accesos = (RecordSet) dtoCargarCriterioDefOferta.getAccesos();
        Vector accesosCol = new Vector();
        accesosCol = accesos.getColumnIdentifiers();

        RecordSet argumentosVenta = (RecordSet) dtoCargarCriterioDefOferta.getArgumentosVenta();
        XMLDocument xmlDoc = new XMLDocument();
        DruidaConector oCnn = new  DruidaConector();
        oCnn = UtilidadesBelcorp.generarConector("DTOSalida.argumentosventa_ROWSET", argumentosVenta, argumentosVenta.getColumnIdentifiers());
     
        asignar("COMBO", "cbArgumentoVenta" ,oCnn , "DTOSalida.argumentosventa_ROWSET");

            
        RecordSet tipoCliente = (RecordSet) dtoCargarCriterioDefOferta.getTiposCliente();
        asignar("COMBO", "cbTipoCliente",
                UtilidadesBelcorp.generarConector("DTOSalida.tipocliente_ROWSET",
                tipoCliente, tipoCliente.getColumnIdentifiers()),
                "DTOSalida.tipocliente_ROWSET");
      
        RecordSet estatus = (RecordSet) dtoCargarCriterioDefOferta.getEstatus();
        asignar("COMBO", "cbEstatusCliente",
                UtilidadesBelcorp.generarConector("DTOSalida.estatus_ROWSET", estatus,
                estatus.getColumnIdentifiers()), "DTOSalida.estatus_ROWSET");

        RecordSet formaPago = (RecordSet) dtoCargarCriterioDefOferta.getFormasPago();
        asignar("COMBO", "cbFormasPago",
                UtilidadesBelcorp.generarConector("DTOSalida.formapago_ROWSET",
                formaPago, formaPago.getColumnIdentifiers()),
                "DTOSalida.formapago_ROWSET");

        //cargamos Datos de la oferta
        asignarAtributo("LABELC", "lblAccesoXX", "valor",
            ((dtoOferta.getDescripcionAcceso() == null) ? ""
                                         : dtoOferta.getDescripcionAcceso()));
        asignarAtributo("LABELC", "lblSubaccesoXX", "valor",
            ((dtoOferta.getDescripcionSubacceso() == null) ? ""
                                            : dtoOferta.getDescripcionSubacceso()));

        asignarAtributo("LABELC", "lbldtEstrategia", "valor",
            ((dtoOferta.getDescripcionEstrategia() == null) ? ""
                                            : dtoOferta.getDescripcionEstrategia()));
        asignarAtributo("LABELC", "lbldtCatalogo", "valor",
            ((dtoOferta.getDescripcionCatalogo() == null) ? ""
                                            : dtoOferta.getDescripcionCatalogo()));
		
		asignarAtributo("VAR", "hidOidArgVenta", "valor",
            ((dtoOferta.getOidArgumentoVenta() == null) ? ""
                                         : dtoOferta.getOidArgumentoVenta()
                                                    .toString()));

/*        asignarAtributo("CTEXTO", "txtNumeroOrden", "valor",
            ((dtoOferta.getNumeroOrden() == null) ? ""
                                   : dtoOferta.getNumeroOrden()
                                              .toString()));
  */  
        //cargar cbIndicador de Cuadre
        RecordSet indicadorCuadre = (RecordSet) dtoCargarCriterioDefOferta.getIndicadoresCuadre();
        if ( /*((dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 5) ||
             (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 6) ||
             (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 7)  )&&*/
             (dtoCargarCriterioDefOferta.getTipoEstrategia().getEstrategiaGrupo()!=null &&
              dtoCargarCriterioDefOferta.getTipoEstrategia().getEstrategiaGrupo().booleanValue() == Boolean.TRUE.booleanValue()) &&
             (dtoCargarCriterioDefOferta.getEstrategia().getCuadreGrupos()!=null &&
              dtoCargarCriterioDefOferta.getEstrategia().getCuadreGrupos().booleanValue() == Boolean.FALSE.booleanValue())&&
              (indicadorCuadre!=null)) {
             //habilitar indicador de cuadre    
             //si el valor del hidHabilitaIndicadorCuadre ="S"
            traza("entro por indCuadre");
            asignarAtributo("VAR", "hidHabilitaIndicadorCuadre", "valor", "S");
           
            //inicio codigo copiado definir oferta
            //se recupera el valor del campo numero de grupos
                String snumGrupos = conectorParametro("txtNumeroGrupos");
                int nroGrp = 0;

                if ((snumGrupos != null) && (!snumGrupos.equals(""))) {
                    nroGrp = (new Integer(snumGrupos)).intValue();

                    if (nroGrp > 0) {
                        if (nroGrp == 1) {

                            RecordSet rsFiltra = new RecordSet();
                            rsFiltra = RecordSet.clone(indicadorCuadre);

                            int cantRows = rsFiltra.getRowCount();

                            //Hay que filtrar el Recordset y generar el conector
                            traza("cambiaNumeroGrupos1a");

                            for (int i = (cantRows - 1); i >= 0; i--) {
                                traza("clase:" +
                                    rsFiltra.getValueAt(i, "IND_OFER_MONO_GRUP")
                                            .getClass().getName());

                                if (((String) rsFiltra.getValueAt(i,
                                            "IND_OFER_MONO_GRUP")).equals(
                                            new String("1"))) {
                                    //este registro va                          
                                } else {
                                    //se quita esta fila
                                    rsFiltra.removeRow(i);
                                }
                            }

                            traza("cambiaNumeroGrupos1a1");
                        } else {
                            traza("cambiaNumeroGrupos1b");

                            RecordSet rsFiltra = new RecordSet();
                            rsFiltra = RecordSet.clone(indicadorCuadre);

                            int cantRows = rsFiltra.getRowCount();

                            //Hay que filtrar el Recordset y generar el conector  
                            for (int i = (cantRows - 1); i >= 0; i--) {
                                if (((String) rsFiltra.getValueAt(i,
                                            "IND_OFER_MONO_GRUP")).equals(
                                            new String("0"))) {
                                    //este registro va                          
                                } else {
                                    //se quita esta fila
                                    rsFiltra.removeRow(i);
                                }
                            }

                            traza("cambiaNumeroGrupos1b1");
                        }
                    }
                } else {
                    //el campo numero de grupos no tiene valor
                    traza("el campo numero de grupos no tiene valor");
                }
            //fin codigo copiado de definir

        } else {
           //inhabilitar indicador de cuadre, hacerlo desde pantalla porque es un combo 
           //si el valor del hidHabilitaIndicadorCuadre ="N"
           asignarAtributo("VAR", "hidHabilitaIndicadorCuadre", "valor", "N");
        }
        //esta linea es un prueba
        asignar("COMBO", "cbIndicadorCuadre", UtilidadesBelcorp.generarConector("DTOSalida.indicadorcuadre_ROWSET", indicadorCuadre, indicadorCuadre.getColumnIdentifiers()), "DTOSalida.indicadorcuadre_ROWSET");
        //la linea de arriba es un prueba
        //Promocion

        
        if ((dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 5) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 6) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 7) ){
            if (dtoOferta.getPromocion() != null) {
                Vector vectorPromocion = (Vector) dtoOferta.getPromocion();
                
                if( vectorPromocion.size()>0 ){						  
                    xml = new XMLDocument();         
                    //doc = xml.makeDocument("<table/>");
                    doc = xml.makeDocument("<DIV/>");
                    Element listado0 = armarLista(vectorPromocion);    						 
                    DruidaConector con0 = new DruidaConector();						 
                    con0.setXML(listado0);						 
                    asignar("REJILLA","rejlistado3",con0);						 
                    asignarAtributo("VAR", "hNombreListas", "valor", nombreLista);						 
                    DTOPromocion elemPromocionSesion = (DTOPromocion) vectorPromocion.get(vectorPromocion.size()-1);
                    conectorParametroSesion("numeroCondicion",(elemPromocionSesion.getNumeroCondicion()==null?"":elemPromocionSesion.getNumeroCondicion().toString() ));

                }
            }
        }        
         
        //traza("antes de grupo");
        //Grupo
        if ( (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue()== 3) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue()== 4) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue()== 6) ||
            (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue()== 7) ){

            //traza("dtoOferta.getGrupo() " + dtoOferta.getGrupo()+ "dtoOferta.getDetalleOferta()  " + dtoOferta.getDetalleOferta());
            if (dtoOferta.getGrupo() != null) {
            
                xml = new XMLDocument();         
                doc = xml.makeDocument("<table/>");                 
                Element listadoG = armarListaGrupos( dtoOferta.getGrupo(), dtoOferta.getDetalleOferta(), dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue());             
                DruidaConector conG = new DruidaConector();             
                conG.setXML(listadoG);
                asignar("REJILLA","rejlistado4",conG);
                asignarAtributo("VAR", "hNombreListas", "valor", nombreLista);
            }
        }   
      
        //Venta exclusiva
        //aca asigna provisoriamente el yLista
        if (yLista==null) {
            yLista = new Integer(TAMANOPAGINASINDINAMICA);            
        } 
        
        asignarAtributo("CAPA", "capaVentaExclusiva","y",(String.valueOf(yLista)));

        yLista = new Integer(yLista.intValue() + 320);
        //yLista = new Integer(yLista.intValue() + 250);
        asignarAtributo("LISTAEDITABLE", "listado5","y",(String.valueOf(yLista)));

        yLista = new Integer(yLista.intValue() + 273);        
        asignarAtributo("BOTON", "Eliminar5", "y", (String.valueOf(yLista)));


      
        if ((dtoOferta.getVentaExclusiva() != null) && (dtoOferta.getVentaExclusiva().size() > 0)) {             
            cambiaVentaExclusiva(dtoOferta.getVentaExclusiva());
        }

        //Datos Generales lista Producto Principal
      
        if (dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 1 ||
            dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 2 ||
            dtoCargarCriterioDefOferta.getTipoEstrategia().getOid().longValue() == 5){
            cargaProductosInicial(dtoOferta.getDetalleOferta(),dtoCargarCriterioDefOferta.getTiposOferta(),dtoCargarCriterioDefOferta.getCiclosVida());
        }

        //Datos Generales
        asignarAtributo("CTEXTO", "txtNumeroGrupos", "valor",
           ((dtoOferta.getNumeroGrupos() == null) ? ""
                                                  : dtoOferta.getNumeroGrupos()
                                                             .toString()));



        asignarAtributo("CTEXTO", "txtNumeroPaquetes", "valor",
           ((dtoOferta.getNumeroPaquetes() == null) ? ""
                                                    : dtoOferta.getNumeroPaquetes()
                                                               .toString()));
        asignarAtributo("VAR", "hIndCuadre", "valor",
           ((dtoOferta.getOidIndCuadre() == null) ? ""
                                                  : dtoOferta.getOidIndCuadre()
                                                             .toString()));
                                                             

        asignarAtributo("CTEXTO", "txtNumeroGruposCondicionantes", "valor",
           ((dtoOferta.getNumeroGruposCondicionantes() == null) ? ""
                                                              : dtoOferta.getNumeroGruposCondicionantes()
                                                                         .toString()));

        //valor condicionantes /condicionados si me viene "S" "N" no hay problema... si viene uno validar antes de asignar
        asignarAtributo("VAR", "hidRDCondicionantes", "valor",
                        (dtoOferta.getCondicionCondicionantes()==null?"":(dtoOferta.getCondicionCondicionantes().equals("O")) ? "N" : "S"));
        asignarAtributo("VAR", "hidRDCondicionados", "valor",
                        (dtoOferta.getCondicionCondicionados()==null?"":(dtoOferta.getCondicionCondicionados().equals("O")) ? "N" : "S"));
                      

        asignarAtributo("CTEXTO", "txtNumeroGruposCondicionados", "valor",
                          (dtoOferta.getNumeroGruposCondicionados() == null ? ""
                                                                 : dtoOferta.getNumeroGruposCondicionados()
                                                                            .toString()));

        //asigno a un hidden para despues focalizar en el combo
        asignarAtributo("VAR", "hFormaPago", "valor",
                          ((dtoOferta.getOidFormaPago() == null) ? ""
                                                : dtoOferta.getOidFormaPago()
                                                           .toString()));

        if(dtoOferta.getDespachoCompleto()==null){
            asignarAtributo("VAR", "hidCKDespachoCompleto", "valor","");

        }else{
            asignarAtributo("VAR", "hidCKDespachoCompleto", "valor", (( (dtoOferta.getDespachoCompleto().booleanValue())) ? "S" : "N"));
        }

        if(dtoOferta.getDespachoAutomatico()==null){
            asignarAtributo("VAR", "hidCKDespachoAutomatico", "valor","");    
        }else {
            asignarAtributo("VAR", "hidCKDespachoAutomatico", "valor", (((dtoOferta.getDespachoAutomatico().booleanValue())) ? "S" : "N"));
        }

          if(dtoOferta.getRecuperacionObligatoria() == null){
              asignarAtributo("VAR", "hidCKRecuperacionObligatoria", "valor", "");
          }else{
            asignarAtributo("VAR", "hidCKRecuperacionObligatoria", "valor", (((dtoOferta.getRecuperacionObligatoria().booleanValue())) ? "S" : "N"));
          }    

        asignarAtributo("VAR","maxGrupo","valor",((dtoCargarCriterioDefOferta.getEstrategia().getMaxGrupos()==null)?"":dtoCargarCriterioDefOferta.getEstrategia().getMaxGrupos().toString()));
        asignarAtributo("VAR","maxGruposCondicionantes","valor",((dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionantes()==null)?"":dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionantes().toString()));
        asignarAtributo("VAR","maxGruposCondicionados","valor",((dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionados()==null)?"":dtoCargarCriterioDefOferta.getEstrategia().getMaxGruposCondicionados().toString()));


    }//fin metodo cargarPantalla()

    public String verificarTipoCondicion(DTOLineaPromocion dto){
        String aux = null;

        if (dto.getTipoRango() == (ConstantesPRE.LINEAS_NEGOCIO)) aux = "Lineas de negocio";
        else if (dto.getTipoRango() == (ConstantesPRE.RANGO_PAGINAS)) aux = "Rangos de paginas";
        else if (dto.getTipoRango() == (ConstantesPRE.PRODUCTOS)) aux = "Producto";   
	
        return aux;
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

    private DruidaConector generarConector(String rowsetID, RecordSet datos,Vector columns) 	throws DOMException,Exception{
        StringBuffer salida = new StringBuffer();
        int sizeColums = datos.getColumnCount();
        int sizeRows = datos.getRowCount();
        if ( columns == null ){
            columns = new Vector();
        }
        Vector columsDesc = datos.getColumnIdentifiers();		
        DruidaConector conectorValoresPosibles = new DruidaConector();				
        XMLDocument xmlDoc  = new XMLDocument();
        Document docDestino = xmlDoc.makeDocument("<ROWSET2/>");			
        Element e_rows = docDestino.createElement("ROWSET");
        e_rows.setAttribute("ID",rowsetID);
        docDestino.getDocumentElement().appendChild(e_rows);
		
        for (int i=0; i < sizeRows; i++){
            Element e_row = docDestino.createElement("ROW");
            e_rows.appendChild(e_row);

            for (int j=0; j < sizeColums; j++){
                if ( columns.contains(columsDesc.elementAt(j)) ){
                    Element e_campo2   = docDestino.createElement("CAMPO");
                    e_campo2.setAttribute("NOMBRE",columsDesc.elementAt(j).toString());
                    e_campo2.setAttribute("TIPO","OBJECTO");
                    e_campo2.setAttribute("LONGITUD","50");
                    Text txt = docDestino.createTextNode((datos.getValueAt(i,j)==null?"":datos.getValueAt(i,j).toString()));
                    e_campo2.appendChild(txt);
                    e_row.appendChild(e_campo2);
                }
            }
        }	
        conectorValoresPosibles.setXML(docDestino.getDocumentElement());
        return conectorValoresPosibles;
    }

    private Element armarLista(Vector vectorDtoPromo)throws Exception{
        traza("metodo armarLista()");
    
        Enumeration listas = vectorDtoPromo.elements();
        //traza("listas: "+listas);

        /*    *********Inicio Marta   es la capa Promocion ***************        */
        //Element tablaEngloba = doc.getDocumentElement();
        Element divPromo = doc.getDocumentElement();
        //Element trEngloba1 = getTR(1);
        if (yLista == null)
          yLista = new Integer(TAMANOPAGINASINDINAMICA);
          
        Element capaPrincipal = doc.createElement("CAPA");
        capaPrincipal.setAttribute("nombre","capaPromocion"+String.valueOf(indice));
        capaPrincipal.setAttribute("alto","100%");
        capaPrincipal.setAttribute("ancho","100%");
        capaPrincipal.setAttribute("colorf","");
        capaPrincipal.setAttribute("borde","0");
        capaPrincipal.setAttribute("imagenf","");
        capaPrincipal.setAttribute("repeat","");
        capaPrincipal.setAttribute("padding","");
        capaPrincipal.setAttribute("visibilidad","visible");
        capaPrincipal.setAttribute("contravsb","");
        capaPrincipal.setAttribute("x","0");
        capaPrincipal.setAttribute("y",yLista.toString());
        capaPrincipal.setAttribute("zindex","");
        Element table = null;
        Element fieldset1 = null;
        Element tablaDentro = null;
        Element tablaAfuera = null;
        Element trTablaAfuera = null;
        Element tr = null;
        Element trEngloba2 = null;

        tablaAfuera = doc.createElement("table");
        tablaAfuera.setAttribute("width","100%");
        tablaAfuera.setAttribute("border","0");
        tablaAfuera.setAttribute("cellspacing","0");
        tablaAfuera.setAttribute("cellpadding","0");

        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12,12));
        tr.getChildNodes().item(1).appendChild(getIMG(1,1));
        ((Element)tr.getChildNodes().item(1)).setAttribute("width","750");
        tr.getChildNodes().item(2).appendChild(getIMG(12,12));
        tablaAfuera.appendChild(tr);

        trTablaAfuera = getTR(3);
        trTablaAfuera.getChildNodes().item(0).appendChild(getIMG(12,12));
        fieldset1 = getFIELDSET();
        Element legenda1 = getLegend();
        fieldset1.appendChild(legenda1);
        /*trEngloba1.getChildNodes().item(0).appendChild(capaPrincipal);
        tablaEngloba.appendChild(trEngloba1);
        */
        divPromo.appendChild(capaPrincipal);

        while( listas.hasMoreElements() ){
            DTOPromocion elemPromocion = (DTOPromocion)listas.nextElement();
            table = doc.createElement("table");
            table.setAttribute("width","100%");
            table.setAttribute("border","0");
            table.setAttribute("align","center");
            table.setAttribute("cellspacing","0");
            table.setAttribute("cellpadding","0");

            tr = getTR(1);
            tr.getChildNodes().item(0).appendChild(getIMG(12,12));
            ((Element)tr.getChildNodes().item(0)).setAttribute("colspan","4");

            table.appendChild(tr);

            Element trTable = getTR(3);
            trTable.getChildNodes().item(0).appendChild(getIMG(8,8));
            ((Element)trTable.getChildNodes().item(1)).setAttribute("width","100%");

            tablaDentro = doc.createElement("table");
            tablaDentro.setAttribute("width","100%");
            tablaDentro.setAttribute("border","0");
            tablaDentro.setAttribute("cellspacing","0");
            tablaDentro.setAttribute("cellpadding","0");

            Element trTablaDentro = getTR(1);

            Element fieldset2 = getFIELDSET();
 
            Element tableDentroD = doc.createElement("table");
            tableDentroD.setAttribute("width","100%");
            tableDentroD.setAttribute("border","0");
            tableDentroD.setAttribute("align","center");
            tableDentroD.setAttribute("cellspacing","0");
            tableDentroD.setAttribute("cellpadding","0");

            tr = getTR(1);
            tr.getChildNodes().item(0).appendChild(getIMG(8,8));
            ((Element)tr.getChildNodes().item(0)).setAttribute("colspan","3");
            tableDentroD.appendChild(tr);
        
            tr = getTR(8);
            tr.getChildNodes().item(0).appendChild(getIMG(8,8));
            tr.getChildNodes().item(1).appendChild(getLABELC("lblNumeroCondicion12"+String.valueOf(indice).toString(),"110","17","1","","datosTitle","004"));
            tr.getChildNodes().item(2).appendChild(getIMG(25,8));
            tr.getChildNodes().item(3).appendChild(getLABELC("lblIndicadorCuadre12"+String.valueOf(indice).toString(),"110","17","1","","datosTitle","005"));
            tr.getChildNodes().item(4).appendChild(getIMG(25,8));
            tr.getChildNodes().item(5).appendChild(getLABELC("lblFactorCuadre12"+String.valueOf(indice).toString(),"130","17","1","","datosTitle","006"));
            tr.getChildNodes().item(6).appendChild(getIMG(236,8));
            ((Element)tr.getChildNodes().item(6)).setAttribute("width","88");
            tr.getChildNodes().item(7).appendChild(getIMG(8,8));
            ((Element)tr.getChildNodes().item(7)).setAttribute("width","100%");
            tableDentroD.appendChild(tr);


            tr = getTR(8);
            tr.getChildNodes().item(0).appendChild(getIMG(8,8));
            tr.getChildNodes().item(1).appendChild(getLABEL("lblNumeroCondicionXX2"+String.valueOf(indice).toString(),"60","17","1",""+elemPromocion.getNumeroCondicion().toString(),"datosCampos"));
            tr.getChildNodes().item(2).appendChild(getIMG(25,8));
            tr.getChildNodes().item(3).appendChild(getLABEL("lblIndicadorCuadreXX2"+String.valueOf(indice).toString(),"","17","1",elemPromocion.getDescripcionIndicadorCuadre(),"datosCampos"));
            tr.getChildNodes().item(4).appendChild(getIMG(25,8));
            tr.getChildNodes().item(5).appendChild(getLABEL("lblFactorCuadreXX2"+String.valueOf(indice).toString(),"130","17","1",""+elemPromocion.getFactorCuadre().toString(),"datosCampos"));
            tr.getChildNodes().item(6).appendChild(getIMG(8,8));
            ((Element)tr.getChildNodes().item(6)).setAttribute("width","1");
            tr.getChildNodes().item(7).appendChild(getIMG(8,8));
            ((Element)tr.getChildNodes().item(7)).setAttribute("width","100%");
            tableDentroD.appendChild(tr);

            tr = getTR(1);
            tr.getChildNodes().item(0).appendChild(getIMG(8,310));
            ((Element)tr.getChildNodes().item(0)).setAttribute("colspan","4");
            tableDentroD.appendChild(tr);

            fieldset2.appendChild(tableDentroD);

            trTablaDentro.getChildNodes().item(0).appendChild(fieldset2);
            tablaDentro.appendChild(trTablaDentro);                  

            trTable.getChildNodes().item(1).appendChild(tablaDentro);
            trTable.getChildNodes().item(2).appendChild(getIMG(12,12));
    
            table.appendChild(trTable);
      
            Element trFiledset3 = getTR(3);
            trFiledset3.getChildNodes().item(0).appendChild(getIMG(0,0));
    
            trFiledset3.getChildNodes().item(2).appendChild(getIMG(12,12));

            table.appendChild(trFiledset3);
            tr = getTR(1);
            tr.getChildNodes().item(0).appendChild(getIMG(12,12));
            ((Element)tr.getChildNodes().item(0)).setAttribute("colspan","3");
            table.appendChild(tr);
            fieldset1.appendChild(table);                  
            listaEditableObtenida = (Element)(doc.importNode((Node)armarListaEditable(elemPromocion.getLineaPromocion(),elemPromocion.getNumeroCondicion()),true));
            listaEditableObtenida.setAttribute("ancho","620");
            
            //yLista = new Integer (yLista.intValue() + 405);                 
            yLista = new Integer (yLista.intValue() + 382);
            /* trEngloba2 = getTR(1);
            trEngloba2.getChildNodes().item(0).appendChild(listaEditableObtenida);
            tablaEngloba.appendChild(trEngloba2);
            */
            divPromo.appendChild(listaEditableObtenida);
            } //fin while

        yLista = new Integer (yLista.intValue() + 42); //52
        //genero mi lista

        trTablaAfuera.getChildNodes().item(1).appendChild(fieldset1);
        trTablaAfuera.getChildNodes().item(2).appendChild(getIMG(12,12));
        tablaAfuera.appendChild(trTablaAfuera);

        capaPrincipal.appendChild(tablaAfuera); 

        Element trFiledSet4 = getTR(3);
        trFiledSet4.getChildNodes().item(0).appendChild(getIMG(12,12));
        trFiledSet4.getChildNodes().item(2).appendChild(getIMG(12,12));
        tablaAfuera.appendChild(trFiledSet4);

        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12,12));
        ((Element)tr.getChildNodes().item(0)).setAttribute("width","12");
        tr.getChildNodes().item(1).appendChild(getIMG(0,0));
        ((Element)tr.getChildNodes().item(1)).setAttribute("width","750");
        tr.getChildNodes().item(2).appendChild(getIMG(12,12));
        ((Element)tr.getChildNodes().item(2)).setAttribute("width","12");
        tablaAfuera.appendChild(tr);
        //return tablaEngloba;
        return divPromo;
    }

    private Element armarListaEditable(Vector v, Integer numeroCond)throws Exception{
        traza("metodo armarListaEditable()");
        ListaEditableDinamica listado = new ListaEditableDinamica(this,"listado3"+String.valueOf(indice),5,0,false,"mipgndo3"+String.valueOf(indice));
        
        if (nombreLista.equals("")){
            nombreLista = "listado3"+String.valueOf(indice);
        }else{
            nombreLista = nombreLista+"|"+"listado3"+String.valueOf(indice);
        }
  
        listado.setCodigoColumna(0,"516");
        listado.setCodigoColumna(1,"593");
        listado.setCodigoColumna(2,"555");
        listado.setCodigoColumna(3,"145");
        listado.setCodigoColumna(4,"553");
        
        listado.setAnchoColumna(0,50);
        listado.setAnchoColumna(1,50);
        listado.setAnchoColumna(2,50);
        listado.setAnchoColumna(3,50);
        listado.setAnchoColumna(4,50);

        Enumeration elementosLineaPromo = v.elements();
        
        while(elementosLineaPromo.hasMoreElements()){
            DTOLineaPromocion elemLineaPromo = (DTOLineaPromocion)elementosLineaPromo.nextElement();
            String oid = ""+(elemLineaPromo.getOidLineaPromocion()==null?"":elemLineaPromo.getOidLineaPromocion().toString());
            String descCata = ""+elemLineaPromo.getDescripcionCatalogo();
            String tipoR =  ""+String.valueOf(elemLineaPromo.getTipoRango());
             String valorD = null;
             if (tipoR.equals("R")) {
                valorD = (elemLineaPromo.getValorDesde() == null ? "" : elemLineaPromo.getValorDesde().toString());
             } else if (tipoR.equals("P")) {
                valorD = (elemLineaPromo.getCodigoProducto() == null ? "" : elemLineaPromo.getCodigoProducto().toString());
             } else {
                valorD = (elemLineaPromo.getCodigoLineaProducto() == null ? "" : elemLineaPromo.getCodigoLineaProducto().toString());           
             }
            String valorH = (elemLineaPromo.getValorHasta()==null?"":elemLineaPromo.getValorHasta().toString());
            String indE = (elemLineaPromo.getIndicadorExclusion()==null?"N":elemLineaPromo.getIndicadorExclusion().booleanValue()?"S":"N" );
            Character lineaNegocio = new Character(ConstantesPRE.LINEAS_NEGOCIO);
            Character rangoPagina = new Character(ConstantesPRE.RANGO_PAGINAS);
            Character producto = new Character(ConstantesPRE.PRODUCTOS);            
			
            if( tipoR.equals(lineaNegocio.toString()) ){
                tipoR = new String("Lineas de negocio");
            }else if(tipoR.equals(rangoPagina.toString()) ){
                tipoR = new String("Rango de páginas");
            }else if(tipoR.equals(producto.toString()) ){
                tipoR = new String("Producto");
            }			
            listado.addFila(new String[]{oid, descCata, tipoR, valorD, valorH, indE});

        }

        //deberiamos agregar al tag boton el atributo codigo y asignar al mismo el nombre de la lista
        /* DIA 26/05/04 
        listado.agregarBoton("Modificar3"+String.valueOf(indice),"botonContenido",new Boolean("True"),2,"accionModificarCondicion("+String.valueOf(numeroCond)+");");
        */		
        indice = indice + 1;
    
        listado.setAlto(273);//290
        listado.setX(32);
        listado.setY(yLista.intValue() + 95);//80        
        return listado.getLista();
    }

    private Element getBOTON(String nombre, String id, String tipo, String accion, String estado, String cod){
        Element boton = doc.createElement("BOTON");
        boton.setAttribute("nombre",nombre);
        boton.setAttribute("ID", id);
        boton.setAttribute("tipo", tipo);
        boton.setAttribute("accion", accion);
        boton.setAttribute("estado", estado);
        boton.setAttribute("cod", cod);      
        return boton;
    }

    /* ******metodo getBOTONEliminar()******** */
    private Element getBOTONEliminar(String nombre, String id, String tipo, String accion, String estado, String cod, String codigo){
        Element boton = doc.createElement("BOTON");
        boton.setAttribute("nombre",nombre);
        boton.setAttribute("ID", id);
        boton.setAttribute("tipo", tipo);
        boton.setAttribute("accion", accion);
        boton.setAttribute("estado", estado);
        boton.setAttribute("cod", cod);
        boton.setAttribute("codigo", codigo);
        return boton;
    }

    private Element getIMG(int width, int height){
				Element img = doc.createElement("IMG")   ;
				img.setAttribute("src","b.gif");
				img.setAttribute("width",""+width);
				img.setAttribute("height",""+height);
				return img;
    }
   
    private Element getTR(int tds){
        Element tr = doc.createElement("tr");
        while(tds > 0){
           tr.appendChild(doc.createElement("td"));
           tds--;
        }
        return tr;
    }
    private Element getFIELDSET(){
        Element fieldset = doc.createElement("fieldset");
        //fieldset.setAttribute("class","legend");
        //fieldset.appendChild(getLABELC("lblPromociones","105","13","1","","legend","00117" ));
        return fieldset;
    }

    private Element getLegend(){
        Element legend = doc.createElement("legend");
        legend.setAttribute("class","legend");
        legend.appendChild(getLABELC("lblPromociones","105","13","1","","legend","00117" ));
        return legend;
    }

    private Element getLABELC(String nombre, String ancho, String alto, String filas, String valor, String id, String cod){
        Element labelC = doc.createElement("LABELC");
        labelC.setAttribute("nombre",nombre);
        labelC.setAttribute("ancho",ancho);
        labelC.setAttribute("alto",alto);
        labelC.setAttribute("filas",filas);
        labelC.setAttribute("valor",valor);
        labelC.setAttribute("id",id);
        labelC.setAttribute("cod",cod);
        return labelC;
    }

    private Element getLABEL(String nombre, String ancho, String alto,
        String filas, String valor, String id) {
        Element label = doc.createElement("LABEL");
        label.setAttribute("nombre", nombre);
        label.setAttribute("ancho", ancho);
        label.setAttribute("alto", alto);
        label.setAttribute("filas", filas);
        label.setAttribute("valor", valor);
        label.setAttribute("id", id);
        //label.setAttribute("cod", cod);
        return label;
    }
    
    private Element getCTEXTO(String nombre, String id,  String max, String tipo, String onchange, String req, String size, String valor, String validacion){
        Element cTexto = doc.createElement("CTEXTO");
        cTexto.setAttribute("nombre",nombre);
        cTexto.setAttribute("id",id);
        cTexto.setAttribute("max",max);
        cTexto.setAttribute("tipo",tipo);
        cTexto.setAttribute("onchange",onchange);
        cTexto.setAttribute("req",req);
        cTexto.setAttribute("size",size);
        cTexto.setAttribute("valor",valor);
        cTexto.setAttribute("validacion",validacion);
        return cTexto;
    }
    
    private Element getCOMBO(String nombre, String id, String size, String multiple, String req){
        Element combo = doc.createElement("COMBO");
        combo.setAttribute("nombre",nombre);
        combo.setAttribute("id",id);
        combo.setAttribute("size",size);
        combo.setAttribute("multiple",multiple);
        combo.setAttribute("req",req);
        // combo.setAttribute("valorinicial",valorinicial);
        // combo.setAttribute("textoinicial",textoinicial);
        combo.appendChild(doc.createElement("ROWSET"));
        return combo;
    }
    
    private Element getRBINPUT(String valor, String check, String onfocus, String id, String texto){
        Element rbInput = doc.createElement("RBINPUT");
        rbInput.setAttribute("valor",valor);
        rbInput.setAttribute("check",check);
        rbInput.setAttribute("onfocus",onfocus);
        rbInput.setAttribute("id",id);
        rbInput.appendChild(doc.createTextNode(texto));
        return rbInput;
    }
    
    private Element getCHECKBOX(String nombre, String texto, String check, String validacion, String req, String id, String ontab){
        Element checkbox = doc.createElement("CHECKBOX");
        checkbox.setAttribute("nombre",nombre);
        checkbox.setAttribute("texto",texto);
        checkbox.setAttribute("check",check);
        checkbox.setAttribute("validacion",validacion);
        checkbox.setAttribute("req",req);
        checkbox.setAttribute("id",id);
        checkbox.setAttribute("ontab",ontab);
        return checkbox;
    }
	
    private Element armarListaGrupos(Vector vectorDtoGrupo, Vector vectorDtoDetalles,long tipoEstr)
        throws Exception {
        //traza("entro en el metodo armarListaGrupos yLista " + yLista );
        //primero, por cada posicion del vector armo 1 lista
        Iterator grupos = vectorDtoGrupo.iterator();
        traza("armarListaGrupos 0");
        //tablaEnglobaG = doc.createElement("table");
        div = doc.createElement("DIV");

        //trEngloba = getTR(1);
        if (yLista == null)
          yLista = new Integer(TAMANOPAGINASINDINAMICA);
          
        Element listaEditableObtenida = null;
        traza("armarListaGrupos 1");
        // Enumeration listas = vectorDtoGrupo.elements();
        Element capaPrincipalG = doc.createElement("CAPA");
        traza("armarListaGrupos 2");
        capaPrincipalG.setAttribute("nombre", "capaGrupos");
        capaPrincipalG.setAttribute("alto", "100%");
        capaPrincipalG.setAttribute("ancho", "100%");
        capaPrincipalG.setAttribute("colorf", "");
        capaPrincipalG.setAttribute("borde", "0");
        capaPrincipalG.setAttribute("imagenf", "");
        capaPrincipalG.setAttribute("repeat", "");
        capaPrincipalG.setAttribute("padding", "");
        capaPrincipalG.setAttribute("visibilidad", "visible");
        capaPrincipalG.setAttribute("contravsb", "");
        capaPrincipalG.setAttribute("x", "0");
        //capaPrincipalG.setAttribute("y", "1370");

        capaPrincipalG.setAttribute("y", yLista.toString());
        capaPrincipalG.setAttribute("zindex", "");
        /*trEngloba.getChildNodes().item(0).appendChild(capaPrincipalG);
        tablaEnglobaG.appendChild(trEngloba);
        traza("armarListaGrupos 3");
        */
        div.appendChild(capaPrincipalG);
        //T1 TABLA 1	  
        tablaAfueraG = doc.createElement("table");
        tablaAfueraG.setAttribute("width", "100%");
        tablaAfueraG.setAttribute("border", "0");
        tablaAfueraG.setAttribute("cellspacing", "0");
        tablaAfueraG.setAttribute("cellpadding", "0");
        traza("armarListaGrupos 4");
        //PRIMERA FILA DE LA TABLA AFUERA
        /*-----------------------------------------------------------------------------------------------------*/
        tr = getTR(3);

        //T1 F1 C1 Col 1
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));

        //T1 F1 C2 Col 2
        tr.getChildNodes().item(1).appendChild(getIMG(1, 1));
        ((Element) tr.getChildNodes().item(1)).setAttribute("width", "100%");

        //System.out.println("metodo armar lista1 ");
        //T1 F1 C3 Col 3
        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        traza("armarListaGrupos 5");
        //cierre de tr
        tablaAfueraG.appendChild(tr);

        //T1 F1 fin primera fila
        /*-----------------------------------------------------------------------------------------------------*/
        //SEGUNDA FILA DE LA TABLA AFUERA
        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));

        fieldset1 = getFIELDSET();
        legend1 = getLEGENDGrupos();
        fieldset1.appendChild(legend1);
        DTOGrupo grupo=null;
        while (grupos.hasNext()) {
            grupo = (DTOGrupo) grupos.next();
            table1 = doc.createElement("table");
            table1.setAttribute("width", "100%");
            table1.setAttribute("border", "0");
            table1.setAttribute("align", "center");
            table1.setAttribute("cellspacing", "0");
            table1.setAttribute("cellpadding", "0");

            // Tabla 1 fila 1
            tr1 = getTR(1);
            tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
            ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
            table1.appendChild(tr1);

            //2
            tr1 = getTR(3);
            tr1.getChildNodes().item(0).appendChild(getIMG(8, 8));
            ((Element) tr1.getChildNodes().item(1)).setAttribute("width", "100%");
            table2 = doc.createElement("table");
            table2.setAttribute("width", "100%");
            table2.setAttribute("border", "0");
            table2.setAttribute("cellspacing", "0");
            table2.setAttribute("cellpadding", "0");

            tr2 = getTR(1);
            fieldset2 = getFIELDSET();

            table3 = doc.createElement("table");
            table3.setAttribute("width", "100%");
            table3.setAttribute("border", "0");
            table3.setAttribute("cellspacing", "0");
            table3.setAttribute("align", "center");
            table3.setAttribute("cellpadding", "0");

            //1 
            tr3 = getTR(1);
            tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
            ((Element) tr3.getChildNodes().item(0)).setAttribute("colspan", "4");
            table3.appendChild(tr3);

            //2
            tr3 = getTR(10);
            tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));

            Element labelC2 = getLABELC("lblNumeroCondicion123"+indice, "110", "17", "1", "",
                    "datosTitle", "533");
            tr3.getChildNodes().item(1).appendChild(labelC2);
            tr3.getChildNodes().item(2).appendChild(getIMG(25, 8));
            labelC2 = getLABELC("lblIndicadorCuadre123"+indice, "110", "17", "1", "", "datosTitle", "005");
            tr3.getChildNodes().item(3).appendChild(labelC2);
            tr3.getChildNodes().item(4).appendChild(getIMG(25, 8));
            labelC2 = getLABELC("lblFactorCuadre123"+indice, "120", "17", "1", "", "datosTitle", "006");
            tr3.getChildNodes().item(5).appendChild(labelC2);
            tr3.getChildNodes().item(6).appendChild(getIMG(25, 8));
            labelC2 = getLABELC("lblTipoGrupo1"+indice, "130", "17", "1", "", "datosTitle", "479");
            tr3.getChildNodes().item(7).appendChild(labelC2);
            tr3.getChildNodes().item(8).appendChild(getIMG(81, 8));
            ((Element) tr3.getChildNodes().item(8)).setAttribute("width", "88");
            tr3.getChildNodes().item(9).appendChild(getIMG(8, 8));
            ((Element) tr3.getChildNodes().item(9)).setAttribute("width", "100%");
            table3.appendChild(tr3);

            //3
            tr3 = getTR(10);

            tr3.getChildNodes().item(0).appendChild(getIMG(8, 8));
            labelC2 = getLABEL("lblNumeroCondicionXX23"+indice, "60", "17", "1", ((grupo.getNumeroGrupo() == null) ? "" : grupo.getNumeroGrupo().toString()),
                    "datosCampos");

            tr3.getChildNodes().item(1).appendChild(labelC2);

            tr3.getChildNodes().item(2).appendChild(getIMG(25, 8));

            labelC2 = getLABEL("lblIndicadorCuadreXX23"+indice, "", "17", "1",
                    ((grupo.getOidIndicadorCuadre() == null) ? ""
                                                             : grupo.getDescripcionIndicadorCuadre()
                                                                    ), "datosCampos");
            tr3.getChildNodes().item(3).appendChild(labelC2);

            tr3.getChildNodes().item(4).appendChild(getIMG(25, 8));

            labelC2 = getLABEL("lblFactorCuadreXX23"+indice, "130", "17", "1",
                    ((grupo.getFactorCuadre() == null) ? "" : grupo.getFactorCuadre().toString()),
                    "datosCampos");
            tr3.getChildNodes().item(5).appendChild(labelC2);

            tr3.getChildNodes().item(6).appendChild(getIMG(25, 8));

            String tipoGrupo = new String();

            /*+ Grupos: (Se muestran si se recogieron datos para los grupos, es decir DTOOferta.grupo != Null). Se muestra una cabecera por grupo (DTOGrupo) con los valores
               - Número grupo = DTOGrupo.numeroGrupo
               - Indicador cuadre = DTOGrupo.descripcionIndicadorCuadre
               - Factor cuadre = DTOGrupo.factorCuadre
               - Tipo grupo
                                             "Paquete" -> Si DTOGrupo.indicadorGrupo == False
                                             "Grupo" -> Si DTOGrupo.condicionante == False AND DTOGrupo.condicionado == False
                                             "Grupo condicionante" -> Si DTOGrupo.condicionante == True
                                             "Grupo condicionado" -> Si DTOGrupo.condicionado == True */

           if ((grupo.getIndicadorGrupo().booleanValue() == false)) {
              tipoGrupo = new String("Paquete");
              if (grupo.getCondicionado().booleanValue() == true) {
                tipoGrupo = "Grupo Condicionado";
              } else if (grupo.getCondicionante().booleanValue() == true) {
               tipoGrupo = "Grupo Condicionante";
              }
           } else if ((grupo.getCondicionado().booleanValue() == false) &&
                      (grupo.getCondicionante().booleanValue() == false)) {
              tipoGrupo = "Grupo";
           }             

            labelC2 = getLABEL("lblTipoGrupoXX1"+indice, "130", "17", "1", "" + tipoGrupo, "datosCampos");
            tr3.getChildNodes().item(7).appendChild(labelC2);

            tr3.getChildNodes().item(8).appendChild(getIMG(8, 8));
            ((Element) tr3.getChildNodes().item(8)).setAttribute("width", "1");
            tr3.getChildNodes().item(9).appendChild(getIMG(8, 8));
            ((Element) tr3.getChildNodes().item(9)).setAttribute("width", "100%");

            table3.appendChild(tr3);

            //4
            tr3 = getTR(1);
            tr3.getChildNodes().item(0).appendChild(getIMG(8, 310));
            ((Element) tr3.getChildNodes().item(0)).setAttribute("colspan", "4");
            table3.appendChild(tr3);
            //fin filas tabla 3
            fieldset2.appendChild(table3);
            tr2.getChildNodes().item(0).appendChild(fieldset2);
            table2.appendChild(tr2);
            tr1.getChildNodes().item(1).appendChild(table2);

            //3
            tr1.getChildNodes().item(2).appendChild(getIMG(12, 12));
            table1.appendChild(tr1);
            //FIN FILA 2 

            //F3
            tr1 = getTR(3);
            tr1.getChildNodes().item(0).appendChild(getIMG(0, 0));
            /*fieldset3 = getFIELDSET();
            table5 = doc.createElement("table");
            table5.setAttribute("width", "100%");
            table5.setAttribute("border", "0");
            table5.setAttribute("align", "center");
            table5.setAttribute("cellspacing", "0");
            table5.setAttribute("cellpadding", "0");
            tr5 = getTR(1);
            tr5.getChildNodes().item(0).appendChild(getBOTONEliminar("btnEliminar"+String.valueOf(indice), "botonContenido", "html", "accionEliminarGrupo('btnEliminar" + String.valueOf(indice) + "');", "false", "1254", (grupo.getOidGrupo()==null?"":grupo.getOidGrupo().toString())));
            */
            /*tr5.getChildNodes().item(0).appendChild(getBOTON("btnEliminar", "botonContenido",
                    "html", "accionEliminarGrupo();", "false", "1254"));
                    */
            /*((Element) tr5.getChildNodes().item(0)).setAttribute("class", "botonera");
            ((Element) tr5.getChildNodes().item(0)).setAttribute("width", "100%");
            table5.appendChild(tr5);
            fieldset3.appendChild(table5);
            tr1.getChildNodes().item(1).appendChild(fieldset3);
            */
            tr1.getChildNodes().item(2).appendChild(getIMG(12, 12));
            table1.appendChild(tr1);
            //fin fila 3

            //F4
            tr1 = getTR(1);
            tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
            ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
            table1.appendChild(tr1);
            //fin fila 4
           
            fieldset1.appendChild(table1);
            listaEditableObtenida = (Element) (doc.importNode((Node) armarListaEditableGrupos(
                        vectorDtoDetalles, grupo.getNumeroGrupo()), true));
            listaEditableObtenida.setAttribute("ancho","620");
            
            yLista = new Integer  (yLista.intValue() + 382);
            //yLista = new Integer  (yLista.intValue() + 385);
/*
            tr2 = getTR(1);
            tr2.getChildNodes().item(0).appendChild(listaEditableObtenida);
            tablaEnglobaG.appendChild(tr2);
*/
            div.appendChild(listaEditableObtenida);
            
            // Modificado SiCC20070316 - Rafael Romero - 18/07/2007
            Element botonModificar = this.getBOTON("Consultar4" + String.valueOf(indice -1),
                "botonContenido", 
                "html",
                "javascript:accionConsultarGrupo(" + String.valueOf(grupo.getNumeroGrupo()) + ");",
                "true", 
                "150");
            
            botonModificar.setAttribute("x","35");
            botonModificar.setAttribute("y",String.valueOf(yLista.intValue() - 39));
            div.appendChild(botonModificar);
            // fin de modificado
            
         //fin while       
          }

				//F5
            tr1 = getTR(3);
            tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));

           // Element labelC = getLABELC("lblTipoGrupo2", "110", "17", "1", "", "datosTitle", "479");
            //tr1.getChildNodes().item(1).appendChild(labelC);
            tr1.getChildNodes().item(2).appendChild(getIMG(8, 8));
            ((Element) tr1.getChildNodes().item(2)).setAttribute("width", "100%");
            table1.appendChild(tr1);
            //fin fila 5

				//F6
            tr1 = getTR(3);
            tr1.getChildNodes().item(0).appendChild(getIMG(8, 8));

            //Tomar el tipo de estrategia
             Element combo = getCOMBO("cbTipoGrupo2", "datosCampos", "1", "N", "N");
               //contador = contador+1;
             Element rowset = getROWSET();
          
             if  (tipoEstr == 3){
               traza("estrategia 3");
               Element campos = getCAMPOS(2,"1");
               ((Element) campos.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
               ((Element) campos.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
               ((Element) campos.getChildNodes().item(0)).setAttribute("VALOR", "1");
 
               ((Element) campos.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
               ((Element) campos.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
               ((Element) campos.getChildNodes().item(1)).setAttribute("VALOR", "Grupo");

               rowset.appendChild(campos);
             }   
             else if (tipoEstr == 4){
              traza("estrategia 4");
               Element campos3 = getCAMPOS(2,"3");
               ((Element) campos3.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
               ((Element) campos3.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
               ((Element) campos3.getChildNodes().item(0)).setAttribute("VALOR", "3");
               ((Element) campos3.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
               ((Element) campos3.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
               ((Element) campos3.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionantes");
               rowset.appendChild(campos3);

               Element campos4 = getCAMPOS(2,"4");
               ((Element) campos4.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
               ((Element) campos4.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
               ((Element) campos4.getChildNodes().item(0)).setAttribute("VALOR", "4");
               ((Element) campos4.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
               ((Element) campos4.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
               ((Element) campos4.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionados");
               rowset.appendChild(campos4);
             } 

             else if  (tipoEstr == 6){
              traza("estrategia 6");
               Element campos2 = getCAMPOS(2,"2");
               ((Element) campos2.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
               ((Element) campos2.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
               ((Element) campos2.getChildNodes().item(0)).setAttribute("VALOR", "2");
               
               ((Element) campos2.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
               ((Element) campos2.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
               ((Element) campos2.getChildNodes().item(1)).setAttribute("VALOR", "Paquete");
               rowset.appendChild(campos2);
              }
              else if (tipoEstr == 7){
                traza("estrategia 7");
                Element campos4 = getCAMPOS(2,"4");
                ((Element) campos4.getChildNodes().item(0)).setAttribute("NOMBRE", "CODIGO");
                ((Element) campos4.getChildNodes().item(0)).setAttribute("TIPO", "STRING");
                ((Element) campos4.getChildNodes().item(0)).setAttribute("VALOR", "4");
                ((Element) campos4.getChildNodes().item(1)).setAttribute("NOMBRE", "DESCRIPCION");
                ((Element) campos4.getChildNodes().item(1)).setAttribute("TIPO", "STRING");
                ((Element) campos4.getChildNodes().item(1)).setAttribute("VALOR", "Grupos condicionados");
                rowset.appendChild(campos4);
              }

            tr1 = getTR(1);
            tr1.getChildNodes().item(0).appendChild(getIMG(12, 12));
            ((Element) tr1.getChildNodes().item(0)).setAttribute("colspan", "3");
            table1.appendChild(tr1);

             //yLista = new Integer  (yLista.intValue()+100);
             yLista = new Integer  (yLista.intValue() + 80);
             tr.getChildNodes().item(1).appendChild(fieldset1);
             tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
             tablaAfueraG.appendChild(tr);

        /*------------------------------------------------------------------------------------------------------*/

        //CUARTA FILA DE LA TABLA AFUERA
        tr = getTR(3);
        tr.getChildNodes().item(0).appendChild(getIMG(12, 12));
        ((Element) tr.getChildNodes().item(0)).setAttribute("width", "12");
        ((Element) tr.getChildNodes().item(0)).setAttribute("align", "center");

        tr.getChildNodes().item(1).appendChild(getIMG(0, 0));
        ((Element) tr.getChildNodes().item(1)).setAttribute("width", "750");

        tr.getChildNodes().item(2).appendChild(getIMG(12, 12));
        ((Element) tr.getChildNodes().item(2)).setAttribute("width", "12");

        tablaAfueraG.appendChild(tr);

        //FIN CUARTA FILA DE LA TABLA AFUERA
        capaPrincipalG.appendChild(tablaAfueraG);

        /*-------------------------------------------------------------------------------------------------------*/
       // return tablaEnglobaG;
       return div;
    }


    /*------------------------------------------------------------------------------------------------*/
    /**
     * 
     * @throws java.lang.Exception
     * @return 
     * @param nroGrupo
     * @param v
     * @author Marcelo J. Maidana (modificado) - Se agregaron las columnas 'Tipo de oferta'
     * y 'Ciclo de vida' a la lista de Grupos.
     * @version 11/07/2005
     */
    private Element armarListaEditableGrupos(Vector v, Integer nroGrupo)throws Exception{
        int count =0; 

        //Agregado mmaidana-----------------------------------------------------
        DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta = 
            (DTOSCargarCriteriosDefinirOferta) conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        //----------------------------------------------------------------------

        traza("metodo armarListaEditableGrupos()");

        //Modificado mmaidana - 3er param cambio de 7 a 9 ----------------------
        ListaEditableDinamica listado = new ListaEditableDinamica(this,"listado4"+String.valueOf(indice),9,0,false,"mipgndo4"+String.valueOf(indice));
        
        if (nombreLista.equals("")){
            nombreLista = "listado4"+String.valueOf(indice);
        } else {
            traza("entro al else de armar lista editable"); 
            nombreLista = nombreLista+"|"+"listado4"+String.valueOf(indice);
        }
         
        listado.setCodigoColumna(0,"8");
        listado.setCodigoColumna(1,"9");
         
        //Agregado mmaidana-----------------------------------------------------
        listado.setCodigoColumna(2,"608");
        listado.setCodigoColumna(3,"581");
        //----------------------------------------------------------------------
         
        listado.setCodigoColumna(4,"529");
        listado.setCodigoColumna(5,"530");
        listado.setCodigoColumna(6,"481");
        listado.setCodigoColumna(7,"482");
        listado.setCodigoColumna(8,"483");
         
        listado.setAnchoColumna(0,50);
        listado.setAnchoColumna(1,50);
        listado.setAnchoColumna(2,50);
        listado.setAnchoColumna(3,50);
        listado.setAnchoColumna(4,50);
        listado.setAnchoColumna(5,50);
        listado.setAnchoColumna(6,50);

        //Agregado mmaidana-----------------------------------------------------
        listado.setAnchoColumna(7,50);
        listado.setAnchoColumna(8,50);
        //----------------------------------------------------------------------
         
        Iterator detalles = v.iterator();
         
        while(detalles.hasNext()){
            DTODetalleOferta ofertaDetalle = (DTODetalleOferta) detalles.next();   

            traza("Oid Grupo Oferta = "+ ofertaDetalle.getNumeroGrupo());
            traza("Nro Grupo = "+ nroGrupo);
              
            if ((ofertaDetalle.getNumeroGrupo()!=null) 
                    && ofertaDetalle.getNumeroGrupo().equals(nroGrupo)){ 
                ofertaDetalle.setNumeroGrupo(nroGrupo); 
                String oid = "" + (ofertaDetalle.getOidDetalleOferta() == null ? "" : ofertaDetalle.getOidDetalleOferta().toString());
                String codSap = (ofertaDetalle.getCodigoSAP()!=null)?ofertaDetalle.getCodigoSAP().toString():"";
                String desc = (ofertaDetalle.getDescripcion()!=null)?ofertaDetalle.getDescripcion().toString():"";
                String factRep = "" + (ofertaDetalle.getFactorRepeticion() == null ? "" : ofertaDetalle.getFactorRepeticion().toString());
                String precCatalogo = "" + (ofertaDetalle.getPrecioCatalogo() == null ? "" : ofertaDetalle.getPrecioCatalogo().toString());
                String atr1 = (ofertaDetalle.getAtributo1()!=null)?ofertaDetalle.getAtributo1().toString():"";
                String atr2 = (ofertaDetalle.getAtributo2()!=null)?ofertaDetalle.getAtributo2().toString():"";
                String atr3 = (ofertaDetalle.getAtributo3()!=null)?ofertaDetalle.getAtributo3().toString():"";
                
                String tipoOferta = this.obtenerDescTipoOferta(dtoCargarCriterioDefOferta, ofertaDetalle.getOidTipoOferta());
                String cicloVida = this.obtenerDescCicloVida(dtoCargarCriterioDefOferta, ofertaDetalle.getOidCicloVida());
                
                listado.addFila(new String[]{oid, codSap, desc, tipoOferta, cicloVida, factRep, precCatalogo, atr1, atr2, atr3});
                //listado.addFila(new String[]{oid, codSap, desc, factRep, precCatalogo, atr1, atr2, atr3});                 
            }
        }
        
        indice = indice + 1;    
        /*  AGREGAR BOTON    */
        //listado.agregarBoton("Modificar4","botonContenido",new Boolean("True"),2,"accionModificarCondicion();");
        traza("nroGrupo" + nroGrupo);
        /* DIA 26/05/04
        listado.agregarBoton("Modificar4"+String.valueOf(indice),"botonContenido",new Boolean("True"),2,"accionModificarGrupo("+String.valueOf(nroGrupo)+");");
            */
        listado.setAlto(272);//290
        listado.setX(32);
        listado.setY(yLista.intValue() + 95);//90
        
        //traza("listado.getLista()  " + listado.getLista());
        return listado.getLista();
    }
    
    //fin armar listaEditableGrupos

    /**
     * 
     * @throws java.lang.Exception
     * @return 
     * @param oid el valor a buscar
     * @param dtoCargarCriterioDefOferta el dto que contiene el RecordSet de Tipos
     * de oferta donde se realizara la busqueda.
     * @author Marcelo J. Maidana
     * @version 11/07/2005
     */
    private String obtenerDescTipoOferta(
                DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta, Long oid) throws Exception {

        traza("entro a obtenerDescTipoOferta");

        traza("tipo de oferta buscado: " + oid);

        BigDecimal bdOid = null;
        Long lOid = null;
        RecordSet rs = dtoCargarCriterioDefOferta.getTiposOferta();

        traza("RecordSet tipos de oferta: " + rs);
        
        if (rs != null && !rs.esVacio() && oid != null){
        
            for (int i = 0; i < rs.getRowCount(); i++){
                bdOid = (BigDecimal)rs.getValueAt(i, 0);
                
                traza("obtuvo bigdecimal: " + bdOid);
                
                if (bdOid != null){
                    lOid = new Long(bdOid.toString());
                    
                    traza("obtuvo long: " + lOid);
                    traza("oid buscado: " + oid);
                    
                    if (lOid.equals(oid)){
                        if (rs.getValueAt(i, 1) != null){
                            return rs.getValueAt(i, 1).toString();
                        }
                    }
                }
            }
        }
        
        return "";
    }

    /**
     * 
     * @throws java.lang.Exception
     * @return 
     * @param oid el valor a buscar
     * @param dtoCargarCriterioDefOferta el dto que contiene el RecordSet de Ciclos
     * de vida donde se realizara la busqueda.
     * @author Marcelo J. Maidana
     * @version 11/07/2005
     */
    private String obtenerDescCicloVida(
            DTOSCargarCriteriosDefinirOferta dtoCargarCriterioDefOferta, Long oid) throws Exception {
    
        traza("entro a obtenerDescCiclosVida");
        traza("ciclo de vida buscado: " + oid);

        BigDecimal bdOid = null;
        Long lOid = null;
        RecordSet rs = dtoCargarCriterioDefOferta.getCiclosVida();
    
        traza("RecordSet ciclos de vida: " + rs);

        if (rs != null && !rs.esVacio() && oid != null){
        
            for (int i = 0; i < rs.getRowCount(); i++){
                bdOid = (BigDecimal)rs.getValueAt(i, 0);
                
                if (bdOid != null){
                    lOid = new Long(bdOid.toString());
                    
                    if (lOid.equals(oid)){
                        if (rs.getValueAt(i, 1) != null){
                            return rs.getValueAt(i, 1).toString();
                        }
                    }
                }
            }
        }
        
        return "";
    }


/* ---------------------------------------------------------------------------------------------------*/
    private Element getROWSET() {
        Element rowset = doc.createElement("ROWSET");
        return rowset;
    }

    private Element getCAMPOS(int cps, String id) {
        Element tr = doc.createElement("ROW");
        tr.setAttribute("ID", id);

        while (cps > 0) {
            tr.appendChild(doc.createElement("CAMPO"));
            cps--;
        }

        return tr;
    }

    private Element getLEGENDGrupos(){
        Element legend = doc.createElement("legend");
        legend.setAttribute("class","legend");
        legend.appendChild(getLABELC("lblGrupos","50","13","1","","legend","545"));
        return legend;
    }

	 private void cambiaVentaExclusiva(Vector vec) throws Exception { //Asigna a la pantalla las ventas exclusivas
        traza("metodo cambiaVentaExclusiva()");
        RecordSet recordSet = new RecordSet();
        llenarRecordSetVentaExclusiva(recordSet);

        Enumeration enum = vec.elements();
        // recordSet.setRowCount(vec.size() - 1);
        int i = 0;

        while (enum.hasMoreElements()) {
            recordSet.addRow(new Vector());

            DTOVentaExclusiva dto = (DTOVentaExclusiva) enum.nextElement();

       
            recordSet.setValueAt(dto.getOidVentaExclusiva(), i, 0);

            recordSet.setValueAt(dto.getDescripcionTipoCliente(), i, 1);         
            recordSet.setValueAt(dto.getDescripcionSubtipoCliente(), i, 2);
            recordSet.setValueAt(dto.getDescripcionTipoClasificacion(), i, 3);
            recordSet.setValueAt(dto.getDescripcionClasificacion(), i, 4);
            recordSet.setValueAt(dto.getDescripcionEstatus(), i, 5);
            recordSet.setValueAt(dto.getEstatus2(), i, 6);
			recordSet.setValueAt(dto.getDescripcionRegion(), i, 7); 
			recordSet.setValueAt(dto.getDescripcionZona(), i, 8); 

            i++;
        }

        asignar("LISTADOA", "listado5",
        UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
        recordSet.getColumnIdentifiers()), "dtoSalida");
      
   }

   private void cargaProductosInicial(Vector vec, RecordSet rs1, RecordSet rs2) throws Exception {
      traza("metodo cargaProductosInicial");
      RecordSet recordSet1 = new RecordSet();
      RecordSet recordSet2 = new RecordSet();

      llenarRecordSetProductos(recordSet1);
      llenarRecordSetProductos(recordSet2);
      
      Enumeration enum = vec.elements();
      int i = 0;
      int x = 0;

       while (enum.hasMoreElements()) {
           DTODetalleOferta dto = (DTODetalleOferta) enum.nextElement();
           if (dto.getProductoPrincipal()!=null&&dto.getProductoPrincipal().booleanValue()){
              recordSet1.addRow(new Vector());
              // Modificado por SICC20070316 - Rafael Romero - 20/07/2007
              //recordSet1.setValueAt(dto.getOidSAP(), i, 0);
              recordSet1.setValueAt(dto.getOidDetalleOferta().toString(), i, 0);
              // fin modificado SICC20070316

               if (dto.getCodigoSAP() != null) {
                   recordSet1.setValueAt(dto.getCodigoSAP(), i, 1);
               }else{recordSet1.setValueAt("", i, 1);}

               if (dto.getDescripcion() != null) {
                  recordSet1.setValueAt(dto.getDescripcion(), i, 2);
               }else{recordSet1.setValueAt("", i, 2);}

               RecordSet rsTipoOferta = (RecordSet)rs1;                
               if (dto.getOidTipoOferta() != null && !rsTipoOferta.esVacio() ) {            
                  /* tipo oferta: obtengo la descripcion  */            
                  for(int j=0; j<rsTipoOferta.getRowCount(); j++){  
                      Long tipoOfert = rsTipoOferta.getValueAt(j,0)==null ? null : new Long(rsTipoOferta.getValueAt(j,0).toString());
                      if(tipoOfert.equals(dto.getOidTipoOferta()) ){
                          recordSet1.setValueAt(rsTipoOferta.getValueAt(j,1), i, 3);
                          break;
                      }
                  }
               }else{recordSet1.setValueAt("", i, 3);}

              /* ciclo de vida: obtengo la descripcion  */
              RecordSet rsCicloVida = (RecordSet)rs2;
              if (dto.getOidCicloVida() != null && !rsCicloVida.esVacio()) {
                  for(int j=0; j<rsCicloVida.getRowCount(); j++){  
                      Long cicloVi = rsCicloVida.getValueAt(j,0)==null ? null : new Long(rsCicloVida.getValueAt(j,0).toString());
                      if(cicloVi.equals(dto.getOidCicloVida()) ){
                          recordSet1.setValueAt(rsCicloVida.getValueAt(j,1), i, 4);
                          break;
                      }
                  }
              }else{
                  recordSet1.setValueAt("", i, 4);
              }

               if (dto.getFactorRepeticion() != null) {
                  recordSet1.setValueAt(dto.getFactorRepeticion(), i, 5);            
               }else{recordSet1.setValueAt("", i, 5);}

               if (dto.getPrecioCatalogo() != null) {
                  recordSet1.setValueAt(dto.getPrecioCatalogo(), i, 6);
               }else{recordSet1.setValueAt("", i, 6);}         

               if (dto.getAtributo1() != null) {
                  recordSet1.setValueAt(dto.getAtributo1(), i, 7);
               }else{recordSet1.setValueAt("", i, 7);}

               if (dto.getAtributo2() != null) {
                  recordSet1.setValueAt(dto.getAtributo2(), i, 8);
               }else{recordSet1.setValueAt("", i, 8);}

               if (dto.getAtributo3() != null) {
                  recordSet1.setValueAt(dto.getAtributo3(), i, 9);
               }else{recordSet1.setValueAt("", i, 9);}
               i++;
          }else{
             recordSet2.addRow(new Vector());
              // Modificado por SICC20070316 - Rafael Romero - 20/07/2007
              //recordSet2.setValueAt(dto.getOidSAP(), x, 0);
              recordSet2.setValueAt(dto.getOidDetalleOferta().toString(), x, 0);
              // fin modificado SICC20070316

             if (dto.getCodigoSAP() != null) {
                recordSet2.setValueAt(dto.getCodigoSAP(), x, 1);
             }else{recordSet2.setValueAt("", x, 1);}

             if (dto.getDescripcion() != null) {
                recordSet2.setValueAt(dto.getDescripcion(), x, 2);
             }else{recordSet2.setValueAt("", x, 2);}

             RecordSet rsTipoOferta = (RecordSet)rs1;                
             if (dto.getOidTipoOferta() != null && !rsTipoOferta.esVacio() ) {            
                /* tipo oferta: obtengo la descripcion  */            
                for(int j=0; j<rsTipoOferta.getRowCount(); j++){  
                    Long tipoOfert = rsTipoOferta.getValueAt(j,0)==null ? null : new Long(rsTipoOferta.getValueAt(j,0).toString());
                    if(tipoOfert.equals(dto.getOidTipoOferta()) ){
                        recordSet2.setValueAt(rsTipoOferta.getValueAt(j,1), x, 3);
                        break;
                    }
                }
            
             }else{recordSet2.setValueAt("", x, 3);}

              /* ciclo de vida: obtengo la descripcion  */
              RecordSet rsCicloVida = (RecordSet)rs2;
              if (dto.getOidCicloVida() != null && !rsCicloVida.esVacio()) {
                  for(int j=0; j<rsCicloVida.getRowCount(); j++){  
                      Long cicloVi = rsCicloVida.getValueAt(j,0)==null ? null : new Long(rsCicloVida.getValueAt(j,0).toString());
                      if(cicloVi.equals(dto.getOidCicloVida()) ){
                          recordSet2.setValueAt(rsCicloVida.getValueAt(j,1), x, 4);
                          break;
                      }
                  }
              }else{recordSet2.setValueAt("", x, 4);}

              if (dto.getFactorRepeticion() != null) {
                  recordSet2.setValueAt(dto.getFactorRepeticion(), x, 5);            
              }else{recordSet2.setValueAt("", x, 5);}

               if (dto.getPrecioCatalogo() != null) {
                  recordSet2.setValueAt(dto.getPrecioCatalogo(), x, 6);
               }else{recordSet2.setValueAt("", x, 6);}         

               if (dto.getAtributo1() != null) {
                  recordSet2.setValueAt(dto.getAtributo1(), x, 7);
               }else{recordSet2.setValueAt("", x, 7);}

               if (dto.getAtributo2() != null) {
                  recordSet2.setValueAt(dto.getAtributo2(), x, 8);
               }else{recordSet2.setValueAt("", x, 8);}

               if (dto.getAtributo3() != null) {
                  recordSet2.setValueAt(dto.getAtributo3(), x, 9);
               }else{recordSet2.setValueAt("", x, 9);}
               x++;
          }
       }
       asignar("LISTADOA", "listado1",
           UtilidadesBelcorp.generarConector("dtoSalida", recordSet1,
              recordSet1.getColumnIdentifiers()), "dtoSalida");
       asignar("LISTADOA", "listado2",
           UtilidadesBelcorp.generarConector("dtoSalida", recordSet2,
              recordSet2.getColumnIdentifiers()), "dtoSalida");
   }

    private void llenarRecordSetProductos(RecordSet r) {
        r.addColumn("OID");
        r.addColumn("COD_SAP");
        r.addColumn("DES_SAP");
        r.addColumn("COD_TIPO_OFER");
        r.addColumn("COD_CICL_VIDA");
        r.addColumn("VAL_FACT_REPE");
        r.addColumn("IMP_PREC_CATA");      
        r.addColumn("VAL_ATRI_1");
        r.addColumn("VAL_ATRI_2");
        r.addColumn("VAL_ATRI_3");     
   }

    private void llenarRecordSetVentaExclusiva(RecordSet r) {
        r.addColumn("OID");
        r.addColumn("DES_TIPO_CLIE");
        r.addColumn("DES_SUB_TIPO_CLIE");
        r.addColumn("DES_TIPO_CLAS");
        r.addColumn("DES_CLAS");
        r.addColumn("ESTATUS1");
        r.addColumn("ESTATUS2");    
		r.addColumn("REGION"); 
        r.addColumn("ZONA"); 
		
    }
    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}
