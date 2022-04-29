package com.company.lab35;

import java.util.Objects;

public class Fraction {
    private NumberT nominator;
    private NumberT denominator;

    public Fraction() {
        this.nominator = new NumberT(1);
        this.denominator = new NumberT(1);
    }

    public Fraction(int nom, int denom) {
        if (denom == 0) {
            throw new IllegalArgumentException();
        }
        this.nominator = new NumberT(nom);
        this.denominator = new NumberT(denom);
    }

    public Fraction(NumberT nom, NumberT denom) {
        if (denom.get() == 0) {
            throw new IllegalArgumentException();
        }
        this.nominator = new NumberT(nom);
        this.denominator = new NumberT(denom);
    }

    public Fraction(Fraction fraction) {
        this.nominator = fraction.nominator;
        this.denominator = fraction.denominator;
    }

    public Fraction sum(Fraction fr) {
        Fraction result = new Fraction();
        int lDenom = this.denominator.get();
        int lNom = this.nominator.get();
        int rDenom = fr.denominator.get();
        int rNom = fr.nominator.get();

        if (lDenom % rDenom == 0) {
            result.nominator.set(lNom + rNom * (lDenom / rDenom));
            result.denominator.set(lDenom);
        } else if (rDenom % lDenom == 0) {
            result.nominator.set(lNom * (rDenom / lDenom) + rNom);
            result.denominator.set(rDenom);
        } else {
            int mply = rDenom * lDenom;
            result.nominator.set(lNom * (mply / lDenom) + rNom * (mply / rDenom));
            result.denominator.set(mply);
        }
        return result;
    }

    public Fraction sub(Fraction fr) {
        Fraction result = new Fraction();
        int lDenom = this.denominator.get();
        int lNom = this.nominator.get();
        int rDenom = fr.denominator.get();
        int rNom = fr.nominator.get();

        if (lDenom % rDenom == 0) {
            result.nominator.set(lNom - rNom * (lDenom / rDenom));
            result.denominator.set(lDenom);
        } else if (rDenom % lDenom == 0) {
            result.nominator.set(lNom * (rDenom / lDenom) - rNom);
            result.denominator.set(rDenom);
        } else {
            int mply = rDenom * lDenom;
            result.nominator.set(lNom * (mply / lDenom) - rNom * (mply / rDenom));
            result.denominator.set(mply);
        }
        return result;
    }

    public Fraction mul(Fraction fr) {
        return new Fraction(this.nominator.get() * fr.nominator.get(), this.denominator.get() * fr.denominator.get());
    }

    public Fraction div(Fraction fr) {
        return mul(new Fraction(fr.denominator.get(), fr.nominator.get()));
    }

    @Override
    public String toString() {
        return new String(nominator + "/" + denominator);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return Objects.equals(nominator, fraction.nominator) && Objects.equals(denominator, fraction.denominator);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nominator, denominator);
    }
}
