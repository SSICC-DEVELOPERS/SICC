package es.indra.sicc.entidades.msg;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.msg.MensajesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class MensajesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-msg");
	private EntityManager em = emf.createEntityManager();

	public MensajesLocal create(String cod_mens, Long pais_oid_pais, String desc_mens, String text, Long periodoDesde, Long periodoHasta, Long modu, Long tipo_msg, Long oid_tipo_perm)throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
	        Long oid = SecuenciadorOID.obtenerSiguienteValor("MSG_MENS_SEQ");
		MensajesLocal local = new MensajesLocal(oid, cod_mens, pais_oid_pais, desc_mens, text, periodoDesde, periodoHasta, modu, tipo_msg, oid_tipo_perm);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(MensajesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(MensajesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public MensajesLocal findByPrimaryKey(Long  oid) {
		MensajesLocal local = (MensajesLocal)em.find(MensajesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}
        
        public MensajesLocal findByUk(Long param1, String param2) {
            Query query=em.createNamedQuery("MensajesLocal.FindByUk");
            
            query.setParameter(1, param1);
            query.setParameter(2, param2);
            
            return (MensajesLocal)(query.getSingleResult());
        }

	
}
