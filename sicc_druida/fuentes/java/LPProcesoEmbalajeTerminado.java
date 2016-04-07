/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * 
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;         
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.xml.XMLDocument;


     
import java.math.BigDecimal;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringTokenizer;
import java.util.Vector;
import es.indra.sicc.util.DTOBelcorp;

import es.indra.sicc.dtos.ape.DTOEtiqueta;

public class LPProcesoEmbalajeTerminado extends LPSICCBase 
{
	private Long pais;
	private Long idioma;
	private String opcionMenu = null;
	private String accion = null;
        
	public LPProcesoEmbalajeTerminado() {      
        super();
	}

	public void inicio() throws Exception { 
	}
	public void ejecucion() throws Exception {
		
		try{
			
			setTrazaFichero();
		    accion = this.conectorParametroLimpia("accion", "", true);
			traza("accion: " + accion);
        	pais = UtilidadesSession.getPais(this);
			idioma = UtilidadesSession.getIdioma(this);
			
			if(accion.equals("")){
				cargarPagina();
			}else if( accion.equals("procesar")){
				procesar();
			}
			
		configurarMenuSecundario();
		}catch (Exception e){   
			traza(e);      
			this.lanzarPaginaError(e);
		}

	}
	private void cargarPagina() throws Exception{

		 pagina("contenido_proceso_embalaje_terminado");  
      
		 // Validaciones
		 getFormatosValidaciones();
	
		// this.asignarAtributo("VAR", "opcionMenu", "valor", opcionMenu);
         //this.asignarAtributo("VAR", "accion", "valor", accion);
         this.asignarAtributo("VAR", "varIdioma", "valor", idioma.toString());
         this.asignarAtributo("VAR", "varPais", "valor", pais.toString());
	}
	private void configurarMenuSecundario() throws Exception{
		traza("LPProcesoEmbalajeTerminado.configurarMenuSecundario(): Entrada");
		if(accion.equals("")){
			this.getFormatosValidaciones();
            this.asignarAtributoPagina("cod","3356");
            this.getConfiguracionMenu("LPProcesoEmbalajeTerminado","procesar");                    
		}
	}
    private void procesar() throws Exception{

		traza("LPProcesoEmbalajeTerminado.procesar() : Entrada");
    	pagina("salidaGenerica");
		String codigo = this.conectorParametroLimpia("codigoBarraEtiqueta", "", true);
		String anio  = this.conectorParametroLimpia("varAnio", "", true);
		 		
		traza("codigo :" + codigo);

		String codigoBarraEtiqueta =  anio.substring(3) + codigo;
		
		String anioPenultimo = anio.substring(2,3);
		if(!anioPenultimo.equals("0")) {
			codigoBarraEtiqueta =  anio.substring(2) + codigo;
		}
		
		traza("codigoBarraEtiqueta : " + codigoBarraEtiqueta);
		int cant = codigoBarraEtiqueta.length();
		int leng = cant - 3;
		
		String numeroSolicitud = codigoBarraEtiqueta.substring(0, leng);
		String numeroCaja = codigoBarraEtiqueta.substring((codigoBarraEtiqueta.length()- 3), codigoBarraEtiqueta.length());
		
		traza("numeroSolicitud: " + numeroSolicitud);
		traza("numeroCaja: " + numeroCaja);
		
		DTOEtiqueta dto = new DTOEtiqueta();
		if(!numeroSolicitud.equals("")){
			dto.setSolicitudCabecera(new Long(numeroSolicitud));
		}
		if(!numeroCaja.equals("")){

			dto.setNumeroCaja(new Long(numeroCaja));
		}
		if(!codigoBarraEtiqueta.equals("")){
			dto.setCodigoImpresora(new String(codigoBarraEtiqueta));
		}
		dto.setOidPais(pais);
        dto.setOidIdioma(idioma);
    	MareBusinessID businessID = new MareBusinessID("APEProcesoEmbalajeTerminado");
                      
        Vector para = new Vector(); 
        para.add(dto);
        para.add(businessID);
        try{
                                                                
			 traza("********** Antes de conectar");
			 conectar("ConectorProcesoEmbalajeTerminado", para);
			 traza("*********** Despues de conectar");
			 asignarAtributo("VAR", "ejecutar", "valor", "fProcesoOK('"+ codigoBarraEtiqueta +"');");
                    
        }catch(Exception e){
			traza("********* Entrando al Catch");
			asignarAtributo("VAR", "ejecutarError", "valor", "fProcesoERR()");
			throw e;
        }
        traza("LPProcesoEmbalajeTerminado.proceso() : Salida");

  }





}