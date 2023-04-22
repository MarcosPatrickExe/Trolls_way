package states;
import java.util.Random;
import java.lang.Thread;
import main.Agent;
import main.Troll;



public class StateFighting extends State{


    @Override
    public void execute(Agent agent){

        try{
            Random ran = new Random();
            Troll troll = (Troll) agent; // Downcasting
            final int threadTime = 2200;
            final int trollAttackDamage = ran.nextInt(3)+2; // 2-4 dano
            final int enemyAttackDamage = ran.nextInt(2)+1; // 1-2 de dano
            int enemyLife = ran.nextInt(4)+1; // 1-4 de life
        

            System.out.println( "\n======> Troll is fighting with a enemy - INITIAL STATUS: \n");
            Thread.sleep(threadTime);
            System.out.println("Troll [ life: "+troll.life+" // damage attack: "+trollAttackDamage+" ]\n");
            System.out.println("Enemy [ life: "+enemyLife+" // damage attack: "+enemyAttackDamage+" ]\n");
            Thread.sleep(threadTime);


            while(true){
                Thread.sleep(threadTime);
                System.out.println( "\n=====> Troll attacked the enemy! \n");
                enemyLife -= trollAttackDamage;
                Thread.sleep(threadTime);
                

                System.out.println( "\n The enemy received "+trollAttackDamage+" damage points!  // Enemy life: "+enemyLife+"\n");
                Thread.sleep(threadTime);


                if(enemyLife <= 0){
                    System.out.println( "\n=====>  The enemy died!\n");
                    Thread.sleep(threadTime);
                    System.out.println( "=====>  The battle is over...\n");
                    Thread.sleep(threadTime);
                    System.out.println( "=====>  The troll went to sleep...\n");
                    Thread.sleep(threadTime);
                    troll.changeState( new StateSleep() );
                    troll.update();
                    break;
                }


                System.out.println( "\n=====>  enemy attacked the troll ! \n");
                troll.life -= enemyAttackDamage;
                Thread.sleep(threadTime);


                System.out.println( "\n The troll received "+enemyAttackDamage+" damage points!  // Troll life: "+troll.life+"\n");
                Thread.sleep(threadTime);


                if(troll.life <= 0){
                    System.out.println( "\n=====>  Troll was killed by the enemy!\n");
                    Thread.sleep(threadTime);
                    System.out.println( "=====>  The battle is over...\n");
                    Thread.sleep(threadTime);
                    troll.changeState( new StateDead() );
                    break;
                }

                --troll.life;
            }

        }catch(InterruptedException ie){
            System.out.println( "\n Houve um erro durante a execucao da Thread..... \n");
        }       
    }

/* 
    @Override
    public void enter(Agent agent){ }

    @Override
    public void exit(Agent agent){ }
*/
}
