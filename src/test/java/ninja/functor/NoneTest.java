package ninja.functor;

import ninja.functor.util.UserUtil;
import org.junit.jupiter.api.Test;

public class NoneTest {
  @Test
  public void test() {
    UserUtil.getSuppliers().forEach(databaseRead -> {
      try {
        final User user = databaseRead.get();
        final String email = user.getEmail();
        System.out.println(email);
      } catch (Throwable e) {
        e.printStackTrace();
      }
    });
  }
}
