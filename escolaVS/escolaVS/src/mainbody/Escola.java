package mainbody;

import conDAO.*;
import java.util.Scanner;
import java.util.ArrayList;
import clearCon.*;

public class Escola {
    public static void main(String[] args) {
        
        AlunoDAO alunDAO = new AlunoDAO() ;
        ProfessorDAO profDAO = new ProfessorDAO();
        TurmaDAO turDAO = new TurmaDAO();

        ConsoleC clean = new ConsoleC();
        Scanner leia = new Scanner(System.in);
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();

        int option = 0;

        do {
       
            System.out.println("|Bem vindo ao menu!|\n 1: Gerenciar turmas\n 2: Gerenciar alunos\n 3: Gerenciar professores\n 5: Sair");
            option = leia.nextInt();

            switch (option) {

                case 1 -> {
                    int suboption = 0;
                    
                    do {
                        clean.clear();
                        System.out.println(" 1: Para visualizar as turmas\n 2: Para criar uma turma\n 3: Para atualizar uma turma\n 4: Para deletar uma turma\n 5: Para voltar ao menu principal");
                        suboption= leia.nextInt();
                        turmas = turDAO.read();
                        switch (suboption) {
                            case 1 -> {

                                clean.clear();
                                System.out.println("|id|turmas|");
                                

                                for ( int i = 0; i < turmas.size(); i++) {
                                    System.out.println(" "+turmas.get(i).getIdturma()+ "  " + turmas.get(i).getNomeTurma());
                                }
                                System.out.println("");
                            }
                            case 2 -> {

                                clean.clear();
                                String nomeT;
                                System.out.println(" Digite o nome da turma:");
                                nomeT = leia.next();

                                Turma tur = new Turma(nomeT);
                                turDAO.create(tur);
                            }
                            case 3 -> {

                                clean.clear();
                                System.out.println("|id|turmas|");
                                int idT;   
                                String nomeT;                      

                                for ( int i = 0; i < turmas.size(); i++) {
                                    System.out.println(" "+turmas.get(i).getIdturma()+ "  " + turmas.get(i).getNomeTurma());
                                }

                                System.out.println("Escolha a turma que deseja atualizar(id):");
                                idT = leia.nextInt();
                                System.out.println("Escolha o nome que deseja atualizar(id):");
                                nomeT = leia.nextLine();
                                Turma turTemp = new Turma(idT,nomeT);
                                turDAO.update(turTemp);
                                System.out.println("Turma atualizada!");
                                
                            }
                            case 4 -> {

                                clean.clear();
                                System.out.println("|id|turmas|");
                                int idT;                         

                                for ( int i = 0; i < turmas.size(); i++) {
                                    System.out.println(" "+turmas.get(i).getIdturma()+ "  " + turmas.get(i).getNomeTurma());
                                }
                                System.out.println("\n Selecione o id de uma turma para deletar:");
                                idT = leia.nextInt();
                                turDAO.delete(idT);
                                System.out.println("Turma deletada!");

                            }
                        }
                    }
                    while (suboption != 5);
                }
                
                case 2 -> {

                }
                case 3 -> {

                }


            }
            default -> { 
                break;
            }

        } while ( option != 4 );
    }
}
