package es.indra.sicc.rep.logicanegocio;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.rep.dtos.DTOCriteriosReportes;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.rep.dtos.DTOReporte;
import es.indra.sicc.rep.dtos.DTOReportID;
import es.indra.mare.common.exception.MareException;
//import es.indra.sicc.cmn.negocio.batch.DTOBatch;
//import es.indra.sicc.cmn.negocio.batch.MONBatch;

public class MONFrontReportBean implements SessionBean 
{
  public void ejbCreate(){
  }

  public void ejbActivate(){
  }

  public void ejbPassivate(){
  }

  public void ejbRemove(){
  }

  public void setSessionContext(SessionContext ctx) {
  }
 /**
  * mdolce - 28/01/2005 
  *
  * Metodo utilizado para buscar los reportes segun criterios
  *
  * @param DTOCriteriosReportes
  *
  * @return DTOSalida
  *
  * @throws MareException
 */
   

  public DTOSalida buscarReportes(DTOCriteriosReportes dtoin) throws MareException{
    DTOSalida dto = new DTOSalida();
    DAOFrontReport dao = new DAOFrontReport();
    
    dto.setResultado(dao.consultarReportes(dtoin));
       
    return dto;
  }
  
   /**
    * mdolce - 28/01/2005
    *
    * Metodo que devuelve un array de bytes obtenido de un blob donde esta el reporte.pdf
    *
    * @param DTOOID
    *
    * @return DTOReporte
    *
    * @throws MareException 
   */

  public DTOReporte getReporte(DTOOID dtoin) throws MareException{
    /*Obtienen el arreglo de byte que conforma el reporte solicitado. 
      Hace un findByPrimarykey sobre la entidad GEN_REPORTESEJB y obtiene el arreglo de byte con el infome. 
      Si no lo encuentra genera una MAREException indicando que el inform no ha sido generado */

    
    DTOReporte dto = new DTOReporte();
    
    
    return dto;
  }
  
   /**
    * mdolce - 28/01/2005
    * 
    * Metodo que llama a batch para que genere el informe
    *
    * @param MAREDTO(cualquier dto)
    *
    * @return DTOReportID
    *
    * @throws MareException - DOCUMENT ME!
   */

  public DTOReportID startReport(DTOReporte dtoin) throws MareException{
  /*Llama al subsistema batch para que inicie la generacion del informe 
    retorna un DTOReportId con el identificador del proceso batch en ejecucion*/
    DTOReportID dto = new DTOReportID();
     
    
        

  
  
    return dto;
  }
}