import java.util.*;

public class CRC {

    public static String CRC(String data, String poly, boolean errchk) {

        String rem = data;

        if (!errchk) {

            for (int i = 0; i < poly.length() - 1; i++) {

                rem += "0";

            }

        }

        for (int i = 0; i < rem.length() - poly.length() + 1; i++) {

            if (rem.charAt(i) == '1') {

                for (int j = 0; j < poly.length(); j++) {

                    rem = rem.substring(0, i + j) + (rem.charAt(i + j) == poly.charAt(j) ? '0' : '1')
                            + rem.substring(i + j + 1);

                }

            }

        }

        return rem.substring(rem.length() - poly.length() + 1);

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the generator polynomial:");

        String poly = sc.next();

        System.out.print("Enter the data to be sent:");

        String data = sc.next();

        String rem = CRC(data, poly, false);

        String Codeword = data + rem;

        System.out.println("Remainder:" + rem);

        System.out.println("Codeword:" + Codeword);

        System.out.print("Enter the received codeword:");

        String recCodeword = sc.next();

        String recRem = CRC(recCodeword, poly, true);

        if (Integer.parseInt(recRem) == 0)

            System.out.println("No error");

        else

            System.out.println("Error detected");

        sc.close();

    }

}
