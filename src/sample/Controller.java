package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    public Label lblClock;
    public Integer tiempo=0;


    public void iniciarHilo(ActionEvent actionEvent) {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    tiempo++;
                    tiempo=tiempo%60;
                    System.out.println(tiempo);

                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            lblClock.setText(""+tiempo.toString());
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        th.setDaemon(true);
        th.start();
    }
}



