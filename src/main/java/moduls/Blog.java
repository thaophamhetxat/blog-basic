package moduls;
import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    Date date;
    String name;
    @Column(columnDefinition = "TEXT")
    String image;
    String fileNhac;
    String binhLuan;
    String trangThai;


    public Blog() {
    }

    public Blog(int id, Date date, String name, String image, String fileNhac, String binhLuan, String trangThai) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.image = image;
        this.fileNhac = fileNhac;
        this.binhLuan = binhLuan;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFileNhac() {
        return fileNhac;
    }

    public void setFileNhac(String fileNhac) {
        this.fileNhac = fileNhac;
    }
}
