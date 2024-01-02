import java.util.*;

public class RED {

    private static final int queueSize = 5;

    private static final int maxpackets = 10;

    private static final double max_prob = 0.7;

    private static final double min_prob = 0.3;

    private static double randDouble(double min, double max) {

        Random rand = new Random();

        return min + (max - min) * rand.nextDouble();

    }

    public static void main(String args[]){

        int queuesize=0;

        double dropprob=min_prob;

        for(int i=0;i<maxpackets;i++){

            if (queueSize==queuesize){

                System.out.println("packets dropped (queue full)");

                dropprob=min_prob;

            }

            else if(randDouble(0,1)<dropprob){

                System.out.println("packet dropped(random)");

                dropprob+=(max_prob-min_prob)/(maxpackets-1);

            }

            else{

                System.out.println("Packet accepted");

                queuesize++;

                dropprob=min_prob;

            }

        }

    }

}