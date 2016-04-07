import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Date;
import java.text.DateFormat;
import es.indra.sicc.util.DTOOID;
//import es.indra.sicc.dtos.com.DTOProductoComision;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.dtos.com.DTODatosComision;

public class LPMantenimientoProductos extends LPSICCBase {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   
  
	private String oidCanal = null;
	private String oidMarca = null;
	private String codProducto = null;
  
	private String oidMarcaProducto = null;
	private String descMarcaProducto = null;
	private String oidUnidadNegocio = null;
	private String descUnidadNegocio = null;
	private String oidNegocio = null;
	private String descNegocio = null;
	private String oidSupergenerico = null;
	private String descSupergenerico = null;
	private String oidGenerico = null;
	private String descGenerico = null;
	private String oidTipoOferta = null;
	private String descTipoOferta = null;
	private String oidCicloVida = null;
	private String descCicloVida = null;  

	private Long constanteCodigoProducto = null;  

	public LPMantenimientoProductos() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {     
		setTrazaFichero();    
  		traza("************ Entre a LPMantenimientoProductos");
		accion = conectorParametroLimpia("accion", "", true);
 		traza("************ accion:" + accion);
	  
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);
		
		try {			  
			if(accion.equals(""))  { 		
				cargaInicial();
			}
			else if(accion.equals("Anadir")) {  
				pagina("Contenido_comisiones_productos_insertar2");      
				oidCanal = conectorParametroLimpia("varOidCanal", "", true);
				oidMarca = conectorParametroLimpia("varOidMarca", "", true);      
				constanteCodigoProducto = ConstantesCOM.INSERTAR_POR_CODIGO_PRODUCTO;
				asignarAtributo("VAR", "varConstanteCodigoProducto", "valor", constanteCodigoProducto.toString());

				traza("************ varConstanteCodigoProducto:" + constanteCodigoProducto.toString());        
				traza("************ oidCanal:" + oidCanal);
				traza("************ oidMarca:" + oidMarca);
			  
				cargaAnadir(new Long(oidCanal), new Long(oidMarca));				
			}
			else if(accion.equals("AceptarProducto")) {        
				codProducto = conectorParametroLimpia("codProducto", "", true);
				oidTipoOferta = conectorParametroLimpia("oidTipoOferta", "", true);      
				descTipoOferta = conectorParametroLimpia("descTipoOferta", "", true);
				oidCicloVida = conectorParametroLimpia("oidCicloVida", "", true);      
				descCicloVida = conectorParametroLimpia("descCicloVida", "", true);

				if(!(oidTipoOferta.equals("")) && !(oidCicloVida.equals(""))) {
					aceptaProducto(codProducto, new Long(oidTipoOferta), descTipoOferta,
					new Long(oidCicloVida), descCicloVida);       
				}
				else if((oidTipoOferta.equals("")) && !(oidCicloVida.equals(""))) {
					aceptaProducto(codProducto, null, descTipoOferta,
					new Long(oidCicloVida), descCicloVida);       
				}
				else if(!(oidTipoOferta.equals("")) && (oidCicloVida.equals(""))) {
					aceptaProducto(codProducto, new Long(oidTipoOferta), descTipoOferta,
					null, descCicloVida);       
				}
				else if((oidTipoOferta.equals("")) && (oidCicloVida.equals(""))) {
					aceptaProducto(codProducto, null, descTipoOferta,
					null, descCicloVida);       
				}        
			}
			else if(accion.equals("AceptarJerarquia")) {        
				oidMarcaProducto = conectorParametroLimpia("oidMarcaProducto", "", true);
				descMarcaProducto = conectorParametroLimpia("descMarcaProducto", "", true);      
				oidUnidadNegocio = conectorParametroLimpia("oidUnidadNegocio", "", true);
				descUnidadNegocio = conectorParametroLimpia("descUnidadNegocio", "", true);              
				oidNegocio = conectorParametroLimpia("oidNegocio", "", true);        
				descNegocio = conectorParametroLimpia("descNegocio", "", true);        
				oidSupergenerico = conectorParametroLimpia("oidSupergenerico", "", true);              
				descSupergenerico = conectorParametroLimpia("descSupergenerico", "", true);        
				oidGenerico = conectorParametroLimpia("oidGenerico", "", true);              
				descGenerico = conectorParametroLimpia("descGenerico", "", true);        
				oidTipoOferta = conectorParametroLimpia("oidTipoOferta", "", true);
				descTipoOferta = conectorParametroLimpia("descTipoOferta", "", true);              
				oidCicloVida = conectorParametroLimpia("oidCicloVida", "", true);
				descCicloVida = conectorParametroLimpia("descCicloVida", "", true);  

				Long tempOidMarcaProducto;
				Long tempOidUnidadNegocio;
				Long tempOidNegocio;
				Long tempOidSupergenerico;
				Long tempOidGenerico;
				Long tempOidTipoOferta;
				Long tempOidCicloVida;

				if(oidMarcaProducto.equals("")) tempOidMarcaProducto = null;
				else tempOidMarcaProducto = new Long(oidMarcaProducto);

				if(oidUnidadNegocio.equals("")) tempOidUnidadNegocio = null;
				else tempOidUnidadNegocio = new Long(oidUnidadNegocio);

				if(oidNegocio.equals("")) tempOidNegocio = null;
				else tempOidNegocio = new Long(oidNegocio);

				if(oidSupergenerico.equals("")) tempOidSupergenerico = null;
				else tempOidSupergenerico = new Long(oidSupergenerico);

				if(oidGenerico.equals("")) tempOidGenerico = null;
				else tempOidGenerico = new Long(oidGenerico);

				if(oidTipoOferta.equals("")) tempOidTipoOferta = null;
				else tempOidTipoOferta = new Long(oidTipoOferta);

				if(oidCicloVida.equals("")) tempOidCicloVida = null;
				else tempOidCicloVida = new Long(oidCicloVida);		
				
				aceptaJerarquia(tempOidMarcaProducto, descMarcaProducto, 
								tempOidUnidadNegocio, descUnidadNegocio, 
								tempOidNegocio,	descNegocio,
								tempOidSupergenerico, descSupergenerico,
								tempOidGenerico, descGenerico, 
								tempOidTipoOferta, descTipoOferta,
								tempOidCicloVida, descCicloVida);
			}		
			if((accion.equals("")) || (accion.equals("Anadir"))) {
				cargarMenuSecundario();
			}			
		}
		catch(Exception e)  {
			ByteArrayOutputStream pila = new ByteArrayOutputStream();
			PrintStream out = new PrintStream(pila);
			e.printStackTrace(out);
			traza("EL STACK ES COMO SIGUE : " +  pila.toString());
			e.printStackTrace(); 
			e.getMessage();
			lanzarPaginaError(e);
		} 
	}     	
  
	public void cargaInicial()throws Exception {
		/*Carga inicial de la pantalla PaginaProductos. 

		  Proceso 
		  ======== 
		  sesion = getSessionCache() 
		  
		  // Coger el valor de caché 
		  DTODatosComision dtoC = sesion.get(COMISION) 
		  
		  varOidCanal = dtoC.oidCanal 
		  
		  Si dtoC.productos tiene elementos 
		  Se carga la lista lstProductos 
		  Fin del Si 
		  
		  Se crea DTOOID dtoE 
		  dtoE.oid = dtoC.oidMarcaPlantilla 
		  
		  IdNegocio = "COMObtenerMarca" 
		  
		  Se invoca al conector ConectorObtenerMarca 
		  
		  Con el DTOOID de salida (dtoS): 
		  varOidMarca = dtoS.oid  */
      
      
      
      
      
      
      
  }
  
  public void cargaAnadir(Long oidCanal, Long oidMarca) throws Exception {      
     traza("************ Entre a cargaAnadir");    
     
     ComposerViewElementList cv = crearParametrosEntrada();
     traza("************ Antes de crear conector");    
     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
     traza("************ Llamando a ejecucion");         
     conector.ejecucion();
     traza("************ Despues de ejecucion");    
     DruidaConector resultados = conector.getConector();
     traza("************ Despues de llamar a getConector");    
    
     traza("************ Asignando datos");    
     //No existe!!!, por ahora esta hardcodeado en la pantalla
     //asignar("COMBO", "cbInsertar", resultados, "COMTiposInsercionProducto");
     asignar("COMBO", "cbCicloVida2", resultados, "PREObtenerCiclosVida");
     asignar("COMBO", "cbCicloVida3", resultados, "PREObtenerCiclosVida");
     asignar("COMBO", "cbTipoOferta2", resultados, "PREObtenerTiposOfertaComisionablePorCanal");
     asignar("COMBO", "cbTipoOferta3", resultados, "PREObtenerTiposOfertaComisionablePorCanal");
     asignar("COMBO", "cbUnidadNegocio", resultados, "MAEObtenerUnidadesNegocioPorPais");
     asignar("COMBO", "cbNegocio", resultados, "MAEObtenerNegocioPorPais");
     asignar("COMBO", "cbSupergenerico", resultados, "MAEObtenerSuperGenericosPorPais");
     asignar("COMBO", "cbGenerico", resultados, "MAEObtenerGenericosPorPais");
     asignar("COMBO", "cbMarca", resultados, "SEGRecuperarMarcasProductoMP");     
  }
  
   private ComposerViewElementList crearParametrosEntrada() throws Exception{
    traza("************ lIdioma " + lIdioma);    
    traza("************ lPais " + lPais);    
    traza("************ oidCanal " + oidCanal);    
    traza("************ oidMarca " + oidMarca);    
    
    //DTOBelcorp
    DTOBelcorp dtoe = new DTOBelcorp(); 
    dtoe.setOidIdioma(lIdioma);
    dtoe.setOidPais(lPais);
    
    //DTOOID para canal
    DTOOID dtoOidCanal = new DTOOID();
    dtoOidCanal.setOid(new Long(oidCanal));
    dtoOidCanal.setOidIdioma(lIdioma);
    dtoOidCanal.setOidPais(lPais);
    
    //DTOOID para marca
    DTOOID dtoOidMarca = new DTOOID();
    dtoOidMarca.setOid(new Long(oidMarca));
    dtoOidMarca.setOidIdioma(lIdioma);
    dtoOidMarca.setOidPais(lPais);
    
    ComposerViewElementList lista = new ComposerViewElementList(); 
		
    //Primer componente
		//ComposerViewElement cve1 = new ComposerViewElement();
		//cve1.setIDBusiness("COMTiposInsercionProducto");
		//cve1.setDTOE(dtoe);
    
    //Segundo componente
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("PREObtenerCiclosVida");
		cve2.setDTOE(dtoe);
    
    //Tercer componente
		ComposerViewElement cve3 = new ComposerViewElement();
		cve3.setIDBusiness("PREObtenerTiposOfertaComisionablePorCanal");
		cve3.setDTOE(dtoOidCanal);
    
    //Cuarto componente
		ComposerViewElement cve4 = new ComposerViewElement();
		cve4.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
		cve4.setDTOE(dtoe);    
    
    //Quinto componente
		ComposerViewElement cve5 = new ComposerViewElement();
		cve5.setIDBusiness("MAEObtenerNegocioPorPais");
		cve5.setDTOE(dtoe);
    
    //Sexto componente
		ComposerViewElement cve6 = new ComposerViewElement();
		cve6.setIDBusiness("MAEObtenerSuperGenericosPorPais");
		cve6.setDTOE(dtoe);
    
    //Septimo componente
		ComposerViewElement cve7 = new ComposerViewElement();
		cve7.setIDBusiness("MAEObtenerGenericosPorPais");
		cve7.setDTOE(dtoe);
    
    //Octavo componente
		ComposerViewElement cve8 = new ComposerViewElement();
		cve8.setIDBusiness("SEGRecuperarMarcasProductoMP");
		cve8.setDTOE(dtoOidMarca);    
    
	//lista.addViewElement(cve1);
    lista.addViewElement(cve2);
    lista.addViewElement(cve3);
    lista.addViewElement(cve4);
    lista.addViewElement(cve5);
    lista.addViewElement(cve6);
    lista.addViewElement(cve7);
    lista.addViewElement(cve8);
    
		return lista;
	}
  
  public void aceptaProducto(String codProducto, Long oidTipoOferta,
  String descTipoOferta, Long oidCicloVida, String descCicloVida) throws Exception  {
 	  traza("************ Entre a aceptaProducto");    

	   pagina("salidaGenerica");

	  traza("************ codProducto " + codProducto);    
      traza("************ oidTipoOferta " + oidTipoOferta);    
      traza("************ descTipoOferta " + descTipoOferta);    
      traza("************ oidCicloVida " + oidCicloVida);    
      traza("************ descCicloVida " + descCicloVida);    

    /*Inserción de un producto por código de producto. 

      Proceso 
      ======= 
      sesion = getSessionCache() 
      
      // Coger el valor de caché 
      DTODatosComision dtoC = sesion.get(COMISION) 
      
      Se crea un DTOProductoComision dtoPE que se carga: 
      dtoPE.pais = país de la sesión 
      dtoPE.idioma = idioma de la sesión 
      dtoPE.codProducto = codProducto 
      dtoPE.oidTipoOferta = oidTipoOferta 
      dtoPE.descTipoOferta = descTipoOferta 
      dtoPE.oidCicloVida = oidCicloVida 
      dtoPE.descCicloVida = descCicloVida 
      
      IdNegocio = "COMCompletarProducto" 
      
      Se invoca al conector ConectorCompletarProducto 
      
      Con el DTOProductoComision de salida (dtoPS) se añade
      un elemento en el ArrayList dtoC.productos. 
      
      sesion.put(COMISION, dtoC) 
      
      pasarProducto(dtoPS) 
      
      Se cierra la ventana.  */

	/*DTODatosComision dtoDatosComision = (DTODatosComision)this.getSessionCache().get("COMISION");
	if(dtoDatosComision == null) {
		dtoDatosComision = new DTODatosComision();
	}

	DTOProductoComision dtoProductoComision = new DTOProductoComision();
	dtoProductoComision.setOidPais(new Long(sPais));
	dtoProductoComision.setOidIdioma(new Long(sIdioma));
	dtoProductoComision.setCodProducto(codProducto);
	dtoProductoComision.setOidTipoOferta(oidTipoOferta);
	dtoProductoComision.setDescTipoOferta(descTipoOferta);
	dtoProductoComision.setOidCicloVida(oidCicloVida);
	dtoProductoComision.setDescCicloVida(descCicloVida);

	MareBusinessID businessID = new MareBusinessID("COMCompletarProducto");
    Vector parametros = new Vector();     
      
    parametros.add(dtoProductoComision);
    parametros.add(businessID);


	try {
        traza("******************* Entrando al try...");
        traza("******************* Antes de conectar");
        traza("******************* dtoProductoComision " + dtoProductoComision);
        DruidaConector con = conectar("ConectorCompletarProducto", parametros);
		DTOProductoComision dtoProd = (DTOProductoComision)con.objeto("DTOSalida");         
        traza("******************* Despues de conectar");
        traza("******************* dtoProd " + dtoProd);
		ArrayList productos = new ArrayList();
		productos.add(dtoProd);

		dtoDatosComision.setProductos(productos);
		this.getSessionCache().put("COMISION", dtoDatosComision);
		pasarProducto(dtoProd);

        asignarAtributo("VAR","ejecutar","valor","reInicioCodigo()");        
      }
      catch(Exception e) {
        traza("******************* Entrando al catch...");
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");  
        throw e;
	  } */
  }
  
  public void aceptaJerarquia(Long oidMarcaProducto, String descMarcaProducto,
  Long oidUnidadNegocio, String descUnidadNegocio, Long oidNegocio,
  String descNegocio, Long oidSupergenerico, String descSupergenerico,
  Long oidGenerico, String descGenerico, Long oidTipoOferta,
  String descTipoOferta, Long oidCicloVida, String descCicloVida) throws Exception  {
	  traza("************ Entre a aceptaJerarquia");    

	  pagina("salidaGenerica");

	  traza("************ oidMarcaProducto " + oidMarcaProducto);    
      traza("************ descMarcaProducto " + descMarcaProducto);    
      traza("************ oidUnidadNegocio " + oidUnidadNegocio);    
      traza("************ descUnidadNegocio " + descUnidadNegocio);    
      traza("************ oidNegocio " + oidNegocio);    
  	  traza("************ descNegocio " + descNegocio);    
      traza("************ oidSupergenerico " + oidSupergenerico);    
      traza("************ descSupergenerico " + descSupergenerico);  	  
      traza("************ oidGenerico " + oidGenerico);    
      traza("************ descGenerico " + descGenerico);
  	  traza("************ oidTipoOferta " + oidTipoOferta);    
      traza("************ descTipoOferta " + descTipoOferta);    
      traza("************ oidCicloVida " + oidCicloVida);    
      traza("************ descCicloVida " + descCicloVida);    



    /*Inserción de un producto por jerarquía. 

      Proceso 
      ======= 
      sesion = getSessionCache() 
      
      // Coger el valor de caché 
      DTODatosComision dtoC = sesion.get(COMISION) 
      
      Se crea un DTOProductoComision dtoPE que se carga: 
      dtoPE.pais = país de la sesión 
      dtoPE.idioma = idioma de la sesión 
      dtoPE.oidTipoOferta = oidTipoOferta 
      dtoPE.descTipoOferta = descTipoOferta 
      dtoPE.oidCicloVida = oidCicloVida 
      dtoPE.descCicloVida = descCicloVida 
      dtoPE.oidMarcaProducto = oidMarcaProducto 
      dtoPE.descMarcaProducto = descMarcaProducto 
      dtoPE.oidUnidadNegocio = oidUnidadNegocio 
      dtoPE.descUnidadNegocio = descUnidadNegocio 
      dtoPE.oidNegocio = oidNegocio 
      dtoPE.descNegocio = descNegocio 
      dtoPE.oidSupergenerico = oidSupergenerico 
      dtoPE.descSupergenerico = descSupergenerico 
      dtoPE.oidGenerico = oidGenerico 
      dtoPE.descGenerico = descGenerico 
      
      IdNegocio = "COMCompletarProducto" 
      
      Se invoca al conector ConectorCompletarProducto 
      
      Con el DTOProductoComision de salida (dtoPS) se añade
      un elemento en el ArrayList dtoC.productos. 
      
      sesion.put(COMISION, dtoC) 
      
      pasarProducto(dtoPS) 
      
      Se cierra la ventana. */
	
	/*DTODatosComision dtoDatosComision = (DTODatosComision)this.getSessionCache().get("COMISION");
	if(dtoDatosComision == null) {
		dtoDatosComision = new DTODatosComision();
	}

	DTOProductoComision dtoProductoComision = new DTOProductoComision();
	dtoProductoComision.setOidPais(new Long(sPais));
	dtoProductoComision.setOidIdioma(new Long(sIdioma));
	dtoProductoComision.setOidTipoOferta(oidTipoOferta);
	dtoProductoComision.setDescTipoOferta(descTipoOferta);
	dtoProductoComision.setOidCicloVida(oidCicloVida);
	dtoProductoComision.setDescCicloVida(descCicloVida);
	dtoProductoComision.setOidMarcaProducto(oidMarcaProducto);
	dtoProductoComision.setDescMarcaProducto(descMarcaProducto);
	dtoProductoComision.setOidUnidadNegocio(oidUnidadNegocio);
	dtoProductoComision.setDescUnidadNegocio(descUnidadNegocio);
	dtoProductoComision.setOidNegocio(oidNegocio);
	dtoProductoComision.setDescNegocio(descNegocio);
	dtoProductoComision.setOidSupergenerico(oidSupergenerico);
	dtoProductoComision.setDescSupergenerico(descSupergenerico);
	dtoProductoComision.setOidGenerico(oidGenerico);
	dtoProductoComision.setDescGenerico(descGenerico);

	MareBusinessID businessID = new MareBusinessID("COMCompletarProducto");
    Vector parametros = new Vector();     
      
    parametros.add(dtoProductoComision);
    parametros.add(businessID);


	try {
        traza("******************* Entrando al try...");
        traza("******************* Antes de conectar");
        traza("******************* dtoProductoComision " + dtoProductoComision);
        DruidaConector con = conectar("ConectorCompletarProducto", parametros);
		DTOProductoComision dtoProd = (DTOProductoComision)con.objeto("DTOSalida");         
        traza("******************* Despues de conectar");
        traza("******************* dtoProd " + dtoProd);
		ArrayList productos = new ArrayList();
		productos.add(dtoProd);

		dtoDatosComision.setProductos(productos);
		this.getSessionCache().put("COMISION", dtoDatosComision);
		pasarProducto(dtoProd);

        asignarAtributo("VAR","ejecutar","valor","reInicioJerarquia()");        
      }
      catch(Exception e) {
        traza("******************* Entrando al catch...");
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");  
        throw e;
	  }       */
      
  }

  
	//Este metodo describe la funcionalidad que tiene el 
	//javascript de la pantalla modal y la pantalla de la pestaña Productos.
//	public void pasarProducto(DTOProductoComision dto) throws Exception {
    /*Pasa a la pantalla principal el producto añadido. 

      Proceso 
      ======= 
      Se genera una página vacía con una función javascript onLoad(). 
      
      Dentro de esta función onLoad(), se llama al método agregarFila
      de la página padre (PaginaProductos) pasándole como parámetro
      los datos de la fila a añadir. 
      
      Después de llamar a la función se cierra la ventana. */      
//	}
	
	private void cargarMenuSecundario() throws Exception {     
  		traza("************ Entre a cargarMenuSecundario");
  		traza("************ accion " + accion);

		if (accion.equals("Anadir")) {
			getConfiguracionMenu("LPMantenimientoProductos","Anadir");
		}
   }
}