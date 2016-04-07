package es.indra.sicc.cmn.negocio.print;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
//import es.indra.sicc.util.BelcorpService;
//import es.indra.sicc.util.CodigosError;
//import es.indra.sicc.util.UtilidadesEJB;
//import es.indra.sicc.util.UtilidadesError; 
import es.indra.sicc.util.UtilidadesLog;

import es.indra.mare.common.exception.MareException;

public class PrinterSystemEJBBean implements SessionBean {
        
    private SessionContext ctx;
  
    public void ejbCreate(){
    }
  
    public void ejbActivate(){
    }
  
    public void ejbPassivate(){
    }
  
    public void ejbRemove() {
    }
  
    public void setSessionContext(SessionContext ctx){
          this.ctx = ctx;
    }

    public Long addDocument(Long idQueue, Long numSecuencia, byte[] buffer, boolean ghostDoc) throws MareException {
        UtilidadesLog.debug("***MON  PrinterSystemEJBBean.addDocument: Entrada");
        Long retorno = null;
        try{
            DAOPrinterSystem dao = new DAOPrinterSystem();
      
            retorno = dao.addDocument(idQueue, numSecuencia, buffer, ghostDoc);
            UtilidadesLog.debug("***MON  PrinterSystemEJBBean.addDocument: Salida");
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        return retorno;
    }


    private IMPPrintableDocumentLocalHome getIMPPrintableDocumentLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (IMPPrintableDocumentLocalHome)context.lookup("java:comp/env/ejb/IMPPrintableDocumentLocal");
    }

    public RecordSet validatePrint(PrinterQueues pqThis) throws MareException{
        UtilidadesLog.debug("***MON  PrinterSystemEJBBean.validatePrint: Entrada");
        RecordSet rs=null;
        try{
            rs= pqThis.validatePrintConditions();
        }catch(Exception e){
            UtilidadesLog.error("ERROR",e);
            throw new MareException(e);
        }
        UtilidadesLog.debug("PrinterSystemEJBBean validatePrint ya salida  ");
        UtilidadesLog.debug("***MON  PrinterSystemEJBBean.validatePrint: salida");
        return rs;  
    }

    private IMPQueueLocalHome getIMPQueueLocalHome() throws NamingException{
        final InitialContext context = new InitialContext();
        return (IMPQueueLocalHome)context.lookup("java:comp/env/ejb/IMPQueueLocal");
    }
}