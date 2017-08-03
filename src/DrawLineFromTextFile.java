/**
 * Created by Dave on 8/1/17.
 */

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DrawLineFromTextFile extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Robot Path");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);

        int c;
        char currentChar;
        String filepath = "/Users/Dave/IdeaProjects/DrawLineFromDirectios/output.txt";

        // starting position
        double x = 50;
        double y = 250;

        File fileToRead = new File(filepath);
        if (fileToRead.exists()) {
            try {
                // FileReader to read text files in default encoding
                FileReader fileReader = new FileReader(filepath);

                Path path = new Path();
                path.getElements().add(new MoveTo(x, y));
                path.setStrokeWidth(1);
                path.setStroke(Color.BLACK);

                while ((c = fileReader.read()) != -1) {
                    currentChar = (char) c;

                        switch (currentChar){
                            case 's':
                                x += 0.1;
                                path.getElements().add(new LineTo(x, y));
                                System.out.println(currentChar);
                                System.out.println(x + " " + y);
                                break;
                            case 'b':
                                x -= 0.1;
                                path.getElements().add(new LineTo(x, y));
                                System.out.println(currentChar);
                                System.out.println(x + " " + y);
                                break;
                            case 'l':
                                y -= 0.1;
                                path.getElements().add(new LineTo(x, y));
                                System.out.println(currentChar);
                                System.out.println(x + " " + y);
                                break;
                            case 'r':
                                y += 0.1;
                                path.getElements().add(new LineTo(x, y));
                                System.out.println(currentChar);
                                System.out.println(x + " " + y);
                                break;
                            default:
                                break;
                        }
                    }

                root.getChildren().add(path);
                primaryStage.setScene(scene);
                primaryStage.show();

                fileReader.close();
            }
            catch (IOException ex) {
                System.out.println("Unable to open file " + filepath);
            }
        }
        else {
            System.out.println("File does not exist");
        }
    }
}

