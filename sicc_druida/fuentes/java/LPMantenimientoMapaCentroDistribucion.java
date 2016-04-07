import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionCabecera;
import es.indra.sicc.dtos.ape.DTOMapaCentroDistribucionDetalle;
import es.indra.sicc.dtos.ape.DTOExpandirAnaquel;

public class LPMantenimientoMapaCentroDistribucion extends LPSICCBase {	

    public LPMantenimientoMapaCentroDistribucion () { super(); }

	private String opcionMenu = null;
	private String accion = null;
	private Long pais = null;     
	private Long idioma = null;

	public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
		setTrazaFichero();
		traza("LPMantenimientoMapaCentroDistribucion.ejecucion() - Entrada");

     	opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
     	accion = conectorParametroLimpia("accion", "", true);
	    pais = UtilidadesSession.getPais(this);
		idioma = UtilidadesSession.getIdioma(this);

		traza("**** opcionMenu : " + opcionMenu);
		traza("**** accion : " + accion);
		traza("**** pais : " + pais);
		traza("**** idioma : " + idioma);
	    
		try  {			
			if (accion.equals("") ) {
				cargarPantalla(); 
			}
			else if(accion.equals("expandir")) {
				expandirAnaquel();
			}			
			else if(accion.equals("dividir")) {
				dividirAnaquel();
			}			
			else if(accion.equals("copiar")) {
				copiar();
			}
			else if(accion.equals("crear")) {
				crear();
			}
			else if(accion.equals("mantener")) {
				mantener();
			}
			else if(accion.equals("moverExpandir")) {
				moverExpandir();
			}
			
			cargarMenuSecundario();
			traza("LPMantenimientoMapaCentroDistribucion.ejecucion() - Salida");
		}
		catch ( Exception e )  {			
			//para la internacionalizacion del campo descripcion
			preservaHiddensI18n(new Integer(1), "APE_MAPA_CENTR_DISTR_CABEC", "formulario", "txtDescripcion", false);
			//para la internacionalizacion del campo descripcion

            e.printStackTrace();
			traza("Exception en LPMantenimientoMapaCentroDistribucion");
			traza(e);
			lanzarPaginaError(e);
	    }
	}

	public void cargarPantalla() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.cargarPantalla() - Entrada");

		if (opcionMenu.equals("mantener")) {
			pagina("contenido_mapa_centro_insertar");  
		}
		else if (opcionMenu.equals("copiar")) {
			pagina("contenido_mapa_centro_copiar");  
		}
		else if (opcionMenu.equals("generar")) {
			pagina("contenido_mapa_centro_generar");  
			
			DTOBelcorp dtoe = new DTOBelcorp();
			dtoe.setOidPais(pais);
			dtoe.setOidIdioma(idioma);

			MareBusinessID businessID = new MareBusinessID("APEObtenerProximoCodigoMapaCD");
			Vector parametros = new Vector();
			parametros.add(dtoe);
			parametros.add(businessID);
			traza("*** Llamando a APEObtenerProximoCodigoMapaCD");
			DruidaConector con = conectar("ConectorObtenerProximoCodigoMapaCD", parametros);

			DTOSalida dtoSalida = (DTOSalida)con.objeto("dtoSalida");			
			RecordSet rs = dtoSalida.getResultado();
			if(rs!=null) {
				traza("********  RecordSet" + rs);
				Long codigo = (Long)rs.getValueAt(0,"CODIGOMAPA");
				traza("******** codigo " + codigo);
				asignarAtributo("VAR", "codigoMapa", "valor", codigo.toString());
			}
			else {
				traza("********  RecordSet null");
				asignarAtributo("VAR", "codigoMapa", "valor", "1");
			}			

			asignarAtributo("VAR", "habilitoBotonMantener", "valor", "false");
		}

		if (!opcionMenu.equals("mantener")) {
			//para la internacionalizacion del campo descripcion
			anyadeHiddensI18N(true, "APE_MAPA_CENTR_DISTR_CABEC", null, new Integer(1), "formulario", "txtDescripcion", false);
			//para la internacionalizacion del campo descripcion
		}

		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		this.getFormatosValidaciones();
		cargarCombos();

		traza("LPMantenimientoMapaCentroDistribucion.cargarPantalla() - Salida");
	}    

	private void cargarCombos() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.cargarCombos() - Entrada");
		cargarComboCentroDistribucion();

		if (opcionMenu.equals("mantener")) {
			cargarCombosMarcaCanal();
		}		

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
        dtoBelcorp.setOidIdioma(idioma);
        dtoBelcorp.setOidPais(pais);

		Vector parametros = new Vector();
		parametros.add(dtoBelcorp);
		parametros.add(new MareBusinessID("APEObtenerValoresDefecto"));

		traza("*** antes de conectar para obtener valores por defecto");
		DruidaConector conector2 = conectar("ConectorObtenerValoresDefecto", parametros);
		traza("*** despues de conectar para obtener valores por defecto");

		DTOSalida dtoSalida = (DTOSalida)conector2.objeto("DTOSalida");
		RecordSet rs = dtoSalida.getResultado();
		traza("*** rs: " + rs);

		StringBuffer lineasDef = new StringBuffer();
		int size = rs.getRowCount();
		for (int i = 0; i < size; i++) {
			Object combo = rs.getValueAt(i, "COMBO");
			if (ConstantesAPE.CONFIGURACION_CD.equals(combo)) {
				asignar("VAR", "hOidCentroDistribucionDefecto", rs.getValueAt(i, "OID").toString());
			} else if (ConstantesAPE.LINEA_ARMADO.equals(combo)) {
				lineasDef.append(rs.getValueAt(i, "OID").toString()).append('|');
			}
		}

		// Borro el ultimo pipe, a fin de hacer un split en JavaScript
		int length = lineasDef.length();
		if (length > 0) {
			lineasDef.delete(length-1, length);
		}
		asignar("VAR", "hOidsLineasArmadoDefecto", lineasDef.toString());
	}

	private void cargarComboCentroDistribucion() throws Exception {
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		ComposerViewElementList lista = new ComposerViewElementList();
		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("APEObtenerDescripcionesCD");
		composer1.setDTOE(dtoe);
		lista.addViewElement(composer1);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("*** Llamando a APEObtenerDescripcionesCD");
		conector.ejecucion();
		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbCentroDistribucion", con, "APEObtenerDescripcionesCD");
	}

	private void cargarCombosMarcaCanal() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.cargarCombosMarcaCanal() - Entrada");
		DTOBelcorp dtoe = new DTOBelcorp();
		dtoe.setOidPais(pais);
		dtoe.setOidIdioma(idioma);

		ComposerViewElementList lista = new ComposerViewElementList();

		ComposerViewElement composer1 = new ComposerViewElement();
		composer1.setIDBusiness("SEGObtenerMarcasSinFiltro");
		composer1.setDTOE(dtoe);
		lista.addViewElement(composer1);

		ComposerViewElement composer2 = new ComposerViewElement();
		composer2.setIDBusiness("SEGObtenerCanalesSinFiltro");
		composer2.setDTOE(dtoe);
		lista.addViewElement(composer2);

		ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
		traza("*** Llamando...");
		conector.ejecucion();
		DruidaConector con = conector.getConector();
		asignar("COMBO", "cbMarca", con, "SEGObtenerMarcasSinFiltro");
		asignar("COMBO", "cbCanal", con, "SEGObtenerCanalesSinFiltro");
		traza("LPMantenimientoMapaCentroDistribucion.cargarCombosMarcaCanal() - Salida");
	}	

	public void crear() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.crear() - Entrada");
		pagina("salidaGenerica");

		String oidCentroDistribucion = conectorParametroLimpia("oidCentroDistribucion", "", true);
		traza("******************* oidCentroDistribucion:" + oidCentroDistribucion);

		String codigoMapa = conectorParametroLimpia("codigoMapa", "", true);
		traza("******************* codigoMapa:" + codigoMapa);

		String descripcionMapa = conectorParametroLimpia("descripcionMapa", "", true);
		traza("******************* descripcionMapa:" + descripcionMapa);

		DTOConfiguracionCentroDistribucion centroDistribucion = new DTOConfiguracionCentroDistribucion();
		centroDistribucion.setOidCentroDistribucion(new Long(oidCentroDistribucion));

		DTOMapaCentroDistribucionCabecera mapaCabecera = new DTOMapaCentroDistribucionCabecera();
		mapaCabecera.setCodigoMapa(new Long(codigoMapa));
		mapaCabecera.setDescripcionMapa(descripcionMapa);
		mapaCabecera.setCentroDistribucion(centroDistribucion);
		//para la internacionalizacion del campo descripcion
		mapaCabecera.setAttriTraducible(this.recuperaTraduccionesI18N(new Integer(1)));
		//para la internacionalizacion del campo descripcion

		Vector parametros = new Vector();
		parametros.add(mapaCabecera);
		parametros.add(new MareBusinessID("APEGenerarMapaCentroDistribucion"));

		try {
	        traza("*** ANTES DE APEGenerarMapaCentroDistribucion");
			DruidaConector conector = conectar("ConectorGenerarMapaCentroDistribucion", parametros);
			traza("*** DESPUES DE APEGenerarMapaCentroDistribucion");

			DTOOID dtoOid = (DTOOID)conector.objeto("dtoSalida");
			Long Oid = dtoOid.getOid();
			traza("*** Oid: " + Oid);
			String strOid = new String();
			if(Oid!=null) {
				strOid = Oid.toString();
			}			

			asignarAtributo("VAR","ejecutar","valor","fGenerarOK('" + strOid + "','" + codigoMapa + "')");
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
		    asignarAtributo("VAR","ejecutar","valor","fGenerarERR()");        
			throw e;
		}
	}    

	public void mantener() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.mantener() - Entrada");
		pagina("contenido_mapa_centro_insertar"); 
		cargarComboCentroDistribucion();
		cargarCombosMarcaCanal();

		String hOidMapaGenerado = conectorParametroLimpia("hOidMapaGenerado", "", true);
		String oidCentroDistribucion = conectorParametroLimpia("oidCentroDistribucion", "", true);

		traza("******************* hOidMapaGenerado:" + hOidMapaGenerado);
		traza("******************* oidCentroDistribucion:" + oidCentroDistribucion);
		
		asignar("VAR", "hOidMapaGenerado", hOidMapaGenerado);
		asignar("VAR", "oidCentroDistribucion", oidCentroDistribucion);	

		asignarAtributo("VAR", "hOidMapaGenerado", "valor", hOidMapaGenerado);
		asignarAtributo("VAR", "oidCentroDistribucion", "valor", oidCentroDistribucion);
		asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "pais", "valor", pais.toString());
		asignarAtributo("VAR", "idioma", "valor", idioma.toString());

		this.getFormatosValidaciones();

		traza("LPMantenimientoMapaCentroDistribucion.mantener() - Salida");
	}    

	public void expandirAnaquel() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.expandirAnaquel() - Entrada");
		pagina("salidaGenerica");
		DTOExpandirAnaquel dtoExpandir = new DTOExpandirAnaquel();

		String oidAnaquelDestino = conectorParametroLimpia("oidAnaquelDestino", "", true);
		String capacidad = conectorParametroLimpia("capacidad", "", true);
		String oidsAnaquelesOrigen = conectorParametroLimpia("oidsAnaquelesOrigen", "", true);
		String oidPeriodo = conectorParametroLimpia("oidPeriodo", "", true);

		traza("******************* oidAnaquelDestino:" + oidAnaquelDestino);
		traza("******************* capacidad:" + capacidad);
		traza("******************* oidsAnaquelesOrigen:" + oidsAnaquelesOrigen);
		traza("******************* oidPeriodo:" + oidPeriodo);

 	 	DTOMapaCentroDistribucionDetalle anaquelDestino = new DTOMapaCentroDistribucionDetalle();
		anaquelDestino.setOid(new Long(oidAnaquelDestino));
		anaquelDestino.setCapacidad(new Long(capacidad));

		DTOOIDs anaquelesOrigen = new DTOOIDs();
		anaquelesOrigen.setOids(stringToArray(oidsAnaquelesOrigen));

		dtoExpandir.setAnaquelDestino(anaquelDestino);
		dtoExpandir.setAnaquelesOrigen(anaquelesOrigen);
		dtoExpandir.setOidPeriodo(new Long(oidPeriodo));

		Vector parametros = new Vector();
		parametros.add(dtoExpandir);
		parametros.add(new MareBusinessID("APEExpandirAnaquel"));

		try {
	        traza("*** ANTES DE APEExpandirAnaquel");
			DruidaConector conector = conectar("ConectorExpandirAnaquel", parametros);
			traza("*** DESPUES DE APEExpandirAnaquel");

			DTOExpandirAnaquel dtoRespuesta = (DTOExpandirAnaquel)conector.objeto("dtoSalida");
	        traza("******** dtoRespuesta " + dtoRespuesta);

			String mostrarMensaje = new String();
			if(dtoRespuesta.getMostrarMensaje()!=null) {
				if(dtoRespuesta.getMostrarMensaje().booleanValue()==true) {
					mostrarMensaje = new String("true");
				}
				else {
					mostrarMensaje = new String("false");
				}
			}

			traza("******** mostrarMensaje " + mostrarMensaje);
		    asignarAtributo("VAR","ejecutar","valor","expandirAnaquelOK('" + mostrarMensaje + "')");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
		    asignarAtributo("VAR","ejecutar","valor","expandirAnaquelERR()");        
			throw e;
		}	

		traza("LPMantenimientoMapaCentroDistribucion.expandirAnaquel() - Salida");
	}    

	private Long[] stringToArray(String listaDeOids) throws Exception{
		traza("LPMantenimientoMapaCentroDistribucion.stringToArray() - Entrada");
		traza("************* listaDeOids " + listaDeOids);
		
		StringTokenizer st1 = new StringTokenizer(listaDeOids,"|");
		int cant = st1.countTokens();
		traza("************* cant " + cant);
		Long[] oids = new Long[cant];

        int i = 0;      
        while(st1.hasMoreTokens()) {
          String elementoI = st1.nextToken();
          traza("************ elementoI: " + elementoI);
		  
		  oids[i] = new Long(elementoI);
          i++;
        }

		traza("LPMantenimientoMapaCentroDistribucion.stringToArray() - Salida");
		return oids;
	}

	public void moverExpandir() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.moverExpandir() - Entrada");
		pagina("salidaGenerica");			
		DTOExpandirAnaquel dtoExpandir = new DTOExpandirAnaquel();

		String oidAnaquelDestino = conectorParametroLimpia("oidAnaquelDestino", "", true);
		String capacidad = conectorParametroLimpia("capacidad", "", true);
		String oidsAnaquelesOrigen = conectorParametroLimpia("oidsAnaquelesOrigen", "", true);

		traza("******************* oidAnaquelDestino:" + oidAnaquelDestino);
		traza("******************* capacidad:" + capacidad);
		traza("******************* oidsAnaquelesOrigen:" + oidsAnaquelesOrigen);

 	 	DTOMapaCentroDistribucionDetalle anaquelDestino = new DTOMapaCentroDistribucionDetalle();
		anaquelDestino.setOid(new Long(oidAnaquelDestino));
		anaquelDestino.setCapacidad(new Long(capacidad));

		DTOOIDs anaquelesOrigen = new DTOOIDs();
		anaquelesOrigen.setOids(stringToArray(oidsAnaquelesOrigen));

		dtoExpandir.setAnaquelDestino(anaquelDestino);
		dtoExpandir.setAnaquelesOrigen(anaquelesOrigen);

		Vector parametros = new Vector();
		parametros.add(dtoExpandir);
		parametros.add(new MareBusinessID("APEMoverExpandir"));

		try {
	        traza("*** ANTES DE APEMoverExpandir");
			DruidaConector conector = conectar("ConectorMoverExpandir", parametros);
			traza("*** DESPUES DE APEMoverExpandir");

		    asignarAtributo("VAR","ejecutar","valor","moverExpandirOK()");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
		    asignarAtributo("VAR","ejecutar","valor","moverExpandirERR()");        
			throw e;
		}	

		traza("LPMantenimientoMapaCentroDistribucion.moverExpandir() - Salida");
	}

	public void dividirAnaquel() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.dividirAnaquel() - Entrada");
		pagina("salidaGenerica");
		String oidsAnaqueles = conectorParametroLimpia("oidsAnaqueles", "", true);
		traza("******************* oidsAnaqueles:" + oidsAnaqueles);

		DTOOIDs anaqueles = new DTOOIDs();
		anaqueles.setOids(stringToArray(oidsAnaqueles));

		Vector parametros = new Vector();
		parametros.add(anaqueles);
		parametros.add(new MareBusinessID("APEDividirAnaquel"));

		try {
	        traza("*** ANTES DE APEDividirAnaquel");
			DruidaConector conector = conectar("ConectorDividirAnaquel", parametros);
			traza("*** DESPUES DE APEDividirAnaquel");

		    asignarAtributo("VAR","ejecutar","valor","dividirAnaquelOK()");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
		    asignarAtributo("VAR","ejecutar","valor","dividirAnaquelERR()");        
			throw e;
		}	

		traza("LPMantenimientoMapaCentroDistribucion.dividirAnaquel() - Salida");
	}    

	public void copiar() throws Exception {
		traza("LPMantenimientoMapaCentroDistribucion.copiar() - Entrada");
		pagina("salidaGenerica");	
		
		String oid = conectorParametroLimpia("oid", "", true);
		traza("******************* oid:" + oid);

		DTOMapaCentroDistribucionCabecera dto = new DTOMapaCentroDistribucionCabecera();
		dto.setOid(new Long(oid));
		//para la internacionalizacion del campo descripcion
		dto.setAttriTraducible(this.recuperaTraduccionesI18N(new Integer(1)));
		//para la internacionalizacion del campo descripcion

		Vector parametros = new Vector();
		parametros.add(dto);
		parametros.add(new MareBusinessID("APECopiarMapaCentroDistribucion"));

		try {
	        traza("*** ANTES DE APECopiarMapaCentroDistribucion");
			DruidaConector conector = conectar("ConectorCopiarMapaCentroDistribucion", parametros);
			traza("*** DESPUES DE APECopiarMapaCentroDistribucion");

		    asignarAtributo("VAR","ejecutar","valor","copiarOK()");        
		}
		catch(Exception e) {
			traza("******************* Entrando al catch...");
		    asignarAtributo("VAR","ejecutar","valor","copiarERR()");        
			throw e;
		}	

		traza("LPMantenimientoMapaCentroDistribucion.copiar() - Salida");
	}    
	
	private void cargarMenuSecundario() throws Exception {     
		traza("LPMantenimientoMapaCentroDistribucion.cargarMenuSecundario() - Entrada");		

		if(accion.equals("")) {
			if(opcionMenu.equals("copiar")) {
				getConfiguracionMenu("LPMantenimientoMapaCentroDistribucion","copiar");
			    asignarAtributoPagina("cod","0964");
			}
			else if(opcionMenu.equals("mantener")) {
				getConfiguracionMenu("LPMantenimientoMapaCentroDistribucion","mantener");
			    asignarAtributoPagina("cod","0963");
			}
			else {
				getConfiguracionMenu("LPMantenimientoMapaCentroDistribucion","");
				asignarAtributoPagina("cod","0962");
			}		
		}	
		else if(accion.equals("mantener")) {
			getConfiguracionMenu("LPMantenimientoMapaCentroDistribucion","mantener");
		    asignarAtributoPagina("cod","0963");
		}	

		traza("LPMantenimientoMapaCentroDistribucion.cargarMenuSecundario() - Salida");
	}
}