import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    String[] isbns = {"1234567891","9876543211","1928374651"};
    float[] prices = {11.2f, 20.3f, 1f};
    BookFinder finder = new BookFinder();

    for (int i = 0; i < isbns.length; i++ ) {
      try {
        finder.insert(isbns[i], prices[i]);
        System.out.printf("insert %d done.\n", i);
      } catch(Exception e) {
        System.out.println("error: " + e.getMessage() );
      }
    }

    for (int i = 0; i < isbns.length; i++ ) {
      try {
        finder.update(isbns[i], prices[i]);
        System.out.printf("update %d done.\n", i);
      } catch(Exception e) {
        System.out.println("error: " + e.getMessage() );
      }
    }

    for (int i = 0; i < isbns.length; i++ ) {
      try {
        float price = finder.getPrice(isbns[i]);
        System.out.printf("getPrice %b\n", (price == prices[i]));
        System.out.printf("getPrice %d done.\n", i);
      } catch(Exception e) {
        System.out.println("error: " + e.getMessage() );
      }
    }

    for (int i = 0; i < isbns.length; i++ ) {
      try {
        finder.delete(isbns[i]);
        System.out.printf("delete %d done.\n", i);
      } catch(Exception e) {
        System.out.println("error: " + e.getMessage() );
      }
    }

    for (int i = 0; i < isbns.length; i++ ) {
      try {
        float price = finder.getPrice(isbns[i]);
        System.out.printf("find deleted fail");
      } catch(Exception e) {
        System.out.println("find deleted done");
      }
    }

  }

}

class BookFinder {

  Map<String, Float> bookPrices = new HashMap<String, Float>();

  public void insert(String isbn, float price) throws Exception {
    int sum = 0;
    for (int i = 0; i < 9; i++) {
      sum += isbn.charAt(i) - '0';
    }
    sum %= 11;
    if ( (sum == 10 && isbn.charAt(9) != 'X') || sum != isbn.charAt(9) - '0' ) {
      throw new Exception("Invalid isbn");
    }
    bookPrices.put(isbn, price);
  }

  public void update(String isbn, float price) throws Exception {
    if ( !bookPrices.containsKey(isbn) ) {
      throw new Exception("ISBN does not exist");
    }
    bookPrices.put(isbn, price);
  }

  public float getPrice(String isbn) throws Exception {
    if ( !bookPrices.containsKey(isbn) ) {
      throw new Exception("ISBN does not exist");
    }
    return bookPrices.get(isbn);
  }

  public void delete(String isbn) throws Exception {
    if ( !bookPrices.containsKey(isbn) ) {
      throw new Exception("ISBN does not exist");
    }
    bookPrices.remove(isbn);
  }

}
