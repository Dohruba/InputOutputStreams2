import java.io.*;

public class DataOutput {
   /* public static void main(String args[]) throws IOException {
        CreateDataOutputStream();
        CreateDataInputStream();
    }*/

    private static void CreateDataOutputStream() throws IOException {
        OutputStream os = new FileOutputStream("Chicken.txt");
        DataOutputStream dos = new DataOutputStream(os);

        dos.writeShort(42);
    }

    private static void CreateDataInputStream() throws IOException{

        InputStream is = new FileInputStream("Chicken.txt");
        DataInputStream dis = new DataInputStream(is);

        int readIntValue = dis.readInt();
        System.out.println("Read integer: " + readIntValue);
    }

}
