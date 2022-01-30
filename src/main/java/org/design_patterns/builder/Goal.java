package org.design_patterns.builder;

import java.time.LocalDate;
import java.util.List;

/* Pisanie builderów jest nużące i powtarzalne, dlatego powstały liczne pluginy do IDE, które generują je za nas. Dla
InteliJ mamy na przykład plugin Builder Generator. Po zainstalowaniu wystarczy kliknąć Alt+Shift+B i
wyskoczy nam opcja do wygenerowania buildera.

Powstały również do tego całe biblioteki. Jedną z nich jest np. Lombok (Który udostępnia szereg innych funkcji).
Wystarczy dorzucić do klasy adnotację @Builder i już możemy korzystać z Buildera za pomocą statycznej metody builder().

Kod buildera jest dosyć rozwlekły. Koszt napisania buildera nie jest może zbyt duży (szczególnie jeśli zostanie wygenerowany),
 jednak może mieć znaczenie wydajnościowe. Dlatego ten wzorzec powinniśmy stosować tylko wtedy kiedy klasa będzie mieć
 przynajmniej 4 wymagane pola (lub wiemy, że ta liczba urośnie) i nie jest to aplikacja performance-critical.
 Przy mniejszej ilości parametrów jest to overengineering.*/

public class Goal {
    private String name;
    private String description;
    private List<Level> levels;
    private Checklist checklist;
    private LocalDate deadline;
    private boolean achieved;

    public static final class Builder {
        private String name;
        private String description;
        private List<Level> levels;
        private Checklist checklist;
        private LocalDate deadline;
        private boolean achieved = false;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder levels(List<Level> levels) {
            this.levels = levels;
            return this;
        }

        public Builder checklist(Checklist checklist) {
            this.checklist = checklist;
            return this;
        }

        public Builder deadline(LocalDate deadline) {
            this.deadline = deadline;
            return this;
        }

        public Builder achieved() {
            this.achieved = true;
            return this;
        }

        public Goal build() {
            if(name.isEmpty()){
                throw new IllegalStateException("Name cannot be empty");
            }
            if(levels.isEmpty()){
                throw new IllegalStateException("Levels cannot be empty");
            }

            Goal goal = new Goal();
            goal.deadline = this.deadline;
            goal.name = this.name;
            goal.checklist = this.checklist;
            goal.levels = this.levels;
            goal.description = this.description;
            goal.achieved = this.achieved;
            return goal;
        }


    }

    private class Checklist {
    }

    private class Level {
    }
}