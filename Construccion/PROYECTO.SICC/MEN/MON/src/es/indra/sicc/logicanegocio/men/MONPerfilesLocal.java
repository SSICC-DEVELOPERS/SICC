package es.indra.sicc.logicanegocio.men;

import es.indra.sicc.dtos.men.DTOEntradaAgregarRoles;

import javax.ejb.EJBLocalObject;
import es.indra.sicc.dtos.men.DTOPerfil;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.men.DTOEntradaEliminarPerfil;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import java.util.Collection;
import es.indra.sicc.dtos.men.DTOString;
import es.indra.sicc.dtos.men.DTOEntradaModificarPerfiles;
import es.indra.sicc.dtos.men.DTOStrings;
import java.util.HashSet;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusqueda;
import es.indra.sicc.dtos.men.DTOCargaPerfil;

public interface MONPerfilesLocal extends EJBLocalObject 
{
    void crear(DTOPerfil dto) throws MareException;

    void removePerfiles(DTOEntradaEliminarPerfil dtoe) throws MareException;

    RecordSet recuperaTodos() throws MareException;

    Collection obtenerPropiedadesInicio(Long oidFuncion) throws MareException;

    RecordSet obtenerFuncionesPerfil(DTOString dto) throws MareException;

    void modificarPerfiles(DTOEntradaModificarPerfiles dtoe) throws MareException;

    void modificar(DTOPerfil dto) throws MareException;

    void eliminar(DTOStrings dto) throws MareException;

    void setRoles(DTOEntradaAgregarRoles dto, HashSet roles) throws MareException;

    DTOSalida buscar(DTOString dto) throws MareException;

    DTOSalida buscarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe) throws MareException;

    DTOCargaPerfil cargaInicial(DTOString dto) throws MareException;

    DTOSalida consultarPerfiles(DTOEntradaCriteriosDeBusqueda dtoe) throws MareException;
}