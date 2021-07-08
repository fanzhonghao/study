package exerice.newPIM;

import exerice.dbOperate.DBoperate;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-28
 * Description:
 * <p>
 * -----------------------
 */
public class PIMDelete {
    private PIMEntity pimEntity;
    public PIMDelete(PIMEntity pimEntity){
        this.pimEntity = pimEntity;
    }
    public void delete(){
        String type = pimEntity.getClass().toString().substring(24);
        DBoperate dBoperate = new DBoperate();
        dBoperate.connect();
        dBoperate.delete(type,pimEntity.toString());
    }
}
