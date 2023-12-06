package oodj.assignment;

import oodj.assignment.DataIO;
import javax.swing.DefaultListModel;

public class Food {
    private String foodID;
    private String foodName;
    private double price;
    private String description;
    private String categories;
    private String vendor;

    public Food(String foodID, String foodName, double price, String description, String categories,String vendor) {
        this.foodID = foodID;
        this.foodName = foodName;
        this.price = price;
        this.description = description;
        this.categories = categories;
        this.vendor = vendor;
        

        
        
    }


    public String toString() {
        return foodID + "," + foodName + "," + price + "," + description + "," + categories + ","+ vendor;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }
    public String getFoodID() {
        return foodID;
    }

    public void setFoodID(String foodID) {
        this.foodID = foodID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

public DefaultListModel<String> ListFoodID(){
        DefaultListModel<String> ListFoodID = new DefaultListModel<>();
        DataIO dataIO = new DataIO();

        for (Food food : DataIO.getAllFood()) {
           // if (order.getCustomer().getUsername().equals("john_doe")){
            ListFoodID.addElement(food.getFoodID());
            ListFoodID.addElement(food.getFoodName());

       // }    

        
    }
      return ListFoodID;
    }

}


