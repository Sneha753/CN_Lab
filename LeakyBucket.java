import java.util.*;

public class LeakyBucket {

    public static void main(String args[]){

        int noofquery=4;

        int bucketsize=10;

        int ippacketsize;

        int oppacketsize = 0;

        int storedbuffersize=0;

        int sizeleft;

        Scanner sc=new Scanner(System.in);

        for(int i=0;i<noofquery;i++){

            System.out.println("input packet size");

            ippacketsize=sc.nextInt();

            sizeleft=bucketsize-storedbuffersize;

            if(ippacketsize<=sizeleft){

                storedbuffersize+=ippacketsize;

            }

            else {

                System.out.println("packet dropped");

            }

            System.out.println("stored buffer size"+storedbuffersize);

            storedbuffersize-=oppacketsize;

        }

      sc.close();  

    }

}