package Java多线程核心技术;

/**
 * Author: hyb
 * Date: Created in 2018/4/28 10:38
 */
public class PublicClass {
    private String userName;
    private String passWord;
    class PrivateClass{
        private String age;
        private String address;

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
        public void printPublicProperty(){
            System.out.println(userName+"  "+passWord);
        }
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public static void main(String[] args){
        PublicClass publicClass = new PublicClass();
        publicClass.setUserName("name");
        publicClass.setPassWord("pass");
        System.out.println(publicClass.getUserName()+"  "+publicClass.getPassWord());
        PrivateClass privateClass = publicClass.new PrivateClass();
        privateClass.setAddress("address");
        privateClass.setAge("age");
        System.out.println(privateClass.getAddress()+"  "+privateClass.getAge());
    }
}
