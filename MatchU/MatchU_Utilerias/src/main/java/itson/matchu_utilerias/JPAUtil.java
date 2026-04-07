/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package itson.matchu_utilerias;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 *
 * @author jalt2
 */
public class JPAUtil {
    private static final String PERSISTENCE_UNIT = "MatchUPU";
    private static EntityManagerFactory emf;

    // Clase de utilidad – no instanciar
    private JPAUtil() {}

    /**
     * Retorna el EntityManagerFactory, creándolo si no existe.
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
        }
        return emf;
    }

    /**
     * Crea y retorna un nuevo EntityManager.
     */
    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }

    /**
     * Cierra el EntityManagerFactory al terminar la aplicación.
     */
    public static void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}
