package com.example.a4serve;

public class EventsList {
    private static Events[] list;
    public EventsList(int num){
        list = new Events[num];
        for(int i=0; i<num; i++){
            list[i] = new Events("Event", 03172020, R.drawable.ic_person_black_24dp);
//            if (i%2 == 0)
//            {
//                list[i].switchFollow();
//            }
        }

    }
    public static void addEvents(Events e){
        int i=0;
        while(list[i]==null&&i<list.length){
            i++;
        }
        if(i==list.length){

        }
        else {
            list[i] = e;
        }
    }
    public static Events[] getList(){
        return list;
    }
}
