/* File: WordSalad.java - April 2018 */
package week09;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Skeleton implementation of the WordSalad class.
 *
 * @author Quinn Thorsnes, Kelson Sadlier, Yohan de Rose
 */
public class WordSalad implements Iterable<String> {

    /**
     * Allows WordSalad to know what WordNode comes first in the LinkedList.
     */
    private WordNode first;
    /**
     * Allows WordSalad to know what WordNode comes last in the LinkedList.
     */
    private WordNode last;
    
    /**
     * Constructs an empty WordSalad object.
     */
    public WordSalad() {
        this.first = null;
        this.last = null;
    }

    /**
     * Constructs WordSalad object from String List object.
     * @param words a list of strings
     */
    public WordSalad(java.util.List<String> words) {
        for (String word : words) {
            addLast(word);
        }
    }

    /** Adds a word to the front of the WordSalad.
     * @param word -string to add to WordSalad
     */
    public void add(String word) {
        if (this.first == null) {
            this.first = new WordNode(word, null);
            this.last = this.first;
            return;
        }
        WordNode newFirst = new WordNode(word, this.first);
        this.first = newFirst;
    }

    /** Adds a string word to the end of the WordSalad.
     * @param word -string to add to WordSalad
     */
    public void addLast(String word) {
        if (this.first == null) {
            add(word);
            return;
        }
        WordNode newLast = new WordNode(word, null);
        this.last.next = newLast;
        this.last = newLast;
    }
    
    /**
    * Defines WordNode objects that make up WordSalads.
    *
    */
    private class WordNode {
        /**
        * The string that this WordNode holds.
        */
        private String word;
        /**
        * A pointer to the next WordNode.
        */
        private WordNode next;

        /**
        * Constructs WordNode object and sets datafields.
        *
        * @param word -takes in string and next node
        * @param next -takes in next node in WordSalad object
        */
        private WordNode(String word, WordNode next) {
            this.word = word;
            this.next = next;
        }

    }

    /**
     * Implementation of Iterator class used to iterate across WordNodes.
     * @return java.util.Iterator<String> -returns String iterator object.
     */
    public java.util.Iterator<String> iterator() {
        return new java.util.Iterator<String>() {
            /**
             * Sets the current WordNode to the first node.
             */
            private WordNode current = first;

            /**
             * Checks if the current WordNode is empty.
             * @return boolean -returns false if null, true otherwise
             */
            public boolean hasNext() {
                return current != null;
            }
            
            /**
             * Returns the word held in the current node, then changes the
             * current node to point to the next node.
             *
             * @return result The word in the current node.
             */
            public String next() {
                String result = current.word;
                current = current.next;
                return result;
            }

            /**
             * Throws exception.
             */
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    /**
     * Shows a string representation of word blocks in WordSalad object.
     *
     * @return result String representation of block(s) of words.
     */
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        WordNode node = first;
        while (node != null) {
            result.append(node.word);
            result.append(node.next == null ? "" : ", ");
            node = node.next;
        }
        return result.toString() + "]";
    }


    // Method stubs to be completed for the assignment.
    // See the assignment description for specification of their behaviour.

   /**
    * Puts the first word in first block, 2nd in 2nd block, kth in kth etc.
    * wrap around blocks
    * like when dealing out cards
    *
    * @param k The number of blocks to distribute into
    * @return an array of WordSalads
    */
    public WordSalad[] distribute(int k) {
       
        WordSalad[] distribution = new WordSalad[k];
        int wordCount = 0;
        int currIndex;
        for(int i = 0; i < k; i++){
            distribution[i] = new WordSalad();
        }
        for(String word : this){
            currIndex = wordCount%k;
            distribution[currIndex].addLast(word);
            wordCount++;
        }
        return distribution;
    }

     /**
     * Chops Word Salad into almost equal pieces.
     *
     * Divides count of words into almost equal blocks and makes ArrayList 
     * This is then the lengths for corresponding WordSalad objects 
     * We fill each WordSalad block until its corresponding length is met
     *
     * @param k used to divide original length into almost equal lengths
     * @return an array of WordSalad objects chopped into k pieces
     */
    public WordSalad[] chop(int k) {
        //establish lengths of each WordSalad item
        ArrayList<Integer> lengths = new ArrayList<>();
        Iterator<String> pointer = this.iterator();
        int count = 0;

        while (pointer.hasNext()) {
            pointer.next();             //remember to move iterator along
            count++;
        }
        int x = count / k;      //x is the result of int division
        int r = count % k;      //r is the remainder

        for (int i = 0; i < k - r; i++) {
            lengths.add(x);        //add x (k-r) times
        }                        //while sum != words: add (count%sum)/r, r--

        int sum = 0;
        for (int i : lengths) {
            sum += i;
        }

        while (sum != count) {
            lengths.add(0, (count % sum) / r);
            r--; //might be r/2
            sum = 0;
            for (int i : lengths) {
                sum += i;
            }
        }

        //construct WordSalad array with reference to lengths
        WordSalad[] result = new WordSalad[k];
        for (int i = 0; i < result.length; i++) {
            result[i] = new WordSalad();
        }

        pointer = this.iterator();
        for (int i = 0; i < lengths.size(); i++) {
            int saladSize = 0;
            while (saladSize < lengths.get(i)) {
                result[i].addLast(pointer.next().toString());
                saladSize++;
            }
        }
        return result;
    }

   /**
    * Splits the WordSalad into an array of WordSalad objects by:
    * 1. Distributing into k chunks.
    * 2. Merging all of these chunks back together, save for the first.
    * 3. Repeating until there is no more WordSalad to Split.
    *
    * @param k - the number of chunks for the distribute calls
    * @return finalPass - an array of word salad objects
    */
    public WordSalad[] split(int k) {
        WordSalad[] currPass;
        WordSalad[] lastPass;
        WordSalad[] finalPass = new WordSalad[0];
        WordSalad saladLeft = this;
        int finalLength = 0;
        boolean splitting = true;
        while(splitting){
            lastPass = finalPass;
            currPass = saladLeft.distribute(k);
            saladLeft = merge(Arrays.copyOfRange(currPass, 1, currPass.length));
            if(saladLeft.first == null){
                splitting = false;
            }

            finalPass = new WordSalad[lastPass.length + 1];
            for(int i = 0; i < lastPass.length; i++){
                finalPass[i] = lastPass[i];
            }

            finalPass[lastPass.length] = currPass[0];
        }
        return finalPass;
    }

    /**
      * Merges blocks of words into a single block of words.
      *
      * Takes the n'th word from each block until all blocks are empty.
      * If a block is emptied it is then skipped in subsequent rounds.
      *
      * Opposite of distribute, so merging a distributed text will result in
      * the same original text.
      *
      * @param blocks An array of WordSalad blocks of words to be merged.
      * @return merged WordSalad object of merged blocks of words.
      */
    public static WordSalad merge(WordSalad[] blocks) {
        // The opposite of distribute
        WordSalad merged = new WordSalad();
        WordNode[] mergeNodes = new WordNode[blocks.length];
        for(int i = 0; i < blocks.length; i++){
            mergeNodes[i] = blocks[i].first;
        }
        boolean merging  = true;
        while(merging){
            for(int i = 0; i < mergeNodes.length; i++){
                if(mergeNodes[i] == null){
                    merging = false;
                }else{
                    merged.addLast(mergeNodes[i].word);
                    mergeNodes[i] = mergeNodes[i].next;
                }
            }
        }
        return merged;
    }

    /**
     * Joins blocks of words into a single block of words.
     *
     * Opposite of chop, so joining a chopped text results in the same original
     * text.
     *
     * @param blocks Array of WordSalad blocks to be joined.
     * @return joined Single WordSalad object containing joined blocks 
     */
    public static WordSalad join(WordSalad[] blocks) {
        // The opposite of Chop
        WordSalad joined = new WordSalad();
        for(WordSalad salad : blocks){
            for(String word : salad){
                joined.addLast(word);
            }
        }

        return joined;
    }

   /**
    * Takes an array of WordSalads that have been jumbled by way of split()
    * and unjumbles them.
    * It does this by performing the operations of split in reverse:
    * 1. Merge the last jumbled salad with the current Salad to be returned.
    * 2. Distribute the current Salad to be returned with k-1.
    * 3. Repeat until you run out of jumbled Salad.
    *
    * @param blocks - The array of jumbled WordSalad Objects.
    * @param k - The distribution parameter.
    * @return WordSalad - The final recombined WordSalad.
    */
    public static WordSalad recombine(WordSalad[] blocks, int k) {
        WordSalad[] curToMerge = new WordSalad[1];
        WordSalad[] lastDist;
        WordSalad recombination = new WordSalad();
        int dists = 0;
        boolean recombining = true;
        while(recombining){
            if(recombination.first != null){
                lastDist = recombination.distribute(k-1);
                curToMerge = new WordSalad[lastDist.length + 1];
                for(int i = 0; i < (curToMerge.length - 1); i++){
                    curToMerge[i+1] = lastDist[i];
                }
            }
            dists++;
            if(dists >= blocks.length){
                recombining = false;
            }
            curToMerge[0] = blocks[blocks.length-dists];
            recombination = merge(curToMerge);
        }

        return recombination;
    }

}
