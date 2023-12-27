package com.example.springmodels.dublicateModel;

import com.example.springmodels.models.Application;
import com.example.springmodels.models.ModelUser;

import javax.persistence.Column;
import java.time.LocalDate;

public class ApplicationMemory {
    private int id;
    private String reason;
    private String text;
    private LocalDate localDate = LocalDate.now();

    private long user_id;

    public ApplicationMemory(Application application) {
        this.id = application.getId();
        this.reason = application.getReason();
        this.text = application.getText();
        this.user_id = application.getPerson().getID_User();
    }

    public ApplicationMemory() {
    }

    public ApplicationMemory(int id, String reason, String text, LocalDate localDate) {
        this.id = id;
        this.reason = reason;
        this.text = text;
        this.localDate = localDate;
    }

    public ApplicationMemory(int id, String reason, String text, LocalDate localDate, long user_id) {
        this.id = id;
        this.reason = reason;
        this.text = text;
        this.localDate = localDate;
        this.user_id = user_id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
}
