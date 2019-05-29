package action;


import Service.employeeservice;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class UploadPicture extends ActionSupport {
    private File myFile;
    public File getMyFile() {
        return myFile;
    }
    public void setMyFile(File myFile) {
        this.myFile = myFile;
    }
    private String myFileContentType;
    private String myFileFileName;
    public String getMyFileContentType() {
        return myFileContentType;
    }
    public void setMyFileContentType(String myFileContentType) {
        this.myFileContentType = myFileContentType;
    }
    public String getMyFileFileName() {
        return myFileFileName;
    }
    public void setMyFileFileName(String myFileFileName) {
        this.myFileFileName = myFileFileName;
    }
    private String destPath;
    employeeservice employeeservice=new employeeservice();

    public String execute() {
        /* Copy file to a safe location */
        HttpServletRequest request = ServletActionContext.getRequest();
        int ID= Integer.parseInt(request.getParameter("id"));
        destPath = "D:\\work\\Project\\pet\\background_system\\web\\employee";
        try{
            System.out.println("Src File name: " + myFile);
            System.out.println("Dst File name: " + myFileFileName);
            File destFile  = new File(destPath, myFileFileName);
            FileUtils.copyFile(myFile, destFile);
        }catch(IOException e){
            e.printStackTrace();
            return ERROR;
        }
        String photo=myFileFileName;
        employeeservice.add_pic(photo,ID);
        return SUCCESS;
//        System.out.print(getMyFile());
//        HttpServletRequest request = ServletActionContext.getRequest();
//        int ID= Integer.parseInt(request.getParameter("id"));
//        try {
//            //将该图片转为二进制输入流（关键点二）
//            FileInputStream fis = new FileInputStream(getMyFile());
//            //设置一个byte数组，数组长度为该图片的字节数目（关键点三）
//            byte[] content = new byte[fis.available()];
//            //二进制流输入到数组（关键点四）
//            fis.read(content);
//            DAOImpl.add_pic(content,ID);
//            System.out.print(content);
//            try {
//                s = sf.openSession();
//                t = s.beginTransaction();
//                String hql="update employee set photo=:p where ID=:i";
//                SQLQuery query = s.createSQLQuery(hql);
//                query.setBinary("p",content);
//                query.setInteger("i",ID);
//                t.commit();
//            } catch ( Exception e){
//                e.printStackTrace();
//            }
//            s.close();
//            sf.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return ERROR;
//        }
    }

}
