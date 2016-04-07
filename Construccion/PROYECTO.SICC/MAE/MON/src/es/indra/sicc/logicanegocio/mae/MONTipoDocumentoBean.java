package es.indra.sicc.logicanegocio.mae;
import es.indra.belcorp.mso.MaeTipoDocumData;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;


public class MONTipoDocumentoBean implements SessionBean 
{
  public void ejbCreate()
  {
  }

  public void ejbActivate()
  {
  }

  public void ejbPassivate()
  {
  }

  public void ejbRemove()
  {
  }

  public void setSessionContext(SessionContext ctx)
  {
  }
  
  public Hashtable insertar(MaeTipoDocumData maeTipoDocumData, Vector vector , HashMap userProperties) throws MareException
    {        
        DAOTipoDocumento daoTipoDocumento = new DAOTipoDocumento();
    
        return daoTipoDocumento.insertar( maeTipoDocumData,  vector,  userProperties) ;
    }

  public Vector query(MaeTipoDocumData maeTipoDocumFrom, MaeTipoDocumData maeTipoDocumTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
  {
      DAOTipoDocumento daoTipoDocumento = new DAOTipoDocumento();
  
      return daoTipoDocumento.query(maeTipoDocumFrom, maeTipoDocumTo, userProperties, pageCount, pageSize);
  }

  public void remove(Vector MaeTipoDocumData ) throws MareException
  {
      DAOTipoDocumento daoTipoDocumento = new DAOTipoDocumento();
  
      daoTipoDocumento.remove(MaeTipoDocumData);
  }

  public void update(MaeTipoDocumData MaeTipoDocumData, Vector localizationLabels) throws MareException
  {
      DAOTipoDocumento daoTipoDocumento = new DAOTipoDocumento();
  
      daoTipoDocumento.update(MaeTipoDocumData, localizationLabels);
  }
 
  //sapaza -- PER-SiCC-2010-0487 -- 16/08/2010          
  public DTOSalida obtenerTiposDocumentoPorSigla(DTOBelcorp DTOE) throws MareException  {
      UtilidadesLog.info("MONTipoDocumentoBean.obtenerTiposDocumentoPorSigla(DTOBelcorp): Entrada"); 
      DTOSalida dtoSalida = new DTOSalida();
      DAOTipoDocumento daoTipoDocumento = new DAOTipoDocumento();
      RecordSet tiposDocumentos = daoTipoDocumento.obtenerTiposDocumentoPorSigla(DTOE);
      dtoSalida.setResultado(tiposDocumentos);
      UtilidadesLog.info("MONTipoDocumentoBean.obtenerTiposDocumentoPorSigla(DTOBelcorp): Salida"); 
      
      return dtoSalida;
  }
  
}