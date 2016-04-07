package es.indra.sicc.entidades.car;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.car.SolicitudesEntregaBloqueadasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Date;
import java.math.BigDecimal;

public class SolicitudesEntregaBloqueadasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-car");
	private EntityManager em = emf.createEntityManager();

	public SolicitudesEntregaBloqueadasLocal create(Long oidPais, Long oidSubAcceso, Long oidTipoSolicitud, Long oidSolicitud, Date fechaSolicitud, Integer indNotificacion, BigDecimal montoSolicitud, BigDecimal montoDeudaVencida, Integer indDeudaVencida, Integer indLineaCredito, Integer indMontoMaximo, Integer indPorcentajeMaximo, Long oidJerarquia, Long estatus, Long oidPeriodo, Long oidCliente, Long oidNivelRiesgo, Long oidGrupoSolicitud, Long oidZona) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAR_SEBL_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		SolicitudesEntregaBloqueadasLocal local = new SolicitudesEntregaBloqueadasLocal(oid, oidPais, oidSubAcceso, oidTipoSolicitud, oidSolicitud, fechaSolicitud, indNotificacion, montoSolicitud, montoDeudaVencida, indDeudaVencida, indLineaCredito, indMontoMaximo, indPorcentajeMaximo, oidJerarquia, estatus, oidPeriodo, oidCliente, oidNivelRiesgo, oidGrupoSolicitud, oidZona);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(SolicitudesEntregaBloqueadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(SolicitudesEntregaBloqueadasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public SolicitudesEntregaBloqueadasLocal findByPrimaryKey(Long  oid) {
		SolicitudesEntregaBloqueadasLocal local = (SolicitudesEntregaBloqueadasLocal)em.find(SolicitudesEntregaBloqueadasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public SolicitudesEntregaBloqueadasLocal findBySolicitud(Long oidSolicitud) {
                Query query=em.createNamedQuery("SolicitudesEntregaBloqueadasLocal.FindBySolicitud");
                
                query.setParameter(1, oidSolicitud);
    
                return (SolicitudesEntregaBloqueadasLocal)(query.getSingleResult());
        }
        
        public Collection findAll() {
            Query query=em.createNamedQuery("SolicitudesEntregaBloqueadasLocal.FindAll");          
            return query.getResultList();
        }

	
}
