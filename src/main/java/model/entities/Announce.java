package model.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 31409695
 */
@Entity
@Table(name = "annouce")
public class Announce implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected AnnoucePK annoucePK;
    
    @Column(name = "sold")
    private Boolean sold;
    
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    
    @JoinColumn(name = "isbn", referencedColumnName = "isbn", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Book book;

    public Announce() {
    }

    public Announce(AnnoucePK annoucePK) {
        this.annoucePK = annoucePK;
    }

    public Announce(int code, String isbn) {
        this.annoucePK = new AnnoucePK(code, isbn);
    }

    public AnnoucePK getAnnoucePK() {
        return annoucePK;
    }

    public void setAnnoucePK(AnnoucePK annoucePK) {
        this.annoucePK = annoucePK;
    }

    public Boolean getSold() {
        return sold;
    }

    public void setSold(Boolean sold) {
        this.sold = sold;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annoucePK != null ? annoucePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Announce)) {
            return false;
        }
        Announce other = (Announce) object;
        if ((this.annoucePK == null && other.annoucePK != null) || (this.annoucePK != null && !this.annoucePK.equals(other.annoucePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Annouce[ annoucePK=" + annoucePK + " ]";
    }
    
}
