package model.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.ColumnDefault;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author 31409695
 */
@Entity
@Table(name = "publisher")
public class Publisher implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_publisher")
    @ColumnDefault("0")
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Integer idPublisher;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher")
    private List<Book> bookList;

    public Publisher() {
    }

    public Publisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public Publisher(Integer idPublisher, String name) {
        this.idPublisher = idPublisher;
        this.name = name;
    }

    public Integer getIdPublisher() {
        return idPublisher;
    }

    public void setIdPublisher(Integer idPublisher) {
        this.idPublisher = idPublisher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPublisher != null ? idPublisher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publisher)) {
            return false;
        }
        Publisher other = (Publisher) object;
        if ((this.idPublisher == null && other.idPublisher != null) || (this.idPublisher != null && !this.idPublisher.equals(other.idPublisher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.entities.Publisher[ idPublisher=" + idPublisher + " ]";
    }
    
}
