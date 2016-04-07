import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.pre.DTOEstrategia;
import es.indra.sicc.dtos.pre.DTOProducto;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.util.UtilidadesBelcorp;

import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.xml.XMLDocument;
import java.lang.Exception;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.math.BigDecimal;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOID;
/*inicio enozigli COL-PRE-002*/
import es.indra.sicc.dtos.pre.DTORangoPrecios;
import java.util.StringTokenizer;
import java.lang.reflect.Method;
import es.indra.mare.common.exception.MareException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
/*fin enozigli COL-PRE-002*/

public class LPDatosProducto extends LPSICCBase {

	private static final String nombreLogica  = "LPDatosProducto";
	private Long oid = null;
	private Long pais = null;
	private String accion = "";
	private Hashtable productos = null;

	private long TiempoDeCargaInicio;
	private long TiempoDeCargaFin;    

	/*inicio enozigli COL-PRE-002*/
    private DTORangoPrecios dtoRangoPrecios;
	/*fin enozigli COL-PRE-002*/

// Constructor, siempre igual
	 public LPDatosProducto() {  
		super();
	 }
// Va siempre, se invoca a la pagina involucrada	
    public void inicio() throws Exception {
	   pagina("contenido_datos_producto_insertar");
     this.getFormatosValidaciones();
	}
	
// Va siempre
    public void ejecucion() throws Exception {

        TiempoDeCargaInicio = System.currentTimeMillis();    
        
        try{            
            setTrazaFichero();
            traza("LPDatosProducto.ejecucion");
            getFormatosValidaciones();
            accion = conectorParametro("accion") == null?"":conectorParametro("accion");
            traza("accion: " + accion);

            this.getConfiguracionMenu("LPDatosProducto","");
            asignarAtributo("VAR","multiseleccion","valor",(conectorParametro("multiseleccion")!=null?conectorParametro("multiseleccion"):""));

            if (accion.equals("")) {
                accionVacia();
            } 
            else if (accion.equals("Guardar")) {
                    guardaProductoAnterior();
                    
                    Long key = obtieneKey(); 
                    traza("key: " + key);
                    if (key!=null) {
                        asignarPantalla(key);
                    } else {                    
						  String tipoOperacion = this.conectorParametroLimpia("htipoOperacion","",true);
						  traza("guardar - tipoOperacion: "+ tipoOperacion);
						  if (ConstantesPRE.OPERACION_MODIFICACION.equals(tipoOperacion)){  
								// DTOProducto.tipoOperacion = "modificacion"
								String slpRetorno = this.conectorParametroLimpia("hlpRetorno","",true);
								this.conectorAction(slpRetorno);
								if ("LPModificarOferta".equals(slpRetorno)){
								  this.conectorActionParametro("accion", "Producto modificado");
								} else if ("LPModificarGrupo".equals(slpRetorno)){
								  this.conectorActionParametro("accion", "Producto seleccionado");                          
								} else if ("LPCrearGrupo".equals(slpRetorno)){
								  this.conectorActionParametro("accion", "Modificar producto");
								}
						  } else {
								// Modificado por enozigli, 14/10/2005
								String volverLPBuscarProducto = (String)conectorParametroSesion("volverLPBuscarProducto");
								traza("volverLPBuscarProducto:"+volverLPBuscarProducto);
								conectorAction(volverLPBuscarProducto);
								conectorActionParametro("accion","Producto seleccionado");
						  }
                   }
            }
            //Agregado por gpons, 18/08/2006 (BELC300023949)
            else if (accion.equals("recargaIndicadores")) {
                     asignarPantalla();            
                     recargarIndicadores();
                     
            }//Fin agregado gpons
			/*inicio enozigli COL-PRE-002*/
			 else if (accion.equals("precios")) {
				traza("accion precios");
				pagina("contenido_rangos_precios_ingresar");
	            this.getConfiguracionMenu("LPDatosProductoPerf","rangos");//Solo para obtener la carga de menu
                accionPrecios();
				getFormatosValidaciones();
			} else if (accion.equals("procesar Rangos")) {
				traza("accion procesar Rangos");
                deserializarRangosPrecios();
			}
			/*fin enozigli COL-PRE-002*/

        
        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322
        
        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPDatosProducto es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));          
		
        } catch(Exception ex) {

            traza("exception: " + ex);
            java.io.StringWriter sw = new java.io.StringWriter();
            java.io.PrintWriter pw = new java.io.PrintWriter(sw);
            ex.printStackTrace(pw);
            pw.flush();
            traza("trace:"+sw);
            this.lanzarPaginaError(ex);
        }
  }	

  /*inicio enozigli COL-PRE-002*/
  private void accionPrecios() throws Exception {
		traza("LPDatosProducto.accionPrecios():Entrada");
		/*
		parametros.precioPosicionamiento =dtoOferta.detalleOferta[posicion].precioPosicionamiento;//formatear
			*/
        String sTipoOperacion = this.conectorParametro("tipoOperacion");
        if (sTipoOperacion == null) {
  		  sTipoOperacion = this.conectorParametro("htipoOperacion");
		  if (sTipoOperacion == null || "".equals(sTipoOperacion)) {
	          sTipoOperacion = "";
		  }
        }
		this.asignarAtributo("VAR", "hRangosSerializados", "valor", serializarRangosPrecios());
		traza("LPDatosProducto.accionPrecios():Mitad");
        this.asignarAtributo("VAR", "htipoOperacion", "valor", sTipoOperacion);
		this.asignarAtributo("VAR", "htipoOperacionMODIFICACION", "valor", ConstantesPRE.OPERACION_MODIFICACION);
        this.asignarAtributo("VAR", "casoDeUso", "valor", "modificar");
		traza("LPDatosProducto.accionPrecios():Salida");
  }

  private String serializarRangosPrecios() throws Exception {

		traza("LPDatosProducto.serializarRangosPrecios():Entrada");

		StringBuffer rangosSerializados = new StringBuffer();
		Long oidDetalle = null;
		String precioPos = null;		

		Long lastPageKey = (Long)this.conectorParametroSesion("key");
		this.productos = (Hashtable)this.conectorParametroSesion("Productos");
		DTOProducto prod = (DTOProducto)productos.get(lastPageKey);	

		Vector rangosPrecios = prod.getRangosPrecios();

		if (rangosPrecios!=null&&!rangosPrecios.isEmpty()) {
				for (int i=0;i<rangosPrecios.size();i++) {
						DTORangoPrecios dtoRango = (DTORangoPrecios)rangosPrecios.get(i);
						rangosSerializados.append("oidDetaOferPrec¿"+dtoRango.getOidDetaOferPrec()+"&");
						rangosSerializados.append("oidDetaOfer¿"+dtoRango.getOidDetaOfer()+"&");
						rangosSerializados.append("numeroOrdenRango¿"+dtoRango.getNumeroOrdenRango()+"&");
						rangosSerializados.append("rangoDesde¿"+dtoRango.getRangoDesde()+"&");
						rangosSerializados.append("rangoHasta¿"+dtoRango.getRangoHasta()+"&");
						rangosSerializados.append("precioPosicionamiento¿"+dtoRango.getPrecioPosicionamiento()+"&");
						rangosSerializados.append("precioCatalogo¿"+dtoRango.getPrecioCatalogo()+"&");
						rangosSerializados.append("modificado¿'no'&");
						rangosSerializados.append("tipoOperacion¿"+dtoRango.getTipoOperacion()+"");
						rangosSerializados.append("#");
						if (oidDetalle==null) {
							oidDetalle = dtoRango.getOidDetaOfer();
						}
				}
		}
		if (oidDetalle==null) {
			oidDetalle = new Long(0);
		}
		if (prod.getPrecioPosicionamiento()==null) {
			precioPos = (new Long(0)).toString();
		} else {
			precioPos = prod.getPrecioPosicionamiento().toString();
		}
		this.asignarAtributo("VAR", "hOidDetalle", "valor", oidDetalle.toString());
		this.asignarAtributo("VAR", "hPrecioPosicionamiento", "valor", precioPos);

		traza("LPDatosProducto.serializarRangosPrecios():Salida");
		return rangosSerializados.toString();
  }

   private void deserializarRangosPrecios() throws Exception {

			traza("LPDatosProducto.deserializarRangosPrecios():Entrada");

			Long lastPageKey = (Long)this.conectorParametroSesion("key");
			this.productos = (Hashtable)this.conectorParametroSesion("Productos");
			DTOProducto prod = (DTOProducto)productos.get(lastPageKey);	
			String sRangosPrecios = conectorParametro("hRangosSerializados");   
						   
			//proceso los rangos de Precios del detalle

			StringTokenizer rangosPrecios = new StringTokenizer(sRangosPrecios, "#");

			if (rangosPrecios.hasMoreTokens()) {                   
				prod.setRangosPrecios(new Vector());

				while(rangosPrecios.hasMoreTokens()){
				   StringTokenizer unrangoPreciosEnTokens = new StringTokenizer(rangosPrecios.nextToken(), "&"); 
				   
				   dtoRangoPrecios = new DTORangoPrecios();
				   while (unrangoPreciosEnTokens.hasMoreTokens()) {                               
					   asignarADTO(unrangoPreciosEnTokens.nextToken(), dtoRangoPrecios, "¿");
				   }
				   prod.getRangosPrecios().add(dtoRangoPrecios);
				}                       
			}
			traza("LPDatosProducto.deserializarRangosPrecios():Salida");
   }

  private void asignarADTO(String datos, Object dto, String separator) throws Exception {
      traza("LPDatosProducto.asignarADTO()-Previo:Entrada");
  
      StringTokenizer propValor = new StringTokenizer(datos, separator);
      
      String nombreProperty = propValor.nextToken();
      String valorASetear = propValor.hasMoreTokens()?propValor.nextToken():"";   
      
      asignarADTO(nombreProperty, valorASetear, dto);
      
      traza("LPDatosProducto.asignarADTO()-Previo:Salida");
  }
    
  private void asignarADTO(String nombreProperty, Object valorASetear, Object dto) throws Exception {      
      traza("LPDatosProducto.asignarADTO():Entrada");
      
      if ((valorASetear!=null)&&(!valorASetear.equals(""))) {
          Method metodo = obtenerMetodo(nombreProperty, dto);
          
          if (metodo!=null) {
              try {
              
                Class claseDelParametro = metodo.getParameterTypes()[0];
                traza("Clase del parametro:"+claseDelParametro.getName());
                if(claseDelParametro.isPrimitive()&&("char".equals(claseDelParametro.getName()))) {
                  traza("El tipo es primitivo char");   
                  Object[] args = {new Character(valorASetear.toString().charAt(0))};
                  Object res = metodo.invoke(dto,args);   
                } else {                  
                  Class[] paramParamType = {valorASetear.getClass()};
                  Object[] paramsParam = {valorASetear};
                  Object param = claseDelParametro.getConstructor(paramParamType).newInstance(paramsParam);                  
                  Object[] args = {param};               
                  Object res = metodo.invoke(dto,args);
                }
              } catch (Exception e) {
                traza("Pincho la asignacion del parametro "+ nombreProperty +" en "+ dto.getClass().getName() +", con el valor "+valorASetear);
                logStackTrace(e);
              }
          } else {
              traza("No se encontro el setter correspondiente a "+ nombreProperty +" en "+ dto.getClass().getName() +", puede que no exista.");
          }
      }
      traza("LPDatosProducto.asignarADTO():Salida");        
  }

  private Method obtenerMetodo(String nombreProp, Object dto) throws Exception {
  
        traza("LPDatosProducto.obtenerMetodo()");
        String primerLetra = nombreProp.substring(0, 1).toUpperCase();
        String restoNombre = nombreProp.substring(1);
        String methodName = "set" + primerLetra + restoNombre;
        
        Class clsDTO = dto.getClass();
        
        Method[] metodos = clsDTO.getMethods();
        
        int i=0;
        int cant = metodos.length;
       
        while (i<cant) {
            if (methodName.equals(metodos[i].getName())) {
              return metodos[i];
            }
            i++;
        }        
        return null;
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
	/*fin enozigli COL-PRE-002*/
  
  private void accionVacia() throws Exception {
		this.productos = (Hashtable)this.conectorParametroSesion("Productos");		
		Hashtable productosClone = (Hashtable)productos.clone();
		this.conectorParametroSesion("ProductosCloned", productosClone);	
		asignarPantalla(obtieneKey());
  }

  private Long obtieneKey() throws Exception {
      Hashtable hash = (Hashtable) this.conectorParametroSesion("ProductosCloned");
                    
      Enumeration keys = hash.keys();
			Long key = null;
      while (keys.hasMoreElements()){
          key = (Long)keys.nextElement();
      }
      if (key!=null){
        hash.remove(key);
      }
      if (key==null){
          this.getRequest().getSession().removeAttribute("ProductosCloned");
          this.getRequest().getSession().removeAttribute("key");
          return null;
      }
      this.conectorParametroSesion("ProductosCloned", hash);										
	  this.conectorParametroSesion("key",key);
      UtilidadesLog.debug("key:"+key);
      return key;
  }

  private void asignarPantalla(Long key) throws Exception {

		DTOSCargarCriteriosBusquedaProductos ccbp = (es.indra.sicc.dtos.pre.DTOSCargarCriteriosBusquedaProductos)this.conectorParametroSesion("DTOSCargarCriteriosBusquedaProductos");
		DTOSCargarCriteriosDefinirOferta ccdo = (es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta)this.conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
		DTOProducto prod = ((DTOProducto)productos.get(key));
        String multiseleccion = conectorParametro("multiseleccion");
        // Agregado por ssantana, 11/10/2005, GCC-PRE-001
        String sTipoOperacion = this.conectorParametro("tipoOperacion");
        if (sTipoOperacion == null) {
  		  sTipoOperacion = this.conectorParametro("htipoOperacion");
		  if (sTipoOperacion == null || "".equals(sTipoOperacion)) {
	          sTipoOperacion = "";
		  }
        }
        // Agregado por SICC20070316 - Rafael Romero - 20/07/2007
        else{
            if(sTipoOperacion.equals("consulta")){
                this.asignarAtributoPagina("cod","01073");
                this.asignarAtributo("CTEXTO","txtFactorRepeticion","req","N");
                this.asignarAtributo("COMBO", "cbTipoOferta","req","N");
                this.asignarAtributo("COMBO", "cbCicloVida","req","N");
            }
        }
        // Fin agregado por SICC20070316
        
        this.asignarAtributo("VAR", "htipoOperacion", "valor", sTipoOperacion);
        String slpRetorno = this.conectorParametro("lpRetorno");
        if (slpRetorno==null){ slpRetorno = ""; }
        this.asignarAtributo("VAR", "hlpRetorno", "valor", slpRetorno);

        String sPrecioPosic = "";
        String sCosteEstandar = "";
                
        String sCentro = prod.getCentro();
        if (sCentro == null ) { 
          sCentro = "";
        }
        traza("sCentro:"+sCentro);
        
        BigDecimal bigPrecioPosic = prod.getPrecioPosicionamiento();
        BigDecimal bigCosteEstandar = prod.getCosteEstandar();
        
        // Formatea los números, para presentar en la pantalla. 
        sPrecioPosic = "";
        if ( bigPrecioPosic != null) {
          sPrecioPosic = UtilidadesBelcorp.formateaNumeroSICC(bigPrecioPosic.toString(),
                                                              LPSICCBase.FORMATO_MONEDA,
                                                              this);
        }
        
        sCosteEstandar = ""; 
        if ( bigCosteEstandar != null )  {
          sCosteEstandar = UtilidadesBelcorp.formateaNumeroSICC(bigCosteEstandar.toString(),
                                                                LPSICCBase.FORMATO_MONEDA,
                                                                this);
        }
        
        String descripcionCatalogo = (String)conectorParametroSesion("descripcionCatalogo"); 
        
        this.asignarAtributo("CTEXTO", "txtCatalogo", "valor", descripcionCatalogo);
        
        this.asignarAtributo("CTEXTO", "txtPrecioPos", "valor", sPrecioPosic);
        this.asignarAtributo("CTEXTO", "txtCosteEstandar", "valor", sCosteEstandar);
        this.asignarAtributo("CTEXTO", "txtCentro", "valor", sCentro);
       
        if (!ConstantesPRE.OPERACION_MODIFICACION.equals(sTipoOperacion) ) {
           // Deshabilita los campos precioPosicionamiento, costeEstandar
           // y centro.
           this.asignarAtributo("VAR", "hidDeshabilitarTrioCampos", "valor", "true");
        } else {
           // Habilita los campos precioPosicionamiento, costeEstandar
           // y centro.
           this.asignarAtributo("VAR", "hidDeshabilitarTrioCampos", "valor", "false");
        }
        // Fin agregado por ssantana, 11/10/2005, GCC-PRE-001
        
				traza("DTOSCargarCriteriosBusquedaProductos : " + ccbp);
				traza("DTOSCargarCriteriosDefinirOferta : " + ccdo);
				traza("DTOProducto : " + prod );
				//this.asignarAtributo("VAR","oid","valor",key.toString());	
				this.asignarAtributo("VAR","codSAP","valor",prod.getCodigoSAP());	
				this.asignarAtributo("CTEXTO","txtCodProducto","valor",prod.getCodigoSAP());	
				
        		//traza(prod);
				String txtTextoBreve = prod.getTextoBreve();
				traza("txtTextoBreve" + txtTextoBreve);
				if(txtTextoBreve != null ){
					asignarAtributo("CTEXTO","txtTextoBreve","valor",txtTextoBreve);
				}
				

				String descSAP = prod.getDescripcionSAP();
				traza("DescripcionSAP:" + descSAP);
				if(descSAP != null){
					asignarAtributo("VAR","descSap","valor",descSAP);	
				}

				int a = 0;
				
				Integer unidEst = prod.getUnidadesEstimadas();
				if (unidEst != null){
					asignarAtributo("CTEXTO","txtUniEstimadas","valor",unidEst.toString());	
				}
				
				Integer factRep = prod.getFactorRepeticion();
				if (factRep != null){
					asignarAtributo("CTEXTO","txtFactorRepeticion","valor",factRep.toString());	
				}
				
        traza("3");
				RecordSet comisionable = ccdo.getTiposOferta();
				if(comisionable != null){
					if (comisionable.getValueAt(0,"IND_COMI")!=null){
						asignarAtributo("LABELC","lblComisionableX","valor",comisionable.getValueAt(0,"IND_COMI").toString());	
						asignarAtributo("VAR","comis","valor",comisionable.getValueAt(0,"IND_COMI").toString());	
					}
				}	
				
        traza("4");
				RecordSet puntaje = ccdo.getTiposOferta();
				if(puntaje != null){
					if (puntaje.getValueAt(0,"IND_PUNT")!=null){
						asignarAtributo("LABELC","lblPuntajeX","valor",puntaje.getValueAt(0,"IND_PUNT").toString());	
						asignarAtributo("VAR","punta","valor",puntaje.getValueAt(0,"IND_PUNT").toString());	
					}
				}

        traza("5");
				RecordSet estadisticable = ccdo.getTiposOferta();
				if(estadisticable != null){
					if (estadisticable.getValueAt(0,"IND_ESTA")!=null){
						asignarAtributo("LABELC","lblEstadisticableX","valor",estadisticable.getValueAt(0,"IND_ESTA").toString());	
   						asignarAtributo("VAR","estad","valor",estadisticable.getValueAt(0,"IND_ESTA").toString());	
					}
				}

        traza("6");
				RecordSet montoMinimo = ccdo.getTiposOferta();
				if(montoMinimo != null){
					if (montoMinimo.getValueAt(0,"IND_MONT_MINI")!=null){
						asignarAtributo("LABELC","lblMontoMinimoX","valor",montoMinimo.getValueAt(0,"IND_MONT_MINI").toString());	
   						asignarAtributo("VAR","mmini","valor",montoMinimo.getValueAt(0,"IND_MONT_MINI").toString());	
					}
				}
		
        traza("7");
				RecordSet aportaMontoEscala = ccdo.getTiposOferta();
				if(aportaMontoEscala != null){
					if (aportaMontoEscala.getValueAt(0,"IND_APOR_MONT_ESCA")!=null){
						asignarAtributo("LABELC","lblAportaMontoX","valor",aportaMontoEscala.getValueAt(0,"IND_APOR_MONT_ESCA").toString());	
  						asignarAtributo("VAR","amesc","valor",aportaMontoEscala.getValueAt(0,"IND_APOR_MONT_ESCA").toString());	
					}
				}
		
        traza("8");
				BigDecimal precioCatalogo = prod.getPrecioCatalogo();
        traza("El precio Catalogo en BidDecimal es: "+precioCatalogo);
				if(precioCatalogo != null){
					asignarAtributo("CTEXTO","txtPrecioCat","valor",(precioCatalogo==null?"":
                          UtilidadesBelcorp.formateaNumeroSICC(precioCatalogo.toString(),
                          this.FORMATO_DEFAULT , this)));	
				} 

		    traza("9");
        traza("10");
  			BigDecimal costeEstandard = prod.getCosteEstandar();
				if(costeEstandard != null){
					asignarAtributo("LABELC","lblCosteEstandarX","valor",(costeEstandard==null?"":
                          UtilidadesBelcorp.formateaNumeroSICC(costeEstandard.toString(),
                          this.FORMATO_DEFAULT , this)));							
				}
        traza("11");
				Integer unidEstimadas = prod.getUnidadesEstimadas();
				if(unidEstimadas != null){
					//CUV-31
					asignarAtributo("CTEXTO","txtUniEstimadas2","valor", (unidEstimadas==null?"":
                          UtilidadesBelcorp.formateaNumeroSICC(unidEstimadas.toString(),
                          this.FORMATO_DEFAULT , this)));
				}				
        traza("12");
				BigDecimal ventaEstimada = prod.getVentaNetaEstimada();
				if(ventaEstimada != null){
					asignarAtributo("CTEXTO","txtVentaNetaEstimada","valor",(ventaEstimada==null?"":
                          UtilidadesBelcorp.formateaNumeroSICC(ventaEstimada.toString(),
                          this.FORMATO_DEFAULT , this)));	
				}
	
        traza("13");
				Integer numPagina = prod.getPaginaCatalogo();
				if (numPagina != null){
					asignarAtributo("CTEXTO","txtNPagCatalogo","valor",numPagina.toString());	
				}
		
        traza("14");
				Integer posicion = prod.getPosicionPagina();
				if(posicion != null){
					asignarAtributo("CTEXTO","txtPosPagina","valor",posicion.toString());	
				}
        traza("15");
				RecordSet condPromRS = ccdo.getCondiciones();
				if(condPromRS != null){
					Vector colID = condPromRS.getColumnIdentifiers();
					DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.condiciones_ROWSET", condPromRS, colID);
					asignar("COMBO", "cbCondicionPromo", dtipo, "DTOSalida.condiciones_ROWSET");
				}
	
        traza("16");
				RecordSet tipoOfertaRS = ccdo.getTiposOferta();
				if(tipoOfertaRS != null){
					Vector colID = tipoOfertaRS.getColumnIdentifiers();
					DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.tiposOferta_ROWSET", tipoOfertaRS, colID);
					asignar("COMBO", "cbTipoOferta", dtipo, "DTOSalida.tiposOferta_ROWSET");
				}
	
        traza("17");
				DTOEstrategia digitable = ccdo.getEstrategia();
				if((multiseleccion!=null)&&
				   (multiseleccion.equals("true"))&&
				   ((new Integer(ccdo.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA)){
					asignarAtributo("VAR","enabledigitable","valor","false");
					asignarAtributo("VAR","digitable","valor","N");
				} else { 
				  if(digitable != null && digitable.getCvDigitable() != null) {
					asignarAtributo("VAR","digitable","valor", (digitable.getCvDigitable().booleanValue() == true)?"S":"N");	
				  }else{
					asignarAtributo("VAR","digitable","valor","N");
				  }
				  if(digitable.getModificableDigitable()!=null&&digitable.getModificableDigitable().booleanValue()==true){
					asignarAtributo("VAR","enabledigitable","valor","true");
				  } else {
					asignarAtributo("VAR","enabledigitable","valor","false");
				  }
				}
		traza("18");

				DTOEstrategia imprimible = ccdo.getEstrategia();
				if((multiseleccion!=null)&&
				   (multiseleccion.equals("true"))&&
				   ((new Integer(ccdo.getTipoEstrategia().getCodigoTipoEstrategia())).intValue() == ConstantesPRE.COMPUESTA_FIJA)){
					asignarAtributo("VAR","enableimprimible","valor","false");
					asignarAtributo("VAR","imprimible","valor","N");        
				} else {
				  if(imprimible != null && imprimible.getCvImprimible() != null ) {
					asignarAtributo("VAR","imprimible","valor",(imprimible.getCvImprimible().booleanValue() == true)?"S":"N");
				  }else{
					asignarAtributo("VAR","imprimible","valor","N");
				  }
				  if(imprimible.getModificableImprimible()!=null&&imprimible.getModificableImprimible().booleanValue()==true){
					asignarAtributo("VAR","enableimprimible","valor","true");
				  } else{
					asignarAtributo("VAR","enableimprimible","valor","false");
				  }
				}
				
				if (slpRetorno.equals("LPModificarOferta")||slpRetorno.equals("LPModificarGrupo")){
					asignarAtributo("VAR","digitable","valor",Boolean.TRUE.equals(prod.getDigitable())?"S":"N");
					asignarAtributo("VAR","imprimible","valor",Boolean.TRUE.equals(prod.getImprimible())?"S":"N"); 
				}
				
		traza("19");
				String centro = prod.getCentro();
				if(centro != null){
					asignarAtributo("LABELC","lblCentroX","valor",centro);		
				}
	
				traza("20");
				RecordSet cicloVidaRS = ccdo.getCiclosVida();
				if(cicloVidaRS != null){
					Vector colID = cicloVidaRS.getColumnIdentifiers();
					DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida", cicloVidaRS, colID);
					traza("dtipo: " + dtipo );					
					asignar("COMBO", "cbCicloVida", dtipo, "DTOSalida");		
				}
			   /*
				* agregado por enozigli, 25/10/2005 - Cambio Club Priviledges
				*/                       


				//Club Priviledges
				traza("Club Priviledges");
				RecordSet programaFidelRS = ccdo.getProgramaFidelizacion();
				
				RecordSet programaFidelRS2 = new RecordSet();
				programaFidelRS2.addColumn("OID_PROG_FIDE");
				programaFidelRS2.addColumn("DES_PROG_FIDE");
				
				for (int i=0; i<programaFidelRS.getRowCount();i++){
				  Object[] rowFidel = {programaFidelRS.getValueAt(i,0),programaFidelRS.getValueAt(i,1)};
				  traza("oid pr.fidel"+programaFidelRS.getValueAt(i,0));
				  traza("des pr.fidel"+programaFidelRS.getValueAt(i,1));
				  programaFidelRS2.addRow(rowFidel);
				}

				if(programaFidelRS2 != null){
					Vector colID = programaFidelRS2.getColumnIdentifiers();
					DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.programaFidelizacion_ROWSET", programaFidelRS2, colID);
					asignar("COMBO", "cbProgramaFidelizacion", dtipo, "DTOSalida.programaFidelizacion_ROWSET");
				}
        
				RecordSet variantesRS = ccdo.getVariantes();
				if(variantesRS != null){
					Vector colID = variantesRS.getColumnIdentifiers();
					DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.variantes_ROWSET", variantesRS, colID);
					asignar("COMBO", "cbVariante", dtipo, "DTOSalida.variantes_ROWSET");
				}
        
				Integer puntoFijo = prod.getPuntajeFijo();
		        traza("El punto fijo es: "+puntoFijo);
				if(puntoFijo != null){
					asignarAtributo("CTEXTO","txtPuntoFijo","valor",(puntoFijo==null?"":
                          UtilidadesBelcorp.formateaNumeroSICC(puntoFijo.toString(),
                          this.FORMATO_DEFAULT , this)));	
				}         

				DruidaConector convariantes = generaConector(variantesRS, "dtoSalida",
											  "OID_VARI", "DES_VARI", "IND_PUNT");
				asignar("COMBO", "lstVariantes", convariantes, "dtoSalida");

				traza("fin carga Club Priviledges");       
			   /*
				* fin agregado por enozigli, 25/10/2005 - Cambio Club Priviledges
				*/               
				this.setearCOMBOS(prod,sTipoOperacion);
	}

	private void guardaProductoAnterior() throws Exception {

	    traza("LPDatosProducto.guardaProductoAnterior():Entrada");
		Long lastPageKey = (Long)this.conectorParametroSesion("key");
		this.productos = (Hashtable)this.conectorParametroSesion("Productos");
		// Guardo la key en sesion ya que la pagina posterior la toma para modificar el dto
		DTOProducto prod = (DTOProducto)productos.get(lastPageKey);
						
		String codSAP = conectorParametro("codSAP");
		if (codSAP != null && !(codSAP.equals(""))) {
		prod.setCodigoSAP(codSAP);
		}

		traza("codSAP"+codSAP);

		String txtTextoBreve = conectorParametro("txtTextoBreve");
		traza(txtTextoBreve);
		if (txtTextoBreve != null && !(txtTextoBreve.equals(""))) {
		prod.setTextoBreve(txtTextoBreve);
		}

		String txtPrecioCat = conectorParametroNumero("txtPrecioCat",this.FORMATO_DEFAULT);
		if (txtPrecioCat != null && !(txtPrecioCat.equals(""))) {
		prod.setPrecioCatalogo(new BigDecimal(txtPrecioCat));
		}

		String txtNPagCatalogo = conectorParametro("txtNPagCatalogo");
		if (txtNPagCatalogo != null && !(txtNPagCatalogo.equals(""))) {
		prod.setPaginaCatalogo(new Integer(txtNPagCatalogo));
		}

		String tipoOfertaDesc = conectorParametro("cbTipoOfertaDesc");
		if (tipoOfertaDesc != null && !(tipoOfertaDesc.equals(""))) {
		prod.setDescripcionTipoOferta(tipoOfertaDesc);
		}

		String cbCicloVidaDesc  = conectorParametro("cbCicloVidaDesc");
		if (cbCicloVidaDesc != null && !(cbCicloVidaDesc.equals(""))) {
		prod.setDescripcionCicloVida(cbCicloVidaDesc);
		}

		traza("cbCicloVidaDesc"+cbCicloVidaDesc);

		// campos ocultos 
		// 9
		String txtPosPagina = conectorParametro("txtPosPagina");
		if (txtPosPagina != null && !(txtPosPagina.equals(""))) {
		prod.setPosicionPagina(new Integer(txtPosPagina));
		}
		// 10
		String txtUniEstimadas2  = conectorParametroNumero("txtUniEstimadas2",this.FORMATO_DEFAULT);//CUV-31-3
		if (txtUniEstimadas2 != null && !(txtUniEstimadas2.equals(""))) {
		prod.setUnidadesEstimadas(new Integer(txtUniEstimadas2));
		}
		// 11
		String txtFactorRepeticion = conectorParametro("txtFactorRepeticion");
		if (txtFactorRepeticion != null && !(txtFactorRepeticion.equals(""))) {
		prod.setFactorRepeticion(new Integer(txtFactorRepeticion));
		}
		// 12
		String txtVentaNetaEstimada  = conectorParametroNumero("txtVentaNetaEstimada",this.FORMATO_DEFAULT);
		if (txtVentaNetaEstimada != null && !(txtVentaNetaEstimada.equals(""))) {
		prod.setVentaNetaEstimada(new BigDecimal(txtVentaNetaEstimada));
		}

		String oidCatalogo = (String)conectorParametroSesion("oidCatalogo");
		if (oidCatalogo != null && !(oidCatalogo.equals(""))) {
		prod.setOidCatalogo(new Long(oidCatalogo));
		}
		// 16
		String cbCondicionPromo = conectorParametro("cbCondicionPromo");
		if (cbCondicionPromo != null && !(cbCondicionPromo.equals(""))) {
		prod.setOidCondicionPromocion(new Long(cbCondicionPromo));
		}
		// 17
		String tipoOferta = conectorParametro("cbTipoOferta");
		if (tipoOferta != null && !(tipoOferta.equals(""))) {
		prod.setOidTipoOferta(new Long(tipoOferta));
		}
		// 18
		String cbCicloVida = conectorParametro("cbCicloVida");
		if (cbCicloVida != null && !(cbCicloVida.equals(""))) {
		prod.setOidCicloVida(new Long(cbCicloVida));
		}
		// 19
		String rbDigitable = conectorParametro("ckDigitable");
		if (rbDigitable != null && !(rbDigitable.equals(""))) {
		prod.setDigitable((rbDigitable.equals("S"))?new Boolean(true):new Boolean(false));
		}

		String rbImprimible = conectorParametro("ckImprimible");
		if (rbImprimible != null && !(rbImprimible.equals(""))) {
		prod.setImprimible((rbImprimible.equals("S"))?new Boolean(true):new Boolean(false));
		}

		traza("rbImprimible"+rbImprimible);

		/*
		* Agregado por ssantana, 5/10/2005 - Cambio GCC-PRE-001
		* Si alguno de los sig. campos está habilitado (modificable)
		* entonces toma su valor para actualizar el DTO. 
		*/
		String precioPosicionamientoDisabled = 
						  this.conectorParametro("precioPosicionamientoDisabled");
		String costeEstandarDisabled = 
						  this.conectorParametro("costeEstandarDisabled");
		String centroDisabled = this.conectorParametro("centroDisabled");

		traza("precioPosicionamientoDisabled"+precioPosicionamientoDisabled);
		traza("costeEstandarDisabled"+costeEstandarDisabled);
		traza("centroDisabled"+centroDisabled);

		if ( precioPosicionamientoDisabled.equals("false")) {
		 String precioPosicionamiento = 
						this.conectorParametroNumero("txtPrecioPos", this.FORMATO_MONEDA);
		 BigDecimal bigPrecioPos = null;
		 if ( !precioPosicionamiento.equals("") ) {
		   bigPrecioPos = new BigDecimal(precioPosicionamiento);
		 }
		 prod.setPrecioPosicionamiento(bigPrecioPos);
		}      

		if ( costeEstandarDisabled.equals("false")) {
		 String costeEstandar = 
					this.conectorParametroNumero("txtCosteEstandar", this.FORMATO_MONEDA);
		 BigDecimal bigCosteEstandar = null;
		 if ( !costeEstandar.equals("") ) {
		   bigCosteEstandar = new BigDecimal(costeEstandar);
		 }
		 prod.setCosteEstandar(bigCosteEstandar);
		}

		traza("costeEstandarDisabled"+costeEstandarDisabled);

		if ( centroDisabled.equals("false")) {
		 String centro = this.conectorParametroLimpia("txtCentro", "", true);
		 prod.setCentro(centro);
		}
		/*
		* Fin agregado por ssantana, 5/10/2005 - Cambio GCC-PRE-001
		*/     

		/*
		* agregado por enozigli, 25/10/2005 - Cambio Club Priviledges
		*/               
		String sprogramaFidel = this.conectorParametroLimpia("cbProgramaFidelizacion","",true);
		traza("programaFidel"+sprogramaFidel);
		Long programaFidel = null;
		try{ programaFidel = Long.valueOf(sprogramaFidel);} catch (NumberFormatException ne){}
		prod.setProgramaFidelizacion(programaFidel);

		String svariante = this.conectorParametroLimpia("cbVariante","",true);
		traza("variante"+svariante);
		Long variante = null;
		try{ variante = Long.valueOf(svariante);} catch (NumberFormatException ne){}
		prod.setVariantes(variante);

		String spuntoFijo = this.conectorParametroLimpia("txtPuntoFijo","",true);
		traza("puntoFijo"+spuntoFijo);
		Integer puntoFijo = null;
		try{ puntoFijo = Integer.valueOf(spuntoFijo);} catch (NumberFormatException ne){}
		prod.setPuntajeFijo(puntoFijo);     
		/*
		* Fin agregado por enozigli, 25/10/2005 - Cambio Club Priviledges
		*/      

		//productos.put(prod.getOid(), prod);	
		traza("producto en sesion: "+productos);
		this.conectorParametroSesion("Productos",productos);
  }

	private void setearCOMBOS(DTOProducto prod, String tipoOperacion) throws Exception{
		//traza("prod.getOidTipoOferta().toString() "  + prod.getOidTipoOferta());
		if(prod.getOidTipoOferta() != null){
			this.asignarAtributo("VAR","ocbTipoOferta","valor",prod.getOidTipoOferta().toString());
		}
		if(prod.getOidCondicionPromocion() != null){
			traza("CONDICION PROCMOCION A ASIGNAR: "+prod.getOidCondicionPromocion());
			this.asignarAtributo("VAR","ocbCondicionPromo","valor",prod.getOidCondicionPromocion().toString());
		}
		if(prod.getOidCicloVida() != null){
			this.asignarAtributo("VAR","ocbCicloVida","valor",prod.getOidCicloVida().toString());
		}

		/*
		 * Agregado por enozigli, 03/07/2006, SICC-DECU-PRE-201-372b.doc
		 */
		traza("asignarPantalla - obtieneProgFideProd");
		DTOOID parProd = new DTOOID();
		parProd.setOid(prod.getOid());
		MareBusinessID bid = new MareBusinessID("PREObtenerProgFide");
		Vector vec = new Vector();
		vec.add(parProd);
		vec.add(bid);
		DTOOID dtoProgFideMaeProd = (DTOOID) conectar("ConectorObtenerProgFide", vec).objeto("dtoSalida");
		traza("asignarPantalla - obtieneProgFideProd - Fin");
		String progFide = "";
		if (dtoProgFideMaeProd.getOid()!=null) {
			this.asignarAtributo("VAR","hFideHabilita","valor","S");
			progFide = dtoProgFideMaeProd.getOid().toString();
		} else {
			this.asignarAtributo("VAR","hFideHabilita","valor","N");
		}
		/*
		 * Agregado por enozigli, 03/07/2006, SICC-DECU-PRE-201-372b.doc
		 */

		traza("prod.getProgramaFidelizacion():"+prod.getProgramaFidelizacion());
		traza("MAD el prg fide es " + progFide);
		traza("MAD ConstantesPRE.OPERACION_MODIFICACION " + ConstantesPRE.OPERACION_MODIFICACION);
		traza("MAD tipoOperacion " + tipoOperacion);

		if(prod.getProgramaFidelizacion() != null){
			if (ConstantesPRE.OPERACION_MODIFICACION.equals(tipoOperacion)){  
				traza("MAD Entro en el if");
				this.asignarAtributo("VAR","ocbProgramaFidelizacion","valor",prod.getProgramaFidelizacion().toString());
			} else {
				traza("MAD Entro en el else");
				this.asignarAtributo("VAR","ocbProgramaFidelizacion","valor",progFide);
			}
		}else{
		   this.asignarAtributo("VAR","ocbProgramaFidelizacion","valor",progFide);		
		}
			
		traza("prod.getVariantes():"+prod.getVariantes());
		if(prod.getVariantes() != null){
			if (ConstantesPRE.OPERACION_MODIFICACION.equals(tipoOperacion)){  
				this.asignarAtributo("VAR","ocbVariante","valor",prod.getVariantes().toString());
			} else {
				if (dtoProgFideMaeProd.getOid()!=null) {
				    this.asignarAtributo("VAR","ocbVariante","valor","2");
				}
			}
		} else {
			if (ConstantesPRE.OPERACION_MODIFICACION.equals(tipoOperacion)){  			
			} else {
				if (dtoProgFideMaeProd.getOid()!=null) {
				    this.asignarAtributo("VAR","ocbVariante","valor","2");
				}
			}
		}

	}
    
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
    
    /**
     * Autor: Gpons
     * Fecha: 17/08/2006
     * Descripcion: Recarga los ndicadores Comisionable, Puntaje, 
     * Estadisticable, Monto mínimo, Aporta monto escala, para el tipo de oferta 
     * 
     * Incidencia BELC300023949
     */
    private void recargarIndicadores () throws Exception {
        traza("Entrada: LPDatosProducto-recargarIndicadores ");
    
        DTOSCargarCriteriosDefinirOferta ccdo = (es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta)this.conectorParametroSesion("DTOSCargarCriteriosDefinirOferta");
        RecordSet tipoOfertaRS = ccdo.getTiposOferta();

        if(tipoOfertaRS != null){
            Vector colID = tipoOfertaRS.getColumnIdentifiers();
            DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.tiposOferta_ROWSET", tipoOfertaRS, colID);
            asignar("COMBO", "cbTipoOferta", dtipo, "DTOSalida.tiposOferta_ROWSET");

            String cmbTipoOferta = conectorParametroLimpia("cbTipoOferta","",true);

            if (cmbTipoOferta != null && !(cmbTipoOferta.equals(""))) {

                for (int i = 0; i < tipoOfertaRS.getRowCount(); i++) {

                    if (cmbTipoOferta.equals(tipoOfertaRS.getValueAt(i,"OID_TIPO_OFER").toString().trim())) {
                        if (tipoOfertaRS.getValueAt(i,"IND_COMI")!=null){
                            asignarAtributo("LABELC","lblComisionableX","valor",tipoOfertaRS.getValueAt(i,"IND_COMI").toString());	
                            asignarAtributo("VAR","comis","valor",tipoOfertaRS.getValueAt(i,"IND_COMI").toString());	
                        }
    
                        if (tipoOfertaRS.getValueAt(i,"IND_PUNT")!=null){
                            asignarAtributo("LABELC","lblPuntajeX","valor",tipoOfertaRS.getValueAt(i,"IND_PUNT").toString());	
                            asignarAtributo("VAR","punta","valor",tipoOfertaRS.getValueAt(i,"IND_PUNT").toString());	
                        }
    
                        if (tipoOfertaRS.getValueAt(i,"IND_ESTA")!=null){
                            asignarAtributo("LABELC","lblEstadisticableX","valor",tipoOfertaRS.getValueAt(i,"IND_ESTA").toString());	
                            asignarAtributo("VAR","estad","valor",tipoOfertaRS.getValueAt(i,"IND_ESTA").toString());	
                        }
                        
                        if (tipoOfertaRS.getValueAt(i,"IND_MONT_MINI")!=null){
                            asignarAtributo("LABELC","lblMontoMinimoX","valor",tipoOfertaRS.getValueAt(i,"IND_MONT_MINI").toString());	
                            asignarAtributo("VAR","mmini","valor",tipoOfertaRS.getValueAt(i,"IND_MONT_MINI").toString());	
                        }
                        
                        if (tipoOfertaRS.getValueAt(i,"IND_APOR_MONT_ESCA")!=null){
                            asignarAtributo("LABELC","lblAportaMontoX","valor",tipoOfertaRS.getValueAt(i,"IND_APOR_MONT_ESCA").toString());	
                            asignarAtributo("VAR","amesc","valor",tipoOfertaRS.getValueAt(i,"IND_APOR_MONT_ESCA").toString());	
                        }
                    }
                }
            }
        }
        
        RecordSet condPromRS = ccdo.getCondiciones();
        if(condPromRS != null){
            Vector colID = condPromRS.getColumnIdentifiers();
            DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.condiciones_ROWSET", condPromRS, colID);
            asignar("COMBO", "cbCondicionPromo", dtipo, "DTOSalida.condiciones_ROWSET");
        }
        
        
        RecordSet cicloVidaRS = ccdo.getCiclosVida();
        if(cicloVidaRS != null){
            Vector colID = cicloVidaRS.getColumnIdentifiers();
            DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida", cicloVidaRS, colID);
            traza("dtipo: " + dtipo );					
            asignar("COMBO", "cbCicloVida", dtipo, "DTOSalida");		
        }

        RecordSet programaFidelRS = ccdo.getProgramaFidelizacion();
        RecordSet programaFidelRS2 = new RecordSet();
        programaFidelRS2.addColumn("OID_PROG_FIDE");
        programaFidelRS2.addColumn("DES_PROG_FIDE");
        
        for (int i=0; i<programaFidelRS.getRowCount();i++){
          Object[] rowFidel = {programaFidelRS.getValueAt(i,0),programaFidelRS.getValueAt(i,1)};
          traza("oid pr.fidel"+programaFidelRS.getValueAt(i,0));
          traza("des pr.fidel"+programaFidelRS.getValueAt(i,1));
          programaFidelRS2.addRow(rowFidel);
        }

        if(programaFidelRS2 != null){
            Vector colID = programaFidelRS2.getColumnIdentifiers();
            DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.programaFidelizacion_ROWSET", programaFidelRS2, colID);
            asignar("COMBO", "cbProgramaFidelizacion", dtipo, "DTOSalida.programaFidelizacion_ROWSET");
        }

        RecordSet variantesRS = ccdo.getVariantes();
        if(variantesRS != null){
            Vector colID = variantesRS.getColumnIdentifiers();
            DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida.variantes_ROWSET", variantesRS, colID);
            asignar("COMBO", "cbVariante", dtipo, "DTOSalida.variantes_ROWSET");
        }
        
	
        DruidaConector convariantes = generaConector(variantesRS, "dtoSalida",
                                      "OID_VARI", "DES_VARI", "IND_PUNT");
        asignar("COMBO", "lstVariantes", convariantes, "dtoSalida");
       
        traza("Salida: LPDatosProducto-recargarIndicadores ");
	}
    
    /**
    * Autor: Gpons
    * Fecha: 17/08/2006
    * Descripcion: Recarga los valores de la pagina.
    * Incidencia BELC300023949
    */   
    private void asignarPantalla() throws Exception {
            traza("Entrada: LPDatosProducto-asignarPantalla ");
            
            String sOid = this.conectorParametro("oid");
            this.asignarAtributo("VAR","oid","valor", sOid==null?"": sOid );
        
            String codSAP = this.conectorParametro("codSAP");
            this.asignarAtributo("VAR","codSAP","valor", codSAP==null?"": codSAP );
        
            String descSAP = this.conectorParametro("descSAP");
            this.asignarAtributo("VAR","descSap","valor",descSAP==null?"": descSAP );
        
            String sOcbCondicionPromo = this.conectorParametro("ocbCondicionPromo"); 
            this.asignarAtributo("VAR","ocbCondicionPromo","valor",sOcbCondicionPromo==null?"": sOcbCondicionPromo );
            
            String sOcbCicloVida = this.conectorParametro("ocbCicloVida"); 		
            this.asignarAtributo("VAR","ocbCicloVida","valor",sOcbCicloVida==null?"": sOcbCicloVida );
        
            String sOcbTipoOferta = this.conectorParametro("ocbTipoOferta"); 
            asignarAtributo("VAR","ocbTipoOferta","valor",sOcbTipoOferta==null?"": sOcbTipoOferta );
        
            String sOcbProgramaFidelizacion = this.conectorParametro("ocbProgramaFidelizacion");         
            this.asignarAtributo("VAR","ocbProgramaFidelizacion","valor",sOcbProgramaFidelizacion==null?"": sOcbProgramaFidelizacion );
        
            String sOcbVariante = this.conectorParametro("ocbVariante");         
            this.asignarAtributo("VAR","ocbVariante","valor",sOcbVariante==null?"": sOcbVariante );
            
            String imprimible = this.conectorParametro("imprimible");
            asignarAtributo("VAR","imprimible","valor",imprimible==null?"": imprimible );
        
            String digitable = this.conectorParametro("digitable");
            asignarAtributo("VAR","digitable","valor",digitable==null?"": digitable );
            
            String enableimprimible = this.conectorParametro("enableimprimible");
            asignarAtributo("VAR","enableimprimible","valor",enableimprimible==null?"": enableimprimible );
            
            String enabledigitable = this.conectorParametro("enabledigitable");		
            asignarAtributo("VAR","enabledigitable","valor",enabledigitable==null?"": enabledigitable );
            
            String multiseleccion = conectorParametro("multiseleccion");
            this.asignarAtributo("VAR", "multiseleccion", "valor", multiseleccion==null?"": multiseleccion );
            
            String hFideHabilita = this.conectorParametro("hFideHabilita");         
            this.asignarAtributo("VAR","hFideHabilita","valor",hFideHabilita==null?"": hFideHabilita );
        
            String precioPosicionamientoDisabled =  this.conectorParametro("precioPosicionamientoDisabled");
            this.asignarAtributo("VAR","precioPosicionamientoDisabled","valor",precioPosicionamientoDisabled==null?"": precioPosicionamientoDisabled );
            
            String costeEstandarDisabled =  this.conectorParametro("costeEstandarDisabled");
            this.asignarAtributo("VAR","costeEstandarDisabled","valor",costeEstandarDisabled==null?"": costeEstandarDisabled );
            
            String centroDisabled = this.conectorParametro("centroDisabled");
            this.asignarAtributo("VAR","centroDisabled","valor",centroDisabled==null?"": centroDisabled );
        
            String sDeshabilitarTrioCampos = this.conectorParametro("hidDeshabilitarTrioCampos");
            this.asignarAtributo("VAR", "hidDeshabilitarTrioCampos", "valor", sDeshabilitarTrioCampos==null?"": sDeshabilitarTrioCampos );
        
            String sTipoOperacion = this.conectorParametro("htipoOperacion");
            this.asignarAtributo("VAR", "htipoOperacion", "valor", sTipoOperacion==null?"": sTipoOperacion );
        
            String sObligaPuntoFijo = this.conectorParametro("obligaPuntoFijo");
            asignarAtributo("CTEXTO","obligaPuntoFijo","valor",sObligaPuntoFijo==null?"": sObligaPuntoFijo );
        
            String sHlpRetorno = this.conectorParametro("hlpRetorno");
            this.asignarAtributo("VAR", "hlpRetorno", "valor", sHlpRetorno==null?"": sHlpRetorno );
        
            String sCodProducto = this.conectorParametro("txtCodProducto");
            this.asignarAtributo("CTEXTO","txtCodProducto","valor", sCodProducto==null?"": sCodProducto );
        
            String sTextoBreve = this.conectorParametro("txtTextoBreve");
            this.asignarAtributo("CTEXTO","txtTextoBreve","valor",sTextoBreve==null?"": sTextoBreve );
        
            String sDescripcionCatalogo = conectorParametro("txtCatalogo"); 
            this.asignarAtributo("CTEXTO", "txtCatalogo", "valor", sDescripcionCatalogo==null?"": sDescripcionCatalogo );
        
            String sFactRep = this.conectorParametro("txtFactorRepeticion");
            asignarAtributo("CTEXTO","txtFactorRepeticion","valor",sFactRep==null?"": sFactRep );
        
            String sCkDigitable = conectorParametroLimpia("ckDigitable","N",true);
            asignarAtributo("CHECKBOX","ckDigitable","check",sCkDigitable);
            asignarAtributo("VAR","digitable","valor",sCkDigitable);
            
            String sCkImprimible = conectorParametroLimpia("ckImprimible","N",true);
            asignarAtributo("CHECKBOX","ckImprimible","check", sCkImprimible );
            asignarAtributo("VAR","imprimible","valor",sCkImprimible);
        
            String sPrecioCatalogo = this.conectorParametro("txtPrecioCat");
            asignarAtributo("CTEXTO","txtPrecioCat","valor",(sPrecioCatalogo==null?"":sPrecioCatalogo));
        
            String sPrecioPosic = this.conectorParametro("txtPrecioPos");
            this.asignarAtributo("CTEXTO", "txtPrecioPos", "valor", sPrecioPosic==null?"": sPrecioPosic );
        
            String sCosteEstandar = this.conectorParametro("txtCosteEstandar");
            this.asignarAtributo("CTEXTO", "txtCosteEstandar", "valor", sCosteEstandar==null?"": sCosteEstandar );
        
            String sUnidEstimadas = this.conectorParametro("txtUniEstimadas2");
            asignarAtributo("CTEXTO","txtUniEstimadas2","valor", (sUnidEstimadas==null?"":sUnidEstimadas));
        
            String sVentaEstimada = this.conectorParametro("txtVentaNetaEstimada");
            asignarAtributo("CTEXTO","txtVentaNetaEstimada","valor",(sVentaEstimada==null?"":sVentaEstimada));
        
            String sNPagCatalogo = this.conectorParametro("txtNPagCatalogo");
            asignarAtributo("CTEXTO","txtNPagCatalogo","valor",sNPagCatalogo==null?"": sNPagCatalogo );
        
            String sPosPagina = this.conectorParametro("txtPosPagina");
            asignarAtributo("CTEXTO","txtPosPagina","valor",sPosPagina==null?"": sPosPagina );
        
            String sCentro = this.conectorParametro("txtCentro");
            this.asignarAtributo("CTEXTO", "txtCentro", "valor", sCentro==null?"": sCentro );
        
            String sPuntoFijo = this.conectorParametro("txtPuntoFijo");
            asignarAtributo("CTEXTO","txtPuntoFijo","valor",sPuntoFijo==null?"": sPuntoFijo );
        
            traza("Salida: LPDatosProducto-asignarPantalla ");
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
