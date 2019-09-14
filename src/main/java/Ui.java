import java.util.Scanner;

public class Ui {
    // listen for input
    // pass to the parser
    // get info from parser
    // show to the user
    private String LINE = "-------------------------";
    private String LOGO = " ____ _ \n" + "| _ \\ _ _| | _____ \n" + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| | < __/\n" + "|____/ \\__,_|_|\\_\\___|\n";
    private String LOADING_ERROR_MESSAGE = "Sorry, we encountered error loading your data. You will be using Duke fresh.";

    public Ui() {

    }

    public String readCommand() {
        System.out.printf(">>> ");
        Scanner sc = new Scanner(System.in);
        String fullCommand = sc.nextLine();
        sc.close();
        return fullCommand;
    }

    public void showWelcome() {
        System.out.println(LOGO);
        System.out.println("Hello! I'm Duke");
    }

    public void showLine() {
        System.out.println(LINE);
    }

    public void showLoadingError() {
        System.out.println(LOADING_ERROR_MESSAGE);
    }

    public void showError(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void showSuccessMessage(String action, Task t) {
        System.out.printf("%s %s successful!\n", action, t);
    }
}
