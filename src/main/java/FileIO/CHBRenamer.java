package FileIO;

import java.io.File;

public class CHBRenamer {

    public static void main(String[] args) {
        String path = "C:\\Users\\hyb\\Desktop\\1"; // 要批量修改的文件所在的目录
        File file = new File(path);
        boolean isDirectory = file.isDirectory();
        if (!isDirectory) { // 如果不是文件夹，就返回
            System.out.println(path + "不是文件夹！");
            return;
        }
        String[] files = file.list();
        File f = null;
        String newFileName = ""; // 新的文件名字
        String oldFileName = ""; // 旧的文件名字
        for (int i = 0; i < files.length; i++) { // 遍历该文件夹下的所有文件
            oldFileName = files[i];
            // 如果不是以特定形式开头的文件，跳过它
//            if (!oldFileName.contains("[迅雷下载www.2tu.cc]"))
//                continue;

            /**
             * 重新生成修改后的文件名称
             * 我这里统一将"[迅雷下载www.2tu.cc]爱情公寓EP02.03.rmvb"
             * 修改为"爱情公寓第二季-03.rmvb"
             */
//            newFileName = " ";
//            newFileName += oldFileName.substring(oldFileName.indexOf("P")+3, oldFileName.length());
            newFileName = i+".jpg";
            // 将修改后的文件保存在原目录下
            f = new File(path + "/" + oldFileName);
            f.renameTo(new File(path + "/" + newFileName));
        }
    }

}