
/**
 * <h1> Pet Class </h1>
 * The Pet Class implements an application that
 * makes an object pet with three given parameters:
 * name, breed and age.
 *
 * @author Dragi Kamov
 * @since 01.03.2018
 */
public class Pet{

    private String name;
    private String breed;
    private int age;

    /**
     * This is the constructor for the class
     * @param name This is the parameter used for the name of the pet
     * @param breed This is the parameter used for the breed of the pet
     * @param age This is the parameter used for the age of the pet
     */
    Pet(String name, String breed, int age){
        this.name=name;
        this.breed=breed;
        this.age=age;
    }

    /**
     * Getter method for this.name
     * @return Getting the name
     */
    public String getName(){
        return this.name;
    }

    /**
     * Getter method for this.breed
     * @return Getting the breed
     */
    public String getBreed() {
        return this.breed;
    }

    /**
     * Getter method for this.age
     * @return Getting the age
     */
    public int getAge(){
        return this.age;
    }

    /**
     * Setter method for this.name
     * @param name Used for setting name
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     * Setter method for this.breed
     * @param breed Used for setting breed
     */
    public void setBreed(String breed){
        this.breed=breed;
    }

    /**
     * Setter method for this.age
     * @param age Used for setting age
     */
    public void setAge(int age){
        this.age=age;
    }

    /**
     * Overridden method which checks if two pets are equal
     * @param obj The pet object that we are comparing with
     * @return true/false
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Pet){
            Pet pet = (Pet) obj;
            if(pet.name.equals(this.name) && pet.breed.equals(this.breed) && pet.age==this.age){
                return true;
            }
            else {
                return false;
            }
        }
        return super.equals(obj);
    }

    /**
     * Overridden method which is used for printing
     * @return Used for printing the name, breed and age of the dog
     */
    @Override
    public String toString(){
        return "Name: " + String.valueOf(this.name) + "\nBreed: "+ String.valueOf(this.breed) + "\nAge: " + String.valueOf(this.age);
    }
}
