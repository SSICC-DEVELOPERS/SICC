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
package es.indra.sicc.entidades.ccc;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;
import javax.ejb.FinderException;
import javax.ejb.DuplicateKeyException;
import java.util.Collection;


public interface CopiaMovimientoBancarioLocalHome extends EJBLocalHome {
    CopiaMovimientoBancarioLocal create() throws CreateException;

    CopiaMovimientoBancarioLocal findByPrimaryKey(Long primaryKey)
        throws FinderException;

    CopiaMovimientoBancarioLocal create(Long empresa, Long subprocesoMarcaCreacion, Long cuentaCorriente, Long pais, Long consultoraReal, Long tipoAbonoCreacion)
        throws CreateException, DuplicateKeyException;

	Collection findAll() throws Exception, FinderException;
}
