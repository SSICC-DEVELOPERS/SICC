import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.com.DTOComisiones;
import es.indra.sicc.dtos.com.DTOComisionesProductos;
import es.indra.sicc.logicanegocio.com.ConstantesCOM;
import es.indra.sicc.logicanegocio.com.ConstantesCOMPestanyas;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenimientoComisionesProductos extends LPComisiones {
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	private String idPestanyaDest;
  
	private String oidPlantilla = null;     
	private String indComparativo = null;     
	private String indTratamientoDif = null;     
	private String oidCanal = null;       //oid del canal
	private String canal = null;          //descripcion del canal
	private String marca = null;  
	private String acceso = null;
	private String periodoDesde = null;
	private String periodoHasta = null;
	private String periodosEspera = null;
	private String incluido = null;
  
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
	private String datosDeLista = null;

	private String lblDescMarcaProducto = null;
	private String lblDescUnidadNegocio = null;
	private String lblDescNegocio = null;
	private String lblDescSupergenerico = null;
	private String lblDescGenerico = null;
	private String lblDescTipoOferta = null;
	private String lblDescCicloVida = null;

	private String descTipoProducto = null;
	private String oidTipoProducto = null;

	private String vieneModificar = null;
    private String tipoInsercion = null;
    private String tipoProducto = null;

	private String oidMarcaTemp = null;
	private String oidUNegocioTemp = null;
	private String oidNegocioTemp = null;
	private String oidSupergenericoTemp = null;
	private String oidGenericoTemp = null;
	private String oidTipoOfertaTemp = null;
	private String oidCicloVidaTemp = null;

	private String oidProductoTemp = null;
	private String lblCodigoProducto = null;

	public LPMantenimientoComisionesProductos() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {       
	    setTrazaFichero();    
  		traza("************ Entre a LPMantenimientoComisionesProductos");

		accion = conectorParametroLimpia("accion", "", true);
		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
		titulo = conectorParametroLimpia("titulo", "", true);
		oidTipoPlantilla = conectorParametroLimpia("oidTipoPlantilla", "", true);
		estadoVentana = conectorParametroLimpia("estadoVentana", "", true);
		
		// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
		String sComisionEscalonada = conectorParametroLimpia("sComisionEscalonada", "", true);

 		traza("************ accion:" + accion);
 		traza("************ opcionMenu:" + opcionMenu);
 		traza("************ titulo:" + titulo);
		traza("************ oidTipoPlantilla:" + oidTipoPlantilla);
		traza("************ estadoVentana:" + estadoVentana);
		
		// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010
		traza("************ sComisionEscalonada:" + sComisionEscalonada);
	  
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);
		
		try {			  
			if(accion.equals(""))  {
				pagina("contenido_comisiones_productos_insertar");
		        asignarAtributo("VAR", "titulo", "valor", titulo);
		        asignarAtributo("VAR", "oidTipoPlantilla", "valor", oidTipoPlantilla);
				asignarAtributo("VAR", "estadoVentana", "valor", estadoVentana);
				
				// sapaza -- PER-SiCC-2010-0478 -- 20/08/2010				
				asignarAtributo("VAR", "sComisionEscalonada", "valor", sComisionEscalonada);
				
				traza("************ Antes de recuperar oid de marca y canal");
				
				oidCanal = conectorParametroLimpia("canalTemp", "", true);
				marca = conectorParametroLimpia("marcaTemp", "", true);
				
				traza("************ oidCanal:" + oidCanal);
				traza("************ marca:" + marca);
				
				asignarAtributo("VAR", "varOidCanal", "valor", oidCanal);
				asignarAtributo("VAR", "varOidMarca", "valor", marca);        
				
				idPestanya = ConstantesCOMPestanyas.PESTANYA_PRODUCTOS;
				cargarPantalla();
			}
			else if(accion.equals("almacenar")) {       
				if(!opcionMenu.equals("consultar")) {
					almacenar();
				}



				idPestanyaDest = conectorParametroLimpia("idPestanyaDest", "", true);
		        redirigir(new Integer(idPestanyaDest));
			}
			else if(accion.equals("guardar")) {           
				almacenar();
				try {      
					traza("************ Llamando al guardar");
					this.guardar();

					if(opcionMenu.equals("insertar")) {
						this.setComision(null);
						conectorAction("LPInsertarComisiones");
					}
					else {
					  // 23192 - dmorello, 30/05/2006: Luego de guardar, corresponde cerrar la ventana modal
					  //asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          
					  asignarAtributo("VAR", "ejecutar", "valor", "window.close();");
					}
				}
				catch(Exception e) {
				  asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");          
				  throw e;
				}        
			}
			else if(accion.equals("Anadir")) {           
				pagina("Contenido_comisiones_productos_insertar2");    
				getFormatosValidaciones();

				oidCanal = conectorParametroLimpia("varOidCanal", "", true);
				oidMarca = conectorParametroLimpia("varOidMarca", "", true);      
				descTipoProducto = conectorParametroLimpia("descTipoProducto", "", true);      

				traza("************ oidCanal:" + oidCanal);
				traza("************ oidMarca:" + oidMarca);
				traza("************ descTipoProducto:" + descTipoProducto);
			  
				cargaAnadir(new Long(oidCanal), new Long(oidMarca));			
			}
			else if(accion.equals("AceptarProducto")) {          
				codProducto = conectorParametroLimpia("codProducto", "", true);
				oidTipoOferta = conectorParametroLimpia("oidTipoOferta", "", true);      
				descTipoOferta = conectorParametroLimpia("descTipoOferta", "", true);
				oidCicloVida = conectorParametroLimpia("oidCicloVida", "", true);      
				descCicloVida = conectorParametroLimpia("descCicloVida", "", true);
				oidTipoProducto = conectorParametroLimpia("oidTipoProducto", "", true);

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
				oidTipoProducto = conectorParametroLimpia("oidTipoProducto", "", true);

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
			else if(accion.equals("excluir")) {          
	  		    pagina("contenido_comisiones_productos_excluir");
				getFormatosValidaciones();

				oidCanal = conectorParametroLimpia("varOidCanal", "", true);
				oidMarca = conectorParametroLimpia("varOidMarca", "", true);      
				descTipoProducto = conectorParametroLimpia("descTipoProducto", "", true);      

				traza("************ oidCanal:" + oidCanal);
				traza("************ oidMarca:" + oidMarca);
				traza("************ descTipoProducto:" + descTipoProducto);

				cargaExcluir(new Long(oidCanal), new Long(oidMarca));
			}
			else if(accion.equals("modificar")) {       
				oidCanal = conectorParametroLimpia("varOidCanal", "", true);
				oidMarca = conectorParametroLimpia("varOidMarca", "", true);      
				descTipoProducto = conectorParametroLimpia("descTipoProducto", "", true);      
				incluido = conectorParametroLimpia("incluido", "", true);      

				traza("************ oidCanal:" + oidCanal);
				traza("************ oidMarca:" + oidMarca);
				traza("************ incluido:" + incluido);
				traza("************ descTipoProducto:" + descTipoProducto);

				if(incluido.equals("true")) {
					pagina("Contenido_comisiones_productos_insertar2");    
					asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
					getFormatosValidaciones();				
					cargaAnadir(new Long(oidCanal), new Long(oidMarca));
				}
				else {
					pagina("contenido_comisiones_productos_excluir");
					asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
					getFormatosValidaciones();
					cargaExcluir(new Long(oidCanal), new Long(oidMarca));
				}
			}

		cargarMenuSecundario();      			
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
  
	public void cargarPantalla() throws Exception {
		traza("************* Entre a cargarPantalla - LPMantenimientoComisionesProductos");
		/*	
		-> DTOComisiones dtoC = getComision() 
		-> PaginaProductos.varOidCanal = dtoC.oidCanal 

		(1) Si dtoC.comisionesProductos tiene elementos 
		-> Se carga la lista lstProductos 
		(1) Fin del Si 

		-> Se crea DTOOID dtoE 
		-> dtoE.oid = dtoC.oidPlantillasComisionesMarca 
		-> IdNegocio = "COMObtenerMarca" 
		-> Se invoca al conector ConectorObtenerMarca 
		-> Con el DTOOID de salida (dtoS): 
		-> PaginaProductos.varOidMarca = dtoS.oid */
		
		DTOComisiones dtoComisiones = this.getComision();
		traza("************* dtoComisiones " + dtoComisiones);

		traza("************ Llamando a verificarDatosComision");
		verificarDatosComision();

		/*Long lCanal = dtoC.getOidCanal();
		traza("************* lCanal " + lCanal.toString());

		asignarAtributo("VAR", "varOidCanal", "valor", lCanal.toString());*/

		if(dtoComisiones.getComisionesProductos()!=null) {	
			traza("************* dtoC.getComisionesProductos() es distinto de null");
			ArrayList productos = dtoComisiones.getComisionesProductos();
			RecordSet rs = new RecordSet();
        
			rs.addColumn(new String("oidtipoproducto"));
		    rs.addColumn(new String("tipoproducto"));
		    rs.addColumn(new String("codigoproducto"));
		    rs.addColumn(new String("tipooferta"));
			rs.addColumn(new String("ciclovida"));
		    rs.addColumn(new String("marca"));
		    rs.addColumn(new String("unidadnegocio"));
		    rs.addColumn(new String("negocio"));
			rs.addColumn(new String("supergenerico"));
		    rs.addColumn(new String("generico"));
		    rs.addColumn(new String("oidtipooferta"));
		    rs.addColumn(new String("oidciclovida"));
			rs.addColumn(new String("oidmarca"));
		    rs.addColumn(new String("oidunidadnegocio"));
		    rs.addColumn(new String("oidnegocio"));
		    rs.addColumn(new String("oidsupergenerico"));
		    rs.addColumn(new String("oidgenerico"));
		    rs.addColumn(new String("oidtipoinsercion"));
		    rs.addColumn(new String("oidproducto"));

  		    for (int i = 0 ; i < productos.size(); i++) {
				DTOComisionesProductos dtoComisionesProductos = (DTOComisionesProductos)productos.get(i);

				traza("************* dtoComisionesProductos " + dtoComisionesProductos);

				Long oidTipoProducto = dtoComisionesProductos.getOidTipoProducto();
				String descTipoProducto = dtoComisionesProductos.getDescTipoProducto();
				String codProducto = dtoComisionesProductos.getCodProducto();
				String descTipoOferta = dtoComisionesProductos.getDescTipoOferta();
				String descCicloVida = dtoComisionesProductos.getDescCicloVida();
				String descMarcaProducto = dtoComisionesProductos.getDescMarcaProducto();
				String descUnidadNegocio = dtoComisionesProductos.getDescUnidadNegocio();
				String descNegocio = dtoComisionesProductos.getDescNegocio();
				String descSupergenerico = dtoComisionesProductos.getDescSupergenerico();
				String descGenerico = dtoComisionesProductos.getDescGenerico();
				Long oidTipoOferta = dtoComisionesProductos.getOidTipoOferta();
				Long oidCicloVida = dtoComisionesProductos.getOidCicloVida();
				Long oidMarcaProducto = dtoComisionesProductos.getOidMarcaProducto();
				Long oidUnidadNegocio = dtoComisionesProductos.getOidUnidadNegocio();
				Long oidNegocio = dtoComisionesProductos.getOidNegocio();
				Long oidSupergenerico = dtoComisionesProductos.getOidSupergenerico();
				Long oidGenerico = dtoComisionesProductos.getOidGenerico();				
				Long oidTipoInsercionProductos = dtoComisionesProductos.getOidTipoInsercionProductos();
				Long oidProducto = dtoComisionesProductos.getOidProducto();

				Vector fila = new Vector();

				fila.add(oidTipoProducto);
				fila.add(descTipoProducto);
				fila.add(codProducto);
				fila.add(descTipoOferta);
				fila.add(descCicloVida);
				fila.add(descMarcaProducto);
				fila.add(descUnidadNegocio);
				fila.add(descNegocio);
				fila.add(descSupergenerico);
				fila.add(descGenerico);
				fila.add(oidTipoOferta);
				fila.add(oidCicloVida);
				fila.add(oidMarcaProducto);
				fila.add(oidUnidadNegocio);
				fila.add(oidNegocio);
				fila.add(oidSupergenerico);
				fila.add(oidGenerico);		
				fila.add(oidTipoInsercionProductos);
				fila.add(oidProducto);

				rs.addRow(fila); 
			}			
		traza("************* Asignando datos a la lista de productos (los que habia ingresado antes)");
		DruidaConector conector = UtilidadesBelcorp.generarConector("ROWSET", rs,rs.getColumnIdentifiers());      
		asignar("LISTADOA", "listado1",conector, "ROWSET");
		}

		MareBusinessID businessID = new MareBusinessID("COMObtenerMarca");
		Vector parametros = new Vector();     
      
		parametros.add(dtoComisiones);
		parametros.add(businessID);

		traza("************* Antes de conectar");
		DruidaConector con = conectar("ConectorObtenerMarca", parametros);
		traza("************* Despues de conectar");

		traza("************* 1");
		DTOOID dtoS = (DTOOID)con.objeto("DTOSalida");     
		traza("************* 2");
		Long lOid = dtoS.getOid();
		traza("************* lOid " + lOid.toString());
		dtoComisiones.setOidPlantillasComisionesMarca(lOid);
		traza("************* Antes de llamar a setComision");    
		this.setComision(dtoComisiones);     
		traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
		DTOComisiones dtoTemp = this.getComision(); 
		traza("************* DTOComisiones " + dtoTemp);        
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	}  
  
	public void almacenar () throws Exception {
		traza("************* Entre a almacenar - LPMantenimientoComisionesProductos");    
    
		pagina("salidaGenerica");
    
		//Se obtiene el DTOComisiones de sesion
		DTOComisiones dtoComisiones = this.getComision(); 
		if(dtoComisiones==null) {
			dtoComisiones = new DTOComisiones();
		}

		traza("************* dtoComisiones " + dtoComisiones);    

		//Seteando marca y canal, se usaran al pasar de pestaña
		if(dtoComisiones.getOidMarca()!=null) {
			marcaTemp = dtoComisiones.getOidMarca().toString();
		}
		if(dtoComisiones.getOidCanal()!=null) {
			canalTemp = dtoComisiones.getOidCanal().toString();
		}		

		//Se obtienen los datos de la lista
		datosDeLista = conectorParametroLimpia("datosDeLista", "", true);	
		
		//Si la lista esta vacia se pasa null al ArrayList comisionesProductos
		if(datosDeLista.equals("null")) {
			traza("************* La lista esta vacia, se pasa null a comisiones productos");    
			dtoComisiones.setComisionesProductos(null);
			traza("************* Antes de llamar a setComision");    
			this.setComision(dtoComisiones); 		
			traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
			DTOComisiones dtoTemp = this.getComision(); 
			traza("************* DTOComisiones " + dtoTemp);        			
		}
		//Si la lista contiene datos, se setean
		else {
			traza("************* La lista tiene datos, se procede a almacenarlos"); 
			traza("************* ... pero antes se setea a null el ArrayList comisiones productos, segun DT"); 
			dtoComisiones.setComisionesProductos(null);
			
			traza("***** ANTES ******** datosDeLista " + datosDeLista);    

			int inicio = 1;
			int fin = datosDeLista.length()-1;
			
			datosDeLista = datosDeLista.substring(inicio, fin);

			traza("***** DESPUES ****** datosDeLista " + datosDeLista);    

			ArrayList comisionesProductos = new ArrayList();

			StringTokenizer stFilas = new StringTokenizer(datosDeLista,"|");
			int cantFilas = stFilas.countTokens();
			traza("************ cantidad de filas " + cantFilas);
		  
			while(stFilas.hasMoreTokens()) {
			  String elemento = stFilas.nextToken();
			  traza("************ elemento: " + elemento);

			  StringTokenizer stCampos = new StringTokenizer(elemento,",");
			  int cantCampos = stCampos.countTokens();
			  traza("************ cantidad de campos " + cantCampos);

			  int i = 0;

  			  DTOComisionesProductos dtoComisionesProductos = new DTOComisionesProductos();

			  while(stCampos.hasMoreTokens()) {
				  String campo = stCampos.nextToken();
				  traza("************ campo: " + campo);
  				  traza("************ i: " + i);

				  //Segun respuesta de incidencia 15810
				  dtoComisionesProductos.setOidComision(dtoComisiones.getOid());

				  if(i==0) {
    				  traza("************ i: 0");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidTipoProducto(null);
					  else dtoComisionesProductos.setOidTipoProducto(new Long(campo));
				  }

				  if(i==1) {
      				  traza("************ i: 1");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescTipoProducto(null);
					  else dtoComisionesProductos.setDescTipoProducto(new String(campo));
				  }

				  if(i==2) {
      				  traza("************ i: 2");
					  if(campo.equals(" ")) dtoComisionesProductos.setCodProducto(null);
					  else dtoComisionesProductos.setCodProducto(new String(campo));			  
				  }

				  if(i==3) {
      				  traza("************ i: 3");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescTipoOferta(null);
					  else dtoComisionesProductos.setDescTipoOferta(new String(campo));				  
				  }

				  if(i==4) {
     				  traza("************ i: 4");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescCicloVida(null);
					  else dtoComisionesProductos.setDescCicloVida(new String(campo));
				  }

				  if(i==5) {
      				  traza("************ i: 5");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescMarcaProducto(null);
					  else dtoComisionesProductos.setDescMarcaProducto(new String(campo));
				  }

				  if(i==6) {
      				  traza("************ i: 6");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescUnidadNegocio(null);
					  else dtoComisionesProductos.setDescUnidadNegocio(new String(campo));
				  }

				  if(i==7) {
      				  traza("************ i: 7");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescNegocio(null);
					  else dtoComisionesProductos.setDescNegocio(new String(campo));
				  }

				  if(i==8) {
      				  traza("************ i: 8");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescSupergenerico(null);
					  else dtoComisionesProductos.setDescSupergenerico(new String(campo));
				  }

				  if(i==9) {
      				  traza("************ i: 9");
					  if(campo.equals(" ")) dtoComisionesProductos.setDescGenerico(null);
					  else dtoComisionesProductos.setDescGenerico(new String(campo));
				  }

				  if(i==10) {
     				  traza("************ i: 10");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidTipoOferta(null);
					  else dtoComisionesProductos.setOidTipoOferta(new Long(campo));
				  }			  

				  if(i==11) {
      				  traza("************ i: 11");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidCicloVida(null);					  
					  else dtoComisionesProductos.setOidCicloVida(new Long(campo));
				  }			 

				  if(i==12) {
      				  traza("************ i: 12");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidMarcaProducto(null);
					  else dtoComisionesProductos.setOidMarcaProducto(new Long(campo));
				  }			 

				  if(i==13) {
      				  traza("************ i: 13");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidUnidadNegocio(null);
					  else dtoComisionesProductos.setOidUnidadNegocio(new Long(campo));
				  }			 

  				  if(i==14) {
      				  traza("************ i: 14");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidNegocio(null);
					  else dtoComisionesProductos.setOidNegocio(new Long(campo));
				  }			 

   				  if(i==15) {
      				  traza("************ i: 15");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidSupergenerico(null);
					  else dtoComisionesProductos.setOidSupergenerico(new Long(campo));
				  }			 

   				  if(i==16) {
      				  traza("************ i: 16");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidGenerico(null);
					  else dtoComisionesProductos.setOidGenerico(new Long(campo));
				  }			 

  				  if(i==17) {
      				  traza("************ i: 17");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidTipoInsercionProductos(null);
					  else dtoComisionesProductos.setOidTipoInsercionProductos(new Long(campo));
				  }			 

   				  if(i==18) {
      				  traza("************ i: 18");
					  if(campo.equals(" ")) dtoComisionesProductos.setOidProducto(null);
					  else dtoComisionesProductos.setOidProducto(new Long(campo));
				  }			 

   				  if(i==19) {
      				  traza("************ i: 19");
					  if(campo.equals(" ")) dtoComisionesProductos.setId(null);
					  else dtoComisionesProductos.setId(new Integer(campo));
				  }		

				  i++;
			  }

			  traza("************* dtoComisionesProductos " + dtoComisionesProductos);        
			  comisionesProductos.add(dtoComisionesProductos);
			}

			dtoComisiones.setComisionesProductos(comisionesProductos);
		
			traza("************* Antes de llamar a setComision");    
			this.setComision(dtoComisiones); 
		
			traza("************* Se guardo el DTOComisiones con la siguiente informacion");    
			DTOComisiones dtoTemp = this.getComision(); 
			traza("************* DTOComisiones " + dtoTemp);       
		}
  }

	public void cargaAnadir(Long oidCanal, Long oidMarca) throws Exception {      
		traza("************ Entre a cargaAnadir");    

		if(descTipoProducto.equals("incluir")) {
			Long inclusion = ConstantesCOM.OID_TIPO_PRODUCTO_INCLUSION;
			asignarAtributo("VAR", "oidTipoProducto", "valor", inclusion.toString());
		}
		else {
			Long exclusion = ConstantesCOM.OID_TIPO_PRODUCTO_EXCLUSION;
			asignarAtributo("VAR", "oidTipoProducto", "valor", exclusion.toString());
		}

		constanteCodigoProducto = ConstantesCOM.INSERTAR_POR_CODIGO_PRODUCTO;
		asignarAtributo("VAR", "varConstanteCodigoProducto", "valor", constanteCodigoProducto.toString());
 		traza("************ varConstanteCodigoProducto:" + constanteCodigoProducto.toString());        
     
		ComposerViewElementList cv = crearParametrosEntrada();
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
    
		traza("************ Asignando datos");    
		asignar("COMBO", "cbInsertar", resultados, "COMTiposInsercionProducto");
		asignar("COMBO", "cbCicloVida2", resultados, "PREObtenerCiclosVida");
		asignar("COMBO", "cbCicloVida3", resultados, "PREObtenerCiclosVida");
		asignar("COMBO", "cbTipoOferta2", resultados, "PREObtenerTiposOfertaComisionablePorCanal");
		asignar("COMBO", "cbTipoOferta3", resultados, "PREObtenerTiposOfertaComisionablePorCanal");
		asignar("COMBO", "cbUnidadNegocio", resultados, "MAEObtenerUnidadesNegocioPorPais");
		asignar("COMBO", "cbNegocio", resultados, "MAEObtenerNegocioPorPais");
		asignar("COMBO", "cbSupergenerico", resultados, "MAEObtenerSuperGenericosPorPais");
		asignar("COMBO", "cbGenerico", resultados, "MAEObtenerGenericosPorPais");
		asignar("COMBO", "cbMarca", resultados, "SEGRecuperarMarcasProductoMP");     

 		oidMarcaTemp = conectorParametroLimpia("oidMarcaTemp", "", true);
		oidUNegocioTemp = conectorParametroLimpia("oidUNegocioTemp", "", true);     
		oidNegocioTemp = conectorParametroLimpia("oidNegocioTemp", "", true);
 		oidSupergenericoTemp = conectorParametroLimpia("oidSupergenericoTemp", "", true);     
		oidGenericoTemp = conectorParametroLimpia("oidGenericoTemp", "", true);
 		oidTipoOfertaTemp = conectorParametroLimpia("oidTipoOfertaTemp", "", true);     
		oidCicloVidaTemp = conectorParametroLimpia("oidCicloVidaTemp", "", true);
		oidProductoTemp = conectorParametroLimpia("oidProductoTemp", "", true);
		lblCodigoProducto = conectorParametroLimpia("lblCodigoProducto", "", true);

		tipoProducto = conectorParametroLimpia("tipoProducto", "", true);
		tipoInsercion = conectorParametroLimpia("tipoInsercion", "", true);

 	  	traza("************ oidMarcaTemp:" + oidMarcaTemp);        
 	  	traza("************ oidUNegocioTemp:" + oidUNegocioTemp);        
 	  	traza("************ oidNegocioTemp:" + oidNegocioTemp);        
 	  	traza("************ oidSupergenericoTemp:" + oidSupergenericoTemp);        
 	  	traza("************ oidGenericoTemp:" + oidGenericoTemp);        
 	  	traza("************ oidTipoOfertaTemp:" + oidTipoOfertaTemp);        
 	  	traza("************ oidCicloVidaTemp:" + oidCicloVidaTemp);           	  	
		traza("************ oidProductoTemp:" + oidProductoTemp);        
   	  	traza("************ lblCodigoProducto:" + lblCodigoProducto);        

		traza("************ tipoProducto:" + tipoProducto);       
   	  	traza("************ tipoInsercion:" + tipoInsercion);        

		asignarAtributo("VAR", "oidMarcaTemp", "valor", oidMarcaTemp);          
		asignarAtributo("VAR", "oidUNegocioTemp", "valor", oidUNegocioTemp);          
		asignarAtributo("VAR", "oidNegocioTemp", "valor", oidNegocioTemp);          
		asignarAtributo("VAR", "oidSupergenericoTemp", "valor", oidSupergenericoTemp);          
		asignarAtributo("VAR", "oidGenericoTemp", "valor", oidGenericoTemp);          
		asignarAtributo("VAR", "oidTipoOfertaTemp", "valor", oidTipoOfertaTemp);          
		asignarAtributo("VAR", "oidCicloVidaTemp", "valor", oidCicloVidaTemp);          
		asignarAtributo("VAR", "oidProductoTemp", "valor", oidProductoTemp);          
		asignarAtributo("VAR", "lblCodigoProducto", "valor", lblCodigoProducto);          

		asignarAtributo("VAR", "tipoProducto", "valor", tipoProducto);          
		asignarAtributo("VAR", "tipoInsercion", "valor", tipoInsercion);      
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
	ComposerViewElement cve1 = new ComposerViewElement();
	cve1.setIDBusiness("COMTiposInsercionProducto");
	cve1.setDTOE(dtoe);
    
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
    
	lista.addViewElement(cve1);
    lista.addViewElement(cve2);
    lista.addViewElement(cve3);
    lista.addViewElement(cve4);
    lista.addViewElement(cve5);
    lista.addViewElement(cve6);
    lista.addViewElement(cve7);
    lista.addViewElement(cve8);
    
		return lista;
	}

	public void cargaExcluir(Long oidCanal, Long oidMarca) throws Exception {
		/* Se mapean los datos del registro seleccionado en el cuadro de cabecera 

		(1) Si se ha pulsado el botón modificar entonces 
		-> Cargar en la cabecera el registro "incluido" y en el marco
		inferior el registro seleccionado y el tipo de inserción en el combo "cmbTipoExclusion" 

		
		(1) Si no entonces 
		-> Se trata una exclusión nueva sobre una inclusión existente, que es
		la seleccionada, entonces se habilita el combo "cmbTipoExclusion" 
		-> Se mantiene invisible el marco inferior hasta que se seleccione un 
		tipo de exclusión. 
		(1) Fin Si 

		// Se queda invisible todo el marco "Productos Excluidos", cuando el
		usuario seleccione el tipo de exclusión se mostrarán aquellos campos
		que corresponda, esto se documenta a los métodos JavaScript de pantalla 

		Se crean los elementos: 

		elem1.idNegocio="COMTiposInsercionProducto" 
		elem1.dtoe=DTOBelcorp 

		elem2.idNegocio="PREObtenerCiclosVida" 
		elem2.dtoe=DTOBelcorp 

		elem3.idNegocio="PREObtenerTiposOfertaComisionablePorCanal" 
		elem3.dtoe=DTOOID (donde DTOOID.oid = oidCanal) 

		elem4.idNegocio="MAEObtenerUnidadesNegocioPorPais" 
		elem4.dtoe=DTOBelcorp 

		elem5.idNegocio="MAEObtenerNegocioPorPais" 
		elem5.dtoe=DTOBelcorp 

		elem6.idNegocio="MAEObtenerSuperGenericosPorPais" 
		elem6.dtoe=DTOBelcorp 

		elem7.idNegocio="MAEObtenerGenericosPorPais" 
		elem7.dtoe=DTOBelcorp 

		elem8.idNegocio="SEGRecuperarMarcasProductoMP" 
		elem8.dtoe=DTOOID (donde DTOOID.oid = oidMarca) 

		Se llama al subsistema GestorCargaPantalla. 

		Con los datos obtenidos en el ROWSET COMTiposInsercionProducto se
		carga la combo cmbInsertarPor 

		Con los datos obtenidos en el ROWSET PREObtenerCiclosVida se cargan
		las combos cmbCicloVida y cmbCicloVidaJ 

		Con los datos obtenidos en el ROWSET PREObtenerTiposOfertaComisionablePorCanal
		se cargan las combos cmbTipoOferta y cmbTipoOfertaJ 

		Con los datos obtenidos en el ROWSET MAEObtenerUnidadesNegocioPorPais se
		carga la combo cmbUnidadNegocio 

		Con los datos obtenidos en el ROWSET MAEObtenerNegocioPorPais se carga
		la combo cmbNegocio 

		Con los datos obtenidos en el ROWSET MAEObtenerSuperGenericosPorPais se
		carga la combo cmbSupergenerico 

		Con los datos obtenidos en el ROWSET MAEObtenerGenericosPorPais se carga
		la combo cmbGenerico 

		Con los datos obtenidos en el ROWSET SEGRecuperarMarcasProductoMP se
		carga la combo cmbMarcaProducto */
		 traza("************ Entre a cargaExcluir");    

	 	 if(descTipoProducto.equals("incluir")) {
			Long inclusion = ConstantesCOM.OID_TIPO_PRODUCTO_INCLUSION;
			asignarAtributo("VAR", "oidTipoProducto", "valor", inclusion.toString());
		 }
		 else {
			Long exclusion = ConstantesCOM.OID_TIPO_PRODUCTO_EXCLUSION;
			asignarAtributo("VAR", "oidTipoProducto", "valor", exclusion.toString());
		 }

 		 vieneModificar = conectorParametroLimpia("vieneModificar", "", true);
 		 traza("************ vieneModificar " + vieneModificar);    
 		 asignarAtributo("VAR", "vieneModificar", "valor", vieneModificar);       

  		 tipoInsercion = conectorParametroLimpia("tipoInsercion", "", true);
 		 traza("************ tipoInsercion " + tipoInsercion);    
 		 asignarAtributo("VAR", "tipoInsercion", "valor", tipoInsercion);   

		 constanteCodigoProducto = ConstantesCOM.INSERTAR_POR_CODIGO_PRODUCTO;
		 asignarAtributo("VAR", "varConstanteCodigoProducto", "valor", constanteCodigoProducto.toString());
	  	 traza("************ varConstanteCodigoProducto:" + constanteCodigoProducto.toString());        
     
	     ComposerViewElementList cv = crearParametrosEntrada();
		 traza("************ Antes de crear conector");    
	     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		 traza("************ Llamando a ejecucion");         
	     conector.ejecucion();
		 traza("************ Despues de ejecucion");    
		  DruidaConector resultados = conector.getConector();
	     traza("************ Despues de llamar a getConector");    
    
	     traza("************ Asignando datos");    
		 asignar("COMBO", "cbInsertar", resultados, "COMTiposInsercionProducto");

	     asignar("COMBO", "cbCicloVidaC", resultados, "PREObtenerCiclosVida");
	     asignar("COMBO", "cbTipoOfertaC", resultados, "PREObtenerTiposOfertaComisionablePorCanal");

		 asignar("COMBO", "cbCicloVidaJ", resultados, "PREObtenerCiclosVida");
	     asignar("COMBO", "cbTipoOfertaJ", resultados, "PREObtenerTiposOfertaComisionablePorCanal");
	     asignar("COMBO", "cbUnidadNegocioJ", resultados, "MAEObtenerUnidadesNegocioPorPais");
		 asignar("COMBO", "cbNegocioJ", resultados, "MAEObtenerNegocioPorPais");
	     asignar("COMBO", "cbSupergenericoJ", resultados, "MAEObtenerSuperGenericosPorPais");
		 asignar("COMBO", "cbGenericoJ", resultados, "MAEObtenerGenericosPorPais");
	     asignar("COMBO", "cbMarcaJ", resultados, "SEGRecuperarMarcasProductoMP"); 

		 lblDescMarcaProducto = conectorParametroLimpia("lblDescMarcaProducto", "", true);
		 lblDescUnidadNegocio = conectorParametroLimpia("lblDescUnidadNegocio", "", true);     
		 lblDescNegocio = conectorParametroLimpia("lblDescNegocio", "", true);
 		 lblDescSupergenerico = conectorParametroLimpia("lblDescSupergenerico", "", true);     
		 lblDescGenerico = conectorParametroLimpia("lblDescGenerico", "", true);
 		 lblDescTipoOferta = conectorParametroLimpia("lblDescTipoOferta", "", true);     
		 lblDescCicloVida = conectorParametroLimpia("lblDescCicloVida", "", true);

 		 oidMarcaTemp = conectorParametroLimpia("oidMarcaTemp", "", true);
		 oidUNegocioTemp = conectorParametroLimpia("oidUNegocioTemp", "", true);     
		 oidNegocioTemp = conectorParametroLimpia("oidNegocioTemp", "", true);
 		 oidSupergenericoTemp = conectorParametroLimpia("oidSupergenericoTemp", "", true);     
		 oidGenericoTemp = conectorParametroLimpia("oidGenericoTemp", "", true);
 		 oidTipoOfertaTemp = conectorParametroLimpia("oidTipoOfertaTemp", "", true);     
		 oidCicloVidaTemp = conectorParametroLimpia("oidCicloVidaTemp", "", true);
		 lblCodigoProducto = conectorParametroLimpia("lblCodigoProducto", "", true);

	  	 traza("************ lblDescMarcaProducto:" + lblDescMarcaProducto);        
 	  	 traza("************ lblDescUnidadNegocio:" + lblDescUnidadNegocio);        
 	  	 traza("************ lblDescNegocio:" + lblDescNegocio);        
 	  	 traza("************ lblDescSupergenerico:" + lblDescSupergenerico);        
 	  	 traza("************ lblDescGenerico:" + lblDescGenerico);        
 	  	 traza("************ lblDescTipoOferta:" + lblDescTipoOferta);        
   	  	 traza("************ lblDescCicloVida:" + lblDescCicloVida);      

 	  	 traza("************ oidMarcaTemp:" + oidMarcaTemp);        
 	  	 traza("************ oidUNegocioTemp:" + oidUNegocioTemp);        
 	  	 traza("************ oidNegocioTemp:" + oidNegocioTemp);        
 	  	 traza("************ oidSupergenericoTemp:" + oidSupergenericoTemp);        
 	  	 traza("************ oidGenericoTemp:" + oidGenericoTemp);        
 	  	 traza("************ oidTipoOfertaTemp:" + oidTipoOfertaTemp);        
   	  	 traza("************ oidCicloVidaTemp:" + oidCicloVidaTemp);      
 		 traza("************ lblCodigoProducto:" + lblCodigoProducto);        

		 if(!vieneModificar.equals("true")) {
	 		 asignarAtributo("LABELC", "lbldtMarca", "valor", lblDescMarcaProducto);          
			 asignarAtributo("LABELC", "lbldtUnidadNegocio", "valor", lblDescUnidadNegocio);          
			 asignarAtributo("LABELC", "lbldtNegocio", "valor", lblDescNegocio);          
			 asignarAtributo("LABELC", "lbldtSupergenerico", "valor", lblDescSupergenerico);          
			 asignarAtributo("LABELC", "lbldtGenerico", "valor", lblDescGenerico);          
			 asignarAtributo("LABELC", "lbldtTipoOferta", "valor", lblDescTipoOferta);          
			 asignarAtributo("LABELC", "lbldtCicloVida", "valor", lblDescCicloVida);          
		 }

		 asignarAtributo("VAR", "oidMarcaTemp", "valor", oidMarcaTemp);          
		 asignarAtributo("VAR", "oidUNegocioTemp", "valor", oidUNegocioTemp);          
		 asignarAtributo("VAR", "oidNegocioTemp", "valor", oidNegocioTemp);          
		 asignarAtributo("VAR", "oidSupergenericoTemp", "valor", oidSupergenericoTemp);          
		 asignarAtributo("VAR", "oidGenericoTemp", "valor", oidGenericoTemp);          
		 asignarAtributo("VAR", "oidTipoOfertaTemp", "valor", oidTipoOfertaTemp);          
		 asignarAtributo("VAR", "oidCicloVidaTemp", "valor", oidCicloVidaTemp);    
		 asignarAtributo("VAR", "lblCodigoProducto", "valor", lblCodigoProducto);      
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
      traza("************ oidTipoProducto " + oidTipoProducto);  

	  /*Coger el valor de caché 
		DTOComisiones dtoC = getComision() 

		Se crea un DTOComisionesProductos dtoPE que se carga: 
		dtoPE.pais = país de la sesión 
		dtoPE.idioma = idioma de la sesión 
		dtoPE.codProducto = codProducto 
		dtoPE.oidTipoOferta = oidTipoOferta 
		dtoPE.descTipoOferta = descTipoOferta 
		dtoPE.oidCicloVida = oidCicloVida 
		dtoPE.descCicloVida = descCicloVida 

		IdNegocio = "COMCompletarProducto" 

		Se invoca al conector ConectorCompletarProducto 
		Con el DTOComisionesProductos de salida (dtoPS) se añade un elemento en el ArrayList dtoC.productos. 
		setComision(dtoC) 
		pasarProducto(dtoPS) 
		Se cierra la ventana. */

	  DTOComisiones dtoC = this.getComision();
	  if(dtoC == null) {
		dtoC = new DTOComisiones();
	  }

	  DTOComisionesProductos dtoPE = new DTOComisionesProductos();
	  dtoPE.setOidPais(new Long(sPais));
	  dtoPE.setOidIdioma(new Long(sIdioma));
	  if(codProducto.equals("")) {
		dtoPE.setCodProducto(null);
	  }
	  else {
		dtoPE.setCodProducto(codProducto);
	  }
	  
	  dtoPE.setOidTipoOferta(oidTipoOferta);
	  dtoPE.setDescTipoOferta(descTipoOferta);
	  dtoPE.setOidCicloVida(oidCicloVida);
	  dtoPE.setDescCicloVida(descCicloVida);
	  dtoPE.setOidTipoProducto(new Long(oidTipoProducto));

	  MareBusinessID businessID = new MareBusinessID("COMCompletarProducto");
      Vector parametros = new Vector();     
      
      parametros.add(dtoPE);
      parametros.add(businessID);

	  try {
		traza("******************* Entrando al try...");
        traza("******************* Antes dtoPE " + dtoPE);
        DruidaConector con = conectar("ConectorCompletarProducto", parametros);
		DTOComisionesProductos dtoPS = (DTOComisionesProductos)con.objeto("DTOSalida");         
        traza("******************* Despus dtoPS " + dtoPS);
		ArrayList productos = new ArrayList();
		productos.add(dtoPS);

		dtoC.setComisionesProductos(productos);
		this.setComision(dtoC);

		//En vez de llamar al metodo pasarProducto(dtoPS);
		//se pasa como parametro el oid y la descripcion del tipo de producto
		//(incluir o excluir)
		String sOidTipo = null;
		Long oidTipo = dtoPS.getOidTipoProducto();
		if(oidTipo!=null) {
			sOidTipo = oidTipo.toString();
		}
		else {
			sOidTipo = "";
		}

		String desTipo = dtoPS.getDescTipoProducto();
		if(desTipo==null) {
			desTipo = "";
		}

		String sOidProducto = null;
		Long oidProducto = dtoPS.getOidProducto();
		if(oidProducto!=null) {
			sOidProducto = oidProducto.toString();
		}
		else {
			sOidProducto = "";
		}

        traza("******************* sOidTipo " + sOidTipo);
        traza("******************* desTipo " + desTipo);
        traza("******************* sOidProducto " + sOidProducto);

        asignarAtributo("VAR","ejecutar","valor","reInicioCodigo('" + 
												  sOidTipo + "', '" + 
												  desTipo + "', '" + 
												  sOidProducto + "')");        
      }
      catch(Exception e) {
        traza("******************* Entrando al catch...");
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");  
        throw e;
	  } 
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
      traza("************ oidTipoProducto " + oidTipoProducto);    


	  /*   // Coger el valor de caché 
			DTOComisiones dtoC = getComision() 

			Se crea un DTOComisionesProductos dtoPE que se carga: 
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
			Con el DTOComisionesProductos de salida (dtoPS) se añade un elemento en el ArrayList dtoC.productos 
			setComision(dtoC) 
			pasarProducto(dtoPS) 
			Se cierra la ventana.  */
	
	  DTOComisiones dtoC = this.getComision();
	  if(dtoC == null) {
		dtoC = new DTOComisiones();
	  }

	  DTOComisionesProductos dtoPE = new DTOComisionesProductos();
	  dtoPE.setOidPais(new Long(sPais));
	  dtoPE.setOidIdioma(new Long(sIdioma));
	  dtoPE.setOidTipoOferta(oidTipoOferta);
	  dtoPE.setDescTipoOferta(descTipoOferta);
	  dtoPE.setOidCicloVida(oidCicloVida);
	  dtoPE.setDescCicloVida(descCicloVida);
	  dtoPE.setOidMarcaProducto(oidMarcaProducto);
	  dtoPE.setDescMarcaProducto(descMarcaProducto);
	  dtoPE.setOidUnidadNegocio(oidUnidadNegocio);
	  dtoPE.setDescUnidadNegocio(descUnidadNegocio);
	  dtoPE.setOidNegocio(oidNegocio);
	  dtoPE.setDescNegocio(descNegocio);
	  dtoPE.setOidSupergenerico(oidSupergenerico);
	  dtoPE.setDescSupergenerico(descSupergenerico);
	  dtoPE.setOidGenerico(oidGenerico);
	  dtoPE.setDescGenerico(descGenerico);
  	  dtoPE.setOidTipoProducto(new Long(oidTipoProducto));

	  MareBusinessID businessID = new MareBusinessID("COMCompletarProducto");
      Vector parametros = new Vector();     
      
      parametros.add(dtoPE);
      parametros.add(businessID);

	  try {
		traza("******************* Entrando al try...");
        traza("******************* Antes dtoPE " + dtoPE);
        DruidaConector con = conectar("ConectorCompletarProducto", parametros);
		DTOComisionesProductos dtoPS = (DTOComisionesProductos)con.objeto("DTOSalida");         
        traza("******************* Despues dtoPS " + dtoPS);
		ArrayList productos = new ArrayList();
		productos.add(dtoPS);

		dtoC.setComisionesProductos(productos);
		this.setComision(dtoC);

		//En vez de llamar al metodo pasarProducto(dtoPS);
		//se pasa como parametro el oid y la descripcion
		//del tipo de insercion
		String sOidTipo = null;
		Long oidTipo = dtoPS.getOidTipoProducto();
		if(oidTipo!=null) {
			sOidTipo = oidTipo.toString();
		}
		else {
			sOidTipo = "";
		}

		String desTipo = dtoPS.getDescTipoProducto();

		if(desTipo==null) {
			desTipo = "";
		}

        traza("******************* sOidTipo " + sOidTipo);
        traza("******************* desTipo " + desTipo);
		asignarAtributo("VAR","ejecutar","valor","reInicioJerarquia('" + sOidTipo + "', '" + desTipo + "')");        
      }
      catch(Exception e) {
        traza("******************* Entrando al catch...");
        asignarAtributo("VAR", "ejecutarError", "valor", "fErrorAlGuardar()");  
        throw e;
	  }      
      
  }

    //Este metodo describe la funcionalidad que tiene el 
    //javascript de la pantalla modal y la pantalla de la pestaña Productos.
	//por eso no se utiliza.
	//public void pasarProducto(DTOProductoComision dto) throws Exception {
    /*Pasa a la pantalla principal el producto añadido. 

      Proceso 
      ======= 
      Se genera una página vacía con una función javascript onLoad(). 
      
      Dentro de esta función onLoad(), se llama al método agregarFila
      de la página padre (PaginaProductos) pasándole como parámetro
      los datos de la fila a añadir. 
      
      Después de llamar a la función se cierra la ventana. */      
	//}

	private void cargarMenuSecundario() throws Exception {     
		traza("************ Entre a cargarMenuSecundario");
	  	traza("************ accion " + accion);
		traza("************ opcionMenu " + opcionMenu);

		if (accion.equals("")) {
			if(opcionMenu.equals("insertar")) {
				getConfiguracionMenu("LPMantenimientoComisionesProductos","");
				asignarAtributoPagina("cod","0515");         
			}
			else if(opcionMenu.equals("consultar")) {
 				getConfiguracionMenu("LPMantenimientoComisionesProductos","consultar");
				if(titulo.equals("EliminarComisiones")) {
					asignarAtributoPagina("cod","0558");         
				}
				else if(titulo.equals("ConsultarComisiones")) {
					asignarAtributoPagina("cod","0510");         
				}
			}
			else if(opcionMenu.equals("modificar")) {
 				getConfiguracionMenu("LPMantenimientoComisionesProductos","modificar");
				asignarAtributoPagina("cod","0520");         
			}
		}
		else if (accion.equals("Anadir")) {
			getConfiguracionMenu("LPMantenimientoProductos","Anadir");
			if(opcionMenu.equals("modificar")) {
				asignarAtributoPagina("cod","0520");  
			}
		}
		else if (accion.equals("excluir")) {
			getConfiguracionMenu("LPMantenimientoComisionesProductos","excluir");
			if(opcionMenu.equals("modificar")) {
				asignarAtributoPagina("cod","0520");  
			}
		}
		else if (accion.equals("modificar")) {
			if(incluido.equals("true")) {
				getConfiguracionMenu("LPMantenimientoProductos","Anadir");
				if(opcionMenu.equals("modificar")) {
					asignarAtributoPagina("cod","0520");  
				}
				if(opcionMenu.equals("consultar")) {
					asignarAtributoPagina("cod","0510");  
				}
			}
			else {
				getConfiguracionMenu("LPMantenimientoComisionesProductos","excluir");
				if(opcionMenu.equals("modificar")) {
					asignarAtributoPagina("cod","0520");  
				}
				if(opcionMenu.equals("consultar")) {
					asignarAtributoPagina("cod","0510");  
				}
			}			
		}		
   }
}