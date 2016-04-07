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


import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.bel.DTOTipoMovimientoAlmacen;
import es.indra.sicc.util.DTOOID;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
public class LPMantenimientoTiposMovimientosAlmacen extends LPSICCBase {
	
	private String accion = null;
	private String casodeuso =null;
	
	public LPMantenimientoTiposMovimientosAlmacen() {
		super();
	}


	public void inicio() throws Exception {
		

	}
	public void ejecucion() throws Exception {
		setTrazaFichero();
		try  {	
			traza("LPMantenimientoTiposMovimientosAlmacen Entrada");
			this.accion = conectorParametroLimpia("accion", "", true);
			Long idioma = UtilidadesSession.getIdioma(this);			
			//asignar("VAR", "hIdioma", idioma.toString());
			Long pais = UtilidadesSession.getPais(this);
			//asignar("VAR", "hPais", pais.toString());	
					
			if(this.accion.equals("insertar")){
				this.casodeuso = "insertar"; 
				this.cargarPaginaInsertar(idioma,pais);
			}
			
			if(this.accion.equals("modificar")){//modificar
				this.casodeuso = "modificar"; 
				this.cargarPaginaBuscar(idioma,pais);
			}
			
			if(this.accion.equals("consultar")){//consultar
				this.casodeuso = "consultar"; //consultar
				this.cargarPaginaBuscar(idioma,pais);
			}
			
			if(this.accion.equals("detalle")){	
				this.casodeuso = "consultar";
				this.cargarPaginaInsertar(idioma,pais);
			}
			if(this.accion.equals("detalleModificar")){	
				this.casodeuso = "modificar";
				this.cargarPaginaInsertar(idioma,pais);
			}			
			if(this.accion.equals("eliminar")){//eliminar
				this.casodeuso = "eliminar";
				this.cargarPaginaBuscar(idioma,pais);
			}
			
			if(this.accion.equals("guardar")){
				this.casodeuso = "insertar";
				this.guardar(idioma,pais);
			}
			
			if(this.accion.equals("guardarModificar")){
				this.casodeuso = "insertar";
				this.guardar(idioma,pais);
			}			
			traza("LPMantenimientoTiposMovimientosAlmacen Salida");			
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}		
	}
	private void cargarPaginaInsertar(Long idioma, Long pais) throws Exception{
		try{	
			traza("LPMantenimientoTiposMovimientosAlmacen.cargarPaginaInsertar Entrada");
			pagina("contenido_tipo_movimiento_almacen_insertar");
			cargarMenuMensajes();	
			DTOBelcorp dtoBelcorp = new DTOBelcorp();
			dtoBelcorp.setOidPais(pais);
			dtoBelcorp.setOidIdioma(idioma);		
			String idNegocios[]=new String[2];
			String nombreCombos[]=new String[2];
			String valoresCombos[]=new String[2];
			String valoresColumnas[]=new String[2];
			idNegocios[0]="BELObtenerEstadosMercancia";
			idNegocios[1]="BELObtenerEstadosMercancia";
			nombreCombos[0]="cbEstado1";
			nombreCombos[1]="cbEstado2";
			
			asignar("VAR","casoUso", this.casodeuso);	
			asignar("VAR","hPais", pais.toString());	
			asignar("VAR","hIdioma", idioma.toString());	
			DTOTipoMovimientoAlmacen  dtoTipoMovimiento=new DTOTipoMovimientoAlmacen();
			if(this.casodeuso.equals("modificar")||this.casodeuso.equals("consultar")){
				DTOOID dtoOid = new DTOOID();
				dtoOid.setOidPais(pais);
				dtoOid.setOidIdioma(idioma);
				dtoOid.setOid(new Long(conectorParametroLimpia("oidSeleccionado", "", true)));
				Vector paramConector = new Vector();			
				paramConector.add(dtoOid);
				paramConector.add(new MareBusinessID("BELConsultarTipoMovimientoAlmacen"));           
				DruidaConector conector = conectar("ConectorConsultarTipoMovimientoAlmacen", paramConector);							
				dtoTipoMovimiento = (DTOTipoMovimientoAlmacen)conector.objeto("DTOTipoMovimientoAlmacen");	

				if(dtoTipoMovimiento.getCodigoMovimiento()!=null){ //String 
					asignar("CTEXTO","txtCodTipoMovimiento", dtoTipoMovimiento.getCodigoMovimiento());					
				}
				if(dtoTipoMovimiento.getCodigoMovimientoSAP()!=null){ //String 
					asignar("CTEXTO","txtCodMovimientoSAP", dtoTipoMovimiento.getCodigoMovimientoSAP());				
				}
				if(dtoTipoMovimiento.getDescripcion()!=null){ //String 
					asignar("CTEXTO","txtDescripcion", dtoTipoMovimiento.getDescripcion());				
				}
				if(dtoTipoMovimiento.getIndicadorSAP()!=null){ //Boolean  CheckBox
					if(dtoTipoMovimiento.getIndicadorSAP().booleanValue()){
						asignarAtributo("CHECKBOX","ckIndicadorSAP","check","S");
						asignar("VAR","hIndicadorSAP","S");
					}else{
						asignarAtributo("CHECKBOX","ckIndicadorSAP","check","N");
						asignar("VAR","hIndicadorSAP","N");
					}
				}
				if(dtoTipoMovimiento.getMantieneMovimientos()!=null){ //Boolean radioButton 
					asignarAtributo("RBINPUT","rbMantieneMovimientosS","check","N");
					asignarAtributo("RBINPUT","rbMantieneMovimientosN","check","N");				
					if(dtoTipoMovimiento.getMantieneMovimientos().booleanValue()){
						asignarAtributo("RBINPUT","rbMantieneMovimientosS","check","S");
						asignar("VAR","hMantieneMovimientos","S");
					}else{
						asignarAtributo("RBINPUT","rbMantieneMovimientosN","check","S");
						asignar("VAR","hMantieneMovimientos","N");
					}					
				}
				if(dtoTipoMovimiento.getMovimientoEntreAlmacenes()!=null){ //Boolean radioButton	
					asignarAtributo("RBINPUT","rbMovimientoAlmacenesS","check","N");
					asignarAtributo("RBINPUT","rbMovimientoAlmacenesN","check","N");
					if(dtoTipoMovimiento.getMovimientoEntreAlmacenes().booleanValue()){
						asignarAtributo("RBINPUT","rbMovimientoAlmacenesS","check","S");
						asignar("VAR","hMovimientoAlmacenes","S");
					}else{
						asignarAtributo("RBINPUT","rbMovimientoAlmacenesN","check","S");
						asignar("VAR","hMovimientoAlmacenes","N");
					}					
				}
				if(dtoTipoMovimiento.getOid()!=null){ //Long 
					asignar("VAR","oid", dtoTipoMovimiento.getOid().toString());				
				}
				if(dtoTipoMovimiento.getOidEstadoMercancia1()!=null){ //Long 
					if (!this.accion.equals("insertar")){
						if (this.accion.equals("detalle")){

							Vector valores = new Vector();
							valores.add(dtoTipoMovimiento.getOidEstadoMercancia1());
							valores.add(dtoTipoMovimiento.getDescripcionEstado1());
							RecordSet rs = new RecordSet();
							rs.addColumn("CODIGO");
							rs.addColumn("DESCRIPCION");
							rs.addRow(valores);
					
							Vector cols = rs.getColumnIdentifiers();
							DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
							asignar("COMBO", "cbEstado1", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), dtoTipoMovimiento.getOidEstadoMercancia1().toString());


							//asignarAtributo("COMBO","cbEstado1","valorinicial",dtoTipoMovimiento.getOidEstadoMercancia1().toString());
							//asignarAtributo("COMBO","cbEstado1","textoinicial",dtoTipoMovimiento.getDescripcionEstado1().toString());	
						}else if(this.accion.equals("detalleModificar")){
							valoresCombos[0]=dtoTipoMovimiento.getOidEstadoMercancia1().toString();
							valoresColumnas[0]="OID_ESTA_MERC";
							asignar("VAR","hEstadoMerc1", dtoTipoMovimiento.getOidEstadoMercancia1().toString());
						}
					}		
				}
				if(dtoTipoMovimiento.getOidEstadoMercancia2()!=null){ //Long 
					//if(!this.accion.equals("detalle")){
					//if((!this.accion.equals("detalle"))&&(!this.accion.equals("detalleModificar"))){
					if (!this.accion.equals("insertar")){
						if (this.accion.equals("detalle")){

							Vector valores = new Vector();
							valores.add(dtoTipoMovimiento.getOidEstadoMercancia2());
							valores.add(dtoTipoMovimiento.getDescripconEstado2());
							RecordSet rs = new RecordSet();
							rs.addColumn("CODIGO");
							rs.addColumn("DESCRIPCION");
							rs.addRow(valores);
					
							Vector cols = rs.getColumnIdentifiers();
							DruidaConector conectorCargaCombo = UtilidadesBelcorp.generarConector( "DTOSalida.combo_ROWSET", rs, cols);
							asignar("COMBO", "cbEstado2", conectorCargaCombo, "DTOSalida.combo_ROWSET", cols.get(0).toString(), dtoTipoMovimiento.getOidEstadoMercancia2().toString());

							//asignarAtributo("COMBO","cbEstado2","valorinicial",dtoTipoMovimiento.getOidEstadoMercancia2().toString());
                            			//asignarAtributo("COMBO","cbEstado2","textoinicial",dtoTipoMovimiento.getDescripconEstado2().toString());
						}else if(this.accion.equals("detalleModificar")){
							valoresCombos[1]=dtoTipoMovimiento.getOidEstadoMercancia2().toString();
							valoresColumnas[1]="OID_ESTA_MERC";
							asignar("VAR","hEstadoMerc2", dtoTipoMovimiento.getOidEstadoMercancia2().toString());
						}
					}			
				}
				if(dtoTipoMovimiento.getOperacion1()!=null){ //Character si es no es de consulta se hace en el onload
					if(!this.accion.equals("insertar")){
						asignar("VAR","hoperacion1", dtoTipoMovimiento.getOperacion1().toString());	
					}
				}
				if(dtoTipoMovimiento.getOperacion2()!=null){ //Character					
					if(!this.accion.equals("insertar")){
						asignar("VAR","hoperacion2", dtoTipoMovimiento.getOperacion2().toString());		
					}
				}				
			}
			if(this.casodeuso.equals("insertar")){
				cargaCombos(dtoBelcorp, idNegocios,nombreCombos,null,null);
			}else if(this.casodeuso.equals("modificar")){
				cargaCombos(dtoBelcorp, idNegocios,nombreCombos,valoresCombos,valoresColumnas);
				asignarAtributoElemento("txtCodTipoMovimiento","disabled","S");
			}else if(this.casodeuso.equals("consultar")){
				asignarAtributoElemento("txtCodTipoMovimiento","disabled","S");
				asignarAtributoElemento("txtCodMovimientoSAP","disabled","S");
				asignarAtributoElemento("txtDescripcion","disabled","S");
				asignarAtributoElemento("ckIndicadorSAP","disabled","S");
				asignarAtributoElemento("rbMovimientoAlmacenes","disabled","S");
				asignarAtributoElemento("rbMantieneMovimientos","disabled","S");
				asignarAtributoElemento("cbOperacion1","disabled","S");
				asignarAtributoElemento("cbOperacion2","disabled","S");
				asignarAtributoElemento("cbEstado1","disabled","S");
				asignarAtributoElemento("cbEstado2","disabled","S");				
			}
			if (this.casodeuso.equals("insertar")){
				anyadeHiddensI18N(true, "BEL_TIPO_MOVIM_ALMAC", null, new Integer(1), "formularios", "txtDescripcion", false);	
			}
			if (this.casodeuso.equals("modificar")){
				anyadeHiddensI18N(true, "BEL_TIPO_MOVIM_ALMAC", dtoTipoMovimiento.getOid(), new Integer(1), "formularios", "txtDescripcion", false);	
			}
			
			if (this.casodeuso.equals("consultar")){
				traza("Oid Tipo Movimiento "+dtoTipoMovimiento.getOid());
				anyadeHiddensI18N(true, "BEL_TIPO_MOVIM_ALMAC", dtoTipoMovimiento.getOid(), new Integer(1), "formularios", "txtDescripcion", true);
			}
			
			
			
			traza("LPMantenimientoTiposMovimientosAlmacen.cargarPaginaInsertar Salida");
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}				
	} 
	private void cargarPaginaBuscar(Long idioma, Long pais) throws Exception{
		try{	
			traza("LPMantenimientoTiposMovimientosAlmacen.cargarPaginaBuscar Entrada");
			pagina("contenido_tipo_movimiento_almacen_modificar");
			cargarMenuMensajes();
			asignar("VAR","casoUso", this.casodeuso);
			asignar("VAR","hPais", pais.toString());	
			asignar("VAR","hIdioma", idioma.toString());
			traza("LPMantenimientoTiposMovimientosAlmacen.cargarPaginaBuscar Salida");
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}				
	} 
	private void guardar(Long idioma, Long pais) throws Exception{
		try{	
			traza("LPMantenimientoTiposMovimientosAlmacen.guardar Entrada");
			
			//Salida Generica
			pagina("salidaGenerica");

			// inc BELC300023320 cdos gPineda
			// anyadeHiddensI18N(false, "BEL_TIPO_MOVIM_ALMAC", null, new Integer(1), "formularios", "txtDescripcion", false);	

			asignar("VAR", "cerrarVentana", "false");
			if (this.accion.equals("guardarModificar")){
				asignar("VAR", "ejecutar", "modificacionCorrecta()");
			}else{
				asignar("VAR", "ejecutar", "insercionCorrecta()");
			}
			//Fin Salida Generica
			
			DTOTipoMovimientoAlmacen dtoTipoMov=new DTOTipoMovimientoAlmacen();
			dtoTipoMov.setOidPais(pais);
			String parametro="";
			parametro=conectorParametroLimpia("oid", "", true);
			if(!parametro.equals("")){
				dtoTipoMov.setOid(new Long(parametro));
			}
			parametro=conectorParametroLimpia("txtCodTipoMovimiento", "", true);
			if(!parametro.equals("")){
				dtoTipoMov.setCodigoMovimiento(parametro);
			}
			parametro=conectorParametroLimpia("rbMovimientoAlmacenes", "", true);						
			if(!parametro.equals("")){
				if(parametro.equals("S")){
					dtoTipoMov.setMovimientoEntreAlmacenes(Boolean.TRUE);
				}else{
					dtoTipoMov.setMovimientoEntreAlmacenes(Boolean.FALSE);
				}
			}			
			parametro=conectorParametroLimpia("rbMantieneMovimientos", "", true);			
			if(!parametro.equals("")){
				if(parametro.equals("S")){
					dtoTipoMov.setMantieneMovimientos(Boolean.TRUE);
				}else{
					dtoTipoMov.setMantieneMovimientos(Boolean.FALSE);
				}								
			}			
			parametro=conectorParametroLimpia("txtCodMovimientoSAP", "", true);			
			if(!parametro.equals("")){				
				dtoTipoMov.setCodigoMovimientoSAP(parametro);
			}			
			parametro=conectorParametroLimpia("ckIndicadorSAP", "", true);			
			if(!parametro.equals("")){
				if(parametro.equals("S")){
					dtoTipoMov.setIndicadorSAP(Boolean.TRUE);
				}else{
					dtoTipoMov.setIndicadorSAP(Boolean.FALSE);
				}												
			}			
			parametro=conectorParametroLimpia("cbOperacion1", "", true);			
			if(!parametro.equals("")){
				dtoTipoMov.setOperacion1(new Character(parametro.charAt(0)));
			}			
			parametro=conectorParametroLimpia("cbOperacion2", "", true);			
			if(!parametro.equals("")){
				dtoTipoMov.setOperacion2(new Character(parametro.charAt(0)));
			}			
			parametro=conectorParametroLimpia("cbEstado1", "", true);
			if(!parametro.equals("")){
				dtoTipoMov.setOidEstadoMercancia1(new Long(parametro));
			}			
			parametro=conectorParametroLimpia("cbEstado2", "", true);
			if(!parametro.equals("")){
				dtoTipoMov.setOidEstadoMercancia2(new Long(parametro));
			}			
			Vector vIdiomas = this.recuperaTraduccionesI18N(new Integer(1));	
			ArrayList aIdiomas=null;		
			if (vIdiomas != null){
				aIdiomas=new ArrayList();				
				for (int i = 0; i < vIdiomas.size(); i++){
					aIdiomas.add(vIdiomas.get(i));
				}
			} 
			dtoTipoMov.setAttTraducible(aIdiomas);
			
			Vector paramConector = new Vector();			
			paramConector.add(dtoTipoMov);
			paramConector.add(new MareBusinessID("BELGuardarTipoMovimientoAlmacen"));           
			DruidaConector conector = conectar("ConectorGuardarTipoMovimientoAlmacen", paramConector);							
			
			/* inc BELC300023320 cdos gPineda 13/06/2006 - INICIO */
			preservaHiddensI18n(new Integer(1), "BEL_TIPO_MOVIM_ALMAC", "formularios", "txtDescripcion", false);
			/* inc BELC300023320 cdos gPineda 13/06/2006 -  FIN   */
			
			traza("LPMantenimientoTiposMovimientosAlmacen.guardar Salida");
		}catch ( Exception e )  {
			e.printStackTrace();
			this.logStackTrace(e);
			lanzarPaginaError(e);
		}				
	} 		
	private void cargarMenuMensajes() throws Exception{
			if(this.casodeuso.equals("insertar")){
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_insertar","cod","0683");
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_insertar","msgle","Insertar tipos de movimiento de almacén");				
				getConfiguracionMenu("LPMantenimientoTiposMovimientosAlmacen", "insertar");
			}			
			if(this.casodeuso.equals("modificar")){
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_modificar","cod","0684");
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_modificar","msgle","Modificar tipos de movimiento de almacén");			
				if (this.accion.equals("modificar")){
					getConfiguracionMenu("LPMantenimientoTiposMovimientosAlmacen", "consultar"); //modificar
				}else {
					asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_insertar","cod","0684");
					asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_insertar","msgle","Modificar tipos de movimiento de almacén");
					getConfiguracionMenu("LPMantenimientoTiposMovimientosAlmacen", "modificar"); 
				}				
			}									
			if(this.casodeuso.equals("consultar")){			
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_modificar","cod","0685");
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_modificar","msgle","Consultar tipos de movimiento de almacén");			
				if(this.accion.equals("consultar")){
					getConfiguracionMenu("LPMantenimientoTiposMovimientosAlmacen", "consultar");
				}else{
					asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_insertar","cod","0685");
					asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_insertar","msgle","Consultar tipos de movimiento de almacén");
					getConfiguracionMenu("LPMantenimientoTiposMovimientosAlmacen", "detalle");				
				}
			}
			if(this.casodeuso.equals("eliminar")){
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_modificar","cod","0686");
				asignarAtributo("PAGINA","contenido_tipo_movimiento_almacen_modificar","msgle","Eliminar tipos de movimiento de almacén");			
				getConfiguracionMenu("LPMantenimientoTiposMovimientosAlmacen", "eliminar");
			}
								
	}
	private void cargaCombos(DTOBelcorp dtoBelcorp, String[] idNegocios, String[] combos, String[] seleccionados, String[] columnas) throws Exception {
		traza("*** Entrada - cargaCombos ***");
		try {
		//Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
		ComposerViewElementList listelem = new ComposerViewElementList();
		ComposerViewElement elem = null;
		
		for (int i = 0; i < idNegocios.length; i++) {
			elem=new ComposerViewElement(); 
			elem.setIDBusiness(idNegocios[i]);
			elem.setDTOE(dtoBelcorp);
			listelem.addViewElement(elem);
		}
		
		/*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
		ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
		conector.ejecucion();
		DruidaConector conConsultar = conector.getConector();
		
		/*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla 
		//correspondiente utilizando el String que representa el BusinessID en cada caso. */
		if (seleccionados == null) {
			for(int j = 0; j < combos.length; j++) {
				asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			}
		} else {
			for (int j = 0; j < combos.length; j++) {
				if (seleccionados[j] != null && !seleccionados[j].equals("") && columnas != null && columnas.length > j && columnas[j] != null && !columnas[j].equals(""))
							asignar("COMBO", combos[j], conConsultar, idNegocios[j], columnas[j], seleccionados[j]);
			   	else
			   		asignar("COMBO", combos[j], conConsultar, idNegocios[j]); 
			}
		}		
		} catch (Exception ex) {
			this.logStackTrace(ex);
		}
		traza("*** Salida - cargaCombos ***");
	}	

	private void logStackTrace(Throwable e) throws Exception {
		traza("Se produjo la excepcion: " + e.getMessage());		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(baos);
		e.printStackTrace(ps);		
		traza("Stack Trace: " + baos.toString());
	}		
}