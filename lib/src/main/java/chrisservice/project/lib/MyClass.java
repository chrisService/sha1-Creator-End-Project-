package chrisservice.project.lib;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyClass {

    public static void main(String... args)throws NoSuchAlgorithmException {

        System.out.println(sha1("test string to sha1"));

        String apiPrefix = "https://api.vindecoder.eu/3.0";
        String apikey = "750441402a4d";   // Your API key
        String secretkey = "398edf1b1e";  // Your secret key
        String id = "decode";
        String vin = "VF1BM0F0529591566";

        String controllsum = sha1(vin+"|"+id+"|"+apikey+"|"+secretkey).substring(0,10);

        System.out.println(controllsum);
    }

    static String sha1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

}
