/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ConexionBD.ConexionBD;
import Modelo.Paciente;

/**
 *
 * @author Abraham
 */
public class PacienteDAO {
    private String sql;
    ConexionBD c = ConexionBD.getConexionBD();

    public PacienteDAO() {
        
    }
    
    public boolean agregarPaciente(Paciente){
        
        return c.ejecutarInstruccion(sql);
    }
}
