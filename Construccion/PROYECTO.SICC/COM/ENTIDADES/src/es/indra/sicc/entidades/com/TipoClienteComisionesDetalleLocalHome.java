package es.indra.sicc.entidades.com;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.com.TipoClienteComisionesDetalleLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TipoClienteComisionesDetalleLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-com");
	private EntityManager em = emf.createEntityManager();

	public TipoClienteComisionesDetalleLocal create(Long tcccOidTipoClieComiCabe, Long ticlOidTipoClie) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COM_TCCD_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TipoClienteComisionesDetalleLocal local = new TipoClienteComisionesDetalleLocal(oid, tcccOidTipoClieComiCabe, ticlOidTipoClie);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TipoClienteComisionesDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TipoClienteComisionesDetalleLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TipoClienteComisionesDetalleLocal findByPrimaryKey(Long  oid) {
		TipoClienteComisionesDetalleLocal local = (TipoClienteComisionesDetalleLocal)em.find(TipoClienteComisionesDetalleLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                Query query=em.createNamedQuery("TipoClienteComisionesDetalleLocal.FindAll");          
                return query.getResultList();
        }

	public Collection findByCabecera(Long oidCabecera) {
		Query query=em.createNamedQuery("TipoClienteComisionesDetalleLocal.FindByCabecera");
		
		query.setParameter(1, oidCabecera);

                return query.getResultList();
	}

}
