package es.indra.sicc.entidades.cob;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.cob.ArgumentoObligatorioVoluntarioLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class ArgumentoObligatorioVoluntarioLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-cob");
	private EntityManager em = emf.createEntityManager();

	public ArgumentoObligatorioVoluntarioLocal create(Character codigo) throws MareException {
		final EntityTransaction et = em.getTransaction();
                Long oid = SecuenciadorOID.obtenerSiguienteValor("COB_OBVO_SEQ");
		et.begin();
		ArgumentoObligatorioVoluntarioLocal local = new ArgumentoObligatorioVoluntarioLocal(oid, codigo);
		em.persist(local);
		et.commit();
		return local;
	}
	
	public void remove(ArgumentoObligatorioVoluntarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(ArgumentoObligatorioVoluntarioLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public ArgumentoObligatorioVoluntarioLocal findByPrimaryKey(Long  oid) {
		ArgumentoObligatorioVoluntarioLocal local = (ArgumentoObligatorioVoluntarioLocal)em.find(ArgumentoObligatorioVoluntarioLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

	
        public Collection findAll() {
            Query query=em.createNamedQuery("ArgumentoObligatorioVoluntarioLocal.FindAll");          
            return query.getResultList();
        }

}
