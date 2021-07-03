/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e1309;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import static javafx.scene.paint.Color.RED;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Gajanan
 */
public class InitialScreenController implements Initializable {

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
    private Text txtOffline;
    @FXML
    private HBox sectionHeader;
    @FXML
    private JFXButton btnHome;
    @FXML
    private JFXButton btnTestScreen;
    @FXML
    private JFXButton btnReport;
    @FXML
    private JFXButton btnSystemCheck;
    @FXML
    private JFXButton btnAdmin;
    @FXML
    private JFXComboBox<String> cmbTestType;
    @FXML
    private JFXComboBox<String> cmbValveSize;
    @FXML
    private JFXRadioButton radioBar;
    @FXML
    private JFXRadioButton radioPsi;
    @FXML
    private JFXRadioButton radioKgcm;
    @FXML
    private JFXTextField txtValveSerialNo;
    @FXML
    private JFXTextField txtPoNo;
    @FXML
    private JFXTextField txtInspection;
    @FXML
    private JFXTextField txtTagNo;
    @FXML
    private JFXTextField txtSoNo;
    @FXML
    private JFXTextField txtValveCode;
    @FXML
    private JFXTextField txtPoSlNo;
    @FXML
    private JFXTextField txtCustMantNo;
    @FXML
    private JFXTextField txtSetPressure;
//    @FXML
//    private JFXComboBox<?> txtGaugeSlNO;
    @FXML
    private JFXTextField txtValveModel;
    @FXML
    private JFXTextField txtOrifice;
    @FXML
    private JFXTextField txtInletSpec;
    @FXML
    private JFXTextField txtOultLetSpec;
    @FXML
    private JFXTextField txtCDSPressure;
    @FXML
    private JFXTextField txtRelievingTemp;
    @FXML
    private JFXTextField txtBaclPressure;
    @FXML
    private JFXTextField txtSpringSpec;
    @FXML
    private JFXTextField txtSpringHeat;
    @FXML
    private JFXTextField txtSpringRT;
    @FXML
    private JFXTextField txtSpringMP;
    @FXML
    private JFXTextField txtSpringLP;
    @FXML
    private JFXTextField txtBodySpec;
    @FXML
    private JFXTextField txtBodyHeat;
    @FXML
    private JFXTextField txtBodyRT;
    @FXML
    private JFXTextField txtBodyMP;
    @FXML
    private JFXTextField txtBodyLP;
    @FXML
    private JFXTextField txtNozzleSpec;
    @FXML
    private JFXTextField txtNozzleHeat;
    @FXML
    private JFXTextField txtNozzleRT;
    @FXML
    private JFXTextField txtNozzleMP;
    @FXML
    private JFXTextField txtNozzleLP;
    @FXML
    private JFXTextField txtDiscSpec;
    @FXML
    private JFXTextField txtDiscHeat;
    @FXML
    private JFXTextField txtDiscRT;
    @FXML
    private JFXTextField txtDiscMP;
    @FXML
    private JFXTextField txtDiscLP;
    @FXML
    private JFXTextField txtBonnetSpec;
    @FXML
    private JFXTextField txtBonnetHeat;
    @FXML
    private JFXTextField txtBonnetRT;
    @FXML
    private JFXTextField txtBonnetMP;
    @FXML
    private JFXTextField txtBonnetLP;
    @FXML
    private JFXTextField txtBellowSpec;
    @FXML
    private JFXTextField txtBellowHeat;
    @FXML
    private JFXTextField txtBellowRT;
    @FXML
    private JFXTextField txtBellowMP;
    @FXML
    private JFXTextField txtBellowLP;
    @FXML
    private Text txtxMagnetic;
    @FXML
    private JFXTextField txtOther;
    DatabaseHandler dh = new DatabaseHandler();
    Connection connect = dh.MakeConnection();
    @FXML
    private JFXTextField txtCustomer;
    @FXML
    private JFXTextField txtRadioGraphy;
    @FXML
    private JFXTextField txtmagnettic;
    @FXML
    private JFXComboBox<String> cmbValveClass;

    String poNo, customer, inspection, tagNo, soNo, valveCode, poSlNo, custMatNo, valveModel, orifice, inletSpec, outletSpec, cdsPressure, relievingTemp, backpressure, SpringHeat, SpringLP, SpringMP, SpringRT, SpringSpec, BodyHeat, BodyLP, BodyMP, BodyRT, BodySpec, BonnetHeat, BonnetLP, BonnetMP, BonnetRT, BonnetSpec, NozzleHeat, NozzleLP, NozzleMP, NozzleRT, NozzleSpec, DiscHeat, DiscLP, DiscMP, DiscRT, DiscSpec, BellowHeat, BellowLP, BellowMP, BellowRT, BellowSpec, RadioGraphy, magnettic, Other, valveType, valveSize, valveClass, testType, setPressure, mac_mode, current_machine_mode;
    @FXML
    private JFXComboBox<String> cmbValveType;
    @FXML
    private JFXComboBox<String> cmbGaugeSlNO;
    Thread machine_mode;
    Boolean stop_insert = false, stop_mode = false, stop_pressure_get = true;
    final ToggleGroup group = new ToggleGroup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            if (Session.get("user_type").equals("admin")) {
                btnAdmin.setVisible(true);
                Session.set("catAccess", "granted");
            } else {
                Session.set("catAccess", "not");
                btnAdmin.setVisible(false);
            }
            date_time();
            InitialDataLoad();
            machine_mode();

            txtPoNo.setEditable(false);
            txtCustomer.setEditable(false);
            txtInspection.setEditable(false);
            txtTagNo.setEditable(false);
            txtSoNo.setEditable(false);
            txtValveCode.setEditable(false);
            txtPoSlNo.setEditable(false);
            txtCustMantNo.setEditable(false);
//                 txtSetPressure.setText(rs.getString(""));
            txtValveModel.setEditable(false);
            txtOrifice.setEditable(false);
            txtInletSpec.setEditable(false);
            txtOultLetSpec.setEditable(false);
            txtCDSPressure.setEditable(false);
            txtRelievingTemp.setEditable(false);
            txtBaclPressure.setEditable(false);

            txtSpringHeat.setEditable(false);
            txtSpringLP.setEditable(false);
            txtSpringMP.setEditable(false);
            txtSpringRT.setEditable(false);
            txtSpringSpec.setEditable(false);

            txtBodyHeat.setEditable(false);
            txtBodyLP.setEditable(false);
            txtBodyMP.setEditable(false);
            txtBodyRT.setEditable(false);
            txtBodySpec.setEditable(false);

            txtBonnetHeat.setEditable(false);
            txtBonnetLP.setEditable(false);
            txtBonnetMP.setEditable(false);
            txtBonnetRT.setEditable(false);
            txtBonnetSpec.setEditable(false);

            txtNozzleHeat.setEditable(false);
            txtNozzleLP.setEditable(false);
            txtNozzleMP.setEditable(false);
            txtNozzleRT.setEditable(false);
            txtNozzleSpec.setEditable(false);

            txtDiscHeat.setEditable(false);
            txtDiscLP.setEditable(false);
            txtDiscMP.setEditable(false);
            txtDiscRT.setEditable(false);
            txtDiscSpec.setEditable(false);

            txtBellowHeat.setEditable(false);
            txtBellowLP.setEditable(false);
            txtBellowMP.setEditable(false);
            txtBellowRT.setEditable(false);
            txtBellowSpec.setEditable(false);

            txtRadioGraphy.setEditable(false);
            txtmagnettic.setEditable(false);
            txtOther.setEditable(false);

            radioBar.setToggleGroup(group);
            radioBar.setSelected(true);
            radioPsi.setToggleGroup(group);
            radioKgcm.setToggleGroup(group);

        } catch (SQLException ex) {
            Logger.getLogger(InitialScreenController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void InitialDataLoad() throws SQLException {
        ResultSet rs = dh.getData("SELECT * FROM test_type ORDER BY test_id ASC", connect);
        cmbTestType.getItems().clear();
        while (rs.next()) {
            cmbTestType.getItems().add(rs.getString("test_type"));
        }
        ResultSet rs_vs = dh.getData("SELECT * FROM valve_size ORDER BY valve_size_id ASC", connect);
        while (rs_vs.next()) {
            cmbValveSize.getItems().add(rs_vs.getString("valve_size"));
        }
        ResultSet rs_vc = dh.getData("SELECT * FROM valve_class ORDER BY valve_class_id ASC", connect);
        while (rs_vc.next()) {
            cmbValveClass.getItems().add(rs_vc.getString("valve_class"));
        }

        ResultSet rs_vt = dh.getData("SELECT * FROM valve_type ORDER BY valve_type_id ASC", connect);
        while (rs_vt.next()) {
            cmbValveType.getItems().add(rs_vt.getString("valve_type"));
        }

        ResultSet rs_gd = dh.getData("SELECT * FROM gauge_data gd", connect);
        while (rs_gd.next()) {
            cmbGaugeSlNO.getItems().add(rs_gd.getString("serial"));
        }
    }

    private void machine_mode() {

        machine_mode = new Thread(() -> {

            String display = "SELECT * FROM initialinitmain ORDER BY id DESC LIMIT 1";
            ResultSet rs;
            while (true) {

                try {

                    long start = System.currentTimeMillis();
//
                    try {

                        machine_mode.sleep(150);
                    } catch (InterruptedException intex) {
                        intex.printStackTrace();
                        System.err.println("Interupt in mode thread : " + intex);
                    }
//Sleeping thread for 250 miliseconds: End

                    if (stop_mode) {
                        break;
                    }

                    rs = dh.getData(display, connect);
                    if (rs.next()) {
                        //Storing Value's of Machine Parameters: Start
                        if (ToolKit.isNull(rs.getString("machine_mode"))) {
                            System.out.println("NULL machine_mode");
                        } else {

//                                mac_mode=rs.getString("ma")
                            mac_mode = rs.getString("machine_mode");
                        }
                        if (mac_mode.equals(current_machine_mode)) {
                        } else {
                            mode(mac_mode);
                        }
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(InitialScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Sleeping thread for 250 miliseconds: End
            }
        });
        machine_mode.start();
    }

    private void mode(String mode) {
        switch (mode) {
            case "0":
                txtMode.setText("Emergency Mode");
                current_machine_mode = "0";
                txtDate.setFill(Color.web("#C32420"));
                break;
            case "1":
                txtMode.setText("PT Error");
                current_machine_mode = "1";
                txtDate.setFill(Color.web("#C32420"));
                break;
            case "2":
                txtMode.setText("Manual Mode");
                current_machine_mode = "2";
                txtDate.setFill(Color.web("#0099FF"));
                break;
            case "3":
                txtMode.setText("Auto Mode");
                current_machine_mode = "3";
                txtDate.setFill(Color.web("#0099FF"));
                break;
            default:
                txtMode.setText("Something wrong");
                current_machine_mode = "4";
                txtDate.setFill(Color.web("#C32420"));
                break;
        }
    }

    private void fieldEmpty() {
        poNo = txtPoNo.getText();
        customer = txtCustomer.getText();
        inspection = txtInspection.getText();
        tagNo = txtTagNo.getText();
        soNo = txtSoNo.getText();
        valveCode = txtValveCode.getText();
        poSlNo = txtPoSlNo.getText();
        custMatNo = txtCustMantNo.getText();
//                 = txtSetPressure.setText(rs.getString(""));
        valveModel = txtValveModel.getText();
        orifice = txtOrifice.getText();
        inletSpec = txtInletSpec.getText();
        outletSpec = txtOultLetSpec.getText();
        cdsPressure = txtCDSPressure.getText();
        relievingTemp = txtRelievingTemp.getText();
        backpressure = txtBaclPressure.getText();

        SpringHeat = txtSpringHeat.getText();
        SpringLP = txtSpringLP.getText();
        SpringMP = txtSpringMP.getText();
        SpringRT = txtSpringRT.getText();
        SpringSpec = txtSpringSpec.getText();

        BodyHeat = txtBodyHeat.getText();
        BodyLP = txtBodyLP.getText();
        BodyMP = txtBodyMP.getText();
        BodyRT = txtBodyRT.getText();
        BodySpec = txtBodySpec.getText();

        BonnetHeat = txtBonnetHeat.getText();
        BonnetLP = txtBonnetLP.getText();
        BonnetMP = txtBonnetMP.getText();
        BonnetRT = txtBonnetRT.getText();
        BonnetSpec = txtBonnetSpec.getText();

        NozzleHeat = txtNozzleHeat.getText();
        NozzleLP = txtNozzleLP.getText();
        NozzleMP = txtNozzleMP.getText();
        NozzleRT = txtNozzleRT.getText();
        NozzleSpec = txtNozzleSpec.getText();

        DiscHeat = txtDiscHeat.getText();
        DiscLP = txtDiscLP.getText();
        DiscMP = txtDiscMP.getText();
        DiscRT = txtDiscRT.getText();
        DiscSpec = txtDiscSpec.getText();

        BellowHeat = txtBellowHeat.getText();
        BellowLP = txtBellowLP.getText();
        BellowMP = txtBellowMP.getText();
        BellowRT = txtBellowRT.getText();
        BellowSpec = txtBellowSpec.getText();

        RadioGraphy = txtRadioGraphy.getText();
        magnettic = txtmagnettic.getText();
        Other = txtOther.getText();

        valveClass = cmbValveClass.getSelectionModel().getSelectedItem();
        valveType = cmbValveType.getSelectionModel().getSelectedItem();
        valveSize = cmbValveSize.getSelectionModel().getSelectedItem();
        testType = cmbTestType.getSelectionModel().getSelectedItem();
        setPressure = txtSetPressure.getText();
    }

    @FXML
    private void btnHomeAction(ActionEvent event) {
        Platform.runLater(() -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                ToolKit.loadScreen(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ToolKit.unloadScreen(btnReport);
    }

    @FXML
    private void btnTestScreenAction(ActionEvent event) throws SQLException {
        fieldEmpty();
        if (ToolKit.isNull(vsn)
                || ToolKit.isNull(poNo)
                || ToolKit.isNull(customer)
                || ToolKit.isNull(inspection)
                || ToolKit.isNull(tagNo)
                || ToolKit.isNull(soNo)
                || ToolKit.isNull(valveCode)
                || ToolKit.isNull(poSlNo)
                || ToolKit.isNull(custMatNo)
                || ToolKit.isNull(setPressure)
                //                || ToolKit.isNull()
                || ToolKit.isNull(valveModel)
                || ToolKit.isNull(orifice)
                || ToolKit.isNull(inletSpec)
                || ToolKit.isNull(outletSpec)
                || ToolKit.isNull(cdsPressure)
                || ToolKit.isNull(relievingTemp)
                || ToolKit.isNull(backpressure)
                || ToolKit.isNull(SpringHeat)
                || ToolKit.isNull(SpringLP)
                || ToolKit.isNull(SpringMP)
                || ToolKit.isNull(SpringRT)
                || ToolKit.isNull(SpringSpec)
                || ToolKit.isNull(BodyHeat)
                || ToolKit.isNull(BodyLP)
                || ToolKit.isNull(BodyMP)
                || ToolKit.isNull(BodyRT)
                || ToolKit.isNull(BodySpec)
                || ToolKit.isNull(NozzleHeat)
                || ToolKit.isNull(NozzleLP)
                || ToolKit.isNull(NozzleMP)
                || ToolKit.isNull(NozzleRT)
                || ToolKit.isNull(NozzleSpec)
                || ToolKit.isNull(DiscHeat)
                || ToolKit.isNull(DiscLP)
                || ToolKit.isNull(DiscMP)
                || ToolKit.isNull(DiscRT)
                || ToolKit.isNull(DiscSpec)
                || ToolKit.isNull(BonnetHeat)
                || ToolKit.isNull(BonnetLP)
                || ToolKit.isNull(BonnetMP)
                || ToolKit.isNull(BonnetRT)
                || ToolKit.isNull(BonnetSpec)
                || ToolKit.isNull(BellowHeat)
                || ToolKit.isNull(BellowLP)
                || ToolKit.isNull(BellowMP)
                || ToolKit.isNull(BellowRT)
                || ToolKit.isNull(BellowSpec)
                || ToolKit.isNull(valveType)
                || ToolKit.isNull(valveClass)
                || ToolKit.isNull(valveSize)
                || ToolKit.isNull(testType)) {

            Dialog.showForSometime("ALERT", "Field Required", "Waring", 450, 5);
            check_text_empty_fields(txtValveSerialNo, vsn);
            check_text_empty_fields(txtPoNo, poNo);
            check_text_empty_fields(txtCustomer, customer);
            check_text_empty_fields(txtInletSpec, inspection);
            check_text_empty_fields(txtTagNo, tagNo);
            check_text_empty_fields(txtSoNo, soNo);
            check_text_empty_fields(txtValveCode, valveCode);
            check_text_empty_fields(txtPoNo, poSlNo);
            check_text_empty_fields(txtCustMantNo, custMatNo);
            check_text_empty_fields(txtSetPressure, setPressure);
            check_text_empty_fields(txtInletSpec, inletSpec);
            check_text_empty_fields(txtOultLetSpec, outletSpec);
            check_text_empty_fields(txtCDSPressure, cdsPressure);
            check_text_empty_fields(txtRelievingTemp, relievingTemp);
            check_text_empty_fields(txtBaclPressure, backpressure);
            check_text_empty_fields(txtValveModel, valveModel);
            check_text_empty_fields(txtOrifice, orifice);
            check_text_empty_fields(txtSpringHeat, SpringHeat);
            check_text_empty_fields(txtSpringLP, SpringLP);
            check_text_empty_fields(txtSpringMP, SpringMP);
            check_text_empty_fields(txtSpringRT, SpringRT);
            check_text_empty_fields(txtSpringSpec, SpringSpec);
            check_text_empty_fields(txtBodyHeat, BodyHeat);
            check_text_empty_fields(txtBodyLP, BodyLP);
            check_text_empty_fields(txtBodyMP, BodyMP);
            check_text_empty_fields(txtBodyRT, BodyRT);
            check_text_empty_fields(txtBodySpec, BodySpec);
            check_text_empty_fields(txtNozzleHeat, NozzleHeat);
            check_text_empty_fields(txtNozzleLP, NozzleLP);
            check_text_empty_fields(txtNozzleMP, NozzleMP);
            check_text_empty_fields(txtNozzleRT, NozzleSpec);
            check_text_empty_fields(txtNozzleSpec, NozzleRT);
            check_text_empty_fields(txtDiscHeat, DiscHeat);
            check_text_empty_fields(txtDiscLP, DiscLP);
            check_text_empty_fields(txtDiscMP, DiscMP);
            check_text_empty_fields(txtDiscRT, DiscRT);
            check_text_empty_fields(txtDiscSpec, DiscSpec);
            check_text_empty_fields(txtBonnetHeat, BonnetHeat);
            check_text_empty_fields(txtBonnetLP, BonnetLP);
            check_text_empty_fields(txtBonnetMP, BonnetMP);
            check_text_empty_fields(txtBonnetRT, BonnetRT);
            check_text_empty_fields(txtBonnetSpec, BonnetSpec);
            check_text_empty_fields(txtBellowHeat, BellowHeat);
            check_text_empty_fields(txtBellowLP, BellowLP);
            check_text_empty_fields(txtBellowMP, BellowMP);
            check_text_empty_fields(txtBellowRT, BellowRT);
            check_text_empty_fields(txtBellowSpec, BellowSpec);
            check_text_empty_fields(txtRadioGraphy, RadioGraphy);
            check_text_empty_fields(txtmagnettic, magnettic);
            check_text_empty_fields(txtOther, Other);
            check_combo_empty_fields(cmbValveClass, valveClass);
            check_combo_empty_fields(cmbValveType, valveType);
            check_combo_empty_fields(cmbValveSize, valveSize);
            check_combo_empty_fields(cmbTestType, testType);

        } else {
            System.out.println("");
            String gaugeSlno = cmbGaugeSlNO.getSelectionModel().getSelectedItem();
            String unit = null;
            if (radioBar.isSelected()) {
                unit = "bar";
            } else if (radioKgcm.isSelected()) {
                unit = "kgcm";
            } else if (radioPsi.isSelected()) {
                unit = "psi";
            }

            ResultSet rs = dh.getData("SELECT * FROM master_data WHERE `serial_number` ='" + txtValveSerialNo.getText() + "'", connect);
            if (rs.next()) {
                ResultSet rs_tno = dh.getData("SELECT test_no FROM valve_data ORDER BY id DESC LIMIT 1", connect);
                if (rs_tno.next()) {
                    test_no = Integer.parseInt(rs_tno.getString("test_no"));
                    test_no++;
                } else {

                }
                System.out.println("INSERT INTO `valve_data`(`test_no`,`testType`, `valveType`, `valveSize`, `valveClass`, `setPressure`, `unit`, `gaugeSlNo`, `holdingTime`, `serial_number`, `poNo`, `customer`, `inspection`, `tagNo`, `soNo`, `valveCode`, `poSlNo`, `custMatNo`, `valveModel`, `orifice`, `inletSpec`, `outletSpec`, `cdsPressure`, `relievingTemp`, `backPressure`, `springSpecification`, `springHeatPart`, `springRT`, `springMP`, `springLP`, `bodySpecification`, `bodyHeatPart`, `bodyRT`, `bodyMP`, `bodyLP`, `nozzleSpecification`, `nozzleHeatPart`, `nozzleRT`, `nozzleMP`, `nozzleLP`, `discInsertSpecification`, `discInsertHeatPart`, `discInsertRT`, `discInsertMP`, `discInsertLP`, `bonnetSpecification`, `bonnetHeatPart`, `bonnetRT`, `bonnetMP`, `bonnetLP`, `bellowSpecification`, `bellowHeatPart`, `bellowRT`, `bellowMP`, `bellowLP`, `radiographyTest`, `magneticparticleTest`, `other`, `date`) VALUES ('" + test_no + "','" + testType + "','" + valveType + "', '" + valveSize + "', '" + valveClass + "','" + setPressure + "','" + unit + "','" + gaugeSlno + "','NA','" + vsn + "','" + poNo + "', '" + customer + "', '" + inspection + "', '" + tagNo + "', '" + soNo + "', '" + valveCode + "','" + poSlNo + "', '" + custMatNo + "', '" + valveModel + "', '" + orifice + "', '" + inletSpec + "', '" + outletSpec + "', '" + cdsPressure + "', '" + relievingTemp + "', '" + backpressure + "', '" + SpringSpec + "','" + SpringHeat + "',  '" + SpringRT + "', '" + SpringMP + "','" + SpringLP + "','" + BodySpec + "','" + BodyHeat + "', '" + BodyRT + "', '" + BodyMP + "','" + BodyLP + "','" + NozzleSpec + "','" + NozzleHeat + "','" + NozzleRT + "','" + NozzleMP + "','" + NozzleLP + "','" + DiscSpec + "','" + DiscHeat + "','" + DiscRT + "','" + DiscMP + "','" + DiscLP + "','" + BonnetSpec + "','" + BonnetHeat + "','" + BonnetRT + "', '" + BonnetMP + "', '" + BonnetLP + "','" + BellowSpec + "','" + BellowHeat + "','" + BellowRT + "','" + BellowMP + "', '" + BellowLP + "', '" + RadioGraphy + "','" + magnettic + "', '" + Other + "',NOW())");

                dh.execute("INSERT INTO `valve_data`(`test_no`,`testType`, `valveType`, `valveSize`, `valveClass`, `setPressure`, `unit`, `gaugeSlNo`, `holdingTime`, `serial_number`, `poNo`, `customer`, `inspection`, `tagNo`, `soNo`, `valveCode`, `poSlNo`, `custMatNo`, `valveModel`, `orifice`, `inletSpec`, `outletSpec`, `cdsPressure`, `relievingTemp`, `backPressure`, `springSpecification`, `springHeatPart`, `springRT`, `springMP`, `springLP`, `bodySpecification`, `bodyHeatPart`, `bodyRT`, `bodyMP`, `bodyLP`, `nozzleSpecification`, `nozzleHeatPart`, `nozzleRT`, `nozzleMP`, `nozzleLP`, `discInsertSpecification`, `discInsertHeatPart`, `discInsertRT`, `discInsertMP`, `discInsertLP`, `bonnetSpecification`, `bonnetHeatPart`, `bonnetRT`, `bonnetMP`, `bonnetLP`, `bellowSpecification`, `bellowHeatPart`, `bellowRT`, `bellowMP`, `bellowLP`, `radiographyTest`, `magneticparticleTest`, `other`, `date`) VALUES ('" + test_no + "','" + testType + "','" + valveType + "', '" + valveSize + "', '" + valveClass + "','" + setPressure + "','" + unit + "','" + gaugeSlno + "','NA','" + vsn + "','" + poNo + "', '" + customer + "', '" + inspection + "', '" + tagNo + "', '" + soNo + "', '" + valveCode + "','" + poSlNo + "', '" + custMatNo + "', '" + valveModel + "', '" + orifice + "', '" + inletSpec + "', '" + outletSpec + "', '" + cdsPressure + "', '" + relievingTemp + "', '" + backpressure + "', '" + SpringSpec + "','" + SpringHeat + "',  '" + SpringRT + "', '" + SpringMP + "','" + SpringLP + "','" + BodySpec + "','" + BodyHeat + "', '" + BodyRT + "', '" + BodyMP + "','" + BodyLP + "','" + NozzleSpec + "','" + NozzleHeat + "','" + NozzleRT + "','" + NozzleMP + "','" + NozzleLP + "','" + DiscSpec + "','" + DiscHeat + "','" + DiscRT + "','" + DiscMP + "','" + DiscLP + "','" + BonnetSpec + "','" + BonnetHeat + "','" + BonnetRT + "', '" + BonnetMP + "', '" + BonnetLP + "','" + BellowSpec + "','" + BellowHeat + "','" + BellowRT + "','" + BellowMP + "', '" + BellowLP + "', '" + RadioGraphy + "','" + magnettic + "', '" + Other + "',NOW())", connect);
                Session.set("vsn", vsn);
                Session.set("test_no", Integer.toString(test_no));
                Session.set("tt", testType);
                Session.set("vt", valveType);
                Session.set("vc", valveClass);
                Session.set("vs", valveSize);
//                    Session.set("green", green);
//                    Session.set("max", max);
//                    Session.set("pu", pu);
                Session.set("hsp", setPressure);

                Session.set("gaugeSlNo", gaugeSlno);
                Platform.runLater(() -> {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("InitialScreen.fxml"));
                        ToolKit.loadScreen(root);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
                ToolKit.unloadScreen(btnTestScreen);
            } else {
                Dialog.showForSometime("ALERT", "You have edited the Valve Serial No..Please Check", BodyHeat, 450, 5);
                check_text_data_fields(txtValveSerialNo);
            }

        }
    }

    private void check_text_empty_fields(JFXTextField field, String value) {
        if (value != null && !value.isEmpty()) {
            if (value.equals("null") || value.equals("")) {
                field.setUnFocusColor(RED);
                field.setFocusColor(RED);
            } else {
//                field.setFocusColor(false);
            }
        } else {
            field.setUnFocusColor(RED);
            field.setFocusColor(RED);
        }
    }

    private void check_text_data_fields(JFXTextField field) {

        field.setUnFocusColor(RED);
        field.setFocusColor(RED);

    }

    private void check_combo_empty_fields(JFXComboBox field, String value) {
        if (value != null && !value.isEmpty()) {
            if (value.equals("null") || value.equals("")) {
                field.setUnFocusColor(RED);
                field.setFocusColor(RED);
            } else {
//                field.setVisible(false);
            }
        } else {
            field.setUnFocusColor(RED);
            field.setFocusColor(RED);
        }
    }

    @FXML
    private void btnReportAction(ActionEvent event) {
        Platform.runLater(() -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("ReportScreen.fxml"));
                ToolKit.loadScreen(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ToolKit.unloadScreen(btnReport);
    }

    @FXML
    private void btnSystemCheckAction(ActionEvent event) {
        Platform.runLater(() -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AlarmScreen.fxml"));
                ToolKit.loadScreen(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ToolKit.unloadScreen(btnReport);
    }

    @FXML
    private void btnAdminAction(ActionEvent event) {
        Platform.runLater(() -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("AdminScreen.fxml"));
                ToolKit.loadScreen(root);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        ToolKit.unloadScreen(btnReport);
    }

    @FXML
    private void cmbTestTypeAction(ActionEvent event) {
    }

    @FXML
    private void cmbValveSizeAction(ActionEvent event) {
    }

    @FXML
    private void txtHydroSetPressureAction(ActionEvent event) {
    }

    @FXML
    private void txtHydroPressureKeyRelease(KeyEvent event) {
    }

    @FXML
    private void radioBarAction(ActionEvent event) {
    }

    @FXML
    private void radioPsiAction(ActionEvent event) {
    }

    @FXML
    private void radioradioKgcmAction(ActionEvent event) {
    }
    String vsn;
    int test_no = 0;

    @FXML
    private void txtValveSerialNoAction(ActionEvent event) throws SQLException {
        vsn = txtValveSerialNo.getText();
        if (vsn.equals("")) {

        } else {
            ResultSet rs = dh.getData("SELECT * FROM master_data WHERE `serial_number` ='" + vsn + "'", connect);
            if (rs.next()) {
                txtPoNo.setText(rs.getString("poNo"));
                txtCustomer.setText(rs.getString("customer"));
                txtInspection.setText(rs.getString("inspection"));
                txtTagNo.setText(rs.getString("tagNo"));
                txtSoNo.setText(rs.getString("soNo"));
                txtValveCode.setText(rs.getString("valveCode"));
                txtPoSlNo.setText(rs.getString("poSlNo"));
                txtCustMantNo.setText(rs.getString("custMatNo"));
//                 txtSetPressure.setText(rs.getString(""));
                txtValveModel.setText(rs.getString("valveModel"));
                txtOrifice.setText(rs.getString("orifice"));
                txtInletSpec.setText(rs.getString("inletSpec"));
                txtOultLetSpec.setText(rs.getString("outletSpec"));
                txtCDSPressure.setText(rs.getString("cdsPressure"));
                txtRelievingTemp.setText(rs.getString("relievingTemp"));
                txtBaclPressure.setText(rs.getString("backPressure"));

                txtSpringHeat.setText(rs.getString("springHeatPart"));
                txtSpringLP.setText(rs.getString("springLP"));
                txtSpringMP.setText(rs.getString("springMP"));
                txtSpringRT.setText(rs.getString("springRT"));
                txtSpringSpec.setText(rs.getString("springSpecification"));

                txtBodyHeat.setText(rs.getString("bodyHeatPart"));
                txtBodyLP.setText(rs.getString("bodyLP"));
                txtBodyMP.setText(rs.getString("bodyMP"));
                txtBodyRT.setText(rs.getString("bodyRT"));
                txtBodySpec.setText(rs.getString("bodySpecification"));

                txtBonnetHeat.setText(rs.getString("bonnetHeatPart"));
                txtBonnetLP.setText(rs.getString("bonnetLP"));
                txtBonnetMP.setText(rs.getString("bonnetMP"));
                txtBonnetRT.setText(rs.getString("bonnetRT"));
                txtBonnetSpec.setText(rs.getString("bonnetSpecification"));

                txtNozzleHeat.setText(rs.getString("nozzleHeatPart"));
                txtNozzleLP.setText(rs.getString("nozzleLP"));
                txtNozzleMP.setText(rs.getString("nozzleMP"));
                txtNozzleRT.setText(rs.getString("nozzleRT"));
                txtNozzleSpec.setText(rs.getString("nozzleSpecification"));

                txtDiscHeat.setText(rs.getString("discInsertHeatPart"));
                txtDiscLP.setText(rs.getString("discInsertLP"));
                txtDiscMP.setText(rs.getString("discInsertMP"));
                txtDiscRT.setText(rs.getString("discInsertRT"));
                txtDiscSpec.setText(rs.getString("discInsertSpecification"));

                txtBellowHeat.setText(rs.getString("bellowHeatPart"));
                txtBellowLP.setText(rs.getString("bellowLP"));
                txtBellowMP.setText(rs.getString("bellowMP"));
                txtBellowRT.setText(rs.getString("bellowRT"));
                txtBellowSpec.setText(rs.getString("bellowSpecification"));

                txtRadioGraphy.setText(rs.getString("radiographyTest"));
                txtmagnettic.setText(rs.getString("magneticparticleTest"));
                txtOther.setText(rs.getString("other"));

            } else {
                Dialog.showForSometime("Alert", "No Data Available", "Waring", 0, 0);
                txtPoNo.getText();
                txtCustomer.getText();
                txtInspection.getText();
                txtTagNo.getText();
                txtSoNo.getText();
                txtValveCode.getText();
                txtPoSlNo.getText();
                txtCustMantNo.getText();
//                 txtSetPressure.setText(rs.getString(""));
                txtValveModel.getText();
                txtOrifice.getText();
                txtInletSpec.getText();
                txtOultLetSpec.getText();
                txtCDSPressure.getText();
                txtRelievingTemp.getText();
                txtBaclPressure.getText();

                txtSpringHeat.getText();
                txtSpringLP.getText();
                txtSpringMP.getText();
                txtSpringRT.getText();
                txtSpringSpec.getText();

                txtBodyHeat.getText();
                txtBodyLP.getText();
                txtBodyMP.getText();
                txtBodyRT.getText();
                txtBodySpec.getText();

                txtBonnetHeat.getText();
                txtBonnetLP.getText();
                txtBonnetMP.getText();
                txtBonnetRT.getText();
                txtBonnetSpec.getText();

                txtNozzleHeat.getText();
                txtNozzleLP.getText();
                txtNozzleMP.getText();
                txtNozzleRT.getText();
                txtNozzleSpec.getText();

                txtDiscHeat.getText();
                txtDiscLP.getText();
                txtDiscMP.getText();
                txtDiscRT.getText();
                txtDiscSpec.getText();

                txtBellowHeat.getText();
                txtBellowLP.getText();
                txtBellowMP.getText();
                txtBellowRT.getText();
                txtBellowSpec.getText();

                txtRadioGraphy.getText();
                txtmagnettic.getText();
                txtOther.getText();
            }
        }
    }

    @FXML
    private void txtWaterTempertureKeyRelease(KeyEvent event) {
    }

    @FXML
    private void cmbValveClassAction(ActionEvent event) {
    }

    @FXML
    private void cmbValveTypeAction(ActionEvent event) {
    }

    @FXML
    private void cmbGaugeSlNOAction(ActionEvent event) {
    }

}
