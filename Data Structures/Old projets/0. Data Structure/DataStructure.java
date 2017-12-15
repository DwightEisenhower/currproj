/**
 * Complete each of the indicated methods. Test each one thoroughly. In the event that a method
 * cannot run as expected (perhaps because an index was referenced that is null or does not exist),
 * return null. (You can print an error too if you like). Be sure to make sure
 * each method runs as efficiently as possible.
 * 
 * Assignment by Mr. Weinfeld, completed by D. Mirin
 */
public class DataStructure
{
    private Integer[] data; /*# Initially has 5 null values */
    private int size; /*# represents the index of the smallest null element in data. UPDATE THIS. */
    public DataStructure()
    {
        data = new Integer[5];
        size = 0;
    }
    
    /*#
     * Place toAdd in the smallest index null space. If the array is full, double it's size to create 
     * more space.
     */
    public void add(Integer toAdd) {//works
        if(size < data.length) {
            data[size] = toAdd;
            size++;
        } else {
            resize();
            add(toAdd);
        }//O(1) - faster time is taken
    }
    
    /*#
     * Insert toAdd in the indicated index. Shift all other elements to make space.
     */
    public void add(int index, Integer toAdd) {//works
        if(index > size) {
            System.out.println("Try a smaller index. "+size+" seems good.");
            return;
        } else {
            Integer[] temp = new Integer[data.length+1];
            for(int i = 0; i < temp.length; i++) {
                if(i < index)
                    temp[i] = data[i];
                if(i == index)
                    temp[i] = toAdd;
                if(i > index)
                    temp[i] = data[i-1];
            }
            data = temp;
        }
    }
    
    /*#
     * Replace the Integer at index with toReplace. Return the removed Integer.
     */
    public Integer set(int index, Integer toReplace) {//works
        Integer temp = data[index];
        data[index] = toReplace;
        return temp;
    }
    
    /*#
     * Remove the Integer at index from data and return it. Shift all to close the gap created by 
     * the removal.Do not change the size of data.
     */
    public Integer remove(int index) {
        if(data[index] == null) {
            System.out.println("invalid index");
            return null;
        }
        Integer[] temp = new Integer[data.length];
        Integer ret = null;
        for(int i = 0; i < size; i++)
            if(i < index)
                temp[i] = data[i];
            else if(i > index)
                temp[i-1] = data[i];
            else
                ret = data[i];
        return ret;
    }
    
    /*#
     * Return the Integer at index.
     */
    public Integer get(int index) {//works
        return data[index];
    }
    
    /*#
     * Return the number of non null elements in data.
     */
    public int size() {//works
        return size-1;
    }
    
    /*#
     * Return true if value is contained in data, false otherwise.
     */
    public boolean contains(Integer value) {//works
        for(int i = 0; i < size/*data[i] != null is better*/; i++)
            if(data[i] != null && data[i].intValue() == value.intValue())
                return true;
        return false;
    }
    
    /*#
     * Double the size of data and copy all the elements over.
     */
    public void resize() {//works
        Integer[] temp = new Integer[data.length*2];
        for(int i = 0; i < data.length; i++)
            temp[i] = data[i];
        data = temp;
    }
    
    /*#
     * toString, no gets or sets or equals needed.
     * toString should display all the elements in data on one line, no nulls.
     */
    
    public String toString() {//works
        String s = "";
        for(Integer i : data)
            if(i != null)
                s += i+", ";
        return s;
    }
}