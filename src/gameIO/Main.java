package gameIO;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        File[] dir = new File[] {new File("D:\\Games/src"), new File("D:\\Games/res"),
                new File("D:\\Games/savegames"), new File("D:\\Games/temp")};
        String text = "";
        for (File dirs : dir) {
            if (dirs.mkdir()) {
                text = "Созданы папки: " + dir[0].getName() + ", " + dir[1].getName() + ", " + dir[2].getName() + ", "
                        + dir[3].getName() + "\n";
            }
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
                        " созданы в папке " + dir[0].getName();
            }
        System.out.println(text);

        try (FileWriter writer = new FileWriter("D:\\Games/temp/temp.txt", true)) {
            writer.write(text);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

