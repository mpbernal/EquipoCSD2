/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LowLevelDesign.DesignVendingMachine;

import java.util.Scanner;

/**
 *
 * @author johan
 */
public class UsernamePasswordAuthentication implements AuthenticationMethod {
    private static final int maximoIntentos = 3;

    @Override
    public void authenticate() throws UserBlockedException {
        Scanner scanner = new Scanner(System.in);
        int intentos = 0;
        while (intentos < maximoIntentos) {
            System.out.print("Ingrese su usuario: ");
            String username = scanner.nextLine();
            System.out.print("Ingrese su contraseña: ");
            String password = scanner.nextLine();
            if("admin".equals(username) && "Cetre13$".equals(password) ){
                return;
            }else{
                intentos++;
                System.out.println("\n usuario o contraseña incorrectos."
                        + "\n valida la informacion y vuelve a intentar cuando estes seguro"
                        + "\n tiene "+intentos+" intento(s) fallido(s)");
                
            }
           
        }
        // Si se excede el número máximo de intentos, lanzar una excepción:
        throw new UserBlockedException();
    }
}

