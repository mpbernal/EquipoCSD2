package LowLevelDesign.DesignVendingMachine;

import LowLevelDesign.DesignVendingMachine.VendingStates.State;
import java.util.Scanner;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;


public class Main {

    public static void main(String args[]){

        VendingMachine vendingMachine = new VendingMachine();
        int selectedOption = 0;
        while(selectedOption!=1){
        try {

             System.out.println("|");
             System.out.println("filling up the inventory");
             System.out.println("|");

             fillUpInventory(vendingMachine);
             displayInventory(vendingMachine);
             System.out.println("|");
             System.out.println("authenticating user");
             System.out.println("|");
             
           AuthenticationMethod authenticationMethod = null;
           
           
        
                selectedOption = selectAuthenticationOption();
        switch (selectedOption) {
            case 1 -> authenticationMethod = new UsernamePasswordAuthentication();
            case 2 -> authenticationMethod = new PinAuthentication();
            case 3 -> authenticationMethod = new SocialMediaAuthentication();
            default -> throw new IllegalArgumentException("Opción de autenticación inválida.");
        }
         
        authenticationMethod.authenticate();
            

             System.out.println("|");
             System.out.println("clicking on InsertCoinButton");
             System.out.println("|");

             State vendingState = vendingMachine.getVendingMachineState();
             vendingState.clickOnInsertCoinButton(vendingMachine);

             vendingState = vendingMachine.getVendingMachineState();
             vendingState.insertCoin(vendingMachine, Coin.NICKEL);
             vendingState.insertCoin(vendingMachine, Coin.QUARTER);
            // vendingState.insertCoin(vendingMachine, Coin.NICKEL);

             System.out.println("|");
             System.out.println("clicking on ProductSelectionButton");
             System.out.println("|");
             vendingState.clickOnStartProductSelectionButton(vendingMachine);

             vendingState = vendingMachine.getVendingMachineState();
             vendingState.chooseProduct(vendingMachine, 102);

             displayInventory(vendingMachine);

         } catch (NotImplementedException e) {
             System.out.println("Auntenticacion no implementada.");
             displayInventory(vendingMachine);
         } catch (UserBlockedException e) {
             System.out.println("Usuario bloqueado, contacte a su administraddor.");
             displayInventory(vendingMachine);
         } catch (Exception e){
             displayInventory(vendingMachine);
         }
        }
         
         
    }

    private static void fillUpInventory(VendingMachine vendingMachine){
        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {
            Item newItem = new Item();
            if(i >=0 && i<3) {
                newItem.setType(ItemType.COKE);
                newItem.setPrice(12);
            }else if(i >=3 && i<5){
                newItem.setType(ItemType.PEPSI);
                newItem.setPrice(9);
            }else if(i >=5 && i<7){
                newItem.setType(ItemType.JUICE);
                newItem.setPrice(13);
            }else if(i >=7 && i<10){
                newItem.setType(ItemType.SODA);
                newItem.setPrice(7);
            }
            slots[i].setItem(newItem);
            slots[i].setSoldOut(false);
        }
    }

    private static void displayInventory(VendingMachine vendingMachine){

        ItemShelf[] slots = vendingMachine.getInventory().getInventory();
        for (int i = 0; i < slots.length; i++) {

            System.out.println("CodeNumber: " + slots[i].getCode() +
                    " Item: " + slots[i].getItem().getType().name() +
                    " Price: " + slots[i].getItem().getPrice() +
                    " isAvailable: " + !slots[i].isSoldOut());
        }
    }
    private static int selectAuthenticationOption() {
    System.out.println("Seleccione el método de autenticación:");
    System.out.println("1. Usuario y contraseña");
    System.out.println("2. PIN");
    System.out.println("3. Redes sociales");
    Scanner scanner = new Scanner(System.in);
    int selectedOption = scanner.nextInt();
    scanner.nextLine();
    return selectedOption;
}
    
}
