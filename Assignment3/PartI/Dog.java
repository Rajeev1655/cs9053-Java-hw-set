
public class Dog {
    private int age;
    private String owner;
    private String breed;

    public Dog(){};

    public Dog(int age, String owner, String breed) {
        this.age = age;
        this.owner = owner;
        this.breed = breed;
    }

    public static boolean hasSameOwner(Dog dog1, Dog dog2) {
        return dog1.getOwner().equals(dog2.getOwner());
    }

    public static double avgAge(Dog[] dogs) {
        double total = 0;
        for (Dog dog:dogs){
            // assume every item in array is not null
            total += (double)dog.getAge(); 
        }
        return total / (double) dogs.length;
    }

    @Override
    public String toString(){
        return this.breed + ": Owner: " + this.owner + ", Age: " + age;
    }

    public String getOwner() {
        return this.owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int newAge) {
        this.age = newAge;
    }

    public String getBreed(){
        return this.breed;
    }

    public void setBreed(String Breed) {
        this.breed = Breed;
    }
    
    public static void main(String[] args) {
        Dog[] dogs = new Dog[5];
        dogs[0] = new Dog(8, "Dexter Morgan", "Corgi");
        dogs[1] = new Dog(7, "Dexter Morgan", "Dorgi");
        dogs[2] = new Dog(6, "Loren Morgan", "Eorgi");
        dogs[3] = new Dog(5, "Kevin Morgan", "Forgi");
        dogs[4] = new Dog(4, "Garry Morgan", "Gorgi");

        System.out.println(dogs[0].toString()); //Corgi: Owner: Dexter Morgan, Age: 8
        System.out.println(avgAge(dogs)); // 6
        System.out.println(hasSameOwner(dogs[0], dogs[1])); // true
        System.out.println(hasSameOwner(dogs[1], dogs[2])); // false
    }
}