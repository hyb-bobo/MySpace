package Clone;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by hyb on 2018/8/27.
 */
public class Arr {
    public  static void main(String args[]){
//集合一
        List<String> _first=new ArrayList<String>();
        _first.add("jim");
        _first.add("tom");
        _first.add("jack");
//集合二
        List<String> _second=new ArrayList<String>();
        _second.add("jack");
        _second.add("happy");
        _second.add("sun");
        _second.add("good");

        Collection exists=new ArrayList<String>(_second);
        Collection notexists=new ArrayList<String>(_second);

        exists.removeAll(_first);
        System.out.println("_second中不存在于_set中的："+exists);
        notexists.removeAll(exists);
        System.out.println("_second中存在于_set中的："+notexists);
    }
}
