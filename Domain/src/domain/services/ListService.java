package domain.services;

import domain.services.interfaces.FileHelper;
import domain.services.interfaces.ListHelper;

import java.util.ArrayList;
import java.util.List;

public class ListService implements ListHelper {
    private final FileHelper fileService;
    public ListService(FileHelper fileService){
        this.fileService = fileService;
    }

    public List<Integer> openList(String filePath) {
        return fileService.readFileInList(filePath);
    }

    public boolean saveList(List<Integer> list, String newFilePath) {
        return fileService.writeListInFile(list, newFilePath);
    }

    public List<Integer> doTask(List<Integer> list) {
        return createNewList(list);
    }

    private List<Integer> createNewList(List<Integer> list) {
        List<Integer> newList = new ArrayList<>();

        int item1=0, item2=0, index=0;

        while(index < list.size()){
            item1 = item2;
            item2 = index;

            if(list.get(item1) == list.get(item2)){
                if(!newList.contains(list.get(index))){
                    newList.add(list.get(index));
                }
            }else{
                newList.add(list.get(index));
            }

            index++;
        }

        return newList;
    }

    public void printList(List<Integer> list){
        System.out.println();
        for(Integer item : list){
            System.out.printf("%d ", item);
        }
    }
}
