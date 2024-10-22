import java.util.*;
public class Monte_Carlo_Mafia {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int numSim, mafia,mafiaWins = 0, numPlayers, remainingMafia, remainingVillages;
        boolean EOG = false;

        System.out.print("Enter the number of simulations to run: ");
        numSim = sc.nextInt();
        System.out.print("Enter the number of players: ");
        numPlayers = sc.nextInt();
        System.out.print("Enter the number of traitors chosen: ");
        mafia = sc.nextInt();

        for(int i = 0; i < numSim; i++){
            //Game setup
            remainingMafia = mafia;
            remainingVillages = numPlayers - mafia;
            //Game start
            while(!EOG){
                //System.out.println("Mafia before night: " + remainingMafia);
                //System.out.println("Villagers before night: " + remainingVillages);
                //night (mafia kill off villagers)
                remainingVillages--;
                //System.out.println("Mafia after night: " + remainingMafia);
                //System.out.println("Villagers after night: " + remainingVillages);

                //day (players to vote to execute suspected mafia)
                int [] vote = new int[remainingMafia+remainingVillages]; // voting for the new day
                Arrays.fill(vote,0);
                //villagers vote randomly
                for(int j = 0; j < remainingVillages; j++){
                    int executed = (int)(Math.random()*(remainingMafia+remainingVillages));// 0-mafia (mafia), mafia+1 - (remainingMafia + remainingVillagers) (villages)
                    vote[executed]++;
                    //System.out.println("Random Villager chosen: " + executed);
                }
                //mafia vote for one villager
                int randomVilager = (int)(Math.random()*(remainingVillages) + remainingMafia);
                //System.out.println("Random Villager chosen by Mafia: " + randomVilager);
                vote[randomVilager]++;

                //tolling of votes
                int mostVotes = 0,executed = 0;
                //System.out.println("First: " + vote[0] + "- Villager 1");
                for(int j = 0; j < remainingMafia+remainingVillages; j++){
                    //System.out.println("Score: " + vote[j] + " - villager: " + j);
                    if(mostVotes <= vote[j]){
                        mostVotes = vote[j];
                        executed = j;
                        //System.out.println("To Be Executed: " + executed);
                    }
                }
                //System.out.println("Executed: " + executed);
                if(executed > mafia){
                    remainingVillages--;
                }
                else{
                    remainingMafia--;
                }
                /*
                System.out.println("Mafia after day: " + remainingMafia);
                System.out.println("Villagers after day: " + remainingVillages);
                System.out.println("End of round");
                */

                if(remainingMafia == 0 || remainingMafia + remainingVillages == 2 ||
                        remainingVillages == 0 || remainingVillages == 1 && remainingMafia > 0){
                    EOG = true;
                }
            }
            //System.out.println("Remaining Mafia EOG: " + remainingMafia);
            if(remainingMafia > 0){
                mafiaWins++;
            }
            //System.out.println("Wins: " + mafiaWins);
            EOG = false;
        }
        System.out.println("The probability that the traitors will win is: " + (double)mafiaWins/(double)numSim * 100 + "%");
    }
}
