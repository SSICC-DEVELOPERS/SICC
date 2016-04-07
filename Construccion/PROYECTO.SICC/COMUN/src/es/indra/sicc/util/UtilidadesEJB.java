package es.indra.sicc.util;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.MareServiceException;

import es.indra.sicc.util.BelcorpService;


public class UtilidadesEJB {
   public UtilidadesEJB() {
   }

   public static Object getHome(String nombre, Class clase)
      throws MareException {
      String codigoError;
      BelcorpService miBerlcorpService = getBelcorpService();

      try {
         return miBerlcorpService.ejbLocator.getHome(nombre, clase);
      } catch (MareServiceException e) {
         //ctx.setRollbackOnly();
         codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      }
   }

   public static Object getLocalHome(String nombre) throws MareException {
      String codigoError;
      BelcorpService miBerlcorpService = getBelcorpService();

      try {
         return miBerlcorpService.ejbLocator.getEntityLocalHome(nombre);
      } catch (MareServiceException e) {
         codigoError = CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB;
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      }
   }

   public static BelcorpService getBelcorpService() throws MareException {
      String codigoError;
      BelcorpService miBerlcorpService = null;

      try {
         miBerlcorpService = BelcorpService.getInstance();
      } catch (MareMiiServiceNotFoundException e) {
         codigoError = CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE;
         throw new MareException(e,
            UtilidadesError.armarCodigoError(codigoError));
      }

      return miBerlcorpService;
   }
}
