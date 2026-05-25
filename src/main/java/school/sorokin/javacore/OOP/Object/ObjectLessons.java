package school.sorokin.javacore.OOP.Object;

public class ObjectLessons {
    public static void main(String[] args) {
        Car car1 = new Car();
        car1.setModel("sda");
        car1.setYear(123);
        System.out.println(car1);

        Car car2 = new Car();
        car2.setModel("sda");
        car2.setYear(123);
        System.out.println(car1.equals(car2));
        System.out.println(car1.hashCode());
        System.out.println(car2.hashCode());
    }

    public static class Car {
        private String model;
        private int year;

        public void setModel(String model) {
            this.model = model;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public String getModel() {
            return model;
        }

        public int getYear() {
            return year;
        }

        @Override
        public String toString() {
            return "Car: " + model + " " + year;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if(obj == null && (getClass() != obj.getClass())) return false;
            Car car = (Car) obj;
            return year == car.getYear() && model.equals(car.model);
        }

        @Override
        public int hashCode(){
            int result = model != null ? model.hashCode() : 0;
            result = 31 * result + year;
            return result;
        }
    }
}
