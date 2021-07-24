import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class DayAdviceClient {
    public void go() {
        try {
            Socket sock = new Socket("127.0.0.1", 4242);
            InputStreamReader streamReader = new InputStreamReader(sock.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            String advice = reader.readLine();
            System.out.println("Today: " + advice);
            reader.close();
            sock.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        var client = new DayAdviceClient();
        client.go();
    }
}