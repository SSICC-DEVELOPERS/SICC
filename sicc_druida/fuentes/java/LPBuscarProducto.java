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
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import es.indra.mare.common.exception.MareException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.StringTokenizer;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.util.DTOOID;
import java.math.BigDecimal;

public class LPBuscarProducto extends LPSICCBase{
    private static final String nombreLogica = "LPBuscarProducto";
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


    public LPBuscarProducto(){
        super();
    }

    // Va siempre, se invoca a la pagina involucrada	
    public void inicio() throws Exception{
        setTrazaFichero();
        pagina("contenido_producto_buscar");
        this.getConfiguracionMenu();        
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
            
            String volverLPBuscarProducto = (String)conectorParametroSesion("volverLPBuscarProducto");
            if ("LPDefinirCondicionOferta".equals(volverLPBuscarProducto)){
              oidCatalogo = (String)conectorParametroSesion("oidCatalogoPromo");
              descripcionCatalogo = (String)conectorParametroSesion("descripcionCatalogoPromo");              
            } else {
              oidCatalogo = (String)conectorParametroSesion("oidCatalogo");
              descripcionCatalogo = (String)conectorParametroSesion("descripcionCatalogo");
            }
            
            asignarAtributo("VAR","multiseleccion","valor",String.valueOf(multiseleccion));
            asignarAtributo("VAR","mostrarValoresAdicionales","valor",valoresAdicionales);
            asignarAtributo("VAR","hOidCatalogo","valor",oidCatalogo);
            asignarAtributo("VAR","hDescCatalogo","valor",descripcionCatalogo);
            asignarAtributo("LABELC","lbldtCatalogo","valor",descripcionCatalogo);

            if (accion.equals("")) {
                cargarCombos();
            }else{
                if(accion.equals("buscar")){
                    traza ("accion Buscar");
                    marca = conectorParametroLimpia("varCbMarca","",true);
                    lineaProducto = conectorParametroLimpia("varCbLineaProducto","",true);
                    unidadNegocio = conectorParametroLimpia("varCbUnNegocio","",true);
                    negocio = conectorParametroLimpia("varCbNegocio","",true);
                    generico = conectorParametroLimpia("varCbGenerico","",true);
                    superGenerico = conectorParametroLimpia("varCbSuperGenerico","",true);
                    codSap = conectorParametroLimpia("vartxtCodSAP","",true);
                    descripcion = conectorParametroLimpia("vartxtDescripcion","",true);
                    paginaDesde = conectorParametroLimpia("vartxtPagDesde","",true);
                    paginaHasta = conectorParametroLimpia("vartxtPagHasta","",true);
                    //devolvemos el valor a la pantalla para seleccionar los filtros utilizados
                    asignarAtributo("VAR","varCbMarca","valor",marca);
                    asignarAtributo("VAR","varCbLineaProducto","valor",lineaProducto);
                    asignarAtributo("VAR","varCbNegocio","valor",negocio);
                    asignarAtributo("VAR","varCbGenerico","valor",generico);
                    asignarAtributo("VAR","varCbSuperGenerico","valor",superGenerico);
                    asignarAtributo("VAR","vartxtCodSAP","valor",codSap);
                    asignarAtributo("VAR","vartxtDescripcion","valor",descripcion);
                    asignarAtributo("VAR","vartxtPagDesde","valor",paginaDesde);
                    asignarAtributo("VAR","vartxtPagHasta","valor",paginaHasta);
                }else{
                    if (accion.equals("Aniadir")){ 
                        accionAniadirProducto(); 
                    }
                }
            }
        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPBuscarProducto es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));            
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
        if(conectorParametroSesion("oidAcceso")!=null){
            this.oidAcceso = conectorParametroSesion("oidAcceso").toString();  
        }

        if(conectorParametroSesion("oidSubacceso")!=null){
            this.oidSubacceso = conectorParametroSesion("oidSubacceso").toString();  
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
        long inicioConectar = System.currentTimeMillis();
        DruidaConector conectorCargarCriteriosBusquedaProducto = conectar("ConectorCargarCriteriosBusquedaProductos", paramEntrada);
        DTOSCargarCriteriosBusquedaProductos dtoS = (DTOSCargarCriteriosBusquedaProductos) conectorCargarCriteriosBusquedaProducto.objeto("dtoSalida");
        traza("CONECTAR: "+(System.currentTimeMillis()-inicioConectar));
        conectorParametroSesion("DTOSCargarCriteriosBusquedaProductos",dtoS);

        DTOSCargarCriteriosDefinirOferta ccdo = (DTOSCargarCriteriosDefinirOferta)conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");

        long inicioGeneraConectores = System.currentTimeMillis();
        DruidaConector con = UtilidadesBelcorp.generarConector("dtoSalida.marca_ROWSET", dtoS.getMarcas(), dtoS.getMarcas().getColumnIdentifiers());
        asignar("COMBO", "cbMarca", con, "dtoSalida.marca_ROWSET");

        //con = UtilidadesBelcorp.generarConector("dtoSalida.lineaProducto_ROWSET", dtoS.getLineasProducto(), dtoS.getLineasProducto().getColumnIdentifiers());
        //asignar("COMBO", "cbLineaProducto", con, "dtoSalida.lineaProducto_ROWSET");

         con = UtilidadesBelcorp.generarConector("dtoSalida.uniNegocio_ROWSET", dtoS.getUnidadesNegocio(), dtoS.getUnidadesNegocio().getColumnIdentifiers());
        asignar("COMBO", "cbUniNegocio", con, "dtoSalida.uniNegocio_ROWSET");

        con = UtilidadesBelcorp.generarConector("dtoSalida.negocio_ROWSET", dtoS.getNegocios(), dtoS.getNegocios().getColumnIdentifiers());
        asignar("COMBO", "cbNegocio", con, "dtoSalida.negocio_ROWSET");

        //con = UtilidadesBelcorp.generarConector("dtoSalida.generico_ROWSET", dtoS.getGenericos(), dtoS.getGenericos().getColumnIdentifiers());
        //asignar("COMBO", "cbGenerico", con, "dtoSalida.generico_ROWSET");
		long inicioconectar = System.currentTimeMillis();
        //con = UtilidadesBelcorp.generarConector("dtoSalida.supergenerico_ROWSET", dtoS.getSupergenericos(), dtoS.getSupergenericos().getColumnIdentifiers());
        //asignar("COMBO", "cbSupergenerico", con, "dtoSalida.supergenerico_ROWSET");
        traza("CONECTARUNICO: "+(System.currentTimeMillis()-inicioconectar));
		traza("CONECTAR: "+(System.currentTimeMillis()-inicioGeneraConectores));
		
        asignarAtributo("VAR","oidCabeceraMF","valor",(oidCabeceraMF==null)?"":oidCabeceraMF);
        asignarAtributo("VAR","oidEstrategia","valor",(oidEstrategia==null)?"":oidEstrategia);
        asignarAtributo("VAR","oidAcceso","valor",(oidAcceso==null)?"":oidAcceso);
        asignarAtributo("VAR","oidSubacceso","valor",oidSubacceso==null?"":oidSubacceso);
        asignarAtributo("VAR","oidIdioma","valor",oidIdioma.toString());
        asignarAtributo("VAR","oidPais","valor",oidPais.toString());
        traza("CARGAR COMBOS: "+(System.currentTimeMillis()-inicioCargasCombos));
    } // Fin metodo cargarCombos()

    public void accionAniadirProducto() throws Exception {
        getFormatosValidaciones();
		String mmat = "";
		if (conectorParametro("mmat") != null){
			mmat = conectorParametro("mmat");
		}
		
		traza("Entro en accion AñadirProducto " + mmat);
        String listado2STR = conectorParametro("listado2STR");
        traza("listado2STR " + listado2STR);
        StringTokenizer stRows = new StringTokenizer(listado2STR, "$");
        int rowCount = stRows.countTokens();
        Hashtable productos = new Hashtable();
        for(int cont =  0 ;stRows.hasMoreTokens(); cont++){
            StringTokenizer stCols = new StringTokenizer(stRows.nextToken(), "|");
            DTOProducto prod = new DTOProducto();
			traza("mmat  " + mmat);
            traza("mmat.equalsIgnoreCase(\"true\") " + mmat.equalsIgnoreCase("true"));
            
			if(mmat.equalsIgnoreCase("true")) {
                if (stCols.hasMoreTokens()) { 
					prod.setOid( (Long)getNull(stCols.nextToken(),new Long(0)));
				}
				if (stCols.hasMoreTokens()) {
					prod.setCodigoSAP(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setDescripcionSAP(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) {
            		prod.setPrecioCatalogo(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setPrecioPosicionamiento(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setCosteEstandar(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setAtributo1(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setAtributo2(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setAtributo3(stCols.nextToken());
				}
        		if (stCols.hasMoreTokens()) { 
        			String val = stCols.nextToken();
					prod.setDescripcionCorta(val);
					prod.setTextoBreve(val);
				}
				if (stCols.hasMoreTokens()) { 
        			String val = stCols.nextToken();
					prod.setProgramaFidelizacion((Long)getNull(val, new Long(0)));
				}        
				
			}else{
				if (stCols.hasMoreTokens()) { 
					prod.setCodigoSAP(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setDescripcionSAP(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setPrecioCatalogo(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setPaginaCatalogo((Integer)getNull(stCols.nextToken(), new Integer(0)));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setDescripcionTipoOferta(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setDescripcionCicloVida(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setAtributo1(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setAtributo2(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setAtributo3(stCols.nextToken());
				}
				// campos ocultos 
				if (stCols.hasMoreTokens()) { 
					prod.setPosicionPagina((Integer)getNull(stCols.nextToken(), new Integer(0)));
				}
				if (stCols.hasMoreTokens()) { 
					BigDecimal variable = formatearBigDecimal(new String(stCols.nextToken()));
					if(variable==null){
						variable = new BigDecimal("0");
					}
					prod.setUnidadesEstimadas(new Integer(variable.toString()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setFactorRepeticion((Integer)getNull(stCols.nextToken(), new Integer(0)));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setVentaNetaEstimada(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setPrecioPosicionamiento(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setCosteEstandar(formatearBigDecimal(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setOidCatalogo((Long)getNull(stCols.nextToken(), new Long(0)));
				}
				// CORREGIR QUE NO ESTA BIEN 
				// CAMPO DES_CATA
				if (stCols.hasMoreTokens()) { 
					prod.setDescripcionTipoOferta(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setOidTipoOferta((Long)getNull(stCols.nextToken(), new Long(0)));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setOidCicloVida((Long)getNull(stCols.nextToken(), new Long(0)));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setCentro(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setTextoBreve(stCols.nextToken());
				}
				if (stCols.hasMoreTokens()) { 
					prod.setOid(new Long(stCols.nextToken()));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setOidCondicionPromocion((Long)getNull(stCols.nextToken(), new Long(0)));
				}
				if (stCols.hasMoreTokens()) { 
					prod.setProgramaFidelizacion((Long)getNull(stCols.nextToken(), new Long(0)));
				}        
			}
            productos.put(prod.getOid(), prod);	
        }   
        conectorParametroSesion("Productos", productos);
        traza("Productos " + productos);
        if (valoresAdicionales.equals("true")){
            //venimos de definir oferta, o crear grupo
            conectorAction("LPDatosProducto");
            conectorActionParametro("accion","");
            conectorActionParametro("multiseleccion",String.valueOf(multiseleccion));
        }else{
			traza("Vuelve sin valores Adicionales");

            conectorAction((String)conectorParametroSesion("volverLPBuscarProducto"));
            conectorActionParametro("accion","Producto seleccionado");
        }
		traza("lp de sesion antes de salir"  + (String)conectorParametroSesion("volverLPBuscarProducto"));
    }

    private Object getNull(String val, Object obj){
        if (val.equals(" ")){
            try{traza("Valor ---" + val  + "---") ;}catch(Exception e){}
            return null;
        }else{
            if(obj instanceof Double) return new Double(val);
            if(obj instanceof Long) return new Long(val);
            if(obj instanceof Integer) return new Integer(val);            
            if(obj instanceof Float) return new Float(val);            
        }
        return null;
    }

    private BigDecimal formatearBigDecimal(String val) throws Exception{
        if (val.equals(" ")){
            try{traza("Valor ---" + val  + "---") ;}catch(Exception e){}
            return null;
        }
        traza(val);
        String numeroFormateado = this.desFormatearNumero(val,this.FORMATO_DEFAULT);
        traza(numeroFormateado);
        return new BigDecimal(numeroFormateado);
    }    
    
}
