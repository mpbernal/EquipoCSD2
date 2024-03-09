/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LowLevelDesign.DesignVendingMachine;

/**
 *
 * @author johan
 */
class UserBlockedException extends Exception {

    public UserBlockedException() {
        super("has superado el numero de intentos, has bloqueado la cuenta, porfavor comunicate con el administrador");
    }
    
}
