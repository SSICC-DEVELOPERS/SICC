package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOMontoUnidades extends DTOBelcorp
{
    private BigDecimal monto;
    private Long unidades;
 
    public void setMonto(BigDecimal monto)
    {
      this.monto = monto;
    } 

    public BigDecimal getMonto()
    {
      return monto;
    }
  
    public Long getUnidades()
    {
      return unidades;
    }

    public void setUnidades(Long unidades)
    {
      this.unidades = unidades;
    }
  
}