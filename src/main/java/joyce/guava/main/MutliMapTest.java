package joyce.guava.main;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.Collection;

public class MutliMapTest {
    public static void main(String... args) {
        Multimap<String, String> myMultimap = ArrayListMultimap.create();

        // Adding some key/value  
        myMultimap.put("Fruits", "Bannana");
        myMultimap.put("Fruits", "Apple");
        myMultimap.put("Fruits", "Pear");
        myMultimap.put("Vegetables", "Carrot");

        // Getting the size  
        int size = myMultimap.size();
        System.out.println(size);  // 4  

        // Getting values  
        Collection<String> fruits = myMultimap.get("Fruits");
        System.out.println(fruits); // [Bannana, Apple, Pear]  

        Collection<String> vegetables = myMultimap.get("Vegetables");
        System.out.println(vegetables); // [Carrot]  

        // Iterating over entire Mutlimap  
        for (String value : myMultimap.values()) {
            System.out.println(value);
        }

        // Removing a single value  
        myMultimap.remove("Fruits", "Pear");
        System.out.println(myMultimap.get("Fruits")); // [Bannana, Pear]  

        // Remove all values for a key  
        myMultimap.removeAll("Fruits");
        System.out.println(myMultimap.get("Fruits")); // [] (Empty Collection!)  
    }


    /**
     * 去重复index_id项合并value值
     * @param array
     */
    public static JSONArray delRepeatIndexid(JSONArray array) {

        JSONArray arrayTemp = new JSONArray();

        int num = 0;
        for(int i = 0;i < array.size();i++){
            if(num==0){
                arrayTemp.add(array.get(i));
            }else{
                int numJ = 0;
                for(int j = 0;j < arrayTemp.size(); j++){
                    JSONObject newJsonObjectI = (JSONObject)array.get(i);
                    JSONObject newJsonObjectJ = (JSONObject)arrayTemp.get(j);
                    String  index_idI = newJsonObjectI.get("index_id").toString();
                    String  valueI = newJsonObjectI.get("value").toString();
                    String  timeI = newJsonObjectI.get("time").toString();
                    String  itemidI = newJsonObjectI.get("itemid").toString();

                    String  index_idJ = newJsonObjectJ.get("index_id").toString();
                    String  valueJ = newJsonObjectJ.get("value").toString();

                    if(index_idI.equals(index_idJ)){
                        int newValue = Integer.parseInt(valueI) + Integer.parseInt(valueJ);
                        arrayTemp.remove(j);
                        JSONObject newObject = new JSONObject();
                        newObject.put("index_id", index_idI);
                        newObject.put("itemid", itemidI);
                        newObject.put("time", timeI);
                        newObject.put("value", newValue);
                        arrayTemp.add(newObject);
                        break;
                    }
                    numJ++;
                }
                if(numJ-1 == arrayTemp.size()-1){
                    arrayTemp.add(array.get(i));
                }
            }

            num++;
        }
        return arrayTemp;
    }
}  