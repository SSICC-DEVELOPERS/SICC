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
 * 
 * Autor : Diego Morello
 */

import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.inc.DTOConsultarPremiosConsuelo;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.zon.DTOUnidadAdministrativa;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.util.Vector;
 
public class LPConsultarPremiosConsuelo extends LPSICCBase {
    public LPConsultarPremiosConsuelo() {
        super();
    }
    
    public void inicio() throws Exception {
        pagina("contenido_premios_consuelo_consultar");
    }
    
    public void ejecucion() throws Exception {
        this.setTrazaFichero();   
        String accion = conectorParametroLimpia("accion","",true);
        try {
            if (accion.equals("")) {
                inicializar();
            } else if (accion.equals("validarCliente")) {
                validarCliente();
            }
        } catch (Exception e) {
            this.lanzarPaginaError(e);
        }
        getConfiguracionMenu();
    }
    
    public void inicializar() throws Exception {
    
        traza("***** Entro en LPConsultarPremiosConsuelo.inicializar() *****");
        
        DTOBelcorp dtob = new DTOBelcorp();
        dtob.setOidPais(UtilidadesSession.getPais(this));
        dtob.setOidIdioma(UtilidadesSession.getIdioma(this));
        
        ComposerViewElementList list = new ComposerViewElementList();
        
        /* Obtengo Nro.concurso premios consuelo */
            ComposerViewElement elem1 = new ComposerViewElement();
            elem1.setIDBusiness("INCObtenerNroConcursoPremiosConsuelo");
            list.addViewElement(elem1);
        
        /* Obtengo artículos premio consuelo */
            ComposerViewElement elem2 = new ComposerViewElement();
            elem2.setIDBusiness("INCObtenerArticulosPremioConsuelo");
            elem2.setDTOE(dtob);
            list.addViewElement(elem2);
        
        /* Obtengo región */
            ComposerViewElement elem3 = new ComposerViewElement();
            elem3.setIDBusiness("ZONRecargaRegiones");
            DTOUnidadAdministrativa dtoUni = new DTOUnidadAdministrativa();
            dtoUni.setOidPais(UtilidadesSession.getPais(this));
            dtoUni.setOidIdioma(UtilidadesSession.getIdioma(this));
            elem3.setDTOE(dtoUni);
            list.addViewElement(elem3);
        
        
        ConectorComposerView conector = new ConectorComposerView(list,this.getRequest());
        conector.ejecucion();
        DruidaConector resultados = conector.getConector();
    
        asignar("COMBO","cbNumConcurso",resultados,"INCObtenerNroConcursoPremiosConsuelo");
        asignar("COMBO","cbArticulo",resultados,"INCObtenerArticulosPremioConsuelo");
        asignar("COMBO","cbRegion",resultados,"ZONRecargaRegiones");
        asignar("VAR","hPais",UtilidadesSession.getPais(this).toString());
        asignarAtributo("VAR", "hLongitudCodCliente", "valor", this.obtenerLongitudCodigoCliente().toString()); 
    }
    
        private void validarCliente() throws Exception{ 
             traza("metodo validarCliente"); 

             pagina("salidaGenerica"); 

             try { 
                  String codigoCliente = conectorParametroLimpia("txtCodCliente", "", true); 

                  // idBusiness= "MAEBusquedaRapidaClientes"  
                  MareBusinessID idBusiness = new MareBusinessID("MAEBusquedaRapidaCliente"); 
                  // Creamos un DTOBusquedaRapidaClientes y lo rellenamos con:  
                  // - pais  
                  // - idioma  
                  // - codigoCliente: Valor introducido en txtCliente  
                  DTOBusquedaRapidaCliente dto = new DTOBusquedaRapidaCliente(); 
                  dto.setIndicadorSituacion(new Long(0)); 
                  dto.setTamanioPagina(new Integer(1)); 
                  dto.setOidPais(UtilidadesSession.getPais(this)); 
                  dto.setOidIdioma(UtilidadesSession.getIdioma(this)); 

                  dto.setCodigoCliente(codigoCliente); 
                  traza("Código de cliente: " + codigoCliente); 

                  // Llamamos al ConectorBusquedaRapidaCliente con el dto creado.  
                  Vector parametros = new Vector(); 
                  parametros.add(dto); 
                  parametros.add(idBusiness); 
                  traza("Conectando a ConectorBusquedaRapidaCliente... "); 
                  DruidaConector conector = conectar("ConectorBusquedaRapidaCliente", parametros); 
                  traza("Conectó."); 

                  // Recibe un DTOSalida (con un registro)  
                  DTOSalida dtoRetornado = (DTOSalida)conector.objeto("DTOSalida"); 
                  RecordSet retorno = dtoRetornado.getResultado(); 
                  traza("Retornó: "); 
                  traza(" - OID: " + (BigDecimal)retorno.getValueAt(0, "OID")); 
                  traza(" - COD_CLIE: " + (String)retorno.getValueAt(0, "COD_CLIE")); 

                  String oidCliente = ((BigDecimal)retorno.getValueAt(0, "OID")).toString(); 
                   
                  String funcion = new String("asignarDatosCliente('" + oidCliente + "')"); 

                  traza("Funcion a ejecutar: " + funcion); 
                   
                  asignarAtributo("VAR", "ejecutar", "valor", funcion); 

         }catch (Exception e){    

            asignarAtributo("VAR", "ejecutarError", "valor", "errorCliente()"); 
            throw e; 
         } 
    } 
}
