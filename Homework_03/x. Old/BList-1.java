package edu.gcccd.csis;

public class BList {
    private String[] sa;

    public BList(String[] sa) {
        this.sa = sa;
    }

    // Return size of the array
    public int size() {
        return sa.length;
    }

    // Add a string to the array
    public String add(String s) {
        String[] tmp = new String[sa.length + 1];
        for (int i = 0; i < sa.length; i++) {
            tmp[i] = sa[i];
        }
        tmp[sa.length] = s;
        sa = tmp;
        return s;
    }

    // Remove a string from the array
    public String remove(String s) {
        String[] tmp = new String[sa.length - 1];
        boolean found = false;
        int i = 0;
        for (String x : sa) {
            if (x.equals(s)) {
                found = true;
            } else {
                if (i < tmp.length) {
                    tmp[i++] = x;
                }
            }
        }
        if (found) {
            sa = tmp;
        }
        return found ? s : null;
    }

    // Function that returns the longest
    // string in the string array.
    public String getLongest()
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

            // Return longest string
            return longStr;
        }
        else
            {return null;}
    }

    // Function that reverse the order
    // of the string array
    public void reverse()
    {
        // Temporary holder for the string while reversing array
        String temp = "";

        // If array is even length
        if (sa!= null)
        {
            for (int i = 0; i < sa.length/2; i++)
            {
                temp = sa[i];
                sa[i] = sa[sa.length-1-i];
                sa[sa.length-1-i] = temp;
            }
        }
        return;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < sa.length; i++) {
            s+=sa[i];
            if (i<sa.length-1) {
                s+=", ";
            }
        }
        return s;
    }

}
