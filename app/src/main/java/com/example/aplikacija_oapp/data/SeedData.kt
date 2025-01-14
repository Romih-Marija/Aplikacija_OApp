package com.example.aplikacija_oapp.data

fun generateSeedPosts(): List<Post> {
    return listOf(
        Post(3, "Alenka", "Horvat",  "Ljubljana", "alenka.horvat@gmail.com","Sem gibalno ovirana 52-letnica, živim v centru Ljubljane in iščem zanesljivo, odgovorno in srčno osebno asistentko, ki mi bo pomagala pri vsakodnevnih opravilih.\n" +
                "Tvoje naloge bodo:\n" +
                "- Pomoč pri premeščanju,\n" +
                "- Osebna higiena, \n" +
                "- Priprava obrokov in druga gospodinjska opravila,\n" +
                "- Občasno druženje in pogovor (kakšen klepet vedno pride prav).\n " +
                "Nudim:\n" +
                "- Prijetno in sproščeno okolje,\n" +
                    "- Fleksibilen delovni čas po dogovoru,\n" +
                    "- Delo preko s.p. ali drugo obliko dogovora.","file:///android_asset/alenka.jpg"),
        Post(1, "Janez", "Novak",  "Maribor", "janez.novak@gmail.com", "Potrebujem asistenta z izpitom za avto. Hodim v službo za polovični delovni čas. Potrebujem asistenta, ki me lahko vozi do službe, mi nudi spremstvo in pomoč pri jutranji osebni negi.", "file:///android_asset/janez.jpg"),
        Post(2, "Maja", "Kovač", "Postojna", "maja.kovac@gmail.com","Stara sem 32 let. Potrebujem pomoč pri osebni negi in vsakodnevnih opravilih. Rada hodim na koncerte in rada imam živali. Imam psa spremljevalca, s katerim se veliko sprehajam po naravi.", "file:///android_asset/maja.png"),

    )
}
fun generateSeedPosts2(): List<Post> {
    return listOf(
        Post(2, "Matevž", "Kovač", "Ljubljana", "matevz.kovac@gmail.com",
            "Sem mlad asistent. Po končani sem srednji zdravstveni šoli sem se zaposlil kot osebni asistent in imam 3 leta delovnih izkušenj na tem področju. Imam vozniško dovoljenje.",
            "file:///android_asset/matevz.png"
        ),
        Post(3, "Eva", "Jovanović", "Kranj", "eva.jovanovic@gmail.com",
            "Ponujam pomoč pri opravljanju nalog v gospodinjstvu. Rada pomagam pri čiščenju, pranju. Sem hitra, natančna in rada pomagam.",
            "file:///android_asset/eva.png"
        ),
        Post(1, "Tina", "Petrov", "Maribor", "tina.petrovic@gmail.com",
            "Pozdravljeni. Sem bodoca diplomantka fizioterapije, stara 26 let iz Maribora, ki isce sluzbo osebne asistentke za 40 ur tedensko v Mariboru, okolici pa vse do Celja. Imela sem ze izkusnje z dvema uporabnicama, vendar brez nege. Sem delovna, marljiva, prijazna, empaticna, znam kuhati in opravljati ostala gospodinjska opravila, imam tudi izpit B kategorije. Zelo rada pomagam, se pogovarjam z ljudmi, torej delo z ljudmi mi je zelo pri srcu. Za vse predloge bi bila hvalezna! ",
            "file:///android_asset/tina.png"
        )
    )
}