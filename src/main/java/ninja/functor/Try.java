package ninja.functor;

import java.util.function.Function;
import java.util.function.Supplier;

public class Try<T> {
  public final T value;

  public final Throwable error;

  private Try(T value) {
    this.value = value;
    this.error = null;
  }

  private Try(Throwable error) {
    this.value = null;
    this.error = error;
  }

  public boolean isError(){
    return error != null;
  }

  public <B> Try<B> map(Function<T, B> function){
    if(isError())
      return new Try(this.error);
    else
        return build(() -> function.apply(value));
  }

  public static <T> Try<T> build(Supplier<T> constructor) {
    try {
      return new Try(constructor.get());
    } catch (Throwable e){
      return new Try(e);
    }
  }
}
