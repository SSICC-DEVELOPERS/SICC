package es.indra.sicc.logicanegocio.car;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.util.UtilidadesLog;
import java.math.BigDecimal;
import es.indra.sicc.logicanegocio.car.ConstantesCAR;


/**
 * 
 * @Autor Joaquin Alem
 * @Fecha 
 * @Descripcion 
 */
public class RedondeoCartera  {
  /**
   * 
 * @Autor Joaquin Alem
   * @Fecha 
   * @Descripcion 
   */
   
   private BigDecimal monto; 
   private Long tipoRedondeo;
   
    
  
  public RedondeoCartera(BigDecimal monto, Long tipoRedondeo) {
        UtilidadesLog.info("RedondeoCartera.RedondeoCartera(BigDecimal , Long):Entrada");
        this.monto = monto;
        this.tipoRedondeo = tipoRedondeo;
        UtilidadesLog.info("RedondeoCartera.RedondeoCartera(BigDecimal , Long):Salida");
  }
  
  public BigDecimal calcularRedondeo () throws MareException{
      UtilidadesLog.info("RedondeoCartera.calcularRedondeo ():Entrada");  
      BigDecimal redondeo;
      BigDecimal iFactorRedondeo = null; 
      redondeo = new BigDecimal(0);  
      BigDecimal lCociente;
      float lResto;
           
      redondeo = this.monto;
      
      if (this.tipoRedondeo.equals(ConstantesCAR.REDONDEO_DECIMAL)) {
          iFactorRedondeo = new BigDecimal(0.1);
      }
      
      if (this.tipoRedondeo.equals(ConstantesCAR.REDONDEO_UNIDAD)) {
          iFactorRedondeo = new BigDecimal(1);
      }
      
      if (this.tipoRedondeo.equals(ConstantesCAR.REDONDEO_DECENA)) {
          iFactorRedondeo = new BigDecimal(10);
      }  
      
      if (this.tipoRedondeo.equals(ConstantesCAR.REDONDEO_CENTENA)) {
          iFactorRedondeo = new BigDecimal(100);
      }
      
      lCociente = monto.divide(iFactorRedondeo, 2, BigDecimal.ROUND_HALF_UP);           
      lResto =  ((monto.floatValue() % iFactorRedondeo.floatValue()));
      BigDecimal lCociente2 =  new BigDecimal(lCociente.longValue() + 1);
      
      if (lResto != 0){
          redondeo = lCociente2.multiply(iFactorRedondeo);               
      }
      UtilidadesLog.info("RedondeoCartera.calcularRedondeo ():Salida");             
      return redondeo;   
  }
  
  
  
}