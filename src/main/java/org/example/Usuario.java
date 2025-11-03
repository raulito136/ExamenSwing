package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Clase Usuario usando lombok
 * @author Raúl López Palomo
 */
@Data
@AllArgsConstructor
public class Usuario {
    String email,pais,plataforma;
}
