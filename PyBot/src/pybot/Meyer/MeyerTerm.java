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
    TAG             ("Von Tag",         "Roof",             "Primary Guard"),
    OCHS            ("Ochs",            "Ox",               "Primary Guard"),
    PFLUG           ("Pflug",           "Plow",             "Primary Guard"),
    OLBER           ("Olber",           "Fool",             "Primary Guard"),
    //
    WECHSEL         ("Wechsel",         "Change",           "Secondary Guard"),
    NEBENHUT        ("Nebenhut",        "Side Guard",       "Secondary Guard"),
    SCHRANKHUT      ("Schrankhut",      "Crossed Guard",    "Secondary Guard"),
    EISENPORT       ("Eisenport",       "Iron Gate",        "Secondary Guard"),
    MITTELHUT       ("Mittelhut",       "Middle Guard",     "Secondary Guard"),
    SCHLUSSEL       ("Schlüßel",        "Key",              "Secondary Guard"),
    LANGNORT        ("Langnort",        "Longpoint",        "Secondary Guard"),
    BRECHFENSTER    ("Brechfenster",    "Break Window",     "See LANGNORT"),
    SPRECHFENSTER   ("ßprechfenster",   "Speaking Window",  "Secondary Guard"),
    HANGETORT       ("Hangetort",       "Hanging Point",    "Secondary Guard"),
    ZORNHUT         ("Zornhut",         "Wrath Guard",      "Secondary Guard"),
    EINHORN         ("Einhorn",         "One Horn",         "Secondary Guard"),
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
    VERSETZEN       ("Versetzen",       "Parrying",         "-"),
    HANDTARBEIT     ("Handtarbeit",     "Handwork",         "-"),
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
    
    public String NameGerAndDesc(){return nameGer + " : " + Desc;};
    public String NameEngAndDesc(){return nameEng + " : " + Desc;};
    public String NameGerAndNameEngAndDesc(){return nameGer + " [" + nameEng + "] : " + Desc;};
    
}
