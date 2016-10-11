package gr.uom.theater.resources;

import gr.uom.theater.application.Person;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import org.controlsfx.control.CheckComboBox;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

public abstract class Util {

    public static final Comparator<Person> PERSON_COMPARATOR = getPersonComparator();

    public static String mapNumberToLetter(int num) {
        return String.valueOf((char) (Math.floorMod(num, 26) + 65));
    }

    public static String listToString(ArrayList<Person> list) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).toString().isEmpty()) {
                result.append(list.get(i).toString());

                if (i < list.size() - 1) {
                    result.append(", ");
                }
            }
        }
        return list.isEmpty() ? "-" : result.toString();
    }

    public static ObservableList<String> personListToStringList(ObservableList<Person> list) {
        ObservableList<String> result = FXCollections.observableArrayList();

        result.addAll(list.stream().filter(p -> !p.toString().isEmpty()).map(Person::toString).collect(Collectors.toList()));

        return result;
    }

    private static Comparator<Person> getPersonComparator() {
        return (o1, o2) -> {
            if (o1.getLastName().isEmpty() && o2.getLastName().isEmpty()) {
                return o1.getFirstName().compareTo(o2.getFirstName());
            } else {
                return o1.getLastName().compareTo(o2.getLastName());
            }
        };
    }

    public static ListChangeListener<String> getCCBChangeListener(CheckComboBox<String> ccb) {
        return (ListChangeListener<String>) c -> {
            if (ccb.getCheckModel().getCheckedItems().isEmpty()) {
                ccb.getCheckModel().check(0);
            } else {
                if (ccb.getCheckModel().getCheckedIndices().size() > 1 && ccb.getCheckModel().getCheckedIndices().contains(0)) {
                    ccb.getCheckModel().clearCheck(0);
                }
            }
        };
    }
}
