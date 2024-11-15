import java.util.List;
 public class Inventory <T extends Supplies> {

	/*     STEP 3 
	*        
	*      Create this bounded type generic class with everything you 
	*      would expect in a class (instance variable, constructor,
	*      get/set methods) and then make two additional generic methods:
	*
	*      Go to Transfer.java for STEP 4
	*/

	//Generic instance var
	private T t;
	
	public Inventory(){
		
	}

	public Inventory(T t) {
		setAll(t);
	}

	public void setObject(T t) {
		this.t = t;
	}

	public T getObject() {
		return t;
	}

	public void setAll(T t){
		setObject(t);
	}


	/*     STEP 5
	*
	*      Create a method called searchByName() that takes two parameters:
	*          - The input List<T> of generic type T
	*          - A String "name" that we will use to search in the input List
	*
	*      This method should iterate through all the objects in our List
	*      and use the getName() method of Supplies to compare against the
	*      input String "name", use the indexOf() method to return the 
	*      index. If no match is found, return -1. 
	*/
	public int searchByName(List<T> list, String name) {
		name = name.trim(); //from demo, removes whitespace from name
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getName().equalsIgnoreCase(name)) {
				return i;
			}
		}
		/* from demo: enhanced for would have worked as well:

		for (T element : list) {
			if (element.getName().equalsIgnoreCase(name)) {
				return list.indexOf(element);
			}
		}

		*/
		System.out.println("No such item found"); //From demo, good to have
		return -1;
	}


	/*     STEP 7:
	* 
	*      Create a method called checkQty() that takes three parameters:
	*           - The input List<T>
	*           - The String name of the object we want to check
	*           - The int desiredQuantity that we want to check/change for 
	*             the item
	*           
	*      Use our method searchByName() to be able to get the index of 
	*      the object we are looking for and use the index to access the 
	*      object within the List<T>. If the object is not found, or if
	*      our searchByName() method returns -1, return null.
	*
	*      Once our object is found, check the quantity via the .get() 
	*      method from the List class and by using the .getQuantity()
	*      from the Supplies class. Compare the value with the parameter 
	*      desiredQuantity, if they match then return the object as-is
	*      and notify user that the quantity matches. If it does not 
	*      match the quantity in the list, then update using .setQuantity
	*      and return the object with the new quantity.
	*/

	public T ceckQty(List<T> list, String name, int desiredQuantity){
		int index = searchByName(list, name);
		if (index ==-1){
			System.out.println(name + " not found."); //demo: maybe throw an exception here.
			return null;
		}
		T found = list.get(index);
		if (found.getQuantity() == desiredQuantity) {
			System.out.println("Quantity of " + found.getName() + " already " + desiredQuantity + ".");
		} else {
			found.setQuantity(desiredQuantity);
		}

		return found;
	}

}