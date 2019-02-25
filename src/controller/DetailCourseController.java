package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class DetailCourseController {

    @FXML
    private Label lbl_course_name;

    @FXML
    private Label lbl_course_category;

    @FXML
    private Label lbl_course_date;

    @FXML
    private Label lbl_course_trainer;

    @FXML
    private Label lbl_course_particip;

    @FXML
    private TextField tf_particip_name;

    @FXML
    private TextField tf_particip_lastname;

    @FXML
    private TableView<?> tbl_particip;

    @FXML
    private TableColumn<?, ?> col_particip_name;

    @FXML
    private TableColumn<?, ?> col_particip_lastname;

    @FXML
    void deleteParticipant(ActionEvent event) {

    }

    @FXML
    void saveParticipant(ActionEvent event) {

    }

}
