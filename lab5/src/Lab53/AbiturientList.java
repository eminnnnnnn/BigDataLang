package Lab53;

import com.company.lab33.Abiturient;

import java.util.ArrayList;
import java.util.Arrays;

public class AbiturientList {
    ArrayList<Abiturient> abiturients;

    public AbiturientList() {
        abiturients = new ArrayList<Abiturient>();
    }

    public AbiturientList(int count) {
        abiturients = new ArrayList<Abiturient>(count);
    }

    public AbiturientList(Abiturient[] abiturients) {
        this.abiturients = new ArrayList<Abiturient>(abiturients.length);
        for (Abiturient a : abiturients) {
            this.abiturients.add(a);
        }
    }

    public Abiturient getById(int id) {
        for (Abiturient a : abiturients) {
            if (a.getId() == id) {
                return a;
            }
        }
        return new Abiturient();
    }

    public Abiturient getByIndex(int idx) throws AbiturientException {
        try {
            return abiturients.get(idx);
        } catch (IndexOutOfBoundsException e) {
            throw new AbiturientException("No such index in abiturient list");
        }
    }


    public void remove(int id) {
        for (int i = 0; i < abiturients.size(); i++) {
            if (abiturients.get(i).getId() == id) {
                abiturients.remove(i);
                return;
            }
        }
    }

    public void append(Abiturient abiturient) throws AbiturientException {
        if (abiturient == null) {
            throw new AbiturientException("Cannot add null pointer to abiturient list");
        }
        abiturients.add(abiturient);
    }

    public int size() {
        return abiturients.size();
    }

    public AbiturientList getAbiturientsWithBadMarks() {
        AbiturientList badAbiturients = new AbiturientList();
        for (Abiturient a : abiturients) {
            if (Arrays.toString(a.getMarks()).contains("2")) {
                badAbiturients.abiturients.add(a);
            }
        }
        return badAbiturients;
    }

    public AbiturientList getWithMeanGreaterThan(double mean) {
        AbiturientList abiturients = new AbiturientList();
        for (Abiturient a : this.abiturients) {
            double a_mean = 0.0;
            int[] a_marks = a.getMarks();
            for (int i = 0; i < a_marks.length; i++) {
                a_mean += a_marks[i];
            }
            a_mean /= a_marks.length;
            if (a_mean > mean) {
                abiturients.abiturients.add(a);
            }
        }
        return abiturients;
    }

    public AbiturientList getBestAbiturients(int maxCount) {
        AbiturientList bestAbiturients = new AbiturientList();

        double best_mean = 0.0;
        double[] a_means = new double[abiturients.size()];
        for (int i = 0; i < abiturients.size(); i++) {
            double a_mean = 0.0;
            int[] a_marks = abiturients.get(i).getMarks();
            for (int j = 0; j < a_marks.length; j++) {
                a_mean += a_marks[j];
            }
            a_mean /= a_marks.length;
            a_means[i] = a_mean;
            if (a_mean > best_mean) {
                best_mean = a_mean;
            }
        }

        for (int i = 0; (maxCount > 0)&&(i < abiturients.size()); i++) {
            if (a_means[i] == best_mean) {
                bestAbiturients.abiturients.add(abiturients.get(i));
                maxCount--;
            }
        }
        for (int i = 0; i < abiturients.size(); i++) {
            if ((a_means[i] < best_mean) && (a_means[i] >= best_mean - 1.0)) {
                bestAbiturients.abiturients.add(abiturients.get(i));
            }
        }

        return bestAbiturients;
    }

    @Override
    public String toString() {
        StringBuilder abiturientsString = new StringBuilder("");
        for (Abiturient a : abiturients) {
            abiturientsString.append(a.toString());
        }
        return abiturientsString.toString();
    }
}
