import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOLineaProducto;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOSCriteriosCondicionOferta;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Hashtable;
import java.util.Vector;
import java.util.Enumeration;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              PRE - Ofertas
 * Componente:          LPDefinirCondicionOferta
 * Fecha:               03/03/2004
 * Dcoumentacion:
 *                      documentos: SICC-DMCO-MEN-201-307
 * Observaciones:
 * @version             3.0
 * @author              Cintia Verónica Argain
 */

public class LPDefinirCondicionOferta extends LPSICCBase {
        private Hashtable hshProductos = null;

        private Float fFactorCuadre = null;
        private Integer iNumeroCondicion = null;

        private Long lOidCatalogo = null;
        private Long lOidEstrategia = null;
        private Long lOidIndicadorCuadre = null;
        private String sDesIndicadorCuadre = null;
        private Long lIdioma = null;
        private Long lPais = null;

        private String sDescCatalogo = null;
        
        private String sPagDesde = null;
        private String sPagHasta = null;

        private Vector vLineasProducto = new Vector(); /*Se carga en la LPSeleccionarLineasProductos*/
        private Vector vProductosCondicion = new Vector(); /*Se carga en esta LP*/
        private Vector vLineasCondicion = new Vector();/*Se carga en esta LP*/

        private long TiempoDeCargaInicio;
        private long TiempoDeCargaFin;    
        

    public LPDefinirCondicionOferta(){
        super();
    }

    public void inicio() throws Exception{
        pagina("contenido_condicion_oferta_definir");
    }

    public void ejecucion() throws Exception
    {
        TiempoDeCargaInicio=System.currentTimeMillis();    
        String sAccion = null;
        setTrazaFichero();
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        traza("Inicializando contenido_condicion_oferta_definir");
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        try{
        /*............... Tomar valores iniciales de trabajo..................*/
            sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
            lPais = UtilidadesSession.getPais(this);
            lIdioma = UtilidadesSession.getIdioma(this);
            
            traza("Accion Seleccionada:  " +sAccion);
            /*.................... Se recargan los combos ...................*/
            cargarCombos();
            /*........ Setea los valores iniciales de los controles ..........*/
            cargaDatosDeSesionEnPantalla(sAccion);

            /*................. Se carga el menu de la página ............*/
            this.getConfiguracionMenu("LPDefinirCondicionOferta","");
			this.getFormatosValidaciones();
                
            /*............ 1.Se verifica la acción seleccionada ..............*/
            if (sAccion.equals(""))
            {
                /*.... Crea un Vector lineasProducto y lo guarda en sesión ...*/
                vLineasProducto = new Vector();
                conectorParametroSesion("lineasProducto",vLineasProducto);

                /*.. Crea un Vector productosCondicion y lo guarda en sesión ..*/
                vProductosCondicion = new  Vector();
                conectorParametroSesion("productosCondicion",vProductosCondicion);

                vLineasCondicion = new  Vector();
                conectorParametroSesion("lineasCondicion",vLineasCondicion);

                            
                quitaVariablesPantallaDeSesion();
                /*................. Se carga el menu de la página ............*/
                //this.getConfiguracionMenu("LPDefinirCondicionOferta","");
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              ANADIR CONDICION
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 **/
            else if (sAccion.equals("Anadir condicion")){
                aniadirCondicion();
                guardaParametrosCondicion();
                quitaVariablesPantallaDeSesion();
                cargaParametrosCondicion();
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              BUSCAR LINEAS PRODUCTOS
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* */
            else  if (sAccion.equals("Buscar lineas productos")){
                buscarLineasProductos ();
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              BUSCAR  PRODUCTOS
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * */
            else if (sAccion.equals("Buscar producto")){
                buscarProducto();
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              ELIMINAR LINEAS CONDICION
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* */
            else if (sAccion.equals("Eliminar lineas condicion")){
                eliminarLineasCondicion();
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              ELIMINAR LINEAS PRODUCTOS
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
* */
            else if (sAccion.equals("Eliminar lineas producto")){
                eliminarLineasProductos();
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              ELIMINAR PRODUCTOS
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * */
            else if (sAccion.equals("Eliminar productos")){
                eliminarProductos();
            }
            else if (sAccion.equals("Finalizar")){
                finalizar();
            }
            else if (sAccion.equals("Guardar")){
                guardar();
                //quitaVariablesPantallaDeSesion();
                this.pagina("contenido_condicion_oferta_definir");
				this.getFormatosValidaciones();
                /*.................... Se recargan los combos ...................*/
                cargarCombos();
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              LINEAS SELECCIONADAS
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * */
            else if (sAccion.equals("Lineas seleccionadas")){
            /*  Recoge de sesión el Vector lineasProducto con la información
             *  de cada linea seleccionada (DTOProducto) en la LP LPSeleccionarLineasProductos
             **/
                vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");

            /*  Recoge de sesión el Vector lineasProducto y muestra las lineas
            *  en la Lista Lineas de Producto
            * */
                cargarListaLineasProducto();
                conectorParametroSesion("PaginaDesdeSesion","");
                conectorParametroSesion("PaginaHastaSesion", "");                
            }
/** ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 *              PRODUCTO SELECCIONADO
 *  ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * */
            else if (sAccion.equals("Producto seleccionado")){
            /*Recoge de sesión la Hashtable "Productos" con la información de
             * cada producto seleccionado (DTOProducto)
            */  
                hshProductos = new Hashtable();
                hshProductos = (Hashtable)conectorParametroSesion("Productos");
                /*Muestra la lista Productos con la información de los productos 
                 * seleccionados 
                */               

                /*......... Recoge de sesión el Vector productosCondicion ........*/
                vProductosCondicion = (Vector)conectorParametroSesion("productosCondicion");
                
                /*......... añade los productos (DTOProducto) al Vector ..........*/
                Enumeration en = hshProductos.elements();
                while (en.hasMoreElements())
                {                    
                    DTOProducto dtoProducto = (DTOProducto)en.nextElement();
                    boolean esta=false;
                    for (int i=0;i<vProductosCondicion.size();i++){
                        DTOProducto dtoExistente = (DTOProducto)vProductosCondicion.elementAt(i);
                        if (dtoExistente.getOid().equals(dtoProducto.getOid()))  esta=true;
                    }
                    if (!esta){
                        vProductosCondicion.add(dtoProducto);
                    }
                }
                traza("------------- PRODUCTOS AGREGADOS AL VECTOR vProductosCondicion");
                traza(vProductosCondicion);

                /*......... Pone en sesión el Vector productosCondicion ........*/
                conectorParametroSesion("productosCondicion", vProductosCondicion);
                cargarListaProductos();
                asignarAtributo("VAR","hidHabilitaCatalogo","valor","N");
                conectorParametroSesion("PaginaDesdeSesion","");
                conectorParametroSesion("PaginaHastaSesion", "");
            }

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPDefinirCondicionOferta es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
        }catch(Exception e){
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            traza("El stack es como sigue : " + pila.toString());
            //lanzarPaginaError(e);
        }
    }

    private void cargarCombos() throws Exception{
            /*..... Recoge de sesión de la estrategia seleccionada .......*/
            lOidEstrategia = (Long) conectorParametroSesion("oidEstrategia");
            traza("+++++++++++++++++++++ Estrategia Seleccionada:  "+lOidEstrategia);

            /*..................... Crea un DTOOID .......................*/
            DTOOID dtoOid = new DTOOID();
            dtoOid.setOid(lOidEstrategia);
            dtoOid.setOidIdioma(lIdioma);
            dtoOid.setOidPais(lPais);
                
            /*...Crea el idBusiness="PRECargarCriteriosCondicionOferta...*/
            MareBusinessID id = new MareBusinessID("PRECargarCriteriosCondicionOferta");

            Vector paramEntrada = new Vector();
            paramEntrada.add(dtoOid);
            paramEntrada.add(id);
            
            /*.........Invoca a ConectorCriteriosCondicionOferta..........*/
            DruidaConector conSalida =  conectar("ConectorCriteriosCondicionOferta", paramEntrada);
  
            /*....... Recupera el DTOSCriteriosCondicionOferta ...........*/
            DTOSCriteriosCondicionOferta dtoS = (DTOSCriteriosCondicionOferta) conSalida.objeto("dtoSalida");

            /*..................... Carga Valores ........................*/
            /*............. - Indicadores cuadre de promocion ............*/
            asignar(    "COMBO",
                        "cbIndicadorCuadre",
                        UtilidadesBelcorp.generarConector(  "dtoSalida",
                                                            dtoS.getIndicadoresCuadre(),
                                                            dtoS.getIndicadoresCuadre().getColumnIdentifiers()),
                        "dtoSalida");
            /*............. - Catalogos ..................................*/
            asignar(    "COMBO",
                        "cbCatalogo",
                        UtilidadesBelcorp.generarConector(  "dtoSalida",
                                                            dtoS.getCatalogos(),
                                                            dtoS.getCatalogos().getColumnIdentifiers()),
                        "dtoSalida");
    }

/** ---------------------------------------------------------------------------
 *                              ANADIR CONDICION
 *  ---------------------------------------------------------------------------
 * */
    public void aniadirCondicion() throws Exception{            
            
        Boolean bIndicadorExclusion = null;
        boolean bValorHallado = false;
        int iContadorRangos = 0;
        long  lOidCondicion = 0;
        Long lOidCatalogo = null;
        Long lValorDesde = null;
        Long lValorHasta = null;
        String sLineaProductosSeleccionados = null;
        String sProductosSeleccionados = null;

        String sCheckExcluirPagina = new String();
        String sCheckExcluirLineaProd = new String();
        String sCheckExcluirProducto = new String();

        int iIndexDel = 0;
        String sDesc = new String();
        String sIDLinea = new String();
        String sCodigo = new String();
        
        traza("++++++++++++++++++++  ANADIR CONDICION ++++++++++++++++++++++");        

        /*.. Recupera de sesión el Vector lineasCondicion (Si no existe se crea) ..*/
        vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");
        if (vLineasCondicion == null)  {
            vLineasCondicion = new  Vector();
        }

        /*.......... Recupera desde la pantalla los valores seteados .........*/
        /*
        iFactorCuadre = Integer.valueOf(conectorParametro("hidFactorCuadre")==null?"":conectorParametro("hidFactorCuadre"));        
        lOidIndicadorCuadre = Long.valueOf(conectorParametro("hidIndicadorCuadre")==null?"":conectorParametro("hidIndicadorCuadre"));        
        */
        sCheckExcluirPagina = conectorParametro("hidcheckExcluirPagina")==null?"":
                      conectorParametro("hidcheckExcluirPagina");

        sCheckExcluirLineaProd = conectorParametro("hidcheckExcluirLineaProd")==null?"":
                         conectorParametro("hidcheckExcluirLineaProd");

        sCheckExcluirProducto = conectorParametro("hidcheckExcluirProducto")==null?"":
                        conectorParametro("hidcheckExcluirProducto");
       
        lOidCatalogo = Long.valueOf(conectorParametro("hOidCatalogo")==null?"":conectorParametro("hOidCatalogo"));
        sDescCatalogo = conectorParametro("hidDesCatalogo")==null?"":conectorParametro("hidDesCatalogo");

        sPagDesde = conectorParametro("hidPaginaDesde")==null?"":conectorParametro("hidPaginaDesde");
        sPagHasta = conectorParametro("hidPaginaHasta")==null?"":conectorParametro("hidPaginaHasta");

        lOidCondicion = lObtenerIndiceCondicion().longValue();
        if (!sPagDesde.equals(""))
        {
            DTOLineaPromocion dtoLProm = new DTOLineaPromocion();
            lOidCondicion++;    
            dtoLProm.setOidLineaPromocion(new Long (lOidCondicion));
            dtoLProm.setDescripcionCatalogo(sDescCatalogo);
            dtoLProm.setValorDesde(sPagDesde);
            if (sPagHasta==null||sPagHasta.equals("")){
              dtoLProm.setValorHasta(sPagDesde);
            } else {
              dtoLProm.setValorHasta(sPagHasta);
            }
            dtoLProm.setDescripcionLineaProducto(null);
            dtoLProm.setCodigoProducto(null);
            dtoLProm.setDescripcionProducto(null);
            if( sCheckExcluirPagina.equals("N"))
                dtoLProm.setIndicadorExclusion(Boolean.FALSE);
            else
                dtoLProm.setIndicadorExclusion(Boolean.TRUE);

            dtoLProm.setOidCatalogo(lOidCatalogo);
            dtoLProm.setTipoRango(ConstantesPRE.RANGO_PAGINAS);
            //dtoLProm.setNumeroRangoInterno( new Integer(0));

            vLineasCondicion.add(dtoLProm);
        }
        
        /*......... Si existen datos en la Lista Lineas productos ............*/
        /*Añade una linea en la Lista Lineas condicion por c/linea de producto*/
        sLineaProductosSeleccionados = conectorParametro("hLineaProductosSeleccionados")==null?"":conectorParametro("hLineaProductosSeleccionados");
        asignarAtributo("VAR","hLineaProductosSeleccionados","valor","");

        if (!sLineaProductosSeleccionados.equals("") ) 
        {
            iIndexDel = 0;
            String[] LineasSel = construirLineaSeleccionada (sLineaProductosSeleccionados,"|");

            /*Se parsea el string que contiene las líneas de producto 
             * seleccionados. Ejemplo de string:  1;1;desc1|2;2;desc2 */
            //iContadorRangos = 0;
            for (int i=0;LineasSel.length > i ;i++ ){
                String[] CamposSel = construirLineaSeleccionada (LineasSel[i],";");
                DTOLineaPromocion dtoLProm = new DTOLineaPromocion();
                lOidCondicion++;

                dtoLProm.setOidLineaPromocion(new Long (lOidCondicion));
                dtoLProm.setDescripcionCatalogo(sDescCatalogo);
                dtoLProm.setDescripcionLineaProducto(CamposSel[2]);
                dtoLProm.setCodigoProducto(null);
                dtoLProm.setCodigoLineaProducto(CamposSel[1]);

                dtoLProm.setValorDesde(CamposSel[0]);
//                dtoLProm.setValorHasta(Long.valueOf(CamposSel[0]));
                dtoLProm.setDescripcionProducto(null);

                if( sCheckExcluirLineaProd.equals("N"))
                    dtoLProm.setIndicadorExclusion(Boolean.FALSE);
                else
                    dtoLProm.setIndicadorExclusion(Boolean.TRUE);
                
                dtoLProm.setOidCatalogo(lOidCatalogo);
                dtoLProm.setTipoRango(ConstantesPRE.LINEAS_NEGOCIO);
                //dtoLProm.setNumeroRangoInterno( new Integer(iContadorRangos));

                //... Añado los DTOLineaPromocion al Vector lineasCondicion ..
                vLineasCondicion.add(dtoLProm);                
                //iContadorRangos++;
            }
        }

        /*.................. Si existen datos en la Lista Productos ..........*/
        /*. Añade una linea en la Lista Lineas condicion por c/producto con .*/
        //sProductosSeleccionados = conectorParametroLimpia("hProductosSeleccionados","",true);
        sProductosSeleccionados = conectorParametro("hProductosSeleccionados")==null?"":conectorParametro("hProductosSeleccionados");
        asignarAtributo("VAR","hProductosSeleccionados","valor","");
        asignarAtributo("VAR","hidHabilitaCatalogo","valor","S");
        
        if (!sProductosSeleccionados.equals(""))
        {
            traza("+++++++++++++++ CARGANDO PRODUCTOS EN LA LISTA ++++++++++++");
            iContadorRangos = 0;

            iIndexDel = 0;
            String[] LineasSel = construirLineaSeleccionada (sProductosSeleccionados,"|");

            /*Se parsea el string que contiene las líneas de producto 
             * seleccionados. Ejemplo de string:  1;1;desc1|2;2;desc2*/
            //iContadorRangos = 0;
            for (int i=0;LineasSel.length > i ;i++ ){
                String[] CamposSel = construirLineaSeleccionada (LineasSel[i],";");
                lOidCondicion++;

                DTOLineaPromocion dtoLProm = new DTOLineaPromocion();

                dtoLProm.setOidLineaPromocion(new Long (lOidCondicion));
                dtoLProm.setDescripcionCatalogo(sDescCatalogo);
                dtoLProm.setDescripcionLineaProducto("");
                dtoLProm.setCodigoProducto(CamposSel[1]);
                dtoLProm.setDescripcionProducto(CamposSel[2]);

                if( sCheckExcluirProducto.equals("N"))
                    dtoLProm.setIndicadorExclusion(Boolean.FALSE);
                else
                    dtoLProm.setIndicadorExclusion(Boolean.TRUE);

                dtoLProm.setValorDesde(CamposSel[0]);
                //dtoLProm.setValorHasta(Long.valueOf(CamposSel[0]));
                //dtoLProm.setNumeroRangoInterno( new Integer(iContadorRangos));
                dtoLProm.setOidCatalogo(lOidCatalogo);
                dtoLProm.setTipoRango(ConstantesPRE.PRODUCTOS);
                /*... Añado los DTOLineaPromocion al Vector lineasCondicion ..*/
                vLineasCondicion.add(dtoLProm);
                //iContadorRangos++;
            }
        }
        /*......... Limpio las variables de sesion ........*/
        conectorParametroSesion("productosCondicion", new Vector());
        conectorParametroSesion("lineasProducto", new Vector());

        /*........ Se guarda el vector Lineas Condicion en sesión ...........*/
        conectorParametroSesion("lineasCondicion", vLineasCondicion);
        cargarListaLineasCondicion();
        
        /*................... Limpia los campos de la pantalla ...............*/
       // pagina("contenido_condicion_oferta_definir");   
    }

/** ---------------------------------------------------------------------------
 *                              BUSCAR PRODUCTOS
 *  ---------------------------------------------------------------------------
 * */
    public void buscarProducto() throws Exception{
        /*. Guarda en sesión la LP actual en la variable "volverLPBuscarProducto".*/
        conectorParametroSesion("volverLPBuscarProducto","LPDefinirCondicionOferta");


		/*Corrección incidencia4633*/
		guardaDatosPantallaEnSesion();

    /*
        Activa la nueva logica de presentación: "LPBuscarProducto" con los parametros:
        - multiseleccion = True
        - mostrarValoresAdicionales == False
        (Permitirá la selección multiple de productos en la pantalla BuscarProducto)
        */
            String oidCatalogo = conectorParametroLimpia("cbCatalogo","",true);
            String descripcionCatalogo = conectorParametroLimpia("hidDesCatalogo","",true);
            traza ("oidCatalogo"+oidCatalogo);
            conectorParametroSesion("oidCatalogoPromo",oidCatalogo);
            conectorParametroSesion("descripcionCatalogoPromo",descripcionCatalogo);              
            traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            traza("ACTIVANDO LP: LPBuscarProducto ");
            traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
            conectorAction("LPBuscarProducto");
            conectorActionParametro("multiseleccion","true");
            conectorActionParametro("mostrarValoresAdicionales","false");            
    }
        
/** ---------------------------------------------------------------------------
 *                          BUSCAR  LINEAS PRODUCTOS
 *  ---------------------------------------------------------------------------
 **/
    public void buscarLineasProductos() throws Exception{
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        traza("             buscarLineasProductos");
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        /*.......... Sube los datos de la pantalla a sesión .........*/
        guardaDatosPantallaEnSesion();
        
        /*Guarda en sesión la LP actual en la variable "volverLPSeleccionarLineasProductos"*/
        conectorParametroSesion("volverLPSeleccionarLineasProductos","LPDefinirCondicionOferta");
        /*Activa la nueva logica de presentación: "LPSeleccionarLineasProductos" */
        
        conectorAction("LPSeleccionarLineasProductos");
    }

/** ---------------------------------------------------------------------------
 *                         ELIMINAR LINEAS CONDICION
 *  ---------------------------------------------------------------------------
 * */    
    public void eliminarLineasCondicion() throws Exception{
    /*  Recode de sesión el Vector lineasCondicion y 
     * elimina los DTOLineaPromocion correspondientes a las lineas seleccionadas.
        Guarda el Vector en sesión.
     * */
        traza("++++++++++++++++++ eliminarLineasCondicion +++++++++++++++++++");
        
        String sLineasCondicionSeleccionadas = new String();

     /*................ Recoge de sesión el Vector lineasCondicion ............*/
        vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");
        DTOLineaPromocion dtoC = null;

        /*..... Toma de la pagina las lineas de productos seleccionados ......*/
        sLineasCondicionSeleccionadas = conectorParametro("hLineasCondicionSeleccionadas");
        
        int iIndexDel = 0;
        String sIDLinea = new String();
        String[] LineasSel = construirLineaSeleccionada (sLineasCondicionSeleccionadas,"|");

        /*Se parsea el string que contiene las líneas de producto 
         * seleccionados.
         * Ejemplo de string:  1,1,desc1;2,2,desc2*/
        for (int i=0;LineasSel.length > i ;i++ ){
            iIndexDel =  LineasSel[i].indexOf(";");

            sIDLinea = LineasSel[i].substring(0,iIndexDel);      
            
            Enumeration e = vLineasCondicion.elements();
            traza("Tamaño del Vector de condiciones seleccionadas: " + vLineasCondicion.size());
            while (e.hasMoreElements()) {
                dtoC = (DTOLineaPromocion)e.nextElement();
                
                traza("OidLineaPromocion: "+dtoC.getOidLineaPromocion() );
                if (dtoC.getOidLineaPromocion().toString().equals(sIDLinea))
                {
                    traza("Objeto a eliminar hallado!");
                    vLineasCondicion.remove(dtoC);
                }
            }
        }
        /*........ Se guarda el vector Lineas Condicion en sesión ...........*/
        conectorParametroSesion("lineasCondicion", vLineasCondicion);
        
        traza("CONTENIDO RESULTANTE DEL VECTOR LINEAS DE CONDICION");
        traza (vLineasCondicion);

        cargarListaLineasCondicion();
    }

/** ---------------------------------------------------------------------------
 * 	                    ELIMINAR LINEAS PRODUCTOS
 *  ---------------------------------------------------------------------------
 * */
    public void eliminarLineasProductos() throws Exception{
        String sLineaProductosSeleccionados = null;
        
        traza("++++++++++++++++++ eliminarLineasProductos ++++++++++++++++");
        
        /*................ Recoge de sesión el Vector lineasProducto ............*/
        vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");

        /*. Añade una linea en la Lista Lineas condicion por c/producto con .*/
        sLineaProductosSeleccionados = conectorParametro("hLineaProductosSeleccionados");
        
        int iIndexDel = 0;
        String sIDLinea = new String();
        String[] LineasSel = construirLineaSeleccionada (sLineaProductosSeleccionados,"|");

        /*Se parsea el string que contiene las líneas de producto 
         * seleccionados. Ejemplo de string:  1,1,desc1;2,2,desc2*/
        for (int i=0;LineasSel.length > i ;i++ ){
            iIndexDel =  LineasSel[i].indexOf(";");

            sIDLinea = LineasSel[i].substring(0,iIndexDel);

            /*.... elimina los DTOs correspondientes a las lineas seleccionadas .....*/
            Enumeration e = vLineasProducto.elements();
            DTOLineaProducto dtoLPro = null; 
            while (e.hasMoreElements()) {
                dtoLPro = (DTOLineaProducto)e.nextElement();
                
                if (dtoLPro.getOidLinea().toString().equals(sIDLinea))
                {
                    traza("Eliminando producto HALLADO");
                    vLineasProducto.remove(dtoLPro);
                }
            }
        }        
        traza("CONTENIDO RESULTANTE DEL VECTOR LINEAS DE PRODUCTO");
        traza (vLineasProducto);
        
        /*.................... Guarda el vector en sesión ....................*/
        conectorParametroSesion("lineasProducto",vLineasProducto);
        /*.....,........ Actualiza la Lista Lineas Producto ..................*/
        cargarListaLineasProducto();
    }
/** ---------------------------------------------------------------------------
 *                             ELIMINAR PRODUCTOS
 *  ---------------------------------------------------------------------------
 * */
    public void eliminarProductos()throws Exception   {
        Long iProductoSel = null;
        String sProductosSeleccionados = null;

        traza("++++++++++++++++++ eliminarProductos +++++++++++++++++++++++++");

        /*........... Recoge de sesión el Vector productosCondicion ..........*/
        vProductosCondicion = (Vector)conectorParametroSesion("productosCondicion");
        sProductosSeleccionados = conectorParametro("hProductosSeleccionados");

        int iIndexDel = 0;
        String sIDLinea = new String();
        String[] LineasSel = construirLineaSeleccionada (sProductosSeleccionados,"|");

        /*Se parsea el string que contiene las líneas de producto 
         * seleccionados. Ejemplo de string:  1,1,desc1;2,2,desc2*/
        for (int i=0;LineasSel.length > i ;i++ ){
            iIndexDel =  LineasSel[i].indexOf(";");

            sIDLinea = LineasSel[i].substring(0,iIndexDel);
            
            /*............ elimina los productos correspondientes ..............*/
            /*Tomar de la lista los productos ingresados y eliminarlos del vector*/
            Enumeration en = vProductosCondicion.elements();

            while (en.hasMoreElements())
            {
                DTOProducto dtoP = (DTOProducto)en.nextElement();
                if (dtoP.getOid().toString().equals(sIDLinea))
                {
                    traza("Eliminando Linea de producto HALLADA");
                    vProductosCondicion.remove(dtoP);
                }
            }
        }
        /*................. Guarda el vector en sesión ...............*/
        conectorParametroSesion("productosCondicion",vProductosCondicion);

        traza("CONTENIDO RESULTANTE DEL VECTOR DE PRODUCTO");
        traza (vProductosCondicion);
        if (vProductosCondicion.isEmpty()){
            asignarAtributo("VAR","hidHabilitaCatalogo","valor","S");
        } else {
            asignarAtributo("VAR","hidHabilitaCatalogo","valor","N");
        }

    /*.................... Actualiza la Lista de Productos ...................*/
        cargarListaProductos();
    }

    
/** ---------------------------------------------------------------------------
 *                             FINALIZAR
 *  ---------------------------------------------------------------------------
 **/
    public void finalizar() throws Exception{
        String sUltimaLP = new String();
        traza("++++++++++++++++++  finalizar ++++++++++++++++++++++++++");
        
    /*........................ Activa la LPDefinirOferta .....................*/
        /*conectorAction("LPDefinirOferta");*/
    /*..........la invoca con accion "Comprobar restricciones"................*/
        /*conectorActionParametro("accion","Comprobar restricciones");*/


        /*.....Recoge de sesión la ultima LP activa (variable UltimaLP........*/
        sUltimaLP = (String)conectorParametroSesion("UltimaLP");
        traza("++++++++++++++++++ Invocando UltimaLP: "+ sUltimaLP);
        conectorAction( sUltimaLP );
        if (sUltimaLP.equals("LPDefinirOferta"))
        {
            conectorActionParametro("accion","Comprobar restricciones");
        }
        else
        {
            conectorActionParametro("accion","Condicion aniadida");
        }   
    }

/** ---------------------------------------------------------------------------
 *                             GUARDAR
 *  ---------------------------------------------------------------------------
 * */
    public void guardar() throws Exception{
        traza("+++++++++++++++++ guardar ++++++++++++++++++++++++++++++++");
        
        /*.............. Recupera de sesión el Vector lineasCondicion ............*/
        vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");
        /*.... Recupera de sesión numeroCondicion (Si no se crea con valor 1) ....*/
traza("1");
//         iNumeroCondicion = (Integer)conectorParametroSesion("numeroCondicion");
            String prueba = (String)conectorParametroSesion("numeroCondicion");
            traza("prueba " + prueba);   
		 iNumeroCondicion = (prueba==""||prueba==null?null:Integer.valueOf(prueba));
  //traza("2" + (iNumeroCondicion==null?"":iNumeroCondicion.toString()));      
         if (iNumeroCondicion == null){
            iNumeroCondicion = new Integer(1);
         }else{
             iNumeroCondicion = new Integer(iNumeroCondicion.intValue()+1);
         }
                   

        /*Creamos un DTOPromocion con:
        - numeroCondicion (recuperado de sesión)
        - oidIndicadorCuadre: Correspondiente al seleccionado en pantalla
        - factorCuadre: Introducido en pantalla*/

        fFactorCuadre = new Float(conectorParametro("hidFactorCuadre"));
        lOidIndicadorCuadre = Long.valueOf(conectorParametro("hidIndicadorCuadre"));
        sDesIndicadorCuadre = conectorParametro("hidDesIndCuadre");
                
        DTOPromocion dtoP = new DTOPromocion();
        dtoP.setNumeroCondicion(iNumeroCondicion);
        dtoP.setOidIndicadorCuadre(lOidIndicadorCuadre);
        dtoP.setFactorCuadre(fFactorCuadre);
        dtoP.setDescripcionIndicadorCuadre(sDesIndicadorCuadre);  

        /*Recuperamos los DTOLineaPromocion encontrados en el Vector lineasCondicion
         * y se añaden al DTOPromocion
         * */
        int contadorProductos = 0;
        int contadorLineasProductos = 0;
        int contadorPaginas = 0;
        
        DTOLineaPromocion dtoLP = null;
        Enumeration en = vLineasCondicion.elements();
        while (en.hasMoreElements())
        {
            dtoLP = (DTOLineaPromocion)en.nextElement();
            if (dtoLP.getTipoRango()==ConstantesPRE.PRODUCTOS){
                dtoLP.setNumeroRangoInterno(new Integer(contadorProductos));
                contadorProductos++;
            } else if (dtoLP.getTipoRango()==ConstantesPRE.LINEAS_NEGOCIO){
                dtoLP.setNumeroRangoInterno(new Integer(contadorLineasProductos));
                contadorLineasProductos++;
            } else {
                dtoLP.setNumeroRangoInterno(new Integer(contadorPaginas));
                contadorPaginas++;
            }
            if (dtoP.getLineaPromocion() == null)
                dtoP.setLineaPromocion(new Vector());
            /*........... Se agrega el DTOLineaPromocion al DTOPromocion .........*/
            dtoP.getLineaPromocion().add(dtoLP);
        }

        /*. Aumentamos en 1 el valor de numeroCondicion y lo guardamos en sesión .*/
        //iNumeroCondicion = new Integer(iNumeroCondicion.intValue()+1);
        
        conectorParametroSesion("numeroCondicion",iNumeroCondicion.toString());

        /*................. Recuperamos de sesión el DTOOferta ...............*/
        
        DTOOferta dtoOf = (DTOOferta)conectorParametroSesion("DTOOferta");       
        /*...................... Le añado el DTOPromocion ....................*/
        if (dtoOf.getPromocion()==null)
            dtoOf.setPromocion(new Vector());
        dtoOf.getPromocion().add(dtoP);

        traza(dtoOf);
     
        /*.......... Eliminamos el Vector lineasCondicion de sesión ..............*/
        this.getRequest().getSession().removeAttribute("lineasCondicion");

        /*Muestra la pantalla DefinirCondicionOferta con todos los campos en blanco
        Las listas deberan estar vacias.
         * */
         conectorParametroSesion("DTOOferta",dtoOf);
    }

    /*  Método:cargarLineasProducto
     *  Desc: Toma la info. del vector lineasProducto y llena la lista Líneas de
     *        productos
    * */
    private void cargarListaLineasProducto() throws Exception
    {
        RecordSet recordSet = new RecordSet();
        String listado  =   "listado1";
        int i=0;

        traza("+++++++++++++++++++++ cargarLineasProducto ++++++++++++++++");
        /*................ Recoge de sesión el Vector lineasProducto ............*/
        vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");
        /*.................. Le agrego las columnas de la tabla ..............*/
        llenarRecordSetLineaProductos(recordSet);
        if (vLineasProducto.size() > 0)
        {
            /*............. Cargo la información del vector en la lista ..........*/
            Enumeration en = vLineasProducto.elements();
            //recordSet.setRowCount(vLineasProducto.size()-1);
            while (en.hasMoreElements())
            {
                DTOLineaProducto dtoLP = (DTOLineaProducto)en.nextElement();
                recordSet.addRow(new Vector());
                recordSet.setValueAt(dtoLP.getOidLinea(),i,0);
                recordSet.setValueAt(dtoLP.getCodigo(),i,1);
                recordSet.setValueAt(dtoLP.getDescripcion(),i,2);
                i++;
            }
        }
        else{
            recordSet.setRowCount(0);
        }

        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtosalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtosalida");
    }

    /*  Función: cargaListaProductos
     *  Desc:    Toma la info. del vector vProductosCondicion y llena la lista
     *           de productos
     * */
    private void cargarListaProductos() throws Exception
    {
        RecordSet recordSet = new RecordSet();
        String listado  =   "listado2";
        int i=0;
        
        traza("+++++++++++++++++++++ cargaListaProductos ++++++++++++++++");
        
        /*......... Recoge de sesión el Vector productosCondicion ........*/
        vProductosCondicion = (Vector)conectorParametroSesion("productosCondicion");
        /*.................. Le agrego las columnas de la tabla ..............*/
        llenarRecordSetProductos(recordSet);
            
        if(vProductosCondicion.size() > 0)
        {
            /*............. Cargo la información del vector en la lista ..........*/
            Enumeration en = vProductosCondicion.elements();
            //recordSet.setRowCount(vProductosCondicion.size()-1);
            while (en.hasMoreElements())
            {
                DTOProducto dtoP = (DTOProducto)en.nextElement();
                recordSet.addRow(new Vector());
                recordSet.setValueAt(dtoP.getOid(),i,0);
                recordSet.setValueAt(dtoP.getCodigoSAP(),i,1);
                recordSet.setValueAt(dtoP.getDescripcionSAP(),i,2);
                i++;
            }
        }
        else{
                recordSet.setRowCount(0);
        }   
        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtosalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtosalida");
    }
    
    private void cargarListaLineasCondicion() throws Exception
    {
        RecordSet recordSet = new RecordSet();
        String listado  =   "listado3";
        int i=0;
        traza("+++++++++++++++++++++ cargarLineasCondicion ++++++++++++++++");

        /*........ Recoge de sesión el Vector Lineas Condicion ...........*/
        vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");

        /*.................. Le agrego las columnas de la tabla ..............*/
        llenarRecordSetLineaCondicion(recordSet);
        /*.......... Se limpia la lista para evitar valores repetidos ........*/
        recordSet.setRowCount(0);
        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtosalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtosalida");

        if (vLineasCondicion.size() > 0)
        {
            /*............. Cargo la información del vector en la lista ..........*/
            Enumeration en = vLineasCondicion.elements();
            //recordSet.setRowCount(vLineasCondicion.size()-1);
        
            while (en.hasMoreElements())
            {
                DTOLineaPromocion dtoLPro = (DTOLineaPromocion)en.nextElement();
                recordSet.addRow(new Vector());            
                recordSet.setValueAt(dtoLPro.getOidLineaPromocion(),i,0);
                recordSet.setValueAt(dtoLPro.getDescripcionCatalogo(),i,1);
                if (dtoLPro.getValorHasta()==null||
                    dtoLPro.getValorHasta().equals("")){
                  recordSet.setValueAt(null,i,2);  
                } else {
                  recordSet.setValueAt(dtoLPro.getValorDesde(),i,2);
                }
                recordSet.setValueAt(dtoLPro.getValorHasta(),i,3);
                recordSet.setValueAt(dtoLPro.getDescripcionLineaProducto(),i,4);
                recordSet.setValueAt(dtoLPro.getCodigoProducto(),i,5);
                recordSet.setValueAt(dtoLPro.getDescripcionProducto(),i,6);
                String exclusion = ((dtoLPro.getIndicadorExclusion()!=null)&&(dtoLPro.getIndicadorExclusion().booleanValue()==true))?ConstantesPRE.SI:ConstantesPRE.NO;
                recordSet.setValueAt(exclusion,i,7);                
                i++;
            }
        }
        else
        {
            recordSet.setRowCount(0);
        }
        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtosalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtosalida");
    }

    private void llenarRecordSetLineaProductos(RecordSet recordSet){
        recordSet.addColumn("OID");
        recordSet.addColumn("CODIGO");
        recordSet.addColumn("DESCR");
    }

    private void llenarRecordSetProductos(RecordSet recordSet){
        recordSet.addColumn("OID");
        recordSet.addColumn("CODIGO");
        recordSet.addColumn("DESCR");
    }

    private void llenarRecordSetLineaCondicion(RecordSet recordSet){
        recordSet.addColumn("OID");
        recordSet.addColumn("CATALOGO");
        recordSet.addColumn("PAGDES");
        recordSet.addColumn("PAGHASTA");
        recordSet.addColumn("LINPROD");
        recordSet.addColumn("PRODUCTO");
        recordSet.addColumn("DESCPROD");
        recordSet.addColumn("INDEXCL");
    }

    public String[] construirLineaSeleccionada (String elementosSeleccionados, String delim) 
        throws Exception{
        
        StringTokenizer stk = new StringTokenizer(elementosSeleccionados,delim);
		String[] arr = new String[stk.countTokens()];
		int cuenta = 0;
        while (stk.hasMoreTokens()) {
			arr[cuenta] = stk.nextToken();
			cuenta++;
        }
        return arr;
     }


     /**
     * 
     * @Function: cargaParametrosCondicion
     * @param paramName comments
     * @Description: Carga de sesión los parámetros de condición en los controles
     * @return 
     */
    private void cargaParametrosCondicion() throws Exception
    {
        String sFactorCuadre = new String();
        String sOidIndicadorCuadre = new String();
    
        sOidIndicadorCuadre = (String)(conectorParametroSesion("IndicadorCuadreSesion")==null?"":
                            conectorParametroSesion("IndicadorCuadreSesion"));
        sFactorCuadre = (String)(conectorParametroSesion("FactorCuadreSesion")==null?"":
                            conectorParametroSesion("FactorCuadreSesion"));

        /*Guardo los valores en variables ocultas del form*/
        asignarAtributo("VAR","hidIndicadorCuadre","valor", sOidIndicadorCuadre);
        asignarAtributo("VAR","hidFactorCuadre","valor", sFactorCuadre);
            

        //traza("bIndicadorCuadreSesion: " + sOidIndicadorCuadre);
        //traza("FactorCuadreSesion: "+  sFactorCuadre);
    }

    private void cargaDatosDeSesionEnPantalla(String sAccion) throws Exception
    {
        String sOidCatalogo = new String();
        String sPagD = new String();
        String sPagH = new String();
        String sCheckExcluirPagina = new String();
        String sCheckExcluirLineaProd = new String();
        String sCheckExcluirProducto = new String();
        Long lOidCatalogo = null;
            
        if (!sAccion.equals("")){
            traza("<<<<<<<<<< cargaDatosDeSesionEnPantalla >>>>>>>>>>>>");
            
            /*.............. Devuelvo los valores seteados en sesión .........*/
            cargaParametrosCondicion();
            sOidCatalogo = (String)(conectorParametroSesion("OidCatalogoSesion")==null?"":
                            conectorParametroSesion("OidCatalogoSesion"));
            sPagD = (String)(conectorParametroSesion("PaginaDesdeSesion")==null?"":
                            conectorParametroSesion("PaginaDesdeSesion"));
            sPagH = (String)(conectorParametroSesion("PaginaHastaSesion")==null?"":
                            conectorParametroSesion("PaginaHastaSesion"));
            
            sCheckExcluirPagina = (String)(conectorParametroSesion("CheckExcluirPaginaSesion")==null?"":
                            conectorParametroSesion("CheckExcluirPaginaSesion"));
            sCheckExcluirLineaProd = (String)(conectorParametroSesion("CheckExcluirLineaProd")==null?"":
                            conectorParametroSesion("CheckExcluirLineaProd"));
            sCheckExcluirProducto = (String)(conectorParametroSesion("CheckExcluirProducto")==null?"":
                            conectorParametroSesion("CheckExcluirProducto"));
                            
            /*Guardo los valores en variables ocultas del form*/
            
            asignarAtributo("VAR","hOidCatalogo","valor", sOidCatalogo);
            asignarAtributo("VAR","hidPaginaDesde","valor", sPagD);
            asignarAtributo("VAR","hidPaginaHasta","valor", sPagH);

            asignarAtributo("VAR","hidcheckExcluirPagina","valor", sCheckExcluirPagina);
            asignarAtributo("VAR","hidcheckExcluirLineaProd","valor", sCheckExcluirLineaProd);
            asignarAtributo("VAR","hidcheckExcluirProducto","valor", sCheckExcluirProducto);
            
            traza("+++++++++++++++++++++ Recargando listas... ++++++++");

            /*......... Recoge de sesión el Vector productosCondicion ........*/
            vProductosCondicion = (Vector)conectorParametroSesion("productosCondicion");
            /*................ Recoge de sesión el Vector lineasProducto ............*/
            vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");
            /*........ Recoge de sesión el Vector Lineas Condicion ...........*/
            vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");
            
            if (vLineasProducto != null){
                cargarListaLineasProducto();
            }
            
            if (vProductosCondicion!= null){
                cargarListaProductos();
            }
            
            if ( vLineasCondicion!= null){
                cargarListaLineasCondicion();
            }
			traza("<<<<<<<<<< SALIENDO DE cargaDatosDeSesionEnPantalla >>>>>>>>>>>>");
        }
    }

    /**
     * 
     * @Function: guardaParametrosCondicion
     * @param paramName comments
     * @Description: Guarda en sesión los parámetros de condición
     * @return 
     */
    private void guardaParametrosCondicion() throws Exception
    {
        String sFactorCuadre = new String();
        String sOidIndicadorCuadre = new String();
    
        sOidIndicadorCuadre =   conectorParametro("hidIndicadorCuadre")==null?"":
                                conectorParametro("hidIndicadorCuadre");
                                
        sFactorCuadre = conectorParametro("hidFactorCuadre")==null?"":
                        conectorParametro("hidFactorCuadre");


        conectorParametroSesion("IndicadorCuadreSesion",sOidIndicadorCuadre);
        conectorParametroSesion("FactorCuadreSesion", sFactorCuadre);

//        traza("bIndicadorCuadreSesion: " + sOidIndicadorCuadre);
//        traza("FactorCuadreSesion: "+  sFactorCuadre);
    }

    /**
     * 
     * @Function: guardaDatosPantallaEnSesion
     * @param paramName comments
     * @Description: Guarda en sesión los valores tomados de los controles, para
     * poder, al regresar de alguna LP, setear en los controles los valores que
     * tenían antes de la llamada a la misma.
     * @return 
     */
    private void guardaDatosPantallaEnSesion() throws Exception
    {
        String sCheckExcluirPagina = new String();
        String sCheckExcluirLineaProd = new String();
        String sCheckExcluirProducto = new String();
        String sOidCatalogo = new String();
        String sPagD = new String();
        String sPagH = new String();

traza(">>>>>> INGRESANDO A guardaDatosPantallaEnSesion");
        guardaParametrosCondicion();
                        
        sOidCatalogo =  conectorParametro("hOidCatalogo")==null?"":
                        conectorParametro("hOidCatalogo");
                                
        sPagD =         conectorParametro("hidPaginaDesde")==null?"":
                        conectorParametro("hidPaginaDesde");
                        
        sPagH =         conectorParametro("hidPaginaHasta")==null?"":
                        conectorParametro("hidPaginaHasta");

        sCheckExcluirPagina = conectorParametro("hidcheckExcluirPagina")==null?"":
                              conectorParametro("hidcheckExcluirPagina");

        sCheckExcluirLineaProd = conectorParametro("hidcheckExcluirLineaProd")==null?"":
                                 conectorParametro("hidcheckExcluirLineaProd");

        sCheckExcluirProducto = conectorParametro("hidcheckExcluirProducto")==null?"":
                                conectorParametro("hidcheckExcluirProducto");
        
        /*......... Guardo en sesión los valores de los controles ...........*/
        conectorParametroSesion("OidCatalogoSesion", sOidCatalogo);        
        conectorParametroSesion("PaginaDesdeSesion",sPagD);
        conectorParametroSesion("PaginaHastaSesion", sPagH);
        conectorParametroSesion("CheckExcluirPaginaSesion", sCheckExcluirPagina);
        conectorParametroSesion("CheckExcluirLineaProd", sCheckExcluirLineaProd);
        conectorParametroSesion("CheckExcluirProducto", sCheckExcluirProducto);

        traza("+++++++++++ VALORES OBTENIDOS DE LA PANTALLA +++++++++++++++++");
        traza("OidCatalogoSesion: "+ sOidCatalogo);
        traza("idPaginaDesdeSesion: "+ sPagD);
        traza("idPaginaHastaSesion: "+ sPagH);
        traza("CheckExcluirLineaProd: "+ sCheckExcluirLineaProd);
        traza("CheckExcluirProducto: "+ sCheckExcluirProducto);
        traza("CheckExcluirPagina: "+  sCheckExcluirPagina);
traza(">>>>>> SALIENDO DE guardaDatosPantallaEnSesion");

    }

    private void quitaVariablesPantallaDeSesion() throws Exception
    {
    traza("+++++++++++ Limpiando valores en sesión de los controles de pantalla +++++");
    
        /*Quito de sesion las variables con los valores de pantalla*/
        this.getRequest().getSession().removeAttribute("OidCatalogoSesion");
        this.getRequest().getSession().removeAttribute("PaginaDesdeSesion");
        this.getRequest().getSession().removeAttribute("PaginaHastaSesion");        
        this.getRequest().getSession().removeAttribute("CheckExcluirPaginaSesion");
        this.getRequest().getSession().removeAttribute("CheckExcluirLineaProd");
        this.getRequest().getSession().removeAttribute("CheckExcluirProducto");

        /*Se limpian las listas*/
        RecordSet recordSet = new RecordSet();

        llenarRecordSetLineaProductos(recordSet);
        recordSet.setRowCount(0);
        asignar("LISTADOA","listado1",UtilidadesBelcorp.generarConector("dtosalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtosalida");

        llenarRecordSetProductos(recordSet);
        recordSet.setRowCount(0);
        asignar("LISTADOA","listado2",UtilidadesBelcorp.generarConector("dtosalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtosalida");
                    
    }
/**
 * 
 * @Function #vObtenerIndiceCondicion
 * @param 
 * @Description Recupera el indice de condiciones insertadas.
 * @return comments
 */

    private Long lObtenerIndiceCondicion() throws Exception
    {
        Long lIndice = null;
        DTOLineaPromocion dtoLinProm;

        if (!vLineasCondicion.isEmpty())
        {
            dtoLinProm =  (DTOLineaPromocion)vLineasCondicion.lastElement();
            lIndice = dtoLinProm.getOidLineaPromocion();
        }
        else
            lIndice = Long.valueOf("0");

        return lIndice;
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
