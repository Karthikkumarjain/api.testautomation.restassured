package com.employeedata.us.constants;

import lombok.Getter;

@Getter
public class FrameworkConstants {

    private FrameworkConstants() {

    }


    private static FrameworkConstants INSTANCE = null;

    public static synchronized FrameworkConstants getInstance() {

        if (INSTANCE == null) {
            INSTANCE = new FrameworkConstants();

        }
        return INSTANCE;
    }


  //  private  final String responseSchemaPath = System.getProperty("user.dir") + "schemas/json/";
      private  final String responseSchemaPath = "schemas/json/";

}
