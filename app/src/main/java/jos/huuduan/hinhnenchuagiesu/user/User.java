package jos.huuduan.hinhnenchuagiesu.user;
import java.io.Serializable;

public class User implements Serializable {
    private int resouceImage;

    public User(int resouceImage) {
        this.resouceImage = resouceImage;

    }

    public int getResouceImage() {
        return resouceImage;
    }

    public void setResouceImage(int resouceImage) {
        this.resouceImage = resouceImage;
    }


}



