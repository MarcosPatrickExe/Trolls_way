package main;
import java.lang.System;
import java.util.Scanner;
import java.lang.Thread;
import java.io.IOException;
import java.lang.Runtime;
import states.StateDead;
import states.StateFighting;
import states.StateSleep;



public class main {
    public static void main( String[] args) {
        
        boolean gameOn = true;
        short cycle = 0;
        Troll troll = new Troll( new StateSleep() );
        final String separator = "======================\n";
        final int threadTime = 2200;
        Scanner scan = new Scanner(System.in);


        while(gameOn){
            try{
                ++troll.hunger;
                ++cycle;


                troll.update();
                Thread.sleep(threadTime);


                if(troll.life <= 0 || troll.hunger >= 10 ){
                    troll.changeState( new StateDead() );
                    troll.update();
                    break;// encerra execucao do 'while'
                }

                
                System.out.println( "\n======== ESTADO DO TROLL: ========= \n"+
                                    "Vida:  "+troll.life+"\n"+
                                    "Fome:  "+troll.hunger+"\n"+
                                    "Ciclo atual: "+cycle+"\n"
                                    + separator
                );
                Thread.sleep(threadTime);

            
                System.out.println("\n=================== Escolha uma das opces: ====================\n"+
                                "1- Permanecer no estado atual (ir direto para o proximo turno) \n"+
                                "2- Aproximar inimigo (inicar batalha) \n"+
                                "3- Encerrar jogo... \n");

                String option = scan.next();

            
                switch(option){
                    case "1":
                        Thread.sleep(threadTime);
                        break;
                    case "2":
                        troll.changeState( new StateFighting() );
                        System.out.print("\033[H\033[2J"); // clearing the console
                        System.out.flush(); // clearing the console
                        System.out.println( "\n============ BATALHA INICIADA! =============\n");
                        Thread.sleep(threadTime);
                        break;
                    case "3":
                        gameOn = false;
                        break;
                    default:
                        System.out.println( "\n ENTRADA DESCONHECIDA! Selecione uma opcao correta! \n");
                        Thread.sleep(threadTime);
                }

            }catch( InterruptedException ioe){ // catch a Thread and Runtime exceptions
                System.out.println( "\n Houve um erro durante a execucao da Thread..... \n");
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





// TRANSFORMAR ARQUIVO .class EM JAR
// jar cfe <jar-name>.jar  ./path/to_main  ./path/to/<file-with-main-method>.class
// jar -cvfm my.jar com/test/myclass/manifest.txt com/test/myclass/MyClass.class
// jar cfe test.jar out.main.main ./out/main/main.class


// jar cfe test.jar ./out/main/main.class ./out/main/main.class
// java -jar test.jar




// EXECUTAR O JAR:
// java -jar <jar-name>.jar


















// exemplo de execucao de arquivo java:
/* 
Source file HelloWorld2/src/com/example/HelloWorld2.java

Compiled class file: HelloWorld2/bin/com/example/HelloWorld2.class

$ java -cp HelloWorld2/bin com.example.HelloWorld2
 
*/
