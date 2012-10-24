package rcb.listsetmaplab;

import java.util.*;

/**
 *
 * @author Bob
 */
public class RCBListSetMapLab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
//1. Using the Employee class from GenericsAndSets.common, create the necessary 
//equals(), hashCode(), toString() and compareTo() methods.
        //done in class
        
        System.out.println("");
        System.out.println("#2");
//2. Nexst, create and initalize four Employee objects, but this time make sure
//at least two have the same social security number. Now add them to a HashSet.
//Then loop through the HashSet and verify that only two employees can be printed
//out because the duplicate (last item that matches) has been removed. Now pass 
//the Set to a List constructor and verify that your list contains the transformed Set.
         Employee e1 = new Employee("Doe", "John", "333-33-3333");
        Employee e2 = new Employee("Smith", "Sally", "111-11-1111");
        Employee e3 = new Employee("Evans", "Bob", "333-33-3333");
        Employee e4 = new Employee("Mallay", "Fred", "222-22-2222");
        
        Set<Employee> EmpSet = new HashSet<>();
        
        EmpSet.add(e1);
        EmpSet.add(e2);
        EmpSet.add(e3);
        EmpSet.add(e4);
        
        for (Employee e : EmpSet){
            System.out.println(e);
        }
        
        List<Employee> Employees = new ArrayList<>(EmpSet);
        
        Collections.sort(Employees, new EmployeeByLastName());
        
        for (Employee e: Employees){
            System.out.println(e.getLastName());
        }
        
        System.out.println("");
        System.out.println("#3");
//3. Store the same four Employee objects in a HashMap. What key will you use? How
//will you retrieve individual items? Use put(key, value) to add items; use get(key)
//to retrieve items. Demonstrate a solution. How will you loop through the keys or
//values? Demonstrate this too.
        Map empMap = new HashMap();
        empMap.put(e1.getSsn(), e1);
        empMap.put(e2.getSsn(), e2);
        empMap.put(e3.getSsn(), e3);
        empMap.put(e4.getSsn(), e4);
     
        
        System.out.println(empMap.get("333-33-3333"));
        System.out.println("");
     
        for(Object key : empMap.keySet()) {
            Employee found = (Employee)empMap.get(key);
            System.out.println(found.toString());
        }
        System.out.println("");
        System.out.println("#4");
//4. Store the same four Employee objects in a TreeMap. Demonstrate that sorting 
//works. Did you remember to override compareTo() from the Comparable interfaces? 
//Now try using a Comparator from the GenericsAndMaps project (remember you’ll need a utility class).
        Map empTree = new TreeMap();
        empTree.put(e1.getSsn(), e1);
        empTree.put(e2.getSsn(), e2);
        empTree.put(e3.getSsn(), e3);
        empTree.put(e4.getSsn(), e4);
        
      
         
            
        for(Object key : empTree.keySet()) {
            Employee found = (Employee)empTree.get(key);
            System.out.println(found.toString());
        }
       
        
        System.out.println("");
        System.out.println("#5");
//5. Store the same four Employee objects in a TreeSet. Demonstrate that sorting 
//works AND that duplicates are removed by looping through the set using an iterator.
        Set empTreeSet = new TreeSet();
        empTreeSet.add(e1);
        empTreeSet.add(e2);
        empTreeSet.add(e3);
        empTreeSet.add(e4);
        
        Iterator<Employee> empIt = empTreeSet.iterator();
        
        while (empIt.hasNext()){
            Employee e = empIt.next();
            System.out.println(e.toString());
        }
        
        
        
    }
}
