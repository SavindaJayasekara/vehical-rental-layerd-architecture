package lk.ijse.ikmanRental.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import lk.ijse.ikmanRental.bo.BOFactory;
import lk.ijse.ikmanRental.bo.custom.AdminBO;
import lk.ijse.ikmanRental.dto.AdminDTO;
import lk.ijse.ikmanRental.util.Detail;

import java.sql.SQLException;

public class AdmineditFormController {

    public static boolean open;

    static int click;
    @FXML
    public TextField txtGmail;

    @FXML
    public PasswordField txtPassword;

    @FXML
    private TextField txtFirstName;

    @FXML
    private TextField txtLastName;

    @FXML
    private TextField txtNic;

    @FXML
    private Hyperlink hypGmail;

    @FXML
    private Hyperlink hypChange;

    @FXML
    private Hyperlink hypDelete;

    private String gmail;

    private final AdminBO adminBO= BOFactory.getInstance().getBO(BOFactory.BOTypes.ADMIN);

    @FXML
    void initialize(){
       setDetail();
       open=true;
    }

    private void setDetail() {
        gmail= Detail.getGmail();
        try {
            AdminDTO admin = adminBO.getloginDetail(gmail);
            txtFirstName.setText(admin.getFirstName());
            txtLastName.setText(admin.getLastName());
            txtPassword.setText(admin.getPassword());
            txtNic.setText(admin.getNIC());
            hypGmail.setText(gmail);
            txtGmail.setText(gmail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void hypChangeOnAction(ActionEvent actionEvent) {
        AdminDTO adminDTO = new AdminDTO(
                txtFirstName.getText(),
                txtLastName.getText(),
                txtNic.getText(),
                txtPassword.getText(),
                txtGmail.getText()
        );

        try {
            boolean isUpdate=adminBO.update(adminDTO);
            if (isUpdate){
                new Alert(Alert.AlertType.CONFIRMATION,"Success !").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,"SQL Error !").show();
            e.printStackTrace();
        }
    }

}
