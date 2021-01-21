import java.io.*;

public class PrintStreamPractice {
    public static void main(String[] args) throws IOException {

        CreatePrintStream();
        CreateBufferedReader();
    }

    private static void CreatePrintStream() throws IOException {
        OutputStream os = new FileOutputStream("Chicken.txt");

        PrintStream ps = new PrintStream(os);
        ps.println("New Stuff \nAnd so on...");
        ps.println("What?");
        ps.append("Walalala");
    }

    private static void CreateBufferedReader() throws IOException {
        InputStream is = new FileInputStream("Chicken.txt");
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);

        String readString;

        do {
            readString = br.readLine();
            if (readString != null ) System.out.println(readString);
        }while (readString != null);
    }
}
