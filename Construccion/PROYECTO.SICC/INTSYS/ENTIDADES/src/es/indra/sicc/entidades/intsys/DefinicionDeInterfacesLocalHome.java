package es.indra.sicc.entidades.intsys;

import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.intsys.DefinicionDeInterfacesLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class DefinicionDeInterfacesLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-intsys");
	private EntityManager em = emf.createEntityManager();

	public DefinicionDeInterfacesLocal create(String codigo, String sistema, String modo, String tipoInterfaz) throws MareException {
		final EntityTransaction et = em.getTransaction();
		et.begin();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INT_DFIN_SEQ");
                DefinicionDeInterfacesLocal local = new DefinicionDeInterfacesLocal(oid, codigo, sistema, modo, tipoInterfaz);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(DefinicionDeInterfacesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(DefinicionDeInterfacesLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public DefinicionDeInterfacesLocal findByPrimaryKey(Long  oid) {
		DefinicionDeInterfacesLocal local = em.find(DefinicionDeInterfacesLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
	public Collection findAll() {
		Query query=em.createNamedQuery("DefinicionDeInterfacesLocal.FindAll");
		return query.getResultList();
	}

}
