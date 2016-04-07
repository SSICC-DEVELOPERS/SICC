package es.indra.sicc.logicanegocio.ape;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.ape.DTOListaPicado;
import es.indra.sicc.dtos.fac.DTOFACCabeceraSolicitud;
import es.indra.sicc.dtos.fac.DTOFACConsolidado;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.LogAPP;
import es.indra.sicc.util.UtilidadesLog;
import java.util.ArrayList;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONImpresionListaPicadoBean implements SessionBean  {
  public void ejbCreate() { }
  public void ejbActivate() { }
  public void ejbPassivate() {  }
  public void ejbRemove() {  }
  public void setSessionContext(SessionContext ctx) {  }

  /**
   * Autor: sapaza
   * Fecha: 12-03-2007
   * Descripcion: Permite imprimir listas de picado de un conjunto de consolidados
   * @throws es.indra.mare.common.exception.MareException
   * @param consolidados
   */
  public void imprimirListaPicado(ArrayList consolidados) throws MareException {
      UtilidadesLog.info("MONImpresionListaPicadoBean.imprimirListaPicado(ArrayList consolidados): Entrada");
      DAOImpresionListaPicado daoImpresion = new DAOImpresionListaPicado();
      ArrayList listaPicado = new ArrayList();
      DTOOIDs cabecerasImpresas = new DTOOIDs();
      
      for(int i=0; i < consolidados.size(); i++) {
          DTOFACConsolidado dtoFacConsolidado = (DTOFACConsolidado)consolidados.get(i);
      
          DTOFACCabeceraSolicitud dtoFacCabecera = dtoFacConsolidado.getDtoCabecera();
          DTOListaPicado dtoListaPicado = daoImpresion.obtenerListaPicadoPorConsolidado(dtoFacCabecera.getOidConsolidado());
    
          if(dtoListaPicado != null) {
            //FALTA IMPLEMENTAR ESTA PARTE DE LA IMPRESION
            //IREp.listaDePicado(dtoListaPicado);
  
            listaPicado.add(dtoListaPicado.getOidListaPicado());
          }      
          else {
            LogAPP.error("No existe lista de picado para el consolidado Nro " + 
            dtoFacCabecera.getNumeroConsolidado());
          }
      }
      
      //Se actualiza el Flag Impreso en las Listas de picado procesadas  
      if(listaPicado.size()>0) {
          UtilidadesLog.debug("*** Se empieza a actualizar el Flag de la lista de picado procesadas");
          Long[] oids = new Long[listaPicado.size()];
          
          for(int i=0; i<listaPicado.size(); i++) 
              oids[i] = (Long)listaPicado.get(i);
          
          cabecerasImpresas.setOids(oids);
          daoImpresion.actualizarFlagImpreso(cabecerasImpresas);
      }
          
      UtilidadesLog.info("MONImpresionListaPicadoBean.imprimirListaPicado(ArrayList consolidados): Salida");
  } 
}