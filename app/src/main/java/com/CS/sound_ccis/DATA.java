package com.CS.sound_ccis;

import android.widget.EditText;

public class DATA {

    String DataBase;
    String Value;
    EditText editText;

   
    public DATA(String dataBase, EditText editText) {
        DataBase = dataBase;
        this.editText = editText;
    }

    public DATA(String dataBase, String value) {
        DataBase = dataBase;
        Value = value;
    }


}
