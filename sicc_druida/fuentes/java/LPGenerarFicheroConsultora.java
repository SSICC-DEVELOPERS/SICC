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

public class LPGenerarFicheroConsultora extends LPSICCBase {

  public LPGenerarFicheroConsultora() {
    super();
  }
    
  public void inicio() throws Exception {   
  }

  public void ejecucion() throws Exception {    
    rastreo();
    setTrazaFichero();
    try{
      traza("*********** Entre a LPGenerarFicheroConsultora");      
      conectorAction("LPNDG");	
     // conectorActionParametro("casoDeUso","Consulta Mensajes por Consultora");
      conectorActionParametro("accion", "");	
    } catch ( Exception e )  {
      traza("Exception en LPGenerarFicheroConsultora");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }
  }

  /*private void generar() throws Exception {
    traza("se va a generar el archivo");
    
    try {
      MareBusinessID idBusiness = new MareBusinessID("NDGGenerarFicheroConsultoras");
      Vector params = new Vector();
      DTOInformacionDeFiltrado dto = new DTOInformacionDeFiltrado();
      dto.setPais(UtilidadesSession.getPais(this));
      params.add(dto);
      params.add(idBusiness);
    traza("se va a hacer el conectar");
      DruidaConector con = conectar("ConectorGenerarFicheroDeUsuarios", params);
      //DTOSalida dtoSalida = (DTOSalida) 
      //con.objeto("dtoSalida");
      asignarAtributo("VAR","generado","valor","OK");
            
    } catch (Exception ex) {
    traza("hubo un error, llama a logStackTrace");
    logStackTrace(ex);
         java.io.StringWriter sw = new java.io.StringWriter();
         java.io.PrintWriter pw = new java.io.PrintWriter(sw);
         ex.printStackTrace(pw);
         pw.flush();      
         ex.printStackTrace();
         traza("el error fue " + ex);
         //asignarAtributo("VAR","errDescripcion","valor","Fichero no fue Generado Correctamente");
         this.lanzarPaginaError(ex);
      }

  }
*/
}
