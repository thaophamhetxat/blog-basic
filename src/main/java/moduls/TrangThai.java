package moduls;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class TrangThai {
    int idTrangThai;
    String nameTrangThai;

    public TrangThai() {
    }

    public TrangThai(int idTrangThai, String nameTrangThai) {
        this.idTrangThai = idTrangThai;
        this.nameTrangThai = nameTrangThai;
    }

    public int getIdTrangThai() {
        return idTrangThai;
    }

    public void setIdTrangThai(int idTrangThai) {
        this.idTrangThai = idTrangThai;
    }

    public String getNameTrangThai() {
        return nameTrangThai;
    }

    public void setNameTrangThai(String nameTrangThai) {
        this.nameTrangThai = nameTrangThai;
    }
}
