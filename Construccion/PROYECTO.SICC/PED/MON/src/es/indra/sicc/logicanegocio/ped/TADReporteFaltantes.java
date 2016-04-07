package es.indra.sicc.logicanegocio.ped;
import es.indra.sicc.dtos.ped.DTOCabeceraReporte;
import es.indra.sicc.dtos.ped.DTOMovimiento;
import es.indra.sicc.dtos.ped.DTOInformeFaltantes;

public class TADReporteFaltantes  {
  private DTOInformeFaltantes informe;

  public TADReporteFaltantes() {
  }

  public TADReporteFaltantes(DTOInformeFaltantes informe) {
      this.informe = informe;
  }

  public DTOInformeFaltantes getInforme() throws es.indra.mare.common.exception.MareException {
    return informe;
  }

  /*
      1.- Busca dentro de cabecera algún elemento de cabecera.movimientoProducto cuyos atributos cumplan: 
      - producto = mov.producto 
      - indDiario = mov.indDiario 
      2.- Si existe se devuelve y sino se hace: 
      - Se crea una copia del parámetro mov con la misma información que contiene mov salvo con el atributo demanda que irá a 0 y se inserta en el array cabecera.movimientoProducto 
      - Se devuelve el elemento. 
   */
  private DTOMovimiento existeProducto(DTOCabeceraReporte cabecera, DTOMovimiento mov) throws es.indra.mare.common.exception.MareException {
     DTOMovimiento[] arrMov = cabecera.getMovimientoProducto();
     int arrMovCont = 0;
     boolean encontro = false;
     while((arrMovCont < arrMov.length)&&(!encontro)) {
        DTOMovimiento movActual = arrMov[arrMovCont];
        if ((movActual.getProducto()!=null)&&(mov.getProducto()!=null)&&
            (movActual.getProducto().equals(mov.getProducto()))&&
            (movActual.getIndDiario()!=null)&&(mov.getIndDiario()!=null)&&
            (movActual.getIndDiario().equals(mov.getIndDiario()))){
              encontro = true;
           } else {
              arrMovCont++;
           }
     }
     if (encontro){
        return arrMov[arrMovCont];
     } else {
        //Hago una copia que tendra el valor demanda en 0
        DTOMovimiento movDupl = new DTOMovimiento();
        movDupl.setDemanda(new Long(0));
        if (mov.getAlmacen()!=null){
          movDupl.setAlmacen(new Long(mov.getAlmacen().longValue()));
        }        
        if(mov.getFaltante()!=null){
          movDupl.setFaltante(new Double(mov.getFaltante().doubleValue()));
        }
        if(mov.getIndAhorro()!=null){
          movDupl.setIndAhorro(mov.getIndAhorro().booleanValue());
        }        
        if(mov.getIndDiario()!=null){
          movDupl.setIndDiario(mov.getIndDiario());
        }     
        if(mov.getNegocio()!=null){
          movDupl.setNegocio(new Long(mov.getNegocio().longValue()));
        }
        if(mov.getPosicion()!=null){
          movDupl.setPosicion(new Long(mov.getPosicion().longValue()));
        }   
        if(mov.getProducto()!=null){
          movDupl.setProducto(new Long(mov.getProducto().longValue()));
        }       
        if(mov.getStockDisponible()!=null){
          movDupl.setStockDisponible(new Long(mov.getStockDisponible().longValue()));
        }      
        if(mov.getTxtAlmacen()!=null){
          movDupl.setTxtAlmacen(new String(mov.getTxtAlmacen()));
        }
        if(mov.getTxtNegocio()!=null){
          movDupl.setTxtNegocio(new String(mov.getTxtNegocio()));
        }  
        if(mov.getTxtProducto()!=null){
          movDupl.setTxtProducto(new String(mov.getTxtProducto()));
        }
        if(mov.getUnidades()!=null){
          movDupl.setUnidades(new Long(mov.getUnidades().longValue()));
        }
        //Agrego la copia al array      
        DTOMovimiento[] arrNewMov = new DTOMovimiento[arrMov.length+1];
        for(int i=0;i<arrMov.length;i++){
           arrNewMov[i]=arrMov[i];
        }
        arrNewMov[arrMov.length]=movDupl;
        cabecera.setMovimientoProducto(arrNewMov);
        return movDupl;
     }     
  }

  /*
    1.- Busca dentro de cabecera algún elemento de cabecera.movimientoCategoria cuyos atributos cumplan: 
    - almacen = mov.almacen 
    - negocio = mov.negocio 
    - indAhorro = mov.indAhorro 
    - indDiario = mov.indDiario 
    2.- Si existe se devuelve y sino se hace: 
    - Se crea una copia del parámetro mov con la misma información que contiene mov salvo con el atributo demanda que irá a 0 y se inserta en el array cabecera.movimientoCategoria 
    - Se devuelve el elemento.
   */
  private DTOMovimiento existeCategoria(DTOCabeceraReporte cabecera, DTOMovimiento mov) throws es.indra.mare.common.exception.MareException {
     DTOMovimiento[] arrMov = cabecera.getMovimientoCategoria();
     int arrMovCont = 0;
     boolean encontro = false;
     while((arrMovCont < arrMov.length)&&(!encontro)) {
        DTOMovimiento movActual = arrMov[arrMovCont];
        if ((movActual.getAlmacen()!=null)&&(mov.getAlmacen()!=null)&&
            (movActual.getAlmacen().equals(mov.getAlmacen()))&&
            (movActual.getNegocio()!=null)&&(mov.getNegocio()!=null)&&
            (movActual.getNegocio().equals(mov.getNegocio()))&&
            (movActual.getIndAhorro()!=null)&&(mov.getIndAhorro()!=null)&&
            (movActual.getIndAhorro().equals(mov.getIndAhorro()))&&
            (movActual.getIndDiario()!=null)&&(mov.getIndDiario()!=null)&&
            (movActual.getIndDiario().equals(mov.getIndDiario()))){
              encontro = true;
        }
        else{
            arrMovCont++;
        }
     }
     if (encontro){
        return arrMov[arrMovCont];
     } 
     else{
        //Hago una copia que tendra el valor demanda en 0
        DTOMovimiento movDupl = new DTOMovimiento();
        movDupl.setDemanda(new Long(0));
        
        if (mov.getAlmacen()!=null){
          movDupl.setAlmacen(new Long(mov.getAlmacen().longValue()));
        }        
        if(mov.getFaltante()!=null){
          movDupl.setFaltante(new Double(mov.getFaltante().doubleValue()));
        }
        if(mov.getIndAhorro()!=null){
          movDupl.setIndAhorro(mov.getIndAhorro());
        }        
        if(mov.getIndDiario()!=null){
          movDupl.setIndDiario(mov.getIndDiario());
        }     
        if(mov.getNegocio()!=null){
          movDupl.setNegocio(new Long(mov.getNegocio().longValue()));
        }
        if(mov.getPosicion()!=null){
          movDupl.setPosicion(new Long(mov.getPosicion().longValue()));
        }   
        if(mov.getProducto()!=null){
          movDupl.setProducto(new Long(mov.getProducto().longValue()));
        }       
        if(mov.getStockDisponible()!=null){
          movDupl.setStockDisponible(new Long(mov.getStockDisponible().longValue()));
        }      
        if(mov.getTxtAlmacen()!=null){
          movDupl.setTxtAlmacen(new String(mov.getTxtAlmacen()));
        }
        if(mov.getTxtNegocio()!=null){
          movDupl.setTxtNegocio(new String(mov.getTxtNegocio()));
        }  
        if(mov.getTxtProducto()!=null){
          movDupl.setTxtProducto(new String(mov.getTxtProducto()));
        }
        if(mov.getUnidades()!=null){
          movDupl.setUnidades(new Long(mov.getUnidades().longValue()));
        }
        //Agrego la copia al array      
        DTOMovimiento[] arrNewMov = new DTOMovimiento[arrMov.length+1];
        for(int i=0;i<arrMov.length;i++){
           arrNewMov[i]=arrMov[i];
        }
        arrNewMov[arrMov.length]=movDupl;
        cabecera.setMovimientoCategoria(arrNewMov);
        return movDupl;
     }
  }

  /*Proceso: 
    ======= 
    1.- DTOMovimiento movimiento = existeProducto(cabecera, mov); 
    2.- Actualiza los siguientes campos de movimiento: 
    - movimiento.demanda += mov.demanda 
    - movimiento.unidades = movimiento.demanda - movimiento.stockDisponible 
    - movimiento.faltante = (movimiento.unidades/movimiento.demanda) * 100 
    3.- Sino se actualizan los siguientes campos de movimiento: 
    - movimiento.demanda += mov.demanda 
    - movimiento.unidades += movimiento.unidades 
    - movimiento.faltante = ((movimiento.demanda - movimiento.unidades)/movimiento.demanda) * 100
  */
  private void insertaProducto(DTOCabeceraReporte cabecera, DTOMovimiento mov) throws es.indra.mare.common.exception.MareException {
  //Se resolvio Incidencia 6376 (valores nulos en calculos)
    long calculo ;
    DTOMovimiento movimiento = existeProducto(cabecera, mov);

    //Si algun operador es nulo, se setea a cero
    if (movimiento.getStockDisponible()==null) { movimiento.setStockDisponible(new Long(0)); }
    if (movimiento.getUnidades() == null) { movimiento.setUnidades(new Long(0)); }
    if (movimiento.getDemanda()==null) { movimiento.setDemanda(new Long(0)); }
    if (mov.getDemanda()==null) { mov.setDemanda(new Long(0)); }
    
    
    if ((mov.getIndDiario() != null) && (mov.getIndDiario().booleanValue())){ 
    //MCO modificado x  incidencia 6378 
         calculo = mov.getDemanda().longValue() + movimiento.getDemanda().longValue();
         movimiento.setDemanda(new Long(calculo));

         calculo = movimiento.getDemanda().longValue() - movimiento.getStockDisponible().longValue();
         movimiento.setUnidades(new Long(calculo));
          
         if (movimiento.getDemanda().longValue()!= 0){
          calculo = (movimiento.getUnidades().longValue()/movimiento.getDemanda().longValue())*100;
          movimiento.setFaltante(new Double(calculo));

         }
         else{
          movimiento.setFaltante(new Double(0));
        }   
    }
    else {
          calculo = mov.getDemanda().longValue() + movimiento.getDemanda().longValue();
          movimiento.setDemanda(new Long(calculo));

          calculo = movimiento.getUnidades().longValue() + movimiento.getUnidades().longValue();
          movimiento.setUnidades(new Long(calculo));
          
          if (movimiento.getDemanda().longValue()!= 0){
            calculo = (movimiento.getDemanda().longValue() - movimiento.getUnidades().longValue());
            calculo = (calculo / movimiento.getDemanda().longValue()) * 100;
            movimiento.setFaltante(new Double(calculo));
          }
          else{
            movimiento.setFaltante(new Double(0));
         }      
    }

  }

  /*Proceso: 
  ======= 
  1.- DTOMovimiento movimiento = existeCategoria(cabecera, mov); 
  2.- Si (mov.indDiario) Se actualizan los siguientes campos de movimiento: 
  - movimiento.demanda += mov.demanda 
  - movimiento.unidades = movimiento.demanda - movimiento.stockDisponible 
  - movimiento.faltante = (movimiento.unidades/movimiento.demanda) * 100 
  3.- Sino se actualizan los siguientes campos de movimiento: 
  - movimiento.demanda += mov.demanda 
  - movimiento.unidades += movimiento.unidades 
  - movimiento.faltante = ((movimiento.demanda - movimiento.unidades)/movimiento.demanda) * 100
  */
  private void insertaCategoria(DTOCabeceraReporte cabecera, DTOMovimiento mov) throws es.indra.mare.common.exception.MareException {
  //Se resolvio Incidencia 6376 (valores nulos en calculos)

    long calculo ;
    DTOMovimiento movimiento = existeCategoria(cabecera, mov);

    //Si algun operador es nulo, se setea a cero
    if (movimiento.getStockDisponible()==null){ movimiento.setStockDisponible(new Long(0)); }
    if (movimiento.getUnidades() == null){ movimiento.setUnidades(new Long(0)); }
    if(movimiento.getDemanda()==null){ movimiento.setDemanda(new Long(0)); }
    if(mov.getDemanda()==null){ mov.setDemanda(new Long(0)); }
    
    
    if ((mov.getIndDiario() != null) && (mov.getIndDiario().booleanValue())){
          calculo = mov.getDemanda().longValue() + movimiento.getDemanda().longValue();
          movimiento.setDemanda(new Long(calculo));

          calculo = movimiento.getDemanda().longValue() - movimiento.getStockDisponible().longValue();
          movimiento.setUnidades(new Long(calculo));

          if (movimiento.getDemanda().longValue() != 0){
             calculo = (movimiento.getUnidades().longValue()/movimiento.getDemanda().longValue())*100;
             movimiento.setFaltante(new Double(calculo));
          }
          else{
             movimiento.setFaltante(new Double(0));
          }   
    }
    else{
          calculo = mov.getDemanda().longValue() + movimiento.getDemanda().longValue();
          movimiento.setDemanda(new Long(calculo));

          calculo = movimiento.getUnidades().longValue() + movimiento.getUnidades().longValue();
          movimiento.setUnidades(new Long(calculo));
    
          if (movimiento.getDemanda().longValue() != 0){
            calculo = (movimiento.getDemanda().longValue() - movimiento.getUnidades().longValue());
            calculo = (calculo / movimiento.getDemanda().longValue()) * 100;
            movimiento.setFaltante(new Double(calculo));
          }
          else{
            movimiento.setFaltante(new Double(0));
          }
    }
   }
  
   public void insertaMovimiento(DTOCabeceraReporte cabecera, DTOMovimiento mov) throws es.indra.mare.common.exception.MareException {
      insertaCategoria(cabecera, mov); 
      insertaProducto(cabecera,mov);
  }
}