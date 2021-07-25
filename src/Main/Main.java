package Main;

import java.util.ArrayList;
import java.util.Scanner;

import lib.Utils;
import Classes.Atleta;
import Classes.ComiteOlimpico;
import Classes.Equipe;

public class Main {
       
    public static void main(String[] args) {
        
        Scanner entrada = new Scanner(System.in);
        ArrayList<ComiteOlimpico> comites = new ArrayList<>();
        
        while (true) {
            Utils.menuPrincipal();
            
            System.out.println("Entre com um opção: ");
            int opcao = entrada.nextInt(); entrada.nextLine();
            
            if (opcao == 0) break;
            
            switch (opcao) {
            case 1:
                
                do {
                    Utils.menu("Comitê");
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1:
                        ComiteOlimpico comite = new ComiteOlimpico();
                        comite.adicionarComite();
                        comites.add(comite);				
                        break;
                    case 2:
                        comite.remover("d");
                        //
                        break;
                    case 3:
                        break;
                    case 4:
                        comite.listar();
                        break;
                    case 5:
                        //
                        break;
                    default:
                        //
                    }
                    
                } while (opcao != 0);
                
                
                break;
            case 2:
                do {
                    Utils.menu("Equipe");
                    
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1:
                        for (ComiteOlimpico a: comites) {
                        }
                        break;
                    case 2:
                        Equipe.remover(entrada);
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        Equipe.listar();						
                        break;
                    case 5:
                        //
                        break;
                    default:
                        
                    }
                    
                } while (opcao != 0);
                break;
            case 3:
                do {
                    menu("Atleta");
                    
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1:
                        Atleta.adicionar(entrada);
                        break;
                    case 2:
                        //
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        //						
                        break;
                    case 5:
                        //
                        break;
                    default:
                        
                    }
                    
                } while (opcao != 0);
                break;
            case 4:
                do {
                    menu("Comissão Técnica");
                    
                    System.out.println("Entre com um opção: ");
                    opcao = entrada.nextInt(); entrada.nextLine();
                    
                    switch(opcao) {
                    case 1:
                        //
                        break;
                    case 2:
                        //
                        break;
                    case 3:
                        //
                        break;
                    case 4:
                        //						
                        break;
                    case 5:
                        //
                        break;
                    default:
                        
                    }
                    
                } while (opcao != 0);
                break;
            }
        }
        entrada.close();
    }
}
    