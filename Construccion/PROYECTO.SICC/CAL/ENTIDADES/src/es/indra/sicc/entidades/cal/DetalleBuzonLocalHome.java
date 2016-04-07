package es.indra.sicc.entidades.cal;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cal.DetalleBuzonLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;
import java.sql.Timestamp;

public class DetalleBuzonLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cal");
	private EntityManager em = emf.createEntityManager();

	public DetalleBuzonLocal create(Long cod_acti, String val_desc_acti, Timestamp fec_hora_crea, String cod_usua, Long cabu_oid, Long cont_oid, Long oid_estatus_actividad_contacto) throws MareException {
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("CAL_DEBU_SEQ");
                final EntityTransaction et = em.getTransaction();
		et.begin();
		DetalleBuzonLocal local = new DetalleBuzonLocal(oid, cod_acti, val_desc_acti, fec_hora_crea, cod_usua, cabu_oid, cont_oid, oid_estatus_actividad_contacto);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DetalleBuzonLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DetalleBuzonLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DetalleBuzonLocal findByPrimaryKey(Long  oid) {
		DetalleBuzonLocal local = (DetalleBuzonLocal)em.find(DetalleBuzonLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
    public Collection findAll() {
        Query query=em.createNamedQuery("DetalleBuzonLocal.FindAll");
        return query.getResultList();
    }

	
}
