package hw.second.part3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-4-1
 * Description:
 * <p>
 * -----------------------
 */
public class CallOperate {
    public static void main(String[] args) {


        String[] cmd = {"/bin/sh","-c","cal 4 2025 | tail -n 6"};
        try {
            Process p = Runtime.getRuntime().exec(cmd);
            p.waitFor();
            InputStream in = p.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
