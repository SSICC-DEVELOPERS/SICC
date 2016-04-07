/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
 
package es.indra.sicc.entidades.edu;

import javax.ejb.EJBLocalObject;
import java.sql.Date;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.EJBException;
import javax.ejb.RemoveException;
import java.math.BigDecimal;

public interface MatrizCursosLocal extends EJBLocalObject {

    Boolean isAccesoDataMart();

    void setAccesoDataMart(Boolean newAccesoDataMart);

    Boolean isAlcance();

    void setAlcance(Boolean newAlcance);

    Boolean isBloqueoExtemporaneas();

    void setBloqueoExtemporaneas(Boolean newBloqueoExtemporaneas);

    Long getCanal();

    void setCanal(Long newCanal);

    Long getCapacitador();

    void setCapacitador(Long newCapacitador);

    Long getClasificacion();

    void setClasificacion(Long newClasificacion);

    Integer getCodigo();

    void setCodigo(Integer newCodigo);

    Boolean isCondicionPedido();

    void setCondicionPedido(Boolean newCondicionPedido);

    String getContenido();

    void setContenido(String newContenido);

    String getDescripcion();

    void setDescripcion(String newDescripcion);

    Boolean isControlMorosidad();

    void setControlMorosidad(Boolean newControlMorosidad);

    Date getFechaConcreta();

    void setFechaConcreta(Date newFechaConcreta);

    Date getFechaDisponible();

    void setFechaDisponible(Date newFechaDisponible);

    Date getFechaFin();

    void setFechaFin(Date newFechaFin);

    Date getFechaIngreso();

    void setFechaIngreso(Date newFechaIngreso);

    Date getFechaLanzamiento();

    void setFechaLanzamiento(Date newFechaLanzamiento);

    Date getFechaUltimo();

    void setFechaUltimo(Date newFechaUltimo);

    Long getFrecuencia();

    void setFrecuencia(Long newFrecuencia);

    Long getMarca();

    void setMarca(Long newMarca);

    Long getMomentoEntrega();

    void setMomentoEntrega(Long newMomentoEntrega);

    BigDecimal getMontoVentas();

    void setMontoVentas(BigDecimal newMontoVentas);

    Integer getNumeroCampanyas();

    void setNumeroCampanyas(Integer newNumeroCampanyas);

    Integer getNumeroOrdenes();

    void setNumeroOrdenes(Integer newNumeroOrdenes);

    Integer getNumeroParticipantes();

    void setNumeroParticipantes(Integer newNumeroParticipantes);

    Integer getNumeroUnidades();

    void setNumeroUnidades(Integer newNumeroUnidades);

    String getObjetivo();

    void setObjetivo(String newObjetivo);

    Long getOid();

    void setOid(Long newOid);

    Long getPais();

    void setPais(Long newPais);

    Long getPlantilla();

    void setPlantilla(Long newPlantilla);

    Long getRegalo();

    void setRegalo(Long newRegalo);

    Long getRegion();

    void setRegion(Long newRegion);

    String getRelacionMaterial();

    void setRelacionMaterial(String newRelacionMaterial);

    Long getSubgerencia();

    void setSubgerencia(Long newSubgerencia);

    Long getTerritorio();

    void setTerritorio(Long newTerritorio);

    Long getZona();

    void setZona(Long newZona);

    Long getSeccion();

    void setSeccion(Long newSeccion);

    Long getPeriodoIniComparativo();

    void setPeriodoIniComparativo(Long newPeriodoIniComparativo);

    Long getPeriodoFinComparativo();

    void setPeriodoFinComparativo(Long newPeriodoFinComparativo);

    Long getPeriodoIniConstancia();

    void setPeriodoIniConstancia(Long newPeriodoIniConstancia);

    Long getPeriodoFinConstancia();

    void setPeriodoFinConstancia(Long newPeriodoFinConstancia);

    Long getPeriodoIngreso();

    void setPeriodoIngreso(Long newPeriodoIngreso);

    Long getTipo();

    void setTipo(Long newTipo);

    Long getTipoClasificacion();

    void setTipoClasificacion(Long newTipoClasificacion);

    Long getTipoCliente();

    void setTipoCliente(Long newTipoCliente);

    Long getSubtipoCliente();

    void setSubtipoCliente(Long newSubtipoCliente);

    Long getStatusCliente();

    void setStatusCliente(Long newStatusCliente);

    Long getAcceso();

    void setAcceso(Long newAcceso);

    Boolean isControlFuncion();

    void setControlFuncion(Boolean newControlFuncion);
    
    Long getClienteCapacitador();

    void setClienteCapacitador(Long clienteCapacitador);

    Long getSubtipoClienteCapacitador();

    void setSubtipoClienteCapacitador(Long subtipoClienteCapacitador);

    Long getTipoClasificacionCapacitador();

    void setTipoClasificacionCapacitador(Long tipoClasificacionCapacitador);

    void modifica() throws  DuplicateKeyException,  EJBException, CreateException;

    void elimina() throws EJBException, RemoveException;

}
