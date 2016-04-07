//$Id: LPResumen.java,v 1.1 2009/12/03 18:41:54 pecbazalar Exp $

/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
/**
 * Sistema:           Belcorp
 * Modulo:            COB
 * Submódulo:         Cobranzas
 * Componente:        LP
 * Fecha:             24/01/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Marta Aurora Montiel
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.math.BigDecimal;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import es.indra.sicc.dtos.cal.DTOBusqueda;
import es.indra.sicc.dtos.cal.DTOCabecera;
import es.indra.sicc.dtos.cal.DTODetalle;
import es.indra.sicc.dtos.cal.DTORedirigirDetalle;
import es.indra.sicc.dtos.cal.DTOCliente;

import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;



public class LPResumen extends LPSICCBase {

	 private String accion = "";
	 private Long pais = null;     
	 private Long idioma = null;



		   

	 public void inicio() throws Exception {
			pagina("contenido_resumen_usuarios_zonificacion_consultar");      
	  }
	  
	  public void ejecucion() throws Exception {    
			setTrazaFichero();   
			accion = conectorParametroLimpia("accion", "", true);
			try{
				traza(" entrada del try ");
				pais = UtilidadesSession.getPais(this);
			    idioma = UtilidadesSession.getIdioma(this);	
				if(accion.equals("")){
					mostrarPantalla();				
				}

			}catch(Exception e){
				lanzarPaginaError(e);
				ByteArrayOutputStream pila = new ByteArrayOutputStream();
				PrintStream out = new PrintStream(pila);
				e.printStackTrace(out);
				traza("EL STACK ES COMO SIGUE : " +  pila.toString());			
			}
			getConfiguracionMenu();			
	  }

	/*Muestra la pantalla PantallaBuscarUsuariosZonificacion , cargando los combos: 
	cbCanal, cbMarca, cbEtapaDeuda*/
	  private void mostrarPantalla() throws Exception {   
		  traza("entre a mostrarPantalla() ");
			DTOBelcorp dtoB = new DTOBelcorp();			
			dtoB.setOidIdioma(idioma);
			dtoB.setOidPais(pais);

			ComposerViewElementList lista = new ComposerViewElementList();

			//Canales
			ComposerViewElement composer1 = new ComposerViewElement();
			traza("1");
			composer1.setIDBusiness("SEGConsultaCanales");
			composer1.setDTOE(dtoB);
			//composer1.setPosOID(Byte.valueOf("1").byteValue());
			//composer1.setPosOID(Byte.valueOf("2").byteValue());
			lista.addViewElement(composer1);
			traza("2");
			//Marcar
			ComposerViewElement composer2 = new ComposerViewElement();

			composer2.setIDBusiness("SEGConsultaMarcas");
			composer2.setDTOE(dtoB);
			//composer2.setPosOID(Byte.valueOf("1").byteValue());
			//composer2.setPosOID(Byte.valueOf("2").byteValue());
			lista.addViewElement(composer2);
			traza("3");
			//Etapa Deuda
			ComposerViewElement composer3 = new ComposerViewElement();

			composer3.setIDBusiness("COBObtenerEtapasDeuda");									 
			composer3.setDTOE(dtoB);
			lista.addViewElement(composer3);




			traza("antes de llamar al conector");
			ConectorComposerView conector = new ConectorComposerView(lista,this.getRequest());
			conector.ejecucion();

			DruidaConector con = conector.getConector();
			traza("antes de asignar a los combos");
			asignarAtributo("VAR", "oidIdioma", "valor", (idioma==null?"":idioma.toString())  );
			asignarAtributo("VAR", "oidPais", "valor", (pais==null?"":pais.toString())  );
		    asignar("COMBO", "cbCanal", con, "SEGConsultaCanales");
			asignar("COMBO", "cbMarca", con, "SEGConsultaMarcas");
			asignar("COMBO", "cbEtapaDeuda", con, "COBObtenerEtapasDeuda");

	 }

}
