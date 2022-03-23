package gameIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File dir = new File("D:\\Games/src");
        File dir1 = new File("D:\\Games/res");
        File dir2 = new File("D:\\Games/savegames");
        File dir3 = new File("D:\\Games/temp");
        String text = "";
            if (dir.mkdir() && dir1.mkdir() && dir2.mkdir() && dir3.mkdir()) {
                text = "Созданы папки: " + dir.getName() + ", " + dir1.getName() + ", " + dir2.getName() + ", "
                        + dir3.getName() + "\n";
            }

        File dir4 = new File("D:\\Games/src/main");
        File dir5 = new File("D:\\Games/src/test");
            if (dir4.mkdir() && dir5.mkdir()) {
                text += "Папки " + dir4.getName() + " и " + dir5.getName() + " созданы в src." + "\n";
            }
        try {
            File file = new File(dir4, "Main.java");
            File file1 = new File(dir4, "Utils.java");
            if (file.createNewFile() && file1.createNewFile()) {
                text += "Файлы созданы в папке " + dir4.getName() + ".\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        File dir6 = new File("D:\\Games/res/drawables");
        File dir7 = new File("D:\\Games/res/vectors");
        File dir8 = new File("D:\\Games/res/icons");
            if (dir6.mkdir() && dir7.mkdir() && dir8.mkdir()) {
                text += "Папки " + dir6.getName() + ", " + dir7.getName() + ", " + dir8.getName() +
                        " созданы в папке " + dir1.getName();
            }
        System.out.println(text);

        try (FileWriter writer = new FileWriter("D:\\Games/temp/temp.txt", true)) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

