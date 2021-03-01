package k.te.kest;

import com.jcraft.jsch.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.SocketException;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

@SpringBootApplication
public class KestApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(KestApplication.class, args);
    }

    @Override
    public void run(String... args)  throws Exception{
        java.util.Properties config = new java.util.Properties();
        config.put("StrictHostKeyChecking", "no");
        Session session;
        JSch jsch = new JSch();

//        Path path=Paths.get("project/app").toAbsolutePath();
//        File file=new File(path+"/Dockerfile");
//        if(file.exists()){
//            System.out.println("YEP");
//        }
//        else{
//            System.out.println("NOPE");
//        }
//        String dir = "C:\\Users\\oleji\\Desktop\\topkek\\test";
//        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", " cd " + dir + " && rename pr proo");
//        Process process = processBuilder.start();

        String sout = "";

        try {
            try {
                ServerSocket server = new ServerSocket(3000 );
                server.setReuseAddress(true);
                server.close();
            } catch (SocketException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            String k=AES.encrypt("dfsdfsfs","kek");
//            System.out.println(k);
//            System.out.println(AES.decrypt(k,"kek"));
//            System.out.println(AES.decrypt("U2FsdGVkX1/m0yfJPBDCUpoqCRZnJpppInCRd/IVxco=","kek"));
            session = jsch.getSession("oleg", "goschansin.ru");
            session.setPassword("kekoleg");
            session.setConfig(config);
            session.connect();
//            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
//            channelSftp.connect();
//            try (OutputStream out = channelSftp.put("kek/Dockerfile")) {
//                OutputStreamWriter writer = new OutputStreamWriter(out);
//                writer.write("some text");
//                writer.flush();
//                writer.close();
//                channelSftp.disconnect();
//                session.disconnect();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
            Channel channel = session.openChannel("exec");
            ((ChannelExec) channel).setCommand("sudo -S -p ' ' ping yandex.ru");
            channel.setInputStream(null);
            ((ChannelExec) channel).setErrStream(System.err);
            InputStream in = channel.getInputStream();
            ((ChannelExec) channel).setPty(true);
            channel.connect();
            OutputStream out = channel.getOutputStream();
            out.write(("kekoleg" + "\n").getBytes());
            out.flush();
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    sout += new String(tmp, 0, i);
                }
                if (channel.isClosed()) {
                    System.out.println("exit-status: " + channel.getExitStatus());
                    break;
                }

//                try{Thread.sleep(1000);}catch(Exception ee){}
            }


            channel.disconnect();
            session.disconnect();

        } catch (JSchException e) {
            e.printStackTrace();
        }
//        System.out.println(sout);
    }
}
