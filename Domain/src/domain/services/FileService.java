package domain.services;

import domain.services.interfaces.FileHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileService implements FileHelper {

    public List<Integer> readFileInList(String filePath){
        try(FileReader fileReader = new FileReader(filePath); Scanner scanner = new Scanner(fileReader)){
            List<Integer> list = new ArrayList<>();
            while(scanner.hasNext()){
                list.add(scanner.nextInt());
            }
            return list;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return new ArrayList<>();
        }
    }

    public boolean writeListInFile(List<Integer> list, String filePath){
        createFileIfNotExist(filePath);
        try(PrintWriter out = new PrintWriter(new FileOutputStream(filePath))){
            for(Integer item : list){
                out.printf("%d ", item);
            }
            return true;
        }catch (Exception ex){
            System.err.println(ex.getMessage());
            return false;
        }
    }

    private void createFileIfNotExist(String path){
        try{
            File file = new File(path);
            if (!file.exists()) {
                file.createNewFile();
            }
        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }
    }
}
