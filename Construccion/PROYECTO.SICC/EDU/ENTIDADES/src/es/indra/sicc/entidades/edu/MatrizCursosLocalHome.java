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

import javax.ejb.EJBLocalHome;
import javax.ejb.CreateException;
import javax.ejb.DuplicateKeyException;
import javax.ejb.FinderException;
import java.sql.Date;
import java.math.BigDecimal;
import java.util.Collection;
import es.indra.mare.common.exception.MareException;

public interface MatrizCursosLocalHome extends EJBLocalHome {

    MatrizCursosLocal create() throws CreateException ;

    /** 
     * @param pais Long con el valor del campo pais
     * @param plantilla Long con el valor del campo plantilla
     * @param canal Long con el valor del campo canal
     * @param marca Long con el valor del campo marca
     * @param acceso Long con el valor del campo acceso
     * @param territorio Long con el valor del campo territorio
     * @param clasificacion Long con el valor del campo clasificacion
     * @param frecuencia Long con el valor del campo frecuencia
     * @param regalo Long con el valor del campo regalo
     * @param subgerencia Long con el valor del campo subgerencia
     * @param region Long con el valor del campo region
     * @param zona Long con el valor del campo zona
     * @param seccion Long con el valor del campo seccion
     * @param periodoIniComparativo Long con el valor del campo periodoIniComparativo
     * @param periodoFinComparativo Long con el valor del campo periodoFinComparativo
     * @param periodoIniConstancia Long con el valor del campo periodoIniConstancia
     * @param periodoFinConstancia Long con el valor del campo periodoFinConstancia
     * @param periodoIngreso Long con el valor del campo periodoIngreso
     * @param tipo Long con el valor del campo tipo
     * @param objetivo String con el valor del campo objetivo
     * @param contenido String con el valor del campo contenido
     * @param relacionMaterial String con el valor del campo relacionMaterial
     * @param montoVentas BigDecimal con el valor del campo montoVentas
     * @param fechaDisponible Date con el valor del campo fechaDisponible
     * @param fechaLanzamiento Date con el valor del campo fechaLanzamiento
     * @param fechaFin Date con el valor del campo fechaFin
     * @param fechaUltimo Date con el valor del campo fechaUltimo
     * @param fechaConcreta Date con el valor del campo fechaConcreta
     * @param fechaIngreso Date con el valor del campo fechaIngreso
     * @param numeroParticipantes Integer con el valor del campo numeroParticipantes
     * @param numeroOrdenes Integer con el valor del campo numeroOrdenes
     * @param numeroCampanyas Integer con el valor del campo numeroCampanyas
     * @param numeroUnidades Integer con el valor del campo numeroUnidades
     * @param descripcion String con el valor del campo descripcion
     * @param accesoDataMart Boolean con el valor del campo accesoDataMart
     * @param alcance Boolean con el valor del campo alcance
     * @param bloqueoExtemporaneas Boolean con el valor del campo bloqueoExtemporaneas
     * @param momentoEntrega Long con el valor del campo momentoEntrega
     * @param condicionPedido Boolean con el valor del campo condicionPedido
     * @param controlMorosidad Boolean con el valor del campo controlMorosidad
     * @param clienteCapacitador Long con el valor del oid de cliente capacitador
     * @param subtipoCliente Long con el valor del campo subtipoCliente
     * @param tipoClasificacion Long con el valor del campo tipoClasificacion
     * @param statusCliente Long con el valor del campo statusCliente
     * @param tipoCliente Long con el valor del campo tipoCliente
     * @param controlFuncion Boolean con el valor del campo controlFuncion
     * @param tipoClasificacionCapacitador Long con el valor del campo tipoClasificacionCapacitador
     * @param subtipoClienteCapacitador Long con el valor del campo subtipoClienteCapacitador
     * @return MatrizCursosLocal
     */
    MatrizCursosLocal create(Long pais, Long plantilla, Long canal, Long marca, Long acceso,
                             Long territorio, Long clasificacion, Long frecuencia, Long regalo,
                             Long subgerencia, Long region, Long zona, Long seccion,
                             Long periodoIniComparativo, Long periodoFinComparativo,
                             Long periodoIniConstancia, Long periodoFinConstancia,
                             Long periodoIngreso, Long tipo, String objetivo, String contenido,
                             String relacionMaterial, BigDecimal montoVentas, Date fechaDisponible,
                             Date fechaLanzamiento, Date fechaFin, Date fechaUltimo, Date fechaConcreta,
                             Date fechaIngreso, Integer numeroParticipantes, Integer numeroOrdenes,
                             Integer numeroCampanyas, Integer numeroUnidades, String descripcion,
                             Boolean accesoDataMart, Boolean alcance, Boolean bloqueoExtemporaneas,
                             Long momentoEntrega, Boolean condicionPedido, Boolean controlMorosidad,
                             //Long capacitador, Long subtipoCliente, Long tipoClasificacion, 
                             Long clienteCapacitador, Long subtipoCliente, Long tipoClasificacion, 
                             Long statusCliente, Long tipoCliente, Boolean controlFuncion, 
                             Integer codigoCurso, Long subtipoClienteCapacitador, 
                             Long tipoClasificacionCapacitador) throws  CreateException, DuplicateKeyException;

    MatrizCursosLocal findByPrimaryKey(Long primaryKey) throws FinderException;

    Collection findByPaisMarcaCanalCurso(Long pais, Long marca, Long canal, Integer curso) throws MareException, FinderException, Exception;

    Collection findByPlantilla(Long plantilla) throws  MareException, FinderException, Exception;
}
