package com.example.a4serve;

public class EventsList {
    private static Events[] list;
//    public EventsList(int num){
//        list = new Events[num];
////        for(int i=0; i<num; i++){
////            list[i] = new Events("Event", 03172020, R.drawable.ic_person_black_24dp);
////        }
//    }

    public EventsList(){
        list = new Events[10];
        list[0] = new Events("One", 03022020, R.drawable.grape);
        list[1] = new Events("Two", 03022020, R.drawable.kiwi);
        list[2] = new Events("Three", 03022020, R.drawable.lemon);
        list[3] = new Events("Four", 03022020, R.drawable.mango);
        list[4] = new Events("Five", 03022020, R.drawable.watermelon);
        list[5] = new Events("Six", 03022020, R.drawable.grape);
        list[6] = new Events("Seven", 03022020, R.drawable.kiwi);
        list[7] = new Events("Eight", 03022020, R.drawable.lemon);
        list[8] = new Events("Nine", 03022020, R.drawable.mango);
        list[9] = new Events("Ten", 03022020, R.drawable.watermelon);

        for(int i=0; i<10; i++){
            list[i].storeEvents(list[i]);
        }
    }

    public static void addEvents(Events e){
        int i=0;
        while(list[i]==null&&i<list.length){
            i++;
            if(i==list.length){

            }
            else {
                list[i] = e;
            }
        }

    }
    public static Events[] getList(){
        return list;
    }
}
