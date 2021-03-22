/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import static demoproject.Encrypt.encrypt;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * FXML Controller class
 *
 * @author BEL
 */
public class UpdateController implements Initializable {

    @FXML
    private Button btnBack;
    @FXML
    private Button btnUpdate;
    @FXML
    private PasswordField pwUpdate;
    @FXML
    private PasswordField cpwUpdate;
    @FXML
    private Label msgUpdate;
    @FXML
    private PasswordField opwUpdate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnUpdate.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                btnUpdate.fire();
            }
        });

        btnBack.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                btnBack.fire();
            }
        });
    }

    @FXML
    private void goBack(ActionEvent event) throws Exception {
        Node node = (Node) event.getSource();
        Parent p = FXMLLoader.load(getClass().getResource("home.fxml"));
        Stage s = (Stage) node.getScene().getWindow();
        Scene sc = new Scene(p, node.getScene().getWidth(), node.getScene().getHeight());

        s.setScene(sc);
        s.setResizable(false);
        s.setTitle("Login");
        s.show();
    }

    @FXML
    private void handleUpdate(ActionEvent event) {
        
        String oldpw = opwUpdate.getText().trim();
        String pw = pwUpdate.getText().trim();
        String cpw = cpwUpdate.getText().trim();
        
        if(!oldpw.isEmpty() && !pw.isEmpty() && !cpw.isEmpty()) {
            
            Node node = (Node) event.getSource();
            Stage s = (Stage) node.getScene().getWindow();
            User user = (User) s.getUserData();
            
            if(encrypt(oldpw).equals(user.getPassword())) {
                
                if(pw.equals(cpw)) {

                    String ePw = encrypt(pw);
                    EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoProjectPU");
                    EntityManager em = emf.createEntityManager();

                    //Method 1
                    Query query = em.createNamedQuery("Emp.updatePassword").setParameter("password",ePw).setParameter("username",user.getUsername());
                    
                    em.getTransaction().begin();
                    query.executeUpdate();
                    em.getTransaction().commit();

//                    //Method 2
//                    Emp emp = em.find(Emp.class, user.getEid());
//                    emp.setPassword(ePw);
//
//                    em.getTransaction().begin();
//                    em.persist(emp);
//                    em.getTransaction().commit();

                    msgUpdate.setText("Password updated!");
                    user.setPassword(ePw);
                    s.setUserData(user);
                    
                    em.close();
                    emf.close();

                }
                else {
                    msgUpdate.setText("Password do not match!");
                }
            }
            else {
                msgUpdate.setText("Old Password is wrong!");
            }
            
        }
        else {
            msgUpdate.setText("Please enter all credentials!");
        }
    }

}
