package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.CabeceraCargosAbonosDirectosLocalHome;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocal;
import es.indra.sicc.entidades.ccc.DetalleCargosAbonosDirectosLocalHome;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesError;
import java.sql.CallableStatement;
import java.sql.Connection;
import javax.ejb.SessionContext;
import java.sql.Date;

import javax.persistence.PersistenceException;

public class HelperConfirmacionMovimientosBancos  {

   private SessionContext ctx;

   public HelperConfirmacionMovimientosBancos(SessionContext session){
      this.ctx = session;
   }

   public Integer obtenerSecuenciaPais(Long pais, Long idioma)throws MareException{
      DTOBelcorp dtoBelcorp = new DTOBelcorp();
      dtoBelcorp.setOidPais(pais);
      dtoBelcorp.setOidIdioma(idioma);
      DAOCCC daoCCC = new DAOCCC();
      return daoCCC.obtenerSecuenciaPais(dtoBelcorp);
   }

   public Long obtenerProceso(String codigo, Long pais)throws MareException{
      DAOCCC daoCCC = new DAOCCC();
      return daoCCC.obtieneProceso(codigo,pais);
   }

   public CabeceraCargosAbonosDirectosLocal crearCabeceraAbonoDirecto(Integer numero, String anio, String periodoMes, Date fechaDocumento,
                                                      Long pais, Long empresa, String usuario, Date fechaValor, Long proceso)throws MareException{
      try{
         CabeceraCargosAbonosDirectosLocalHome cabeceraCargosAbonosDirectosLocalHome = this.getCabeceraCargosAbonosDirectosLocalHome();
         return  cabeceraCargosAbonosDirectosLocalHome.create(numero, anio, periodoMes, fechaDocumento, 
                                                               pais, empresa, usuario,fechaValor, proceso);
      } catch(PersistenceException e) {
         ctx.setRollbackOnly();
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
   }

   public DetalleCargosAbonosDirectosLocal crearDetalleCargosAbonos(Long oidcabecera, Integer numeroLinea, String usuario, 
                                                                    Long empresa, Long tipoAbonoTES)throws MareException{
      try{
   	 DetalleCargosAbonosDirectosLocalHome detalleCargosAbonosDirectosLocalHome = this.getDetalleCargosAbonosDirectosLocalHome();
         return detalleCargosAbonosDirectosLocalHome.create(oidcabecera, numeroLinea, usuario, empresa, tipoAbonoTES);
      } catch(PersistenceException e) {
         ctx.setRollbackOnly();
         throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ACCESO_A_BASE_DE_DATOS));
      }
   }

   private CabeceraCargosAbonosDirectosLocalHome getCabeceraCargosAbonosDirectosLocalHome() throws MareException {
        return new CabeceraCargosAbonosDirectosLocalHome();
   }
   private DetalleCargosAbonosDirectosLocalHome getDetalleCargosAbonosDirectosLocalHome()  throws MareException {
        return new DetalleCargosAbonosDirectosLocalHome();
  }
  
   public void insertarTemporalCabeceraCargosAbonos(Long oidCabecera){
      /*try{
      
         BelcorpService bs = BelcorpService.getInstance();
         StringBuffer buff = new StringBuffer();
         buff.append("SELECT * FROM CCC_CABEC_ABONO_DIREC_TEMP ");
         buff.append("WHERE OID_CABE_ABON_DIRE_TEMP = "+oidCabecera.toString());
         RecordSet salida =bs.dbService.executeStaticQuery(buff.toString()) ;
         if(salida.esVacio()){
            buff = new StringBuffer();
            buff.append("INSERT INTO CCC_CABEC_ABONO_DIREC_TEMP values (");
            buff.append(oidCabecera.toString());
            buff.append(")");
            bs.dbService.executeUpdate(buff.toString());
         }
      } catch ( Exception ex ) {
         ;
      } */      
   }
   
   public void numerarDetallesCargoAbono() throws MareException{
      Connection connection = null;
      try{
         connection = BelcorpService.getInstance().dbService.getConnection();
         CallableStatement pstmt = null;
         pstmt = connection.prepareCall("{call CCC_GENE_NUME_LINE_DETA_CAB}");
         pstmt.executeUpdate();
         if (pstmt != null){
             pstmt.close();
         }
      }catch(Exception e){
         throw new MareException(e);
      }finally{
         if(connection!=null){
            try{
               connection.close();
            }catch(Exception e){;}
         }
      }

   }

}