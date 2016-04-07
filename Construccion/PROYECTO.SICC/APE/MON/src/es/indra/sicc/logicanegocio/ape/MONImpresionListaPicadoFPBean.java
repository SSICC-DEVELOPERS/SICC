package es.indra.sicc.logicanegocio.ape;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOBusquedaListaPicadoFP;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.entidades.ape.ListaPicadoCabeceraLocal;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOColeccion;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.Iterator;
import es.indra.sicc.entidades.ape.ListaPicadoCabeceraLocalHome;
import es.indra.sicc.logicanegocio.ape.ConstantesAPE;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONImpresionListaPicadoFPBean implements SessionBean  {

  private SessionContext ctx;

  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
    this.ctx = ctx;
  }
  
  /** 
  * Autor: hhernandez
  * Fecha: 01-03-2007
  * Descripcion: Busca Lista de  Picado cabecera 
  * @param dtoE DTOBusquedaListaPicadoFP
  * @return DTOSalida 
  * @exception MareException 
  */  
  public DTOSalida buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFP dtoE) throws MareException {
    UtilidadesLog.info("MONImpresionListaPicadoFPBean.buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFP dtoE): Entrada");
    DTOSalida dtoSalida = new DAOImpresionListaPicadoFP().buscarListaPicadoCabeceraFP(dtoE);
    UtilidadesLog.info("MONImpresionListaPicadoFPBean.buscarListaPicadoCabeceraFP(DTOBusquedaListaPicadoFP dtoE): Salida");
    return dtoSalida;
  }

  /** 
  * Autor: hhernandez
  * Fecha: 01-03-2007
  * Descripcion: 
  * @param dtoE DTOColeccion
  * @return DTOSalida 
  * @exception MareException 
  */    
  public void imprimirListaPicadoCabeceraFP(DTOColeccion dtoE) throws MareException {
    //DTOSalida dtoGrupos = this.consulta(marca, pais, canal, idioma);
    Iterator iterator =  dtoE.getLista().iterator();  //dtoE.getResultado().getRecords().iterator();
    ListaPicadoCabeceraLocalHome listaPicadoCabeceraLH = null;
    ListaPicadoCabeceraLocal lista = null;
    while (iterator.hasNext()) {
      /*
       * FALTA IMPLEMENTAR ESTA PARTE DE LA IMPRESION
       * LLamamos a IREp.listaDePicado(dtoE.geElement()) 
       * FALTA IMPLEMENTAR ESTA PARTE DE LA IMPRESION
       * */
      try{
          DTOListaPicado dtoListaPicado = (DTOListaPicado) iterator.next();
          listaPicadoCabeceraLH = new ListaPicadoCabeceraLocalHome();
          lista = listaPicadoCabeceraLH.findByPrimaryKey(dtoListaPicado.getOidListaPicado());
          lista.setIndicadorImpresion(ConstantesAPE.IMPRESION_SI.toString());
          try {
              listaPicadoCabeceraLH.merge(lista);
          } catch (PersistenceException e) {
              ctx.setRollbackOnly();
              UtilidadesLog.error("ERROR ", e);
              throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
          }
      } catch (NoResultException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } catch (PersistenceException e) {
          ctx.setRollbackOnly();
          UtilidadesLog.error("ERROR ", e);
          throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }      
    }
  }

}