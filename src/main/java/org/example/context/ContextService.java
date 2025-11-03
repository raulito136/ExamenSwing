package org.example.context;

import java.util.HashMap;
import java.util.Optional;

/**
 * Clase que contiene un Singletone para poner mandar y recibir datos entre distintas pantallas
 * @author Raúl López Palomo
 */
public class ContextService {

    private static ContextService instance;
    private static HashMap<String, Object> data = new HashMap<>();

    // Constructor privado --> no se puede instanciar desde fuera
    private ContextService() {}


    public static ContextService getInstance(){
        if(instance == null){
            // Con el primer acceso, se crea el servicio.
            instance = new ContextService();
        }
        return instance;
    }

    public void addItem(String key, Object o){
        data.put(key, o);
    }

    public Optional<Object> getItem(String key){
        return Optional.ofNullable(data.get(key));
    }

}
