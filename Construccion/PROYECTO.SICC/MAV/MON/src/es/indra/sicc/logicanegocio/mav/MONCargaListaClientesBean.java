package es.indra.sicc.logicanegocio.mav;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.files.ExcelUtil;
import es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente;
import es.indra.sicc.dtos.zon.DTOFicheroDisp;
import es.indra.sicc.dtos.zon.DTOManagerFileResult;
import es.indra.sicc.util.BelcorpService;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.DTOString;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.sicc.util.UtilidadesEJB;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import es.indra.sicc.util.UtilidadesPaginacion;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import org.apache.commons.lang.StringUtils;


public class MONCargaListaClientesBean implements SessionBean {
    SessionContext ctx = null;

    public void ejbCreate() {}

    public void ejbActivate() {}

    public void ejbPassivate() {}

    public void ejbRemove() {}

    public void setSessionContext(SessionContext ctx) {
        this.ctx = ctx;
    }

    /**
     * sapaza -- PER-SiCC-2010-0699 -- 10/12/2010
     * 
     * Se realice el ajuste al proceso debido a que ahora recibira archivos Excel
     */
    public DTOManagerFileResult procesar(DTOFicheroDisp dto) throws MareException {
        UtilidadesLog.info("MONCargaListaClientesBean.procesar(DTOFicheroDisp dto): Entrada");
        
        if(dto == null) {
            UtilidadesLog.debug("dto: DTOFicheroDisp, es nulo.......");
            return null;
        }
        UtilidadesLog.debug("dtoFichero: " + dto);
        DTOManagerFileResult fResu = new DTOManagerFileResult();
        
        FicheroListaClientes fichero = null;
        Long oidListaClientes = null;
        ArrayList listMapFila = new ArrayList();
        int fila=0;
        
        try {        
            Long oidPaisActivo = dto.getOidPais();                              // Importante: Pais Activo del usuario
            String codPaisActivo = this.obtieneCodPais(oidPaisActivo);
            UtilidadesLog.debug("=== (00) El Pais Activo es: " + codPaisActivo + " (oid: " + oidPaisActivo + ")");
            
            //Abrimos el archivo Excel para su procesamiento
            ExcelUtil excelUtil = new ExcelUtil(dto.getPathFichero(), dto.getNombreFichero(), false);         
            //nos colocamos en la primera hora del documento Excel
            excelUtil.initSheet(0);
            
            //eliminar clientes de la tabla temporal
            eliminarClientesTemporales();
            
            boolean errorPorFila =false; 
            while(excelUtil.hasNext()) {
                Map mapRow = excelUtil.next();
                fila +=1;
                errorPorFila= false;
    
                //obtenemos el codigo Pais, codigo de cliente y Numero Unidades 
                String codigoPais=(String)mapRow.get("0");
                String codigoCliente=(String)mapRow.get("1");
                String numeroUnidades=(String)mapRow.get("2");
                Long oidCliente = null;
                String filaExcel = (String)mapRow.get("rowNum");//obtiene la fila con datas
                 
                 while(fila<Integer.parseInt(filaExcel)){
                     anhadirFilaVacia(listMapFila,fila);                             
                     fila +=1;
                 }
                 
                 //validaciones
                 String mensajeError="";
    
                 if(StringUtils.isEmpty(codigoPais)){
                     mensajeError = "error.codigoPaisVacio";
                 }       
    
                 if(StringUtils.isEmpty(codigoCliente)){
                         mensajeError = "error.codigoClienteVacio";
                 }       
                 
                 if(StringUtils.isEmpty(numeroUnidades)){
                     mensajeError = "error.numeroUnidadesVacio";
                 }       
                 
                 if(StringUtils.isEmpty(codigoPais) && StringUtils.isEmpty(codigoCliente) && StringUtils.isEmpty(numeroUnidades) ){
                     mensajeError = "error.noRegistroFila";
                 }
    
                 if(StringUtils.isNotEmpty(codigoPais)){
                    if (!codPaisActivo.equals(codigoPais)) {    
                        mensajeError = "error.PaisNoActivo";
                    }
                 }   
    
                 if(StringUtils.isNotEmpty(codigoCliente)){                     
                     oidCliente = validarCliente(oidPaisActivo, codigoCliente);
                     if(oidCliente == null){
                         mensajeError = "error.noExisteConsultora";
                     }
                 }
    
                 if(StringUtils.isNotEmpty(numeroUnidades)){
                     if(!validoFormatoPuntaje(numeroUnidades)){
                         mensajeError = "error.noFormatoNumeroUnidades";
                     }
                 }                                                       
    
                 UtilidadesLog.debug("Insertamos registro de Cliente : + codigoCliente");
                 String message = insertCliente(codigoCliente, oidCliente, numeroUnidades, fila, mensajeError);
            }
            
            //verificamos los clientes duplicados
            updateClientesDuplicados();
            
            //actualizamos todos los duplicados de codigo de consultora
            RecordSet resultado = recuperarFilasErroneas();
            if( !resultado.esVacio() )
                for(int j = 0; j < resultado.getRowCount(); j++) {
                    //Lo almacenamos en una lista temporal
                    Map mapFila = new HashMap();
                    mapFila.put("numeroFila", resultado.getValueAt(j, 0).toString());
                    mapFila.put("codigoCliente", resultado.getValueAt(j, 1).toString());
                    mapFila.put("mensajeError", resultado.getValueAt(j, 2).toString());
                    listMapFila.add(mapFila);
                    UtilidadesLog.debug("Fila : " + mapFila);
                }               
            
            excelUtil.cerrar();
            fResu.setEstatus(new Long(-2)); // Procesamiento Finalizado OK 
            fResu.setListaRespuesta(listMapFila);
        } catch(MareException ne) {
            UtilidadesLog.error(ne);
            throw ne;
        } catch(Exception e) {
            UtilidadesLog.error(e);
            ctx.setRollbackOnly();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }


        if (fila == 0) {
            UtilidadesLog.error("El archivo esta vacio");
            fResu.setEstatus(new Long(-4)); // Procesamiento Finalizado Error
        } else {
            fResu.setReporteRegistros(String.valueOf(fila));
        }
         
        return fResu;
    }

    
    private String obtieneCodPais(Long oidPais) throws MareException {
        UtilidadesLog.info("MONCargaListaClientesBean.obtieneCodPais(Long oidPais) - Entrada");
        // Ahora obtengo el Codigo del Pais en base a su oid que viene de la sesion del usuario. 
        String codPais = null;
         
        StringBuffer sql = new StringBuffer("");
        sql.append(" SELECT p.COD_PAIS ");
        sql.append("   FROM SEG_PAIS p ");
        sql.append("  WHERE p.OID_PAIS = " + oidPais + " ");     
        
        try {
            BelcorpService bs = BelcorpService.getInstance();
            RecordSet r = bs.dbService.executeStaticQuery(sql.toString());
            if (!r.esVacio()) {
                codPais = (String) r.getValueAt(0,0);
            } else {
                UtilidadesLog.error("No se ha encontrado Codigo del Pais cuyo oid es:" + oidPais);
                String descError = CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE;
                throw new MareException("No se encontro el Codigo de Pais para su oid:" + oidPais , 
                    UtilidadesError.armarCodigoError(descError));
            }
        } catch (MareMiiServiceNotFoundException mEx) {
            UtilidadesLog.error(mEx);
            throw new MareException(mEx, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        } catch (Exception ex) {
            UtilidadesLog.error(ex);
            throw new MareException(ex, 
                UtilidadesError.armarCodigoError(CodigosError.ERROR_AL_LOCALIZAR_UN_COMPONENTE_EJB));
        }
        UtilidadesLog.debug("codigo de Pais a retornar: " + codPais);
        UtilidadesLog.info("MONCargaListaClientesBean.obtieneCodPais(Long oidPais) - Salida");
        return codPais;
    }
    
    // sapaza -- PER-SiCC-2010-0699 -- 13/12/2010
    public DTOSalida busquedaListaClientes(DTOBusquedaRapidaCliente dto) throws MareException {
        UtilidadesLog.info("MONCargaListaClientesBean.busquedaListaClientes(DTOBusquedaRapidaCliente): Entrada"); 
        String codigoError;

        DTOSalida sl = new DTOSalida();
        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        try {
            bs = UtilidadesEJB.getBelcorpService();

            StringBuffer query = new StringBuffer();
            String whereStr;

            query.append(" SELECT distinct c.OID_CLIE OID, c.COD_CLIE, c.VAL_NOM1, c.VAL_NOM2, c.VAL_APE1, c.VAL_APE2, i.NUM_UNID ");
            query.append("   FROM MAE_CLIEN c, MAV_LISTA_CLIEN_CLIEN i ");
            query.append("  WHERE c.PAIS_OID_PAIS = " + dto.getOidPais());
            query.append("    AND i.CLIE_OID_CLIE = c.OID_CLIE ");
            query.append("    AND i.LICL_OID_LISTA_CLIE = " + dto.getCriterioBusqueda1());

            if (dto.getCodigoCliente() != null) {
                query.append("    AND c.COD_CLIE LIKE '" + dto.getCodigoCliente() + "' ");
            }

            if ((dto.getApellido1() != null) && (!dto.getApellido1().equals(""))) {
                query.append(" AND UPPER(c.VAL_APE1) LIKE UPPER('" + dto.getApellido1() + "') "); 
            }

            if ((dto.getApellido2() != null) && (!dto.getApellido2().equals(""))) {
                query.append(" AND UPPER(c.VAL_APE2) LIKE UPPER('" + dto.getApellido2() + "') "); 
            }

            String queryStr = UtilidadesPaginacion.armarQueryPaginacion(query.toString(), dto);

            resultado = bs.dbService.executeStaticQuery(queryStr);
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        if (resultado.esVacio()) {
            UtilidadesLog.debug("####### EL RESULTADO ES VACIO ######");
            throw new MareException(null, null, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
        }

        sl.setResultado(resultado);
        UtilidadesLog.info("MONCargaListaClientesBean.busquedaListaClientes(DTOBusquedaRapidaCliente): Salida"); 

        return sl;
    }

    private Long validarCliente(Long oidPais, String codigoCliente) throws MareException {
        UtilidadesLog.info("MONCargaListaClientes.validarCliente() - Entrada");
        BelcorpService bs;
        RecordSet resultado = null;
        Long oidClienteValidado = null;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
                
        try {
            // Valido los codigos y obtengo oids de cliente realizando consulta
            StringBuffer sqlValidacion = new StringBuffer("");
            sqlValidacion.append(" SELECT OID_CLIE ");
            sqlValidacion.append("   FROM MAE_CLIEN ");
            sqlValidacion.append("  WHERE PAIS_OID_PAIS = " + oidPais);
            sqlValidacion.append("    AND COD_CLIE = '" + codigoCliente + "'");
                        
            resultado = bs.dbService.executeStaticQuery(sqlValidacion.toString());
            
            if((resultado!=null) && (!resultado.esVacio())) {
                oidClienteValidado = new Long(((BigDecimal) resultado.getValueAt(0,0)).longValue());
            }
            
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al validar Codigos de cliente del archivo", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONCargaListaClientes.validarCliente() - Salida");
        return oidClienteValidado;
    }

    private boolean validoFormatoPuntaje(String numeroPuntaje) {
        boolean valor=true;
        try{
                Double.parseDouble(numeroPuntaje);
        }catch(Exception e){
                valor=false;
        }
        return valor;
    }

    private void anhadirFilaVacia(ArrayList listMapFila, int fila) {
        Map mapFila = new HashMap();
        mapFila.put("numeroFila", String.valueOf(fila));
        mapFila.put("codigoCliente", "");
        mapFila.put("mensajeError", "procesoINCDarPorAtendidoBolsaFaltantesForm.error.noRegistroFila");
        listMapFila.add(mapFila);               
    }

    private String insertCliente(String codigoCliente, Long oidCliente, String numeroUnidades, int numeroFila, String mensajeError) throws MareException {
        UtilidadesLog.info("MONCargaListaClientes.insertCliente() - Entrada");
        BelcorpService bs;
        StringBuffer sqlInsercion = new StringBuffer();
        String valor = "";
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            // El insert sobre MAV_LISTA_CLIEN_TEMPO
            sqlInsercion.append("INSERT INTO MAV_LISTA_CLIEN_TEMPO (COD_CLIE, CLIE_OID_CLIE, NUM_UNID, NUM_FILA, COD_MENS_ERRO) ");
            sqlInsercion.append("VALUES (");

            if(codigoCliente == null)
                sqlInsercion.append("NULL");
            else
                sqlInsercion.append("'" + codigoCliente + "'");

            if(oidCliente == null)
                sqlInsercion.append(", NULL");
            else
                sqlInsercion.append("," +  oidCliente);

            if(numeroUnidades == null)
                sqlInsercion.append(", NULL");
            else
                sqlInsercion.append(",'" + numeroUnidades + "'");
            
            sqlInsercion.append("," + numeroFila + ",'" + mensajeError + "')");

            bs.dbService.executeUpdate(sqlInsercion.toString());    
        }catch(Exception e){
            valor = e.getMessage();
        }
        
        return valor;
    }       
    
    private void updateClientesDuplicados() throws MareException {
        UtilidadesLog.info("MONCargaListaClientes.updateClientesDuplicados() - Entrada");
        BelcorpService bs;
        StringBuffer sqlInsercion = new StringBuffer();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            // El update sobre MAV_LISTA_CLIEN_TEMPO
            sqlInsercion.append("UPDATE MAV_LISTA_CLIEN_TEMPO ");
            sqlInsercion.append("   SET COD_MENS_ERRO = 'error.existenDuplicados' ");
            sqlInsercion.append(" WHERE CLIE_OID_CLIE IN (  ");
            sqlInsercion.append("                    SELECT CLIE_OID_CLIE  ");
            sqlInsercion.append("                      FROM (SELECT CLIE_OID_CLIE, COUNT(1) ");
            sqlInsercion.append("                              FROM MAV_LISTA_CLIEN_TEMPO ");            
            sqlInsercion.append("                              WHERE CLIE_OID_CLIE IS NOT NULL ");
            sqlInsercion.append("                              GROUP BY CLIE_OID_CLIE ");
            sqlInsercion.append("                             HAVING COUNT(1) > 1)  ) ");

            bs.dbService.executeUpdate(sqlInsercion.toString());    
        }catch(Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al tratar de eliminar clientes de la tabla temporal", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        UtilidadesLog.info("MONCargaListaClientes.updateClientesDuplicados() - Salida");
    }     
    
    public RecordSet recuperarFilasErroneas() throws MareException {
        UtilidadesLog.info("MONCargaListaClientesBean.recuperarFilasErroneas(): Entrada"); 

        BelcorpService bs;
        RecordSet resultado = new RecordSet();

        try {
            bs = UtilidadesEJB.getBelcorpService();

            StringBuffer query = new StringBuffer();
            String whereStr;

            query.append(" SELECT NUM_FILA, COD_CLIE, COD_MENS_ERRO ");
            query.append("   FROM MAV_LISTA_CLIEN_TEMPO ");
            query.append("  WHERE COD_MENS_ERRO IS NOT NULL ");
            query.append("  ORDER BY NUM_FILA ");

            resultado = bs.dbService.executeStaticQuery(query.toString());
        } catch (Exception e) {
            e.printStackTrace();
            throw new MareException(e, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_LECTURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONCargaListaClientesBean.recuperarFilasErroneas(): Salida"); 

        return resultado;
    }
    

    private void eliminarClientesTemporales() throws MareException {
        UtilidadesLog.info("MONCargaListaClientes.eliminarClientesTemporales() - Entrada");
        BelcorpService bs;
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        try {
            // El insert sobre MAV_LISTA_CLIEN_TEMPO
            String sqlEliminacion = "DELETE FROM MAV_LISTA_CLIEN_TEMPO";

            bs.dbService.executeUpdate(sqlEliminacion);    
        }catch(Exception e){
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al tratar de eliminar clientes de la tabla temporal", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }

        UtilidadesLog.info("MONCargaListaClientes.eliminarClientesTemporales() - Salida");
    }

    public DTOString procesarLista(DTOString dto) throws MareException {
        UtilidadesLog.info("MONCargaListaClientes.procesarLista() - Entrada");
        BelcorpService bs;
        StringBuffer sqlInserciones = new StringBuffer();
        Long oidListaClientes = null;
        String strOidListaClientes;
        DTOString respuesta = new DTOString();
        
        try {
            bs = BelcorpService.getInstance();
        } catch (MareException e) {
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_AL_PEDIR_UN_SERVICIO_MARE));
        }
        
        //recuperar la cantidad de clientes que estan siendo procesadas
        Long cantClientes = null;
        try {
            // Valido los codigos y obtengo oids de cliente realizando consulta
            String sqlTotal = "SELECT COUNT(1) FROM MAV_LISTA_CLIEN_TEMPO";
                        
            RecordSet resultado = bs.dbService.executeStaticQuery(sqlTotal);
            
            if((resultado!=null) && (!resultado.esVacio())) {
                cantClientes = new Long(((BigDecimal) resultado.getValueAt(0,0)).longValue());
            }
            
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al validar Codigos de cliente del archivo", e);
            throw new MareException(e, UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        
        try {
            // El insert sobre MAV_LISTA_CLIEN
            oidListaClientes = SecuenciadorOID.obtenerSiguienteValor("MAV_LICL_SEQ");
            strOidListaClientes = oidListaClientes.toString();

            sqlInserciones.append("INSERT INTO MAV_LISTA_CLIEN (OID_LIST_CLIE, NUM_CLIE, PAIS_OID_PAIS) ");
            sqlInserciones.append("VALUES (" + strOidListaClientes + ", " + cantClientes + ", " + dto.getOidPais() + ")");
            
            bs.dbService.executeUpdate(sqlInserciones.toString());   
            
            sqlInserciones = new StringBuffer();
            sqlInserciones.append("INSERT INTO MAV_LISTA_CLIEN_CLIEN (OID_LIST_CLIE_CLIE, ");
            sqlInserciones.append("LICL_OID_LISTA_CLIE, CLIE_OID_CLIE, NUM_UNID) ");
            sqlInserciones.append("SELECT MAV_LCLC_SEQ.nextval, " + strOidListaClientes +", ");
            sqlInserciones.append("       CLIE_OID_CLIE, NUM_UNID FROM MAV_LISTA_CLIEN_TEMPO WHERE COD_MENS_ERRO IS NULL ");
            
            bs.dbService.executeUpdate(sqlInserciones.toString());   
        } catch (Exception e) {
            ctx.setRollbackOnly();
            UtilidadesLog.error("Error al insertar Lista de Clientes de MAV",e);
            throw new MareException(e,
                UtilidadesError.armarCodigoError(
                    CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
        }
        UtilidadesLog.debug(" Creada la ListaClientes oid :" + oidListaClientes);
        UtilidadesLog.info("MONCargaListaClientes.procesarLista() - Salida");
        
        respuesta.setCadena(String.valueOf(oidListaClientes));
        return respuesta;
    }
}
