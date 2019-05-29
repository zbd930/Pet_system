package service;

import Bean_class.Dog;
import dbcp.dbcp;

import java.math.BigDecimal;

public class dogfileservice {

    public  void insert_t1(Dog dog) {
        dbcp dbcp =new dbcp();
        //System.out.print(dog.getUser_Name());
        dbcp.insert_dogfile(dog.getUser_Name(),dog.getDogName(),dog.getPicture(),dog.getDogcategory());

    }
    public void insert_t2(Dog dog){
                dbcp dbcp=new dbcp();
                int sex=0;
                BigDecimal big=null;
                big=new BigDecimal(dog.getDogweight());
                if (dog.getDogsex()=="female"){
                  sex=1;
                  dbcp.insert_filedetails(dog.getUser_Name(),sex,big,dog.getDogbirthday());
                }else if(dog.getDogsex()=="male"){
                   sex=2;
                   dbcp.insert_filedetails(dog.getUser_Name(),sex,big,dog.getDogbirthday());
                }
    }

}
