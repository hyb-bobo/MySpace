package Clone;

public class TestVoB {

    private int sex;
    public TestVoB(int sex){
        this.sex = sex;
    }
    
    public void sumValue(){
        this.sex += 10;
    }
    
    public String toString(){
        return Integer.toString(sex);
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

}