package domain.services.interfaces;

import java.util.List;

public interface FileHelper {
    List<Integer> readFileInList(String filePath);
    boolean writeListInFile(List<Integer> list, String filePath);
}
