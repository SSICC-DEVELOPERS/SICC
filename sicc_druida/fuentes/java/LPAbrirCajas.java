
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.bel.DTOCopiarParametrosBelcenter;
import es.indra.sicc.logicanegocio.bel.ConstantesBEL;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOBoolean;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;

import java.io.*;

import java.util.StringTokenizer;
import java.util.Vector;

public class LPAbrirCajas extends LPSICCBase {		

	public LPAbrirCajas() {	 
     super();
  }

	public void inicio() throws Exception { 
     //pagina("contenido_territorio_seleccionar"); 
  }

	public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        traza("la accion es " + accion);
        if(accion.equals("")){
           cargarPagina();
        }

        if(accion.equals("guardar")){
           guardar();  
        }
       

     } catch (Exception ex) {

				ByteArrayOutputStream stack = new ByteArrayOutputStream();
				PrintStream out = new PrintStream(stack);
				ex.printStackTrace(out);
				traza("EXCEPCION:" + stack.toString());
				lanzarPaginaError(ex);

     }

     getConfiguracionMenu();
  }

  private void cargarPagina() throws Exception{
     pagina("contenido_cajas_abrir");

     String dirIp = UtilidadesBelcorp.getIPCliente(this);
     DruidaConector con = null;
     DTOSalida dtoS = null;

     DTOString dto = new DTOString();

     dto.setCadena(dirIp);
     dto.setOidPais(UtilidadesSession.getPais(this));
     traza("el dto es " + dto);
     MareBusinessID id = new MareBusinessID("BELAbrirCajasConsulta");
     
     Vector param = new Vector();

     param.add(dto);
     param.add(id);
     
     con = conectar("ConectorAbrirCajasConsulta",param);

     
     if( con != null ){

       dtoS = (DTOSalida)con.objeto( "DTOSalida");
       RecordSet res = dtoS.getResultado();

       if(!res.esVacio()){
          DruidaConector conLista = UtilidadesBelcorp.generarConector("LISTA", res, res.getColumnIdentifiers());
          asignar("LISTADOA", "listado1", conLista, "LISTA");

       }
     }
 
  }

  private void guardar() throws Exception{
     pagina("contenido_cajas_abrir");
     DTOOIDs cajas = new DTOOIDs();
     DruidaConector con = null; 
     

     String oids = conectorParametroLimpia("datosEnviar", "", true);
     traza("los oids " + oids);
          
     StringTokenizer tok = new StringTokenizer(oids, ",");

     Long[] oidV = new Long[tok.countTokens()];

     int contador = 0;

     while (tok.hasMoreTokens()) {
        oidV[contador] = new Long(tok.nextToken()); 
        contador ++;   
     }
     
     cajas.setOids(oidV);
     traza("********el dto " + cajas.getOids());
      

     //-> Guardar en "cajas" aquellos oids de caja que estén con estado de caja = ConstantesBEL.CAJA_ABIERTA

     MareBusinessID id = new MareBusinessID("BELAbrirCajas");
     Vector param = new Vector(); 
     param.add(cajas);
     param.add(id);

     traza("antes de conectar");
     con = conectar("ConectorAbrirCajas",param);
     traza("conecto");

     conectorAction("LPAbrirCajas");
     conectorActionParametro("accion", "");
   

  }
   
}
