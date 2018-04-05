package edu.gcccd.csis;

public class SequenceSearchImpl extends SequenceSearch {

    public SequenceSearchImpl(final String content, final String start, final String end) {
        super(content, start, end);
    }

    @Override
    public String[] getAllTaggedSequences() {
        // tagSeq will be returned string array, return empty array
        // if no start tags in the content string
        String[] tagSeq = new String[0];
        if ( !(content.contains(startTag)) ){
            return tagSeq;
        }
            // Find the first end tag
            int indexEnd = content.lastIndexOf(endTag);
            int indexStart = content.lastIndexOf(startTag, indexEnd-1);

            while (indexEnd !=-1 && indexStart !=-1){
                // If the start/end tag line up correct, add to array
                if ( content.lastIndexOf(endTag, indexEnd-1) <= indexStart) {
                    tagSeq = adds(tagSeq, content.substring(indexStart + startTag.length(), indexEnd));
                }
                // Go to next end tag
                indexEnd = content.lastIndexOf(endTag, indexEnd-1);
                // If the end tag and start tag are the same go down one more
                if (startTag.equals(endTag)) {
                    indexEnd = content.lastIndexOf(endTag, indexEnd-1);
                }
                indexStart = content.lastIndexOf(startTag, indexEnd-1);
            }
            return tagSeq;
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