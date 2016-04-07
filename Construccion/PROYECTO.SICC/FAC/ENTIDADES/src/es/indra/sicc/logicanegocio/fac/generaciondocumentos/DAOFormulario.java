package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.mare.common.exception.MareException;
import javax.ejb.EJBException;
import java.util.ArrayList;
import es.indra.sicc.util.BelcorpService;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.UtilidadesError;
import java.math.BigDecimal;

import es.indra.sicc.util.UtilidadesLog;

public class DAOFormulario 
{
  public DAOFormulario()
  {
  }

 public ArrayList obtenerFormulario(Long oidTipoSolicitud, Long subaccesoUsuario) throws MareException
  {
   UtilidadesLog.info("DAOFormulario.obtenerFormulario(Long oidTipoSolicitud, Long subaccesoUsuario): Entrada"); 
   StringBuffer query = new StringBuffer();
     
    // A.IMVI_OID_IMPR eliminado de BD. Fantan cambios de la BELC300015996     
   query.append(" SELECT A.OID_FORM,A.COD_FORM,A.NUM_LINE,A.VAL_TAMA_FORM,A.VAL_RUTI_DISE_FORM,A.IND_IMPR,A.IND_PREI,A.IND_SPOO_INDI, ");
   query.append(" A.TEIM_OID_TECN,A.VAL_NOMB_FORM,A.IND_ACTI,A.IND_NUM_OFIC,A.NUM_LINE_SALT_PAGI,A.TIDO_OID_TIPO_DOCU, ");
   query.append(" A.DEIM_OID_DEST_IMPR,A.TIFO_OID_TIPO_FORM,B.NUM_ORDE_SECU, C.IMVI_OID_IMPR ");
     
	 query.append(" FROM FAC_FORMU A, ");
	 query.append(" FAC_FORMU_TIPO_SOLIC B, ");
     query.append(" FAC_ASIGN_IMPRE C ");
	
	   
  query.append(" WHERE B.TSPA_OID_TIPO_SOLI_PAIS="+oidTipoSolicitud.longValue());
  query.append(" AND A.OID_FORM=B.FORS_OID_FORM ");
  query.append(" AND A.IND_IMPR=1 ");

  query.append(" AND C.FORS_OID_FORM=A.OID_FORM ");
  query.append(" AND C.SBAC_OID_SBAC = "+subaccesoUsuario);
	 
  query.append(" ORDER BY B.NUM_ORDE_SECU ");
 
      RecordSet rs = new RecordSet();

     try {
            rs = (RecordSet) getBelcorpService().dbService.executeStaticQuery(query.toString());
        } catch (MareException me) {
            throw me;
        }catch (Exception e) {
            throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }
      
      ArrayList salida=new ArrayList();
      
      for(int i=0;i<rs.getRowCount();i++)
      {
          DTOFACFormulario miFormu= new DTOFACFormulario();
        
          miFormu.setOidFormulario(new Long(((BigDecimal)rs.getValueAt(i,"OID_FORM")).longValue()));
          miFormu.setCodFormulario((String)rs.getValueAt(i,"COD_FORM"));
          miFormu.setNumLineas(new Long(((BigDecimal)rs.getValueAt(i,"NUM_LINE")).longValue()));
          miFormu.setValTamañoFormulario((String)rs.getValueAt(i,"VAL_TAMA_FORM"));
          miFormu.setRutinaDiseñoFormulario((String)rs.getValueAt(i,"VAL_RUTI_DISE_FORM"));
          int aux= ((BigDecimal)rs.getValueAt(i,"IND_IMPR")).intValue();
          switch (aux)
          {
          case 0: miFormu.setIndicadorImpresion(false);
          break;
          
          case 1: miFormu.setIndicadorImpresion(true);
          break;
          }   
         
          aux= ((BigDecimal)rs.getValueAt(i,"IND_PREI")).intValue();
          switch (aux)
          {
          case 0: miFormu.setIndicadorDePreimpreso(false);
          break;
          
          case 1: miFormu.setIndicadorDePreimpreso(true);
          break;
          }   
         
          aux= ((BigDecimal)rs.getValueAt(i,"IND_SPOO_INDI")).intValue();
          switch (aux)
          {
          case 0: miFormu.setIndicadorSpoolIndividual(false);
          break;
          
          case 1: miFormu.setIndicadorSpoolIndividual(true);
          break;
          }   
              
          miFormu.setOidSecuanciaTecnologia(new Long(((BigDecimal)rs.getValueAt(i,"TEIM_OID_TECN")).longValue()));
          miFormu.setNombreFormulario((String)rs.getValueAt(i,"VAL_NOMB_FORM"));
                   
          aux= ((BigDecimal)rs.getValueAt(i,"IND_ACTI")).intValue();
          switch (aux)
          {
          case 0: miFormu.setIndicadorActivo(false);
          break;
          
          case 1: miFormu.setIndicadorActivo(true);
          break;
          }
                    
          aux= ((BigDecimal)rs.getValueAt(i,"IND_NUM_OFIC")).intValue();
          switch (aux)
          {
          case 0: miFormu.setIndicadorNumeracionOficial(false);
          break;
          
          case 1: miFormu.setIndicadorNumeracionOficial(true);
          break;
          }
          
          miFormu.setNumeroLineasParaSaltoPagina(new Long(((BigDecimal)rs.getValueAt(i,"NUM_LINE_SALT_PAGI")).longValue()));
          if (rs.getValueAt(i,"TIDO_OID_TIPO_DOCU")!=null){
                miFormu.setOidTipoDocumentoLegal(new Long(((BigDecimal)rs.getValueAt(i,"TIDO_OID_TIPO_DOCU")).longValue()));
          }
          miFormu.setOidDestinoImpresion(new Long(((BigDecimal)rs.getValueAt(i,"DEIM_OID_DEST_IMPR")).longValue()));
          Object objAux =rs.getValueAt(i,"TIFO_OID_TIPO_FORM");
          if(objAux!=null){
          miFormu.setOidTipoFormulario(new Long(((BigDecimal)rs.getValueAt(i,"TIFO_OID_TIPO_FORM")).longValue()));
          }
          // BELC300015996     
          miFormu.setOidImpresoraVirtual(new Long(((BigDecimal)rs.getValueAt(i,"IMVI_OID_IMPR")).longValue()));
          miFormu.setOidNumOrdenSecuencia(new Long(((BigDecimal)rs.getValueAt(i,"NUM_ORDE_SECU")).longValue()));
     
          salida.add(miFormu);
      }
      UtilidadesLog.info("DAOFormulario.obtenerFormulario(Long oidTipoSolicitud, Long subaccesoUsuario): Entrada"); 
      return salida;
  }
  
 private BelcorpService getBelcorpService() {
       try  {
            return BelcorpService.getInstance();
        } catch (MareMiiServiceNotFoundException mmsnfe)  {
            throw new EJBException( "MareMiiServiceNotFoundException: "
                        + mmsnfe.getMessage(), mmsnfe);
        } 
    }


}