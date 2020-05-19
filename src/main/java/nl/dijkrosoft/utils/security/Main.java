package nl.dijkrosoft.utils.security;

import com.sun.media.jfxmediaimpl.HostUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.zip.CRC32;

public class  Main {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {

     byte[] bytes = Files.readAllBytes(Paths.get("/Users/dickdijk/_Study/Snippets/sim.zip"));

//        crc32(bytes);
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(bytes);
        System.out.println("SHA-256: "+ bytesToHex(encodedhash));
    }

    private static void crc32(byte[] bytes) {
        CRC32 crc32 = new CRC32();
        crc32.update(bytes);
        System.out.println("Value is "+ crc32.getValue());
    }

    private static String bytesToHex(byte[] hash) {
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) hexString.append('0');
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
