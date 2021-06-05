package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main extends Application {

    private static MyGymManager myGymManager;
    private static List<DefaultMember> list;
    Button searchBtn,resetBtn;
    TableView<DefaultMember> table;
    TextField searchField;
    Label searchFieldL;
    Scene mainScene;
    ObservableList<DefaultMember> members;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gym Management System");
        list = myGymManager.getMembers();

        //button define
        searchBtn = new Button("Search");
        resetBtn = new Button("Reset");

        //button actions
        searchBtn.setOnAction(e->search(searchField.getText()));
        resetBtn.setOnAction(e->resetSearch());


        //label and text field define
        searchField = new TextField();
        searchField.setPrefSize(200,20);
        searchFieldL = new Label("Search");
        searchFieldL.setPrefWidth(50);

        createTable();

        //main Screen
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setPrefHeight(200);
        scrollPane.setContent(table);

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(searchFieldL,searchField,searchBtn,resetBtn);

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(hbox,scrollPane);

        mainScene = new Scene(layout, 1000, 400);
        primaryStage.setScene(mainScene);
        primaryStage.show();
    }

    void refreshList() {
        members.clear();
        list.forEach(member -> members.add(member));
    }


    ObservableList<DefaultMember> getMembers() {
        members  = FXCollections.observableArrayList();
        list.forEach(m->members.add(m));
        return  members;
    }

    void search(String name){
        List<DefaultMember> searchList = new ArrayList<>();
        list.forEach(m->{
            if(m.getName().contains(name)) searchList.add(m);
        });
        list = searchList;
        refreshList();
    }

    void resetSearch(){
        list = myGymManager.getMembers();
        refreshList();
    }

    void  showAlert(String title,String msg){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(200);
        window.setResizable(false);

        Label label = new Label(msg);
        Button okBtn = new Button("Okay");
        okBtn.setOnAction(e->window.close());

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label,okBtn);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();
    }

    void createTable(){
        table = new TableView<>();
        table.setPrefWidth(980);
        TableColumn<DefaultMember, String> column1 = new TableColumn<>("Membership Number");
        column1.setPrefWidth(200);
        column1.setCellValueFactory(new PropertyValueFactory<>("MembershipNumber"));
        TableColumn<DefaultMember, String> column2 = new TableColumn<>("Membership Start Date");
        column2.setPrefWidth(200);
        column2.setCellValueFactory(new PropertyValueFactory<>("StartMembershipDate"));
        TableColumn<DefaultMember, String> column3 = new TableColumn<>("Member Name");
        column3.setPrefWidth(200);
        column3.setCellValueFactory(new PropertyValueFactory<>("Name"));
        TableColumn<DefaultMember, String> column4 = new TableColumn<>("Member School");
        column4.setPrefWidth(200);
        column4.setCellValueFactory(new PropertyValueFactory<>("SchoolName"));
        TableColumn<DefaultMember, String> column5 = new TableColumn<>("Member Age");
        column5.setPrefWidth(200);
        column5.setCellValueFactory(new PropertyValueFactory<>("Age"));

        table.setItems(getMembers());

        table.getColumns().addAll(column1,column2,column3,column4,column5);

    }

    public static void AddMember(Scanner scanner){
        System.out.print("Enter Membership Number : ");
        int membershipNumber = scanner.nextInt();
        System.out.print("Enter Membership start year : ");
        int year = scanner.nextInt();
        System.out.print("Enter Membership start Month : ");
        int month = scanner.nextInt();
        System.out.print("Enter Membership start Day : ");
        int day = scanner.nextInt();
        System.out.print("Enter Member Name : ");
        String name = scanner.next();
        Date date = new Date(year,month,day);
        DefaultMember defaultMember = new DefaultMember(membershipNumber,date,name);
        myGymManager.AddMember(defaultMember);
        System.out.println();
    }

    public static void AddStudentMember(Scanner scanner){
        System.out.print("Enter Membership Number : ");
        int membershipNumber = scanner.nextInt();
        System.out.print("Enter Membership start year : ");
        int year = scanner.nextInt();
        System.out.print("Enter Membership start Month : ");
        int month = scanner.nextInt();
        System.out.print("Enter Membership start Day : ");
        int day = scanner.nextInt();
        System.out.print("Enter Member Name : ");
        String name = scanner.next();
        System.out.print("Enter Member School : ");
        String school = scanner.next();
        Date date = new Date(year,month,day);
        DefaultMember defaultMember = new StudentMember(membershipNumber,date,name,school);
        myGymManager.AddMember(defaultMember);
        System.out.println();
    }

    public static void AddOver60Member(Scanner scanner){
        System.out.print("Enter Membership Number : ");
        int membershipNumber = scanner.nextInt();
        System.out.print("Enter Membership start year : ");
        int year = scanner.nextInt();
        System.out.print("Enter Membership start Month : ");
        int month = scanner.nextInt();
        System.out.print("Enter Membership start Day : ");
        int day = scanner.nextInt();
        System.out.print("Enter Member Name : ");
        String name = scanner.next();
        System.out.print("Enter Member Age : ");
        int age = scanner.nextInt();
        Date date = new Date(year,month,day);
        DefaultMember defaultMember = new Over60Member(membershipNumber,date,name,age);
        myGymManager.AddMember(defaultMember);
        System.out.println();
    }

    public static void DeleteMember(Scanner scanner){
        List<DefaultMember> list = myGymManager.getMembers();
        myGymManager.PrintMembers();
        System.out.println("Enter Record Number to Delete :");
        int index = scanner.nextInt();
        if(index< 0 || index>= list.size())  System.out.println("Wrong choice !");
        else {
            myGymManager.DeleteMember(list.get(index));
        }
        System.out.println();
    }

    public static void main(String[] args) {
        myGymManager = new MyGymManager();
        Scanner scanner = new Scanner(System.in);

        int choice = -1;

        do {
            System.out.println("1. Add Member\n2. Add Student Member\n3. Add Over 60 Member\n4. Delete Member\n5. Print All Members\n6. Save Data\n7. Show Members\n0. Exit");
            System.out.print("Enter Choice : ");
            choice = scanner.nextInt();
            System.out.println();
            switch (choice){
                case 1: AddMember(scanner); break;
                case 2: AddStudentMember(scanner); break;
                case 3: AddOver60Member(scanner); break;
                case 4: DeleteMember(scanner); break;
                case 5: myGymManager.PrintMembers(); System.out.println("Input any and press enter to continue..."); scanner.next();break;
                case 6:
                    try {
                        myGymManager.Save("Members.txt");
                    } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("Error : " + e);
                    }
                    System.out.println();
                    break;
                case 7: launch(args);
                case 0: return;
                default: System.out.println("Wrong choice !");
            }
        }while (choice!= 0);
    }
}
