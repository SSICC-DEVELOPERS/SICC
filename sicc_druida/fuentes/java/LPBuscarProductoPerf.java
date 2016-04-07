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
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.HashMap;
import java.util.Vector;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class LPBuscarProductoPerf extends LPSICCBase{
    private static final String nombreLogica = "LPBuscarProductoPerf";
    private String oid = "";
    private String oidCabeceraMF = "";
    private String oidEstrategia = null;
    private Long oidIdioma = null;
    private Long oidPais = null;
    private String oidAcceso = null;
	private String oidSubacceso = null;
    private String oidCatalogo = null;
    private String accion = "";
    private String casoDeUso = "";
    private String codSap = "";
    private String descripcion = "";
    private String catalogo = "";
    private String paginaDesde = "";
    private String paginaHasta = "";
    private String marca = "";
    private String lineaProducto = "";
    private String unidadNegocio = "";
    private String negocio = "";
    private String generico = "";
    private String superGenerico = "";
    private String valoresAdicionales = "";
    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;
    private String descripcionCatalogo = "";

    private String ipCliente = "";
    // Parametros No funcionales
    private String referrer = "";
    private boolean  multiseleccion = false;

    private HashMap param = new HashMap();


    public LPBuscarProductoPerf(){
        super();
    }

    // Va siempre, se invoca a la pagina involucrada	
    public void inicio() throws Exception{
        setTrazaFichero();
        pagina("contenido_producto_buscar_perf");
		getFormatosValidaciones();
        this.getConfiguracionMenu("LPBuscarProductoPerf","");
    }

    // Va siempre - Metodo ejecucion()
    public void ejecucion() throws Exception{
	
        TiempoDeCargaInicio=System.currentTimeMillis();
        try{
            //agregado Por el caso de uso modificar grupos
            String casoDeUso = conectorParametroLimpia("casoDeUso","",true);
            asignarAtributo("VAR","casoDeUso","valor",casoDeUso);

            accion = conectorParametroLimpia("accion","",true);
            rastreo();
            traza("Accion: " + accion);
            oidPais = UtilidadesSession.getPais(this);
            oidIdioma = UtilidadesSession.getIdioma(this);
            ipCliente = UtilidadesBelcorp.getIPCliente(this);

            
            multiseleccion = (conectorParametro("multiseleccion").equals("true")?true:false);
            valoresAdicionales = conectorParametro("mostrarValoresAdicionales");
            
            String volverLPBuscarProducto = (String)conectorParametro("volverLPBuscarProducto");
            if ("LPDefinirCondicionOfertaPerf".equals(volverLPBuscarProducto)){
              oidCatalogo = (String)conectorParametroSesion("oidCatalogoPromo");
              descripcionCatalogo = (String)conectorParametroSesion("descripcionCatalogoPromo");              
            } else {
              oidCatalogo = (String)conectorParametro("oidCatalogo");
              descripcionCatalogo = (String)conectorParametro("descripcionCatalogo");
            }

			traza("******* multiseleccion " + multiseleccion);
			traza("******* valoresAdicionales " + valoresAdicionales);
			traza("******* oidCatalogo " + oidCatalogo);
			traza("******* descripcionCatalogo " + descripcionCatalogo);
            
            asignarAtributo("VAR","multiseleccion","valor",String.valueOf(multiseleccion));
            asignarAtributo("VAR","mostrarValoresAdicionales","valor",valoresAdicionales);
            asignarAtributo("VAR","oidCatalogo","valor",oidCatalogo);
            asignarAtributo("VAR","descripcionCatalogo","valor",descripcionCatalogo);
            
            // SiCC 20070317 - Rafael Romero - 27/06/2007
            // /* comentado */ asignarAtributo("LABELC","lbldtCatalogo","valor",descripcionCatalogo);
            
            if (accion.equals("")) {
                cargarCombos();
            }
            
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322
            
        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPBuscarProductoPerf es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));            
        }catch (Exception ex){
            traza("exception: " + ex);
            this.logStackTrace(ex);
      			this.lanzarPaginaError(ex);
  		  }

        this.getConfiguracionMenu();
    }
	private void logStackTrace(Throwable e) throws Exception{

		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		
		if (e instanceof MareException){
			MareException e2 = (MareException)e;
			traza("Es una mare Exception con codigo de error: " + e2.getCode());
		}

		e.printStackTrace(out);
		traza("stack Trace : " + pila.toString());

	}//logStackTrace()
  
    private void cargarCombos()throws Exception{
    	long inicioCargasCombos = System.currentTimeMillis();
        oid = conectorParametroLimpia("hOid","",true);
        
        if(conectorParametroSesion("oidCabeceraMF")!=null){
            oidCabeceraMF = conectorParametroSesion("oidCabeceraMF").toString();  
        }
        if(conectorParametroSesion("oidEstrategia")!=null){
            oidEstrategia = conectorParametroSesion("oidEstrategia").toString();  
        }
        if(conectorParametro("oidAcceso")!=null){
            this.oidAcceso = conectorParametro("oidAcceso").toString();  
        }

        if(conectorParametro("oidSubacceso")!=null){
            this.oidSubacceso = conectorParametro("oidSubacceso").toString();  
        }
		
        Vector paramEntrada = new Vector();
        MareBusinessID idBuss = new MareBusinessID("PRECargarCriteriosBusquedaProductosMinimo");
													
        // Crea DTOBelcorp con oidPais y oidIdioma 
        DTOOID dtoEntrada = new DTOOID();
        dtoEntrada.setOidPais(oidPais);
        dtoEntrada.setOidIdioma(oidIdioma);
        dtoEntrada.setOid(new Long(oidCabeceraMF));
        paramEntrada.addElement(dtoEntrada);
        paramEntrada.addElement(idBuss);
        //long inicioConectar = System.currentTimeMillis();
        DruidaConector conectorCargarCriteriosBusquedaProducto = conectar("ConectorCargarCriteriosBusquedaProductos", paramEntrada);
        DTOSCargarCriteriosBusquedaProductos dtoS = (DTOSCargarCriteriosBusquedaProductos) conectorCargarCriteriosBusquedaProducto.objeto("dtoSalida");
        //traza("CONECTAR: "+(System.currentTimeMillis()-inicioConectar));


        long inicioGeneraConectores = System.currentTimeMillis();
        DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida.marca_ROWSET", dtoS.getMarcas(), dtoS.getMarcas().getColumnIdentifiers());
        asignar("COMBO", "cbMarca", con, "dtoSalida.marca_ROWSET");

        //con = UtilidadesBelcorp.generarConector("dtoSalida.lineaProducto_ROWSET", dtoS.getLineasProducto(), dtoS.getLineasProducto().getColumnIdentifiers());
        //asignar("COMBO", "cbLineaProducto", con, "dtoSalida.lineaProducto_ROWSET");

         con = UtilidadesBelcorp.generarConector("dtoSalida.uniNegocio_ROWSET", dtoS.getUnidadesNegocio(), dtoS.getUnidadesNegocio().getColumnIdentifiers());
        asignar("COMBO", "cbUniNegocio", con, "dtoSalida.uniNegocio_ROWSET");

        con = UtilidadesBelcorp.generarConector("dtoSalida.negocio_ROWSET", dtoS.getNegocios(), dtoS.getNegocios().getColumnIdentifiers());
        asignar("COMBO", "cbNegocio", con, "dtoSalida.negocio_ROWSET");

        // Agregado por SiCC 20070317 - Rafael Romero - 27/06/2007
        cargarCatalogo();
        // Fin agregado por SICC 20070317

        //con = UtilidadesBelcorp.generarConector("dtoSalida.generico_ROWSET", dtoS.getGenericos(), dtoS.getGenericos().getColumnIdentifiers());
        //asignar("COMBO", "cbGenerico", con, "dtoSalida.generico_ROWSET");
		//long inicioconectar = System.currentTimeMillis();
        //con = UtilidadesBelcorp.generarConector("dtoSalida.supergenerico_ROWSET", dtoS.getSupergenericos(), dtoS.getSupergenericos().getColumnIdentifiers());
        //asignar("COMBO", "cbSupergenerico", con, "dtoSalida.supergenerico_ROWSET");
        //traza("CONECTARUNICO: "+(System.currentTimeMillis()-inicioconectar));
		//traza("CONECTAR: "+(System.currentTimeMillis()-inicioGeneraConectores));
		
        asignarAtributo("VAR","oidCabeceraMF","valor",(oidCabeceraMF==null)?"":oidCabeceraMF);
        asignarAtributo("VAR","oidEstrategia","valor",(oidEstrategia==null)?"":oidEstrategia);
        asignarAtributo("VAR","oidAcceso","valor",(oidAcceso==null)?"":oidAcceso);
        asignarAtributo("VAR","oidSubacceso","valor",oidSubacceso==null?"":oidSubacceso);
        asignarAtributo("VAR","oidIdioma","valor",oidIdioma.toString());
        asignarAtributo("VAR","oidPais","valor",oidPais.toString());
        //traza("CARGAR COMBOS: "+(System.currentTimeMillis()-inicioCargasCombos));
    } // Fin metodo cargarCombos()
    
    // Agrgado por incidencia SiCC 20070317 - Rafael Romero - 27/06/2007
    private void cargarCatalogo() throws Exception {
         ComposerViewElementList cv = crearParametrosEntrada();
         ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
         conector.ejecucion();
         DruidaConector resultados = conector.getConector();
         
         this.asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
         
    }

     private ComposerViewElementList crearParametrosEntrada() throws Exception {
        ComposerViewElementList lista = new ComposerViewElementList(); 
        DTOBelcorp dtobcp = new DTOBelcorp();
         
        dtobcp.setOidIdioma(oidIdioma);
        dtobcp.setOidPais(oidPais);
      
        ComposerViewElement ci1 = new ComposerViewElement();
        ci1.setIDBusiness("MAVCargarCatalagosBP");           
        ci1.setDTOE(dtobcp);
        lista.addViewElement(ci1);
      
         return lista;    
    }
    // Fin agregado por SiCC 20070317
    
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
