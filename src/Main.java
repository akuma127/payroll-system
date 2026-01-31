//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import javafx.application.Application;
import view.LoginUI;
//import view.PayrollApp;
public class Main {
    public static void main(String[] args) {

        String currentDir = System.getProperty("user.dir");
        System.out.println("Current working directory: " + currentDir);
        Application.launch(LoginUI.class, args);

    }
}
