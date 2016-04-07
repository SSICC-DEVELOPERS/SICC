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

public class LPPruebaDDIU extends LPSICCBase {

    Long pais = null;
    Long idioma = null;
         
    public LPPruebaDDIU() {      
         super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
         try {      
         setTrazaFichero();
                
         String accion = conectorParametroLimpia("accion", "", true);
         traza("accion: " + accion);
         
         pais = UtilidadesSession.getPais(this);
         idioma = UtilidadesSession.getIdioma(this);
         
         
           pagina("contenido_tip_imp_ubigeo_consultar");
         
      } catch (Exception e){
           //traza(e);      
           this.lanzarPaginaError(e);
      }
      
    }
  
}

