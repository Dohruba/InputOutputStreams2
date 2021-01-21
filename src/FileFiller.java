import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileFiller {

    public static void main(String[] args ) throws IOException {

        String filename = "Chicken.txt";
        createFileOutputstream(filename);
        ReadFromFile(filename);

    }

    public static void createFileOutputstream(String filename){

        OutputStream os = null;

        try{
            os = new FileOutputStream(filename);
        } catch (FileNotFoundException ex){
            System.err.println("FileNotFound. Making file.");
            File file = new File("Chicken.txt");
            System.exit(0);
        }

        String text = "Something important.Manana\n";
        byte[] textAsByte = text.getBytes(StandardCharsets.US_ASCII);

        //Experimetn, two inputs

        String text2 = "Lalalalala chicken monono.";
        byte[] textAsByte2 = text2.getBytes(StandardCharsets.UTF_8);

        try {
            //Aqui es donde se escribe la información en el archivo (O puerto o lo que sea)
            //Overrides
            os.write(textAsByte);
            os.write(textAsByte2);
        } catch (IOException ex){
            System.err.println("Couldn´t write data.");
            System.exit(0);
        }
    }

    public static void ReadFromFile(String filename) throws IOException {
        InputStream is = null;
        try {
            is = new FileInputStream(filename);
        }catch(IOException ex){
            System.err.println("Couldn´t find file.");
            System.exit(0);
        }

        //Version1
        readDataFromFileOnBuffer(is);
    }


    private static void readDataFromFileOnBuffer(InputStream is) throws IOException{

        //        byte[] readBuffer = new byte[10];
        byte[] readBuffer = new byte[100]; //With this, only 10 chars are read, saved and printed. The rest,
        //from the same Inputstream, are still in the pipe and can be read by the second method.
        try {
            //Aquí se llena el el buffer con lo que lee el InputStream
            is.read(readBuffer);
        } catch (IOException ex){
            System.err.println("Couldn´t read");
            System.exit(0);
        }

        //Stuff goes from  byte to string just like that :D
        String readString = new String(readBuffer);
        System.out.println("Read something: " + readString);
        WriteOnNewFilePerBuffer(readBuffer, "SecondChicken.txt");
    }


    private static void WriteOnNewFilePerBuffer(byte[] buffer, String filename) throws IOException {
        OutputStream os = new FileOutputStream(filename);
        String text = new String(buffer);
        byte[] output = text.getBytes(StandardCharsets.UTF_8);
        os.write(output);
    }

}
