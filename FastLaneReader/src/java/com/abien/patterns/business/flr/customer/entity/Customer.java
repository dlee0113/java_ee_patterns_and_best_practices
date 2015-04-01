/*
 * The contents of this file are subject to the terms 
 * of the GPL License.  You may not use this file except in
 * compliance with the License. 
 * 
 * You can obtain a copy of the license at 
 * http://www.gnu.org/copyleft/gpl.html 
 * See the License for the specific language governing 
 * permissions and limitations under the License.
 * 
 * Contact: abien@adam-bien.com
 * Phone: ++49/170 280 3144
 * Homepage: www.adam-bien.com
 * Weblog: blog.adam-bien.com
 */
package com.abien.patterns.business.flr.customer.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * Entity class Customer
 * 
 * @author Adam Bien, www.adam-bien.com
 */
@Entity
@Table(name = "PAGINATED_CUSTOMER")
@NamedQueries({
    @NamedQuery(name = Customer.findAll, query = "SELECT c FROM Customer c"),
    @NamedQuery(name = Customer.findAllNames, query = "SELECT c.name FROM Customer c"),
})
public class Customer implements Serializable {
    public final static String findAll = "Customer.findAll";
    public final static String findAllNames = "Customer.findAllNames";
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer customerId;

    private String zip;

    @Column(name = "NAME")
    private String name;

    @Column(name = "ADDRESSLINE1")
    private String addressline1;

    @Column(name = "ADDRESSLINE2")
    private String addressline2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "FAX")
    private String fax;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "CREDIT_LIMIT")
    private Integer creditLimit;

     
    /** Creates a new instance of Customer */
    public Customer() {
    }

    /**
     * Creates a new instance of Customer with the specified values.
     * @param customerId the customerId of the Customer
     */
    public Customer(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Creates a new instance of Customer with the specified values.
     * @param customerId the customerId of the Customer
     * @param zip the zip of the Customer
     */
    public Customer(Integer customerId, String zip) {
        this.customerId = customerId;
        this.zip = zip;
    }

    /**
     * Gets the customerId of this Customer.
     * @return the customerId
     */
    public Integer getCustomerId() {
        return this.customerId;
    }

    /**
     * Sets the customerId of this Customer to the specified value.
     * @param customerId the new customerId
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * Gets the zip of this Customer.
     * @return the zip
     */
    public String getZip() {
        return this.zip;
    }

    /**
     * Sets the zip of this Customer to the specified value.
     * @param zip the new zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * Gets the name of this Customer.
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets the name of this Customer to the specified value.
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the addressline1 of this Customer.
     * @return the addressline1
     */
    public String getAddressline1() {
        return this.addressline1;
    }

    /**
     * Sets the addressline1 of this Customer to the specified value.
     * @param addressline1 the new addressline1
     */
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    /**
     * Gets the addressline2 of this Customer.
     * @return the addressline2
     */
    public String getAddressline2() {
        return this.addressline2;
    }

    /**
     * Sets the addressline2 of this Customer to the specified value.
     * @param addressline2 the new addressline2
     */
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    /**
     * Gets the city of this Customer.
     * @return the city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * Sets the city of this Customer to the specified value.
     * @param city the new city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state of this Customer.
     * @return the state
     */
    public String getState() {
        return this.state;
    }

    /**
     * Sets the state of this Customer to the specified value.
     * @param state the new state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the phone of this Customer.
     * @return the phone
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * Sets the phone of this Customer to the specified value.
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the fax of this Customer.
     * @return the fax
     */
    public String getFax() {
        return this.fax;
    }

    /**
     * Sets the fax of this Customer to the specified value.
     * @param fax the new fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     * Gets the email of this Customer.
     * @return the email
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Sets the email of this Customer to the specified value.
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Gets the creditLimit of this Customer.
     * @return the creditLimit
     */
    public Integer getCreditLimit() {
        return this.creditLimit;
    }

    /**
     * Sets the creditLimit of this Customer to the specified value.
     * @param creditLimit the new creditLimit
     */
    public void setCreditLimit(Integer creditLimit) {
        this.creditLimit = creditLimit;
    }


  
    /**
     * Returns a hash code value for the object.  This implementation computes 
     * a hash code value based on the id fields in this object.
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (this.customerId != null ? this.customerId.hashCode() : 0);
        return hash;
    }

    /**
     * Determines whether another object is equal to this Customer.  The result is 
     * <code>true</code> if and only if the argument is not null and is a Customer object that 
     * has the same id field values as this object.
     * @param object the reference object with which to compare
     * @return <code>true</code> if this object is the same as the argument;
     * <code>false</code> otherwise.
     */
    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer)object;
        if (this.customerId != other.customerId && (this.customerId == null || !this.customerId.equals(other.customerId))) return false;
        return true;
    }

    /**
     * Returns a string representation of the object.  This implementation constructs 
     * that representation based on the id fields.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "com.abien.javaee5patterns.paginator.customer.domain.Customer[customerId=" + customerId + "]";
    }
    
}
