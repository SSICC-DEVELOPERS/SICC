package es.indra.sicc.logicanegocio.ccc;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.dtos.ccc.DTOCodigoProceso;
import es.indra.sicc.dtos.ccc.DTOConsultarMarcasTipoAbono;
import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;
import es.indra.sicc.entidades.ccc.MarcasTipoAbonoLocal;
import es.indra.sicc.entidades.ccc.MarcasTipoAbonoLocalHome;
import es.indra.sicc.logicanegocio.ccc.ErroresDeNegocio;
import es.indra.sicc.logicanegocio.seg.ConstantesSEG;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;

import java.util.Collection;
import java.util.Iterator;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMarcasPorTipoAbonoBean implements SessionBean  {
  public void ejbCreate() {}
  public void ejbActivate() {}
  public void ejbPassivate() {}
  public void ejbRemove() {}

  SessionContext ctx = null;  
  public void setSessionContext(SessionContext ctx) { this.ctx=ctx; }

  public DTOSalida cargaMarcasSituacion(DTOBelcorp dto) throws MareException {    
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.cargaMarcasSituacion(DTOBelcorp dto): Entrada");

    /*
     *  marcasSituacion = Llamar al método DAOCCC.obtenerMarcasSituacion(dto) 

        Creamos un DTOSalida: 
        DTOSalida.resultado = marcasSituacion 

        Devolvemos el DTOSalida
    */
    DAOCCC dao = new DAOCCC();    
    DTOSalida dtoS = new DTOSalida();
    RecordSet rsMarcasSituacion = new RecordSet();
    
    rsMarcasSituacion = dao.obtenerMarcasSituacion(dto);    
    dtoS.setResultado(rsMarcasSituacion);
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.cargaMarcasSituacion(DTOBelcorp dto): Salida");
    return dtoS;
    
  }

  public DTOSalida buscar(DTOMarcasPorTipoAbono dto) throws MareException {    
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.buscar(DTOMarcasPorTipoAbono dto): Entrada");
    UtilidadesLog.debug("************El dto es " + dto);
    
    DAOCCC dao = new DAOCCC();
    DTOSalida dtoSalida = new DTOSalida();

    dtoSalida = dao.buscarMarcasPorTipoAbono(dto);
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.buscar(DTOMarcasPorTipoAbono dto): Salida");
    return dtoSalida;
  }

  public void guardar(DTOMarcasPorTipoAbono dto) throws MareException {
     
     UtilidadesLog.info("MONMarcasPorTipoAbonoBean.guardar(DTOMarcasPorTipoAbono dto): Entrada");
      try {        
            // Si (oid != null) { 
            //Es una modificación 
            //Llamamos a parametrosAuditoria del home del entity MarcasTipoAbono pasandole el dto
            Long oid = dto.getOid();
            
            UtilidadesLog.debug("***** OID *****" + oid);
            
            
            if (oid != null){
                MarcasTipoAbonoLocalHome mtalh = this.getMarcasTipoAbonoLocalHome();                
            
            //Borramos todos las marcas asociadas al tipo de abono recibido 
            //Se hace un findByTipoAbonoSubproceso de la entidad MarcasTipoAbono, 
            ///obteniendo todos las marcas actualmente asociadas al tipo de abono 
            //Eliminamos todas la marcas obtenidas 
            //Se llama al metodo remove de cada entidad obtenida 
            //}
                Collection coll = mtalh.findByTipoAbonoSubproceso(dto.getTipoAbono());
                Iterator it = coll.iterator();
                UtilidadesLog.debug("************** COL ********" + coll);
                

                  while(it.hasNext()) {
                    MarcasTipoAbonoLocal mtal = (MarcasTipoAbonoLocal)it.next();
                    mtalh.remove(mtal);
                  }// while
            }// (oid != null)
            
            //Antes de insertar en la entidad se comprueba que no exista ya una 
            //marca para el mismo tipo de abono/cargo 
            //tiposAbono = Llamar al método findByTipoAbonoSubproceso (dto.tipoAbono) de 
            //la entidad 
            //Si obtengo algún registro 
            //lanzar una MARE-Exception con el mensaje de error CCC-0058: 
            //"Ya existe una marca para el proceso, subproceso y tipo de abono/cargo 
            //seleccionados" 
            MarcasTipoAbonoLocalHome mtalh = this.getMarcasTipoAbonoLocalHome();
            Collection cMarca = mtalh.findByTipoAbonoSubproceso(dto.getTipoAbono());
            if ( cMarca.size() > 0 ){
                UtilidadesLog.debug("** Ya existe una marca para el proceso, subproceso y tipo de abono/cargo seleccionados");
               
                            
                 throw new MareException(new Exception(),
                    UtilidadesError.armarCodigoError(ConstantesSEG.MODULO_CCC, "",
                        ErroresDeNegocio.CCC_0058));
            }
//Se llama al create de la entidad MarcasTipoAbono con: 
//observaciones = dto.observaciones 
//idEntradaSalida = 'S' 
//marca = dto.marcaSituacionSalida 
//tipoAbonoSubproceso = dto.tipoAbono 
            if(dto.getMarcaSituacionSalida()!=null) {
                //MarcasTipoAbonoLocal 
                 mtalh.create(
                "S",
                dto.getObservaciones(),            
                dto.getMarcaSituacionSalida(),
                dto.getTipoAbono());
            }

//Por cada elemento en el array marcasSituacionEntrada { 
//Llamamos al create de entidad MarcasTipoAbono con: 
//observaciones = dto.observaciones 
//idEntradaSalida = 'E' 
//marca = dto.marcasSituacionEntrada[i] 
//tipoAbonoSubproceso = dto.tipoAbono 
            if(dto.getMarcasSituacionEntrada()!=null) {
                Long[] marcaSituacionEntrada = dto.getMarcasSituacionEntrada();
                
                for(int i=0;i<marcaSituacionEntrada.length;i++) {
                    UtilidadesLog.debug("***** marcaSituacionEntrada: " + marcaSituacionEntrada[i]);          
                }
            
                int j=0;
                while(j<marcaSituacionEntrada.length) {
                    //MarcasTipoAbonoLocal
                     mtalh.create(
                    "E",
                    dto.getObservaciones(),            
                    marcaSituacionEntrada[j],
                    dto.getTipoAbono());
                   
                    j++;
                }          
            }

      }
      catch (NoResultException ne) {
        UtilidadesLog.error(ne);
        ctx.setRollbackOnly();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
     }
       catch (PersistenceException ne) {
        UtilidadesLog.error(ne);
        ctx.setRollbackOnly();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
      }
     
     UtilidadesLog.info("MONMarcasPorTipoAbonoBean.guardar(DTOMarcasPorTipoAbono dto): Salida");
  }

  public void elimina(DTOOIDs dto) throws MareException {    
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.elimina(DTOOIDs dto): Entrada");
    UtilidadesLog.debug("***** dto: " + dto);
    Long[] array = dto.getOids();
    for(int i=0;i<array.length;i++) {
      UtilidadesLog.debug("***** array " + array[i]);     
    }
    //i=0 
    //por cada elemento en el dto de entrada 
    //{ 
    //Llamamos al método DAOCCC.eliminarMarcasTipoAbono(dto.oid[i]) 
    //i++ 
    //}
        Long[] oids = dto.getOids();
        DAOCCC dao = new DAOCCC();
        for(int i=0; i<oids.length; i++) {
            dao.eliminarMarcasTipoAbono(oids[i]);
      }
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.elimina(DTOOIDs dto): Salida");
  }

  public DTOSalida obtieneSubprocesos(DTOOID dto) throws MareException {    
// Delegamos en el método DAOCCC.obtieneSubprocesos(dto, true) 
// pasándole el oid del proceso y el indicador de de subproceso gestiona marcas = true

    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneSubprocesos(DTOOID dto): Entrada");
    DAOCCC dao = new DAOCCC();
    DTOSalida dtoSalida = new DTOSalida();
    dtoSalida = dao.obtieneSubprocesos(dto, Boolean.TRUE);  
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneSubprocesos(DTOOID dto): Salida");
    return dtoSalida;
  }


  public DTOSalida obtieneTiposAbonoSubproceso(DTOOID dto) throws MareException {
    //Delegamos en el mtodo del mismo nombre del DAOCCC
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneTiposAbonoSubproceso(DTOOID dto): Entrada");
    DTOSalida dtoSalida = new DTOSalida();
    DAOCCC dao = new DAOCCC();
    dtoSalida = dao.obtieneTiposAbonoSubproceso(dto);
    UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneTiposAbonoSubproceso(DTOOID dto): Salida");
    return dtoSalida;
  }

  private MarcasTipoAbonoLocalHome getMarcasTipoAbonoLocalHome() {    
    return new MarcasTipoAbonoLocalHome();
  }
  
    public DTOSalida obtieneSubprocesosProcesoPais(DTOCodigoProceso dto) throws MareException {
            UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneSubprocesosProcesoPais(DTOCodigoProceso dto): Entrada");
            DAOCCC miDao = new DAOCCC();
            DTOSalida salida = miDao.obtieneSubprocesosProcesoPais(dto);
            UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneSubprocesosProcesoPais(DTOCodigoProceso dto): Salida");
            return salida;
    }

    public DTOSalida obtieneProcesos(DTOBelcorp dto) throws MareException
    {
        // procesos = Llamar al método DAOCCC.obtieneProcesosPais(dto.pais, false, false) 
        //Crear un DTOSalida: 
        //DTOSalida.resultado = procesos 
        
        //Devolvemos el DTOSalida
        UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneProcesos(DTOBelcorp dto): Entrada");
        DAOCCC dao = new DAOCCC();
        RecordSet rsProcesos = new RecordSet();
        DTOSalida dtoS = new DTOSalida();
    
        rsProcesos = dao.obtieneProcesosPais(dto.getOidPais().longValue(),false,false);    
        dtoS.setResultado(rsProcesos);
        UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneProcesos(DTOBelcorp dto): Salida");    
        return dtoS;
    }

    public DTOSalida obtieneSubprocesosMarcas(DTOOID dto) throws MareException
    {
        UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneSubprocesosMarcas(DTOOID dto): Entrada");    
        //Delegamos en el método DAOCCC.obtieneSubprocesos(dto : DTOOID, marcas: Boolean), dto y true.
        DAOCCC dao = new DAOCCC();
        DTOSalida dtoS = new DTOSalida();
        dtoS = dao.obtieneSubprocesos(dto, Boolean.TRUE);
        UtilidadesLog.info("MONMarcasPorTipoAbonoBean.obtieneSubprocesosMarcas(DTOOID dto): Salida");            
        return null;
    }

    public DTOConsultarMarcasTipoAbono consultar(DTOMarcasPorTipoAbono dto) throws MareException
    {
        //DTOS = Llamamos al método DAOCCC.consultarMarcasTipoAbono (dto) 
        //Devolvemos el DTOS 
        UtilidadesLog.info("MONMarcasPorTipoAbonoBean.consultar(DTOMarcasPorTipoAbono dto): Entrada");            
        DAOCCC dao = new DAOCCC();
        DTOConsultarMarcasTipoAbono dtoCMTA = new DTOConsultarMarcasTipoAbono();
        dtoCMTA = dao.consultarMarcasTipoAbono(dto);
        UtilidadesLog.info("MONMarcasPorTipoAbonoBean.consultar(DTOMarcasPorTipoAbono dto): Salida"); 
        return dtoCMTA;
    }


}
