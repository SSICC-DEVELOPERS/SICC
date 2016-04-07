import java.util.StringTokenizer;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;

import java.util.Vector;
import java.text.SimpleDateFormat;


// Definicion de la clase
public class LPRegenerarCuentaCorriente extends LPSICCBase {
              
         private String accion = null;
         
         public LPRegenerarCuentaCorriente() {
                  super();
         }
         
         public void inicio() throws Exception {
                  // Asignar nombre de la vista
                  pagina("contenido_cuenta_corriente_regenerar");	
         }
         
         public void ejecucion() throws Exception {
                  traza("***Entrada -  LPRegenerarCuentaCorriente - ejecucion ***");

                  this.accion = conectorParametroLimpia("accion","", true);

                  traza("***accion recuperada ***"+ this.accion);

                  try {
                           if (this.accion.equals("")) {
                                    getConfiguracionMenu("LPRegenerarCuentaCorriente", accion);
									this.accionVacia();
                           } else if (this.accion.equals("regenerar")) {
                                    accionRegenerar();
                           } 
                  } catch (Exception e) {
                           lanzarPaginaError(e); 
                  }

                  traza("***Salida -  LPRegenerarCuentaCorriente - ejecucion ***");
         }
         
         private void accionVacia() throws Exception {
			//this.generarHiddenFormatoFecha();
            // Se carga el combo de la página
            this.cargaCombos();
         }
         


         private void accionRegenerar() throws Exception {
                  traza("***Entrada -  LPRegenerarCuentaCorriente - accionRegenerar ***");
				  
				  String fechaStr = conectorParametroLimpia("fechaFacturacion", "", true);
				  String tiposSolic = conectorParametroLimpia("tiposSolicitud", "", true);
				  SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
				  java.util.Date fecha= sf.parse(fechaStr);

				  DTOOIDs oids = new DTOOIDs();
				  StringTokenizer tok = new StringTokenizer(tiposSolic,",");
				  Long[] oid = new Long[tok.countTokens()];
				  int posicion = 0;
				  while(tok.hasMoreTokens()){
					oid[posicion] = new Long(tok.nextToken());
					posicion+=1;
				  }
				  oids.setOids(oid);
				  oids.setOidIdioma(new Long(fecha.getTime()));//esta feo, pero es lo que hay
                  MareBusinessID idBusiness = new MareBusinessID("CCCRegenerarCuentaCorriente");

                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(oids);
                  paramEntrada.addElement(idBusiness);

                  conectar("ConectorConfirmarMovBanc", paramEntrada);
                  cargaCombos();
                  traza("***Salida -  LPRegenerarCuentaCorriente - accionRegenerar ***");
         }

         
         private void cargaCombos() throws Exception {
                  //Cada elemento va a contener el IDbusiness y el DTO que reciben la logica de negocio como entrada. 
                  ComposerViewElementList listelem = new ComposerViewElementList();
                  ComposerViewElement elem = new ComposerViewElement();

				  DTOBelcorp dtoBelcorp = new DTOBelcorp();
				  dtoBelcorp.setOidPais(UtilidadesSession.getPais(this));
				  dtoBelcorp.setOidIdioma(UtilidadesSession.getIdioma(this));
                  elem.setIDBusiness("PEDobtieneTiposSolicitudPorPais");
                  elem.setDTOE(dtoBelcorp);
                  listelem.addViewElement(elem);
                  /*Se ejecuta el conector y se obtiene un RowSet que contiene todos los datos solicitados.*/ 
                  ConectorComposerView conector = new ConectorComposerView(listelem, this.getRequest());
                  conector.ejecucion();
                  DruidaConector conConsultar = conector.getConector();
                  /*Posterior a la llamada se debe hacer el asignar a los elementos de la pantalla correspondiente utilizando el String que representa el BusinessID en cada caso. */
                  asignar("COMBO", "comboCCC", conConsultar, "PEDobtieneTiposSolicitudPorPais"); 
         }
}