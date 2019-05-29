package Bean_class;

import java.io.Serializable;

public class Orders implements Serializable {
    private String date;
    private int status;
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
