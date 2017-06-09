/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pybot.Meyer;

/**
 *
 * @author BNC
 */
public enum MeyerTerm {
    JOACHIMMEYER    ("Joachim Meyer",   "",                 "ca. 1537 Basal - 1571 Schwerin"    + "\nCutler and Freifechter of Strasbourg", MeyerTermTag.PERSON), 
    //
    KNOPF           ("Knopf",           "Pommel",           "Parts of the Sword"    + "\nCounter mass",                             MeyerTermTag.SWORDPART),
    ORT             ("Ort",             "Point",            "Parts of the Sword"    + "\nTip of the sword",                         MeyerTermTag.SWORDPART),
    CREUTZ          ("Creutz",          "Quillon",          "Parts of the Sword"    + "\nCross-Guard",                              MeyerTermTag.SWORDPART),
    GEFES           ("Gefeß",           "Hilt",             "Parts of the Sword"    + "\nNon-Edged portion of the sword",           MeyerTermTag.SWORDPART),
    HEFT            ("Heft",            "Handle",           "Parts of the Sword"    + "\nHeld portion of the hilt",                 MeyerTermTag.SWORDPART),
    BINDT           ("Bindt",           "Grip",             "Parts of the Sword"    + "\nBinding of the handle",                    MeyerTermTag.SWORDPART),
    KLINGE          ("Klinge",          "Blade",            "Parts of the Sword"    + "\nEdged portion of the sword",               MeyerTermTag.SWORDPART),
    STERCKE         ("Stercke",         "Forte",            "Parts of the Sword"    + "\nFirst half of the blade",                  MeyerTermTag.SWORDPART),
    SCHWECHE        ("Schweche",        "Foible",           "Parts of the Sword"    + "\nSecond half of the blade",                 MeyerTermTag.SWORDPART),
    KURTZESCHNEIDE  ("Kurtze Schneide", "Short Edge",       "Parts of the Sword"    + "\nEdge aligned with wrist of main hand",     MeyerTermTag.SWORDPART),
    LANGESCHNEIDE   ("Lange Schneide",  "Long Edge",        "Parts of the Sword"    + "\nEdge aligned with knuckles of main hand",  MeyerTermTag.SWORDPART),
    FLACH           ("Flach",           "Flat",             "Parts of the Sword"    + "\nFlat portion of the blade",                MeyerTermTag.SWORDPART),
    //
    OCHS            ("Ochs",            "Ox",               "Primary Guard"     + "\nRight Ochs: left foot forward, hilt to right of head, point at opponent",              MeyerTermTag.GUARD, MeyerTermTag.PRIMARYGUARD),
    PFLUG           ("Pflug",           "Plow",             "Primary Guard"     + "\nRight Pflug: right foot forward, hilt by forward knee, point at opponent",             MeyerTermTag.GUARD, MeyerTermTag.PRIMARYGUARD),
    TAG             ("Tag",             "Day",              "Primary Guard"     + "\nPosture: left foot forward, sword over head, Pommel in peripheral vision, 45 degrees", MeyerTermTag.GUARD, MeyerTermTag.PRIMARYGUARD),
    OBERHUT         ("Oberhut",         "High Guard",       "See TAG"           + "\nAlias of Tag",                                                                         MeyerTermTag.ALIAS),
    OLBER           ("Olber",           "Fool",             "Primary Guard"     + "\nPosture: left foot forward, tip extended past forward foot, long edge downward",       MeyerTermTag.GUARD, MeyerTermTag.PRIMARYGUARD),
    //
    ZORNHUT         ("Zornhut",         "Wrath Guard",      "Secondary Guard"   + "\nPosture: left foot forward, sword on right shoulder, tip in peripheral vision",                        MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    LANGNORT        ("Langnort",        "Longpoint",        "Secondary Guard"   + "\nPosture: left foot forward, sword and arms extended, point at opponent",                               MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    BRECHFENSTER    ("Brechfenster",    "Break Window",     "See LANGNORT"      + "\nAlias of Langnort",                                                                                    MeyerTermTag.ALIAS),
    WECHSEL         ("Wechsel",         "Change",           "Secondary Guard"   + "\nPosture: right foot forward, tip to ground at left, short edge at opponent",                           MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    NEBENHUT        ("Nebenhut",        "Side Guard",       "Secondary Guard"   + "\nPosture: left foot forward, tip to ground at right, pommel at opponent",                               MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    EISENPORT       ("Eisenport",       "Iron Gate",        "Secondary Guard"   + "\nPosture: right foot forward, hilt at knee, point at opponent",                                         MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    SCHRANKHUT      ("Schrankhut",      "Crossed Guard",    "Secondary Guard"   + "\nPosture: tip at ground with crossed hands",                                                            MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    HANGETORT       ("Hangetort",       "Hanging Point",    "Secondary Guard"   + "\nPosture: right foot forward, sword and arms extended, point somewhat towards ground",                  MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    SCHLUSSEL       ("Schlüßel",        "Key",              "Secondary Guard"   + "\nPosture: left foot forward, hilt and crossed hands at chest, point at opponent, short edge downward",  MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    EINHORN         ("Einhorn",         "One Horn",         "Secondary Guard"   + "\nPosture: left foot forward, crossed hands at right, point upwards",                                    MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    MITTELHUT       ("Mittelhut",       "Middle Guard",     "Secondary Guard"   + "\nFlat rests on arm",                                                                                    MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    SPRECHFENSTER   ("ßprechfenster",   "Speaking Window",  "Secondary Guard"   + "\nSword in front, in bind",                                                                              MeyerTermTag.GUARD, MeyerTermTag.SECONDARYGUARD),
    //
    OBERHAUW        ("Oberhauw",        "High Cut",         "Straight Cut"      + "\nDownward cut",                                     MeyerTermTag.CUT, MeyerTermTag.STRAIGHTCUT, MeyerTermTag.BASICCUT),
    SCHEIDELHAUW    ("Scheidelhauw",    "Scalp Cut",        "See OBERHAUW"      + "\nDownward cut, Alias of Oberhauw as a master cut",  MeyerTermTag.CUT, MeyerTermTag.STRAIGHTCUT, MeyerTermTag.MASTERCUT),
    ZORNHAUW        ("Zornhauw",        "Wrath Cut",        "Straight Cut"      + "\nDownard diagonal cut",                             MeyerTermTag.CUT, MeyerTermTag.STRAIGHTCUT, MeyerTermTag.MASTERCUT),
    STREITHAUW      ("Streithauw",      "Strife Cut",       "See ZORNHAUW"      + "\nAlias of Zornhauw",                                MeyerTermTag.ALIAS),
    VATTERSTREICH   ("Vatterstreich",   "Father Stroke",    "See ZORNHAUW"      + "\nAlias of Zornhauw",                                MeyerTermTag.ALIAS),
    MITTELHAUW      ("Mittelhauw",      "Middle Cut",       "Straight Cut"      + "\nSideward cut",                                     MeyerTermTag.CUT, MeyerTermTag.STRAIGHTCUT, MeyerTermTag.BASICCUT),
    UBERZWERCHHAUW  ("Überzwerchhauw",  "Horizontal Cut",   "See MITTELHAUW"    + "\nAlias of Mittelhauw",                              MeyerTermTag.ALIAS),
    UNDERHAUW       ("Underhauw",       "Low Cut",          "Straight Cut"      + "\nUpward diagonal cut",                              MeyerTermTag.CUT, MeyerTermTag.STRAIGHTCUT, MeyerTermTag.BASICCUT),
    //
    SCHIELHAUW      ("Schielhauw",      "Squinting Cut",    "Reverse Cut"   +"\nLong to short downward cut",                        MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.MASTERCUT),
    KRUMPHAUW       ("Krumphauw",       "Crooked Cut",      "Reverse Cut"   +"\nPerpendicular to opponent cut to crossed hands",    MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.MASTERCUT),
    ZWERCH          ("Zwerch",          "Thwart",           "Reverse Cut"   +"\nHilt above head, sweep horizontally",               MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.MASTERCUT),
    KURTZHAUW       ("Kurtzhauw",       "Short Cut",        "Reverse Cut"   +"\nShort Krumphauw to Zwerch, push pommel",            MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    GLUTZHAUW       ("Glützhauw",       "Clashing Cut",     "Reverse Cut"   +"\nContact with flat above head, short cut",           MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    PRELLHAUW       ("Prellhauw",       "Rebound Cut",      "Reverse Cut"   +"\nRebound off of flat, Zwerch",                       MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    BLENDTHAUW      ("Blendthauw",      "Blind Cut",        "Reverse Cut"   +"\nBind, wind through below",                          MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    WINDTHAUW       ("Windthauw",       "Winding Cut",      "Reverse Cut"   +"\nCut from crossed hands, step out, pull pommel",     MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    KRONHAUW        ("Kronhauw",        "Crown Cut",        "Reverse Cut"   +"\nCatch with quillons from below, pull pommel",       MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    KNIECHELHAUW    ("Kniechelhauw",    "Wrist Cut",        "Reverse Cut"   +"\nUnending Zwerch to overextended high guard",        MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    STURTZHAUW      ("Sturtzhauw",      "Plunge Cut",       "Reverse Cut"   +"\nHight short cut from low guard",                    MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    WECHSELHAUW     ("Wechselhauw",     "Change Cut",       "Reverse Cut"   +"\nChange to a different cut",                         MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    SCHNELLER       ("Schneller",       "Flick",            "Reverse Cut"   +"\nFlick at opponent",                                 MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    ZECKRUR         ("Zeckrur",         "Tag-Hit",          "See SCHNELLER" +"\nDownward flick at head, Alias of Schneller",        MeyerTermTag.ALIAS),
    FLUGELHAUW      ("Flügelhauw",      "Wing Cut",         "Reverse Cut"   +"\nHilt up, clip to back through armpit",              MeyerTermTag.CUT, MeyerTermTag.REVERSECUT, MeyerTermTag.SECONDARYCUT),
    //
    PASSING         ("-",                "Passing Step",     "Step"  +"\nAdvance following foot past lead foot",                 MeyerTermTag.STEP),
    GATHERING       ("-",                "Gathering Step",   "Step"  +"\nGather with following foot, advance with lead foot",    MeyerTermTag.STEP),
    MASTER          ("-",                "Master Step",      "Step"  +"\nStep out with following foot, lead foot back",          MeyerTermTag.STEP),
    SIMPLE          ("-",                "Simple Step",      "Step"  +"\nAdvance lead foot then following foot",                 MeyerTermTag.STEP),
    //
    ZUFECHTEN       ("Zufechten",       "Approch",          "Parts of the Fight", MeyerTermTag.FIGHTPART),
    KRIEG           ("Krieg",           "War",              "Parts of the Fight", MeyerTermTag.FIGHTPART),
    ABZUG           ("Abzug",           "Withdraw",         "Parts of the Fight", MeyerTermTag.FIGHTPART),
    //
    VOR             ("Vor",             "Before",           "Times of the Fight", MeyerTermTag.TIMEPART),
    NACH            ("Nach",            "After",            "Times of the Fight", MeyerTermTag.TIMEPART),
    GLEICH          ("Gleich",          "Simultaneously",   "Times of the Fight", MeyerTermTag.TIMEPART),
    INDES           ("Indeß",           "Instantaneous",    "Times of the Fight", MeyerTermTag.TIMEPART),
    //
    VERSETZEN       ("Versetzen",       "Parrying",         "Handwork", MeyerTermTag.HANDWORK),
    HANDTARBEIT     ("Handtarbeit",     "Handwork",         ""),
    ANBINDEN        ("Versetzen",       "Binding",          "Handwork", MeyerTermTag.HANDWORK),
    BLEIBEN         ("Bleiben",         "Remaining",        "Handwork", MeyerTermTag.HANDWORK),
    FULEN           ("Fülen",           "Feeling",          "Handwork", MeyerTermTag.HANDWORK),
    NACHREISEN      ("Nachreisen",      "Chasing",          "Handwork", MeyerTermTag.HANDWORK),
    SCHNEIDEN       ("Schneiden",       "Slicing",          "Handwork", MeyerTermTag.HANDWORK),
    UMBSCHLAGEN     ("Umbschlagen",     "Striking Around",  "Handwork", MeyerTermTag.HANDWORK),
    ABLAUFFEN       ("Ablauffen",       "Running Off",      "Handwork", MeyerTermTag.HANDWORK),
    VERFUHREN       ("Verführen",       "Deceiving",        "Handwork", MeyerTermTag.HANDWORK),
    VERFLIEGEN      ("Verfliegen",      "Flitting",         "Handwork", MeyerTermTag.HANDWORK),
    ABSETZEN        ("Umbschlagen",     "Setting Off",      "Handwork", MeyerTermTag.HANDWORK),
    SCHLAUDERN      ("Schlaudern",      "Slinging",         "Handwork", MeyerTermTag.HANDWORK),
    ZUCKEN          ("Zucken",          "Pulling",          "Handwork", MeyerTermTag.HANDWORK),
    DOPLIEREN       ("Doplieren",       "Doubling",         "Handwork", MeyerTermTag.HANDWORK),
    VERKEHREN       ("Verkehren",       "Reversing",        "Handwork", MeyerTermTag.HANDWORK),
    UMBSCHNAPPEN    ("Umbschnappen",    "Snapping Around",  "Handwork", MeyerTermTag.HANDWORK),
    FEHLEN          ("Fehlen",          "Failing",          "Handwork", MeyerTermTag.HANDWORK),
    ZIRCKEL         ("Zirckel",         "Circle",           "Handwork", MeyerTermTag.HANDWORK),
    RINDE           ("Rinde",           "Looping",          "Handwork", MeyerTermTag.HANDWORK),
    WINDEN          ("Winden",          "Winding",          "Handwork", MeyerTermTag.HANDWORK),
    DURCHWINDEN     ("Durchwinden",     "Winding Through",  "Handwork", MeyerTermTag.HANDWORK),
    WECHSLEN        ("Wechslen",        "Changing",         "Handwork", MeyerTermTag.HANDWORK),
    ABSCHNEIDEN     ("Abschneiden",     "Slicing Off",      "Handwork", MeyerTermTag.HANDWORK),
    HENDTRUCKEN     ("Hendtrucken",     "Pressing Hands",   "Handwork", MeyerTermTag.HANDWORK),
    VERSCHIEBEN     ("Verschieben",     "Sliding",          "Handwork", MeyerTermTag.HANDWORK),
    HENGEN          ("Hengen",          "Hanging",          "Handwork", MeyerTermTag.HANDWORK),
    ABSREISEN       ("Absreißen",       "Wrenching",        "Handwork", MeyerTermTag.HANDWORK),
    SPERREN         ("Sperren",         "Barring",          "Handwork", MeyerTermTag.HANDWORK),
    VERSTULLEN      ("Verstüllen",      "Blocking",         "Handwork", MeyerTermTag.HANDWORK),
    UBERGREIFFEN    ("Übergreiffen",    "Over Gripping",    "Handwork", MeyerTermTag.HANDWORK),
    EINLAUFFEN      ("Einlauffen",      "Running In",       "Handwork", MeyerTermTag.HANDWORK),
    ;
    
    private final String nameGer;
    private final String nameEng;
    private final String Desc;
    private final MeyerTermTag[] tags;
    MeyerTerm(String nameGer, String nameEng, String Desc, MeyerTermTag... tags){
        this.nameGer = nameGer;
        this.nameEng = nameEng;
        this.Desc = Desc;
        this.tags = tags;
    }
    
    public String nameGer(){return nameGer;};
    public String nameEng(){return nameEng;};    
    public String desc(){return Desc;};
    public MeyerTermTag[] tags() {return tags;};
    
    public String NameGerAndNameEngAndDesc(){
        String full = "";
        full = full.concat(nameGer);
        if(!nameEng.isEmpty()){
            full = full.concat(" [" + nameEng + "]");  
        }
        if(!Desc.isEmpty()){
            full = full.concat(" : " + Desc);  
        }
        return full;
    };
    
}
