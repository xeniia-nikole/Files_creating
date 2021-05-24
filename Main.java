package Files;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
    public static StringBuilder str = new StringBuilder();
    public static String FILEPATH = "C:/Users/503242115/IdeaProjects/Initial" + File.separator;

    public static void main(String[] args) {
        addDir(FILEPATH + "Games");
        addDir(FILEPATH + "Games/src");
        addDir(FILEPATH + "Games/res");
        addDir(FILEPATH + "Games/res/drawables");
        addDir(FILEPATH + "Games/res/vectors");
        addDir(FILEPATH + "Games/res/icons");
        addDir(FILEPATH + "Games/savegames");
        addDir(FILEPATH + "Games/src/main");
        addDir(FILEPATH + "Games/src/test");
        addDir(FILEPATH + "Games/temp");

        addFile(FILEPATH + "Games/src/main//Main.java");
        addFile(FILEPATH + "Games/src/main//Utils.java");

        File temp_txt = new File(FILEPATH + "Games/temp//temp.txt");
        try {
            if (temp_txt.createNewFile()) System.out.println(">> File 'temp.txt' was successfully created");
            str.append("\n>> File 'temp.txt' was successfully created");
            try (FileOutputStream fos = new FileOutputStream(temp_txt)) {
                byte[] bytes = str.toString().getBytes();
                fos.write(bytes, 0, bytes.length);
            } catch (IOException io) {
                System.out.println(io.getMessage());
            }
            ;
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }

    private static StringBuilder addFile(String fileName) {
        File file = new File(fileName);
        try {
            if (file.createNewFile()) System.out.println(">> File '" + fileName + "' was successfully created");
            str.append("\n>> File '" + fileName + "' was successfully created");
        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
        return str;
    }

    private static StringBuilder addDir(String dirName) {
        File dir = new File(dirName);
        if (dir.mkdir()) System.out.println(">> Dir '" + dirName + "' was successfully created");
        str.append("\n>> Dir '" + dirName + "' was successfully created");
        return str;
    }
}

