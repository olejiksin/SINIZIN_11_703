package sample.servers;

public class startServer {
    public static void main(String[] args) {
        Server server=new Server();
        server.start(8888);
    }
}
