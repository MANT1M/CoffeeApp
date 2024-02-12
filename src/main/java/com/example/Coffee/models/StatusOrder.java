package com.example.Coffee.models;

public enum StatusOrder {

        REG(0),
        IN_PROCESS(1),
        READY(2),
        DONE(3),
        CANCEL(-1);


        private int value;
        StatusOrder(int value){
            this.value = value;
        }

        public int getValue() {
            return value;
        }

}
