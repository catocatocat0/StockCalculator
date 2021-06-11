package catocatocato.StockCalculator.FileManagement;

import org.jetbrains.annotations.Nullable;

import java.io.*;

@SuppressWarnings("ResultOfMethodCallIgnored")
public class FileManagement {
    /*
    this method initializes a file inside of a directory.
    then it returns that file as a File object.
    should the file already exist, it will not overwrite it.

    directory - relative directory to the compiled program
    fileName - name of the file

    returns the file as a File object
     */
    public File selectAndInitializeFile(String directory, String fileName) throws IOException {
        File file;

        String filePath = directory + "\\";

        File fileDirectory = new File(filePath);

        //if the path doesn't exist then make it
        if (!fileDirectory.exists()) {
            fileDirectory.mkdir();
        }

        //this makes sure the file will have a file extension
        if (!fileName.contains(".")) {
            fileName += ".txt";
        }

        //create the file in that path with that name
        file = new File(filePath, fileName);

        //if the file doesn't exist, then make it
        if (!file.exists()) {
            file.createNewFile();
        }

        return file;
    }

    /*
    this checks and sees if a file exists given
    the file's directory and name.

    fileDirectory - relative directory to the compiled program
    fileName - name of the file

    returns a boolean that's true if the file exists
     */

    public boolean checkFileExists(String fileDirectory, String fileName){

        String filePath = fileDirectory+"\\";

        File file = new File(filePath, fileName);

        return file.exists();
    }

    /*
    writes raw data to the a file object as well as potentially prompting a message.
    this method does not close the buffer stream which has to be done outside the method.

    file - a BufferedWriter containing the file we want to write to

    data - the data we want to write to the file

    ignoreWarning - ignores the warning if data is an empty string when true
     */
    public void writeData(BufferedWriter file, String data, @Nullable boolean ignoreWarning) throws IOException{

        if(!data.equals("")){
            file.write(data);
        }else if(ignoreWarning){
            System.out.println("Data is empty!");
        }
    }

    /*
    reads and returns the file's contents. returns null if file does not exist

    file - File object to extract data from

    returns a BufferedReader with the file's contents
     */
    public BufferedReader readData(File file){

        BufferedReader outputReader = null;

        try{

            outputReader = new BufferedReader(new FileReader(file));
        }catch(FileNotFoundException e){

            e.printStackTrace();
            System.out.println(file.getName()+" Does not exist!");
        }

        return outputReader;
    }
}
