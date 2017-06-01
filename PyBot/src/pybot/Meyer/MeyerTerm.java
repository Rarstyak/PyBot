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
    JOACHIMMEYER    ("Joachim Meyer",   "",                 "ca. 1537 Basal - 1571 Schwerin"
            + "\nCutler and Freifechter of Strasbourg"),
    //
    KNOPF           ("Knopf",           "Pommel",           "Parts of the Sword"
            + "\nCounter mass"),
    ORT             ("Ort",             "Point",            "Parts of the Sword"
            + "\nTip of the Sword"),
    CREUTZ          ("Creutz",          "Quillon",          "Parts of the Sword"
            + "\nCross-Guard"),
    GEFES           ("Gefeß",           "Hilt",             "Parts of the Sword"
            + "\nNon-Edged portion of the Sword"),
    HEFT            ("Heft",            "Handle",           "Parts of the Sword"
            + "\nHeld portion of the Hilt"),
    BINDT           ("Bindt",           "Grip",             "Parts of the Sword"
            + "\nBinding of the Handle"),
    KLINGE          ("Klinge",          "Blade",            "Parts of the Sword"
            + "\nEdged portion of the Sword"),
    STERCKE         ("Stercke",         "Forte",            "Parts of the Sword"
            + "\nFirst half of the Blade"),
    SCHWECHE        ("Schweche",        "Foible",           "Parts of the Sword"
            + "\nSecond half of the Blade"),
    KURTZESCHNEIDE  ("Kurtze Schneide", "Short Edge",       "Parts of the Sword"
            + "\nEdge aligned with wrist of main hand"),
    LANGESCHNEIDE   ("Lange Schneide",  "Long Edge",        "Parts of the Sword"
            + "\nEdge aligned with knuckles of main hand"),
    FLACH           ("Flach",           "Flat",             "Parts of the Sword"
            + "\nFlat portion of the Blade"),
    //
    OCHS            ("Ochs",            "Ox",               "Primary Guard"
            + "\nRight Ochs: left foot forward, hilt to right of head, point at opponent"),
    PFLUG           ("Pflug",           "Plow",             "Primary Guard"
            + "\nRight Pflug: right foot forward, hilt by forward knee, point at opponent"),
    TAG             ("Tag",             "Day",              "Primary Guard"
            + "\nPosture: left foot forward, sword over head, pommel in peripheral vision, 45 degrees"),
    OBERHUT         ("Oberhut",         "High Guard",       "See TAG"),
    OLBER           ("Olber",           "Fool",             "Primary Guard"
            + "\nPosture: left foot forward, point extended past forward foot, long edge downward, short edge upward"),
    //
    ZORNHUT         ("Zornhut",         "Wrath Guard",      "Secondary Guard"
            + "\nPosture: left foot forward, sword on right shoulder, tip in peripheral vision"),
    LANGNORT        ("Langnort",        "Longpoint",        "Secondary Guard"
            + "\nPosture: left foot forward, sword and arms extended, point at opponent"),
    BRECHFENSTER    ("Brechfenster",    "Break Window",     "See LANGNORT"),
    WECHSEL         ("Wechsel",         "Change",           "Secondary Guard"
            + "\nPosture: right foot forward, point to ground at left, short edge at opponent"),
    NEBENHUT        ("Nebenhut",        "Side Guard",       "Secondary Guard"
            + "\nPosture: left foot forward, point to ground at right, pommel at opponent"),
    EISENPORT       ("Eisenport",       "Iron Gate",        "Secondary Guard"
            + "\nPosture: right foot forward, hilt at knee, point at opponent"),
    SCHRANKHUT      ("Schrankhut",      "Crossed Guard",    "Secondary Guard"
            + "\nPosture: point at ground with crossed hands"),
    HANGETORT       ("Hangetort",       "Hanging Point",    "Secondary Guard"
            + "\nPosture: right foot forward, sword and arms extended, point somewhat towards ground"),
    SCHLUSSEL       ("Schlüßel",        "Key",              "Secondary Guard"
            + "\nPosture: left foot forward, hilt and crossed hands at chest, point at opponent, short edge downward"),
    EINHORN         ("Einhorn",         "One Horn",         "Secondary Guard"
            + "\nPosture: left foot forward, crossed hands at right, point upwards"),
    MITTELHUT       ("Mittelhut",       "Middle Guard",     "Secondary Guard"
            + "\nFlat rests on arm"),
    SPRECHFENSTER   ("ßprechfenster",   "Speaking Window",  "Secondary Guard"
            + "\nSword in front, in Bind"),
    //
    OBERHAUW        ("Oberhauw",        "High Cut",         "Straight Cut"),
    SCHEIDELHAUW    ("Scheidelhauw",    "Scalp Cut",        "See OBERHAUW"),
    ZORNHAUW        ("Zornhauw",        "Wrath Cut",        "Straight Cut"),
    STREITHAUW      ("Streithauw",      "Strife Cut",       "See ZORNHAUW"),
    VATTERSTREICH   ("Vatterstreich",   "Father Stroke",    "See ZORNHAUW"),
    MITTELHAUW      ("Mittelhauw",      "Middle Cut",       "Straight Cut"),
    UBERZWERCHHAUW  ("Überzwerchhauw",  "Horizontal Cut",   "See MITTLEHAUW"),
    UNDERHAUW       ("Underhauw",       "Low Cut",          "Straight Cut"),
    //
    SCHIELHAUW      ("Schielhauw",      "Squinting Cut",    "Reverse Cut"),
    KRUMPHAUW       ("Krumphauw",       "Crooked Cut",      "Reverse Cut"),
    ZWERCH          ("Zwerch",          "Thwart",           "Reverse Cut"),
    KURTZHAUW       ("Kurtzhauw",       "Short Cut",        "Reverse Cut"),
    GLUTZHAUW       ("Glützhauw",       "Clashing Cut",     "Reverse Cut"),
    PRELLHAUW       ("Prellhauw",       "Rebound Cut",      "Reverse Cut"),
    BLENDTHAUW      ("Blendthauw",      "Blind Cut",        "Reverse Cut"),
    WINDTHAUW       ("Windthauw",       "Winding Cut",      "Reverse Cut"),
    KRONHAUW        ("Kronhauw",        "Crown Cut",        "Reverse Cut"),
    KNIECHELHAUW    ("Kniechelhauw",    "Wrist Cut",        "Reverse Cut"),
    STURTZHAUW      ("Sturtzhauw",      "Plunge Cut",       "Reverse Cut"),
    WECHSELHAUW     ("Wechselhauw",     "Change Cut",       "Reverse Cut"),
    SCHNELLER       ("Schneller",       "Flick",            "Reverse Cut"),
    ZECKRUR         ("Zeckrur",         "Tag-Hit",          "See SCHNELLER"),
    FLUGELHAUW      ("Flügelhauw",      "Wing Cut",         "Reverse Cut"),
    //
    PASSING         ("",                "Passing Step",     "Step"),
    GATHERING       ("",                "Gathering Step",   "Step"),
    MASTER          ("",                "Master Step",      "Step"),
    SIMPLE          ("",                "Simple Step",      "Step"),
    //
    ZUFECHTEN       ("Zufechten",       "Approch",          "Part"),
    KRIEG           ("Krieg",           "War",              "Part"),
    ABZUG           ("Abzug",           "Withdraw",         "Part"),
    //
    VOR             ("Vor",             "Before",           "Time"),
    NACH            ("Nach",            "After",            "Time"),
    GLEICH          ("Gleich",          "Simultaneously",   "Time"),
    INDES           ("Indeß",           "Instantaneous",    "Time"),
    //
    VERSETZEN       ("Versetzen",       "Parrying",         "Handwork"),
    HANDTARBEIT     ("Handtarbeit",     "Handwork",         ""),
    ANBINDEN        ("Versetzen",       "Binding",          "Handwork"),
    BLEIBEN         ("Bleiben",         "Remaining",        "Handwork"),
    FULEN           ("Fülen",           "Feeling",          "Handwork"),
    NACHREISEN      ("Nachreisen",      "Chasing",          "Handwork"),
    SCHNEIDEN       ("Schneiden",       "Slicing",          "Handwork"),
    UMBSCHLAGEN     ("Umbschlagen",     "Striking Around",  "Handwork"),
    ABLAUFFEN       ("Ablauffen",       "Running Off",      "Handwork"),
    VERFUHREN       ("Verführen",       "Deceiving",        "Handwork"),
    VERFLIEGEN      ("Verfliegen",      "Flitting",         "Handwork"),
    ABSETZEN        ("Umbschlagen",     "Setting Off",      "Handwork"),
    SCHLAUDERN      ("Schlaudern",      "Slinging",         "Handwork"),
    ZUCKEN          ("Zucken",          "Pulling",          "Handwork"),
    DOPLIEREN       ("Doplieren",       "Doubling",         "Handwork"),
    VERKEHREN       ("Verkehren",       "Reversing",        "Handwork"),
    UMBSCHNAPPEN    ("Umbschnappen",    "Snapping Around",  "Handwork"),
    FEHLEN          ("Fehlen",          "Failing",          "Handwork"),
    ZIRCKEL         ("Zirckel",         "Circle",           "Handwork"),
    RINDE           ("Rinde",           "Looping",          "Handwork"),
    WINDEN          ("Winden",          "Winding",          "Handwork"),
    DURCHWINDEN     ("Durchwinden",     "Winding Through",  "Handwork"),
    WECHSLEN        ("Wechslen",        "Changing",         "Handwork"),
    ABSCHNEIDEN     ("Abschneiden",     "Slicing Off",      "Handwork"),
    HENDTRUCKEN     ("Hendtrucken",     "Pressing Hands",   "Handwork"),
    VERSCHIEBEN     ("Verschieben",     "Sliding",          "Handwork"),
    HENGEN          ("Hengen",          "Hanging",          "Handwork"),
    ABSREISEN       ("Absreißen",       "Wrenching",        "Handwork"),
    SPERREN         ("Sperren",         "Barring",          "Handwork"),
    VERSTULLEN      ("Verstüllen",      "Blocking",         "Handwork"),
    UBERGREIFFEN    ("Übergreiffen",    "Over Gripping",    "Handwork"),
    EINLAUFFEN      ("Einlauffen",      "Running In",       "Handwork"),
    ;
    
    private final String nameGer;
    private final String nameEng;
    private final String Desc;
    MeyerTerm(String nameGer, String nameEng, String Desc){
        this.nameGer = nameGer;
        this.nameEng = nameEng;
        this.Desc = Desc;
    }
    
    public String nameGer(){return nameGer;};
    public String nameEng(){return nameEng;};    
    public String Desc(){return Desc;};
    
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
