/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @author Gustavo Viñales.
 *  Revisada para cumplir el modelo de componentes INC4.
 * @date 27/04/2005
 * 
 * @NOTA: Modificado por revision de Auditoria
 * @autor: Paola Cabrera
 * @fecha: 20/09/2005 
 * 
 * 
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;


public class ClientePremiacion implements Serializable {
    private ArrayList clienteConcursos;
    private BigDecimal montoPedidoPremiacion;
    private DatosPersonales datosPersonales;

    /**
     * El campo clientesPremiacionConcurso guarda objetos
     * ClientePremiacionConcurso mapeados según oidConcurso
     */
    private HashMap clientesPremiacionConcurso;
    private HashMap periodosConPedidos;
    private HashMap productos;
    private HashMap tiposCursosAsistidos;
    private Long oidCanal;
    private Long oidCliente;
    private String oidCodigoEmpleado;
    private Long oidMarca;
    private Long oidPais;
    private Long recomendacionesEfectivas;
    private Periodo periodo;
    private Periodo periodoPrimerContacto;
    private UnidadesAdministrativasGerenciadas unidadAdministrativaGer;
    private boolean gerente;
    private boolean indPagoEnTermino;
    private Long subacceso;
    private Long acceso;
    // vbongiov -- 14/11/2006 -- DBLG700000221
    private Boolean indCuponRecomendacion;
      
    // vbongiov -- 9/01/2007 -- DBLG500001077
    private boolean indAnulacion;
    private boolean indAnulacionRecomendante;
    private boolean indGrabaCandidataGanadora=true;
    private boolean indCrearMensajePremio=true;
    
    //jrivas BLO-001 
    private boolean clienteBloqueado;
    
    // vbongiov -- Cambio 20090929 -- 18/09/2009
    private String tipoCierre;
    private Long periodoCierreMenosUno;
    private boolean deudaPeriodoCierreMenosUno;

    // sapaza -- PER-SiCC-2012-0712 -- 06/11/2012
    private BigDecimal montoPuntajeRetail;

    public ClientePremiacion() {
        this.recomendacionesEfectivas = new Long(0);
        clienteConcursos = new ArrayList();
        productos = new HashMap();
        tiposCursosAsistidos = new HashMap();
        clientesPremiacionConcurso = new HashMap();
        this.gerente = false;
        this.indPagoEnTermino = false;
        this.setIndCuponRecomendacion(Boolean.FALSE);   
        // vbongiov -- 9/01/2007 -- DBLG500001077
        this.indAnulacion = false;
        this.indAnulacionRecomendante = false;
        this.indGrabaCandidataGanadora = true;
        this.indCrearMensajePremio=true;
        this.clienteBloqueado = false;
    }

    public void setClientePremiacionConcurso(Long oidConcurso) {
        //clientesPremiacionConcurso = new HashMap();
        ClientePremiacionConcurso clientePremConc =
            new ClientePremiacionConcurso();
        clientePremConc.setOidConcurso(oidConcurso);
        clientesPremiacionConcurso.put(oidConcurso, clientePremConc);
    }

    /**
     * Obtiene el ClientePremiacionConcurso asociado al OID del concurso
     * recibido; si no lo encuentra crea uno nuevo y lo retorna
     * @author Gustavo Viñales.
     * @date 27/04/2005
     */
    public ClientePremiacionConcurso getClientePremiacionConcurso(
        Long oidConcurso) throws MareException {
        UtilidadesLog.info(
            "ClientePremiacion.getClientePremiacionConcurso(Long" +
            "oidConcurso): Entrada");

        /*
           Si lo encuentra Retorna clientePremiacionConcurso
           Sino Crea un objeto del tipo ClientePremiacionConcurso(oidConcurso)
           Carga el objeto:
              con DaoGerentes.recuperarClientePremiacionConcurso si
                this.gerente==true
           sino
              con DAOClientePremiacionConcurso.
                    recuperarClientePremiacionConcurso si this.gerente==true
           Lo mete en el HashMap clientePremiacionConcursos
           retorna el objeto creado
           }
         */
        ClientePremiacionConcurso clientePremConc = (ClientePremiacionConcurso) 
            clientesPremiacionConcurso.get(oidConcurso);

        if (clientePremConc == null) {
            clientePremConc = new ClientePremiacionConcurso();
            clientePremConc.setOidConcurso(oidConcurso);

            if (this.gerente) {
                DAOGerentes daoGerentes = new DAOGerentes();
                daoGerentes.recuperarClientePremiacionConcurso(clientePremConc,
                    this);
            } else {
                DAOClientePremiacionConcurso daoCliePremConc =
                    new DAOClientePremiacionConcurso();
                daoCliePremConc.recuperarClientePremiacionConcurso(
                    clientePremConc, this);
            }

            //jrivas 2/8/2005
            //inc 20269
            RecuperadorDatosPremiacion rec = new RecuperadorDatosPremiacion();
            clientesPremiacionConcurso.put(oidConcurso, clientePremConc);
            rec.obtenerDatosCalificacionPremiacion(this, clientePremConc);
        }

        UtilidadesLog.info(
            "ClientePremiacion.getClientePremiacionConcurso(Long" +
            "oidConcurso): Salida");

        return clientePremConc;
    }

    public void setClientesPremiacionConcurso(
        HashMap clientesPremiacionConcurso) {
        this.clientesPremiacionConcurso = clientesPremiacionConcurso;
    }

    public HashMap getClientesPremiacionConcurso() {
        return clientesPremiacionConcurso;
    }

    public void setDatosPersonales(DatosPersonales datosPersonales) {
        this.datosPersonales = datosPersonales;
    }

    public DatosPersonales getDatosPersonales() {
        return datosPersonales;
    }

    public void setGerente(boolean gerente) {
        this.gerente = gerente;
    }

    public boolean getGerente() {
        return this.gerente;
    }

    public void setIndPagoEnTermino(boolean indPagoEnTermino) {
        this.indPagoEnTermino = indPagoEnTermino;
    }

    public boolean isIndPagoEnTermino() {
        return this.indPagoEnTermino;
    }

    public void setMontoPedidoPremiacion(BigDecimal montoPedidoPremiacion) {
        this.montoPedidoPremiacion = montoPedidoPremiacion;
    }

    public BigDecimal getMontoPedidoPremiacion() {
        return montoPedidoPremiacion;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCanal() {
        return this.oidCanal;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidCliente() {
        return this.oidCliente;
    }

    public void setOidCodigoEmpleado(String oidCodigoEmpleado) {
        this.oidCodigoEmpleado = oidCodigoEmpleado;
    }

    public String getOidCodigoEmpleado() {
        return this.oidCodigoEmpleado;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidMarca() {
        return this.oidMarca;
    }

    public void setOidPais(Long oidPais) {
        this.oidPais = oidPais;
    }

    public Long getOidPais() {
        return this.oidPais;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Periodo getPeriodo() {
        return this.periodo;
    }

    public void setPeriodoPrimerContacto(Periodo periodoPrimerContacto) {
        this.periodoPrimerContacto = periodoPrimerContacto;
    }

    public Periodo getPeriodoPrimerContacto() {
        return this.periodoPrimerContacto;
    }

    public void setPeriodosConPedidos(HashMap periodosConPedidos) {
        this.periodosConPedidos = periodosConPedidos;
    }

    public HashMap getPeriodosConPedidos() {
        return periodosConPedidos;
    }

    public void setProductos(HashMap productos) {
        this.productos = productos;
    }

    public HashMap getProductos() {
        return productos;
    }

    /**
     * Sets getClientePremiacionConcurso( oidConcurso ).rechazado=true
     * @param oidConcurso
     * @author Gustavo Viñales.
     * @date 27/04/2005
     */
    public void setRechazado(Long oidConcurso) throws MareException {
        getClientePremiacionConcurso(oidConcurso).setRechazado(true);
    }

    /**
     * Retorna getClientePremiacionConcurso(oidConcurso).rechazado
     * @author Gustavo Viñales.
     * @date 27/04/2005
     */
    public boolean isRechazado(Long oidConcurso) throws MareException {
        boolean retorna = getClientePremiacionConcurso(oidConcurso)
                              .getRechazado();

        return retorna;
    }

    public void setRecomendacionesEfectivas(Long recomendacionesEfectivas) {
        this.recomendacionesEfectivas = recomendacionesEfectivas;
    }

    public Long getRecomendacionesEfectivas() {
        return this.recomendacionesEfectivas;
    }

    public void setTiposCursosAsistidos(HashMap tiposCursosAsistidos) {
        this.tiposCursosAsistidos = tiposCursosAsistidos;
    }

    public HashMap getTiposCursosAsistidos() {
        return tiposCursosAsistidos;
    }

    public void setUnidadesAdministrativasGerenciadas(
        UnidadesAdministrativasGerenciadas unidadAdministrativaGer) {
        this.unidadAdministrativaGer = unidadAdministrativaGer;
    }

    public UnidadesAdministrativasGerenciadas 
        getUnidadesAdministrativasGerenciadas() {
        return this.unidadAdministrativaGer;
    }

    /**
     * Determina si el cliente ha pasado al menos una solicitud para el periodo 
     * dado.
     * @return true/false
     * @param oidPeriodo
     * @author Gustavo Viñales.
     * @date 27/04/2005
     */
    public boolean pasoPedidos(Long oidPeriodo) {
        UtilidadesLog.info(
            "ClientePremiacion.pasoPedidos(Long oidPeriodo): Entrada");

        UtilidadesLog.debug("oidPeriodo " + oidPeriodo);

        UtilidadesLog.info(
            "ClientePremiacion.pasoPedidos(Long oidPeriodo): Salida");

        return getPeriodosConPedidos().containsKey(oidPeriodo);
    }

    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long subacceso) {
        this.subacceso = subacceso;
    }

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long acceso) {
        this.acceso = acceso;
    }

    /**
     * Retorna getClientePremiacionConcurso(oidConcurso).isDescalificado
     * @author Julián Rivas
     * @date 28/05/2005
      * INC 20638
     */
    public boolean isDescalificado(Long oidConcurso) throws MareException {
        boolean retorna = getClientePremiacionConcurso(oidConcurso)
                              .isDescalificado();

        return retorna;
    }
    
    public void setRechazadoPeriodoDespacho(Long oidConcurso) throws MareException {
        getClientePremiacionConcurso(oidConcurso).setRechazadoPeriodoDespacho(true);
    }


    public boolean isRechazadoPeriodoDespacho(Long oidConcurso) throws MareException {
        boolean retorna = getClientePremiacionConcurso(oidConcurso)
                              .getRechazadoPeriodoDespacho();

        return retorna;
    }    

  public Boolean getIndCuponRecomendacion() {
    return indCuponRecomendacion;
  }

  public void setIndCuponRecomendacion(Boolean indCuponRecomendacion) {
    this.indCuponRecomendacion = indCuponRecomendacion;
  }

  public boolean getIndAnulacion() {
    return indAnulacion;
  }

  public void setIndAnulacion(boolean indAnulacion) {
    this.indAnulacion = indAnulacion;
  }

  public boolean getIndAnulacionRecomendante() {
    return indAnulacionRecomendante;
  }

  public void setIndAnulacionRecomendante(boolean indAnulacionRecomendante) {
    this.indAnulacionRecomendante = indAnulacionRecomendante;
  }
  
  public boolean getIndGrabaCandidataGanadora() {
    return indGrabaCandidataGanadora;
  }

  public void setIndGrabaCandidataGanadora(boolean indGrabaCandidataGanadora) {
    this.indGrabaCandidataGanadora = indGrabaCandidataGanadora;
  }  
  
  public boolean getIndCrearMensajePremio() {
    return indCrearMensajePremio;
  }

  public void setIndCrearMensajePremio(boolean indCrearMensajePremio) {
    this.indCrearMensajePremio = indCrearMensajePremio;
  }  

  public boolean getClienteBloqueado() {
    return clienteBloqueado;
  }

  public void setClienteBloqueado(boolean clienteBloqueado) {
    this.clienteBloqueado = clienteBloqueado;
  }  
  
  public String getTipoCierre() {
    return tipoCierre;
  }
        
  public void setTipoCierre(String tipoCierre) {
    this.tipoCierre = tipoCierre;
  }  
  
  public boolean getDeudaPeriodoCierreMenosUno() {
    return deudaPeriodoCierreMenosUno;
  }
    
  public void setDeudaPeriodoCierreMenosUno(boolean deudaPeriodoCierreMenosUno) {
    this.deudaPeriodoCierreMenosUno = deudaPeriodoCierreMenosUno;
  }  
  
  public Long getPeriodoCierreMenosUno() {
      return periodoCierreMenosUno;
  }
    
  public void setPeriodoCierreMenosUno(Long periodoCierreMenosUno) {
      this.periodoCierreMenosUno = periodoCierreMenosUno;
  }

  public void setRechazadoPeriodoDeuda(Long oidConcurso) throws MareException {
      getClientePremiacionConcurso(oidConcurso).setRechazadoPeriodoDeuda(true);
  }


  public boolean isRechazadoPeriodoDeuda(Long oidConcurso) throws MareException {
      boolean retorna = getClientePremiacionConcurso(oidConcurso)
                          .isRechazadoPeriodoDeuda();

      return retorna;
  }
    
  // sapaza -- PER-SiCC-2010-0403 -- 07/07/2010   
  public void setRechazado(Long oidConcurso, Long oidRegla) throws MareException {
    getClientePremiacionConcurso(oidConcurso).setRechazado(true);
    getClientePremiacionConcurso(oidConcurso).setOidReglaRechazada(oidRegla);
  }

    public void setMontoPuntajeRetail(BigDecimal montoPuntajeRetail) {
        this.montoPuntajeRetail = montoPuntajeRetail;
    }

    public BigDecimal getMontoPuntajeRetail() {
        return this.montoPuntajeRetail;
    }
    
    public BigDecimal getMontoPedidoPremiacionAux(Long oidBaseCalculo) {
        if(ConstantesINC.OID_BASE_CALCULO_RECOMENDADAS.equals(oidBaseCalculo)   ) {
            if(this.montoPedidoPremiacion.doubleValue() < this.montoPuntajeRetail.doubleValue()) 
                return montoPuntajeRetail;
            else
                return this.montoPedidoPremiacion;
        } else {
            return this.montoPedidoPremiacion;
        }
    }
    
}
