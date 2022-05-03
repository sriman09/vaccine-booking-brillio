package com.sriman.vaccinationschedulesystem.Vaccination;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sriman.vaccinationschedulesystem.Patient.Patient;

import javax.persistence.*;

@Entity
public class Vaccination {
    @Id
    @GeneratedValue
    private int id;

    private String vaccination;
    private String dateAdministrated;
    private String vaccineBrand;
    private String givenAt;

    @ManyToOne
    @JsonIgnore
    private Patient patient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVaccination() {
        return vaccination;
    }

    public void setVaccination(String vaccination) {
        this.vaccination = vaccination;
    }

    public String getDateAdministrated() {
        return dateAdministrated;
    }

    public void setDateAdministrated(String dateAdministrated) {
        this.dateAdministrated = dateAdministrated;
    }

    public String getVaccineBrand() {
        return vaccineBrand;
    }

    public void setVaccineBrand(String vaccineBrand) {
        this.vaccineBrand = vaccineBrand;
    }

    public String getGivenAt() {
        return givenAt;
    }

    public void setGivenAt(String givenAt) {
        this.givenAt = givenAt;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
