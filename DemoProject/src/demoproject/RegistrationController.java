/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demoproject;

import static demoproject.Encrypt.encrypt;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
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
public class RegistrationController implements Initializable {

    private boolean hasReg = false;
    
    @FXML
    private TextField unameReg;
    @FXML
    private PasswordField pwReg;
    @FXML
    private PasswordField cpwReg;
    @FXML
    private Button btnReg;
    @FXML
    private Label msgReg;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnReg.setOnKeyPressed((event) -> {
           if(event.getCode().equals(KeyCode.ENTER)) {
               btnReg.fire();
           }    
        });
    }    

    @FXML
    private void handleReg(ActionEvent event) {
        String name = unameReg.getText().trim();
        String pass = pwReg.getText().trim();
        String cpass = cpwReg.getText().trim();
        
        if(!name.isEmpty() && !pass.isEmpty() && !cpass.isEmpty()) {
            if(pass.equals(cpass)) {
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoProjectPU");
                EntityManager em = emf.createEntityManager();
                
                Query query = em.createNamedQuery("Emp.findByUsername");
                query.setParameter("username", name);
                
                List<Emp> res = query.getResultList();
                
                if(res.isEmpty()) {
                    String encPass = encrypt(pass);
                    
                    em.getTransaction().begin();
                    Emp emp = new Emp();
                    emp.setUsername(name);
                    emp.setPassword(encPass);
                    
                    em.persist(emp);
                    
                    em.getTransaction().commit();
                    
                    hasReg = true; 
                    msgReg.setText("Successfully Registered! Click here to Login");
                    msgReg.setUnderline(true);
                    
                    em.close();
                    emf.close();
                }
                else {
                    em.close();
                    emf.close();
                    
                    msgReg.setText("Username already exists!");
                    pwReg.setText("");
                    cpwReg.setText("");                    
                }
            }
            else {
                msgReg.setText("Passwords donot match!");
            }
        }
        else {
            msgReg.setText("Please enter all credentials!");
        }
    }

    @FXML
    private void goToLogin(MouseEvent event) throws Exception {
        if(hasReg==true) {
            Parent p = FXMLLoader.load(getClass().getResource("login.fxml"));
            Stage s = (Stage) btnReg.getScene().getWindow();
            Scene sc = new Scene(p, btnReg.getScene().getWidth(), btnReg.getScene().getHeight());
            
            s.setScene(sc);
            s.setResizable(false);
            s.setTitle("Login");
            s.show();
        }
    }
    
}
