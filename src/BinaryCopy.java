import java.io.*;
import java.util.Scanner;

public class BinaryCopy {
    public void copy(File source, File target) throws FileNotFoundException {
        InputStream is = null;
        OutputStream os = null;
        int sumBytes = 0;

        is = new FileInputStream(source);
        os = new FileOutputStream(target);

        try {
            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                sumBytes += length;
            }
        } catch (FileNotFoundException e) {
            System.out.print("Khong tim thay file");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
                System.out.println("So byte : " + sumBytes);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    Scanner scanner = new Scanner(System.in);

    public String inputSource() {
        System.out.println("Input source file : ");
        return scanner.nextLine();
    }

    public String inputTarget() {
        System.out.println("Input target file : ");
        return scanner.nextLine();
    }
}
