/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1309;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import eu.hansolo.medusa.Gauge;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gajanan
 */
public class TestScreenController implements Initializable {

    @FXML
    private HBox sectionHeader1;
    @FXML
    private Text txtMode;
    @FXML
    private ImageView imgEmergency;
    @FXML
    private ImageView imgAuto;
    @FXML
    private ImageView imgManual;
    @FXML
    private Text txtDate;
    @FXML
    private HBox sectionHeader;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnInitial;
    @FXML
    private JFXButton btnTestScreen;
    @FXML
    private JFXButton btnReport;
    @FXML
    private JFXButton btnSystemCheck;
    @FXML
    private JFXButton btnAdmin;
    @FXML
    private JFXButton btnCycleaStrat;
    @FXML
    private JFXButton btnCycleStop;
    @FXML
    private Gauge GaugeActualHydro_A;
    @FXML
    private Gauge GaugeActualHydro_A1;
    @FXML
    private JFXDrawer drawer;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        if (Session.get("user_type").equals("admin")) {
            btnAdmin.setVisible(true);
            Session.set("catAccess", "granted");
        } else {
            Session.set("catAccess", "not");
            btnAdmin.setVisible(false);
        }
        date_time();

    }

    private void date_time() {
        time.scheduleAtFixedRate(date, 0, 1000);
    }

    Timer time = new Timer();

    TimerTask date = new TimerTask() {
        @Override
        public void run() {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
            txtDate.setText("Date:" + dtf.format(now));

        }
    };

    @FXML
    private void btnHomeAction(ActionEvent event) {

    }

    @FXML
    private void btnInitialAction(ActionEvent event) {
    }

    @FXML
    private void btnTestScreenAction(ActionEvent event) {
    }

    @FXML
    private void btnReportAction(ActionEvent event) {
    }

    @FXML
    private void btnSystemCheckAction(ActionEvent event) {
    }

    @FXML
    private void btnAdminAction(ActionEvent event) {
    }

    @FXML
    private void btnCycleaStratAction(ActionEvent event) {
    }

    @FXML
    private void btnCycleStopAction(ActionEvent event) {
    }

}
