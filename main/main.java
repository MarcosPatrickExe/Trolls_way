package main;
import java.lang.System;
import java.util.Scanner;
import java.lang.Thread;

import states.StateDead;
import states.StateEating;
import states.StateSleep;


enum Locations { Forest, Cave }


public class main {
    public static void main( String[] args) {
        
        boolean gameOn = true;
        short cycle = 0;
        Troll troll = new Troll( new StateSleep() );
        final String separator = "==============================================\n";
        Scanner scan = new Scanner(System.in);


        while(gameOn){
            //System.out.println( "Atualmente o Troll se encontra "+troll.currentState.nameState+"");
            ++troll.hunger;
            ++cycle;

            
            if(troll.life == 0 || troll.hunger==10 ){
                String frase = (troll.life == 0) ? "\n ====> O TROLL MORREU! (Pontos de vida iguais a ZERO) \n" : "\n ====> O TROLL MORREU! (Pontos de fome iguais a 10) \n";
                System.out.println(frase);
                troll.changeState( new StateDead() );
                break;
            }


            if(troll.currentLocation == Locations.Forest){
                troll.hunger -=3;
                --troll.life;
                
                if(troll.hunger <= 4){
                    troll.changeState( new StateSleep() );
                    troll.currentLocation = Locations.Cave;
                }

            }else if(troll.currentLocation == Locations.Cave){
                if(troll.life <10)
                    ++troll.life;

                if(troll.hunger > 4){
                    troll.currentLocation = Locations.Forest;
                    troll.changeState( new StateEating() );
                }
            }


        
            System.out.println( "\n \n============ ESTADO DO TROLL: =========== \n"+
                                "Vida:  "+troll.life+"\n"+
                                "Fome:  "+troll.hunger+"\n"+
                                "Ciclo atual: "+cycle+"\n"
                                 + separator
            );

            troll.update();
          
            System.out.println("\n=====> Escolha uma das opces: \n"+
                               "1- Permanecer no estado atual (ir direto para o proximo turno) \n"+
                               "2- Aproximar inimigo (inicar batalha) \n"+
                               "3- Encerrar jogo... \n");

            String option = scan.next();

          
            switch(option){
                case "1":
                    break;
                case "2":
                    troll.changeState( new StateEating() );
                    break;
                case "3":
                    gameOn = false;
                    break;
                default:
                    System.out.println( "\n ENTRADA DESCONHECIDA! Selecione uma opcao correta! \n");
                    try{
                        Thread.sleep(1000);
                    }catch(Exception ex){
                        System.out.println("Houve um erro de thread !!");
                    }
            }
          
        }//while

        System.exit(0);
    }//void main()
}//main {}




// COMANDO PARA COMPILAR TODOS OS ARQUVOS .java DE TODAS AS PASTAS DA APLICACAO:
// javac -d ./out/ ./main/*.java  ./states/*.java 

// COMANDO PARA EXECUTAR A APLICACAO  (NO CASO O ARQUIVO .class QUE EH PRINCIAL):
// java -cp out main.main


// java -classpath <directory> <package-name>.<main-file-.class>

















// exemplo de execucao de arquivo java:
/* 
Source file HelloWorld2/src/com/example/HelloWorld2.java

Compiled class file: HelloWorld2/bin/com/example/HelloWorld2.class

$ java -cp HelloWorld2/bin com.example.HelloWorld2
 
*/