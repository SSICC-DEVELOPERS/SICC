package es.indra.sicc.dtos.ccc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.Date;

public class DTOOrdenaMovimientosFechaVencimiento extends DTOBelcorp implements Comparable {

   public DTOOrdenaMovimientosFechaVencimiento(Long oidSolicitud, Date fechaVencimiento,DTOMovimientoCuentaCompleto movimiento ) {
      super();
      this.oidSolicitud=oidSolicitud;
      this.fechaVencimiento=fechaVencimiento;
      this.movimiento = movimiento;
   }
   
   private Date fechaVencimiento;
   private Long oidSolicitud;
   private DTOMovimientoCuentaCompleto movimiento;

   public int compareTo(Object o) {
      if(!(o instanceof DTOOrdenaMovimientosFechaVencimiento)){
         throw new ClassCastException("Invalid object to compare");
      }
      int i=0;
      if(this.fechaVencimiento.getTime()<((DTOOrdenaMovimientosFechaVencimiento)o).getFechaVencimiento().getTime()){
         i=-1;
      }else if(this.fechaVencimiento.getTime()>((DTOOrdenaMovimientosFechaVencimiento)o).getFechaVencimiento().getTime()){
         i=1;
/*      }else if(this.oidSolicitud.longValue()<((DTOOrdenaMovimientosFechaVencimiento)o).getOidSolicitud().longValue()){
         i=-1;
      }else if(this.oidSolicitud.longValue()>((DTOOrdenaMovimientosFechaVencimiento)o).getOidSolicitud().longValue()){
         i=1; */
      }else if(this.movimiento.getNumeroIdentificadorCuota().intValue() <((DTOOrdenaMovimientosFechaVencimiento)o).getMovimiento().getNumeroIdentificadorCuota().intValue() ){
        i=-1;
      }else if(this.movimiento.getNumeroIdentificadorCuota().intValue() >((DTOOrdenaMovimientosFechaVencimiento)o).getMovimiento().getNumeroIdentificadorCuota().intValue() ){
        i=1;
      }else if(this.movimiento.getNumeroOrdenCuota().intValue() <((DTOOrdenaMovimientosFechaVencimiento)o).getMovimiento().getNumeroOrdenCuota().intValue() ){
        i=-1;
      }else if(this.movimiento.getNumeroOrdenCuota().intValue() >((DTOOrdenaMovimientosFechaVencimiento)o).getMovimiento().getNumeroOrdenCuota().intValue() ){
        i=1;
      }
      return i;
   }

   public boolean equals(Object obj) {
      boolean salida = false;
      if(obj instanceof DTOOrdenaMovimientosFechaVencimiento){
         DTOOrdenaMovimientosFechaVencimiento tmp = (DTOOrdenaMovimientosFechaVencimiento)obj;
         if(this.fechaVencimiento.equals(tmp.getFechaVencimiento())){
            salida = true;
         }
      }
      return salida;
   }

   public int hashCode() {
      return new BigDecimal(this.oidSolicitud.longValue()).add(new BigDecimal(this.fechaVencimiento.getTime())).intValue();
   }

   public void setFechaVencimiento(Date fechaVencimiento) {
      this.fechaVencimiento = fechaVencimiento;
   }


   public Date getFechaVencimiento() {
      return fechaVencimiento;
   }


   public void setOidSolicitud(Long oidSolicitud) {
      this.oidSolicitud = oidSolicitud;
   }


   public Long getOidSolicitud() {
      return oidSolicitud;
   }


   public void setMovimiento(DTOMovimientoCuentaCompleto movimiento) {
      this.movimiento = movimiento;
   }


   public DTOMovimientoCuentaCompleto getMovimiento() {
      return movimiento;
   }

}