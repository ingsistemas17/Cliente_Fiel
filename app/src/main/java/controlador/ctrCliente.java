package controlador;







import org.apache.commons.codec.binary.Base64;

import java.security.MessageDigest;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import modelo.Cliente;


/**
 * Created by carlos.morales on 18/10/2016.
 */
public class ctrCliente {

    public Cliente registroUsuario(String primerNombre, String segundoNombre,String primerApellido,String segundoApellido,String cuenta,String contrasena,String nombreCompleto,String correo){
        Cliente cli = new Cliente();
            cli.setPrimerNombre(primerNombre);

            cli.setSegundoNombre(segundoNombre);
            cli.setPrimerApellido(primerApellido);
            cli.setSegundoApellido(segundoApellido);
            cli.setCuenta(cuenta);
            cli.setContrasena(Encriptar(contrasena));
            cli.setNombreCompleto(primerNombre+" "+segundoNombre+" "+primerApellido+" "+segundoApellido);
            cli.setCorreo(correo);

        return cli;
    }


    /**
     * encripta la contrasena
     * @param texto
     * @return
     */
    public static String Encriptar(String texto) {

        String secretKey = "ClienteFiel"; //llave para encriptar datos
        String base64EncryptedString = "";

        try {

            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);

            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            base64EncryptedString = new String(base64Bytes);

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    /**
     * desencripta la contrasena
     * @param textoEncriptado
     * @return
     */
    public static String Desencriptar(String textoEncriptado) throws Exception {

        String secretKey = "ClienteFiel"; //llave para desenciptar datos
        String base64EncryptedString = "";

        try {
            byte[] message = Base64.decodeBase64(textoEncriptado.getBytes("utf-8"));
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");

            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] plainText = decipher.doFinal(message);

            base64EncryptedString = new String(plainText, "UTF-8");

        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }

    /**
     * autentica el Usuario
     * @param cuenta
     * @return
     */
    public Cliente autenticaUsuario(String cuenta) {
        Cliente cli = new Cliente();

        cli.setCuenta(cuenta);

        return cli;
    }
}
