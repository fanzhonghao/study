package exerice.newPIM;

import exerice.dbOperate.DBoperate;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-27
 * Description:
 * <p>
 * -----------------------
 */
public class PIMSave {
    PIMEntity pimEntity;
    public PIMSave(PIMEntity pimEntity){
        this.pimEntity = pimEntity;
    }
    public boolean save(){
        boolean flag = false;
        DBoperate dBoperate = new DBoperate();
        dBoperate.connect();
        if (pimEntity instanceof PIMTodo){
            dBoperate.insert("todo",pimEntity.toString());
            flag = true;
        }else if (pimEntity instanceof PIMNote){
            dBoperate.insert("note",pimEntity.toString());
            flag = true;
        }else if (pimEntity instanceof PIMContact){
            dBoperate.insert("contact",pimEntity.toString());
            flag = true;
        }else if (pimEntity instanceof PIMAppointment){
            dBoperate.insert("appointment",pimEntity.toString());
            flag = true;
        }
        return flag;
    }
}
