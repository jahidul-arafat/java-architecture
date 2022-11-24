package com.example.bootingweb.helpers;

import java.util.ArrayList;
import java.util.List;

public class Helper {
    public static List covertInterableIntoList(Iterable kataIterable){
        List kataList = new ArrayList();
        kataIterable.forEach(kataList::add);
        return kataList;

    }
}
