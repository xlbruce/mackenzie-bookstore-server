/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class AnnoucePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isbn")
    private int isbn;

    public AnnoucePK() {
    }

    public AnnoucePK(int code, int isbn) {
        this.code = code;
        this.isbn = isbn;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) code;
        hash += (int) isbn;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnnoucePK)) {
            return false;
        }
        AnnoucePK other = (AnnoucePK) object;
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
