 /*
 Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 Avda. de Bruselas, 35
 Parque Empresarial Arroyo de la Vega
 28108 Alcobendas, Madrid
 España
 Privado y Confidencial.
 La información contenida en este documento es propiedad de Indra sistemas.
 Para uso exclusivo de empleados autorizados no permitiéndose
 la distribución de este código sin permiso expreso.
*/
//------------------------------------------------------------------------------
/* 
Sistema:             Belcorp - SICC
Modulo:              PRE - Precios
Componente:          LPCrearMF
Fecha:               04/03/2004
Dcoumentacion:       
Observaciones:
@version             3.0
@author              Hugo Andrés Mansi
*/
//------------------------------------------------------------------------------


import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.pre.DTOCabecCatal;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.util.Vector;

import org.jaxen.dom.DOMXPath;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

//import es.indra.mare.common.exception.MareException;


public class LPCrearMF extends LPSICCBase {
    //definicion de variables
    private String accion = null;
    private Long oidCabeceraMF = null;

  //Contructor
    public LPCrearMF() {
        super();
    }

    public void inicio() throws Exception {
      pagina("contenido_erroresMF");
    }

    public void ejecucion() throws Exception {

        setTrazaFichero();

        try {
            rastreo();
            //Traemos las variables de la pagina
            accion=conectorParametroLimpia("accion","",true);
            traza("accion: "+ accion);

            if (accion.equals("")){
                traza("entro al if");
                conectorParametroSesion("UltimaLP", "LPCrearMF");
                conectorAction("LPSeleccionarMF");
                //conectorActionParametro("nueva", "false");
            }
            else if (accion.equals("Matriz seleccionada")){
                traza("entro al else");
                cargarCatalogo();
            }else if (accion.equals("CatalogoSeleccionado")){
                traza("entro al CatalogoSeleccionado");
                crearMF();
            }

            // Agregado por SICC20070322 - Rafael Romero - 24/07/2007
            getConfiguracionMenu();
            agregarMenuComplementario();
            // Fin agregado SICC20070322

        }catch (Exception ex){
                
            traza("pincho la lp principal");
            ByteArrayOutputStream pila = new ByteArrayOutputStream();
            PrintStream out = new PrintStream(pila);
            ex.printStackTrace(out);
            traza("EL STACK ES COMO SIGUE : " +  pila.toString());
            ex.printStackTrace(); 
            ex.getMessage();
            this.lanzarPaginaError(ex);		  
        }
    }

    private void crearMF()throws Exception{
        Vector paramEntrada = new Vector();
        MareBusinessID id = new MareBusinessID("PRECrearMF");
        //DTOOID dto = new DTOOID();
		DTOCabecCatal dto = new DTOCabecCatal();

		String sCatalogo = null; 
		Long oidCatalogo = null; 
		sCatalogo = conectorParametroLimpia("cbCatalogo","",true);
		traza(" >>>>Catalogo:" + sCatalogo);
		if (!sCatalogo.equals("")){
			traza(" >>>>Catalogo != null");
			oidCatalogo = new Long (sCatalogo);	
		}
		traza(" >>>>Obtuve oidCatalogo "  + oidCatalogo);


        Long oid = (Long) this.conectorParametroSesion("oidCabeceraMF");				   
        traza("oidCabeceraMF " + conectorParametroSesion("oidCabeceraMF"));
		//dto.setOid(oid);
        dto.setOidCabecera(oid);
        //dto.setIpCliente(UtilidadesSession.getIdUsuario(this));
        //dto.setPrograma(UtilidadesSession.getFuncion(this));
        dto.setOidPais(UtilidadesSession.getPais(this)); 
        dto.setOidIdioma(UtilidadesSession.getIdioma(this));

		dto.setOidCatalogo (oidCatalogo); 

        paramEntrada.add(dto);
        paramEntrada.add(id);
        traza("antes del conetor");
        traza("parametros de entrada " + paramEntrada);
        DruidaConector conector = conectar("ConectorCrearMF", paramEntrada);
        traza("despues del conector");
        conectorParametroSesion("UltimaLP", "LPCrearMF");
        // Modificado por SICC20070322 - Rafael Romero - 26/07/2007
        //conectorAction("LPCrearMF");
        //conectorActionParametro("accion", "");
        conectorAction("LPSeleccionarMF");
        conectorActionParametro("accion", "ElegirMatriz");
        // Fin modificado SICC20070322
  }

  private void cargarCatalogo() throws Exception {
	  traza(" >>>>Entra en cargarCatalogo ");
	  this.pagina("contenido_catalogo_seleccion"); 
	  ComposerViewElementList cv = crearParametrosEntrada();
	  traza(" >>>Se crearon Parametros de Entrada ");
	  ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
	  conector.ejecucion();
	  traza(" >>>Se ejecuto el conector ");
	  DruidaConector resultados = conector.getConector();
	  asignar("COMBO", "cbCatalogo", resultados, "MAVCargarCatalagosBP");
	  asignarAtributo("VAR","lpOrigen","valor","LPCrearMF");
	  traza(" >>>Se asignaron los valores ");

   }

   private ComposerViewElementList crearParametrosEntrada() throws Exception {
		ComposerViewElementList lista = new ComposerViewElementList(); 
		DTOBelcorp dtobcp = new DTOBelcorp();
		UtilidadesSession sesion = new UtilidadesSession();

		dtobcp.setOidIdioma(sesion.getIdioma(this));
		dtobcp.setOidPais(sesion.getPais(this));

		ComposerViewElement ci1 = new ComposerViewElement();
		ci1.setIDBusiness("MAVCargarCatalagosBP");          
		ci1.setDTOE(dtobcp);
		lista.addViewElement(ci1);

		return lista;

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

  
