package joyce.guava.main;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.sf.json.JSONObject;

/**
 * Author: hyb
 * Date: Created in 2018/5/18 15:08
 */
public class MakeSale {

    public static final String[] fieldToAdd = new String[]{
            "AuditStatusEnum", "标准方案_设备_明细表",
            "AuditStatusEnum", "标准方案_设备_明细表",
            "AuditStatusEnum", "标准方案_设备_明细表",
            "AuditStatusEnum", "标准方案_设备_明细表"
    };

    public static void main(String[] args) {

        for (int i=0;i<fieldToAdd.length;i+=2){
            getEnum(fieldToAdd[i],fieldToAdd[i+1]);
            System.out.println("------------------------------------------");
        }


    }

    public static void getEnum(String keyName , String keyNameExplain) {

        System.out.println(toLowerCaseFirstOne(keyName)+"\t\t\t\t\t:[],/*"+keyNameExplain+"*/");

        System.out.println();

        System.out.println("|| base_info."+toLowerCaseFirstOne(keyName)+".length == 0");
        System.out.println();

        System.out.println("/*"+keyNameExplain+"*/");
        System.out.println("obj.put(\""+toLowerCaseFirstOne(keyName)+"\","+keyName+".toJsonArr());");
        System.out.println();
        System.out.println();

        String anEnum = keyName.substring(0, keyName.indexOf("Enum"));
        anEnum = toLowerCaseFirstOne(anEnum);
        System.out.println("@ApiOperation(value = \""+keyNameExplain+"\")");
        System.out.println("@RequestMapping(value = "+""+"\"/"+anEnum+"\", method = RequestMethod.GET)");
        System.out.println("public @ResponseBody");
        System.out.print("JSONObject "+anEnum+"(){");
        System.out.println("return RCode.returnSUCCESS("+keyName+".toJsonArr());}");
        System.out.println();

    }

    public static String toLowerCaseFirstOne(String s){
        if(Character.isLowerCase(s.charAt(0)))
            return s;
        else
            return (new StringBuilder()).append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}
