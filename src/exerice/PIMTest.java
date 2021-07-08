package exerice;


import exerice.newPIM.*;

/**
 * ----------------------
 *
 * @Author:fan
 * @Date: 18-5-26
 * Description:
 * <p>
 * -----------------------
 */
public class PIMTest {
    public static void main(String[] args) {
        StringBuffer type = new StringBuffer();
        PIMEntity p = new PIMNote();
        type.append(p.getClass());
        p.fromString("owner:"+ "fan" + "##" + "whetherPublic:" + "true" + "##" + "priority:" + "normal" +
                "##" + "data:" + "note data first");
        System.out.println(p.toString());
        p = new PIMContact();

        p.fromString("owner:"+ "fan" + "##" + "whetherPublic:" + false + "##" + "priority:" + "urgent" +
                "##" + "firstName:" + "fan" + "##" + "lastName:" + "Li" + "##" + "emailAddress:" +
                "1412328318@qq.com");
        System.out.println(p.toString());
        p = new PIMTodo();

        p.fromString("owner:"+ "fan" + "##" + "whetherPublic:" + "true" + "##" + "priority:" + "normal" +
                "##" + "date:" + "04/28/2018" + "##" + "data:" + "todo data");
        System.out.println(p.toString());
        p = new PIMAppointment();

        p.fromString("owner:"+ "fan" + "##" + "whetherPublic:" + false + "##" + "priority:" + "urgent" +
                "##" + "date:" + "05/26/2018" + "##" + "description:" + "appointment data");
        System.out.println(p.toString());

    }
}
