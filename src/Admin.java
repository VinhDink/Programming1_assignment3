import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
    Scanner fileScanner = null;

    //Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //Getter
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    //Setter

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean validateAccount() {
        try {
            fileScanner = new Scanner(new File("src/data/admin.txt"));
            while (fileScanner.hasNext()) {
                String[] arr = fileScanner.nextLine().split(",");
                if (username.equals(arr[0]) && password.equals(arr[1])) {
                    System.out.println("Login successfully!");
                    return true;
                } else System.out.println("Wrong password or username!");
            }
        }  catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }finally {
            fileScanner.close();
        }

        return false;
    }
}


