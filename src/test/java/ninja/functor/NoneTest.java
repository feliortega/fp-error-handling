package ninja.functor;

import org.junit.jupiter.api.Test;

public class NoneTest extends BaseTest {
  @Test
  public void test() {
    for (int i = 0; i < USER_SUPPLIER.length; i++) {
      final User user = USER_SUPPLIER[i].get();
      final String email = user.getEmail();
      System.out.println("email: " + email);
    }
  }
}
