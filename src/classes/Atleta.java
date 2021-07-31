package classes;

import java.util.ArrayList;

import interfaces.OperacoesComuns;
import lib.Utils;
import java.util.Random;

public class Atleta extends CredenciadoOlimpico implements OperacoesComuns {

    private String sexo;
    private ArrayList<Integer> medalhas = new ArrayList<>();


    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public ArrayList<Integer> getMedalhas() {
        return medalhas;
    }

    public void setMedalhas(ArrayList<Integer> medalhas) {
        this.medalhas = medalhas;
    }

    @Override
    public void adicionar() {
        String temporario;
        
        System.out.print("Digite o nome do Atleta: ");
        super.setNome(Utils.entrada.nextLine());
        System.out.print("Digite o sexo do Atleta: ");
        this.setSexo(Utils.entrada.nextLine());
        super.setId(new Random().nextInt(30000));
        
        while (true) {
            System.out.print("\nDeseja adicionar Medalhas agora? [s/n]: ");
            temporario = Utils.entrada.nextLine();

            if (temporario.equalsIgnoreCase("s")) {
                this.adicionarMedalhasDoAtleta();
                break;
            } else if (temporario.equalsIgnoreCase("n")) {
                break;
            } else {
				System.out.println("Você digitou uma opção inválida! Digite novamente.");
            }
        }
    }

    @Override
    public void listarDados() {
        System.out.println("Atleta { \nnome=" + this.getNome() + ", " + "\nsexo=" + this.getSexo() + "\n");

        System.out.println("\tMedalhas { \n\tOuro=" + this.getMedalhas().get(0) + ", " + "\n\tPrata="
            + this.getMedalhas().get(1) + ", " + "\n\tBronze" + this.getMedalhas().get(2) + "\n");
    }

    public void alterarAtleta() {

        System.out.print("Deseja alterar o nome do atleta? [s/n] ");
        String sinal = Utils.entrada.nextLine().toLowerCase();
        try {
            if (sinal.equals("s")) {
                System.out.print("Digite um novo nome: ");
                super.setNome(Utils.entrada.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Entrada válida apenas para texto!");
        }

        System.out.print("Deseja alterar o sexo do atleta? [s/n]: ");
        sinal = Utils.entrada.nextLine().toLowerCase();
        try {
            if (sinal.equals("s")) {
                System.out.print("Digite o sexo: ");
                this.setSexo(Utils.entrada.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Entrada válida apenas para texto!");
        }

        System.out.print("Deseja mudar a quantidade de medalhas? [s/n]: ");
        sinal = Utils.entrada.nextLine().toLowerCase();
        try {
            if (sinal.equals("s")) {
                this.adicionarMedalhasDoAtleta();
            } 
        } catch (Exception e) {
            System.out.println("Entrada válida apenas para texto!");
        }
    }

    public static Atleta buscar(String nome) {

        for (ComiteOlimpico comite : ComiteOlimpico.getLista_comites()) {
            for (Equipe equipe : comite.getEquipe()) {
                for (Atleta atleta : equipe.getAtletas()) {
                    if (atleta.getNome().equalsIgnoreCase(nome)) {
                        return atleta;
                    }
                }
            }
        }
        return null;
    }

    public void adicionarMedalhasDoAtleta() {
        boolean sinaliza = true;
        while (sinaliza) {
            try {
                System.out.print("Digite a quantidade da medalha de Ouro: ");
                this.medalhas.add(Integer.parseInt(Utils.entrada.nextLine()));
                sinaliza = false;
            } catch(NumberFormatException e) {
                System.out.println("Digite apenas números inteiros positivos!");
                sinaliza = true;
            } 
        }

        sinaliza = true;
        while (sinaliza) {
            try {
                System.out.print("Digite a quantidade da medalha de Prata: ");
                this.medalhas.add(Integer.parseInt(Utils.entrada.nextLine()));
                sinaliza = false;
            } catch(NumberFormatException e) {
                System.out.println("Digite apenas números inteiros positivos!");
                sinaliza = true;
            }
        }
        sinaliza = true;
        while (sinaliza) {
             try {
                System.out.print("Digite a quantidade da medalha de Bronze: ");
                this.medalhas.add(Integer.parseInt(Utils.entrada.nextLine()));
                sinaliza = false;
            } catch (NumberFormatException e) {
                System.out.println("Digite apenas números inteiros positivos!");
                sinaliza = true;
            }
        }
    }
}