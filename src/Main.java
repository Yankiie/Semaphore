import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args){
        int perm =  1;
        Semaphore semaforo = new Semaphore(perm);
        for (int operacao = 0 ; operacao < 21 ; operacao++){
                    Thread Main = new Banco(operacao, semaforo);
                    Main.start();

        }

    }
}
