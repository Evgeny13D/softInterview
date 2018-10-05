package A402.email;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Test string on containing keywords from config file
 * Used to filter out absolutely incorrect email addresses
 */
public class TrashEmailFilter implements Serializable {
    private List<String> trackEmailKeywords;

    /**
     * Create list of keywords
     * @param trashEmailKeywordsPath - path within classpath
     * @throws IOException
     */
    public TrashEmailFilter(String trashEmailKeywordsPath) throws IOException {
        makeTrashEmailFilter(trashEmailKeywordsPath);
    }

    private void makeTrashEmailFilter(String trashEmailKeywordsPath) throws IOException {
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream(trashEmailKeywordsPath)) {
            if (is == null) {
                trackEmailKeywords = Collections.emptyList();
            } else {
                trackEmailKeywords = new ArrayList<>();
                Scanner scanner = new Scanner(is);
                while (scanner.hasNextLine()) {
                    trackEmailKeywords.add(scanner.nextLine().trim());
                }
            }
        }
    }

    public boolean isEmailTrash(String email){
        for (String trackEmailKeyword : trackEmailKeywords) {
            if (email.contains(trackEmailKeyword)) {
                return true;
            }
        }
        return false;
    }
}