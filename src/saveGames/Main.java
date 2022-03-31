package saveGames;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Main {
    public static void main(String[] args) throws IOException {
        GameProgress gameProgress1 = new GameProgress(100, 3, 5, 20.3);
        GameProgress gameProgress2 = new GameProgress(87, 4, 8, 100.6);
        GameProgress gameProgress3 = new GameProgress(50, 6, 15, 15.4);

        File file1 = new File("D://Games/savegames", "save1.txt");
        File file2 = new File("D://Games/savegames", "save2.txt");
        File file3 = new File("D://Games/savegames", "save3.txt");

           if (file1.createNewFile() &&  file2.createNewFile() && file3.createNewFile()) {
               System.out.println("Файлы созданы.");
           }



        String path1 = "D://Games/savegames/save1.txt";
        String path2 = "D://Games/savegames/save2.txt";
        String path3 = "D://Games/savegames/save3.txt";
        String archive = "D://Games/savegames/archive.zip";

        saveGame(path1, gameProgress1);
        saveGame(path2, gameProgress2);
        saveGame(path3, gameProgress3);

        List<String> path = new ArrayList<>();
        path.add(path1);
        path.add(path2);
        path.add(path3);

        zip(archive, path);

        file1.delete();

        if (file2.delete() && file3.delete()) {
            System.out.println("Файлы удлены.");
        } else {
            System.out.println("Удалить фалы не удалось.");
        }
    }

    static public void saveGame(String path, GameProgress object) {
        try (FileOutputStream fos = new FileOutputStream(path);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    static public void zip (String archive, List<String> name) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(archive))) {
            for (String value : name) {
                FileInputStream fis = new FileInputStream(value);
                ZipEntry entry = new ZipEntry(value);
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
                fis.close();
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}