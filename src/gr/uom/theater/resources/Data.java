package gr.uom.theater.resources;

import gr.uom.theater.application.Main;
import gr.uom.theater.application.Performance;
import gr.uom.theater.application.Person;
import gr.uom.theater.application.Play;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableSet;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

public abstract class Data {

    public static final int SMALL_SCREEN_WIDTH = 300;
    public static final int SMALL_SCREEN_HEIGHT = 200;
    public static final int MAIN_SCREEN_WIDTH = 1000;
    public static final int MAIN_SCREEN_HEIGHT = 800;
    public static final int SEATS_SCREEN_WIDTH = 800;
    public static final int SEATS_SCREEN_HEIGHT = 600;

    public static final Image NO_IMAGE = new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/no-image.png"));

    public static final Tooltip CITY_TOOLTIP = new Tooltip("Επιλέξτε την πόλη στην οποία επιθυμείται να βρείτε θέατρα");
    public static final Tooltip PLAYS_TOOLTIP = new Tooltip("Επιλέξτε την θεατρική παράσταση για την οποία θέλετε να κάνετε κράτηση");
    public static final Tooltip THEATERS_TOOLTIP = new Tooltip("Επιλέξτε τη προβολή για την οποία θέλετε να κάνετε κράτηση");
    public static final Tooltip SEATS_TOOLTIP = new Tooltip("Επιλέξτε τον αριθμό των θέσεων που θέλετε να κρατήσετε");

    public static final String TABLE_PLACEHOLDER = "Δεν υπάρχουν παραστάσεις στην συγκεκριμένη πόλη";

    public static final ArrayList<String> USERS = getUsers();

    public static final ObservableList<String> CITIES = getCities();
    public static final ObservableList<Play> PLAYS = getPlays();
    public static final ObservableList<Person> WRITERS = getWriters();
    public static final ObservableList<Person> DIRECTORS = getDirectors();
    public static final ObservableList<Person> ACTORS = getActors();
    public static final ObservableList<Person> MUSICIANS = getMusicians();
    public static final ObservableList<Person> COSTUMES = getCostumes();

    public static Performance selectedPerformance;
    public static String selectedCity;
    public static int selectedSeats = 0;

    private static ObservableList<String> getCities() {
        ObservableList<String> data = FXCollections.observableArrayList();

        data.add("Αθήνα");
        data.add("Θεσσαλονίκη");

        return data;
    }

    private static ObservableList<Play> getPlays() {
        ObservableList<Play> data = FXCollections.observableArrayList();

        Play p1 = new Play("Για όλα φταίει ο φίλος μου", 1994);
        p1.addWriters(new Person("Ευάγγελος", "Σαμιώτης"));
        p1.addDirectors(new Person("Ζαχαρίας", "Ρόχας"));
        p1.addActors(new Person("Αλέξανδρος", "Ζαχαρέας"), new Person("Τόνια", "Οικονόμου"), new Person("Θανάσης", "Πατριαρχέας"), new Person("Λούλα", "Τριανταφύλλου"), new Person("Πάνος", "Τσαλιγόπουλος"));
        p1.addCostumes(new Person("Ιωάννα", "Μιχοπούλου"));
        p1.setPoster(new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/1.jpg")));
        p1.setSummary("Πόσο προσκολλημένη είναι η Ελληνίδα μάνα στα παιδιά της; Τι γίνεται όταν ένας εγκλωβισμένος γιος αποφασίζει να κάνει την επανάσταση του; Θα καταφέρει να βγει από το καβούκι του ή θα παρασύρει τους πάντες σε αυτή του την προσπάθεια; Ο Δημητράκης είναι ο γιος που ονειρεύεται κάθε παραδοσιακή Ελληνίδα μάνα. Δεν πίνει, δεν βρίζει, δεν ξενυχτάει, δεν παίρνει ναρκωτικά, δεν αντιμιλάει, δεν... Μέχρι που επιστρέφει ο κολλητός του, ο Μητσάρας, από την Αγγλία και μαζί με την προκλητική Ντέμπορα θα προσπαθήσουν να του αλλάξουν τη ζωή. Η μία ανατροπή διαδέχεται την άλλη...");
        p1.addPerformances(new Performance("Αθήνα", "LIFE N' ART THEATER", LocalDate.of(2016, 4, 20), LocalTime.of(21, 30), 8),
                new Performance("Αθήνα", "LIFE N' ART THEATER", LocalDate.of(2016, 4, 21), LocalTime.of(21, 30), 8),
                new Performance("Αθήνα", "LIFE N' ART THEATER", LocalDate.of(2016, 4, 22), LocalTime.of(21, 30), 8));

        data.add(p1);

        Play p2 = new Play("Φιλάνθρωπο όπλο", 2015);
        p2.addWriters(new Person("Γιώργης", "Γιατρομανωλάκης"));
        p2.addDirectors(new Person("Ζαφείρης", "Νικήτας"));
        p2.addActors(new Person("Νίκος", "Ράμμος"), new Person("Αλεξία", "Φάλλα"));
        p2.addCostumes(new Person("Σπύρος", "Ζαννιάς"));
        p2.addMusicians(new Person("Σπύρος", "Εμμανουηλίδης"));
        p2.setPoster(new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/2.jpg")));
        p2.setSummary("Το έργο είναι η ιστορία ενός φόνου, μιας οικογενειακής βεντέτας στην Κρήτη. Ένας έμπορος μεταξιού, ο Εμμανουήλ Γεωργίου Ζερβός, η κόρη του κι ο σύζυγός της εμπλέκονται σε ένα τρίγωνο βίας και στοργής. Ποιό είναι το κίνητρο του φόνου; Πώς αντιμετωπίζεται το πένθος; Πότε αποδίδεται η δικαιοσύνη;");
        p2.addPerformances(new Performance("Αθήνα", "ΚΕΝΤΡΟ ΕΛΕΓΧΟΥ ΤΗΛΕΟΡΑΣΕΩΝ", LocalDate.of(2016, 4, 20), LocalTime.of(21, 0), 5),
                new Performance("Αθήνα", "ΚΕΝΤΡΟ ΕΛΕΓΧΟΥ ΤΗΛΕΟΡΑΣΕΩΝ", LocalDate.of(2016, 4, 21), LocalTime.of(21, 0), 5),
                new Performance("Αθήνα", "ΚΕΝΤΡΟ ΕΛΕΓΧΟΥ ΤΗΛΕΟΡΑΣΕΩΝ", LocalDate.of(2016, 4, 22), LocalTime.of(21, 0), 5));

        data.add(p2);

        Play p3 = new Play("Τρεις αδερφές", 1901);
        p3.addWriters(new Person("Αντον", "Τσέχωφ"));
        p3.addDirectors(new Person("Ομάδα Casus Belli", ""));
        p3.addActors(new Person("Ανδρονίκη", "Αβδελιώτη"), new Person("Γιώργος", "Ανδράκης"), new Person("Βαγγέλης", "Παπαδάκης"), new Person("Μαρία", "Πίγκου"), new Person("Ελίζα", "Πιτσικώνη"), new Person("Μάριος", "Πλιάτσικας"), new Person("Μάριος", "Σουγιουτζόγλου"), new Person("Σωτήρης", "Σταυράτης"), new Person("Αννα", "Ψαρρά"));
        p3.addMusicians(new Person("Σίσσυ", "Βλαχογιάννη"));
        p3.setPoster(new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/8.jpg")));
        p3.setSummary("Όλα όσα ονειρευτήκαμε δε θα γίνουν ποτέ; Μια παράσταση για τη συντριβή και τα χαμένα όνειρα. Ένας κόσμος καταρρέει και δίνει τη θέση του σ’ έναν άλλο. Υπάρχει ελπίδα μετά την ματαίωση; Μπορούμε, έστω, να ελπίζουμε στην ευτυχία;");
        p3.addPerformances(new Performance("Αθήνα", "ΑΠΟ ΜΗΧΑΝΗΣ ΘΕΑΤΡΟ", LocalDate.of(2016, 4, 24), LocalTime.of(19, 0), 6),
                new Performance("Αθήνα", "ΑΠΟ ΜΗΧΑΝΗΣ ΘΕΑΤΡΟ", LocalDate.of(2016, 5, 1), LocalTime.of(19, 0), 6),
                new Performance("Αθήνα", "ΑΠΟ ΜΗΧΑΝΗΣ ΘΕΑΤΡΟ", LocalDate.of(2016, 5, 8), LocalTime.of(19, 0), 6));

        data.add(p3);

        Play p4 = new Play("72 ώρες", 2014);
        p4.addWriters(new Person("Γιώργος", "Χατζηπαύλου"), new Person("Αστερόπη", "Λαζαρίδου"));
        p4.addDirectors(new Person("Γιάννης", "Σαρακατσάνης"));
        p4.addActors(new Person("Έλενα", "Μεντζέλου"), new Person("Σπύρος", "Πετούσης"));
        p4.addCostumes(new Person("Ηλένια", "Δουλαδίρη"), new Person("Ζωή", "Μολυβδά"));
        p4.addMusicians(new Person("Φοίβος", "Δεληβοριάς"));
        p4.setPoster(new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/3.jpg")));
        p4.setSummary("Όταν ο Μάνος γνώρισε τη Μάνια, ήταν και οι δύο πολύ κουρασμένοι από όλες τις προηγούμενες αποτυχημένες σχέσεις τους και τα εξίσου αποτυχημένα τυφλά ραντεβού τους. Μόνος αυτός, μόνη κι αυτή, στην κρίσιμη ηλικία των 38, αποφάσισαν να ενώσουν τις μοναξιές τους, για να έρθουν, λίγο καιρό αργότερα, αντιμέτωποι με ένα τεράστιο δίλημμα: είναι έτοιμοι να βουτήξουν στα βαθιά, ή προτιμούν να πλατσουρίζουν για πάντα στα ρηχά, σαν ενήλικες με παρατεταμένη εφηβεία; Μία καταιγιστική κωμωδία που εξελίσσεται μέσα σε 72 ώρες - αλλά μην ανησυχείτε! Η παράσταση διαρκεί πολύ λιγότερο.");
        p4.addPerformances(new Performance("Θεσσαλονίκη", "Θέατρο Αθήναιον", LocalDate.of(2016, 4, 22), LocalTime.of(21, 30), 10),
                new Performance("Θεσσαλονίκη", "Θέατρο Αθήναιον", LocalDate.of(2016, 4, 23), LocalTime.of(21, 30), 10),
                new Performance("Θεσσαλονίκη", "Θέατρο Αθήναιον", LocalDate.of(2016, 4, 24), LocalTime.of(20, 0), 10));

        data.add(p4);

        Play p5 = new Play("Between", 2016);
        p5.addWriters(new Person("Γιώργος", "Κριθάρας"));
        p5.addDirectors(new Person("Γιώργος", "Κριθάρας"), new Person("Μυρσίνη", "Λινού"));
        p5.addActors(new Person("Γιάννης", "Σαμψαλάκης"), new Person("Τάσος", "Τσουκάλης"), new Person("Τάσος", "Δημητριάδης"));
        p5.setPoster(new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/4.jpeg")));
        p5.setSummary("Η παράσταση \"Between\" πραγματεύεται το ζήτημα / αίσθημα της νιότης και το γεγονός του πένθους στη σύγχρονη, ελληνική πραγματικότητα, η οποία αδυνατεί να κατακτήσει ή ακόμη και να αντέξει τη μετάβαση ζωής που ορίζεται ως ενηλικίωση. Πρόκειται για ένα παραστασιακό συμβάν, που αφηγείται μια σειρά στιγμών ζωής δύο νέων ανδρών, οι οποίες άλλοτε επιβεβαιώνουν και άλλοτε εξηγούν την ατελή τους ενηλικίωση. Ακολουθώντας ως δραματουργικό άξονα τα τρία στάδια μιας διαβατήριας τελετής: Αποχωρισμός - Μηδενική ταυτότητα - Ενσωμάτωση, το \"Between\" αποπειράται να αναδείξει ένα είδος θεάτρου που ως δημιουργική απαρχή του επιλέγει την έρευνα. Και ως μέθοδο και αισθητικό μονόδρομο την εξής θέση: κάθε ύλη και δράση επί σκηνής αποτελεί ντοκουμέντο και θραύσμα πραγματικότητας.");
        p5.addPerformances(new Performance("Θεσσαλονίκη", "Δημοτικό Θέατρο Καλαμαριάς Μελίνα Μερκούρη", LocalDate.of(2016, 4, 20), LocalTime.of(21, 0), 7),
                new Performance("Θεσσαλονίκη", "Δημοτικό Θέατρο Καλαμαριάς Μελίνα Μερκούρη", LocalDate.of(2016, 4, 21), LocalTime.of(21, 0), 7),
                new Performance("Θεσσαλονίκη", "Δημοτικό Θέατρο Καλαμαριάς Μελίνα Μερκούρη", LocalDate.of(2016, 4, 22), LocalTime.of(21, 0), 7),
                new Performance("Θεσσαλονίκη", "Δημοτικό Θέατρο Καλαμαριάς Μελίνα Μερκούρη", LocalDate.of(2016, 4, 23), LocalTime.of(21, 0), 7),
                new Performance("Θεσσαλονίκη", "Δημοτικό Θέατρο Καλαμαριάς Μελίνα Μερκούρη", LocalDate.of(2016, 4, 24), LocalTime.of(21, 0), 7));

        data.add(p5);

        Play p6 = new Play("Ανθρώπινες φωνές", 1930);
        p6.addWriters(new Person("Ζαν", "Κοκτώ"));
        p6.addDirectors(new Person("Γιώργος", "Μακρής"));
        p6.addActors(new Person("Ευδοκία", "Κελεσίδη"), new Person("Γιώργος", "Μακρής"));
        p6.addCostumes(new Person("Δέσποινα", "Χριστοπούλου"));
        p6.addMusicians(new Person("Γιώργος", "Μακρής"));
        p6.setPoster(new Image(Main.class.getResourceAsStream("/gr/uom/theater/resources/images/5.jpg")));
        p6.setSummary("Οι \"Ανθρώπινες Φωνές\" αποτελούν σύνθεση τριών ανεξάρτητων έργων του Jean Cocteau σε μια ενιαία παράσταση. \"Η Ανθρώπινη Φωνή\", \"Η Ψεύτρα\", που για τις ανάγκες της παράστασης έγινε \"Ο Ψεύτης\", και \"Ο Ωραίος Αδιάφορος\" γράφτηκαν τις δεκαετίες ’30 και ’40 από τον Γάλλο συγγραφέα. Τρία διαχρονικά κείμενα που αν τα κοιτάξουμε λίγο καλύτερα συνειδητοποιούμε πως με έναν μαγικό τρόπο συνδέονται απόλυτα. Ακούμε διαρκώς φωνές. Όλη μας η ζωή είναι γεμάτη φωνές. Κάποιες φορές υπαρκτές, κάποιες όχι. Πολλές φορές δεν δίνουμε σημασία, ούτε στις μεν ούτε στις δε. Τις θεωρούμε δεδομένες, ενοχλητικές ίσως και ανούσιες. Όταν, όμως, αυτές πάψουν να ακούγονται, τότε καταλαβαίνουμε την ουσία τους. Η απόγνωση, ο αρρωστημένος έρωτας, η απώλεια, το ψέμα και η ταπείνωση είναι βασικά στοιχεία και των τριών μονολόγων, που στο καθένα αποδίδονται με διαφορετικό τρόπο.");
        p6.addPerformances(new Performance("Θεσσαλονίκη", "Θέατρο Αυλαία", LocalDate.of(2016, 4, 22), LocalTime.of(18, 0), 12),
                new Performance("Θεσσαλονίκη", "Θέατρο Αυλαία", LocalDate.of(2016, 4, 23), LocalTime.of(18, 0), 12));

        data.add(p6);

        return data;
    }

    private static ObservableList<Person> getWriters() {
        ObservableSet<Person> data = FXCollections.observableSet();

        for (Play p : PLAYS) {
            data.addAll(p.getWriters().stream().filter(pe -> !pe.toString().isEmpty()).collect(Collectors.toList()));
        }
        ObservableList<Person> result = FXCollections.observableArrayList(data);
        FXCollections.sort(result, Util.PERSON_COMPARATOR);

        return result;
    }

    private static ObservableList<Person> getDirectors() {
        ObservableSet<Person> data = FXCollections.observableSet();

        for (Play p : PLAYS) {
            data.addAll(p.getDirectors().stream().filter(pe -> !pe.toString().isEmpty()).collect(Collectors.toList()));
        }
        ObservableList<Person> result = FXCollections.observableArrayList(data);
        FXCollections.sort(result, Util.PERSON_COMPARATOR);

        return result;
    }

    private static ObservableList<Person> getActors() {
        ObservableSet<Person> data = FXCollections.observableSet();

        for (Play p : PLAYS) {
            data.addAll(p.getActors().stream().filter(pe -> !pe.toString().isEmpty()).collect(Collectors.toList()));
        }
        ObservableList<Person> result = FXCollections.observableArrayList(data);
        FXCollections.sort(result, Util.PERSON_COMPARATOR);

        return result;
    }

    private static ObservableList<Person> getMusicians() {
        ObservableSet<Person> data = FXCollections.observableSet();

        for (Play p : PLAYS) {
            data.addAll(p.getMusicians().stream().filter(pe -> !pe.toString().isEmpty()).collect(Collectors.toList()));
        }
        ObservableList<Person> result = FXCollections.observableArrayList(data);
        FXCollections.sort(result, Util.PERSON_COMPARATOR);

        return result;
    }

    private static ObservableList<Person> getCostumes() {
        ObservableSet<Person> data = FXCollections.observableSet();

        for (Play p : PLAYS) {
            data.addAll(p.getCostumes().stream().filter(pe -> !pe.toString().isEmpty()).collect(Collectors.toList()));
        }
        ObservableList<Person> result = FXCollections.observableArrayList(data);
        FXCollections.sort(result, Util.PERSON_COMPARATOR);

        return result;
    }

    private static ArrayList<String> getUsers() {
        ArrayList<String> users = new ArrayList<>();
        users.add("Θεατής");
        users.add("Διαχειριστής");
        return users;
    }
}
