/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.util.Vector;
import java.util.ArrayList;
import java.util.Iterator;

import es.indra.sicc.util.UtilidadesSession;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.ape.DTOConfiguracionCentroDistribucion;

import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;

public class LPMantenimientoCentroDistribucion extends LPSICCBase {
	
	private String accion = null;
	private String opcionMenu = null;
	private Long pais = null;
	private Long idioma = null;

	public LPMantenimientoCentroDistribucion() {
		super();
	}


	public void inicio() throws Exception {
		

	}
	public void ejecucion() throws Exception {
        rastreo();
        setTrazaFichero();

		try  {	
			traza("LPMantenimientoCentroDistribucion Entrada");

			this.accion = conectorParametroLimpia("accion", "", true);
			this.opcionMenu = conectorParametroLimpia("opcionMenu", "", true);
			this.idioma = UtilidadesSession.getIdioma(this);			
			this.pais = UtilidadesSession.getPais(this);

			traza(" *** accion: " + this.accion + " / opcionMenu: " + this.opcionMenu);
			traza(" *** pais: " + this.pais + " / idioma: " + this.idioma);
					
			if(this.accion.equals("")){
				this.cargarPantalla();
			}
			
			if(this.accion.equals("guardar")){//insertar
				this.guardar();
			}
			
			if(this.accion.equals("detalle")){//consultar o modificar
				this.detalleCentroDistribucion();
			}
			
			this.getFormatosValidaciones();
			traza("LPMantenimientoCentroDistribucion Salida");			
		}catch ( Exception e )  {
			traza("entro en catch LPMantenimientoCentroDistribucion");			
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
	}

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
        preservaHiddensI18n(new Integer(1),"APP_CONFI_CENTR_DISTR","formulario","txtDescripcion", false);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}	
	
	private	void cargarPantalla() throws Exception{
		traza("entro en LPMantenimientoCentroDistribucion.cargarPantalla");			

		if(this.opcionMenu.equals("insertar")){//insertar
			traza("entro en LPMantenimientoCentroDistribucion.cargarPantalla:if");
			pagina("contenido_centro_distribucion_insertar");

			getConfiguracionMenu("LPMantenimientoCentroDistribucion", "insertar");
			asignarAtributoPagina("cod", "ApeConfCentroDistribucion.create.label");
			asignar("VAR", "casoUso", "insertar");

			anyadeHiddensI18N(false, "APP_CONFI_CENTR_DISTR", null, new Integer(1), "formulario", "txtDescripcion", false);	
			this.cargarCmbInsertar();

		} else {
			traza("entro en LPMantenimientoCentroDistribucion.cargarPantalla:else");

			pagina("contenido_centro_distribucion_buscar");

			traza("se evalua que caso de uso es: -" + opcionMenu +"-");

			if (this.opcionMenu.equals("eliminar")) {
				getConfiguracionMenu("LPMantenimientoCentroDistribucion", "eliminar");
				asignarAtributoPagina("cod", "ApeConfCentroDistribucion.remove.label");
				asignar("VAR", "casoUso", "eliminar");
			} else if (this.opcionMenu.equals("modificar")) {
				getConfiguracionMenu("LPMantenimientoCentroDistribucion", "consultar");
				asignarAtributoPagina("cod", "ApeConfCentroDistribucion.update.label");
				asignar("VAR", "casoUso", "modificar");
			} else {//consultar
				getConfiguracionMenu("LPMantenimientoCentroDistribucion", "consultar");
				asignarAtributoPagina("cod", "ApeConfCentroDistribucion.query.label");
				asignar("VAR", "casoUso", "consultar");
			}
			
			this.cargarCmbConsultar();
		}
	}

	private void guardar() throws Exception{
		traza("LPMantenimientoCentroDistribucion.guardar Entrada");
		
		pagina("salidaGenerica");

		anyadeHiddensI18N(false, "APP_CONFI_CENTR_DISTR", null, new Integer(1),"formulario", "txtDescripcion", false);
        Vector inter = recuperaTraduccionesI18N(new Integer(1));

        if (this.opcionMenu.equals("insertar")) {
            inter = quitarTraduccionesEnBlanco(inter);
        }
        
		for (int i=0; i<inter.size(); i++){	
		
			DTOI18nSICC dtoTemp = (DTOI18nSICC) inter.elementAt(i);
			traza("idioma " + dtoTemp.getOidIdioma());
		}


		DTOConfiguracionCentroDistribucion dtoCD = new DTOConfiguracionCentroDistribucion();

		String parametro=conectorParametroLimpia("hOidCentroDistribucion", "", true);
		if(!parametro.equals("")){
			dtoCD.setOidCentroDistribucion(new Long(parametro));
		}

		dtoCD.setDescripcion(conectorParametroLimpia("txtDescripcion", "", true));

		parametro=conectorParametroLimpia("chkCentroDefault", "", true);
		if(!parametro.equals("")){
			if(parametro.equals("S")){
				dtoCD.setValorDefecto(Boolean.TRUE);
			}else{
				dtoCD.setValorDefecto(Boolean.FALSE);
			}												
		}			

		dtoCD.setNivelOutsourcing(conectorParametroLimpia("cbNivelOursourcing", "", true));
		//dtoCD.setImprimirListaPicado(conectorParametroLimpia("chkImprimirListasPicado", "", true));
        
		// Inicio Agrega Inc. BELC400000417 eiraola

		// Inc. BELC400000478 - Gpons
		String ordenPedidoPicado = conectorParametroLimpia("cbOrdenListaPicado", "", true);
		String ordenAscDesc = conectorParametroLimpia("cbOrden", "", true);
		if(!ordenPedidoPicado.equals("")){
			dtoCD.setOrdenPedidoPicado(new Long(ordenPedidoPicado));
		}
		if(!ordenAscDesc.equals("")){
			dtoCD.setOrdenAscDesc(new Long(ordenAscDesc));
		}
		// Fin BELC400000478 - Gpons

		dtoCD.setTextoChequeos(conectorParametroLimpia("txtChequeoListaPicado", "", true));
		dtoCD.setTextoPrimerPedido(conectorParametroLimpia("txtPrimeroPicado", "", true));
		dtoCD.setAgrupacionDefaultAFP(new Long(conectorParametroLimpia("cbAgrupacionParaAFP", "", true)));
		// Fin Agrega Inc. BELC400000417 eiraola
		// Agregado por cambio 20090839
		String impresionesDatosBasicos = conectorParametroLimpia("chkImpresionDatosBC","", true);
		if(impresionesDatosBasicos.equals("S")){
			dtoCD.setImpresionDatosbasicos(new Long(1));
		}else{
			dtoCD.setImpresionDatosbasicos(new Long(0));
		}
		dtoCD.setOidOredenVisulaChequeo(new Long(conectorParametroLimpia("cbCodigoVisualChequeo","", true)));
        String orden = conectorParametroLimpia("RBOreden", "", true);
		traza("orden: " + orden);
		if(orden.equals("A")){
			dtoCD.setOredenVisual("A");
		}else{
			dtoCD.setOredenVisual("D");
		}

		dtoCD.setOidPais(this.pais);
		dtoCD.setOidIdioma(this.idioma); // BELC400000198 - dmorello, 07/03/2007

		dtoCD.setAttTraducible(inter);

		traza("dto ---- " + dtoCD);

		asignar("VAR", "ejecutar", "bienGuardado()");
		asignar("VAR", "ejecutarError", "malGuardado()");

		Vector paramConector = new Vector();			
		paramConector.add(dtoCD);
		paramConector.add(new MareBusinessID("APEGuardarCentroDistribucion"));           
		DruidaConector conector = conectar("ConectorGuardarCentroDistribucion", paramConector);							
		preservaHiddensI18n(new Integer(1), "APP_CONFI_CENTR_DISTR", "formulario", "txtDescripcion", false);

		traza("LPMantenimientoCentroDistribucion.guardar Salida");
	}

	private void cargarCmbInsertar() throws Exception{
		traza("entro en LPMantenimientoCentroDistribucion.cargarCmbInsertar");

		asignar("VAR", "hPais", this.pais.toString());
		asignar("VAR", "hIdioma", this.idioma.toString());
		asignar("VAR", "opcionMenu", this.opcionMenu);
		asignar("VAR", "accion", this.accion);

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidPais(this.pais);
		dtoBelcorp.setOidIdioma(this.idioma);

		traza("antes de Druida conector2");

		String[] idBusiness = new String[] {"APECentroDistribucionOutSourcing", 
                                            "APEObtenerOrdenListaPicado",
                                            "APEObtenerOrdenacionProductos",
                                            "APEObtenerAgrupacionAFP",
											"APECodigoVisualizacionChequeo" 	
                                           };
		String[] comboBox = new String[] {"cbNivelOursourcing", 
                                          "cbOrdenListaPicado",
                                          "cbOrden",
                                          "cbAgrupacionParaAFP",
										  "cbCodigoVisualChequeo"	
                                         };

		this.cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);

		traza("salio en LPMantenimientoCentroDistribucion.cargarCmbInsertar");
	}

	private void cargarCmbConsultar() throws Exception {

		asignar("VAR", "hPais", this.pais.toString());
		asignar("VAR", "hIdioma", this.idioma.toString());
		asignar("VAR", "opcionMenu", this.opcionMenu);
		asignar("VAR", "accion", this.accion);

		DTOBelcorp dtoBelcorp = new DTOBelcorp();
		dtoBelcorp.setOidIdioma(this.idioma);
		dtoBelcorp.setOidPais(this.pais);

		String[] idBusiness = new String[] {"APEObtenerCodigoCentrosDistribucion","APEObtenerDescripcionesCD"};
		String[] comboBox = new String[] {"cbCentroDistribucion","cbDescripcion"};

		this.cargarCombos(dtoBelcorp, idBusiness, comboBox, null, null);
	}

	private void detalleCentroDistribucion() throws Exception {

		String oidCentroDistribucion = conectorParametroLimpia("oid", "", true);
		String txtCodigo = conectorParametroLimpia("codigo", "", true);
		String txtDescripcion = conectorParametroLimpia("descripcion", "", true);
		String chkCentroDefault = conectorParametroLimpia("ckdef", "", true);
		String oidNivelOutsourcing = conectorParametroLimpia("outsourcing", "", true);
		String oidOrdenListaPicado = conectorParametroLimpia("ordenListaPicado", "", true);
		String oidOrdenProducto = conectorParametroLimpia("ordenAscDesc", "", true);
		String textoChequeo = conectorParametroLimpia("textoChequeo", "", true);
		String textoPrimerPedido = conectorParametroLimpia("textoPrimPedido", "", true);
		String oidAgrupacionAFP = conectorParametroLimpia("agrupacionAFP", "", true);
        //Agregado por cambio 20090839
		String impresionesDatosBC = conectorParametroLimpia("impresionDatosBc", "", true); 
		String oidCodigoVisualChequeo = conectorParametroLimpia("oidVisualChequeo","",true);
		String codigoVisualChequeo = conectorParametroLimpia("CodigoVisualChequeo","", true);
		String ordenVisualCheque = conectorParametroLimpia("ordenVisualCheque","", true);
        
		pagina("contenido_centro_distribucion_insertar");
		cargarCmbInsertar();

		traza("oid: " + oidCentroDistribucion);
		traza("codigo: " + txtCodigo);
		traza("descripcion: " + txtDescripcion);
		traza("ckdef: " + chkCentroDefault);
		traza("nivel: " + oidNivelOutsourcing);
        traza("ordenListaPicad: " + oidOrdenListaPicado);
		traza("ordenProducto: " + oidOrdenProducto);
		traza("textoChequeo: " + textoChequeo);
		traza("textoPrimPedi: " + textoPrimerPedido);
		traza("agrupacAFP: " + oidAgrupacionAFP);
  	    traza("impresionesDatosBC: " + impresionesDatosBC);
		traza("oidCodigoVisualChequeo: " + oidCodigoVisualChequeo);
		traza("codigoVisualChequeo: " + codigoVisualChequeo);
		traza("ordenVisualCheque: " + ordenVisualCheque);
        
        // Valores ocultos para seleccionar valor en combo, y para fLimpiar de 'modificar'
		asignar("VAR", "hOidCentroDistribucion", oidCentroDistribucion);
        asignar("VAR", "hDescripcionCD", txtDescripcion);
		asignar("VAR", "hDefault", chkCentroDefault);
		asignar("VAR", "hOutsourcing", oidNivelOutsourcing);
        asignar("VAR", "hOrdenListaPicado", oidOrdenListaPicado);
        asignar("VAR", "hOrden", oidOrdenProducto);
        asignar("VAR", "hTextoChequeoListaPicado", textoChequeo);
        asignar("VAR", "hTextoPrimeroPicado", textoPrimerPedido);
        asignar("VAR", "hAgrupacionParaAFP", oidAgrupacionAFP);
		asignar("VAR", "hoidCodigoVisual", oidCodigoVisualChequeo);
		asignar("VAR", "hradioButton", ordenVisualCheque);
		asignar("VAR", "hck77", impresionesDatosBC);
        
        asignarAtributo("LABELC", "txtCodigo", "valor", txtCodigo);        
        asignarAtributo("CTEXTO", "txtDescripcion", "valor", txtDescripcion);
        asignarAtributoElemento("chkCentroDefault", "check", chkCentroDefault);
		//asignarAtributoElemento("chkImpresionDatosBC", "check", impresionesDatosBC);
        asignarAtributo("CTEXTO", "txtChequeoListaPicado", "valor", textoChequeo);
        asignarAtributo("CTEXTO", "txtPrimeroPicado", "valor", textoPrimerPedido);
		


		if(this.opcionMenu.equals("modificar")) {
			anyadeHiddensI18N(true, "APP_CONFI_CENTR_DISTR", new Long(oidCentroDistribucion), new Integer(1), "formulario", "txtDescripcion", false);
			getConfiguracionMenu("LPMantenimientoCentroDistribucion", "modificarDetalle");
			asignarAtributoPagina("cod", "ApeConfCentroDistribucion.update.label");
			asignar("VAR", "casoUso", "modificarDetalle");
		} else {
			anyadeHiddensI18N(true, "APP_CONFI_CENTR_DISTR", new Long(oidCentroDistribucion), new Integer(1), "formulario", "txtDescripcion", true);
			getConfiguracionMenu("LPMantenimientoCentroDistribucion", "detalle");
			asignarAtributoPagina("cod", "ApeConfCentroDistribucion.view.label");
			asignar("VAR", "casoUso", "detalle");

            // Para el detalle se deshabilitan todos los campos de la pantalla
            asignarAtributoElemento("txtDescripcion",       "disabled", "S");
            asignarAtributoElemento("cbNivelOursourcing",   "disabled", "S");
            asignarAtributoElemento("chkCentroDefault",     "disabled", "S");
            asignarAtributoElemento("cbOrdenListaPicado",   "disabled", "S");
            asignarAtributoElemento("cbOrden",              "disabled", "S");
            asignarAtributoElemento("txtChequeoListaPicado","disabled", "S");
            asignarAtributoElemento("txtPrimeroPicado",     "disabled", "S");
            asignarAtributoElemento("cbAgrupacionParaAFP",  "disabled", "S");
			//Agregado por cambio 20090839
			asignarAtributoElemento("chkImpresionDatosBC",  "disabled", "S");
			asignarAtributoElemento("cbCodigoVisualChequeo",  "disabled", "S");
			asignarAtributoElemento("RBOreden",  "disabled", "S");

		}
	}

	private void cargarCombos(DTOBelcorp dto, String[] idBusiness, String[] comboBox, String[] column, String[] selected) throws Exception {
        traza("*** Entrada - LPMantenimientoCentroDistribucion - cargarCombos ***");

		ComposerViewElementList list = new ComposerViewElementList();
		ComposerViewElement element = null;

		for (int i = 0; i < idBusiness.length; i++) { 
			element = new ComposerViewElement(); 
            element.setIDBusiness(idBusiness[i]);
            element.setDTOE(dto);
            list.addViewElement(element);
		}

		// Obtener un RowSet que contiene los datos solicitados por list.
		ConectorComposerView ccv = new ConectorComposerView(list, this.getRequest());
        ccv.ejecucion();
        DruidaConector dc = ccv.getConector();

		if (selected != null && column != null) {
			for (int i = 0; i < comboBox.length; i++) {
				if (selected[i] != null && column[i] != null) {
					asignar("COMBO", comboBox[i], dc, idBusiness[i], column[i], selected[i]);
				} else {
					asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
				}
			}
		} else {
			for(int i = 0; i < comboBox.length; i++) {
				asignar("COMBO", comboBox[i], dc, idBusiness[i]); 
			}
		}

		traza("*** Salida - LPMantenimientoCentroDistribucion - cargarCombos ***");
	}

    /**
     * Limpieza de descripciones internacionalizables en blanco. Quitamos los
     * dto de los idiomas que no tienen una descripcion para que no se
     * inserte en blanco ya que sino no funciona la recuperacion de la
     * descripcion por defecto cuando no se guardo una alternativa.
     */
    private Vector quitarTraduccionesEnBlanco(Vector traducciones) throws Exception {
             ArrayList traduccionesEnBlanco = new ArrayList();
             traza(" traducciones antes_" + traducciones);
             
             Iterator iter = traducciones.iterator();
             
             while (iter.hasNext()) {
                  DTOI18nSICC i18n = (DTOI18nSICC) iter.next();
                  String descripcionI18n = (String)i18n.getValorI18n();
                  
                  if (descripcionI18n == null || descripcionI18n.equals(" ")) {
                      traduccionesEnBlanco.add(i18n);
                  }
             }
             traducciones.removeAll(traduccionesEnBlanco);
             traza(" traducciones despues_" + traducciones);
             return traducciones;
    }

}
