/**
 * Copyright 2008 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;
import es.indra.mare.common.dto.MareDTO;
import java.math.BigDecimal;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.lang.String;
import java.util.HashMap;
import es.indra.druida.belcorp.MMGDruidaHelper;
import es.indra.belcorp.mso.*;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.util.ArrayList;
import es.indra.sicc.cmn.presentacion.i18n.Idioma;



public class LPMantenimientoTipoEncuesta extends LPSICCBase{
		private String accion = null;
		private String opcionMenu = null;
		private Long idioma;
		private Long pais;
		
		public static final String BUSINESSID_CREATE= "MAEGuardarTipoeEncuesta";
        public static final String BUSINESSID_UPDATE = "MMGMaeEncueNseUpdateI18N";
        public static final String BUSINESSID_REMOVE = "MMGMaeEncueNseRemoveSeveral";
        public static final String BUSINESSID_QUERY = "MMGMaeEncueNseQueryFromToUserPage";	

		public static final String CONECTOR_CREATE = "ConectorGuardarTipoEncuesta";
		public static final String CONECTOR_UPDATE = "MaeEncueNseConectorUpdate";
         public static final String CONECTOR_REMOVE = "MaeEncueNseConectorRemove";


		public LPMantenimientoTipoEncuesta(){
			super();
		}

		public void inicio() throws Exception {
		}

		public void ejecucion() throws Exception{
				
					try{
							this.setTrazaFichero();
							this.traza("77777777777LPMantenimientoTipoEncuesta.ejecucion(): Entrada");
							this.rastreo();	
							accion = this.conectorParametroLimpia("accion", "", true);
							opcionMenu = this.conectorParametroLimpia("opcionMenu", "", true);
							idioma = UtilidadesSession.getIdioma(this);
							pais = UtilidadesSession.getPais(this);
							if(accion.equals("")){
					
									cargarPagina();

							}else if(accion.equals("guardar")){
					
									guardar();

							}else if(accion.equals("detalle")){
									detalle();

							}else if(accion.equals("modificar")){
									modificar();

							}
							
							cargarMenuSecundarios();

					}catch(Exception e){
						  this.lanzarPaginaError(e);
					}
		}

		public void cargarPagina() throws Exception{
				traza("7777777777777LPMantenimientoTipoEncuesta.cargarPagina(): Entrada");
                if(opcionMenu.equals("insertar")){
					traza("777777777Entro");
					pagina("contenido_tipo_encuesta_insertar");
					anyadeHiddensI18N(true, "MAE_ENCUE_NSE", null, new Integer(1),
                                    "formulario", "txtDescripcion", false);
				}else{
					pagina("contenido_tipo_encuesta_modificar");
				}
				this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
				this.asignarAtributo("VAR", "accion", "valor", accion);
				this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
				this.asignarAtributo("VAR", "varPais", "valor", pais.toString());
    			this.getFormatosValidaciones();
				cargarComboMarca();

				this.traza("77777777777LPMantenimientoTipoEncuesta.cargarPagina(): Salida");
		}
		public void cargarComboMarca() throws Exception {

				   traza("77777777777LPMantenimientoTipoEncuesta.cargarComboMarca(): Entrada");
				   ComposerViewElementList listElement = new ComposerViewElementList();
         
                   DTOBelcorp dtoe = new DTOBelcorp();
                   dtoe.setOidPais(pais);
                   dtoe.setOidIdioma(idioma);
         
                   ComposerViewElement elem1 = new ComposerViewElement();
                   elem1.setIDBusiness("SEGConsultaMarcas");
                   elem1.setDTOE(dtoe);
          
                   listElement.addViewElement(elem1);
         
                   ConectorComposerView conector = new ConectorComposerView(listElement,this.getRequest());
          
                   conector.ejecucion();
          
                   DruidaConector conConsultar = conector.getConector();

                   asignar("COMBO", "cbMarca", conConsultar, "SEGConsultaMarcas");                

				   traza("77777777777LPMantenimientoTipoEncuesta.cargarComboMarca(): Salida");
		}
		public void cargarMenuSecundarios() throws Exception {
				traza("7777777777777LPMantenimientoTipoEncuesta.cargarMenuSecundario(): Entrada");
				if(accion.equals("")){
					if(opcionMenu.equals("insertar")){
						this.getFormatosValidaciones();
						this.asignarAtributoPagina("cod","MaeEncueNseView.create.label");
						this.getConfiguracionMenu("LPMantenimientoTipoEncuesta","insertar"); 				
					}else if(opcionMenu.equals("modificar")){
						this.getFormatosValidaciones();
						this.asignarAtributoPagina("cod","MaeEncueNseView.update.label");
						this.getConfiguracionMenu("LPMantenimientoTipoEncuesta","modificar");
						anyadeHiddensI18N(false, "MAE_ENCUE_NSE", null, new Integer(1),
                                    "formulario", "txtDescripcion", false);
					}else if(opcionMenu.equals("consultar")){
						this.getFormatosValidaciones();
						this.asignarAtributoPagina("cod","MaeEncueNseView.view.label");
						this.getConfiguracionMenu("LPMantenimientoTipoEncuesta","consultar"); 
						anyadeHiddensI18N(false, "MAE_ENCUE_NSE", null, new Integer(1),
                                    "formulario", "txtDescripcion", true);
					}else if(opcionMenu.equals("eliminar")){
						this.getFormatosValidaciones();
						this.asignarAtributoPagina("cod","MaeEncueNseView.remove.label");
						this.getConfiguracionMenu("LPMantenimientoTipoEncuesta","eliminar"); 
						anyadeHiddensI18N(false, "MAE_ENCUE_NSE", null, new Integer(1),
                                    "formulario", "txtDescripcion", true);
					}
				}else if(accion.equals("modificar")){
					this.getFormatosValidaciones();
					this.asignarAtributoPagina("cod","MaeEncueNseView.update.label");
					this.getConfiguracionMenu("LPMantenimientoTipoEncuesta","modificar"); 	

				}else if(accion.equals("detalle")){
				
					this.getFormatosValidaciones();
					this.asignarAtributoPagina("cod","MaeEncueNseView.view.label");
					this.getConfiguracionMenu("LPMantenimientoTipoEncuesta","consultar"); 	
				}
				traza("7777777777777LPMantenimientoTipoEncuesta.cargarMenuSecundarios(): Salida");
	}
	public void guardar() throws Exception{
				traza("777777777777LPMantenimientoTipoEncuesta.guardar(): Entrada");
				pagina("salidaGenerica");
				

             try{
				anyadeHiddensI18N(false, "MAE_ENCUE_NSE", null, new Integer(1),
                                    "formulario", "txtDescripcion", false);
    		    HashMap userProperties = MMGDruidaHelper.getUserProperties(this);
				userProperties.put("loidPais",pais);


				String oidTipoEncuesta = conectorParametroLimpia("oidTipoEncuesta", "", true);
				String oidMarca = conectorParametroLimpia("oidMarca", "", true);
				String codTipoEncuesta = conectorParametroLimpia("txtCodEncuesta", "", true);
				String descripcion = conectorParametroLimpia("txtDescripcion", "", true);

				traza("777777777777oidTipoEncuesta: " + oidTipoEncuesta);
				traza("777777777777oidMarca: " + oidMarca);
				traza("777777777777codTipoEncuesta: " + codTipoEncuesta);
				traza("777777777777descripcion: " + descripcion);
				traza("777777777777pais: " + pais);
                traza("777777777777opcionMenu: " + opcionMenu);
				traza("777777777777accion: " + accion);
				MaeEncueNseData maeEncueNse= new MaeEncueNseData();

				if(!oidTipoEncuesta.equals("")){
						maeEncueNse.setId(new Long(oidTipoEncuesta));
				}
				if(!oidMarca.equals("")){
						SegMarcaData marcOidMarc = new SegMarcaData();
						marcOidMarc.setId(new Long(oidMarca));						
						maeEncueNse.setMarcOidMarc(marcOidMarc);
				}
				if(!codTipoEncuesta.equals("")){
						maeEncueNse.setCodTipoEncu(new String(codTipoEncuesta));
				}
				if(!descripcion.equals("")){
						maeEncueNse.setDescripcion(new String(descripcion));
				}
				SegPaisViewData paisOidPais = new SegPaisViewData();
				paisOidPais.setId(pais);
				maeEncueNse.setPaisOidPais(paisOidPais);		
				MareBusinessID businessID = null;
				if(opcionMenu.equals("insertar")){
					 businessID = new MareBusinessID(BUSINESSID_CREATE);
				}else{
					 businessID = new MareBusinessID(BUSINESSID_UPDATE);
				}
				traza("Traduccciones: "+ recuperaTraduccionesI18N(new Integer(1)));
				Vector i18n = recuperaTraduccionesI18N(new Integer(1));
                Vector localizationLabels = new Vector();   
			    Long oidIdioma = null;
                String des = null;
				DTOI18nSICC dtoTraduccion = null;
				for(int i = 0; i < i18n.size(); i++){
				           GenDetaSiccData label = new GenDetaSiccData();
						   dtoTraduccion = (DTOI18nSICC)i18n.get(i);
						   oidIdioma = (Long)dtoTraduccion.getOidIdioma();
                           des = (String)dtoTraduccion.getValorI18n(); 
                           label.setAtri(new Long(1));
                           SegIdiomData language = new SegIdiomData();
                           language.setId(oidIdioma);
                           label.setIdioOidIdio(language);
                           label.setEnti("MAE_ENCUE_NSE");
						   label.setDeta(des);
                           localizationLabels.add(label);
				}

				Vector para = new Vector(); 
				MareDTO dto = new MareDTO();
                dto.addProperty("maeEncueNse", maeEncueNse);
                dto.addProperty("localizationLabels", localizationLabels);
                dto.addProperty("userProperties", userProperties);
    			para.add(dto);
				para.add(businessID);
				
					traza("7777777777 Antes de conectar");
					if(accion.equals("guardar")){
						traza("7777777777777777conector");	
						conectar(CONECTOR_CREATE, para);

					}else{

						conectar(CONECTOR_UPDATE, para);

					}
					traza("777777777 Despues de conectar");
					asignarAtributo("VAR", "ejecutar", "valor", "fGuardarOK()");
				}catch(Exception e){
					traza("777777777 Entrando al Catch");
					asignarAtributo("VAR", "ejecutarError", "valor", "fGuardarERR()");
					throw e;
				}
				traza("777777777777LPMantenimientoTipoEncuesta.guardar(): Salida");

	}
	public void detalle() throws Exception{
			traza("777777777777LPMantenimientoTipoEncuesta.detalle(): Entrada");
			this.pagina("contenido_tipo_encuesta_insertar");
			anyadeHiddensI18N(true, "MAE_ENCUE_NSE", null, new Integer(1),
                                    "formulario", "txtDescripcion", false);
			cargarComboMarca();
			asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
            asignarAtributo("VAR", "accion", "valor", accion);
            asignarAtributo("VAR", "varPais", "valor", pais.toString());
            asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());


			String oidTipoEncuesta = conectorParametroLimpia("oidTipoEncuesta", "", true);
			String oidMarca = conectorParametroLimpia("oidMarca", "", true);
			String desMarca = conectorParametroLimpia("desMarca", "", true); 
			String codTipoEncuesta = conectorParametroLimpia("codEncuesta", "", true);
			String descripcion = conectorParametroLimpia("descripcion", "", true);

			traza("777777777777oidTipoEncuesta: " + oidTipoEncuesta);
			traza("777777777777oidMarca: " + oidMarca);
			traza("777777777777desMarca: " + desMarca);
			traza("777777777777codTipoEncuesta: " + codTipoEncuesta);
			traza("777777777777descripcion: " + descripcion);
			
			asignarAtributo("VAR", "oidEstadoMercancia", "valor", oidTipoEncuesta);
            asignarAtributo("VAR","oidMarca", "valor", oidMarca);

			asignarAtributo("CTEXTO", "txtCodEncuesta", "valor", codTipoEncuesta);
			asignarAtributo("CTEXTO", "txtDescripcion", "valor", descripcion);
			//asignarAtributo("COMBO", "cbMarca", "valor", desMarca);
	}
	public void modificar() throws Exception{
			traza("777777777777LPMantenimientoTipoEncuesta.modificar(): Entrada");
			this.pagina("contenido_tipo_encuesta_insertar");
			
			cargarComboMarca();
			asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
            asignarAtributo("VAR", "accion", "valor", accion);
            asignarAtributo("VAR", "varPais", "valor", pais.toString());
            asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());


			String oidTipoEncuesta = conectorParametroLimpia("oidTipoEncuesta", "", true);
			String oidMarca = conectorParametroLimpia("oidMarca", "", true);
			String desMarca = conectorParametroLimpia("desMarca", "", true); 
			String codTipoEncuesta = conectorParametroLimpia("codEncuesta", "", true);
			String descripcion = conectorParametroLimpia("descripcion", "", true);
			anyadeHiddensI18N(true, "MAE_ENCUE_NSE",Long.valueOf(oidTipoEncuesta), new Integer(1),
                                    "formulario", "txtDescripcion", false);

			traza("777777777777oidTipoEncuesta: " + oidTipoEncuesta);
			traza("777777777777oidMarca: " + oidMarca);
			traza("777777777777desMarca: " + desMarca);
			traza("777777777777codTipoEncuesta: " + codTipoEncuesta);
			traza("777777777777descripcion: " + descripcion);
			
			asignarAtributo("VAR", "oidTipoEncuesta", "valor", oidTipoEncuesta);
            asignarAtributo("VAR","oidMarca", "valor", oidMarca);

			asignarAtributo("CTEXTO", "txtCodEncuesta", "valor", codTipoEncuesta);
			asignarAtributo("CTEXTO", "txtDescripcion", "valor", descripcion);
			//asignarAtributo("COMBO", "cbMarca", "valor", desMarca);
			traza("777777777777LPMantenimientoTipoEncuesta.modificar(): Entrada");

	}
	
	


}