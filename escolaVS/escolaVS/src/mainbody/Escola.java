package mainbody;

import conDAO.*;
import java.util.Scanner;
import java.util.ArrayList;
import clearCon.*;



public class Escola {
    
    
    public static void main(String[] args) {

        String holder;
        
        AlunoDAO alunDAO = new AlunoDAO() ;
        ProfessorDAO profDAO = new ProfessorDAO();
        TurmaDAO turDAO = new TurmaDAO();

        ConsoleC clean = new ConsoleC();
        Scanner leia = new Scanner(System.in);
        ArrayList<Turma> turmas = new ArrayList<>();
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Professor> professors = new ArrayList<>();

        int option = 0;
        
        do {
            clean.clear();
       
            System.out.println("|Bem vindo ao menu!|\n 1: Gerenciar turmas\n 2: Gerenciar alunos\n 3: Gerenciar professores\n 4: Sair");
            option = leia.nextInt();

            switch (option) {

                case 1 -> {
                    
                    int optturma = 0;
                    do {
                        
                        clean.clear();
                        System.out.println(" 1: Para visualizar as turmas\n 2: Para criar uma turma\n 3: Para atualizar uma turma\n 4: Para deletar uma turma\n 5: Para voltar ao menu principal");
                        optturma= leia.nextInt();
                        turmas = turDAO.read();

                        switch (optturma) {

                            case 1 -> {

                                clean.clear();
                                System.out.printf("%s%-2s%s%-10s%s%n","|","id","|","Turmas","|");
                                

                                for ( int i = 0; i < turmas.size(); i++) {
                                    System.out.printf("%s%-2d%s%-10s%s%n","|",turmas.get(i).getIdturma(),"|",turmas.get(i).getNomeTurma(),"|");
                                }
                                System.out.println("Insira qualquer tecla para sair.");
                                holder = leia.next();
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
                                System.out.printf("%s%-2s%s%-10s%s%n","|","id","|","Turmas","|");
                                int idT;   
                                String nomeT;                      

                                for ( int i = 0; i < turmas.size(); i++) {
                                    System.out.printf("%s%-2d%s%-10s%s%n","|",turmas.get(i).getIdturma(),"|",turmas.get(i).getNomeTurma(),"|");
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
                                System.out.printf("%s%-2s%s%-10s%s%n","|","id","|","Turmas","|");
                                int idT;                         

                                for ( int i = 0; i < turmas.size(); i++) {
                                    System.out.printf("%s%-2d%s%-10s%s%n","|",turmas.get(i).getIdturma(),"|",turmas.get(i).getNomeTurma(),"|");
                                }
                                System.out.println("\n Selecione o id de uma turma para deletar:");
                                idT = leia.nextInt();
                                turDAO.delete(idT);
                                System.out.println("Turma deletada!");

                            }
                        }
                    }
                    while (optturma != 5);
                }
                
                case 2 -> {
                    
                    int optaluno = 0;
                    do {
                        
                        clean.clear();
                        System.out.println(" 1: Para visualizar os alunos\n 2: Para cadastrar um aluno\n 3: Para atualizar um aluno\n 4: Para deletar um aluno\n 5: Para voltar ao menu principal");
                        optaluno= leia.nextInt();
                        alunos = alunDAO.read();
                        turmas = turDAO.read();

                        switch (optaluno) {

                            case 1 -> {
                                
                                int optalunod;
                                clean.clear();

                                System.out.println(" 1: Para visualizar todos os alunos\n 2: Para visualizar os alunos de uma só turma.");
                                optalunod = leia.nextInt();

                                switch (optalunod) {
                                    
                                    case 1  -> {
                                        clean.clear();

                                        System.out.printf("%-3s%-15s%s%n","|id|","Alunos","|Notas|");

                                        for ( int i = 0; i < alunos.size(); i++) {
                                        System.out.printf("%s%-2d%s%-15s%s%-5.2f%s%n","|",alunos.get(i).getIdturma(),"|",alunos.get(i).getNome(),"|",alunos.get(i).getNotas(),"|");
                                        }
                                        System.out.print("insira qualquer tecla para porsseguir:");
                                        holder = leia.next();

                                    }
                                    case 2 -> {
                                        int idTur;

                                        clean.clear();

                                        System.out.println("Digite o id da turma que deseja:");            
                                        idTur = leia.nextInt();
                                        
                                        for ( int i = 0; i < turmas.size(); i++) {
                                            if (turmas.get(i).getIdturma() == idTur) {
                                                System.out.println("Turma: "+ turmas.get(i).getNomeTurma());
                                            }
                                        }

                                        System.out.printf("%-3s%-15s%s%n","|id|","Alunos","|Notas|");
                                        for ( int i = 0; i < alunos.size(); i++) {
                                            if (alunos.get(i).getIdturma() == idTur) {
                                                System.out.printf("%s%-2d%s%-15s%s%-5.2f%s%n","|",alunos.get(i).getIdturma(),"|",alunos.get(i).getNome(),"|",alunos.get(i).getNotas(),"|");
                                            }
                                        }
                                        System.out.print("insira qualquer tecla para porsseguir:");
                                        holder = leia.next();


                                    }


                                }
                                
                            }
                            case 2 -> {

                                clean.clear();
                                String nomeA;
                                int idadeA;
                                int idT;
                                double notaA;
                                System.out.println(" Digite o nome do aluno:");
                                nomeA = leia.next();
                                System.out.println(" Digite a idade do aluno:");
                                idadeA = leia.nextInt();
                                System.out.println(" Digite o id da turma do aluno:");
                                idT = leia.nextInt();
                                System.out.println(" Digite a nota do aluno:");
                                notaA = leia.nextDouble();

                                Aluno alun = new Aluno(idT,nomeA,idadeA,notaA);
                                alunDAO.create(alun);
                                System.out.println("Aluno cadastrado!");
                            }
                            case 3 -> {

                                clean.clear();
                                System.out.printf("%-3s%-15s%s%n","|id|","Alunos","|");                    
                                String nomeA;
                                int idadeA;
                                int idT;
                                double notaA;

                                for ( int i = 0; i < alunos.size(); i++) {
                                    System.out.printf("%s%-2d%s%s%n","|",alunos.get(i).getIdaluno(),"|",alunos.get(i).getNome());
                                }

                                
                                System.out.println(" Digite o nome do aluno:");
                                nomeA = leia.next();
                                System.out.println(" Digite a idade do aluno:");
                                idadeA = leia.nextInt();
                                System.out.println(" Digite o id da turma do aluno:");
                                idT = leia.nextInt();
                                System.out.println(" Digite a nota do aluno:");
                                notaA = leia.nextDouble();

                                Aluno alun = new Aluno(idT,nomeA,idadeA,notaA);
                                alunDAO.update(alun);
                                System.out.println("Aluno atualizado!");
                                
                            }
                            case 4 -> {

                                clean.clear();
                                System.out.println("|id|alunos|");
                                int idT;                         

                                for ( int i = 0; i < alunos.size(); i++) {
                                    System.out.printf("%s%-2d%s%s%n","|",alunos.get(i).getIdaluno(),"|",alunos.get(i).getNome());
                                }
                                System.out.println("\n Selecione o id do aluno para deletar:");
                                idT = leia.nextInt();
                                alunDAO.delete(idT);
                                System.out.println("Aluno deletado!");

                            }
                        }
                    }
                    while (optaluno != 5);
                }
                    
                case 3 -> {
                    int optprof = 0;
                    
                    do {

                        clean.clear();
                        System.out.println(" 1: Para visualizar os professores\n 2: Para cadastrar um professor\n 3: Para atualizar um professor\n 4: Para deletar um professor\n 5: Para voltar ao menu principal");
                        optprof= leia.nextInt();
                        alunos = alunDAO.read();
                        turmas = turDAO.read();
                        professors = profDAO.read();

                        switch (optprof) {

                            case 1 -> {
                                
                                int optprofd;
                                clean.clear();

                                System.out.println(" 1: Para visualizar todos os professores\n 2: Para visualizar o professor de uma turma.");
                                optprofd = leia.nextInt();

                                switch (optprofd) {
                                    
                                    case 1  -> {
                                        clean.clear();
                                        System.out.printf("%s%-15s%s%n","|id|","Professor","|salário|");

                                        for ( int i = 0; i < professors.size(); i++) {
                                        System.out.printf("%1s%-2s%1s%-15s%s%-7s%s%n","|", Integer.toString(professors.get(i).getIdturma()),"|", professors.get(i).getNome(), "|" , Double.toString(professors.get(i).getSalario()),"|");
                                        }
                                        System.out.print("insira qualquer tecla para porsseguir:");
                                        holder = leia.next();

                                    }
                                    case 2 -> {
                                        int idTur;

                                        clean.clear();

                                        System.out.println("Digite o id da turma que deseja:");            
                                        idTur = leia.nextInt();
                                        
                                        for ( int i = 0; i < turmas.size(); i++) {
                                            if (turmas.get(i).getIdturma() == idTur) {
                                                System.out.println("Turma: "+ turmas.get(i).getNomeTurma());
                                            }
                                        }
                                        System.out.println("|id| |professor| |salário|");
                                        for ( int i = 0; i < professors.size(); i++) {
                                            if (professors.get(i).getIdturma() == idTur) {
                                            System.out.printf("%1s%-2s%1s%-15s%s%-7s%s%n","|", Integer.toString(professors.get(i).getIdturma()),"|", professors.get(i).getNome(), "|" , Double.toString(professors.get(i).getSalario()),"|");
                                            }
                                        }
                                        System.out.print("insira qualquer tecla para porsseguir:");
                                        holder = leia.next();
                                    }
                                }
                            }
                            case 2 -> {

                                clean.clear();
                                String nomeP;
                                int idadeP;
                                int idT;
                                double salar;
                                System.out.println(" Digite o nome do professor");
                                nomeP = leia.next();
                                System.out.println(" Digite a idade do professor");
                                idadeP = leia.nextInt();
                                System.out.println(" Digite o id da turma do professor:");
                                idT = leia.nextInt();
                                System.out.println(" Digite o salário do professor:");
                                salar = leia.nextDouble();

                                Professor profs = new Professor(idT,nomeP,idadeP,salar);
                                profDAO.create(profs);
                                System.out.println("professor cadastrado!");
                            }
                            case 3 -> {

                                clean.clear();
                                
                                String nomeP;
                                int idadeP;
                                int idT;
                                double salar;
                                
                                System.out.println("|id|professores|");                     
                                
                                for ( int i = 0; i < professors.size(); i++) {
                                    System.out.printf("%s%-2d%s%n","|"+professors.get(i).getIdprofessor(), professors.get(i).getNome());
                                }
      
                                System.out.println(" Digite o nome do professor");
                                nomeP = leia.next();
                                System.out.println(" Digite a idade do professor");
                                idadeP = leia.nextInt();
                                System.out.println(" Digite o id da turma do professor:");
                                idT = leia.nextInt();
                                System.out.println(" Digite o salário do professor:");
                                salar = leia.nextDouble();

                                Professor profs = new Professor(idT,nomeP,idadeP,salar);
                                profDAO.update(profs);
                                System.out.println("Professor atualizado!");
                                
                            }
                            case 4 -> {

                                clean.clear();
                                System.out.println("|id|professores|");
                                int idT;                         

                                for ( int i = 0; i < professors.size(); i++) {
                                    System.out.printf("%s%-2d%s%-11s%s%n", "|"+professors.get(i).getIdprofessor(),"|", professors.get(i).getNome(),"|");
                                }

                                System.out.println("\n Selecione o id do professor para deletar:");
                                idT = leia.nextInt();
                                profDAO.delete(idT);
                                System.out.println("Professor deletado!");

                            }
                        }
                    }
                    while (optprof != 5);
                }default -> { 
                    break;
                }
            }
        } while ( option != 4 );
    }
}
