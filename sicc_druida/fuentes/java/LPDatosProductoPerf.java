import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.ConstantesPRE;
import es.indra.sicc.dtos.pre.DTOECargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOEstrategia;
import es.indra.sicc.dtos.pre.DTOSCargarCriteriosDefinirOferta;
import es.indra.sicc.dtos.pre.DTOValidacionesOferta;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.lang.Exception;
import java.math.BigDecimal;

import java.util.Hashtable;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;



public class LPDatosProductoPerf extends LPSICCBase {

	private static final String nombreLogica  = "LPDatosProductoPerf";
	private Long oid = null;
	private Long pais = null;
	private String accion = "";
	private Hashtable productos = null;

	private long TiempoDeCargaInicio;
	private long TiempoDeCargaFin;    


// Constructor, siempre igual
	 public LPDatosProductoPerf() {  
		super();
	 }

    public void inicio() throws Exception {
		/*inicio enozigli COL-PRE-002*/
		// Se elimina de aqui la llamada a la pagina ya que ahora hay 2 posibles paginas para cargar
		/*fin enozigli COL-PRE-002*/
	}
	
// Va siempre
   public void ejecucion() throws Exception {

        TiempoDeCargaInicio = System.currentTimeMillis();    
        
        try{            
            setTrazaFichero();
            traza("LPDatosProductoPerf.ejecucion");
			/*inicio enozigli COL-PRE-002*/
            //getFormatosValidaciones();
            accion = conectorParametro("accion") == null?"":conectorParametro("accion");
            traza("accion: " + accion);

            if (accion.equals("")) {
				pagina("contenido_datos_producto_insertar_perf");
	            this.getConfiguracionMenu("LPDatosProductoPerf","");
	            asignarAtributo("VAR","multiseleccion","valor",(conectorParametro("multiseleccion")!=null?conectorParametro("multiseleccion"):""));
                accionVacia();
            } else if (accion.equals("precios")) {
				traza("accion precios");
				pagina("contenido_rangos_precios_ingresar");
	            this.getConfiguracionMenu("LPDatosProductoPerf","rangos");
                accionPrecios();
			} else if (accion.equals("validaciones")) {
				traza("accion validaciones");
				pagina("salidaGenerica");
                accionValidaciones();
			}

			getFormatosValidaciones();

			/*fin enozigli COL-PRE-002*/

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

        TiempoDeCargaFin = System.currentTimeMillis();
        traza("El tiempo de carga de LPDatosProductoPerf es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));          
		
        }catch(Exception ex) {

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
  /**
   * @author enoziglia
   * @date 10/10/2007
   * @throws Exception
   * @reference COL-PRE-002
   */
  private void accionPrecios() throws Exception {
		traza("LPDatosProductoPerf.accionPrecios():Entrada");
        String sTipoOperacion = this.conectorParametro("tipoOperacion");
        if (sTipoOperacion == null) {
  		  sTipoOperacion = this.conectorParametro("htipoOperacion");
		  if (sTipoOperacion == null || "".equals(sTipoOperacion)) {
	          sTipoOperacion = "";
		  }
        }
		traza("LPDatosProductoPerf.accionPrecios():Mitad");
        this.asignarAtributo("VAR", "htipoOperacion", "valor", sTipoOperacion);
		this.asignarAtributo("VAR", "htipoOperacionMODIFICACION", "valor", ConstantesPRE.OPERACION_MODIFICACION);	
		traza("LPDatosProductoPerf.accionPrecios():Salida");
  }
  /*fin enozigli COL-PRE-002*/

  private void accionVacia() throws Exception {
		cargarPantalla();
  }

  private void cargarPantalla() throws Exception {

		Long oidCabeceraMF = (Long) conectorParametroSesion("oidCabeceraMF");
        Long oidEstrategia = (Long) conectorParametroSesion("oidEstrategia");
        Long idioma = UtilidadesSession.getIdioma(this);
        Long pais = UtilidadesSession.getPais(this);
        
        DTOECargarCriteriosDefinirOferta dto = new DTOECargarCriteriosDefinirOferta();
        dto.setOidCabeceraMF(oidCabeceraMF);
        dto.setOidEstrategia(oidEstrategia);
        dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
        dto.setIpCliente(UtilidadesSession.getIdUsuario(this));
        dto.setPrograma(UtilidadesSession.getFuncion(this));

        MareBusinessID bid = new MareBusinessID("PRECargarCriteriosDefinirOferta");
        Vector vec = new Vector();
        vec.add(dto);
        vec.add(bid);
        traza("cargarPantalla();--1--llamando al conector");

        DTOSCargarCriteriosDefinirOferta ccdo = (DTOSCargarCriteriosDefinirOferta) conectar("ConectorCargarCriteriosDefinirOferta",
                vec).objeto("dtoSalida");

        String multiseleccion = conectorParametro("multiseleccion");

        // Agregado por ssantana, 11/10/2005, GCC-PRE-001
        String sTipoOperacion = this.conectorParametro("tipoOperacion");
        if (sTipoOperacion == null) {
  		  sTipoOperacion = this.conectorParametro("htipoOperacion");
		  if (sTipoOperacion == null || "".equals(sTipoOperacion)) {
	          sTipoOperacion = "";
		  }
        }
        
        this.asignarAtributo("VAR", "htipoOperacion", "valor", sTipoOperacion);
		this.asignarAtributo("VAR", "htipoOperacionMODIFICACION", "valor", ConstantesPRE.OPERACION_MODIFICACION);
        String slpRetorno = this.conectorParametro("lpRetorno");
        if (slpRetorno==null){ slpRetorno = ""; }
        this.asignarAtributo("VAR", "hlpRetorno", "valor", slpRetorno);

       
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

		traza("DTOSCargarCriteriosDefinirOferta : " + ccdo);


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
		
		//para manejo de labels comisionable, puntaje, estadisticable, monto minimo y aporta monto a escala.
		//OID_TIPO_OFER, VAL_I18N,IND_COMI,IND_PUNT,IND_ESTA,IND_MONT_MINI, IND_APOR_MONT_ESCA
		StringBuffer lstTiposOferta = new StringBuffer();

		for (int i=0;i<tipoOfertaRS.getRowCount();i++)	{
			lstTiposOferta.append(tipoOfertaRS.getValueAt(i,0)+"&");//0
			//lstTiposOferta.append(tipoOfertaRS.getValueAt(i,1)+"&");//VAL_I18N lo saco porque no es necesario
			lstTiposOferta.append(tipoOfertaRS.getValueAt(i,2)+"&");//1
			lstTiposOferta.append(tipoOfertaRS.getValueAt(i,3)+"&");//2
			lstTiposOferta.append(tipoOfertaRS.getValueAt(i,4)+"&");//3
			lstTiposOferta.append(tipoOfertaRS.getValueAt(i,5)+"&");//4
			lstTiposOferta.append(tipoOfertaRS.getValueAt(i,6));//5
			lstTiposOferta.append("|");
			// | divisor de registro y & divisor de dato
		}		
		this.asignarAtributo("VAR", "hlstTiposOferta", "valor", lstTiposOferta.toString());

		traza("20");
		RecordSet cicloVidaRS = ccdo.getCiclosVida();
		if(cicloVidaRS != null){
			Vector colID = cicloVidaRS.getColumnIdentifiers();
			DruidaConector dtipo = UtilidadesBelcorp.generarConector("DTOSalida", cicloVidaRS, colID);
			traza("dtipo: " + dtipo );					
			asignar("COMBO", "cbCicloVida", dtipo, "DTOSalida");		
		}

		traza("21");
		DTOEstrategia estrategia = ccdo.getEstrategia();

		asignarAtributo("VAR","hTipoEstrategia","valor",ccdo.getTipoEstrategia().getCodigoTipoEstrategia().toString());
		asignarAtributo("VAR","hCompuestaFija","valor",""+ConstantesPRE.COMPUESTA_FIJA);				

		if(estrategia != null && estrategia.getCvDigitable() != null) {
			asignarAtributo("VAR","hdigitable","valor", (estrategia.getCvDigitable().booleanValue() == true)?"S":"N");	
		}
		if(estrategia.getModificableDigitable()!=null&&estrategia.getModificableDigitable().booleanValue()==true){
			asignarAtributo("VAR","henabledigitable","valor","true");
		} 
		traza("22");
		if(estrategia != null && estrategia.getCvDigitable() != null) {
			asignarAtributo("VAR","himprimible","valor", (estrategia.getCvImprimible().booleanValue() == true)?"S":"N");	
		}
		if(estrategia.getModificableImprimible()!=null&&estrategia.getModificableImprimible().booleanValue()==true){
			asignarAtributo("VAR","henableimprimible","valor","true");
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

		//para manejo de variantes.
		//OID_VARI,DES_VARI,IND_PUNT
		StringBuffer lstVariantes = new StringBuffer();

		for (int i=0;i<variantesRS.getRowCount();i++)	{
			lstVariantes.append(variantesRS.getValueAt(i,0)+"&");//0
			//lstTiposOferta.append(tipoOfertaRS.getValueAt(i,1)+"&");//DES_VARI no lo necesito
			lstVariantes.append(variantesRS.getValueAt(i,2));//1

			lstVariantes.append("|");
			// | divisor de registro y & divisor de dato
		}		
		this.asignarAtributo("VAR", "hlstVariantes", "valor", lstVariantes.toString());

		traza("fin carga Club Priviledges");       
	   /*
		* fin agregado por enozigli, 25/10/2005 - Cambio Club Priviledges
		*/               
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
    
    private void accionValidaciones() throws Exception {
    	traza("LPDatosProductoPerf.accionValidaciones():Entrada");
    	asignar("VAR", "cerrarVentana", "false");
    	
    	String mensajeValidacion = "";
    	String oidTipoOferta = this.conectorParametroLimpia("ocbTipoOferta", "", true);   
    	String sCodProducto = this.conectorParametroLimpia("txtCodProducto", "", true);
    	Long oidEstrategia = (Long) conectorParametroSesion("oidEstrategia");
    	String sPrecioCat = this.conectorParametroLimpia("txtPrecioCat", "", true);  
    	String sPrecioPos = this.conectorParametroLimpia("txtPrecioPos", "", true);  
    	
    	traza("oidTipoOferta: " + oidTipoOferta);
    	traza("sCodProducto: " + sCodProducto);
    	traza("oidEstrategia: " + oidEstrategia);
    	traza("sPrecioCat: " + sPrecioCat);
    	traza("sPrecioPos: " + sPrecioPos);
    	
    	DTOValidacionesOferta dto = new DTOValidacionesOferta();
        dto.setOidPais(pais);
        dto.setOidTipoOferta(new Long(oidTipoOferta));
        dto.setCodigoProducto(sCodProducto);
        dto.setOidEstrategia(new Long(oidEstrategia));
        dto.setPrecioCatalogo(new BigDecimal(sPrecioCat.replace(",", "")));
        dto.setPrecioPosicionamiento(new BigDecimal(sPrecioPos.replace(",", "")));
        
        MareBusinessID bid = new MareBusinessID("PREValidarRestriccionesOferta");
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
