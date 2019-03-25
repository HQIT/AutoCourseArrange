package com.github.arrange.utils;

import java.io.*;

public class CloneUtils {
    /**
     * 实现对象的深复制
     * @param obj
     * @param <T>
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj){
        T clonedObj = null;
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            clonedObj = (T) ois.readObject();
            ois.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return clonedObj;
    }
}
