import java.util.concurrent.Semaphore;

public class Banco extends Thread {

    private int operacao;
    private Semaphore semaforo;

    public Banco(int operacao, Semaphore semaforo) {
        this.operacao = operacao;
        this.semaforo = semaforo;
    }

    public void run(){
        int i = 0;
        while ( i < 2){
            try {
                semaforo.acquire();
            } catch (InterruptedException e1){
                e1.printStackTrace();
            } finally {
                transacao();
            }
                semaforo.release();
                    if (operacao % 3 == 2 && operacao % 3 == 0) {
                        calc();
                        try {
                            semaforo.acquire();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            transacao();
                        }
                        semaforo.release();
                    }
            i++;
        }

    }
    private void calc() {
        int tempo = 0;
        if (operacao % 3 == 1) {
            tempo = (int) ((Math.random() * 801) + 200);
        } else if (operacao % 3 == 2) {
            tempo = (int) ((Math.random() * 1001) + 500);
        } else if (operacao % 3 == 0){
            tempo = (int) ((Math.random() * 1001) * 1000);
        }
        System.out.println("Calculando");
        try {
            sleep(tempo);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private void transacao() {
        int tempo = 0;
        if (operacao % 3 == 1) {
            tempo = (int) (Math.random() * 1001);
        } else if (operacao % 3 == 2) {
            tempo = (int) (Math.random() * 1501);
        } else if (operacao % 3 == 0){
            tempo = (int) (Math.random() * 1501);
        }
        System.out.println("Transaçao BD");
        try {
            sleep(tempo);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
