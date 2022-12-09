package domain.services.interfaces;

import java.util.List;

public interface ListHelper {
    List<Integer> openList(String filePath);
    boolean saveList(List<Integer> list,String newFilePath);
    List<Integer> doTask(List<Integer> list);
    void printList(List<Integer> list);
}
