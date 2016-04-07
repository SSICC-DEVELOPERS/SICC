package es.indra.sicc.entidades.pre;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.pre.TextosOfertasLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class TextosOfertasLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-pre");
	private EntityManager em = emf.createEntityManager();

	public TextosOfertasLocal create(Integer num_orde, Long mfca_oid_cabe, String val_text, Long oidCatalogo) throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("PRE_TXTO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		TextosOfertasLocal local = new TextosOfertasLocal(oid, num_orde, mfca_oid_cabe, val_text, oidCatalogo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(TextosOfertasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(TextosOfertasLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public TextosOfertasLocal findByPrimaryKey(Long  oid) {
		TextosOfertasLocal local = (TextosOfertasLocal)em.find(TextosOfertasLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findByNumeroOrdenYCabe(Integer numeroOrden,Long oidCabe) {
		Query query=em.createNamedQuery("TextosOfertasLocal.FindByNumeroOrdenYCabe");
		
		query.setParameter(1, numeroOrden);

		query.setParameter(2, oidCabe);

		return query.getResultList();
	}

}
