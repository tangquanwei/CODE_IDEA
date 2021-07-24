public class Chat {
    public static void main(String[] args) {
        var server = new DayAdviceServer();
        server.go();
        var client = new DayAdviceClient();
        client.go();

    }
}
