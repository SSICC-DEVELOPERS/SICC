package es.indra.sicc.logicanegocio.men;

import es.indra.mare.common.mgu.manager.UserIDImpl;

import es.indra.sicc.dtos.men.DTOEntradaMENSeguridad;

import java.util.HashMap;

import javax.ejb.EJBLocalObject;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.dtos.men.DTOEntradaBorrarUsuario;
import es.indra.sicc.dtos.men.DTOSalidaMantenimientoUsuarios;
import es.indra.sicc.dtos.men.DTOSalidaDepartamentosPerfiles;
import es.indra.sicc.dtos.men.DTOIdentUsuario;
import es.indra.sicc.dtos.men.DTOEntradaInsertarUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPais;
import es.indra.sicc.dtos.men.DTOEntradaConsultarUsuario;
import es.indra.sicc.dtos.men.DTOEntradaCriteriosDeBusquedaUsuarios;
import es.indra.sicc.dtos.men.DTOEntradaCambiarPassword;
import es.indra.sicc.util.DTOString;

public interface MONUsuariosLocal extends EJBLocalObject 
{
    DTOSalida obtenerUsuarios(DTOBelcorp dtoin) throws MareException;

    void removeUsuario(DTOEntradaBorrarUsuario dtoe) throws MareException;

    DTOSalidaMantenimientoUsuarios prepararMantenimiento(DTOEntradaMENSeguridad dtoe) throws MareException;

    DTOIdentUsuario obtenerUsuario(DTOIdentUsuario dtoe) throws MareException;

    String obtenerPaginaInicio(DTOEntradaMENSeguridad dtoe) throws MareException;

    DTOSalida obtenerCodUsuarios(DTOBelcorp dto) throws MareException;

    void modificarUsuario(DTOEntradaInsertarUsuarios dtoe) throws MareException;

    String modificaPaisDefecto(DTOEntradaCambiarPais dtoe) throws MareException;

    DTOSalida consultarUsuario(DTOEntradaConsultarUsuario dtoe) throws MareException;

    DTOSalida buscarUsuario(DTOEntradaCriteriosDeBusquedaUsuarios dtoe) throws MareException;

    DTOSalida recargaAccesosScr(DTOString dtoe) throws MareException;

    DTOSalida recargaSubAccesosScr(DTOString dtoe) throws MareException;

    DTOSalida recargaSubGerenciasScr(DTOString dtoe) throws MareException;

    DTOSalida recargaSociedadesScr(DTOString dtoe) throws MareException;

    DTOSalida recargaRegionesScr(DTOString dtoe) throws MareException;

    DTOSalida recargaZonasScr(DTOString dtoe) throws MareException;

    DTOSalida recargaSeccionesScr(DTOString dtoe) throws MareException;

    DTOSalida recargaTerritoriosPorSeccionesScr(DTOString dtoe) throws MareException;

    DTOSalida recuperaUsuariosSustitucion(DTOString dtoe) throws MareException;

    DTOSalida consultarUsuario2(DTOEntradaConsultarUsuario dtoe) throws MareException;

    HashMap getMergedProperties(DTOEntradaConsultarUsuario dtoe) throws MareException;

    HashMap getProperties(UserIDImpl usr) throws MareException;

    void cambiarPassword(DTOEntradaCambiarPassword dtoe) throws MareException;

    DTOSalida getProperties2(UserIDImpl usr) throws MareException;

    DTOSalidaDepartamentosPerfiles preparaMantenimientoBusqueda(Long idioma) throws MareException;
}
