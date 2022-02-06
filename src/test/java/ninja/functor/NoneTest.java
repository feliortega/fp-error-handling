package ninja.functor;

import ninja.functor.util.UnsafeUtil;
import org.junit.jupiter.api.Test;

public class NoneTest {
  @Test
  public void test() {
    UnsafeUtil.getUserSupplierStream()
        .forEach(userSupplier -> {
          try {
            final User user = userSupplier.get();
            final String email = user.getEmail();
            System.out.println("email: " + email);
          } catch (Throwable e) {
            System.out.println("error: " + e);
          }
        });
  }
}
