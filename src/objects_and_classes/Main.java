package objects_and_classes;

public class Main {
    public static void main(String[] args) {
        printLocalClass();
        printNestedClass();
        printTopLevelClass();
        printAnonymousClass();
    }

    interface AnonymousPerson {
    }

    static class NestedPerson {
        private String name;

        NestedPerson(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return String.format("%s - %s", this.getClass().getSimpleName(), this.name);
        }
    }

    private static void printLocalClass() {
        class LocalPerson {
            private String name;

            LocalPerson(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return String.format("%s - %s", this.getClass().getSimpleName(), this.name);
            }
        }

        LocalPerson localPerson = new LocalPerson("Sexy boi");
        System.out.println(localPerson);
    }

    private static void printNestedClass() {
        NestedPerson person = new NestedPerson("Sexy boi");
        System.out.println(person);
    }

    private static void printTopLevelClass() {
        TopLevelPerson person = new TopLevelPerson("Sexy boi");
        System.out.println(person);
    }

    private static void printAnonymousClass() {
        AnonymousPerson person = new AnonymousPerson() {
            private String name = "Sexy boi";

            @Override
            public String toString() {
                return String.format("%s - %s", this.getClass().getSimpleName(), this.name);
                //returns empty in this case cause its anonymous
            }
        };
        System.out.println(person);
    }
}

class TopLevelPerson {
    private String name;

    TopLevelPerson(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%s - %s", this.getClass().getSimpleName(), this.name);
    }
}