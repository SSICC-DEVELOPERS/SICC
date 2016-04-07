package es.indra.sicc.entidades.men;

import javax.persistence.PersistenceContext;
import javax.persistence.Persistence;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.Collection;

import es.indra.sicc.entidades.men.FavoritosLocal;
import es.indra.sicc.util.SecuenciadorOID;
import es.indra.mare.common.exception.MareException;

public class FavoritosLocalHome {

	//@PersistenceContext private EntityManager em; 
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("entidades-men");
	private EntityManager em = emf.createEntityManager();

        public FavoritosLocal create(Long func_oid_func, String val_usua) throws MareException{
                Long oid = SecuenciadorOID.obtenerSiguienteValor("GEN_I18N_SEQ");
                final EntityTransaction et = em.getTransaction();
                et.begin();
                FavoritosLocal local = new FavoritosLocal(oid, func_oid_func, val_usua);
                em.persist(local);
                et.commit();
                return local;
        }
	
	public void remove(FavoritosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.remove(local);
		et.commit();
	}
	
	public void merge(FavoritosLocal local) {
		final EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(local);
		et.commit();
	}
	
	public FavoritosLocal findByPrimaryKey(Long  oid) {
		FavoritosLocal local = (FavoritosLocal)em.find(FavoritosLocal.class, oid);
		if (local==null) throw new NoResultException();
		return local;
	}

        public Collection findByUsuario(String codigo) {
                Query query=em.createNamedQuery("FavoritosLocal.FindByUsuario");
                query.setParameter(1, codigo);
                return query.getResultList();
        }
    
        public Collection findAll() {
                Query query=em.createNamedQuery("FavoritosLocal.FindAll");
                return query.getResultList();
        }

	
}
