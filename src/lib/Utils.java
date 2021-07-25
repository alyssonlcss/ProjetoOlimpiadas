public class Utils {
     
    public static void menuPrincipal() {
        System.out.println("[1] Gerenciar Comitê...........");
        System.out.println("[2] Gerenciar Equipe...........");
        System.out.println("[3] Gerenciar Atleta...........");
        System.out.println("[4] Gerenciar Comissão Técnica.");
        System.out.println("[0] SAIR.......................");
    }
    
    
    public static void menu(String nome) {
        System.out.println("[1] Adicionar " + nome + ".");
        System.out.println("[2] Remover "   + nome + ".");
        System.out.println("[3] Alterar "   + nome + ".");
        System.out.println("[4] Listar "    + nome + ".");
        System.out.println("[5] Buscar "    + nome + ".");
        System.out.println("[0] SAIR.                  ");
    }
    
    
}
