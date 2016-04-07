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

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOLineaProducto;
import es.indra.sicc.dtos.pre.DTOLineaPromocion;
import es.indra.sicc.dtos.pre.DTOOferta;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOPromocion;
import es.indra.sicc.dtos.pre.DTOSCriteriosCondicionOferta;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;

public class LPModificarCondicion extends LPSICCBase{
    private Long oidPais = new Long(0);
    private Long oidIdioma = new Long(0);
    private String accion = "";
    private String casoDeUso = "";
    private Long indCuadre = null;
    private Long catalogo = null;
    private String factorCuadre;
    private String valorDesde;
    private String valorHasta;
    private String sCatalogo;
    private String sLineaProductosSeleccionados;
    private String sCheckExcluirPaginas;
    private String sCheckExcluirLineasProductos;
    private String sCheckExcluirProductos;
    private String sProductosSeleccionados;
    private String sLineasCondicionSeleccionadas;
    private String sIndCuadre;    
    private Vector vLineasCondicion = new Vector();
    private Vector vLineasProducto = new Vector();
    private Vector vProductosCondicion = new Vector();
    private Hashtable hshProductos = new Hashtable();
    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;

    public LPModificarCondicion(){
	      super();
    }

    public void inicio() throws Exception{
        setTrazaFichero();
    }

    public void ejecucion() throws Exception {
        TiempoDeCargaInicio=System.currentTimeMillis();
        String accion = null;
    
        try{		
            accion = conectorParametroLimpia("accion","",true);
            traza("ENTRO A EJECUCION Accion: " + accion);
            oidPais = UtilidadesSession.getPais(this);
            oidIdioma = UtilidadesSession.getIdioma(this);
    
            conectorParametroSesion("productosCondicion",vProductosCondicion);        

            if (accion.equals("")){
                cargarValoresIniciales();
                cargarCombos();
                accionVacia();
                ponerValoresEnPantalla();
            }else if (accion.equals("Buscar lineas productos")){
                tomarValoresDePantalla();
                buscarLineasProductos();
            }else if (accion.equals("Lineas seleccionadas")){
                cargarValoresIniciales();
                InicializaControlesFormulario(accion);
                cargarCombos();
                vLineasProducto = (Vector) conectorParametroSesion("lineasProducto");
                cargarListaLineasProducto();
            }else if (accion.equals("Eliminar lineas producto")){
                tomarValoresDePantalla();
                cargarValoresIniciales();
                eliminarLineasProductos();
                cargarCombos();
                ponerValoresEnPantalla();
            }else if (accion.equals("Buscar producto")){
                tomarValoresDePantalla();
                buscarProducto();
            }else if (accion.equals("Producto seleccionado")){
                cargarValoresIniciales();
                cargarCombos();
                InicializaControlesFormulario(accion);
                hshProductos = (Hashtable) conectorParametroSesion("Productos");       
                vProductosCondicion = (Vector) conectorParametroSesion("productosCondicion");
                Enumeration en = hshProductos.elements();
                while (en.hasMoreElements()) {
                    DTOProducto dtoProducto = (DTOProducto)en.nextElement();
                    if (!inVectorProductos(vProductosCondicion,dtoProducto)){     
                        vProductosCondicion.add(dtoProducto);
                    }
                }
                cargarListaProductos();
            }else if (accion.equals("Eliminar productos")){
                tomarValoresDePantalla();
                cargarValoresIniciales();
                eliminarProductos();
                cargarCombos();
                ponerValoresEnPantalla();
            }else if (accion.equals("Anadir condicion")){
                tomarValoresDePantalla();
                cargarValoresIniciales();
          			aniadirCondicion();
                cargarCombos();
                ponerValoresEnPantalla();
            }else if (accion.equals("Eliminar lineas condicion")){
                tomarValoresDePantalla();
                cargarValoresIniciales();
                eliminarLineasCondicion();
                cargarCombos();
                ponerValoresEnPantalla();
            }else if (accion.equals("Guardar")){
                tomarValoresDePantalla();
                cargarValoresIniciales();
                guardar();
            }
        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPModificarCondicionOferta es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
        }catch (Exception e){
            cargarValoresIniciales();
            traza("*********Estoy en excepcion***************");
            logStackTrace(e);
            lanzarPaginaError(e);
            traza("**********************************");
        }
  	}

    /* ************** logStackTrace ******************* */
    private void logStackTrace(Throwable e) {
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        e.printStackTrace(ps);
        try {
           traza(os.toString());
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    private void ponerValoresEnPantalla() throws Exception{
        /*Guardo los valores en variables ocultas del form*/
        if (catalogo!=null)
            asignarAtributo("VAR","hOidCatalogo","valor", catalogo.toString());
        if (indCuadre!=null)
            asignarAtributo("VAR","hidIndicadorCuadre","valor", indCuadre.toString());
        if (!(accion.equals("Anadir condicion"))){
            if (valorDesde!=null)
                asignarAtributo("VAR","hidPaginaDesde","valor", valorDesde);
            if (valorHasta!=null)
                asignarAtributo("VAR","hidPaginaHasta","valor", valorHasta);
        }
        if (factorCuadre!=null)
            asignarAtributo("VAR","hidFactorCuadre","valor", factorCuadre);
        if (sCheckExcluirPaginas!=null)
            asignarAtributo("VAR","hidcheckExcluirPagina","valor", sCheckExcluirPaginas);

        traza("++++++++ Recargando listas... ++++++++");

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
    }

    private void cargarValoresIniciales() throws Exception{
        pagina("contenido_condicion_oferta_definir");
        this.getConfiguracionMenu("LPModificarCondicion","");
		this.getFormatosValidaciones();
        asignarAtributo("PAGINA","contenido_condicion_oferta_definir","cod","0151");
        asignarAtributo("VAR","casoDeUso","valor","Modificar Condicion");
        asignarAtributo("VAR","conectorAction","valor","LPModificarCondicion");
    }

    private void tomarValoresDePantalla() throws Exception{
        indCuadre = (conectorParametro("cbIndicadorCuadre")==null || 
                                  conectorParametro("cbIndicadorCuadre").equals(""))?null:
                                  Long.valueOf(conectorParametro("cbIndicadorCuadre"));
        catalogo = (conectorParametro("cbCatalogo")==null || 
                                  conectorParametro("cbCatalogo").equals(""))?null:
                                  Long.valueOf(conectorParametro("cbCatalogo"));
                                  
        factorCuadre = conectorParametro("txtFactorCuadre");
        valorDesde = conectorParametro("hidPaginaDesde");
        valorHasta = conectorParametro("hidPaginaHasta");
        sCatalogo = conectorParametro("hidDesCatalogo");
        sIndCuadre = conectorParametro("hidDesIndCuadre");
        sLineaProductosSeleccionados = conectorParametro("hLineaProductosSeleccionados");
        sCheckExcluirPaginas = conectorParametro("hidcheckExcluirPagina")==null?"":conectorParametro("hidcheckExcluirPagina");
        sCheckExcluirLineasProductos = conectorParametro("hidcheckExcluirLineaProd")==null?"":conectorParametro("hidcheckExcluirLineaProd");
        sCheckExcluirProductos = conectorParametro("hidcheckExcluirProducto")==null?"":conectorParametro("hidcheckExcluirProducto");
        sProductosSeleccionados = conectorParametro("hProductosSeleccionados")==null?"":conectorParametro("hProductosSeleccionados");
        sLineasCondicionSeleccionadas = (String)conectorParametro("hLineasCondicionSeleccionadas");
    }

    private void accionVacia() throws Exception{
        int  iOidCondicion = 0;
        conectorParametroSesion("lineasProducto",vLineasProducto);

        /* Recupera de sesión el DTOPromocion que se va a modificar (DTOPromocion.oidPromocion == numeroCondicion recibido) */
        DTOPromocion dtoPromo = (DTOPromocion) conectorParametroSesion("dtoPromocion");
        asignarAtributo("VAR","hidIndicadorCuadre","valor", dtoPromo.getOidIndicadorCuadre().toString());

        asignarAtributo("VAR","hidFactorCuadre","valor", dtoPromo.getFactorCuadre().toString());
        Enumeration vLineaPromocion = dtoPromo.getLineaPromocion().elements();
            
        while (vLineaPromocion.hasMoreElements()){
            DTOLineaPromocion dtoLinPromo = new DTOLineaPromocion(); 
            DTOLineaPromocion aLineaPromocion = (DTOLineaPromocion)vLineaPromocion.nextElement();
            
            // Agregado por ssantana, 28/10/2005, GCC-PRE-001
            dtoLinPromo.setTipoOperacion(aLineaPromocion.getTipoOperacion());
            // Fin Agregado por ssantana, 28/10/2005, GCC-PRE-001   

			dtoLinPromo.setIndicadorExclusion(aLineaPromocion.getIndicadorExclusion());

            if (aLineaPromocion.getTipoRango() == ConstantesPRE.RANGO_PAGINAS){
                iOidCondicion++;    

                dtoLinPromo.setDescripcionCatalogo(aLineaPromocion.getDescripcionCatalogo());
                dtoLinPromo.setValorDesde(aLineaPromocion.getValorDesde());
                dtoLinPromo.setValorHasta(aLineaPromocion.getValorHasta());
                dtoLinPromo.setDescripcionLineaProducto(null);
                dtoLinPromo.setCodigoProducto(null);
                dtoLinPromo.setDescripcionProducto(null);

                dtoLinPromo.setOidLineaPromocion(new Long(iOidCondicion));
                dtoLinPromo.setOidCatalogo(aLineaPromocion.getOidCatalogo());
                dtoLinPromo.setTipoRango(ConstantesPRE.RANGO_PAGINAS);
                dtoLinPromo.setNumeroRangoInterno(aLineaPromocion.getNumeroRangoInterno());

                vLineasCondicion.add(dtoLinPromo);

            }
            if (aLineaPromocion.getTipoRango() == ConstantesPRE.LINEAS_NEGOCIO){
                iOidCondicion++;    

                dtoLinPromo.setDescripcionCatalogo(aLineaPromocion.getDescripcionCatalogo());
                dtoLinPromo.setValorDesde(aLineaPromocion.getValorDesde());
                dtoLinPromo.setValorHasta(aLineaPromocion.getValorHasta());
                dtoLinPromo.setDescripcionLineaProducto(aLineaPromocion.getDescripcionLineaProducto());
                dtoLinPromo.setCodigoProducto(null);
                dtoLinPromo.setDescripcionProducto(null);

                dtoLinPromo.setOidLineaPromocion(new Long(iOidCondicion));
                dtoLinPromo.setOidCatalogo(aLineaPromocion.getOidCatalogo());
                dtoLinPromo.setTipoRango(ConstantesPRE.LINEAS_NEGOCIO);
                dtoLinPromo.setNumeroRangoInterno(aLineaPromocion.getNumeroRangoInterno());

                vLineasCondicion.add(dtoLinPromo);
            }
            if (aLineaPromocion.getTipoRango() == ConstantesPRE.PRODUCTOS){
                iOidCondicion++;    

                dtoLinPromo.setDescripcionCatalogo(aLineaPromocion.getDescripcionCatalogo());
                dtoLinPromo.setValorDesde(aLineaPromocion.getValorDesde());
                dtoLinPromo.setValorHasta(aLineaPromocion.getValorHasta());
                dtoLinPromo.setDescripcionLineaProducto(null);
                dtoLinPromo.setCodigoProducto(aLineaPromocion.getCodigoProducto());
                dtoLinPromo.setDescripcionProducto(aLineaPromocion.getDescripcionProducto());

                dtoLinPromo.setOidLineaPromocion(new Long(iOidCondicion));
                dtoLinPromo.setOidCatalogo(aLineaPromocion.getOidCatalogo());
                dtoLinPromo.setTipoRango(ConstantesPRE.PRODUCTOS);
                dtoLinPromo.setNumeroRangoInterno(aLineaPromocion.getNumeroRangoInterno());

                vLineasCondicion.add(dtoLinPromo);
            }
        }
        traza("*************************************************");
        traza("Esto es el vector que guardo en Sesion con el cual se carga la Pagina");
        traza(vLineasCondicion);
        conectorParametroSesion("lineasCondicion",vLineasCondicion);
        cargarListaLineasCondicion();
    }

    private void cargarCombos() throws Exception{
    		DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidPais(oidPais);
        dtoBelcorp.setOidIdioma(oidIdioma);

        /* Crea el idBusiness = "PRECargarCriteriosCondicionOferta"  */
        MareBusinessID idBusiness = new MareBusinessID("PRECargarCriteriosCondicionOferta");
            
        Vector paramEntrad = new Vector();
        paramEntrad.addElement(dtoBelcorp);
        paramEntrad.addElement(idBusiness);

        DruidaConector  conectorCriteriosCondicionOferta = conectar("ConectorCriteriosCondicionOferta", paramEntrad);          
		    DTOSCriteriosCondicionOferta dtoCriteriosCondicionOferta = (DTOSCriteriosCondicionOferta) conectorCriteriosCondicionOferta.objeto("dtoSalida");

    		RecordSet condicionOfertaInd = dtoCriteriosCondicionOferta.getIndicadoresCuadre();
        Vector colInd = condicionOfertaInd.getColumnIdentifiers();
            

        DruidaConector indCondicionOferta = UtilidadesBelcorp.generarConector("dtoSalida.indicadoresCuadre_ROWSET",condicionOfertaInd,colInd);
        asignar("COMBO", "cbIndicadorCuadre", indCondicionOferta, "dtoSalida.indicadoresCuadre_ROWSET");

    		RecordSet condicionOfertaCat = dtoCriteriosCondicionOferta.getCatalogos();
        Vector colCat = condicionOfertaCat.getColumnIdentifiers();
                    
        DruidaConector catCondicionOferta = UtilidadesBelcorp.generarConector("dtoSalida.catalogos_ROWSET",condicionOfertaCat,colCat);
        asignar("COMBO", "cbCatalogo", catCondicionOferta, "dtoSalida.catalogos_ROWSET");
    }
    
    public void buscarLineasProductos()  throws Exception {
        guardaDatosPantalla();        
        conectorParametroSesion("volverLPSeleccionarLineasProductos","LPModificarCondicion");
        conectorAction("LPSeleccionarLineasProductos");
        conectorActionParametro("accion","");
    }

    public void eliminarLineasProductos() throws Exception{
        String sLineaProductosSeleccionados = null;        
        vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");
        
        //sLineaProductosSeleccionados = conectorParametro("hLineaProductosSeleccionados");

        int iIndexDel = 0;
        String sIDLinea = new String();
        String[] LineasSel = construirLineaSeleccionada (sLineaProductosSeleccionados,"|");

        for (int i=0;LineasSel.length > i ;i++ ){
            iIndexDel =  LineasSel[i].indexOf(";");

            sIDLinea = LineasSel[i].substring(0,iIndexDel);

            /* elimina los DTOs correspondientes a las lineas seleccionadas */
            Enumeration e = vLineasProducto.elements();
            DTOLineaProducto dtoLPro = null; 
            while (e.hasMoreElements()) {
                dtoLPro = (DTOLineaProducto)e.nextElement();
                
                if (dtoLPro.getOidLinea().toString().equals(sIDLinea)){
                    vLineasProducto.remove(dtoLPro);
                }
            }
        }
        conectorParametroSesion("lineasProducto",vLineasProducto);
        cargarListaLineasProducto();

    }

    public void buscarProducto() throws Exception {
        guardaDatosPantalla();
        conectorParametroSesion("volverLPBuscarProducto","LPModificarCondicion");

        conectorAction("LPBuscarProducto");
        conectorActionParametro("multiseleccion","true");
        conectorActionParametro("mostrarValoresAdicionales","false");
        conectorActionParametro("accion","");        
    }

    public void eliminarProductos() throws Exception {
        String sProductosSeleccionados = null;
		    /*Recoge de sesión el Vector productosCondicion */
        vProductosCondicion = (Vector) conectorParametroSesion("productosCondicion");
        int iIndexDel = 0;
        String sIDLinea = new String();
        String[] LineasSel = construirLineaSeleccionada(sProductosSeleccionados,"|");

        /*Elimina los productos correspondientes */
        for (int i=0;LineasSel.length > i ; i++){
            iIndexDel = LineasSel[i].indexOf(";");
            sIDLinea = LineasSel[i].substring(0,iIndexDel);

            Enumeration en = vProductosCondicion.elements();

            while (en.hasMoreElements()){
                DTOProducto dtoProducto = (DTOProducto) en.nextElement();
                if (dtoProducto.getOid().toString().equals(sIDLinea)){
                    vProductosCondicion.remove(dtoProducto);
                }
            }
        }				
        /*Guarda el vector en sesión */
        conectorParametroSesion("productosCondicion",vProductosCondicion);
        /*Actualiza la Lista Productos*/
        cargarListaProductos();
    }

  	public void aniadirCondicion() throws Exception {
        int  iOidCondicion = 0;
        vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");

        if (valorDesde != null && !valorDesde.equals("")) {
            traza("se va a agregar una condicion simple");
            DTOLineaPromocion dtoLineaPromocion = new DTOLineaPromocion();

            iOidCondicion++;    
            dtoLineaPromocion.setOidLineaPromocion(new Long(iOidCondicion));

            dtoLineaPromocion.setDescripcionCatalogo(sCatalogo);
            dtoLineaPromocion.setValorDesde(valorDesde);
            if (valorHasta==null || valorHasta.equals("")){
                dtoLineaPromocion.setValorHasta(valorDesde);
            }else{
                dtoLineaPromocion.setValorHasta(valorHasta);
            }
            dtoLineaPromocion.setDescripcionLineaProducto(null);
            dtoLineaPromocion.setCodigoProducto(null);
            dtoLineaPromocion.setDescripcionProducto(null);

            dtoLineaPromocion.setOidCatalogo(catalogo);
            dtoLineaPromocion.setTipoRango(ConstantesPRE.RANGO_PAGINAS);
            //dtoLineaPromocion.setNumeroRangoInterno(new Integer(0));
            if( sCheckExcluirPaginas.equals("N"))
                dtoLineaPromocion.setIndicadorExclusion(Boolean.FALSE);
            else
                dtoLineaPromocion.setIndicadorExclusion(Boolean.TRUE);

            // Agregado por ssantana, 5/10/2005, GCC-PRE-001
            dtoLineaPromocion.setTipoOperacion("alta");
            // Fin Agregado por ssantana, 5/10/2005, GCC-PRE-001
            
            if (!vLineasCondicion.contains(dtoLineaPromocion)){
                vLineasCondicion.add(dtoLineaPromocion);
            }
        }

        if (!sLineaProductosSeleccionados.equals("")){
            int iIndexDel = 0;
            String[] LineasSel = construirLineaSeleccionada(sLineaProductosSeleccionados,"|");
            //int iContadorRango = 0;
            traza("se van a agregar lineas de condicion");
            for (int i=0;LineasSel.length>i;i++){
                String[] CampoSel = construirLineaSeleccionada(LineasSel[i],";");

                DTOLineaPromocion dtoLineaPromocion = new DTOLineaPromocion();

                iOidCondicion++;    
                dtoLineaPromocion.setOidLineaPromocion(new Long(iOidCondicion));

                dtoLineaPromocion.setDescripcionCatalogo(sCatalogo);
                dtoLineaPromocion.setValorDesde(CampoSel[0]);
                dtoLineaPromocion.setValorHasta(null);

                dtoLineaPromocion.setDescripcionLineaProducto(CampoSel[2]);
                dtoLineaPromocion.setCodigoProducto(null);
                dtoLineaPromocion.setCodigoLineaProducto(CampoSel[1]);
                dtoLineaPromocion.setDescripcionProducto(null);

                dtoLineaPromocion.setOidCatalogo(catalogo);
                dtoLineaPromocion.setTipoRango(ConstantesPRE.LINEAS_NEGOCIO);
                //dtoLineaPromocion.setNumeroRangoInterno(new Integer(iContadorRango));
                if( sCheckExcluirLineasProductos.equals("N"))
                    dtoLineaPromocion.setIndicadorExclusion(Boolean.FALSE);
                else
                    dtoLineaPromocion.setIndicadorExclusion(Boolean.TRUE);
                
                // Agregado por ssantana, 5/10/2005, GCC-PRE-001
                dtoLineaPromocion.setTipoOperacion("alta");
                // Fin Agregado por ssantana, 5/10/2005, GCC-PRE-001

                if (!vLineasCondicion.contains(dtoLineaPromocion)){
                    vLineasCondicion.add(dtoLineaPromocion);
                   // iContadorRango++;
                }
            }
        }
        //traza("productos seleccionados: "+sProductosSeleccionados);
        if (!sProductosSeleccionados.equals("")){
            int iIndexDel = 0;
            String[] LineasSel = construirLineaSeleccionada(sProductosSeleccionados,"|");
            int iContadorRango = 0;
            traza("se van a agregar productos");
            for (int i=0;LineasSel.length>i;i++){
                String[] CampoSel = construirLineaSeleccionada(LineasSel[i],";");

                DTOLineaPromocion dtoLineaPromocion = new DTOLineaPromocion();

                iOidCondicion++;    
                dtoLineaPromocion.setOidLineaPromocion(new Long(iOidCondicion));

                dtoLineaPromocion.setDescripcionCatalogo(sCatalogo);
                dtoLineaPromocion.setValorDesde(CampoSel[0]);
                dtoLineaPromocion.setValorHasta(null);

                dtoLineaPromocion.setDescripcionLineaProducto(null);
                dtoLineaPromocion.setCodigoProducto(CampoSel[1]);
                dtoLineaPromocion.setDescripcionProducto(CampoSel[2]);

                dtoLineaPromocion.setOidCatalogo(catalogo);
                dtoLineaPromocion.setTipoRango(ConstantesPRE.PRODUCTOS);
                //dtoLineaPromocion.setNumeroRangoInterno(new Integer(iContadorRango));
                if( sCheckExcluirProductos.equals("N"))
                    dtoLineaPromocion.setIndicadorExclusion(Boolean.FALSE);
                else
                    dtoLineaPromocion.setIndicadorExclusion(Boolean.TRUE);


                // Agregado por ssantana, 5/10/2005, GCC-PRE-001
                dtoLineaPromocion.setTipoOperacion("alta");
                // Fin Agregado por ssantana, 5/10/2005, GCC-PRE-001

                if (!vLineasCondicion.contains(dtoLineaPromocion)){
                    vLineasCondicion.add(dtoLineaPromocion);
                    //iContadorRango++;
                }
            }
        }
        /*......... Limpio las variables de sesion ........*/
        conectorParametroSesion("productosCondicion", new Vector());
        conectorParametroSesion("lineasProducto", new Vector());
        valorDesde = "";
        valorHasta = "";
        
        // Agregado por ssantana, 13/10/2005, GCC-PRE-001
        DTOOferta dtoOferta = (DTOOferta) this.conectorParametroSesion("DTOOferta");
        dtoOferta.setModificacionPromocion(Boolean.TRUE);
        this.conectorParametroSesion("DTOOferta", dtoOferta);
        // Fin agregado por ssantana, 13/10/2005, GCC-PRE-001
        
        renumerarOid(vLineasCondicion);
        conectorParametroSesion("lineasCondicion", vLineasCondicion);
        cargarListaLineasCondicion();
	  }
  
    public void eliminarLineasCondicion() throws Exception {
        traza("LPModificarCondicion.eliminarLineasCondicion()");
        String sLineaProductosSeleccionados = new String();

        Vector vLineasCondicion = (Vector) conectorParametroSesion("lineasCondicion");
        Enumeration e = vLineasCondicion.elements();
        DTOLineaPromocion dtoC = null;

        int iIndexDel = 0;
        String sIDLinea = new String();
        String[] LineasSel = construirLineaSeleccionada (sLineasCondicionSeleccionadas,"|");

        for (int i=0;LineasSel.length > i ;i++ ){
            iIndexDel =  LineasSel[i].indexOf(";");
            sIDLinea = LineasSel[i].substring(0,iIndexDel);      
            Enumeration en = vLineasCondicion.elements();
            while (en.hasMoreElements()) {
                dtoC = (DTOLineaPromocion)en.nextElement();
                // Agregado por ssantana, 5/10/2005, GCC-PRE-001. 
                if (dtoC.getOidLineaPromocion().toString().equals(sIDLinea)){
                    //vLineasCondicion.remove(dtoC);
                    traza("Da de baja");
                    dtoC.setTipoOperacion("baja");
                }
            }
        }
        /*........ Se guarda el vector Lineas Condicion en sesión ...........*/		
        conectorParametroSesion("lineasCondicion", vLineasCondicion);
        
        // Agregado por ssantana, 13/10/2005, GCC-PRE-001
        DTOOferta dtoOferta = (DTOOferta) this.conectorParametroSesion("DTOOferta");
        dtoOferta.setModificacionPromocion(Boolean.TRUE);
        this.conectorParametroSesion("DTOOferta", dtoOferta);
        // Fin Agregado por ssantana, 13/10/2005, GCC-PRE-001
        
        cargarListaLineasCondicion();       
    }

    public void guardar()throws Exception{
        traza("metodo guardar en modificar condicion");

        /*Recuperamos de sesión el Vector lineasCondicion */
        /*Recuperamos de sesión la variable numeroCondicion*/
        Vector vLineasCondicion = new Vector(); 
        vLineasCondicion = (conectorParametroSesion("lineasCondicion")==null?null:(Vector)conectorParametroSesion("lineasCondicion"));
        String nroCondicionStr = (String)conectorParametroSesion("numeroCondicion");
        Integer iNumeroCondicion =null;
        iNumeroCondicion = (nroCondicionStr==""?null:Integer.valueOf(nroCondicionStr));

        DTOPromocion dtoPromocion = (DTOPromocion) conectorParametroSesion("dtoPromocion");

        dtoPromocion.setNumeroCondicion(iNumeroCondicion);
        dtoPromocion.setDescripcionIndicadorCuadre(sIndCuadre);
        dtoPromocion.setOidIndicadorCuadre(indCuadre);
        dtoPromocion.setFactorCuadre(Float.valueOf(factorCuadre));
        
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
            if (dtoPromocion.getLineaPromocion() == null)
                dtoPromocion.setLineaPromocion(new Vector());
            /*........... Se agrega el DTOLineaPromocion al DTOPromocion .........*/
            dtoPromocion.getLineaPromocion().add(dtoLP);
        }
        /*
        Sustituimos los DTOLineaPromocion del DTOPromocion por los que se encuentran en el Vector.*/
        dtoPromocion.setLineaPromocion(vLineasCondicion);
        conectorParametroSesion("dtoPromocion",dtoPromocion);
        
        // Agregado por ssantana, GCC-PRE-001, 5/10/2005
        dtoPromocion.setTipoOperacion("alta");
        // Fin Agregado por ssantana, GCC-PRE-001, 5/10/2005

        // Agregado por ssantana, 13/10/2005, GCC-PRE-001
        DTOOferta dtoOferta = (DTOOferta) this.conectorParametroSesion("DTOOferta");
        dtoOferta.setModificacionPromocion(Boolean.TRUE);
        this.conectorParametroSesion("DTOOferta", dtoOferta);
        // Fin Agregado por ssantana, 13/10/2005, GCC-PRE-001
        
        /*Eliminamos el Vector lineasCondicion de sesión. */
        this.getRequest().getSession().removeAttribute("lineasCondicion");
        
        

        /*Activa la LPModificarOferta con accion = "Condicion añadida" */
        traza("antes de volver a la LPModificarOferta");
        conectorAction("LPModificarOferta");
        conectorActionParametro("accion","Condicion modificada");
    }

    public String[] construirLineaSeleccionada (String elementosSeleccionados, String delim) throws Exception{
        StringTokenizer stk = new StringTokenizer(elementosSeleccionados,delim);
        String[] arr = new String[stk.countTokens()];
        int cuenta = 0;
        while (stk.hasMoreTokens()) {
        arr[cuenta] = stk.nextToken();
        cuenta++;
        }
        return arr;
    }

    private void cargarListaLineasCondicion()  throws Exception {
        RecordSet recordSet = new RecordSet();
        String listado  =   "listado3";
        int i=0;

        vLineasCondicion = (Vector)conectorParametroSesion("lineasCondicion");
        if (vLineasCondicion.size() > 0){
            traza("Estoy en vLineasCondicion.size > 0 **************************");
            llenarRecordSetLineaCondicion(recordSet);
            Enumeration en = vLineasCondicion.elements();
          
            while (en.hasMoreElements())
            {
                DTOLineaPromocion dtoLPro = (DTOLineaPromocion)en.nextElement();
                // Modificado por ssantana, 20/10/2005, GCC-PRE-001
                String sTipoOperacionDTO = dtoLPro.getTipoOperacion();
                traza("sTipoOperacionDTO: " + sTipoOperacionDTO);
                if ( !ConstantesPRE.OPERACION_BAJA.equals(sTipoOperacionDTO) ) {
                   recordSet.addRow(new Vector());            
                   recordSet.setValueAt(dtoLPro.getOidLineaPromocion(),i,0);
                   recordSet.setValueAt(dtoLPro.getDescripcionCatalogo(),i,1);
                   if (dtoLPro.getTipoRango()==ConstantesPRE.RANGO_PAGINAS)
                       recordSet.setValueAt(dtoLPro.getValorDesde(),i,2);
                   recordSet.setValueAt(dtoLPro.getValorHasta(),i,3);
                   recordSet.setValueAt(dtoLPro.getDescripcionLineaProducto(),i,4);
                   recordSet.setValueAt(dtoLPro.getCodigoProducto(),i,5);
                   recordSet.setValueAt(dtoLPro.getDescripcionProducto(),i,6);
                   String exclusion = ((dtoLPro.getIndicadorExclusion()!=null)&&(dtoLPro.getIndicadorExclusion().booleanValue()==true))?ConstantesPRE.SI:ConstantesPRE.NO;
                   recordSet.setValueAt(exclusion,i,7);
                   i++;                   
                }
                
                // Modificado por ssantana, 20/10/2005, GCC-PRE-001                
            }
        }else{
            recordSet.setRowCount(0);
        }
        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtoSalida");

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

    private void cargarListaLineasProducto() throws Exception{
        RecordSet recordSet = new RecordSet();
        String listado  =   "listado1";
        int i=0;


        traza("Este es el vector que se va a cargar en la lista");
        vLineasProducto = (Vector)conectorParametroSesion("lineasProducto");        
        
        llenarRecordSetLineaProductos(recordSet);
    
        if (vLineasProducto.size() > 0){
            Enumeration en = vLineasProducto.elements();
            
            while (en.hasMoreElements())
            {
                DTOLineaProducto dtoLP = (DTOLineaProducto)en.nextElement();
                recordSet.addRow(new Vector());
                recordSet.setValueAt(dtoLP.getOidLinea(),i,0);
                recordSet.setValueAt(dtoLP.getCodigo(),i,1);
                recordSet.setValueAt(dtoLP.getDescripcion(),i,2);
                i++;
            }
        }else{
                recordSet.setRowCount(0);
        }

        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                recordSet.getColumnIdentifiers()),"dtoSalida");
        
    }

    private void llenarRecordSetLineaProductos(RecordSet recordSet){
        recordSet.addColumn("OID");
        recordSet.addColumn("CODIGO");
        recordSet.addColumn("DESCR");
    }

    private void cargarListaProductos() throws Exception{
        RecordSet recordSet = new RecordSet();
        String listado  =   "listado2";
        int i=0;
        
        /*......... Recoge de sesión el Vector productosCondicion ........*/
        vProductosCondicion = (Vector)conectorParametroSesion("productosCondicion");
        /*.................. Le agrego las columnas de la tabla ..............*/
        llenarRecordSetProductos(recordSet);
            
        if(vProductosCondicion.size() > 0)
        {
            /*............. Cargo la información del vector en la lista ..........*/
            Enumeration en = vProductosCondicion.elements();
            while (en.hasMoreElements()){
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
        asignar("LISTADOA",listado,UtilidadesBelcorp.generarConector("dtoSalida", recordSet,
                    recordSet.getColumnIdentifiers()),"dtoSalida");
    }

    private void llenarRecordSetProductos(RecordSet recordSet){
        recordSet.addColumn("OID");
        recordSet.addColumn("CODIGO");
        recordSet.addColumn("DESCR");
    }

    private void InicializaControlesFormulario(String sAccion) throws Exception{
        String sOidCatalogo = new String();
        String sOidIndicadorCuadre = new String();
        String sPagD = new String();
        String sPagH = new String();
        String sFactorCuadre = new String();
        String sCheckExcluirPagina = new String();
        Long lOidCatalogo = null;
        
        if (!sAccion.equals("")){            
            traza("++++++++++++++ InicializaControlesFormulario +++++++++++++");
            
            /*................... Devuelvo los valores seteados...............*/
            sOidCatalogo = (String)(conectorParametroSesion("OidCatalogoSesion")==null?"":
                            conectorParametroSesion("OidCatalogoSesion"));
            sOidIndicadorCuadre = (String)(conectorParametroSesion("IndicadorCuadreSesion")==null?"":
                            conectorParametroSesion("IndicadorCuadreSesion"));
            sPagD = (String)(conectorParametroSesion("PaginaDesdeSesion")==null?"":
                            conectorParametroSesion("PaginaDesdeSesion"));
            sPagH = (String)(conectorParametroSesion("PaginaHastaSesion")==null?"":
                            conectorParametroSesion("PaginaHastaSesion"));
            sFactorCuadre = (String)(conectorParametroSesion("FactorCuadreSesion")==null?"":
                            conectorParametroSesion("FactorCuadreSesion"));
            sCheckExcluirPagina = (String)(conectorParametroSesion("CheckExcluirPaginaSesion")==null?"":
                            conectorParametroSesion("CheckExcluirPaginaSesion"));
                            
            /*Guardo los valores en variables ocultas del form*/
            asignarAtributo("VAR","hOidCatalogo","valor", sOidCatalogo);
            asignarAtributo("VAR","hidIndicadorCuadre","valor", sOidIndicadorCuadre);
            asignarAtributo("VAR","hidPaginaDesde","valor", sPagD);
            asignarAtributo("VAR","hidPaginaHasta","valor", sPagH);
            asignarAtributo("VAR","hidFactorCuadre","valor", sFactorCuadre);
            asignarAtributo("VAR","hidcheckExcluirPagina","valor", sCheckExcluirPagina);

            traza("++++++++ Recargando listas... ++++++++");

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
        }
    }
    
    private void guardaDatosPantalla() throws Exception{
        /*......... Guardo en sesión los valores de los controles ...........*/        
        conectorParametroSesion("OidCatalogoSesion", (catalogo!=null)?catalogo.toString():"");
        conectorParametroSesion("IndicadorCuadreSesion",(indCuadre!=null)?indCuadre.toString():"");
        conectorParametroSesion("PaginaDesdeSesion",(valorDesde!=null)?valorDesde:"");
        conectorParametroSesion("PaginaHastaSesion", (valorHasta!=null)?valorHasta:"");
        conectorParametroSesion("FactorCuadreSesion", (factorCuadre!=null)?factorCuadre:"");
        conectorParametroSesion("CheckExcluirPaginaSesion", (sCheckExcluirPaginas!=null)?sCheckExcluirPaginas:"");
    }

    private void renumerarOid(Vector vectorLineaCondicion) throws Exception{

        DTOLineaPromocion elementoVector = new DTOLineaPromocion();

        for (int i=0 ;vectorLineaCondicion.size() > i ;i++)  {
           elementoVector =  (DTOLineaPromocion) vectorLineaCondicion.get(i);
           elementoVector.setOidLineaPromocion(new Long(i));
        }
    
    }

    private boolean inVectorProductos(Vector vector, DTOProducto dto){

        boolean result = false;
        String dtoEntrada = dtoSinOid(dto);
        for (int i=0;i< vector.size();i++)  {
            String dtoProdString = dtoSinOid((DTOProducto)vector.get(i));
            if (dtoProdString.equals(dtoEntrada)){
                result = true;
                break;
            }
        }
        return result;        
    }

    private String dtoSinOid(DTOProducto dto){
        String aString = dto.toString();
        aString = aString.substring(5) ;        
        aString = aString.substring(aString.indexOf('\n')+1);    
        return aString;
    }
}
