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
 * Autor: Viviana Bongiovanni
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Boolean;
import java.math.BigDecimal;
import java.util.Vector;
import java.util.StringTokenizer;
import java.util.ArrayList;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;

import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;

import es.indra.sicc.dtos.ape.DTOListaPicadoCabecera;
import es.indra.sicc.dtos.ape.DTOListaPicadoDetalle;
import es.indra.sicc.dtos.ape.DTOLineaArmado;

import es.indra.sicc.dtos.ape.DTOListaPicado;

import es.indra.sicc.dtos.intsys.DTOEtiquetaInduccionPTL;


public class LPPruebaServ extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
        
    public LPPruebaServ() {	 
        super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
        try {      
        setTrazaFichero();
		/*
        String accion = conectorParametroLimpia("accion", "", true);
        traza("accion: " + accion);
        
        pais = UtilidadesSession.getPais(this);
        idioma = UtilidadesSession.getIdioma(this);
        
        if(accion.equals("")) { 
          pagina("contenido_prueba");
        } else if(accion.equals("lanzar")) { 
          this.lanzar();          
        }

		pagina("salidaGenerica");

		DTOListaPicado dtoLista = new DTOListaPicado();
		dtoLista.setOidPais(UtilidadesSession.getPais(this));
		dtoLista.setOidListaPicado(new Long(6));
		dtoLista.setOidCentroDistribucion(new Long(42));
		dtoLista.setOidLineaArmado(new Long(1));
		dtoLista.setOidPeriodo(new Long(1364));
		MareBusinessID id = new MareBusinessID("APEPrueba");
		Vector paramEntrada = new Vector();

		DTOBelcorp dto = new DTOBelcorp();
		dto.setOidPais(new Long(1));
		dto.setOidIdioma(new Long(1));

		//paramEntrada.add(dtoLista);
		paramEntrada.add(dto);
		paramEntrada.add(id);
		traza("*************** Antes de conectar");
		DruidaConector con = conectar("ConectorPrueba", paramEntrada);
		traza("*************** Despues de conectar");
		*/

		pagina("contenido_picado_lista");

        
      } catch (Exception e){
		  for ( Throwable th = e; th != null; th = th.getCause() ) {
			  traza(th);
		  }
          //traza(e);      
          this.lanzarPaginaError(e);
      }
      //getConfiguracionMenu();
    }
    
    
    private void lanzar() throws Exception{
      pagina("salidaGenerica");
      
      try {         
           DTOListaPicadoCabecera listaPicado = new DTOListaPicadoCabecera();
           ArrayList detalles = new ArrayList();
           
           DTOListaPicadoDetalle dtoListaPicadoDetalle1  = new DTOListaPicadoDetalle();
           dtoListaPicadoDetalle1.setOidProducto(new Long(53831));
           dtoListaPicadoDetalle1.setUnidadesProducto(new Long(4));
           
           detalles.add(dtoListaPicadoDetalle1);
           
           DTOListaPicadoDetalle dtoListaPicadoDetalle2  = new DTOListaPicadoDetalle();
           dtoListaPicadoDetalle2.setOidProducto(new Long(53832));
           dtoListaPicadoDetalle2.setUnidadesProducto(new Long(3));
           
           detalles.add(dtoListaPicadoDetalle2);
           
           DTOListaPicadoDetalle dtoListaPicadoDetalle3  = new DTOListaPicadoDetalle();
           dtoListaPicadoDetalle3.setOidProducto(new Long(53833));
           dtoListaPicadoDetalle3.setUnidadesProducto(new Long(2));
           
           detalles.add(dtoListaPicadoDetalle3);
           
           DTOLineaArmado dtoLineaArmado = new DTOLineaArmado();
           dtoLineaArmado.setOid(new Long(1));
            
           listaPicado.setLineaArmado(dtoLineaArmado);
           
           listaPicado.setDetalles(detalles);
           listaPicado.setOidPais(new Long(1));
            
           traza("listaPicado: " + listaPicado);
           
           MareBusinessID id = new MareBusinessID("APEPrueba");             
           Vector paramEntrada = new Vector();
         
           paramEntrada.add(listaPicado);
           paramEntrada.add(id);
           traza("*************** Antes de conectar");
           DruidaConector con = conectar("ConectorPrueba", paramEntrada);
           traza("*************** Despues de conectar");
                
           asignarAtributo("VAR", "ejecutar", "valor", "ejecutarOK();");
           
      } catch(Exception e) {
         traza("Excepcion: " + e);
         asignarAtributo("VAR", "ejecutarError", "valor", "focalizaCD();");
         throw e;
      }
   }
}
