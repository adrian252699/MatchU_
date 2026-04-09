package itson.daos;


import itson.matchu_dominio.models.Hobby;
import itson.matchu_utilerias.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author Ricardo
 */
public class HobbyDAO {

    public Hobby guardar(Hobby hobby) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
            return hobby;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw new RuntimeException("Error al guardar hobby: " + e.getMessage(), e);
        } finally {
            em.close();
        }
    }

    public List<Hobby> listarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            return em.createQuery(
                "SELECT h FROM Hobby h ORDER BY h.categoria, h.nombre", Hobby.class
            ).getResultList();
        } finally {
            em.close();
        }
    }

    public Optional<Hobby> buscarPorNombre(String nombre) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            List<Hobby> result = em.createQuery(
                "SELECT h FROM Hobby h WHERE h.nombre = :nombre", Hobby.class
            ).setParameter("nombre", nombre).getResultList();
            return result.isEmpty() ? Optional.empty() : Optional.of(result.get(0));
        } finally {
            em.close();
        }
    }

    public void inicializarHobbiesPorDefecto() {
        if (!listarTodos().isEmpty()) return;
        String[][] datos = {
            {"Programación","Tecnología"},{"Videojuegos","Tecnología"},
            {"Diseño gráfico","Tecnología"},{"Robótica","Tecnología"},
            {"Fútbol","Deportes"},{"Basketball","Deportes"},
            {"Voleibol","Deportes"},{"Natación","Deportes"},
            {"Guitarra","Música"},{"Piano","Música"},{"Canto","Música"},{"DJ","Música"},
            {"Pintura","Arte"},{"Fotografía","Arte"},{"Escultura","Arte"},{"Dibujo","Arte"},
            {"Lectura","Cultural"},{"Cine","Cultural"},{"Teatro","Cultural"},
            {"Astronomía","Ciencia"},
            {"Cocina","Otros"},{"Yoga","Otros"},{"Senderismo","Otros"},{"Idiomas","Otros"},
        };
        for (String[] d : datos) guardar(new Hobby(d[0], d[1]));
    }
}