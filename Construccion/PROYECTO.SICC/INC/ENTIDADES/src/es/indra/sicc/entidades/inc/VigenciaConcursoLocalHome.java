package es.indra.sicc.entidades.inc;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.inc.VigenciaConcursoLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class VigenciaConcursoLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-inc");
	private EntityManager em = emf.createEntityManager();

	public VigenciaConcursoLocal create() throws MareException {
                Long oid = SecuenciadorOID.obtenerSiguienteValor("INC_VICO_SEQ");
		final EntityTransaction et = em.getTransaction();
		et.begin();
		VigenciaConcursoLocal local = new VigenciaConcursoLocal(oid);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(VigenciaConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(VigenciaConcursoLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public VigenciaConcursoLocal findByPrimaryKey(Long  oidVigenciaConcurso) {
		VigenciaConcursoLocal local = (VigenciaConcursoLocal)em.find(VigenciaConcursoLocal.class, oidVigenciaConcurso);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
                    Query query = em.createNamedQuery("VigenciaConcursoLocal.FindAll");
                    return query.getResultList();
            }

}
