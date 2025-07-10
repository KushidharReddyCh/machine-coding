import java.util.List;
import java.util.ArrayList;

//1. Eager Initilization
// pitfall: if the object is not used, it will still be created

class DBConnectionEager {
    private static DBConnectionEager conObject = new DBConnectionEager();

    private DBConnectionEager() {}

    public static DBConnectionEager getInstance() {
        return conObject;
    }
}

//2. Lazy Initilization
// pitfall: not thread safe
// todo: look in to serialization & deserialization
// todo: look in to reflection
// todo: look in to class loader
class DBConnectionLazy {
    private static DBConnectionLazy conObject;

    private DBConnectionLazy(){}

    public static DBConnectionLazy getInstance() {
        if(conObject == null) {
            conObject = new DBConnectionLazy();
        }
        return conObject;
    }
}   

//3. Synchronized Method
// pitfall: we are taking lock on the whole method
// if we are calling this method from multiple threads, it will be a bottleneck
class DBConnectionSynchronize{
    private static DBConnectionSynchronize conObject;

    private DBConnectionSynchronize(){}

    synchronized public static DBConnectionSynchronize getInstance() {
        if(conObject == null) {
            conObject = new DBConnectionSynchronize();
        }
        return conObject;
    }
}

//4. Double Locking
// pitfall: memory issue
/*
 * in cpu there are multiple cores
 * each core has its own cache (L1 cache)
 * there is a mismatch between the value in main memory and the value in cache
 * to fix this issue we use volatile keyword
 * volatile keyword ensures that the value is read from main memory and not from cache
 */
class DBConnectionDoubleLocking{
    private static volatile DBConnectionDoubleLocking conObject;

    private DBConnectionDoubleLocking(){}

    public static DBConnectionDoubleLocking getInstance(){
        if(conObject == null){ // first check
            synchronized(DBConnectionDoubleLocking.class){
                if(conObject == null){ // second check
                    conObject = new DBConnectionDoubleLocking();
                }
            }
        }
        return conObject;
    }
}
// the above method is thread safe but it is not efficient due to volatile and synchronized it is slow

// 5. Bill Pugh Solution
class DBConnectionBillPugh{
    private DBConnectionBillPugh(){}

    // static inner class is loaded only when it is used
    // this is the best way to create a singleton class
    private static class DBConnectionBillPughHelper{
        private static final DBConnectionBillPugh INSTANCE_OBJECT = new DBConnectionBillPugh();
    }

    public static DBConnectionBillPugh getInstance(){
        return DBConnectionBillPughHelper.INSTANCE_OBJECT;
    }
}

// 6. Enum Singleton
enum DBConnectionEnum{
    INSTANCE;
}
// enum is a singleton by default, one instance is created per JVM


/* IMMUTABLE CLASS:
1. We can not change the value of an object once it is created 
2. Declare class as final so that it can not be extended. Why?
    This breaks the principle of immutability and Liskov Substitution Principle.
    "Subtypes must be substitutable for their base types without altering the correctness of the program."
3. All class members should be private. So that direct access can be avoided.
4. All are final variables. 
5. And class members are initialized only once using constructor.
6. There should not be any setter methods, which is generally use to change the value.
7. Just getter methods. And returns Copy of the member variable.
 Example: String, Wrapper clases etc..
*/

class ImmutableClass{

    private final String name;
    // not even you can edit the values or add new values in the list
    private final List<Integer> arrayList;

    public ImmutableClass(String name, List<Integer> arrayList){
        this.name = name;
        this.arrayList = arrayList;
    }

    public String getName(){
        return this.name;
    }

    public List<Integer> getArrayList(){
        // this is required, because making list final
        // means you can noe not point it to a new list
        // but you can add new values to the list
        // so thats why we send the copy of the list
        return new ArrayList<>(this.arrayList);
    }

}