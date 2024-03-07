/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package LowLevelDesign.DesignVendingMachine;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

/**
 *
 * @author johan
 */
public interface AuthenticationMethod {
    void authenticate() throws NotImplementedException, UserBlockedException;
    
}
