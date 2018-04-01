package hw.second.part1;

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-3-31
 * Description:
 * <p>
 * -----------------------
 */
public class fileOperate {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private File f;
    public fileOperate() throws IOException {
        f = new File("fan.txt");
        if (!f.exists()) try {
            f.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public LinkedList<PIMEntity> loadAll(){
        LinkedList list = new LinkedList();
        list.clear();
        try {
            PIMEntity p;
            in = new ObjectInputStream(new FileInputStream(f));
            while (true){
                p = (PIMEntity) in.readObject();
                if (p != null) list.add(p);
//                Set set = new HashSet(list);
//                list.clear();
//                list.addAll(set);
            }
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return list;
        }

    }
    public void saveAll(LinkedList<PIMEntity> list){
        try {

            int size = list.size();

//            Set set = new HashSet(list);
//            list.clear();
//            list.addAll(set);

            out = new ObjectOutputStream(new FileOutputStream(f));
            for (int i = 0;i < size;i++){
                out.writeObject(list.get(i));
                out.flush();
//                System.out.println(i);
            }
            list.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
