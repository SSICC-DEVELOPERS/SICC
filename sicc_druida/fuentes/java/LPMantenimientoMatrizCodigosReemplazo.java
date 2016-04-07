import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.DTOProductoVenta;
import es.indra.sicc.dtos.pre.DTOProductosVenta;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.math.BigDecimal;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Vector;

import org.jaxen.dom.DOMXPath;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import es.indra.sicc.util.xml.XMLDocument;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

//import LPSICCBase;


public class LPMantenimientoMatrizCodigosReemplazo extends LPSICCBase {
   
  public LPMantenimientoMatrizCodigosReemplazo() {
    super();
  }

  public void inicio() throws Exception{
    pagina("contenido_matriz_codigos_reemplazo_registrar");
	this.cargarZonas();
	this.cargarRegiones();
	this.cargaComboTipoClien();
    Long pais = UtilidadesSession.getPais(this);
    Long idioma = UtilidadesSession.getIdioma(this);

    asignarAtributo("VAR","hIdioma","valor", (idioma==null?"":idioma.toString()) );
    asignarAtributo("VAR","hPais","valor",  (pais==null?"":pais.toString()) );

  }

  public void ejecucion() throws Exception{
    setTrazaFichero();
		this.rastreo();
    String accion = conectorParametroLimpia("accion","",true); 
    traza("accion: " + accion);
		asignarAtributo("VAR", "accion", "valor", accion );

    String cbReemplazo = conectorParametroLimpia("cbReemplazo", "", true);      
	String ckEmitirMensaje = conectorParametroLimpia("ckEmitirMensaje", "", true);    
	
	String cbTipoCliente = conectorParametroLimpia("cbTipoCliente", "", true);      
	String cbSubTipoCliente = conectorParametroLimpia("cbSubTipoCliente", "", true);      
	String cbTipoClasificacion = conectorParametroLimpia("cbTipoClasificacion", "", true);
	String cbClasificacion = conectorParametroLimpia("cbClasificacion", "", true);      
	String cbRegion = conectorParametroLimpia("cbRegion", "", true);
	String cbZona = conectorParametroLimpia("cbZona", "", true);
		
    try{
      if(accion.equals("")){
        // Acción "" 
        // 1- Asignar pagina "_matriz_codigos_reemplazo_registrar" 
        // 2- Guardar en sesión el nombre de la LP actual y llamar a la LP 
        // "LPSeleccionarMF" perteneciente al caso de uso 
        // "SeleccionarMatrizFacturacion". .
        conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosReemplazo");
        conectorAction("LPSeleccionarMF");
        
      }else if( accion.equals("Matriz seleccionada") ){
      
        // Acción "matrizSeleccionada" 
        // 1- Obtener de la sesión el oid de la matriz seleccionada en la 
        // actividad anterior.
        // 2- Mostrar pagina "_matriz_codigos_reemplazo_registrar" vacía 
        String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString(); 
				traza("contenido del oid de matriz  ::: . " + sOidMatriz);	
				asignarAtributo("VAR", "oidMatrizFacturacion", "valor", sOidMatriz);
              
      }else if( accion.equals("buscarProductoPrincipal") ){
      
        // Acción "buscarProductoPrincipal" 
        // 1- Guardar en sesión el nombre de la LP actual en la variable 
        // "UltimaLP" y llamar a la LP "LPBuscarProductosVenta", 
        // accion "buscarProductoPrincipal"
        conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosReemplazo");
        conectorAction("LPBuscarProductosVenta");
        conectorActionParametro("accion", "buscarProductoPrincipal");

      }else if( accion.equals("productoPrincipalSeleccionado") ){
      
        // Acción "productoPrincipalSeleccionado" 
        // 1- Obtener de la sesión el objeto DTOProductoVenta 
        // 2- Construir idBusiness = "PRECargarRegistroMatrizCodigosReemplazo" 
        // 3- Asignar conector "ConectorCargarPantallasRegistro" 
        // 4- Asignar a la pagina el objeto dto de respuesta "DTOSalida" 
        // 5- Si no se encuentran datos mostrar mensaje "PRE-0040" 
        DTOProductoVenta dtoProductoPrincipal  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

        asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", dtoProductoPrincipal.getCodigoVenta());
        asignarAtributo("LABELC", "lblDescripcionXX", "valor", dtoProductoPrincipal.getDescripcion());

        dtoProductoPrincipal.setOidIdioma(UtilidadesSession.getIdioma(this));

        //Parametros auditoria
        dtoProductoPrincipal.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductoPrincipal.setPrograma( UtilidadesSession.getFuncion(this) );

        // Producto de reemplazo
        MareBusinessID id = new MareBusinessID("PRECargarRegistroMatrizCodigosReemplazo");
        Vector parametros = new Vector();
        parametros.add(dtoProductoPrincipal);
        parametros.add(id);

        traza("antes conector 1");
        DruidaConector conector = (DruidaConector)conectar("ConectorCargaPantallasRegistro", parametros);
        traza("despues conector 1");

        DTOSalida dtoSalida = (DTOSalida)conector.objeto("DTOSalida");

        RecordSet rs = dtoSalida.getResultado();

        if( rs.esVacio() ){
          asignarAtributo("VAR", "hidDatosReemp", "valor", "N");
        } else {
          // Producto de reemplazo
          BigDecimal oidMatrizFacturacion = (BigDecimal)rs.getValueAt(0, "OID_MATR_FACT");
          String codVenta = (String)rs.getValueAt(0, "VAL_CODI_VENT");
          String descripcion = (String)rs.getValueAt(0, "VAL_I18N");
          BigDecimal bdReemplazo = (BigDecimal)rs.getValueAt(0, "IND_REEM_ANTE_CUAD");
          BigDecimal bdMensaje = (BigDecimal)rs.getValueAt(0, "IND_MENS");

          traza("oidMatrizFacturacion: " + new Long(oidMatrizFacturacion.longValue()));
          traza("codVenta: " + codVenta);
          traza("descripcion; " + descripcion);

          asignarAtributo("LABELC", "lblCodigoVentaReemplazoXX", "valor", codVenta );
          asignarAtributo("LABELC", "lblDescripcionReemplazoXX", "valor", descripcion );

          if ( bdMensaje.intValue() == 1 ){
            asignarAtributo("CHECKBOX", "ckEmitirMensaje", "check", "S");
          }else{
            asignarAtributo("CHECKBOX", "ckEmitirMensaje", "check", "N");
          }
					
          if( bdReemplazo!= null && bdReemplazo.intValue() == 1 ){
            asignarAtributo("VAR","hidReemAntesCuadre", "valor", "1");    
          }else if( bdReemplazo!= null && bdReemplazo.intValue() == 0 ){
            asignarAtributo("VAR","hidReemAntesCuadre", "valor", "2");    
          }else{
            asignarAtributo("VAR","hidReemAntesCuadre", "valor", "0");    
          }

          asignarAtributo("VAR", "hidDatosReemp", "valor", "S");

          ArrayList array = new ArrayList();		
          DTOProductosVenta dtoProductosReemplazo = new DTOProductosVenta();
          DTOProductoVenta dtoProductoReemplazo = new DTOProductoVenta();
				
          dtoProductoReemplazo.setOidMatrizFacturacion(new Long(oidMatrizFacturacion.longValue()));
          dtoProductoReemplazo.setCodigoVenta(codVenta);				
          dtoProductoReemplazo.setDescripcion(descripcion);

          array.add(dtoProductoReemplazo);

          dtoProductosReemplazo.setListaProductos(array);		

          conectorParametroSesion("DTOProductosVenta", dtoProductosReemplazo);
        }
      }else if( accion.equals("buscarProductosReemplazo") ){
        // Acción "buscarProductosReemplazo" 
        // 1- Guardar en sesión el nombre de la LP actual en la variable 
        // "UltimaLP" y llamar a la LP "LPBuscarProductosVenta", accion
        // "buscarGrupoProductosReemplazo".
        String sOidMatriz = ((Long) conectorParametroSesion("oidCabeceraMF")).toString(); 
        traza("contenido del oid de matriz 3: " + sOidMatriz);	

        conectorParametroSesion("UltimaLP", "LPMantenimientoMatrizCodigosReemplazo");
        conectorAction("LPBuscarProductosVenta");
        conectorActionParametro("accion", "buscarGrupoProductosReemplazo");

      }else if( accion.equals("grupoProductosSeleccionado") ){
        // Acción "grupoProductosSeleccionado" 
        // 1- Obtener de la sesión el objeto DTOProductoVenta y desplegarlo
        // en pantalla.
        DTOProductoVenta dtoProductoVentaPrincReemp  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

        traza("dtoProductoVentaPrincReemp:" + dtoProductoVentaPrincReemp);

        asignarAtributo("LABELC", "lblCodigoVentaXX", "valor", dtoProductoVentaPrincReemp.getCodigoVenta());
        asignarAtributo("LABELC", "lblDescripcionXX", "valor", dtoProductoVentaPrincReemp.getDescripcion());

        // Producto de reemplazo
        DTOProductosVenta dtoProductosReemplazo = (DTOProductosVenta)conectorParametroSesion("DTOProductosVenta");

        ArrayList array = new ArrayList();

        array = dtoProductosReemplazo.getListaProductos();

        DTOProductoVenta dtoProductoReemplazo = (DTOProductoVenta) array.get(0);		
 
        traza("dtoProductoReemplazo:" + dtoProductoReemplazo);

        asignarAtributo("LABELC", "lblCodigoVentaReemplazoXX", "valor", dtoProductoReemplazo.getCodigoVenta());
        asignarAtributo("LABELC", "lblDescripcionReemplazoXX", "valor", dtoProductoReemplazo.getDescripcion());
                
				asignarAtributo("VAR", "hidDatosReemp", "valor", "S");

			}else if( accion.equals("guardarMatriz") ){
        // Acción "guardarMatriz"
        // 1- Construir un objeto DTOProductosVenta 
        // 2- Guardar el producto principal de la pantalla en un objeto 
        // DTOProductoVenta y añadirlo al parámetro productoPrincipal del
        // DTOProductosVenta .
        // 3- Guardar el registro del producto de recuperación en un objeto
        // DTOProductoVenta, y almacenarlo en el objeto DTOProductosVenta, 
        // en un array que contiene como atributo.
        // 4- Construir idBusiness = "PREGuardarMatrizCodigosReemplazo".
        // 5- Asignar conector "ConectorGuardarMatrizCodigosReemplazo".

				pagina("salidaGenerica");

        DTOProductosVenta dtoProductos = new DTOProductosVenta();
				DTOProductoVenta dtoProductoReemplazo = new DTOProductoVenta();


        //Parametros auditoria
        dtoProductos.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductos.setPrograma( UtilidadesSession.getFuncion(this) );

        dtoProductoReemplazo.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductoReemplazo.setPrograma( UtilidadesSession.getFuncion(this) );


        // Producto principal
        DTOProductoVenta dtoProductoVentaPrincReemp  = (DTOProductoVenta)conectorParametroSesion("DTOProductoVenta");

        //Parametros auditoria
        dtoProductoVentaPrincReemp.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductoVentaPrincReemp.setPrograma( UtilidadesSession.getFuncion(this) );

				dtoProductos.setProductoPrincipal(dtoProductoVentaPrincReemp);

        // Producto de reemplazo                
				DTOProductosVenta dtoProductosReemplazo = (DTOProductosVenta)conectorParametroSesion("DTOProductosVenta");

        //Parametros auditoria
        dtoProductosReemplazo.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductosReemplazo.setPrograma( UtilidadesSession.getFuncion(this) );

				ArrayList array = new ArrayList();				

			  array = dtoProductosReemplazo.getListaProductos();				

				DTOProductoVenta dtoProductoVentaReemp = (DTOProductoVenta) array.get(0);

        //Parametros auditoria
        dtoProductoVentaReemp.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductoVentaReemp.setPrograma( UtilidadesSession.getFuncion(this) );
				
				dtoProductoReemplazo.setOidMatrizFacturacion(dtoProductoVentaReemp.getOidMatrizFacturacion());
        dtoProductoReemplazo.setCodigoVenta(dtoProductoVentaReemp.getCodigoVenta());				
        dtoProductoReemplazo.setDescripcion(dtoProductoVentaReemp.getDescripcion());
        
        if(!cbReemplazo.equals("0")) {
          dtoProductoReemplazo.setIndicadorAntesDespuesCuadre(cbReemplazo.equals("1")?Boolean.TRUE:Boolean.FALSE);
				}
        
        dtoProductoReemplazo.setEmiteMensaje(ckEmitirMensaje.equals("S")?Boolean.TRUE:Boolean.FALSE);

		dtoProductoReemplazo.setTipoCliente(cbTipoCliente.equals("")?null: new Long(cbTipoCliente) );
		dtoProductoReemplazo.setSubTipoCliente(cbSubTipoCliente.equals("")?null: new Long(cbSubTipoCliente) );
		dtoProductoReemplazo.setTipoClasificacion(cbTipoClasificacion.equals("")?null: new Long(cbTipoClasificacion) );
		dtoProductoReemplazo.setClasificacion(cbClasificacion.equals("")?null: new Long(cbClasificacion) );

		if(cbZona.trim().equals("")){
			dtoProductoReemplazo.setRegiones(cbRegion.trim().equals("") ? null : this.obtenerRegiones(cbRegion));
		}
		if(cbRegion.trim().equals("")){
			dtoProductoReemplazo.setRegiones(cbZona.trim().equals("") ? null : this.obtenerZonas(cbZona,false));
			dtoProductoReemplazo.setZonas(cbZona.trim().equals("") ? null : this.obtenerZonas(cbZona,true));
		}
				ArrayList arrayProd = new ArrayList();
				arrayProd.add(dtoProductoReemplazo);
                
        dtoProductos.setListaProductos(arrayProd);				

        //Parametros auditoria
        dtoProductos.setIpCliente( UtilidadesBelcorp.getIPCliente(this) );
        dtoProductos.setPrograma( UtilidadesSession.getFuncion(this) );

        MareBusinessID id = new MareBusinessID("PREGuardarMatrizCodigosReemplazo");

				traza("dtoProductos:" + dtoProductos);

        Vector paramEntrada = new Vector();
        paramEntrada.add(dtoProductos);
        paramEntrada.add(id);
                
				traza("antes conector 2");
        DruidaConector conector = conectar("ConectorGuardarMatrizCodigosReemplazo", paramEntrada); 				
				traza("despues conector 2");

				asignarAtributo("VAR", "ejecutar", "valor", "cargarAccion('','N');");
      }

        // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
        agregarMenuComplementario();
        // Fin agregado SICC20070322

    }catch (Exception ex){
			logStackTrace(ex);
      this.lanzarPaginaError(ex);
    } 
    
    getConfiguracionMenu("LPMantenimientoMatrizCodigosReemplazo");
  }


	public void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());

		ByteArrayOutputStream pila = new ByteArrayOutputStream();
		PrintStream out = new PrintStream(pila);
		if (e instanceof MareException){
      MareException e2=(MareException)e;
			traza("Es una mare Exception con codigo de error: "+e2.getCode());
		}
		e.printStackTrace(out);
		traza("stack Trace : " +  pila.toString());
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
	private ArrayList obtenerRegiones(String oidsRegiones) throws Exception {
		StringTokenizer oidsRegionesTk = new StringTokenizer(oidsRegiones,"|");
		ArrayList regiones = new ArrayList();
    
		while (oidsRegionesTk.hasMoreTokens()) {
			Long oidRegion = new Long(oidsRegionesTk.nextToken());
			regiones.add(oidRegion);
		}
		return regiones;
	}

	private ArrayList obtenerZonas(String oids, boolean Zona) throws Exception {
		StringTokenizer oidsZonasTk = new StringTokenizer(oids,"|");
		ArrayList zonas = new ArrayList();
		ArrayList regiones = new ArrayList();
		StringTokenizer oidsZonasSinRegionTk;
		while (oidsZonasTk.hasMoreTokens()) {
			oidsZonasSinRegionTk = new StringTokenizer(oidsZonasTk.nextToken(),"x");
			Long oidZona = new Long(oidsZonasSinRegionTk.nextToken());
			Long oidRegion = new Long(oidsZonasSinRegionTk.nextToken());
			zonas.add(oidZona);
			regiones.add(oidRegion);
		}
		if(Zona){
			return zonas;
		}else{
			return regiones;
		}
	}

	private void cargarRegiones()
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOBelcorp dto = new DTOBelcorp();
        dto.setOidIdioma(idioma);
        dto.setOidPais(pais);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dto);
        vector.add(new MareBusinessID("ZONObtenerRegionesPorPais"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConector(dtosalida.getResultado(), "dtoSalida", "OID", "DESCRIPCION", "MARCA", "CANAL", null, null);
        asignar("COMBO", "cbRegion", druidaconector, "dtoSalida");
    }

    private void cargarZonas()
        throws Exception
    {
        Long pais = UtilidadesSession.getPais(this);
        Long idioma = UtilidadesSession.getIdioma(this);

		DTOSalida dtosalida = new DTOSalida();
        DTOUnidadAdministrativa dtounidadadministrativa = new DTOUnidadAdministrativa();
        dtounidadadministrativa.setOidIdioma(idioma);
        dtounidadadministrativa.setOidPais(pais);
        dtounidadadministrativa.setOidMarca(null);
        dtounidadadministrativa.setOidCanal(null);
        DruidaConector druidaconector = null;
        Vector vector = new Vector();
        vector.add(dtounidadadministrativa);
        vector.add(new MareBusinessID("ZONObtenerZonasPorRegiones"));
        druidaconector = conectar("ConectorObjeto", vector);
        dtosalida = (DTOSalida)druidaconector.objeto("DTOSalida");
        druidaconector = generaConectorZona(dtosalida.getResultado(), "dtoSalida", "OID_ZONA","DES_ZONA", "ZORG_OID_REGI", "MARCA", "CANAL", null);
        asignar("COMBO", "cbZona", druidaconector, "dtoSalida");
    }
private DruidaConector generaConector(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString() : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }
        }

        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
  private DruidaConector generaConectorZona(RecordSet recordset, String s, String s1, String s2, String s3, String s4, String s5, 
            String s6)
        throws Exception
    {
        XMLDocument xmldocument = new XMLDocument();
        Document document = xmldocument.makeDocument("<ROWSET2/>");
        String s7 = UtilidadesSession.getFormatoFecha(this);
        Element element = document.createElement("ROWSET");
        element.setAttribute("ID", s);
        document.getDocumentElement().appendChild(element);
        for(int i = 0; i < recordset.getRowCount(); i++)
        {
            Element element1 = document.createElement("ROW");
            element.appendChild(element1);
            Element element2 = document.createElement("CAMPO");
            element2.setAttribute("NOMBRE", s1);
            element2.setAttribute("TIPO", "OBJECTO");
            element2.setAttribute("LONGITUD", "50");
            ///// OJO  SUMA DE STRINGS
			org.w3c.dom.Text text = document.createTextNode(recordset.getValueAt(i, s1) != null ? recordset.getValueAt(i, s1).toString()+"x"+recordset.getValueAt(i, s3).toString()  : "");
            element2.appendChild(text);
            element1.appendChild(element2);
            Element element3 = document.createElement("CAMPO");
            element3.setAttribute("NOMBRE", s2);
            element3.setAttribute("TIPO", "OBJECTO");
            element3.setAttribute("LONGITUD", "50");
            org.w3c.dom.Text text1 = document.createTextNode(recordset.getValueAt(i, s2) != null ? recordset.getValueAt(i, s2).toString() : "");
            element3.appendChild(text1);
            element1.appendChild(element3);
            if(s3 != null)
            {
                Element element4 = document.createElement("CAMPO");
                element4.setAttribute("NOMBRE", s3);
                element4.setAttribute("TIPO", "OBJECTO");
                element4.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text2 = document.createTextNode(recordset.getValueAt(i, s3) != null ? recordset.getValueAt(i, s3).toString() : "");
                element4.appendChild(text2);
                element1.appendChild(element4);
            }
            if(s4 != null)
            {
                Element element5 = document.createElement("CAMPO");
                element5.setAttribute("NOMBRE", s4);
                element5.setAttribute("TIPO", "OBJECTO");
                element5.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text3 = document.createTextNode(recordset.getValueAt(i, s4) != null ? recordset.getValueAt(i, s4).toString() : "");
                element5.appendChild(text3);
                element1.appendChild(element5);
            }
            if(s5 != null)
            {
                Element element6 = document.createElement("CAMPO");
                element6.setAttribute("NOMBRE", s4);
                element6.setAttribute("TIPO", "OBJECTO");
                element6.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text4 = document.createTextNode(recordset.getValueAt(i, s5) != null ? recordset.getValueAt(i, s5).toString() : "");
                element6.appendChild(text4);
                element1.appendChild(element6);
            }
            if(s6 != null)
            {
                Element element7 = document.createElement("CAMPO");
                element7.setAttribute("NOMBRE", s6);
                element7.setAttribute("TIPO", "OBJECTO");
                element7.setAttribute("LONGITUD", "50");
                org.w3c.dom.Text text5 = document.createTextNode(recordset.getValueAt(i, s6) != null ? recordset.getValueAt(i, s6).toString() : "");
                element7.appendChild(text5);
                element1.appendChild(element7);
            }
        }

        DruidaConector druidaconector = new DruidaConector();
        druidaconector.setXML(document.getDocumentElement());
        return druidaconector;
    }
	private void cargaComboTipoClien()throws Exception{
		
		ComposerViewElementList cv = crearParametrosEntrada();
        ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
        traza("antes del conector.ejecucion");
        conector.ejecucion();
        traza("antes del conector");
        DruidaConector resultados = conector.getConector();

        traza("antes de asignar al COMBO");
        asignar("COMBO","cbTipoCliente",resultados,"MAEObtenerTipos");      

	}

	private ComposerViewElementList crearParametrosEntrada() throws Exception{
        traza("metodo ComposerViewElementList");
		ComposerViewElementList lista = new ComposerViewElementList();
		//combo codigo configuracion
		ComposerViewElement tipSolicitud = new ComposerViewElement();

        DTOBelcorp dtoBel = new DTOBelcorp();
        traza("antes de asignar al dtobelcorp");
        dtoBel.setOidPais(UtilidadesSession.getPais(this));
        dtoBel.setOidIdioma(UtilidadesSession.getIdioma(this));
        
		tipSolicitud.setIDBusiness("MAEObtenerTipos");
		tipSolicitud.setDTOE(dtoBel);
        
        lista.addViewElement(tipSolicitud);
        return lista;
    }

}
