import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        BinaryCopy binaryCopy = new BinaryCopy();

        try {
            String source = binaryCopy.inputSource();
            File sourceFile = new File(source);
            if (!sourceFile.exists()) {
                throw new FileNotFoundException();
            }

            String target = binaryCopy.inputTarget();
            File targetFile = new File(target);
            if (targetFile.exists()) {
                System.out.println("Target file is already existed!");
                System.out.println("Do you want to replace ? (Y/N) : ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                if (answer == "Y") {
                    binaryCopy.copy(sourceFile, targetFile);
                } else {
                    System.out.println("Cancel!");
                }
            } else{
                binaryCopy.copy(sourceFile, targetFile);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File khong ton tai");
        }
    }
}
