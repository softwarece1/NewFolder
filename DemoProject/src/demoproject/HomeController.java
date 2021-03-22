package demoproject;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class HomeController implements Initializable {

    @FXML
    private Button btnLogOut;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        btnLogOut.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                btnLogOut.fire();
            }
        });

        btnUpdate.setOnKeyPressed((event) -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                btnLogOut.fire();
            }
        });

        btnDelete.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                btnDelete.fire();
            }
        });
    }

    @FXML
    private void goToLogin(ActionEvent event) throws Exception {

        Node node = (Node) event.getSource();
        Stage s = (Stage) node.getScene().getWindow();
        User user = (User) s.getUserData();
        user = null;
        s.setUserData(user);
        System.gc();

        Parent p = FXMLLoader.load(getClass().getResource("login.fxml"));
        Scene sc = new Scene(p, btnLogOut.getScene().getWidth(), btnLogOut.getScene().getHeight());

        s.setScene(sc);
        s.setResizable(false);
        s.setTitle("Login");
        s.show();
    }

    @FXML
    private void goToUpdate(ActionEvent event) throws Exception {

        Parent p = FXMLLoader.load(getClass().getResource("update.fxml"));
        Stage s = (Stage) btnLogOut.getScene().getWindow();
        Scene sc = new Scene(p, btnLogOut.getScene().getWidth(), btnLogOut.getScene().getHeight());

        s.setScene(sc);
        s.setResizable(false);
        s.setTitle("Login");
        s.show();
    }

    @FXML
    private void handleDelete(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage s = (Stage) node.getScene().getWindow();

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("CAUTION");
        alert.setContentText("Account Deletion is irrevocable. Proceed?");
        alert.setHeaderText(null);
        alert.setResizable(false);

        Optional<ButtonType> result = alert.showAndWait();
        if (!result.isPresent()) // alert is exited, no button has been pressed.
        {
        } else if (result.get() == ButtonType.OK) {
            //deleting the account
            User user = (User) s.getUserData();
            System.out.println(user);

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("DemoProjectPU");
            EntityManager em = emf.createEntityManager();

            Query query = em.createNamedQuery("Emp.deleteByEid").setParameter("eid", user.getEid());

            em.getTransaction().begin();
            query.executeUpdate();
            em.getTransaction().commit();

            em.close();
            emf.close();

            try {
                goToLogin(event);
                Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success");
                alert.setContentText("Account has been deleted.");
                alert.setHeaderText(null);
                alert.setResizable(false);
                alert.showAndWait();
            } catch (Exception ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (result.get() == ButtonType.CANCEL) // cancel button is pressed
        {
            alert.close();
        }
    }
}
