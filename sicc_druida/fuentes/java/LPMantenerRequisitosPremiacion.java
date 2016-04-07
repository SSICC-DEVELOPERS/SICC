import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.cra.DTOPeriodo;
import es.indra.sicc.dtos.edu.DTODruidaBusqueda;
import es.indra.sicc.dtos.inc.DTOConcurso;
import es.indra.sicc.dtos.inc.DTOCursoExigidoPremiacion;
import es.indra.sicc.dtos.inc.DTOCursosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTOParametrosConsultoras;
import es.indra.sicc.dtos.inc.DTOProductoExigidoPremiacion;
import es.indra.sicc.dtos.inc.DTOProductosExigidosPremiacion;
import es.indra.sicc.dtos.inc.DTORequisitosPremiacion;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

public class LPMantenerRequisitosPremiacion extends LPIncentivos {
	//Variables de sesion
	private String sPais = null;     
	public String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;   

	//Variables que se corresponden con campos de la pantalla
	private String oidRequisitosPremiacion = null;
	private String montoMinimoConcurso = null;
	private String numeroPedidos = null;
	private String cuotaMinimaIngreso = null;
	private String pasarPedidosPeriodoPremiacion = null;
	private String montoMinimoPedido = null;
	private String pagoTiempo = null;
	private String diasGracia = null;
	private String periodoDesde = null;
	private String periodoHasta = null;

	//Datos de las modales
	private String lstCursosExigidosPremiacion = null;
	private String listaProductosExigidosPremiacion = null;

	//Variable que se usara para el guardar
	private String datosObligatorios = null;
	
	//Agregado por cambio 20090929

	private String validaDeuda = null;
	private String validaDeudaDescripcion = null;
	private String nroPedidoEspera = null;
	private String periodoMax = null;
	private String periodoMaxDesc = null;
	private String periodoDespacho = null;
	private String baseCalculo = null;
	private String nroPerioEvaluar = null;
	private String periodoHastaParaGral = null;


	//Dtos auxiliares
	private DTOCursosExigidosPremiacion dtoListaCursosExigPremiacionAux = null;
	private DTOProductosExigidosPremiacion dtoListaProductosExigPremiacionAux = null;

	public LPMantenerRequisitosPremiacion() { super(); }

	public void inicio() throws Exception { }  
  
	public void ejecucion() throws Exception {       
		setTrazaFichero();    
	  	traza("************ Entre a LPMantenerRequisitosPremiacion");

		accion = conectorParametroLimpia("accion", "", true);
		opcionMenu = conectorParametroLimpia("opcionMenu", "", true);    

 		traza("************ accion:" + accion);
 		traza("************ opcionMenu:" + opcionMenu);
				
		sPais = UtilidadesSession.getPais(this).toString();
		sIdioma = UtilidadesSession.getIdioma(this).toString();
		sDescPais = UtilidadesSession.getDescripcionPais(this).toString();  	  
		lIdioma = UtilidadesSession.getIdioma(this);
		lPais = UtilidadesSession.getPais(this);

		obtenerFlagsPestanyas();
		
		try {			  
			if(accion.length() < 1)  {
				cargarPantalla();
			}
			else if(accion.equals("cargar cursos exigidos premiacion")) {       
				cargarPantallaCursosExigidosPremiacion();
			}
			else if(accion.equals("cargar productos exigidos premiacion")) {        
				cargarPantallaProductosExigidosPremiacion();
			}
			else if(accion.equals("almacenar")) {           
				almacenar();
				redirigir();
			}
			else if(accion.equals("guardar")) {    
				almacenar();
				guardar();
			}
			else if(accion.equals("redirigir")) {           
				redirigir();
			}
			else if(accion.equals("almacenar cursos exigidos premiacion")) {
				concurso = getConcurso();

				String lstCursosExigidosPremiacion = 
				conectorParametroLimpia("lstCursosExigidosPremiacion", "", true);
				
				pagina("salidaGenerica");
				try {
					almacenarCursosExigidosPremiacion(concurso, lstCursosExigidosPremiacion);					
					asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          
					asignarAtributo("VAR", "cerrarVentana", "valor", "false");
				}
				catch(Exception e) {
					asignarAtributo("VAR", "ejecutarError", "valor", "errorEnAlmacenar()");          
					throw e;
				} 
			}
			else if(accion.equals("almacenar productos exigidos premiacion")) {
				concurso = getConcurso();

				String listaProductosExigidosPremiacion =
				conectorParametroLimpia("listaProductosExigidosPremiacion", "", true);

				pagina("salidaGenerica");
				try {
					almacenarProductosExigidosPremiacion(concurso, listaProductosExigidosPremiacion);			
					asignarAtributo("VAR", "ejecutar", "valor", "reInicio()");          
					asignarAtributo("VAR", "cerrarVentana", "valor", "false");
				}
				catch(Exception e) {
					asignarAtributo("VAR", "ejecutarError", "valor", "errorEnAlmacenar()");          
					throw e;
				} 					
			}
			else if(accion.equals("periodoMaximo")){
				   busquedaPeriodo();
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

	//Este metodo se ejecuta cuando se ingresa a la pestaña
	public void cargarPantalla() throws Exception {
		traza("************ Entre a cargarPantalla");
		pagina("contenido_requisitos_premiacion_mantener");
		getFormatosValidaciones();
		cargarFlagsPestanyas();

		concurso = getConcurso();
		traza("************ concurso " + concurso);

		//**********************************************************************************************
		//Los dtos auxiliares se obtienen del DTOConcurso y se ponen en sesion -- 
		//**********************************************************************************************
		dtoListaCursosExigPremiacionAux = concurso.getListaCursosExigidosPremiacion();
		traza("************ dtoListaCursosExigPremiacionAux " + dtoListaCursosExigPremiacionAux);
		this.getSessionCache().put("DTOCursosExigidosPremiacion", dtoListaCursosExigPremiacionAux);		

		dtoListaProductosExigPremiacionAux = concurso.getListaProductosExigidosPremiacion();
		traza("************ dtoListaProductosExigPremiacionAux " + dtoListaProductosExigPremiacionAux);		
		this.getSessionCache().put("DTOProductosExigidosPremiacion", dtoListaProductosExigPremiacionAux);		
		//**********************************************************************************************
		
		DTOPeriodo dtoPeriodo = new DTOPeriodo();
		dtoPeriodo.setPais(concurso.getOidPais());
		dtoPeriodo.setMarca(concurso.getParamGenerales().getOidMarca());
		dtoPeriodo.setCanal(concurso.getParamGenerales().getOidCanal());
		
		//Agregado por cambio 20090929
		/*DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(lIdioma);*/
		
		ComposerViewElementList lista = new ComposerViewElementList(); 
			
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("CRAObtienePeriodos");
		cve1.setDTOE(dtoPeriodo);
		
		//Agregado por cambio 20090929
		
		/*ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("INCValidaDeuda");
		cve2.setDTOE(dtoBelcorp);*/
		
		lista.addViewElement(cve1);
		//Agregado por cambio 20090929
		//lista.addViewElement(cve2);
		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
          
    
		//Cargando los combos de periodos
		asignar("COMBO", "cbPeriodoDesde", resultados, "CRAObtienePeriodos");
		asignar("COMBO", "cbPeriodoHasta", resultados, "CRAObtienePeriodos");
		//agregado por cambio 20090929		
		try{
				MareBusinessID businessID = new MareBusinessID("CRAObtienePeriodos");
				Vector parametro = new Vector(); 
				parametro.add(dtoPeriodo);
				parametro.add(businessID);
				traza("********** Antes de conectar");
				resultados = new DruidaConector();
				resultados  = conectar("ConectorObtenerDatosPeriodo", parametro);
				traza("7777777777777");
                DTOSalida dtoSalida = (DTOSalida)resultados.objeto("rsSalida");
                RecordSet rs = dtoSalida.getResultado(); 
				Vector vec= new Vector();
				if(!rs.esVacio()){
					for(int i = 0; i <rs.getRowCount(); i++){
						DTOPeriodo periodo = new DTOPeriodo();
						periodo.setOid(new Long(((BigDecimal)rs.getValueAt(i,"OID_PERI")).toString()));
						periodo.setNombre((String)rs.getValueAt(i,"VAL_NOMB_PERI"));
						vec.add(periodo);
					}				
				}
				this.getSessionCache().put("Periodo", vec);

		
		}catch(Exception e){
			  e.printStackTrace();

		}


		
		traza("parametrosConcurso: " + concurso.getParamConsultoras()); 	

		setearVariablesDePantalla();
		
		
	
		//Seteando valores por defecto a los checkbox
		asignarAtributo("CHECKBOX", "ckPasarPedido", "check", "N");
		
		// sapaza -- PER-SiCC-2010-0395 -- 15/07/2010
		asignarAtributo("CHECKBOX", "ckPagoTiempo", "check", "N");
		

		//Si ya habia cargado datos en esta pestaña se mapean a la pagina
		if(concurso.getIndRequisitosPremacion()!=null) {
			if(concurso.getIndRequisitosPremacion().booleanValue()==true) {

				if(concurso.getRequisitosPremiacion().getOidRequisitosPremiacion()!=null) {
					oidRequisitosPremiacion = concurso.getRequisitosPremiacion().getOidRequisitosPremiacion().toString();
				}
				else {
					oidRequisitosPremiacion = new String();
				}					

				if(concurso.getRequisitosPremiacion().getMontoMinimoConcurso()!=null) {
					montoMinimoConcurso = UtilidadesBelcorp.formateaNumeroSICC(concurso.getRequisitosPremiacion().getMontoMinimoConcurso().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				else {
					montoMinimoConcurso = new String();
				}					

				if(concurso.getRequisitosPremiacion().getNumeroPedidos()!=null) {
					numeroPedidos = UtilidadesBelcorp.formateaNumeroSICC(concurso.getRequisitosPremiacion().getNumeroPedidos().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				else {
					numeroPedidos = new String();
				}					

				if(concurso.getRequisitosPremiacion().getCuotaMinimaIngreso()!=null) {
					cuotaMinimaIngreso = UtilidadesBelcorp.formateaNumeroSICC(concurso.getRequisitosPremiacion().getCuotaMinimaIngreso().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				else {
					cuotaMinimaIngreso = new String();
				}					

				if(concurso.getRequisitosPremiacion().getIndPasarPedidoPeriodoPremiacion()!=null) {
					pasarPedidosPeriodoPremiacion = concurso.getRequisitosPremiacion().getIndPasarPedidoPeriodoPremiacion().toString();
				}
				else {
					pasarPedidosPeriodoPremiacion = new String();
				}					
				
				if(concurso.getRequisitosPremiacion().getMontoMinimoPedido()!=null) {
					montoMinimoPedido = UtilidadesBelcorp.formateaNumeroSICC(concurso.getRequisitosPremiacion().getMontoMinimoPedido().toString(), 
					this.FORMATO_DEFAULT, this);
				}
				else {
					montoMinimoPedido = new String();
				}					

				if(concurso.getRequisitosPremiacion().getIndPagoTiempo()!=null) {
					pagoTiempo = concurso.getRequisitosPremiacion().getIndPagoTiempo().toString();
				}
				else {
					pagoTiempo = new String();
				}					

				if(concurso.getRequisitosPremiacion().getDiasGracia()!=null) {
					diasGracia = UtilidadesBelcorp.formateaNumeroSICC(concurso.getRequisitosPremiacion().getDiasGracia().toString(), 
						this.FORMATO_DEFAULT, this);
				}
				else {
					diasGracia = new String();
				}					

				if(concurso.getRequisitosPremiacion().getOidPeriodoDesde()!=null) {
					periodoDesde = concurso.getRequisitosPremiacion().getOidPeriodoDesde().toString();
				}
				else {
					periodoDesde = new String();
				}					

				if(concurso.getRequisitosPremiacion().getOidPeriodoHasta()!=null) {
					periodoHasta = concurso.getRequisitosPremiacion().getOidPeriodoHasta().toString();
				}
				else {
					periodoHasta = new String();
				}
				//Agregado por cambio 20090929
				
				if(concurso.getRequisitosPremiacion().getOidValiDeuda() !=null) {
					validaDeuda = concurso.getRequisitosPremiacion().getOidValiDeuda().toString();
				}
				else {
					validaDeuda = new String();
				}

				if(concurso.getRequisitosPremiacion().getNumeroPerioEspera() !=null) {
					nroPedidoEspera = concurso.getRequisitosPremiacion().getNumeroPerioEspera().toString();
				}
				else {
					nroPedidoEspera = new String();
				}

				if(concurso.getRequisitosPremiacion().getOidPeriodoMax() !=null) {
					periodoMax = concurso.getRequisitosPremiacion().getOidPeriodoMax().toString();
				}
				else {
					periodoMax = new String();
				}
				if(concurso.getRequisitosPremiacion().getPeriodoMaxDescrip() !=null) {
					periodoMaxDesc = concurso.getRequisitosPremiacion().getPeriodoMaxDescrip().toString();
				}
				else {
					periodoMaxDesc = new String();
				}
				if(concurso.getRequisitosPremiacion().getDescripValidaDeuda() != null){
					validaDeudaDescripcion = concurso.getRequisitosPremiacion().getDescripValidaDeuda();
				}else{
					validaDeudaDescripcion = new String(); 
				}


				

				traza("************ oidRequisitosPremiacion " + oidRequisitosPremiacion);
				traza("************ montoMinimoConcurso " + montoMinimoConcurso);
				traza("************ numeroPedidos " + numeroPedidos);
				traza("************ cuotaMinimaIngreso " + cuotaMinimaIngreso);
				traza("************ pasarPedidosPeriodoPremiacion " + pasarPedidosPeriodoPremiacion);
				traza("************ montoMinimoPedido " + montoMinimoPedido);
				traza("************ pagoTiempo " + pagoTiempo);
				traza("************ diasGracia" + diasGracia);
				traza("************ periodoDesde " + periodoDesde);
				traza("************ periodoHasta " + periodoHasta);
				//Agregado por cambio 20090929
				traza("7777777777777 validaDeuda: " + validaDeuda);
				traza("7777777777777 validaDeudaDescripcion: " + validaDeudaDescripcion);
				traza("7777777777777 nroPedidoEspera: " + nroPedidoEspera);
				traza("7777777777777 periodoMax: " + periodoMax);
				traza("7777777777777 periodoMaxDesc: " + periodoMaxDesc);
				


				asignarAtributo("VAR", "oidRequisitosPremiacion", "valor", oidRequisitosPremiacion);
				asignarAtributo("VAR", "montoMinimoConcurso", "valor", montoMinimoConcurso);
				asignarAtributo("VAR", "numeroPedidos", "valor", numeroPedidos);
				asignarAtributo("VAR", "cuotaMinimaIngreso", "valor", cuotaMinimaIngreso);
				asignarAtributo("VAR", "pasarPedidosPeriodoPremiacion", "valor", pasarPedidosPeriodoPremiacion);
				asignarAtributo("VAR", "montoMinimoPedido", "valor", montoMinimoPedido);
				asignarAtributo("VAR", "pagoTiempo", "valor", pagoTiempo);
				asignarAtributo("VAR", "diasGracia", "valor", diasGracia);
				asignarAtributo("VAR", "periodoDesde", "valor", periodoDesde);
				asignarAtributo("VAR", "periodoHasta", "valor", periodoHasta);
				//Agregado por cambio 20090929
				asignarAtributo("VAR", "validaDeuda", "valor", validaDeuda);
				asignarAtributo("VAR", "validaDeudaDescrip", "valor", validaDeudaDescripcion);
				asignarAtributo("VAR", "numPerioEspera", "valor", nroPedidoEspera);
				asignarAtributo("VAR", "perioMax", "valor", periodoMax);
				asignarAtributo("VAR", "perioMaxDes", "valor", periodoMaxDesc);
				

			}
			//Si no se pone en null el indicador de la pestaña
			else {
				concurso.setIndRequisitosPremacion(null);
			}
		}
	}

	//Asigna variables accion y opcionMenu
	private void setearVariablesDePantalla() throws Exception {
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
	}

	//Este metodo se ejecuta cuando se abre la pantalla modal de cursos
	private void cargarPantallaCursosExigidosPremiacion() throws Exception {
		traza("************ Entre a cargarPantallaCursosExigidosPremiacion");
		pagina("contenido_requisitos_premiacion_mantener_cursos");

		concurso = getConcurso();
		traza("************ concurso " + concurso);

		//Carga el combo Tipos curso
		DTODruidaBusqueda dtoe = new DTODruidaBusqueda();
		dtoe.setOidIdioma(concurso.getOidIdioma());
		dtoe.setOidMarca(concurso.getParamGenerales().getOidMarca());

		ComposerViewElementList lista = new ComposerViewElementList(); 
			
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("CMNObtieneTiposCurso");
		cve1.setDTOE(dtoe);
    
    
    traza("a");
		
		lista.addViewElement(cve1);

		ConectorComposerView conector = new ConectorComposerView(lista, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();
    
		asignar("COMBO", "cbCurso", resultados, "CMNObtieneTiposCurso");

		//Despues mapea los datos que habia en sesion a la lista, si es que hay
		DTOCursosExigidosPremiacion dtoCursos = (DTOCursosExigidosPremiacion)this.getSessionCache().get("DTOCursosExigidosPremiacion");
		traza("************ dtoCursos " + dtoCursos);
		if(dtoCursos!=null) {
			ArrayList dtos = dtoCursos.getLstCursosExigidosPremiacion();
			traza("************ dtos " + dtos);

			if(dtos!=null) {
				//Creo el RecordSet que se insertara a la lista
				RecordSet rs = new RecordSet(); 	        
				rs.addColumn(new String("oidCursoExigido"));
				rs.addColumn(new String("tipoCurso"));
				rs.addColumn(new String("oidTipoCurso"));

				for(int i=0; i<dtos.size(); i++) {
					//Tomo cada dto del ArrayList
					DTOCursoExigidoPremiacion dtoTemp = (DTOCursoExigidoPremiacion)dtos.get(i);
					traza("************ i " + i);
					traza("************ dtoTemp " + dtoTemp);
	
					//Obtengo los valores del dto
					Long oidCursoExigido = dtoTemp.getOidCursoExigido();
					Long oidTipoCurso = dtoTemp.getOidTipoCurso();
					String tipoCurso = dtoTemp.getTipoCurso();

					//Los paso a un Vector
					Vector fila = new Vector();
					fila.add(oidCursoExigido);
					fila.add(tipoCurso);
					fila.add(oidTipoCurso);
	
					//Paso el vector al RecordSet
					rs.addRow(fila); 
				}
				traza("************ rs " + rs);
				DruidaConector con = UtilidadesBelcorp.generarConector("ROWSET", rs,rs.getColumnIdentifiers());      
				asignar("LISTADOA", "listado1",con, "ROWSET");
			}		
		}

		setearVariablesDePantalla();
	}

	//Este metodo se ejecuta cuando se abre la pantalla modal de productos
	private void cargarPantallaProductosExigidosPremiacion() throws Exception {
		traza("************ Entre a cargarPantallaProductosExigidosPremiacion");
		pagina("contenido_productos_exigidos_premiacion_mantener");

		concurso = getConcurso();
		traza("************ concurso " + concurso);

		//Primero se cargan los combos de marca, unidad de negocio, negocio
		//supergenerico y generico
		ComposerViewElementList cv = crearParametrosEntrada(concurso);
		ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
		conector.ejecucion();
		DruidaConector resultados = conector.getConector();

		asignar("COMBO", "cbMarca", resultados, "SEGRecuperarMarcasProductoMP");
		asignar("COMBO", "cbUnidadNegocio", resultados, "MAEObtenerUnidadesNegocioPorPais");
		asignar("COMBO", "cbNegocio", resultados, "MAEObtenerNegocioPorPais");
		asignar("COMBO", "cbSupergenerico", resultados, "MAEObtenerSuperGenericosPorPais");
		asignar("COMBO", "cbGenerico", resultados, "MAEObtenerGenericosPorPais");

		//Luego se mapean los datos que habia en sesion a la lista
		DTOProductosExigidosPremiacion dtoProductos = (DTOProductosExigidosPremiacion)this.getSessionCache().get("DTOProductosExigidosPremiacion");

		if(dtoProductos!=null) {
			ArrayList dtos = dtoProductos.getLstProductosExigidosPremiacion();

			if(dtos!=null) {
				//Creo el RecordSet que se insertara a la lista
				RecordSet rs = new RecordSet(); 	        
				rs.addColumn(new String("oidProductoExigido"));
				rs.addColumn(new String("marca"));
				rs.addColumn(new String("unidadNegocio"));
				rs.addColumn(new String("negocio"));
				rs.addColumn(new String("generico"));
				rs.addColumn(new String("superGenerico"));
				rs.addColumn(new String("codigoProducto"));
				rs.addColumn(new String("oidMarca"));
				rs.addColumn(new String("oidUnidadNegocio"));				
				rs.addColumn(new String("oidNegocio"));
				rs.addColumn(new String("oidGenerico"));
				rs.addColumn(new String("oidSuperGenerico"));
				rs.addColumn(new String("oidCodigoProducto"));

				for(int i=0; i<dtos.size(); i++) {
					//Tomo cada dto del ArrayList
					DTOProductoExigidoPremiacion dtoTemp = (DTOProductoExigidoPremiacion)dtos.get(i);

					//Obtengo los valores del dto
					Long oidProductoExigido = dtoTemp.getOidProductoExigido();
					Long oidMarca = dtoTemp.getOidMarca();
					String marca = dtoTemp.getMarca();
					Long oidUnidadNegocio = dtoTemp.getOidUnidadNegocio();
					String unidadNegocio = dtoTemp.getUnidadNegocio();
					Long oidNegocio = dtoTemp.getOidNegocio();
					String negocio = dtoTemp.getNegocio();
					Long oidSuperGenerico = dtoTemp.getOidSuperGenerico();
					String superGenerico = dtoTemp.getSuperGenerico();
					Long oidGenerico = dtoTemp.getOidGenerico();
					String generico = dtoTemp.getGenerico();
					Long oidCodigoProducto = dtoTemp.getOidCodigoProducto();
					String codigoProducto = dtoTemp.getCodigoProducto();

					//Los paso a un Vector
					Vector fila = new Vector();
					fila.add(oidProductoExigido);
					fila.add(marca);
					fila.add(unidadNegocio);
					fila.add(negocio);
					fila.add(generico);
					fila.add(superGenerico);
					fila.add(codigoProducto);					
					fila.add(oidMarca);
					fila.add(oidUnidadNegocio);
					fila.add(oidNegocio);
					fila.add(oidGenerico);
					fila.add(oidSuperGenerico);
					fila.add(oidCodigoProducto);									

					//Paso el vector al RecordSet
					rs.addRow(fila); 
				}

				DruidaConector con = UtilidadesBelcorp.generarConector("ROWSET", rs,rs.getColumnIdentifiers());      
				asignar("LISTADOA", "listado1",con, "ROWSET");
			}	
		}		
		setearVariablesDePantalla();
	}

	//Este metodo realiza la carga inicial cuando se abre la pantalla modal de productos
	private ComposerViewElementList crearParametrosEntrada(DTOConcurso concurso) throws Exception{    
		traza("************ Entre a crearParametrosEntrada");
		//DTOOID
		DTOOID dtoOid = new DTOOID();
		dtoOid.setOidPais(concurso.getOidPais());
		dtoOid.setOidIdioma(concurso.getOidIdioma());
		dtoOid.setOid(concurso.getParamGenerales().getOidMarca());

		//DTOBelcorp
		DTOBelcorp dtoe = new DTOBelcorp(); 
		dtoe.setOidPais(concurso.getOidPais());
		dtoe.setOidIdioma(concurso.getOidIdioma());
    
	    ComposerViewElementList lista = new ComposerViewElementList(); 

		//Primer componente
		ComposerViewElement cve1 = new ComposerViewElement();
		cve1.setIDBusiness("SEGRecuperarMarcasProductoMP");
		cve1.setDTOE(dtoOid);    

		//Segundo componente
		ComposerViewElement cve2 = new ComposerViewElement();
		cve2.setIDBusiness("MAEObtenerUnidadesNegocioPorPais");
		cve2.setDTOE(dtoe);

		//Tercer componente
		ComposerViewElement cve3 = new ComposerViewElement();
		cve3.setIDBusiness("MAEObtenerNegocioPorPais");
		cve3.setDTOE(dtoe);

		//Cuarto componente
		ComposerViewElement cve4 = new ComposerViewElement();
		cve4.setIDBusiness("MAEObtenerSuperGenericosPorPais");
		cve4.setDTOE(dtoe);

		//Quinto componente
		ComposerViewElement cve5 = new ComposerViewElement();
		cve5.setIDBusiness("MAEObtenerGenericosPorPais");
		cve5.setDTOE(dtoe);    
    
		lista.addViewElement(cve1);
		lista.addViewElement(cve2);
	    lista.addViewElement(cve3);
		lista.addViewElement(cve4);
	    lista.addViewElement(cve5);
    
		return lista;
	}

	//Este metodo se ejecuta cuando el usuario pasa de pestaña
	public void almacenar() throws Exception {
		traza("************ Entre a almacenar");

		concurso = getConcurso();
		traza("************ concurso " + concurso);

		//Toma el DTOCursosExigidosPremiacion que hay en sesion y lo setea al DTOConcurso,
		//que tambien esta en sesion
		DTOCursosExigidosPremiacion dtoCursos = (DTOCursosExigidosPremiacion)this.getSessionCache().get("DTOCursosExigidosPremiacion");
		traza("************ dtoCursos " + dtoCursos);
		concurso.setListaCursosExigidosPremiacion(dtoCursos);
		if(dtoCursos!=null) concurso.setIndCursosExigidosPremiacion(new Boolean(true));		

		//Setea un indicador para saber si el usuario ingreso los datos obligatorios de la pestaña
		datosObligatorios = conectorParametroLimpia("datosObligatorios", "", true);
		concurso.setIndObligRequisitosPremiacion(new Boolean(datosObligatorios));

		//Toma variables de la pantalla
		oidRequisitosPremiacion = conectorParametroLimpia("oidRequisitosPremiacion", "", true);
		montoMinimoConcurso = conectorParametroNumero("montoMinimoConcurso",this.FORMATO_DEFAULT);
		numeroPedidos = conectorParametroNumero("numeroPedidos",this.FORMATO_DEFAULT);
		cuotaMinimaIngreso = conectorParametroNumero("cuotaMinimaIngreso",this.FORMATO_DEFAULT);
		pasarPedidosPeriodoPremiacion = conectorParametroLimpia("pasarPedidosPeriodoPremiacion", "", true);

		//Si el indicador pasar pedido periodo premiacion esta chequeado, tomo el 
		//DTOProductosExigidosPremiacion de sesion y se lo asigno al DTOConcurso
		if(pasarPedidosPeriodoPremiacion.equals("S")) {
			traza("************ Entro al if");
			DTOProductosExigidosPremiacion dtoProductos = 
			(DTOProductosExigidosPremiacion) this.getSessionCache().get("DTOProductosExigidosPremiacion");
			traza("************ dtoProductos " + dtoProductos);
			concurso.setListaProductosExigidosPremiacion(dtoProductos);
			if(dtoProductos!=null) concurso.setIndProductosExigidosPremiacion(new Boolean(true));
		}	
		//Si no queda en null
		else {
			traza("************ Entro al else");
			concurso.setListaProductosExigidosPremiacion(null);
			//AGREGADO - CVALENZU - DBLG500000529 - 29/3/2006
			concurso.setIndProductosExigidosPremiacion(new Boolean(false));
			//FIN - AGREGADO - CVALENZU - DBLG500000529 - 29/3/2006
		}

		//Toma el resto de las variables de la pestaña
		montoMinimoPedido = conectorParametroNumero("montoMinimoPedido",this.FORMATO_DEFAULT);
		pagoTiempo = conectorParametroLimpia("pagoTiempo", "", true);
		diasGracia = conectorParametroNumero("diasGracia",this.FORMATO_DEFAULT);
		periodoDesde = conectorParametroLimpia("periodoDesde", "", true);
		periodoHasta = conectorParametroLimpia("periodoHasta", "", true);
		//Agregado por cambio 20090929
		validaDeuda  = conectorParametroLimpia("validaDeuda", "", true);
		validaDeudaDescripcion = conectorParametroLimpia("validaDeudaDescrip", "", true);
 		nroPedidoEspera  = conectorParametroLimpia("numPerioEspera", "", true);
		periodoMax = conectorParametroLimpia("perioMax", "", true);
		periodoMaxDesc = conectorParametroLimpia("perioMaxDes", "", true);
		//fin de lo agregado
		
		traza("************ oidRequisitosPremiacion " + oidRequisitosPremiacion);
		traza("************ montoMinimoConcurso " + montoMinimoConcurso);
		traza("************ numeroPedidos " + numeroPedidos);
		traza("************ cuotaMinimaIngreso " + cuotaMinimaIngreso);
		traza("************ pasarPedidosPeriodoPremiacion " + pasarPedidosPeriodoPremiacion);
		traza("************ montoMinimoPedido " + montoMinimoPedido);
		traza("************ pagoTiempo " + pagoTiempo);
		traza("************ diasGracia" + diasGracia);
		traza("************ periodoDesde " + periodoDesde);
		traza("************ periodoHasta " + periodoHasta);
        //Agregado por cambio 20090929
		traza("************ validaDeuda: " + validaDeuda);
		traza("************ validaDeudaDescripcion: " + validaDeudaDescripcion);
		traza("************ nroPedidoEspera: " + nroPedidoEspera);
		traza("************ periodoMax: " + periodoMax);
		traza("************ periodoMaxDesc: " + periodoMaxDesc);
		//fin de lo agregado
		DTORequisitosPremiacion dtoRequisitos = new DTORequisitosPremiacion();

		if(!oidRequisitosPremiacion.equals(""))
			dtoRequisitos.setOidRequisitosPremiacion(new Long(oidRequisitosPremiacion));

		if(!montoMinimoConcurso.equals(""))
			dtoRequisitos.setMontoMinimoConcurso(new BigDecimal(montoMinimoConcurso));

		if(!numeroPedidos.equals(""))
			dtoRequisitos.setNumeroPedidos(new Integer(numeroPedidos));

		if(!cuotaMinimaIngreso.equals(""))
			dtoRequisitos.setCuotaMinimaIngreso(new Integer(cuotaMinimaIngreso));
		
		if(pasarPedidosPeriodoPremiacion.equals("S")) {
			dtoRequisitos.setIndPasarPedidoPeriodoPremiacion(new Boolean(true));
		}
		else {
			dtoRequisitos.setIndPasarPedidoPeriodoPremiacion(new Boolean(false));
		}
		
		if(!montoMinimoPedido.equals(""))
			dtoRequisitos.setMontoMinimoPedido(new BigDecimal(montoMinimoPedido));
		
		if(pagoTiempo.equals("S")) {
			dtoRequisitos.setIndPagoTiempo(new Boolean(true));
		}
		else {
			dtoRequisitos.setIndPagoTiempo(new Boolean(false));
		}
		
		if(!diasGracia.equals(""))
			dtoRequisitos.setDiasGracia(new Integer(diasGracia));
		
		if(!periodoDesde.equals(""))
			dtoRequisitos.setOidPeriodoDesde(new Long(periodoDesde));
		
		if(!periodoHasta.equals(""))
			dtoRequisitos.setOidPeriodoHasta(new Long(periodoHasta));
		//Agregado por cambio 20090929
		if(!validaDeuda.equals("")){
			dtoRequisitos.setoidValiDeuda(new Long(validaDeuda));
		}	
		if(!nroPedidoEspera.equals("")){
			dtoRequisitos.setNumeroPerioEspera(new Long(nroPedidoEspera));
		}
		if(!periodoMax.equals("")){
			dtoRequisitos.setOidPeriodoMax(new Long(periodoMax));
		}
		if(!periodoMaxDesc.equals("")){
			dtoRequisitos.setPeriodoMaxDescrip(new String(periodoMaxDesc));
		}
		if(!validaDeudaDescripcion.equals("")){
			dtoRequisitos.setDescripValidaDeuda(new String(validaDeudaDescripcion));
		}
		// fin de lo agregado
		concurso.setRequisitosPremiacion(dtoRequisitos);
		concurso.setIndRequisitosPremacion(new Boolean(true));
		traza("************ DTOConcturso FINAL");
		traza("************ concurso " + concurso);
		setConcurso(concurso);
	}

	//Almacena los datos de la pantalla modal cursos exigidos
    private void almacenarCursosExigidosPremiacion(DTOConcurso concurso, String lstCursosExigidosPremiacion) 
		throws Exception {
		traza("************ Entre a almacenarCursosExigidosPremiacion");

		concurso.setIndCursosExigidosPremiacion(new Boolean(true));

		//Primero ponen en null el DTOCursosExigidosPremiacion de sesion
		this.getSessionCache().put("DTOCursosExigidosPremiacion", null);

		//Si hay datos en la lista de la modal, crea un nuevo DTOCursosExigidosPremiacion, lo pone
		//en sesion y se lo pasa al DTOConcurso
		if(!lstCursosExigidosPremiacion.equals("")) {
			int inicio = 1;
			int fin = lstCursosExigidosPremiacion.length()-1;			
			lstCursosExigidosPremiacion = lstCursosExigidosPremiacion.substring(inicio, fin);

			ArrayList listaTemp = new ArrayList();

			StringTokenizer stFilas = new StringTokenizer(lstCursosExigidosPremiacion,"|");		  

			while(stFilas.hasMoreTokens()) {
				String elemento = stFilas.nextToken();
				StringTokenizer stCampos = new StringTokenizer(elemento,",");
				int i = 0;

				DTOCursoExigidoPremiacion dtoTemp = new DTOCursoExigidoPremiacion();

				while(stCampos.hasMoreTokens()) {
					String campo = stCampos.nextToken();

					if(i==0) {
						if(campo.equals(" ")) dtoTemp.setOidCursoExigido(null);
						else dtoTemp.setOidCursoExigido(new Long(campo));
					}

					if(i==1) {
						if(campo.equals(" ")) dtoTemp.setTipoCurso(null);
						else dtoTemp.setTipoCurso(campo);
					}

					if(i==2) {
						if(campo.equals(" ")) dtoTemp.setOidTipoCurso(null);
						else dtoTemp.setOidTipoCurso(new Long(campo));			  
					}

					i++;
				}

				listaTemp.add(dtoTemp);			
			}	

			DTOCursosExigidosPremiacion dtoArraylist = new DTOCursosExigidosPremiacion();
			dtoArraylist.setLstCursosExigidosPremiacion(listaTemp);
			concurso.setListaCursosExigidosPremiacion(dtoArraylist);
			traza("************ TERMINO almacenarCursosExigidosPremiacion");
			traza("************ concurso: " + concurso);
			setConcurso(concurso);
			
			this.getSessionCache().put("DTOCursosExigidosPremiacion", dtoArraylist);
		}
	}

	//Este metodo almacena los datos de la pantalla modal productos exigidos
	private void almacenarProductosExigidosPremiacion(DTOConcurso concurso, String listaProductosExigidosPremiacion) throws Exception {
		traza("************ Entre a almacenarProductosExigidosPremiacion");

		concurso.setIndProductosExigidosPremiacion(new Boolean(true));

		//Primero pone en null el DTOProductosExigidosPremiacion de sesion
		this.getSessionCache().put("DTOProductosExigidosPremiacion", null);		

		//Si hay registros en la lista de la pantalla modal, crea un nuevo
		//DTOProductosExigidosPremiacion, lo pone en sesion y lo setea al DTOConcurso
		if(!listaProductosExigidosPremiacion.equals("")) {
			int inicio = 1;
			int fin = listaProductosExigidosPremiacion.length()-1;			
			listaProductosExigidosPremiacion = listaProductosExigidosPremiacion.substring(inicio, fin);

			ArrayList listaTemp = new ArrayList();

			StringTokenizer stFilas = new StringTokenizer(listaProductosExigidosPremiacion,"|");		  

			while(stFilas.hasMoreTokens()) {
				String elemento = stFilas.nextToken();
				StringTokenizer stCampos = new StringTokenizer(elemento,",");
				int i = 0;

				DTOProductoExigidoPremiacion dtoTemp = new DTOProductoExigidoPremiacion();
	
				while(stCampos.hasMoreTokens()) {
					String campo = stCampos.nextToken();
	
					if(i==0) {
						if(campo.equals(" ")) dtoTemp.setOidProductoExigido(null);
						else dtoTemp.setOidProductoExigido(new Long(campo));
					}

					if(i==1) {
						if(campo.equals(" ")) dtoTemp.setMarca(null);
						else dtoTemp.setMarca(campo);
					}

					if(i==2) {
						if(campo.equals(" ")) dtoTemp.setUnidadNegocio(null);
						else dtoTemp.setUnidadNegocio(campo);			  
					}

					if(i==3) {
						if(campo.equals(" ")) dtoTemp.setNegocio(null);
						else dtoTemp.setNegocio(campo);
					}

					if(i==4) {
						if(campo.equals(" ")) dtoTemp.setGenerico(null);
						else dtoTemp.setGenerico(campo);			  
					}

					if(i==5) {
						if(campo.equals(" ")) dtoTemp.setSuperGenerico(null);
						else dtoTemp.setSuperGenerico(campo);
					}

					if(i==6) {
						if(campo.equals(" ")) dtoTemp.setCodigoProducto(null);
						else dtoTemp.setCodigoProducto(campo);			  
					}

					if(i==7) {
						if(campo.equals(" ")) dtoTemp.setOidMarca(null);
						else dtoTemp.setOidMarca(new Long(campo));
					}

					if(i==8) {
						if(campo.equals(" ")) dtoTemp.setOidUnidadNegocio(null);
						else dtoTemp.setOidUnidadNegocio(new Long(campo));			  
					}

					if(i==9) {
						if(campo.equals(" ")) dtoTemp.setOidNegocio(null);
						else dtoTemp.setOidNegocio(new Long(campo));
					}

					if(i==10) {
						if(campo.equals(" ")) dtoTemp.setOidGenerico(null);
						else dtoTemp.setOidGenerico(new Long(campo));			  
					}

					if(i==11) {
						if(campo.equals(" ")) dtoTemp.setOidSuperGenerico(null);
						else dtoTemp.setOidSuperGenerico(new Long(campo));
					}

					if(i==12) {
						if(campo.equals(" ")) dtoTemp.setOidCodigoProducto(null);
						else dtoTemp.setOidCodigoProducto(new Long(campo));			  
					}

					i++;
				}

				listaTemp.add(dtoTemp);			
			}	

			DTOProductosExigidosPremiacion dtoArraylist = new DTOProductosExigidosPremiacion();
			dtoArraylist.setOidPais(lPais);
			dtoArraylist.setLstProductosExigidosPremiacion(listaTemp);
			concurso.setListaProductosExigidosPremiacion(dtoArraylist);
			traza("************ TERMINO almacenarProductosExigidosPremiacion");
			traza("************ concurso: " + concurso);
			setConcurso(concurso);

			this.getSessionCache().put("DTOProductosExigidosPremiacion", dtoArraylist);		
		}		
	}

	//Este metodo setea la configuracion del menu secundario, titulo y botones
	private void cargarMenuSecundario() throws Exception {     
		if (accion.equals("")) {
			getConfiguracionMenu("LPMantenerRequisitosPremiacion","");    
		}	
		else if (accion.equals("cargar productos exigidos premiacion")) {
			getConfiguracionMenu("LPMantenerRequisitosPremiacion","cargarProductos");		
		}
		else if (accion.equals("cargar cursos exigidos premiacion")) {
			getConfiguracionMenu("LPMantenerRequisitosPremiacion","cargarCursos");		
		}

		if(opcionMenu.equals("Crear concurso")){
			asignarAtributoPagina("cod", "0491");             
	    }
		else if(opcionMenu.equals("Consultar Concurso")){
			asignarAtributoPagina("cod", "0493");
		}
		else if(opcionMenu.equals("Modificar Concurso")){
			asignarAtributoPagina("cod", "0486");
		}
	}
	//Agregado por cambio 20090929
	private void busquedaPeriodo() throws Exception{
			traza("LPMantenimientoRequisitosPremiacion.busquedaPeriodo(): Entrada");
			pagina("salidaGenerica");
			concurso = getConcurso();
			try{
			String opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			
			traza("************ concurso " + concurso);
			String numPerioEspe = conectorParametroLimpia("numPerioEspera", "", true);
			traza("numPerioEspe: " + numPerioEspe);
			Long numPeriEspera = Long.valueOf(numPerioEspe);
			traza("numPeriEspera: " + numPeriEspera);
			Long perioDespa = null;
			Long periodoMaximo = null;
			Long perioHasta = null;
			Long numPerioEva = null;
			String oid = "";
			String des = "";
			DTOParametrosConsultoras dtoParConsultoras = concurso.getParamConsultoras();
		    traza("*********** dtoParConsultoras " + dtoParConsultoras);
			try{
					if(concurso.getParamGralesPremiacion()!=null){
						if(concurso.getParamGralesPremiacion().getOidPeriodo() != null){
							periodoDespacho = concurso.getParamGralesPremiacion().getOidPeriodo().toString();
						}
						else{
							periodoDespacho = new String();
							periodoDespacho = "";
							traza("periodoDespacho: " + periodoDespacho);
						 }
					}else{
							periodoDespacho = new String();
							periodoDespacho = "";
							traza("periodoDespacho: " + periodoDespacho);
					}
					
					if(concurso.getPlantilla().getOidBaseCalculo() != null){
							baseCalculo = concurso.getPlantilla().getOidBaseCalculo().toString();
					}else{
							baseCalculo = new String();
							baseCalculo = "";
							traza("1");
					}
					
					//traza("parametroConsultora: " + concurso.getParamConsultoras());
					if(dtoParConsultoras != null){
						if(dtoParConsultoras.getNroPeriodosEvaluar()!= null){
							nroPerioEvaluar = dtoParConsultoras.getNroPeriodosEvaluar().toString();
						}	
					}else{
							nroPerioEvaluar = new String();
							nroPerioEvaluar = "0";
							traza("2");
					}
					if(concurso.getParamGenerales().getOidPeriodoHasta() != null){
							periodoHastaParaGral = concurso.getParamGenerales().getOidPeriodoHasta().toString();
					}else{
							periodoHastaParaGral = new String(); 
							periodoHastaParaGral="0";
							traza("3");
					}
			}catch(Exception e){
				 e.printStackTrace();
			}
			
            Long periodoContar = null;
            Long numeroPeriodos = null;
			
			if( !periodoDespacho.equals("")){
					perioDespa = Long.valueOf(periodoDespacho);
					//periodoMaximo = perioDespa + numPeriEspera;
					traza("periodoDespacho + numeroPerioEspera:  ");
					
					periodoContar = perioDespa;
					numeroPeriodos = numPeriEspera;
			 }
			 if((periodoDespacho.equals("")) && (baseCalculo.equals("4")) ) {
					perioHasta = Long.valueOf(periodoHastaParaGral);
					numPerioEva = Long.valueOf(nroPerioEvaluar);
					//periodoMaximo = perioHasta + numPerioEva + numPeriEspera;
					traza("perioHasta + numPerioEva + numPerioEspera: ");

					periodoContar = perioHasta;
					numeroPeriodos = numPerioEva + numPeriEspera;
			 }
			 if((periodoDespacho.equals("")) && (!baseCalculo.equals("4")) ){
						perioHasta = Long.valueOf(periodoHastaParaGral);
						//periodoMaximo = perioHasta + numPeriEspera;		
						traza("perioHasta + numPerioEspera: ");

						periodoContar = perioHasta;
						numeroPeriodos = numPeriEspera;
			 }

			Vector parametros = (Vector)this.getSessionCache().get("Periodo");
			int k = 0;
			
			//encontramos el periodo Hasta o periodo Despacho
			for (int i = 0;i < parametros.size(); i++ ) {
				DTOPeriodo per = new DTOPeriodo();
				per = (DTOPeriodo)parametros.get(i);
				
				if(per.getOid().longValue() == periodoContar.longValue()){
					k=i;
					break;
				}
				
			}
			k = k+numeroPeriodos.intValue();
			
			if(k < parametros.size()) {
				DTOPeriodo per = (DTOPeriodo)parametros.get(k);
				oid = per.getOid().toString();
				des = per.getNombre();
				traza("oid: " + oid);
				traza("des: "  + des);
			}
			
			asignarAtributo("VAR", "cerrarVentana", "valor", "false");
			asignarAtributo("VAR", "ejecutar", "valor", "fCargaComboMaximoPeriodo('"+oid+"','"+ des +"');"); 
			}catch(Exception e){
				traza("777777777 Entrando al Catch");
				asignarAtributo("VAR", "ejecutarError", "valor", "fBuscarPeriodoErro()");
				throw e;
			}

			traza("LPMantenimientoRequisitosPremiacion.busquedaPeriodo(): Salida");

	}
}
