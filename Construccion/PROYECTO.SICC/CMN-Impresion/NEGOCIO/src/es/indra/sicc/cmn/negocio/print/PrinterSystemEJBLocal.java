package es.indra.sicc.cmn.negocio.print;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.ejb.EJBLocalObject;

import es.indra.mare.common.exception.MareException;

public interface PrinterSystemEJBLocal extends EJBLocalObject 
{
  Long addDocument(Long idQueue, Long numSecuencia, byte[] buffer, boolean ghostDoc) throws MareException;

  RecordSet validatePrint(PrinterQueues pqThis) throws MareException;
}