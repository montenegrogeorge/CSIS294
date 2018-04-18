package edu.gcccd.csis;

import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class SelfAware implements Language {

        // Hash map used to map the keywords to their respective count
        private HashMap<String, Integer> KWords = new HashMap<String, Integer>(ReservedWords.length);

        // Constructor initializes the hashmap to reserved keywords to 0
        public SelfAware(String file) {
            for (String i: ReservedWords) {
                KWords.put(i, 0);
            }
        }

        /**
         * Counts the total number of occurrences of all Java keyword in the file.
         *
         * @param sourceFile {@link String} path to a java source file
         * @return {@link int} number of times java keyword occur in the source file.
         * @throws Exception not a java file or no file maybe ...
         */
        @Override
        public int occurrences(String sourceFile) throws Exception {
                try {
                        // Counter for all the keywords
                        int overallCount = 0;

                        // For each keyword
                        for (String i : ReservedWords) {
                            int count = 0;
                            BufferedReader br = new BufferedReader(new FileReader(sourceFile));
                            String line = "";

                            // Read through each line in the file
                            Pattern p = Pattern.compile(i);
                            while( (line = br.readLine()) != null){
                                Matcher m = p.matcher(line);
                                    // When you find the keyword, add one to the count
                                    while( m.find()) {
                                        overallCount++;
                                        count++;
                                    }
                            }
                            // Replace entry in hashmap with count
                            KWords.replace(i, count);
                            br.close();
                        }
                        return overallCount;

                }
                catch (Exception Exception){
                        System.err.println("You messed up!" + '\n' + "Not a java file or no file maybe ..." );
                        return 0;
                }
            }

        /**
         * Appends the provided file with the provided message
         *
         * @param sourceFile {@link String} path to a java source file
         * @param message    {@link String} message to be appended
         * @throws IOException things didn't go too well ...
         */
        @Override
        public void append(String sourceFile, String message) throws IOException {
                 try
                     {
                         BufferedWriter fw = new BufferedWriter(new FileWriter(sourceFile,true));
                         fw.write(message);
                         fw.newLine();
                         fw.close();
                     }
                 catch(IOException ioe)
                     {
                         System.err.println("IOException");
                     }
            }

        /**
         * Appends the txt file the data from the hashmap
         *
         * @param sourceFile {@link String} path to a java source file
         * @throws IOException things didn't go too well ...
         */
        public void appendMap(String sourceFile) throws IOException {
            try
            {
                BufferedWriter fw = new BufferedWriter(new FileWriter(sourceFile,true));

                // For every keyword with at least 1 instance, add it to the ext file
                for( String i: KWords.keySet()  ) {
                    if (KWords.get(i) > 0) {
                        fw.write(i + ": " + KWords.get(i));
                        fw.newLine();
                    }
                }
                fw.flush();
                fw.close();
            }
            catch(IOException ioe)
            {
                System.err.println("IOException");
            }
        }

    public static void main(String[] args) throws Exception {
//        final String code = System.getProperty("user.dir") + File.separator +
//                "src" + File.separator + "main" + File.separator + "java" + File.separator +
//                SelfAware.class.getName().replace(".", File.separator) + ".java";
                SelfAware sa = new SelfAware("test.txt");
                sa.append("Test.txt", "Keywords: " + sa.occurrences("test.txt") );
                sa.appendMap("Test.txt");
    }
}
