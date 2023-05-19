public class Bird{
    private String name;
    private String genus;
    private String img;
    public Bird(String name, String genus){
        this.name = name;
        this.genus = genus;
    }
    public String getName(){
        return name;
    }
    public String getGenus(){
        return genus;
    }
    public boolean compareName(Bird object){
        if(object.getName().equals(this.getName())){
            return true;
        }
        return false;
    }
    
    public boolean compareGenus(Bird object){
        if(object.getGenus().equals(this.getGenus())){
            return true;
        }
        return false;
    }
}