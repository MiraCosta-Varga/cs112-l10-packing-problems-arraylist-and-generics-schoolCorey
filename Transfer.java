import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Transfer {

  // **** Sets up our arrays, do not edit  ****
  Setup setup = new Setup();
  Food[] foodArray = setup.getFoodArray();
  Parts[] partsArray = setup.getPartsArray();
  Supplies[] suppliesArray = setup.getSuppliesArray();
  // **** Sets up our arrays, do not edit ****


  /*  STEP 1
  *   
  *   To start, lets create three new ArrayLists with types <Food>, 
  *   <Parts>, and <Supplies>; name them foodList, partsList, and 
  *   suppliesList. The names must be exact, or the print method at
  *   the end of this class will not work. The default capacity of 
  *   10 will suffice for this lab. Once the lists have been created,
  *   go to the very end of this class and erase the comments to allow
  *   the method body of printLists() to execute when we run the program. 
  *
  *   Once this is completed, lets edit our default constructor for
  *   Transfer and make it so when we create a Transfer object it
  *   will transfer all our data from our three arrays: foodArray,
  *   partsArray, and suppliesArray to our lists: foodList, partsList,
  *   and suppliesList.
  *
  */

  ArrayList<Food> foodList = new ArrayList<Food>();
  ArrayList<Parts> partsList = new ArrayList<Parts>();
  ArrayList<Supplies> suppliesList = new ArrayList<Supplies>();

  public Transfer() {

    /*  
    *   Transfer all the data from the array's to our new ArrayList's here
    *    -  foodArray data goes into foodList
    *    -  partsArray data goes into partsList
    *    -  suppliesArray data goes into suppliesList
    *
    *   You can use a for-loop to transfer all our items, or import
    *   java.util.Arrays and use the Arrays.asList() method
    */

    foodList = new ArrayList<Food>(Arrays.asList(foodArray));
    partsList = new ArrayList<Parts>(Arrays.asList(partsArray));
    suppliesList = new ArrayList<Supplies>(Arrays.asList(suppliesArray));

  }


  public void addItems(int listNumber) {

    /*    STEP 2
    *
    *     In this method, listNumber is how we identify which 
    *     list we are looking in to add items. 
    *     If listNumber == 1, we are looking in our foodList
    *     If listNumber == 2, we are looking in our partsList
    *     If listNumber == 3, we are looking in our suppliesList
    *
    *     The user input is collected for you and the object 
    *     has been created. All you have to do is insert it 
    *     into the correct list and print to the console that
    *     the item has been successfully added.
    *
    *     View our lists to make sure our new item is there!
    */   

    
    Scanner keyboard = new Scanner(System.in);

    if(listNumber == 1) {// Add to Food list

      System.out.print("Food name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();
      keyboard.nextLine();
      System.out.print("Perishable? (T/F): ");
      boolean perishable = false;
      String perish = keyboard.nextLine();
      perish = perish.substring(0,1);
      if(perish.equalsIgnoreCase("T")) {
        perishable = true;
      }

      Food newFoodItem = new Food(name, qty, perishable);


      /* Use the newFoodItem here and enter it into our foodList.
      *  Print to make sure it was successful
      */
      foodList.add(newFoodItem);
      System.out.println("Food: " + newFoodItem + "added!");

    } else if(listNumber == 2) { // Add to Parts list

      System.out.print("Part name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();
      System.out.print("Part Number (5-digit) : ");
      int pn = keyboard.nextInt();

      Parts newPartsItem = new Parts(name, qty, pn);
      System.out.println("Part: " + newPartsItem + "added!");

      /* Use the newPartsItem here and enter it into our partsList.
      *  Print to make sure it was successful
      */

      partsList.add(newPartsItem);

    } else { // Add to Supplies list

      System.out.print("Supplies name: ");
      String name = keyboard.nextLine();
      System.out.print("Quantity: ");
      int qty = keyboard.nextInt();

      Supplies newSuppliesItem = new Supplies(name, qty);

      /* Use the newSuppliesItem here and enter it into our suppliesList.
      *  Print to make sure it was successful
      */
      suppliesList.add(newSuppliesItem);
      System.out.println("Supply Item: " + newSuppliesItem + "added!");

    }
  }

  /*  Once you have finished the above method and tested it by 
  *   running the program, go to our Inventory class and follow
  *   the instructions for STEP 3.
  *
  *   Come back here once you are finished with STEP 3 and instance
  *   three generic Inventory objects for the three different types
  *   we are working with. Remember to instance the class and declare
  *   the type (Food/Parts/Supplies) in the angled <> brackets. Name
  *   these Inventory objects foodInventory, partsInventory, and 
  *   suppliesInventory.
  */

  /* STEP 4 -- Create our three Inventory objects here for each type
  *            Food/Parts/Supplies
  */
  Inventory<Food> foodInventory = new Inventory<Food>();
  Inventory<Parts> partsInventory = new Inventory<Parts>();
  Inventory<Supplies> suppliesInventory = new Inventory<Supplies>();

  public void removeItems(int listNumber) {

    /*    STEP 6
    *
    *     Use our generic objects from above to access the generic 
    *     methods searchByName() and List method remove()
    */

    // These below gather the String name for our searchByName() method
    Scanner keyboard = new Scanner(System.in);
    System.out.print("\nName of Item to be Removed: ");
    String name = keyboard.nextLine(); 

    if(listNumber == 1) { // Food

      /* This is where you will use our generic method searchByName()
      *  and List method remove() for our foodList
      */ 

      int index = foodInventory.searchByName(foodList, name);
      if (index > -1){
        foodList.remove(index);
        System.out.println("Removed " + name + " (was at index: " +index + ")."); 
      }



    } else if(listNumber == 2) { // Parts

      /* This is where you will use our generic method searchByName()
      *  and List method remove() for our partsList
      */  
      int index = partsInventory.searchByName(partsList, name);
      if (index > -1){
        partsList.remove(index);
        System.out.println("Removed " + name + " (was at index: " +index + ")."); 
      }



    } else if(listNumber == 3) { // Supplies
      
      /* This is where you will use our generic method searchByName()
      *  and List method remove() for our suppliesList
      */

      int index = suppliesInventory.searchByName(suppliesList, name);
      if (index > -1){
        suppliesList.remove(index);
        System.out.println("Removed " + name + " (was at index: " +index + ")."); 
      }
      

    }
  }



  /*  Once you have finished the above method, go to our Inventory
  *   class and follow the instructions for STEP 8.
  *
  *   Come back here once you are finished with STEP 8 and complete
  *   the editQuantity() method below.
  */
  

  public void editQuantity(int listNumber) {
      
    /*    STEP 9
    *
    *     Use our generic objects to access the generic method 
    *     checkQty() we wrote in Inventory in STEP 8. Make sure 
    *     we edit the correct list with awareness of the listNumber.    
    */

    // These below just gather input from user to use in checkQty()
    Scanner keyboard = new Scanner(System.in);
    System.out.println("\nName of Item to Edit: ");
    String name = keyboard.nextLine();
    System.out.println("Desired Quantity: ");
    int desiredQty = keyboard.nextInt();

    if(listNumber == 1) { // Food

      /* This is where you will use our generic method checkQty()
      *  for our foodList.
      */
      Food foodTemp = foodInventory.ceckQty(foodList, name, desiredQty); 
      //these ifs should maybe be try/catch for that error we could have checkQty throw
      if (foodTemp != null){
        System.out.println("Updated Quantity of "+ foodTemp.getName() + " to " + desiredQty + ".");
      }
      


    } else if(listNumber == 2) { // Parts

      /* This is where you will use our generic method checkQty()
      *  for our partsList.
      */
      Parts partsTemp = partsInventory.ceckQty(partsList, name, desiredQty);
      if (partsTemp != null) {
        System.out.println("Updated Quantity of "+ partsTemp.getName() + " to " + desiredQty + ".");
      }
      


    } else if(listNumber == 3) { // Supplies

      /* This is where you will use our generic method checkQty()
      *  for our suppliesList.
      */
      Supplies supplyTemp = suppliesInventory.ceckQty(suppliesList, name, desiredQty);
      if (supplyTemp != null) {
        System.out.println("Updated Quantity of "+ supplyTemp.getName() + " to " + desiredQty + ".");
      }
      

    }
  }













  // Will print our lists in a table once we have created them
  public void printLists() {

    
    
    


    if(foodList.isEmpty() && partsList.isEmpty() && suppliesList.isEmpty()) {
      System.out.printf("\n%19s", "No objects found in lists.");
    } 
      
    if(!foodList.isEmpty()) {
      System.out.printf("\n\n%s", "FOOD");
      System.out.print("\n----------------------------------------------");
      System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "Perishable", "Qty");
      System.out.print("----------------------------------------------");

      for(int i = 0; i < foodList.size(); i++) {
        Food tempFood = foodList.get(i);
        System.out.printf("\n%-25.25s %-15.15s %-10.10s", tempFood.getName(), tempFood.getPerishable(), "" + tempFood.getQuantity());
        }   
    }
      
    if(!partsList.isEmpty()) {
      System.out.printf("\n\n%s", "PARTS");
      System.out.print("\n----------------------------------------------");
      System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "PN", "Qty");
      System.out.print("----------------------------------------------");

      for(int i = 0; i < partsList.size(); i++) {
        Parts tempPart = partsList.get(i);
        System.out.printf("\n%-25.25s %-15.15s %-10.10s", tempPart.getName(), "" + tempPart.getPartNumber(), "" + tempPart.getQuantity());
        }
    }

    if(!suppliesList.isEmpty()) {
      System.out.printf("\n\n%s", "SUPPLIES");
      System.out.print("\n----------------------------------------------");
      System.out.printf("\n%-25.25s %-15.15s %-10.10s%n", "Name", "Qty", "");
      System.out.print("----------------------------------------------");

      for(int i = 0; i < suppliesList.size(); i++) {
        Supplies tempSupplies = suppliesList.get(i);
        System.out.printf("\n%-25.25s %-15.15s %-10.10s", tempSupplies.getName(), "" + tempSupplies.getQuantity(), "");
      }
    }
  }
}