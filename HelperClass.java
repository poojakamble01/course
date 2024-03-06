package com.example.coursewithdb;

public class HelperClass {
    String editName;

    public String getBtnView() {
        return btnView;
    }

    public void setBtnView(String btnView) {
        this.btnView = btnView;
    }

    String btnView;
    public HelperClass() {
    }

    public String getEditName() {
        return editName;
    }

    public void setEditName(String editName) {
        this.editName = editName;
    }



    public HelperClass(String editName) {
        this.editName = editName;
    }
}