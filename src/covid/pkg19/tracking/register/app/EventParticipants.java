/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package covid.pkg19.tracking.register.app;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author HP 250
 */
@Entity
@Table(name = "event_participants", catalog = "Tracking_register", schema = "")
@NamedQueries({
    @NamedQuery(name = "EventParticipants.findAll", query = "SELECT e FROM EventParticipants e"),
    @NamedQuery(name = "EventParticipants.findByUserID", query = "SELECT e FROM EventParticipants e WHERE e.userID = :userID"),
    @NamedQuery(name = "EventParticipants.findByUserName", query = "SELECT e FROM EventParticipants e WHERE e.userName = :userName"),
    @NamedQuery(name = "EventParticipants.findByUserSurname", query = "SELECT e FROM EventParticipants e WHERE e.userSurname = :userSurname"),
    @NamedQuery(name = "EventParticipants.findByContactNumber", query = "SELECT e FROM EventParticipants e WHERE e.contactNumber = :contactNumber"),
    @NamedQuery(name = "EventParticipants.findByAge", query = "SELECT e FROM EventParticipants e WHERE e.age = :age"),
    @NamedQuery(name = "EventParticipants.findByAddress", query = "SELECT e FROM EventParticipants e WHERE e.address = :address"),
    @NamedQuery(name = "EventParticipants.findByEmailAddress", query = "SELECT e FROM EventParticipants e WHERE e.emailAddress = :emailAddress"),
    @NamedQuery(name = "EventParticipants.findByTemperature", query = "SELECT e FROM EventParticipants e WHERE e.temperature = :temperature"),
    @NamedQuery(name = "EventParticipants.findByCovidSymptons", query = "SELECT e FROM EventParticipants e WHERE e.covidSymptons = :covidSymptons"),
    @NamedQuery(name = "EventParticipants.findByExposedtoanyonewithcovid", query = "SELECT e FROM EventParticipants e WHERE e.exposedtoanyonewithcovid = :exposedtoanyonewithcovid")})
public class EventParticipants implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "UserID")
    private Integer userID;
    @Basic(optional = false)
    @Column(name = "UserName")
    private String userName;
    @Column(name = "UserSurname")
    private String userSurname;
    @Column(name = "Contact_Number")
    private Integer contactNumber;
    @Column(name = "Age")
    private Integer age;
    @Column(name = "Address")
    private String address;
    @Column(name = "EmailAddress")
    private String emailAddress;
    @Column(name = "Temperature")
    private Integer temperature;
    @Column(name = "Covid_Symptons")
    private String covidSymptons;
    @Column(name = "Exposed_to_anyone_with_covid")
    private String exposedtoanyonewithcovid;

    public EventParticipants() {
    }

    public EventParticipants(Integer userID) {
        this.userID = userID;
    }

    public EventParticipants(Integer userID, String userName) {
        this.userID = userID;
        this.userName = userName;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        Integer oldUserID = this.userID;
        this.userID = userID;
        changeSupport.firePropertyChange("userID", oldUserID, userID);
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        String oldUserName = this.userName;
        this.userName = userName;
        changeSupport.firePropertyChange("userName", oldUserName, userName);
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        String oldUserSurname = this.userSurname;
        this.userSurname = userSurname;
        changeSupport.firePropertyChange("userSurname", oldUserSurname, userSurname);
    }

    public Integer getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Integer contactNumber) {
        Integer oldContactNumber = this.contactNumber;
        this.contactNumber = contactNumber;
        changeSupport.firePropertyChange("contactNumber", oldContactNumber, contactNumber);
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        Integer oldAge = this.age;
        this.age = age;
        changeSupport.firePropertyChange("age", oldAge, age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        String oldEmailAddress = this.emailAddress;
        this.emailAddress = emailAddress;
        changeSupport.firePropertyChange("emailAddress", oldEmailAddress, emailAddress);
    }

    public Integer getTemperature() {
        return temperature;
    }

    public void setTemperature(Integer temperature) {
        Integer oldTemperature = this.temperature;
        this.temperature = temperature;
        changeSupport.firePropertyChange("temperature", oldTemperature, temperature);
    }

    public String getCovidSymptons() {
        return covidSymptons;
    }

    public void setCovidSymptons(String covidSymptons) {
        String oldCovidSymptons = this.covidSymptons;
        this.covidSymptons = covidSymptons;
        changeSupport.firePropertyChange("covidSymptons", oldCovidSymptons, covidSymptons);
    }

    public String getExposedtoanyonewithcovid() {
        return exposedtoanyonewithcovid;
    }

    public void setExposedtoanyonewithcovid(String exposedtoanyonewithcovid) {
        String oldExposedtoanyonewithcovid = this.exposedtoanyonewithcovid;
        this.exposedtoanyonewithcovid = exposedtoanyonewithcovid;
        changeSupport.firePropertyChange("exposedtoanyonewithcovid", oldExposedtoanyonewithcovid, exposedtoanyonewithcovid);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userID != null ? userID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventParticipants)) {
            return false;
        }
        EventParticipants other = (EventParticipants) object;
        if ((this.userID == null && other.userID != null) || (this.userID != null && !this.userID.equals(other.userID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "covid.pkg19.tracking.register.app.EventParticipants[ userID=" + userID + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
