import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.dtos.pre.DTOValidacionRecuperacion;
import es.indra.sicc.dtos.pre.DTOValidacionesOferta;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesSession;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;


/**
 * en Sistema:    444         Belcorp - SICC
 * Modulo:              PRE - Precios * 
 */
 /*--------------------------------------------------
  * Esta clase se encarga del mantenimiento de la 
  * pagina contenido_producto_venta_buscar 
  */

  
public class LPBuscarProductosVenta extends LPSICCBase {
    private String accion = null;

    public LPBuscarProductosVenta() {
        super();
    }

    public void inicio() throws Exception {
        pagina("contenido_producto_venta_buscar");
    }
   
    public void ejecucion() throws Exception{
        setTrazaFichero();
        traza(" **** EJECUCION ***");
        String oidMatrizFacturacion  = ((Long)conectorParametroSesion("oidCabeceraMF")).toString();
        traza(" **** oidMatrizFacturacion *** "+oidMatrizFacturacion);
        asignarAtributo("VAR", "UltimaLP", "valor", (String)conectorParametroSesion("UltimaLP") );
 
        try{
            accion = this.conectorParametro("accion");
            traza("/* --------------------------------------------------------*/");
            traza("/* ------LPBuscarProductosVenta - accion " + accion + "----*/");
            traza("/* -------------------------------------------------------*/");
            Long idioma = UtilidadesSession.getIdioma(this);
		        asignarAtributo("VAR", "idiomaSesion", "valor", idioma.toString() );
        
            if ( accion.equals("buscarProductoPrincipal") ){
                asignarAtributo("VAR", "accion", "valor", accion );            
                String sOidCabecera = ((Long)conectorParametroSesion("oidCabeceraMF")).toString();
            
                traza("--------- sOidCabecera " +sOidCabecera);
                asignarAtributo("VAR", "oidCabecera", "valor", sOidCabecera);
			
                asignarAtributo("VAR", "oidMatrizFacturacion", "valor", sOidCabecera);
                traza("--------- traza 1 ");
                asignarAtributo("VAR", "oidPeriodo", "valor", "null");
			
                traza("--------- traza 2 ");
                asignarAtributo("VAR", "tipoProductoEstrategia", "valor", "null");
			
                traza("--------- traza 3 ");
                // Cant de elementos a seleccionar: 1
                asignarAtributo("VAR", "cantElem", "valor", "true");
                
                // Agregado por SICC20070475 - Rafael Romero - 12/10/2007
                asignarAtributo("VAR", "cantidadTotalProductos", "valor", "UNO");
			
            }else if (accion.equals("buscarProductoPrincipalRecuparacion")){
                traza("--------- entra  buscarProductoPrincipalRecuparacion");
                String sOidCabecera = conectorParametroSesion("oidCabeceraMF").toString();
                traza(sOidCabecera);
                String tipoProductoEstrategia = new Integer(ConstantesPRE.RECUPERACION).toString();
                traza(tipoProductoEstrategia);                
                asignarAtributo("VAR", "oidCabecera", "valor", sOidCabecera);
                asignarAtributo("VAR", "oidMatrizFacturacion", "valor", oidMatrizFacturacion);
                asignarAtributo("VAR", "oidPeriodo", "valor", "null");
                asignarAtributo("VAR", "esRecuperacion", "valor", "S");
                asignarAtributo("VAR", "tipoProductoEstrategia", "valor", tipoProductoEstrategia);
                asignarAtributo("VAR", "principalRecuperacion", "valor", "S");

                // Cant de elementos a seleccionar: 1
                asignarAtributo("VAR", "cantElem", "valor", "true");
                
                // Agregado por SICC20070475 - Rafael Romero - 12/10/2007
                asignarAtributo("VAR", "cantidadTotalProductos", "valor", "UNO");
                
            }else if (accion.equals("buscarGrupoProductosAlternativos")){                  
                traza("--------- entra  buscarGrupoProductosAlternativos");
                // String sOidCabecera = (String)conectorParametroSesion("oidCabeceraMF");
                traza("oidMatrizFacturacion" + oidMatrizFacturacion);
                // if (sOidCabecera==null)
                //    sOidCabecera = "2";
                //String tipoProductoEstrategia = "ConstantesPRE.ALTERNATIVO";
                String tipoProductoEstrategia = new Integer(ConstantesPRE.ALTERNATIVO).toString();
                //String tipoProductoEstrategia = "2"; // Campo TIPR_OID_TIPO_PROD de Base.

                asignarAtributo("VAR", "oidCabecera", "valor", oidMatrizFacturacion);
                asignarAtributo("VAR", "oidMatrizFacturacion", "valor", oidMatrizFacturacion);
                asignarAtributo("VAR", "oidPeriodo", "valor", "null");
                asignarAtributo("VAR", "tipoProductoEstrategia", "valor", tipoProductoEstrategia);

                // Cant de elementos a seleccionar: varios
                asignarAtributo("VAR", "cantElem", "valor", "false"); 
                
                // Agregado por SICC20070475 - Rafael Romero - 12/10/2007
                asignarAtributo("VAR", "cantidadTotalProductos", "valor", "DOS");
                
            } else if (accion.equals("buscarGrupoProductosRecuperacion") ){
                asignarAtributo("VAR", "accion", "valor", accion );            
                String sOidCabecera = ((Long)conectorParametroSesion("oidCabeceraMF")).toString();
                String oidPeriodo = conectorParametroLimpia("oidPeriodo","",true); 

				//modificado por Sapaza, fecha 04-10-2007, cambio Sicc20070457
                //String tipoProductoEstrategia = new Integer(ConstantesPRE.ORDEN_COMPRA).toString();
                //traza(tipoProductoEstrategia);
                
                // sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
                String sOidMatrizPrincipal = ((Long) conectorParametroSesion("oidMatrizPrincipal")).toString(); 
                traza("oidMatrizPrincipal: " + sOidMatrizPrincipal);
                asignarAtributo("VAR", "oidMatrizCodigoAlternativo", "valor", sOidMatrizPrincipal);
                
                traza("Perdiodo " + oidPeriodo);
                conectorParametroSesion("oidPeriodo", oidPeriodo);
                asignarAtributo("VAR", "oidCabecera", "valor", sOidCabecera);
                //asignarAtributo("VAR", "tipoProductoEstrategia", "valor", tipoProductoEstrategia);
                asignarAtributo("VAR", "tipoProductoEstrategia", "valor", "null");			

                asignarAtributo("VAR", "oidCabecera", "valor", sOidCabecera);
                asignarAtributo("VAR", "oidMatrizFacturacion", "valor", oidMatrizFacturacion);
                traza("--------- traza 1 ");
                asignarAtributo("VAR", "oidPeriodo", "valor", oidPeriodo);
			
                // Cant de elementos a seleccionar: 1
                asignarAtributo("VAR", "cantElem", "valor", "true");
                asignarAtributo("VAR", "esRecuperacion", "valor", "S");

                // Agregado por SICC20070475 - Rafael Romero - 12/10/2007
                asignarAtributo("VAR", "cantidadTotalProductos", "valor", "DOS");

            } else if (accion.equals("buscarGrupoProductosReemplazo") ){
                String sOidCabecera = ((Long) conectorParametroSesion("oidCabeceraMF")).toString();
           
                String tipoProductoEstrategia = new Integer(ConstantesPRE.REEMPLAZO).toString();          


                asignarAtributo("VAR", "oidCabecera", "valor", sOidCabecera);
                asignarAtributo("VAR", "oidMatrizFacturacion", "valor", oidMatrizFacturacion);
                asignarAtributo("VAR", "oidPeriodo", "valor", "null");
                asignarAtributo("VAR", "tipoProductoEstrategia", "valor", tipoProductoEstrategia);

                // Cant de elementos a seleccionar: 1
                asignarAtributo("VAR", "cantElem", "valor", "true"); 
                
                // Agregado por SICC20070475 - Rafael Romero - 12/10/2007
                asignarAtributo("VAR", "cantidadTotalProductos", "valor", "DOS");
                
            } else if (accion.equals("validarRecuperacion")) {
				traza("accion validarRecuperacion");
				pagina("salidaGenerica");
                accionValidaciones();
			}
            
            if (accion.equals("aniadir") ){
                traza("/*---------------entra aniaadir--------------*/");
                String a = null;
			
                // traza( "variable a "+a.toString() );
                // 1. Obtiene los valores necesitados de la pagina.
		   
                traza("antes asignaciones");
		   
                String  sSeleccion =  conectorParametro("elementosSeleccionados");
                traza("sSeleccion: " + sSeleccion);
           
                String sTipo = (String) conectorParametro("tipoProductoEstrategia");
                traza("sTipo: " + sTipo);

                String sOidCabeceraMatrizFact = ((Long)conectorParametroSesion("oidCabeceraMF")).toString(); 
                traza("sOidCabeceraMatrizFact: " + sOidCabeceraMatrizFact);

                String sPeriodo = (String) conectorParametro("oidPeriodo");
                traza("sPeriodo: " + sPeriodo);
                
                // Agregado por SICC20070475 - Rafael Romero - 12/10/2007
                String cantidadTotalProductos = conectorParametro("cantidadTotalProductos");
                traza("cantidadTotalProductos: " + cantidadTotalProductos);
                // Fin agregado SICC20070475
    
                // Modificado por SICC20070475 - Rafael Romero - 12/10/2007
                // if ( sTipo.equals("null") ){
                if ( cantidadTotalProductos.equals("UNO") ){
                // Fin modificado SICC20070475
                    // 2. Se permitio elegir UN SOLO producto.        

                    String sOidMatrizFact = null;
                    String sVenta = null;
                    String sDescProd = null;
                    String oidPeri = "";              
                    //traza("TipoEstrategia es null -> UN SOLO PRODUCTO");
                    DTOProductoVenta dto = new DTOProductoVenta();
                    //dto.setOidMatrizFacturacion( new Long(sOidMatrizFact) );
                    traza("seleccion");
                    
                    // Parsea el String con la seleccion, proveniente de la pagina.
                    StringTokenizer tok = new StringTokenizer(sSeleccion, ",");
					traza("sSeleccion: "+sSeleccion);
                    traza("tokenizer has " + tok.countTokens() + " token/s");
                    sOidMatrizFact = tok.nextToken();
                    traza("sOidMatrizFact "+ sOidMatrizFact);
                    sVenta = tok.nextToken();
                    traza(" | sVenta "+ sVenta);
                    sDescProd = tok.nextToken();
                    traza("| sDescProd "+sDescProd);
                    try {
                        oidPeri = tok.nextToken();
                        traza("| oidPeri " + oidPeri);
                    } catch (Exception s) {
                    }  
               
                    dto.setCodigoVenta(sVenta);
                    dto.setDescripcion(sDescProd);
                    dto.setOidMatrizFacturacion(new Long(sOidMatrizFact));
                    dto.setOidPeriodo(new Long(oidPeri));

                    //agregado

                    dto.setEmiteMensaje(new Boolean(false));
                    dto.setIndicadorAntesDespuesCuadre(new Boolean(false));
                    dto.setIndicadorRecuperadorAut(new Boolean(false));
                    dto.setNumeroOrden(new Long(0));

                    traza("DTO a poner en sesion: " + dto.toString() );
                    conectorParametroSesion("DTOProductoVenta", dto);
              
                    conectorAction( (String)conectorParametroSesion("UltimaLP") );
				  
                    this.conectorActionParametro("accion", "productoPrincipalSeleccionado");
                } else{
                    //traza("MAS DE UN PRODUCTO");
                    int k= 0;             
                    ArrayList arrayL = new ArrayList();             
                    DTOProductosVenta dtoP = new DTOProductosVenta();

                    traza("antes asignaciones");
                    String  sSelecc =  conectorParametro("elementosSeleccionados");
                    traza("sSelecc: " + sSelecc);

                    // Primero parsea por "|" para separar las potenciales
                    // distintas filas. 
                    StringTokenizer tok = new StringTokenizer(sSelecc, "|");

                    traza("contenido de tok ----- " + sSeleccion);
                    String sBuffer = null;
                    String sOidMatrizFact = null;
                    String sVenta = null;
                    String sDescProd = null;
                    String orden= null;
                    String mensaje= null;
                    
                    while (tok.hasMoreTokens()){
                        DTOProductoVenta dto = new DTOProductoVenta();
                        traza("tokenizer has " + tok.countTokens() + " token/s");              
				
                        sBuffer = tok.nextToken();  

                        traza("------------------------------------------");

                        traza("contenido de sBuffer *******" + sBuffer);
				
                        // Ahora, ya que tenemos una fila, la parseamos y armamos un
                        //DTOProducto NOTA: Acá se setea Periodo (si es distinto de 
                        //"null" <-- STRING, no NULL) 

                        StringTokenizer tokFila = new StringTokenizer(sBuffer, ",");

                        sOidMatrizFact = tokFila.nextToken();
                        traza("sOidMatrizFact" +sOidMatrizFact);
                        sVenta = tokFila.nextToken();
                        traza("sVenta" +sVenta);
                        sDescProd = tokFila.nextToken();
                        traza("sDescProd" +sDescProd);
                        dto.setCodigoVenta(sVenta);
                        dto.setDescripcion(sDescProd);
                        dto.setOidMatrizFacturacion(new Long(sOidMatrizFact));


                        if ((!sPeriodo.equals("null")) && (!sPeriodo.equals("") ))
                            dto.setOidPeriodo(new Long(sPeriodo) );
                        else
                            dto.setOidPeriodo(null);

                        traza("dto a Agregar: " + dto.toString() );
                        arrayL.add(dto);
                        traza ("arrayL "+arrayL);
                        dtoP.setListaProductos(arrayL);
                        traza("|||||||Contenido de dtoP *****" + dtoP);
                    }	

                    traza("###############Contenido de dtoP *****" + dtoP.getProductoPrincipal());
                    conectorParametroSesion("DTOProductosVenta", dtoP);
                    conectorAction( (String)conectorParametroSesion("UltimaLP") );
                    this.conectorActionParametro("accion", "grupoProductosSeleccionado");
                }
            }	  

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

        }catch (Exception e){
            e.printStackTrace();
            this.lanzarPaginaError(e);

            if (accion.equals("aniadir") ){
                if((String)conectorParametro("codVenta") != null )
                    asignarAtributo("CTEXTO","txtCodigoVenta","valor",(String)conectorParametro("codVenta"));
                if ((String)conectorParametro("descProd") != null)
                    asignarAtributo("CTEXTO","txtDescripcion","valor",(String)conectorParametro("descProd"));
                    asignarAtributo("VAR", "accion", "valor", "aniadir");
            }
        }
        getConfiguracionMenu("LPBuscarProductosVenta","");
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
    
    // sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
    private void accionValidaciones() throws Exception {
    	traza("LPBuscarProductosVenta.accionValidaciones():Entrada");
    	asignar("VAR", "cerrarVentana", "false");
    	
    	String mensajeValidacion = "";
    	
        String sOidMatrizPrincipal = ((Long) conectorParametroSesion("oidMatrizPrincipal")).toString(); 
        traza("oidMatrizPrincipal: " + sOidMatrizPrincipal);
    	
    	String sOidMatrizRecuperacion = this.conectorParametroLimpia("oidMatrizCodigoAlternativo", "", true);       	  
    	traza("oidMatrizRecuperacion: " + sOidMatrizRecuperacion);
    	
    	DTOValidacionRecuperacion dto = new DTOValidacionRecuperacion();
        dto.setOidMatrizPrincipal(new Long(sOidMatrizPrincipal));
        dto.setOidMatrizRecuperacion(new Long(sOidMatrizRecuperacion));
        
        MareBusinessID bid = new MareBusinessID("PREValidarProductoRecuperacion");
        Vector vec = new Vector();
        vec.add(dto);
        vec.add(bid);
        traza("--llamando al conector");

        DTOString ccdo = (DTOString) conectar("ConectorCargarCriteriosDefinirOferta",
                 vec).objeto("dtoSalida");
         
        if(ccdo.getCadena()!=null)
        	mensajeValidacion = ccdo.getCadena();
    	
    	String funcion = new String("mostrarValidaciones('" + mensajeValidacion + "')");
		traza("Funcion a ejecutar: " + funcion);
		
    	asignarAtributo("VAR", "ejecutar", "valor", funcion);
    }
    
}

