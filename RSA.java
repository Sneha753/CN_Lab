import java.io.*;

import java.math.BigInteger;

import java.util.*;

public class RSA {

    private BigInteger p, q, n, phi, e, d;

    private int bitlength = 1024;

    private Random r;

    public RSA() {

        r = new Random();

        p = BigInteger.probablePrime(bitlength, r);

        q = BigInteger.probablePrime(bitlength, r);

        System.out.println("prime number p is " + p);

        System.out.println("prime number q is " + q);

        n = p.multiply(q);

        phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.probablePrime(bitlength / 2, r);

        while (phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0) {

            e.add(BigInteger.ONE);

        }

        System.out.println("public key is " + e);

        d = e.modInverse(phi);

        System.out.println("private key is " + d);

    }

    public RSA(BigInteger e, BigInteger d, BigInteger n) {

        this.e = e;

        this.d = d;

        this.n = n;

    }

    public static void main(String args[]) throws IOException {

        RSA rsa = new RSA();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String teststring;

        System.out.println("enter plaintext:");
        ;

        teststring = in.readLine();

        System.out.println("encrypting string " + teststring);

        System.out.println("string in bytes " + bytestostring(teststring.getBytes()));

        byte[] encrypted = rsa.encrypt(teststring.getBytes());

        byte[] decrypted = rsa.decrypt(encrypted);

        System.out.println("Decryption bytes " + bytestostring(decrypted));

        System.out.println("decrypted string " + new String(decrypted));

    }

    private static String bytestostring(byte[] encrypted) {

        String test = "";

        for (byte b : encrypted) {

            test += Byte.toString(b);

        }

        return test;

    }

    public byte[] encrypt(byte[] message) {

        return (new BigInteger(message)).modPow(e, n).toByteArray();

    }

    public byte[] decrypt(byte[] message){

        return (new BigInteger(message)).modPow(d,n).toByteArray();

    }

}