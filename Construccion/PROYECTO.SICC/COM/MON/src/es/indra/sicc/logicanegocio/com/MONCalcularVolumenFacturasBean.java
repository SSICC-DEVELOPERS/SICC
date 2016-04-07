package es.indra.sicc.logicanegocio.com;
import es.indra.sicc.dtos.com.DTOGerenteZona;
import es.indra.sicc.dtos.com.DTOClienteComision;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import java.util.Date;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import es.indra.sicc.dtos.com.DTODatosCalculosComision;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasClienteLocal;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasClienteLocalHome;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasLocal;
import es.indra.sicc.entidades.com.ComisionesCobranzasAcumuladasLocalHome;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import javax.persistence.PersistenceException;


public class MONCalcularVolumenFacturasBean implements SessionBean 
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
      this.ctx = ctx;
  }
  
  SessionContext ctx;
   

 
   /**
   *@Author: Pcabrera, 08/04/2005
   *@throws es.indra.mare.common.exception.MareException
   *@return 
   *@param DTODatosCalculosComision dto
  */

  public void calcularVolumenFacturas(DTODatosCalculosComision dto) throws MareException {
        UtilidadesLog.info("MONCalcularVolumenFacturasBean.calcularVolumenFacturas(DTODatosCalculosComision dto): Entrada");
       
        DAOCalcularComisiones dao = new DAOCalcularComisiones();         
        DAOCalcularVolumenFacturas daoFact = new DAOCalcularVolumenFacturas();         
        
        DTOSalida tramosRecuperacion = daoFact.tramosRecuperacion(dto.getOidComision(), dto.getOidPais());
        RecordSet rs = tramosRecuperacion.getResultado();
  
        ArrayList  gerentes = dto.getGerentes();
        
        /// --- Por cada uno de los elementos del arrayList de gerentes
       
        for(int i = 0; i<gerentes.size(); i++){          
          
           BigDecimal acumulador = new BigDecimal(0);    
           
          // Long oidCliente = (Long)gerentes.get(i);  
          
          DTOClienteComision dtoC = (DTOClienteComision)gerentes.get(i);
          Long oidCliente = dtoC.getOid();
          
          
          UtilidadesLog.debug("oidCliente>>> " + oidCliente);
            
           DTOGerenteZona gerenteZona =  dao.validarGerente(oidCliente, dto); 
                      
           if (gerenteZona==null)
              continue;
       
           ComisionesCobranzasAcumuladasClienteLocalHome comisionesALocalHome= null;
           ComisionesCobranzasAcumuladasClienteLocal comisionesALocal = null;   
           
           ComisionesCobranzasAcumuladasLocalHome comisionesLocalHome= null;
           ComisionesCobranzasAcumuladasLocal comisionesLocal  = null;       
           
          
           DTOSalida consultoras = dao.recuperarConsultoras(dto.getOidPeriodo(),gerenteZona);          
           RecordSet rsConsultoras = consultoras.getResultado();
           UtilidadesLog.debug("rsConsultoras ---- " + rsConsultoras.getRowCount());
           
           
          /// -- Por cada una de las consultoras obtenidas:::
           ArrayList arrayConsultoras = new ArrayList();
           for(int x=0; x < rsConsultoras.getRowCount(); x++){
          
              Long oid = new Long(((BigDecimal) rsConsultoras.getValueAt(x,"CLIE_OID_CLIE")).longValue());
              arrayConsultoras.add(oid);
              //BigDecimal valor = dao.calcularCuotas(dto.getOidPeriodo(), oid);
              
              //acumulador = acumulador.add(valor);   
          
           }// --Fin   
           if (arrayConsultoras.size()>0){
              acumulador = dao.calcularCuotas(dto.getOidPeriodo(), arrayConsultoras);
           }
          
           try {
               comisionesLocalHome = this.getComisionesCobranzasAcumuladasLocalHome(); 
                                      
               Long comision = dto.getOidComision();
               
               Long periodo = dto.getOidPeriodo();               
               
               UtilidadesLog.debug("ComisionesCobranzasAcumuladas create: ");
               UtilidadesLog.debug("acumulador: " + acumulador );
               UtilidadesLog.debug("oidCliente: " + oidCliente );
               UtilidadesLog.debug("comision: " + comision );
               UtilidadesLog.debug("periodo: " + periodo );
               UtilidadesLog.debug("Fin create ");
               comisionesLocal = comisionesLocalHome.create(acumulador,oidCliente,comision, periodo);
                  
           } catch(PersistenceException e) {
                ctx.setRollbackOnly();
                UtilidadesLog.error("ERROR ", e);
                throw new MareException(e,
                       UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
           }      
          
          Long oidComisionAcumulada = null;
          oidComisionAcumulada = comisionesLocal.getOid();
                    
          // -- Por cada registro recuperado en tramosRecuperacion
          for(int j=0;j<rs.getRowCount();j++){   
            UtilidadesLog.debug("Posicion " + j + " del RS: " + rs.getRow(j));
          
            try {
                 comisionesALocalHome  = this.getComisionesCobranzasAcumuladasClienteLocalHome();
                 
                 Integer nivelTramo = new Integer(((BigDecimal)rs.getValueAt(j,"VAL_NIVE_TRAM")).toString());
                 Date fechaCalc = new Date(new Date(System.currentTimeMillis()).getTime());         
                 
                 /* 23287 - dmorello, 05/06/2006: Si NUM_DIAS_COMI es null se toma valor cero */
                 //Integer numeroDiasParaComison = new Integer(((BigDecimal)rs.getValueAt(j,"NUM_DIAS_COMI")).toString());
                 BigDecimal numDiasComi = (BigDecimal)rs.getValueAt(j,"NUM_DIAS_COMI");
                 BigDecimal numDiasTrasFact = (BigDecimal)rs.getValueAt(j,"NUM_DIAS_TRAS_FACT");
                 int numeroDiasParaComison = (numDiasComi != null)? numDiasComi.intValue() : 0;
                 int numeroDiasTrasFacturacion = (numDiasComi != null)? numDiasTrasFact.intValue() : 0;
                 // Fin 23287 dmorello 05/06/2006
                 
                 Integer numDias = new Integer(numeroDiasTrasFacturacion + numeroDiasParaComison);
                 
                 Double porcRecuperado = null;         
                 Double porcObjetivo = new Double(((BigDecimal)rs.getValueAt(j,"VAL_PORC_RECU")).toString());         
                 Double porcComision = new Double(((BigDecimal)rs.getValueAt(j,"VAL_PORC_COMI")).toString());  
                            
                 UtilidadesLog.debug("ComisionesCobranzasAcumuladasCliente create: ");
                 UtilidadesLog.debug("nivelTramo: " + nivelTramo );
                 UtilidadesLog.debug("fechaCalc: " + fechaCalc );
                 UtilidadesLog.debug("numDias: " + numDias );
                 UtilidadesLog.debug("porcComision: " + porcComision);
                 UtilidadesLog.debug("porcOb: " + porcObjetivo );
                 UtilidadesLog.debug("oidComisionAcumulada: " + oidComisionAcumulada );
                 comisionesALocal = comisionesALocalHome.create(nivelTramo, fechaCalc, numDias, porcComision, porcObjetivo , oidComisionAcumulada);
                 UtilidadesLog.debug("Fin create ");
                 
            } catch(PersistenceException e) {
                 ctx.setRollbackOnly();
                 UtilidadesLog.error("ERROR ", e);
                 throw new MareException(e,
                        UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
            } catch(Exception  ex){
                 UtilidadesLog.error(ex);
                 throw new MareException(ex,
                 UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                                 
            }    
           
          }
      
      } /// -- Fin del for
      
      UtilidadesLog.info("MONCalcularVolumenFacturasBean.calcularVolumenFacturas(DTODatosCalculosComision dto): Salida");
  }
  
     private ComisionesCobranzasAcumuladasClienteLocalHome getComisionesCobranzasAcumuladasClienteLocalHome()  throws MareException {
             
        return new ComisionesCobranzasAcumuladasClienteLocalHome();
     }


      private ComisionesCobranzasAcumuladasLocalHome getComisionesCobranzasAcumuladasLocalHome()  throws MareException {
         
        return new ComisionesCobranzasAcumuladasLocalHome();
     }
 
 }
