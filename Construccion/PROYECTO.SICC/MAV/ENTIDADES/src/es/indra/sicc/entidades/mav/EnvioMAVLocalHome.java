package es.indra.sicc.entidades.mav;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.mav.EnvioMAVLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

import java.sql.Timestamp;

public class EnvioMAVLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-mav");
	private EntityManager em = emf.createEntityManager();

	public EnvioMAVLocal create(Long numeroUnidades, Double precioEstandar, Double precio, Double precioContable, 
                                    Long oidDetalleMAV, Long oidMatrizFacturacion, Long oidCliente, Long oidActividad, 
                                    Long oidEstadoEnvio, Long oidFormaCobro, Long oidTipoDespacho, Character indicadorEnvio, 
                                    Timestamp fechaEntrega, Long oidPagoFraccionado, Long oidBuzonMensajes) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_MENV_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		EnvioMAVLocal local = new EnvioMAVLocal(oid, numeroUnidades, precioEstandar, precio, precioContable, 
                                 oidDetalleMAV, oidMatrizFacturacion, oidCliente, oidActividad, 
                                 oidEstadoEnvio, oidFormaCobro, oidTipoDespacho, indicadorEnvio, 
                                 fechaEntrega, oidPagoFraccionado, oidBuzonMensajes);
		em.persist(local);
		et.commit();
		return local;
	}

        public EnvioMAVLocal create(Long numeroUnidades, Double precioEstandar, Double precio, Double precioContable,
                                    Long oidDetalleMAV, Long oidMatrizFacturacion, Long oidCliente, Long oidActividad, 
                                    Long oidEstadoEnvio, Long oidFormaCobro, Long oidTipoDespacho, Character indicadorEnvio) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("MAV_MENV_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                EnvioMAVLocal local = new EnvioMAVLocal(oid, numeroUnidades, precioEstandar, precio, precioContable,
                                 oidDetalleMAV, oidMatrizFacturacion, oidCliente, oidActividad, 
                                 oidEstadoEnvio, oidFormaCobro, oidTipoDespacho, indicadorEnvio);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(EnvioMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(EnvioMAVLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public EnvioMAVLocal findByPrimaryKey(Long  oid) {
		EnvioMAVLocal local = (EnvioMAVLocal)em.find(EnvioMAVLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByClienteDetalle(Long oidCliente, Long oidDetalle) {
		Query query=em.createNamedQuery("EnvioMAVLocal.FindByClienteDetalle");
		
		query.setParameter(1, oidCliente);

		query.setParameter(2, oidDetalle);

		return query.getResultList();
	}

	public Collection findByClienteDetalleMatriz(Long oidCliente, Long oidDetalle, Long oidMatriz) {
		Query query=em.createNamedQuery("EnvioMAVLocal.FindByClienteDetalleMatriz");
		
		query.setParameter(1, oidCliente);

		query.setParameter(2, oidDetalle);

		query.setParameter(3, oidMatriz);

		return query.getResultList();
	}

}
