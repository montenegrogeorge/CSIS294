package edu.gcccd.csis;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
    public String[] getAllTaggedSequences() {
        // tagSeq will be returned string array
        String[] tagSeq = new String[0];

        // If there is no startTag, return empty array
        if ( !(content.contains(startTag)) ){
            return tagSeq;
        }

        // If the start tag and the end tag are the same
        if(startTag.equals(endTag)){
            int indexStart = content.indexOf(startTag);
            int indexEnd = content.indexOf(endTag, indexStart+startTag.length());


            while(indexStart!=-1 && indexEnd!=-1) {

                tagSeq = adds(tagSeq, content.substring(indexStart + startTag.length(), indexEnd) );

                indexStart = content.indexOf(startTag, indexEnd+startTag.length());
                indexEnd = content.indexOf(endTag, indexStart+endTag.length());
            }
            return tagSeq;
        }
        else { // If the tags are not the same
            int indexEnd = content.lastIndexOf(endTag);
            int indexStart = content.lastIndexOf(startTag, indexEnd);
            while (indexEnd !=-1 && indexStart != -1){
                if ( content.lastIndexOf(endTag, indexEnd-endTag.length()) > indexStart) {
                    indexEnd = content.lastIndexOf(endTag, indexEnd-endTag.length());
                    indexStart = content.lastIndexOf(startTag, indexEnd);
                }
                else {
                    tagSeq = adds(tagSeq, content.substring(indexStart + startTag.length(), indexEnd));
                    indexEnd = content.lastIndexOf(endTag, indexEnd-endTag.length());
                    indexStart = content.lastIndexOf(startTag, indexEnd);
                }
            }
            // reverse the string array, above algorithm finds tagged
            // sequences in reverse
            for(int i = 0; i < tagSeq.length / 2; i++)
            {
                String temp = tagSeq[i];
                tagSeq[i] = tagSeq[tagSeq.length - i - 1];
                tagSeq[tagSeq.length - i - 1] = temp;
            }
            return tagSeq;
        }
    }

    @Override
    public String getLongestTaggedSequence() {
        String[] tagSeq = getAllTaggedSequences();

        // If there are no tagged sequences return null
        if (tagSeq.length <= 0) {
            return null;
        }
        // Find largest tagged sequence
        String maxLen = "";
        for (String i : tagSeq){
            if (i.length() >= maxLen.length()){
                maxLen = i;
            }
        }
        return maxLen;
    }

    @Override
    public String displayStringArray() {
        String[] tagSeq = getAllTaggedSequences();
        StringBuilder ret = new StringBuilder("");
        String tmp = "";
        for (String i : tagSeq){
            tmp = i + " : " + i.length() + "\n";
            ret.append(tmp);
        }
        return ret.toString();
    }

    @Override
    public String toString() {
        String retString = content;
        // If the start and end tag are the same, just remove the start tags once
        if (startTag.equals(endTag)) {
            retString= retString.replaceAll(startTag, "");
        }
        else { // If tags are different, remove both
            retString = retString.replaceAll(startTag, "");
            retString = retString.replaceAll(endTag, "");
        }
        return retString;
    }
}