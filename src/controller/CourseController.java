package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Course;

import java.io.IOException;
import java.time.LocalDate;

public class CourseController {
    //--------------------Obiekt listy kursów-----------------------------------
    ObservableList<Course> courses = FXCollections.observableArrayList();
    public static int id;
    //--------------------------------------------------------------------------
    @FXML
    private TableView<Course> tbl_course;

    @FXML
    private TableColumn<Course, String> col_course_name;

    @FXML
    private TableColumn<Course, String> col_course_category;

    @FXML
    private TextField tf_course_name;

    @FXML
    private TextField tf_course_category;

    @FXML
    private DatePicker dp_course_date;

    @FXML
    private TextField tf_course_trainer;

    @FXML
    void addCourse(ActionEvent event) {
        // walidacja danych
        if(!tf_course_name.getText().equals("") && !tf_course_category.getText().equals("") && dp_course_date.getValue() != null) {
            // pobranie wartości z kontrolki TextField
            String course_name = tf_course_name.getText();
            String course_category = tf_course_category.getText();
            LocalDate course_date = dp_course_date.getValue();
            String course_trainer = tf_course_trainer.getText();
            // utworzenie obiektu klasy Course
            Course c = new Course(++id, course_name, course_category, course_date, course_trainer);
            // wprowadzenie obiektu klasy Course do listy kursów
            courses.add(c);
            // odświeżenie TableView
            insertCoursesIntoTableView();
            // czyszczenie pól po dodaniu kursu
            tf_course_name.clear();
            tf_course_category.clear();
            dp_course_date.setValue(null);
            tf_course_trainer.clear();
        } else {
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setTitle("Błąd");
            a.setHeaderText("Błąd dodawania nowego kursu");
            a.setContentText("Musisz podać wszystkie dane w celu dodania nowego kursu");
            a.show();
        }
    }

    @FXML
    void deleteCourse(ActionEvent event) {
        // odczyt zaznaczonego rekordu z tabeli i przypisanie jego id do zmiennej
        Course c_deleted = tbl_course.getSelectionModel().getSelectedItem();
        // usuwamy zaznaczony obiekt z listy kursów
        courses.remove(c_deleted);
        // odświeżenie TableView
        insertCoursesIntoTableView();
    }
    // przekazanie obiektu statycznego do innego widoku
    static Course c_selected;
    @FXML
    void getCourse(ActionEvent event) throws IOException {
        c_selected = tbl_course.getSelectionModel().getSelectedItem();
        // wywołanie nowego widoku
        Stage courseStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("/view/detailCourseView.fxml"));
        courseStage.setTitle("Wybrany kurs");
        courseStage.setScene(new Scene(root));
        courseStage.show();
    }
    // ------------- metoda do wprowadzania zawartości listy kursów do tabelki ----------------------------------
    private void insertCoursesIntoTableView(){
        // konfiguracja zmiennych do kolumn
        col_course_name.setCellValueFactory(new PropertyValueFactory<Course,String>("course_name"));
        col_course_category.setCellValueFactory(new PropertyValueFactory<Course,String>("course_category"));
        // wprowadzenie danych do tabeli z listy ObservableList
        tbl_course.setItems(courses);
    }
    // ----------------------------------------------------------------------------------------------------------
    // metoda która urauchamia się po załądowaniu widoku jako pierwsza
    public void initialize(){
        insertCoursesIntoTableView();
    }

}
