package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ThreadClock implements Runnable {
    int tiempo;
    @FXML
    public Label lblClock;

    @Override
    public void run() {

        while(true){
            tiempo++;
            tiempo=tiempo%60;
            System.out.println(tiempo);
//            lblClock.setText(""+tiempo);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public ThreadClock() {
    tiempo=0;
    }

    public int getTiempo() {
        return tiempo;
    }
}
