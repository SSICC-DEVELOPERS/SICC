package es.indra.sicc.logicanegocio.mav;
import es.indra.sicc.dtos.mav.DTOEBuscarEstadosMAV;
import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocal;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.i18n.Entidadi18nLocalHome;
import es.indra.sicc.dtos.mav.DTOEstadoMAV;
import es.indra.sicc.entidades.mav.EstadosMAVLocal;
import es.indra.sicc.entidades.mav.EstadosMAVLocalHome;
import es.indra.sicc.entidades.mav.EstadosMAVMAELocal;
import es.indra.sicc.entidades.mav.EstadosMAVMAELocalHome;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.CodigosError;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.UtilidadesError;
import es.indra.sicc.util.UtilidadesLog;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import java.util.Vector;
import es.indra.sicc.util.DTOSalida;

import javax.persistence.NoResultException;
import javax.persistence.PersistenceException;

public class MONMantenimientoEstadosMAVBean implements SessionBean  {
  SessionContext ctx = null;  
  public void ejbCreate() {
  }

  public void ejbActivate() {
  }

  public void ejbPassivate() {
  }

  public void ejbRemove() {
  }

  public void setSessionContext(SessionContext ctx) {
    this.ctx=ctx;
  }


    public void eliminarEstados(DTOOIDs dto) throws MareException {
	    /*
      Entrada: DTOOIDs 
      Para cada oid contenido en el array del dto de entrada hacer: 
      -> Hacer un delete de la tabla MAV_ESTAD_MAV_MAE para todos los registros 
         donde EMAV_OID_ESTA_MAV = oid del dto de entrada. 
      -> Hacer findByPrimaryKey() sobre la entidad "EstadoMAV" 
      -> Hacer remove() 
      Fin Para
    */

    UtilidadesLog.info("MONMantenimientoEstadosMAVBean.eliminarEstados(DTOOIDs dto):Entrada");
    UtilidadesLog.debug("---------------------------------------------------------");
    UtilidadesLog.debug("metodo eliminarEstados parametros "+dto);
    
    Long [] oids= dto.getOids();
    
    int giro =0;
    /*Para cada oid contenido en el array del dto de entrada hacer:*/

  try 
  {
      EstadosMAVLocalHome estadolh = new EstadosMAVLocalHome();            
      EstadosMAVMAELocalHome maemavlh = new EstadosMAVMAELocalHome();      
      EstadosMAVMAELocal maemav = null;
      while (giro <= oids.length-1) 
      {
        UtilidadesLog.debug("oids "+oids);
        UtilidadesLog.debug("collection maemav");
        //EstadosMAVMAELocal maemav = maemavlh.findOidEstadoMAV(oids[giro]);
        Collection col = maemavlh.findOidEstadoMAV(oids[giro]);
        Vector vec = new Vector (col);
        UtilidadesLog.debug("ciclo borrado mae mav");
        for (int vuel = 0; vuel< vec.size();vuel++) 
        {
          maemav = (EstadosMAVMAELocal) vec.elementAt(vuel);
          maemavlh.remove(maemav);
        }
        UtilidadesLog.debug("despues borrado maemav");
             
        /*-> Hacer findByPrimaryKey() sobre la entidad "EstadoMAV"*/
        UtilidadesLog.debug("find estados mav ");
        EstadosMAVLocal estado =estadolh.findByPrimaryKey(oids[giro]);
        /*-> Hacer remove()*/ 
        UtilidadesLog.debug("antes del remove de estados mav");
        estadolh.remove(estado);
        UtilidadesLog.debug("despues del remove estados mav");
        UtilidadesLog.debug("antes del internacionalizacion");
        Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
        Collection col2 = e18nLH.findByEntAtrPK("MAV_ESTAD_MAV", new Long(1),oids[giro]);
        Iterator it = col2.iterator();
        while (it.hasNext())
        {
            Entidadi18nLocal e18nLocal= (Entidadi18nLocal)it.next();
            e18nLH.remove(e18nLocal);
        }
        
        giro++; 
        UtilidadesLog.debug("variable del ciclo"+ giro);
      }

  }   catch (NoResultException ne) 
  {
    UtilidadesLog.error(ne);    
    ctx.setRollbackOnly();
    throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
  }  catch (PersistenceException ne) 
  {
    UtilidadesLog.error(ne);
    ctx.setRollbackOnly();
    throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_BORRADO_DE_DATOS));
   }    
   UtilidadesLog.info("MONMantenimientoEstadosMAVBean.eliminarEstados(DTOOIDs dto):Salida");
  }

	public void guardarEstados(DTOEstadoMAV dto) throws MareException {
	/*
    Entrada: DTOEstadoMAV 
  - oidEstadoMAV 
  - descripcion (arrayList para descripcion internacionalizable) 
  - estadosMAE (arrayList de oids de estados seleccionados en pantalla) 
  - activo 
  - inactivo 
  Proceso: 
  Si "dto.oidEstadoMAV" = null entonces 
  -> Hacer create sobre entidad EstadoMAV con los atributos del dto de entrada 
  -> Tomar oid del registro creado y hacer con él un create sobre entidad EstadoMAVMAE por cada oid contenido en atributo "estadosMAE" del dto de entrada 
  Si no entonces 
  -> Hacer findByPrimaryKey sobre la entidad EstadoMAV con "oidEstadoMAV" del dto de entrada 
  -> Setear los atributos del dto de entrada 
  -> Hacer un "delete" de todos los registros de la tabla MAV_ESTAD_MAV_MAE donde el campo EMAV_OID_ESTA_MAV es igual al oid del EstadoMAV del dto de entrada 
  -> Hacer un create con el "oidEstadoMAV" del dto de entrada sobre entidad EstadoMAVMAE por cada oid contenido en atributo "estadosMAE" del dto de entrada 
   Fin Si
   */
    UtilidadesLog.info("MONMantenimientoEstadosMAVBean.guardarEstados(DTOEstadoMAV dto):Entrada");
    try 
    {  
      UtilidadesLog.debug(" dto "+dto.getOidEstadoMAV());
      if (dto.getOidEstadoMAV()==null) {
        UtilidadesLog.debug("entra con oid =null");
        UtilidadesLog.debug("entra a guardar con DTO "+dto);
	    /*creacion del registro sobre estados mav*/
        EstadosMAVLocalHome estadolh = new EstadosMAVLocalHome();
        UtilidadesLog.debug("dto ip------------------------> "+dto.getIpCliente());        
        UtilidadesLog.debug("despues auditoria");
        /*nuevo regoistro*/
        EstadosMAVLocal estado = estadolh.create(dto.getOidPais());
        UtilidadesLog.debug("despues de local");

        /*seteo de los campos*/
        estado.setActivo(dto.getActivo());
        UtilidadesLog.debug("despues set activo" + dto.getActivo());
        estado.setNoActivo(dto.getNoActivo());
        UtilidadesLog.debug("despues set no activo" + dto.getNoActivo());
        estadolh.merge(estado);
        /* seteo de las descripciones internacionalizables */
        Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
        UtilidadesLog.debug("despues internbacionalizacion");
	      for (int i=0; i<dto.getDescripcion().size(); i++)
        {
            UtilidadesLog.debug("entra loop de internacionalizacion");
            DTOI18nSICC dto18 = (DTOI18nSICC) dto.getDescripcion().elementAt(i); //devuelve los datos de la traducción
            UtilidadesLog.debug("obtine el dtoi18n" + dto18 );
            Long oidIdioma = dto18.getOidIdioma();
            UtilidadesLog.debug("obtine el idioma" + oidIdioma );
            String descripcion = dto18.getValorI18n();
            UtilidadesLog.debug("obtine descripcion" + descripcion );
            e18nLH.create("MAV_ESTAD_MAV", new Long(1), oidIdioma, descripcion,estado.getOid());
            UtilidadesLog.debug("despues del crete" );
        }
        /*seteo de los campos de la tabla relacion*/
        EstadosMAVMAELocalHome maemavlh = new EstadosMAVMAELocalHome();    		
        UtilidadesLog.debug("despues de la relacion");
        UtilidadesLog.debug("dto.getEstadosMAE().size() "+dto.getEstadosMAE().size());
        Long clave =null;
        if (dto.getEstadosMAE().size()>1)
        {
            for (int j=0;j<dto.getEstadosMAE().size();j++)
            {
              /*nuevo regoistro*/
              UtilidadesLog.debug("entra al for ");
              UtilidadesLog.debug("------------------------> dto "+ dto.getEstadosMAE().elementAt(j).toString());
              clave = new Long (dto.getEstadosMAE().elementAt(j).toString());
              UtilidadesLog.debug("obtine clave" + clave);
              maemavlh.create(estado.getOid(),clave);
              UtilidadesLog.debug("create de la realcion" );
            }
        }
        else
        {
            clave = new Long (dto.getEstadosMAE().firstElement().toString());
            maemavlh.create(estado.getOid(),clave);
        }
    } else {
        /* intancia para realizar la modificacion*/
        EstadosMAVLocalHome estadolh = new EstadosMAVLocalHome();                      
        /*busco registro */
        EstadosMAVLocal estado =estadolh.findByPrimaryKey(dto.getOidEstadoMAV());
        /*asigno valores a los campos*/
        estado.setActivo(dto.getActivo());
        estado.setNoActivo(dto.getNoActivo());
        estado.setOidPais(dto.getOidPais());
        estadolh.merge(estado);
        /* internacionalizacion de la descripcion*/
        Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
        /*por cada descripcion hace hace */
        for (int i=0;i< dto.getDescripcion().size();i++) {
              DTOI18nSICC dtoTraduccion = (DTOI18nSICC) dto.getDescripcion().elementAt(i); //devuelve los datos de la traducción
              Long oidIdioma = dtoTraduccion.getOidIdioma();
              String descripcion = dtoTraduccion.getValorI18n();
              try {
                  Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "MAV_ESTAD_MAV", new Long(1) ,oidIdioma, estado.getOid());
                  e18nL.setDetalle(descripcion);
                  e18nLH.merge(e18nL);
              } catch(NoResultException e)
              {
                  UtilidadesLog.debug("No se encontro la descripcion para ese idioma, vamos a crearlo");
                  e18nLH.create("MAV_ESTAD_MAV",new Long (1),oidIdioma,descripcion, estado.getOid());
              }catch(PersistenceException e)
              {
                  UtilidadesLog.debug("No se pudo actualizar la descripcion del idioma");
                  throw new MareException(e,UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
                  
              }
        }
        EstadosMAVMAELocalHome maemavlh = new EstadosMAVMAELocalHome();        
        EstadosMAVMAELocal maemav =null;
        Collection estmae =maemavlh.findOidEstadoMAV(dto.getOidEstadoMAV());
        Vector todos_maemav =new Vector(estmae);
        if (todos_maemav.size()==1){
          maemav= (EstadosMAVMAELocal) todos_maemav.firstElement();
          maemavlh.remove(maemav);
          
        }
        else {
          for (int vueltas=0;vueltas<todos_maemav.size();vueltas++) {
            maemav= (EstadosMAVMAELocal) todos_maemav.elementAt(vueltas);
            maemavlh.remove(maemav);
          }
        }
        Long clave=null;
          for (int j=0;j<dto.getEstadosMAE().size();j++) {
            clave = new Long (dto.getEstadosMAE().elementAt(j).toString());
            UtilidadesLog.debug("obtine clave" + clave);
            maemav = maemavlh.create(estado.getOid(),clave);
            
          } 
        
      }
    } catch(NoResultException ne) {
      	UtilidadesLog.error(ne);
        ctx.setRollbackOnly();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
    } catch (PersistenceException ne) {
        UtilidadesLog.error(ne);
        ctx.setRollbackOnly();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_ESCRITURA_EN_BASE_DE_DATOS));
    }    
    UtilidadesLog.info("MONMantenimientoEstadosMAVBean.guardarEstados(DTOEstadoMAV dto):Salida");
    
  }

	public DTOEstadoMAV consultarEstado(DTOOID dto) throws MareException {
	
    /*
     * Entrada: DTOOID (oidEstadoMAV) 
      -> Construir DTOEstadoMAV 
      -> Hacer findByPrimaryKey sobre la entidad "EstadoMAV". 
      -> Setear los atributos del dto creado con los del registro encontrado 
      -> Hacer consulta sobre tabla MAV_ESTAD_MAV_MAE obteniendo los datos del campo ESTA_OID_ESTA_CLIE, para EMAV_OID_ESTA_MAV = oid del dto de entrada 
      -> Tomar RecordSet obtenido en actividad anterior e introducir cada oid encontrado en el atributo "estadosMAE" de tipo arrayList. 
      -> Devolver DTOEstadoMAV creado
     */
     UtilidadesLog.info("MONMantenimientoEstadosMAVBean.consultarEstado(DTOOID dto):Entrada");
     DTOEstadoMAV estmav =new DTOEstadoMAV();
     try 
     {
      UtilidadesLog.debug("parametros de entrada"+dto);
      /*instanciacion de objeteria a utilizar*/
      EstadosMAVLocalHome estadolh = new EstadosMAVLocalHome();      
      String clave =new String();      
      DAOEstadoMAV consulta =new DAOEstadoMAV ();
      EstadosMAVMAELocalHome maemavlh = new EstadosMAVMAELocalHome();      
      EstadosMAVMAELocal  maemav=null;
      DTOBelcorp param =new DTOBelcorp();
      
      
      
      /* busqueda de todos los registros de estadosmav*/
      EstadosMAVLocal estado= estadolh.findByPrimaryKey(dto.getOid());
      /*buequeda de todos los registros de estados maemav */
      Collection colMAVMAE = maemavlh.findOidEstadoMAV(dto.getOid()); 
      /*para mayor facilidad de utilizacion */
      Vector todo = new Vector(colMAVMAE);
      /*seteo parametros para la consulta*/
      param.setOidIdioma(dto.getOidIdioma());
      param.setOidPais(dto.getOidPais());
      /*vector auxiliar para colocar el recordset*/ 
        Vector aux =new Vector();
      /*verifico si tengo solo un registro o n*/ 
      if (todo.size()==1) {
            /* Se toma el registro se obtienen los datos para mandar a la cosulta con 
             * un artificio para no reescribir la consulta, el recordset se lo toma y 
             * se lo pone en el vector de los estado */
            maemav =(EstadosMAVMAELocal) todo.firstElement();
            clave= maemav.getOidEstatusCliente().toString()+","+maemav.getOidEstatusCliente().toString();
      } else {
         clave ="";
         for (int i=0;i<todo.size();i++) {
            maemav =(EstadosMAVMAELocal) todo.elementAt(i);
            if (i==0) {
             clave= maemav.getOidEstatusCliente().toString(); 
            }
            else {
            clave= maemav.getOidEstatusCliente().toString()+","+ clave;  
            }
            
         }
       } /* seteo de estados mavmae*/
       UtilidadesLog.debug("clave  "+clave);
       RecordSet  salida =consulta.obtenerPosiblesEstatusCliente(param,clave);
       UtilidadesLog.debug("salida " + salida);
       aux.add(salida);
       estmav.setEstadosMAE(aux);
       /* seteo de variables de mav */
       estmav.setActivo(estado.getActivo());
       estmav.setNoActivo(estado.getNoActivo());
       estmav.setOidEstadoMAV(estado.getOid());
       UtilidadesLog.info ("estado "+ estado);
       /* internacionalizacion */
       Entidadi18nLocalHome e18nLH = new Entidadi18nLocalHome();
       Entidadi18nLocal e18nL = e18nLH.findByEntAtrIdioPK( "MAV_ESTAD_MAV", new Long(1) ,dto.getOidIdioma(), estado.getOid());        
       Vector aux1 =new Vector();
       aux1.add(e18nL.getDetalle());
       aux1.add(e18nL.getOid().toString());
       estmav.setDescripcion(aux1);
        
     } catch (NoResultException ne) {
        UtilidadesLog.error(ne);
        ctx.setRollbackOnly();
        throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
      } 
      UtilidadesLog.info("MONMantenimientoEstadosMAVBean.consultarEstado(DTOOID dto):Salida");
      return estmav;
  }

	public DTOSalida buscarEstados(DTOEBuscarEstadosMAV dto) throws MareException {
    UtilidadesLog.info("MONMantenimientoEstadosMAVBean.buscarEstados(DTOEBuscarEstadosMAV dto):Entrada");
		DAOEstadoMAV est = new DAOEstadoMAV();
		try {
        UtilidadesLog.info("MONMantenimientoEstadosMAVBean.buscarEstados(DTOEBuscarEstadosMAV dto):Salida");
   		  return  est.buscarEstados(dto);			
    } catch(MareException ne) {
        UtilidadesLog.error(ne);
        throw ne;
		} catch (Exception ne) {
			  UtilidadesLog.error(ne);
				throw new MareException(ne, UtilidadesError.armarCodigoError(CodigosError.ERROR_DE_PETICION_DE_DATOS_NO_EXISTENTE));
		}
    
		
	}



	
	}




