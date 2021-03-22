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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author BEL
 */
public class LoginController implements Initializable {
    
    @FXML
    private TextField unameLogin;
    @FXML
    private PasswordField pwLogin;
    @FXML
    private Button btnLogin;
    @FXML
    private Button btnRegn;
    @FXML
    private Label msgLogin;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogin.setOnKeyPressed((event) -> {
           if(event.getCode().equals(KeyCode.ENTER)) {
               btnLogin.fire();
           } 
        });
        
        btnRegn.setOnKeyPressed((event) -> {
           if(event.getCode().equals(KeyCode.ENTER)) {
               btnRegn.fire();
           } 
        });
    }    

    @FXML
    private void handleLogin(ActionEvent event) throws Exception {
        String name = unameLogin.getText().trim();
        String pass = pwLogin.getText().trim();
        
        if(!name.isEmpty() && !pass.isEmpty()) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoProjectPU");
            EntityManager em = emf.createEntityManager();
            
            Query query = em.createNamedQuery("Emp.findByUsername");
            query.setParameter("username", name);
            
            List<Emp> res = query.getResultList();
            
            if(!res.isEmpty()) {
                String encPass = encrypt(pass);
                Emp emp = res.get(0);
                
                if(emp.getPassword().equals(encPass)) {
                    
                    em.close();
                    emf.close();
                    
                    Node node = (Node) event.getSource();
                    User user = new User(emp.getEid(),emp.getUsername(), emp.getPassword());
                    
                    Parent p = FXMLLoader.load(getClass().getResource("home.fxml"));
                    Stage s = (Stage) node.getScene().getWindow();
                    Scene sc = new Scene(p, btnLogin.getScene().getWidth(), btnLogin.getScene().getHeight());
                    
                    s.setUserData(user);
                    s.setScene(sc);
                    s.setTitle("Home");
                    s.setResizable(false);
                    s.show();
                }
                else {
                    msgLogin.setText("Incorrect Password!");
                    pwLogin.setText("");
                    
                    em.close();
                    emf.close();
                }
            }
            else {
                msgLogin.setText("No such username!");
                em.close();
                emf.close();
            }
        }
        else {
            msgLogin.setText("Please enter all credentials!");
        }
    }

    @FXML
    private void goToReg(ActionEvent event) throws Exception {
        
        Parent p = FXMLLoader.load(getClass().getResource("registration.fxml"));
        
        Stage s = (Stage) btnLogin.getScene().getWindow();
        Scene sc = new Scene(p, btnLogin.getScene().getWidth(), btnLogin.getScene().getHeight());
        s.setScene(sc);
        s.setTitle("Register");
        s.setResizable(false);
        s.show();
    }
    
}
