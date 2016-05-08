package model.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author 31409695
 */
@Embeddable
public class AnnouncePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbn")
    private String isbn;

    public AnnouncePK() {
    }

    public AnnouncePK(int code, String isbn) {
        this.code = code;
        this.isbn = isbn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) code;
        hash += (isbn != null ? isbn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnnouncePK)) {
            return false;
        }
        AnnouncePK other = (AnnouncePK) object;
        if (this.code != other.code) {
            return false;
        }
        if (this.isbn != other.isbn) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.AnnoucePK[ code=" + code + ", isbn=" + isbn + " ]";
    }
    
}
