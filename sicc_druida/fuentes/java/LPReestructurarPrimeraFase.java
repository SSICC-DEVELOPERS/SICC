//import LPGenericaSubirFichero;
import es.indra.sicc.dtos.zon.DTOPeriodosRezonificacion;
import es.indra.sicc.dtos.cra.DTOPeriodo;

import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroDisp;
import es.indra.sicc.cmn.presentacion.subidaFichero.DTOFicheroResultado;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.util.UtilidadesBelcorp;
import java.util.Vector;
import java.util.Collection;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.mare.common.mln.MareBusinessID;
import es.indra.druida.DruidaConector;

public class LPReestructurarPrimeraFase extends LPGenericaSubirFichero {

  public LPReestructurarPrimeraFase() {
    super();
  }

/*  public void inicio() throws Exception {

     String accion = conectorParametroLimpia("accion", "", true);

     if(accion.equals("")){
          pagina("contenido_seleccion_fichero");
     }else{
          pagina("contenido_resultado_fichero");
     }

  }   */ 

         public void ejecucion() throws Exception {
                  rastreo();
                  setTrazaFichero();
                  traza("*** Entrada - LPReestructurarPrimeraFase - ejecucion ***");

                  try {
                  String accion = conectorParametroLimpia("accion", "", true);

                           if (accion.equals("")) {
                                    this.seleccionar();
                                    getConfiguracionMenu("LPReestructurarPrimeraFase", accion);
                           } else if (accion.equals("procesar")) {
                                    this.procesar();
                                    getConfiguracionMenu("LPReestructurarPrimeraFase", accion);
                           } else if (accion.equals("Rezonificar")) {
                                    this.rezonificar();
                           }


                  } catch(Exception e) {
                           logStackTrace(e);
                           lanzarPaginaError(e);
                  }
                  traza("*** Salida - LPReestructurarPrimeraFase - ejecucion ***");
    
         }


         public void seleccionar() throws Exception {
                  traza("*** Entrada - LPReestructurarPrimeraFase - seleccionar ***");
                  pagina("contenido_seleccion_fichero");
                  asignar("VAR", "conectorAction", "LPReestructurarPrimeraFase");
                  asignar("VAR", "accion", "procesar");
                  asignarAtributo("PAGINA", "contenido_seleccion_fichero", "cod", "00661"); //"Selección fichero Rezonificación" 

                  traza("*** Salida - LPReestructurarPrimeraFase - seleccionar ***");
         }
         public void procesar() throws Exception {
                  traza("*** Entrada - LPReestructurarPrimeraFase - procesar ***");
                  pagina("contenido_unidades_administrativas_primera_fase_reestructurar");
                  Long pais = UtilidadesSession.getPais(this); 
                  Long idioma = UtilidadesSession.getIdioma(this);

                  String s1 = this.getDirTempDruida();
                  String s2 = conectorParametroLimpia("seleccion", "", true); 
                  String s3 = this.getWebTmpDir(); 

                  DTOFicheroDisp dtoin = new DTOFicheroDisp();
                  dtoin.setNombreFichero(s2); 
                  dtoin.setPathFichero(s3); 
                  dtoin.setOidPais(pais);
                  dtoin.setOidIdioma(idioma);
    
    traza("DTOFicheroDisp: " + dtoin);

                  //Los atributo TypeProc y Datos se deben asignar si el metodo de negocio que va a procesar el fichero los requiere. 

                  //Se crea el idbusiness "ZONObtenerPeriodoRezonificacion" 
                  MareBusinessID idBussiness = new MareBusinessID("ZONObtenerPeriodoRezonificacion");
                  
                  
                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoin);
                  paramEntrada.addElement(idBussiness);
                  
                  //Se ejecuta el conector "ConectorProcesarFichero" 
                  traza("*** invocamos conector ***");
                  DruidaConector conector = conectar("ConectorProcesarFichero", paramEntrada);

                  DTOFicheroResultado dtoFicheroResultado = (DTOFicheroResultado)conector.objeto("dtoSalida");
                  if (dtoFicheroResultado != null) {
                           traza("*** DTOFicheroResultado ***: " + dtoFicheroResultado);
                           DTOPeriodosRezonificacion periodos = (DTOPeriodosRezonificacion)dtoFicheroResultado.getDatos();
         
                           if (periodos != null) {
                                    if (periodos.getPeriodoPropuesto() != null) {
                                             asignar("LABELC", "lblPeriodo", periodos.getPeriodoPropuesto().getCodigoPeriodo());
                                             if (periodos.getPeriodoPropuesto().getOid() != null)
                                                      asignar("VAR", "oidPeriodoPropuesto", periodos.getPeriodoPropuesto().getOid().toString());
                                    }

                                    if (periodos.getPeriodoSinSolapar() != null) {
                                             asignar("LABELC", "lblPeriodo2", periodos.getPeriodoSinSolapar().getCodigoPeriodo());
                                             if (periodos.getPeriodoSinSolapar().getOid() != null)
                                                      asignar("VAR", "oidPeriodoSinSolapar", periodos.getPeriodoSinSolapar().getOid().toString());
                                    }

                                    Collection coleccion = periodos.getListaPosteriores();
                                    if (coleccion != null) {
                                             Object [] lista = coleccion.toArray();
                                             RecordSet rs = new RecordSet();
                                             rs.addColumn("oid");
                                             rs.addColumn("descripcion");
                  
                                             for (int i = 0; i < lista.length; i++) {
                                                      DTOPeriodo period = (DTOPeriodo)lista[i];
                                                      Object[] fila = new Object[2];
                                                      fila[0] = period.getOid();
                                                      fila[1] = period.getCodigoPeriodo();
                                                      rs.addRow(fila);
                                             }
                  
                                             conector = UtilidadesBelcorp.generarConector("DTOSalida.combo_ROWSET", rs, rs.getColumnIdentifiers()); 
                                                    
                                             // Se carga el combo
                                             asignar("COMBO", "cbPeriodo", conector, "DTOSalida.combo_ROWSET");
                                    }
                           }
                  }

                  asignar("VAR", "nombreFichero", s2);
                  asignar("VAR", "pathFichero", s3);
    
    // vbongiov -- ZON-03 -- 8/11/2007
    String casoDeUso = conectorParametroLimpia("casoDeUso", "", true); 
    asignar("VAR", "casoDeUso", casoDeUso);


                  traza("*** Salida - LPReestructurarPrimeraFase - procesar ***");
         }

         private void rezonificar() throws Exception {
                  traza("*** Entrada - LPReestructurarPrimeraFase - rezonificar ***");
                  pagina("salidaGenerica");

                  Long pais = UtilidadesSession.getPais(this); 
                  Long idioma = UtilidadesSession.getIdioma(this);

                  DTOFicheroDisp dtoin = new DTOFicheroDisp();
                  dtoin.setNombreFichero(conectorParametro("nombreFichero")); 
                  dtoin.setPathFichero(conectorParametro("pathFichero")); 
                  dtoin.setOidPais(pais);
                  dtoin.setOidIdioma(idioma);
                  dtoin.setDatos(new Long(conectorParametro("oidPeriodo")));

                  MareBusinessID idBussiness = new MareBusinessID("ZONLanzarRezonificacionPrimeraFase");
                  
                  
                  // Se almacenan los parametros de entrada
                  Vector paramEntrada = new Vector();
                  paramEntrada.addElement(dtoin);
                  paramEntrada.addElement(idBussiness);
                  
                  traza("*** invocamos conector ***");
                  DruidaConector conector = conectar("ConectorRezonificacionPrimeraFase", paramEntrada);

                  traza("*** Salida - LPReestructurarPrimeraFase - rezonificar ***");
                  //Cleal - 21495 - 21808
             asignarAtributo("VAR", "ejecutar", "valor", "mensajeProcesando()");

         }

         private void logStackTrace(Throwable e) throws Exception {
                  traza("Se produjo la excepcion: " + e.getMessage());
                  
                  ByteArrayOutputStream baos = new ByteArrayOutputStream();
                  PrintStream ps = new PrintStream(baos);
                  e.printStackTrace(ps);
                  
                  traza("Stack Trace: " + baos.toString());
         }

  
}