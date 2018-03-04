package edu.gcccd.csis;

public class BList {
    private String[] sa;
    private String longestString = "";
    private boolean reversed = false;

    // Constructor
    public BList(String[] sa) {
        this.sa = sa;
        setLongest();
    }

    // Return size of the array
    public int size() {
        return sa.length;
    }

    // Add a string to the array
    public String add(String s) {

        // Create temp array that is one larger than
        // the current array
        String[] tmp = new String[sa.length + 1];

        // If not reversed add the current array
        // to the temp array, and add new string to the end
        if (!reversed) {
            for (int i = 0; i < sa.length; i++) {
                tmp[i] = sa[i];
            }
            tmp[sa.length] = s;

            // Assign tmp array to the sa array
            sa = tmp;
        }
        else
        {
            // Add the new string at the beginning
            // which is the end of a reversed list
            tmp[0] = s;

            // Add the rest of the elements
            for (int i = 1; i < sa.length+1; i++) {
                tmp[i] = sa[i-1];
            }

            // Assign tmp array to the sa array
            sa = tmp;

        }
        // If new string is longer than current longest
        // set the longestString to new longest
        if (longestString.length() < s.length())
            {longestString = s;}

        return s;
    }

    // Remove a string from the array
    public String remove(String s) {

        // Create temp array to hold smaller array
        String[] tmp = new String[sa.length - 1];

        // Create a boolean to see if string is found
        //
        boolean found = false;
        int i = 0;

        // Check every string in sa against string s
        for (String x : sa) {
            if (x.equals(s)) {
                found = true; // If string found in array makes boolean true
            } else {
                if (i < tmp.length) {
                    tmp[i++] = x; // If string not found add to temp array
                }
            }
        }

        // If string found in array
        if (found) {
            sa = tmp;  // Make the temp array the new sa array

            // If the removed string is the longest string
            // set a new longest
            if (s.equals(longestString))
                {setLongest();}
        }

        return found ? s : null;
    }

    // Function that returns the longest
    // string in the string array.
    public void setLongest()
    {
        // Check to see if array exists
        if(sa!=null)
        {
            // longest holds length of longest string in the array
            // longStr holds the longest string
            int longest = 0;
            String longStr = "";

            // Iterate through the array
            for (int i = 0; i <= sa.length-1;i++)
            {
                // If the length of the string is longer than
                // the current longest
                if(longest < sa[i].length())
                    {
                        longest = sa[i].length();
                        longStr = sa[i];
                    }
            }

            // Set new longest string
            longestString = longStr;
            return;
        }
        else
            {return;}
    }

    // Return the longest string in the array
    public String getLongest()
        {return longestString;}


    // Function that sets a boolean that decides
    // if toString prints in reverse
    public void reverse()
    {
        if (reversed == true)
            {reversed = false;}
        else
            {reversed = true;}
    }

    @Override
    public String toString()
    {
        String s = "";

        // If the list is not reversed
        // then print it in order
        if (reversed == false) {
            for (int i = 0; i < sa.length; i++) {
                s += sa[i];
                if (i < sa.length - 1) {
                    s += ", ";
                }
            }
        }
        // If the list is reversed
        // Print it from the end
        else {
            for (int i = 0; i < sa.length; i++) {
                s += sa[sa.length-1-i];
                if (i < sa.length - 1) {
                    s += ", ";
                }
            }

        }
        return s;
    }

}
