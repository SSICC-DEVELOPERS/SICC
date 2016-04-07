/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.dtos.pre.DTOSCriteriosCondicionOferta;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;
import org.jaxen.dom.DOMXPath;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * Sistema:             Belcorp - SICC
 * Modulo:              PRE - Ofertas
 * Componente:          LPDefinirCondicionOfertaPerf
 * Fecha:               22/10/2006
 * Dcoumentacion:
 *                      documentos: Performance
 * Observaciones:
 */

public class LPDefinirCondicionOfertaPerf extends LPSICCBase {
        
    private Long lOidEstrategia = null;    
    private Long lIdioma = null;
    private Long lPais = null;

    private long TiempoDeCargaInicio;
    private long TiempoDeCargaFin;            

    public LPDefinirCondicionOfertaPerf(){
        super();
    }

    public void inicio() throws Exception{
        pagina("contenido_condicion_oferta_definir_perf");
    }

    public void ejecucion() throws Exception {
    
        TiempoDeCargaInicio=System.currentTimeMillis();    
        String sAccion = null;
        setTrazaFichero();
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        traza("Inicializando contenido_condicion_oferta_definir_perf");
        traza("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        
        try{
            /*............... Tomar valores iniciales de trabajo..................*/
            sAccion = conectorParametro("accion")==null?"":conectorParametro("accion");
            lPais = UtilidadesSession.getPais(this);
            lIdioma = UtilidadesSession.getIdioma(this);
            
            traza("Accion Seleccionada:  " +sAccion);
            /*.................... Se recargan los combos ...................*/
            cargarCombos();            

            /*................. Se carga el menu de la página ............*/
            this.getConfiguracionMenu("LPDefinirCondicionOfertaPerf","");
            this.getFormatosValidaciones();
                            
            if (sAccion.equals("")) {
            } 
            
            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            agregarMenuComplementario();
            // Fin agregado SICC20070322

            TiempoDeCargaFin = System.currentTimeMillis();
            traza("El tiempo de carga de LPDefinirCondicionOfertaPerf es :"+(TiempoDeCargaFin-TiempoDeCargaInicio));
            
        } catch(Exception e) {
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            e.printStackTrace(out);
            traza("El stack es como sigue : " + pila.toString());            
        }
    }

    private void cargarCombos() throws Exception{
      /*..... Recoge de sesión de la estrategia seleccionada .......*/
      lOidEstrategia = (Long) conectorParametroSesion("oidEstrategia");
      traza("+++++++++++++++++++++ Estrategia Seleccionada:  "+lOidEstrategia);

      /*..................... Crea un DTOOID .......................*/
      DTOOID dtoOid = new DTOOID();
      dtoOid.setOid(lOidEstrategia);
      dtoOid.setOidIdioma(lIdioma);
      dtoOid.setOidPais(lPais);
          
      /*...Crea el idBusiness="PRECargarCriteriosCondicionOferta...*/
      MareBusinessID id = new MareBusinessID("PRECargarCriteriosCondicionOferta");

      Vector paramEntrada = new Vector();
      paramEntrada.add(dtoOid);
      paramEntrada.add(id);
      
      /*.........Invoca a ConectorCriteriosCondicionOferta..........*/
      DruidaConector conSalida =  conectar("ConectorCriteriosCondicionOferta", paramEntrada);

      /*....... Recupera el DTOSCriteriosCondicionOferta ...........*/
      DTOSCriteriosCondicionOferta dtoS = (DTOSCriteriosCondicionOferta) conSalida.objeto("dtoSalida");

      /*..................... Carga Valores ........................*/
      /*............. - Indicadores cuadre de promocion ............*/
      asignar("COMBO","cbIndicadorCuadre",UtilidadesBelcorp.generarConector(  "dtoSalida",
                                                      dtoS.getIndicadoresCuadre(),
                                                      dtoS.getIndicadoresCuadre().getColumnIdentifiers()),
                                                      "dtoSalida");
      /*............. - Catalogos ..................................*/
      asignar("COMBO","cbCatalogo",UtilidadesBelcorp.generarConector(  "dtoSalida",
                                                      dtoS.getCatalogos(),
                                                      dtoS.getCatalogos().getColumnIdentifiers()),
                                                      "dtoSalida");
    }

    // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
    private void agregarMenuComplementario() throws Exception{
        if(conectorParametroSesion("descripcionPeriodo")!=null){
            DOMXPath xform = new DOMXPath("//PAGINA/FORMULARIO[VAR[@nombre='conectorAction']]");
            Element formulario = (Element)xform.selectSingleNode(getXML());
            if(formulario != null)
            {
                DOMXPath xpath = new DOMXPath("//VAR[@nombre='SICC_CUSTOM_TITTLE']");
                Node var = (Node)xpath.selectSingleNode(getXML());
                if(var == null)
                {
                    var = getXML().createElement("VAR");
                    ((Element)var).setAttribute("nombre", "SICC_CUSTOM_TITTLE");
                }
                ((Element)var).setAttribute("valor", (String)conectorParametroSesion("descripcionPeriodo"));
                
                formulario.appendChild(var);
            }
        }
    }
    // Fin agregado SICC20070322
}
